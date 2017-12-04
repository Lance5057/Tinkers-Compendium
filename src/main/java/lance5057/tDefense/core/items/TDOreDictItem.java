package lance5057.tDefense.core.items;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.CoreBase;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TDOreDictItem extends Item {
	String prefix;

	public List<String> mats = new ArrayList<String>();
	public List<Integer> colors = new ArrayList<Integer>();

	public TDOreDictItem(String pre, List<String> materials_master, List<Integer> materials_colors) {
		setUnlocalizedName(pre + "_meta");
		setRegistryName(pre + "_meta");
		prefix = pre;
		mats = materials_master;
		colors = materials_colors;
		this.setCreativeTab(CoreBase.tab);
		this.hasSubtypes = true;
	}

	public boolean isOreDict() {
		return true;
	}

	public String getOreDictPrefix() {
		return prefix;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < mats.size(); i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}

	public ItemStack getItembyName(String name) {
		for (int i = 0; i < mats.size(); i++) {
			if (mats.get(i).equals(name)) {
				return new ItemStack(this, 1, i);
			}
		}
		return null;
	}
	
	public int getIDbyName(String name) {
		for (int i = 0; i < mats.size(); i++) {
			if (mats.get(i).equals(name)) {
				return i;
			}
		}
		return 0;
	}

	public int getColor(ItemStack i) {
		return colors.get(i.getMetadata());
	}

	public static class ColorHandler implements IItemColor {
		@Override
		public int getColorFromItemstack(ItemStack stack, int tintIndex) {
			if (tintIndex == 0) {
				if (stack.getItem() instanceof TDOreDictItem) {
					return ((TDOreDictItem) stack.getItem()).getColor(stack);
				}
			}
			return 0xFFFFFF;
		}
	}
}
