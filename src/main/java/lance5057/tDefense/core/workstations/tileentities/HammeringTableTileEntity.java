package lance5057.tDefense.core.workstations.tileentities;

import lance5057.tDefense.core.workstations.registries.hammeringtable.HammeringTableRecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class HammeringTableTileEntity extends GuilessManualWorkstationTileEntity {

	public HammeringTableTileEntity(int inputs, String tag, int timerMax, String in, String out) {
		super(inputs, tag, timerMax, in, out);
	}

	@Override
	public void createItem() {
		ItemStack itemstack = this.items[0];
		ItemStack itemstack1 = HammeringTableRecipeRegistry.instance().getHammeringResult(itemstack);
		ItemStack itemstack2 = this.output;

		if (itemstack2 == null || itemstack2.isEmpty()) {
			this.output = itemstack1.copy();
		} else if (itemstack2.getItem() == itemstack1.getItem()) {
			itemstack2.grow(itemstack1.getCount());
		}

		itemstack.shrink(1);
	}
}
