package lance5057.tDefense.core.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import tconstruct.library.tools.ToolCore;

public class EntityHookshotHook extends EntityThrowable
{
	public int				maxChain;

	public static final int	DATA_PLAYER		= 22;
	public static final int	DATA_TARGET		= 23;
	public static final int	DATA_ARRIVED	= 24;
	public static final int	DATA_HOOK		= 25;
	public static final int	HIT_POS_X		= 26, HIT_POS_Y = 27,
			HIT_POS_Z = 28;
	public static final int	DATA_ITEM		= 29;

	boolean					playerTouching	= false;

	public EntityHookshotHook(World world)
	{
		super(world);
	}

	public EntityHookshotHook(World world, EntityLivingBase entity)
	{
		super(world, entity);
	}

	public EntityHookshotHook(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		setSize(0.25F, 0.25F);
		dataWatcher.addObject(DATA_PLAYER, "");
		dataWatcher.addObject(DATA_TARGET, -1);
		dataWatcher.addObject(DATA_ARRIVED, (byte) 0);
		dataWatcher.addObject(DATA_HOOK, "");
		dataWatcher.addObject(HIT_POS_X, 0.0F);
		dataWatcher.addObject(HIT_POS_Y, 0.0F);
		dataWatcher.addObject(HIT_POS_Z, 0.0F);
		dataWatcher.addObject(DATA_ITEM, new ItemStack(Blocks.air, 1, 0));
	}

	@Override
	protected void onImpact(MovingObjectPosition Op)
	{
		motionX = motionY = motionZ = 0.0D;
		if(Op.typeOfHit == MovingObjectType.BLOCK)
		{
			final Block block = worldObj.getBlock(Op.blockX, Op.blockY, Op.blockZ);

			if(!block.getMaterial().blocksMovement())
				return;
			if(ticksExisted < getChainLength())
			{
				dataWatcher.updateObject(DATA_ARRIVED, (byte) 1);
				posX = Op.blockX + 0.5D;
				posY = Op.blockY + 0.5D;
				posZ = Op.blockZ + 0.5D;
			}
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if(ticksExisted > 0)// getChainLength())
		{
			if(worldObj.isRemote && getThrower() instanceof EntityPlayer && ticksExisted % 4 == 0 && dataWatcher.getWatchableObjectByte(DATA_ARRIVED) == (byte) 1)
			{
				((EntityPlayer) getThrower()).playSound("tinkersdefense:hookshotChain", 1.0F, 1.0F);
			}
		}
		else
		{
			setDead();
		}
	}

	@Override
	public EntityLivingBase getThrower()
	{
		final String name = dataWatcher.getWatchableObjectString(DATA_PLAYER);
		if(name == "")
			return null;
		return worldObj.getPlayerEntityByName(name);
	}

	@Override
	protected float func_70182_d()
	{
		return 1.25F;
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0.0F;
	}

	public void setHook(String type)
	{
		dataWatcher.updateObject(DATA_HOOK, type);
	}

	public String getHook()
	{
		return dataWatcher.getWatchableObjectString(DATA_HOOK);
	}

	public void setHookshot(ItemStack hookshot)
	{
		dataWatcher.updateObject(DATA_ITEM, hookshot);
	}

	public ItemStack getHookshot()
	{
		return dataWatcher.getWatchableObjectItemStack(DATA_ITEM);
	}

	public String getPlayer()
	{
		return dataWatcher.getWatchableObjectString(DATA_PLAYER);
	}

	public void setPlayer(EntityPlayer player)
	{
		dataWatcher.updateObject(DATA_PLAYER, player.getDisplayName());
	}

	public int getChainLength()
	{
		final ItemStack tool = dataWatcher.getWatchableObjectItemStack(DATA_ITEM);
		if(tool != null && tool.getItem() instanceof ToolCore)
		{
			final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

			return tags.getInteger("ChainLength");
		}
		return 0;
	}
}
