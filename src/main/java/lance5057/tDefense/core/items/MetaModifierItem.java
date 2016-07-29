package lance5057.tDefense.core.items;

import java.util.List;

import lance5057.tDefense.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MetaModifierItem extends Item
{
	public IIcon[]	icons;
	public String[]	names;
	int				metaAmount;

	public MetaModifierItem(String unlocalizedName, int metaAmount, String[] names)
	{
		super();
		setHasSubtypes(true);
		setUnlocalizedName(unlocalizedName);
		setCreativeTab(CreativeTabs.tabMaterials);
		this.metaAmount = metaAmount;
		this.names = names;
		icons = new IIcon[metaAmount];
	}

	@Override
	public void registerIcons(IIconRegister reg)
	{
		for(int i = 0; i < metaAmount; i++)
		{
			icons[i] = reg.registerIcon(Reference.MOD_ID + ":item_" + names[i]);
		}
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		if(meta > metaAmount - 1)
		{
			meta = 0;
		}

		return icons[meta];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < metaAmount; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.getUnlocalizedName() + "_" + names[stack.getItemDamage()];
	}
}
