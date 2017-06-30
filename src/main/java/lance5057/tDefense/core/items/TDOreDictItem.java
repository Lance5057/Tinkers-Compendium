package lance5057.tDefense.core.items;

import lance5057.tDefense.core.CoreBase;
import net.minecraft.item.Item;

public class TDOreDictItem extends Item {
	String prefix;

	public TDOreDictItem(String pre, String name) {
		setUnlocalizedName(pre + "_" + name);
		setRegistryName(pre + "_" + name);
		prefix = pre;
		this.setCreativeTab(CoreBase.tab);
	}

	public boolean isOreDict() {
		return true;
	}

	public String getOreDictPrefix() {
		return prefix;
	}
}
