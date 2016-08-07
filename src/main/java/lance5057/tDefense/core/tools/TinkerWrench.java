package lance5057.tDefense.core.tools;

import ic2.api.tile.IWrenchable;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import buildcraft.api.tools.IToolWrench;
import cofh.api.block.IDismantleable;
import cofh.api.item.IToolHammer;
import cpw.mods.fml.common.Optional;

@Optional.InterfaceList({@Optional.Interface(modid = "buildcraft", iface = "buildcraft.api.tools.IToolWrench"), @Optional.Interface(modid = "cofh", iface = "cofh.api.item.IToolHammer")})
public class TinkerWrench extends ToolCore implements IToolWrench, IToolHammer
{
	int	induceDamage	= 0;

	public TinkerWrench()
	{
		super(0);
		setUnlocalizedName("tinkerwrench");
	}

	@Override
	public Item getHeadItem()
	{
		return TinkerTools.handGuard;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkerTools.toolRod;
	}

	@Override
	public Item getAccessoryItem()
	{
		return TinkerTools.binding;
	}

	@Override
	public int durabilityTypeAccessory()
	{
		return 2;
	}

	@Override
	public float getRepairCost()
	{
		return 1.0f;
	}

	@Override
	public float getDurabilityModifier()
	{
		return 0.1f;
	}

	@Override
	public float getDamageModifier()
	{
		return 0.4f;
	}

	@Override
	public int getPartAmount()
	{
		return 3;
	}

	@Override
	public String getIconSuffix(int partType)
	{
		switch(partType)
		{
			case 0:
				return "_wrench_head";
			case 1:
				return "_wrench_head_broken";
			case 2:
				return "_wrench_handle";
			case 3:
				return "_wrench_binding";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_wrench_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "wrench";
	}

	@Override
	@Optional.Method(modid = "buildcraft")
	public boolean canWrench(EntityPlayer player, int x, int y, int z)
	{
		final NBTTagCompound tags = player.inventory.getCurrentItem().getTagCompound().getCompoundTag("InfiTool");

		if(!tags.getBoolean("Broken"))
		{
			return true;
		}
		return false;
	}

	@Override
	@Optional.Method(modid = "buildcraft")
	public void wrenchUsed(EntityPlayer player, int x, int y, int z)
	{

		player.swingItem();
		AbilityHelper.damageTool(player.inventory.getCurrentItem(), 1, player, false);

	}

	@Override
	@Optional.Method(modid = "cofh")
	public boolean isUsable(ItemStack item, EntityLivingBase user, int x, int y, int z)
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Optional.Method(modid = "cofh")
	public void toolUsed(ItemStack item, EntityLivingBase user, int x, int y, int z)
	{
		// TODO Auto-generated method stub

	}

	//	//Skin Changer
	//	@Override
	//	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
	//	{
	//		if(entity.worldObj.isRemote)
	//		{
	//			return false;
	//		}
	//		if(entity instanceof EntityAnimal)
	//		{
	//			EntityAnimal target = (EntityAnimal) entity;
	//			player.openGui(TinkersDefense.instance, TinkersDefense.GUI_ANVIL_INV, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	//			return true;
	//		}
	//		return false;
	//	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		final Block block = world.getBlock(x, y, z);
		final TileEntity te = world.getTileEntity(x, y, z);
		final int metaData = world.getBlockMetadata(x, y, z);

		if(te != null && te instanceof IWrenchable)
		{
			final IWrenchable wte = (IWrenchable) te;

			if(!player.isSneaking())
			{
				//				for(int step = 1; step < 6; step++)
				//				{
				//side = (wte.getFacing() + 6 - step) % 6;
				if(!world.isRemote)
				{
					//side = side % -3;//(wte.getFacing() + step) % 6;
					//
					if(wte.wrenchCanSetFacing(player, side))
					{
						wte.setFacing((short) side);
						return true;
					}
				}
				//				}
			}
			else
			{
				if(!world.isRemote)
				{
					final List<ItemStack> drops = block.getDrops(world, x, y, z, metaData, 0);
					if(world.rand.nextFloat() <= wte.getWrenchDropRate())
					{
						final ItemStack drop = wte.getWrenchDrop(player);
						if(drop != null)
						{
							if(drops.isEmpty())
							{
								drops.add(drop);
							}
							else
							{
								drops.set(0, drop);
							}
						}
					}
					for(final ItemStack itemStack : drops)
					{
						final EntityItem ei = new EntityItem(world, x, y, z,
								itemStack.copy());
						world.spawnEntityInWorld(ei);
					}
					world.removeTileEntity(x, y, z);
					world.setBlockToAir(x, y, z);
					return true;
				}
			}
			return false;
		}
		if(world.blockExists(x, y, z))
		{
			if(block != null)
			{
				if(player.isSneaking() && block instanceof IDismantleable && ((IDismantleable) block).canDismantle(player, world, x, y, z))
				{
					if(!world.isRemote)
					{
						((IDismantleable) block).dismantleBlock(player, world, x, y, z, false);
						player.swingItem();
						return true;
					}
				}

			}
		}
		return false;
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"wrench"};
	}

}
