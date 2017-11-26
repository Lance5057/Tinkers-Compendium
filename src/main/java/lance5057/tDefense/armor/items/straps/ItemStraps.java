package lance5057.tDefense.armor.items.straps;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.CoreBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemStraps extends ItemArmor
{
	public ItemStraps()
	{
		super(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD);
		// ItemStacks that store an NBT Tag Compound are limited to stack size of 1
		setMaxStackSize(1);
		// you'll want to set a creative tab as well, so you can get your item
		setCreativeTab(CoreBase.tab);
	}

	// Without this method, your inventory will NOT work!!!
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1; // return any value greater than zero
	}
   
    	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		if (!worldIn.isRemote)
		{
			// If player not sneaking, open the inventory gui
			if (!playerIn.isSneaking()) {
				playerIn.openGui(TinkersDefense.instance, TinkersDefense.GUI_STRAPS_INV, worldIn, 0, 0, 0);
			}
		}
		
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
}