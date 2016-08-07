package lance5057.tDefense.core.tools;

import java.util.List;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.entity.EntityHookshotHook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tconstruct.library.crafting.ToolBuilder;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;

public class TinkersHookshot extends ToolCore
{

	public TinkersHookshot()
	{
		super(0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDefaultFolder()
	{
		return "hookshot";
	}

	@Override
	public String getEffectSuffix()
	{
		return "_hookshot_effect";
	}

	@Override
	public int getPartAmount()
	{
		return 3;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partArmorplate;
	}

	@Override
	public Item getAccessoryItem()
	{
		return TinkersDefense.partChainmaille;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkerTools.toughRod;
	}

	@Override
	public String getIconSuffix(int partType)
	{
		switch(partType)
		{
			case 0:
				return "_hookshot_chamber";
			case 1:
				return "_hookshot_chamber_broken";
			case 2:
				return "_hookshot_handle";
			case 3:
				return "_hookshot_chain";
			default:
				return "";
		}
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"hookshot"};
	}

	@Override
	public void buildTool(int id, String name, List list)
	{
		final Item accessory = getAccessoryItem();
		final ItemStack accessoryStack = accessory != null ? new ItemStack(
				getAccessoryItem(), 1, id) : null;
				final Item extra = getExtraItem();
				final ItemStack extraStack = extra != null ? new ItemStack(extra, 1, id) : null;
				final ItemStack tool = ToolBuilder.instance.buildTool(new ItemStack(
						getHeadItem(), 1, id), new ItemStack(getHandleItem(), 1, id), accessoryStack, extraStack, name);
				if(tool != null)
				{
					tool.getTagCompound().getCompoundTag("InfiTool").setBoolean("Built", true);
					tool.getTagCompound().getCompoundTag("InfiTool").setInteger("ChainLength", 10);
					list.add(tool);
				}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		player.setItemInUse(stack, getMaxItemUseDuration(stack));
		final EntityHookshotHook hook = new EntityHookshotHook(player.worldObj,
				player);
		hook.setPlayer(player);
		hook.setHook("test");
		hook.setHookshot(stack);
		if(!player.worldObj.isRemote)
		{
			player.worldObj.spawnEntityInWorld(hook);
		}
		return stack;
	}
}
