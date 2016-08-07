package lance5057.tDefense.core.items;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import net.minecraft.item.Item;

public class RawGem extends Item
{
	public RawGem(String name)
	{
		setCreativeTab(TinkersDefense.tabName);
		setMaxStackSize(64);
		setUnlocalizedName("raw" + name);
		setTextureName(Reference.MOD_ID + ":raw" + name);
	}
}
