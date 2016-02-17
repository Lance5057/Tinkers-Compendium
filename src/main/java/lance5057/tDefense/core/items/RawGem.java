package lance5057.tDefense.core.items;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import net.minecraft.item.Item;

public class RawGem extends Item
{
	public RawGem(String name)
	{
		this.setCreativeTab(TinkersDefense.tabName);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("raw" + name);
		this.setTextureName(Reference.MOD_ID + ":raw" + name);
	}
}
