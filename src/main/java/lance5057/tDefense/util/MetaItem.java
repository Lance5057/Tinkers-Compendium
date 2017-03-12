package lance5057.tDefense.util;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MetaItem extends Item 
{
	String[] items;
	public MetaItem(String[] items) {
		super();
		this.setHasSubtypes(true);
		setMaxDamage(0);
		this.items = items;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return super.getUnlocalizedName() + "." + items[stack.getItemDamage()];
	}
	
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
		for(int i = 0; i < items.length; i++)
		{
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}
}
