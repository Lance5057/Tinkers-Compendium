package lance5057.tDefense.core.items;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.CoreBase;
import lance5057.tDefense.util.TDMatHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TDOreDictItem extends Item {
	String prefix;
	
	public List<String> mats = new ArrayList<String>();

	public TDOreDictItem(String pre, List<String> materials_master) {
		setUnlocalizedName(pre + "_meta");
		setRegistryName(pre + "_meta");
		prefix = pre;
		mats = materials_master;
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
		for (int i = 0; i < mats.size(); i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}
	
	public ItemStack getItembyName(String name)
	{
		for(int i = 0; i < mats.size(); i++)
		{
			if(mats.get(i).equals(name))
			{
				return new ItemStack(this, 1, i);
			}
		}
		return null;
	}
}
