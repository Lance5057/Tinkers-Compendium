package lance5057.tDefense.core.items;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GuideBook extends Item
{
	public GuideBook()
	{
		setCreativeTab(TinkersDefense.tabName);
		setMaxStackSize(1);
		setUnlocalizedName("guidebook");
		setTextureName(Reference.MOD_ID + ":tdbook");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.openGui(TinkersDefense.instance, TinkersDefense.GUI_GUIDEBOOK, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
		return stack;
	}
}
