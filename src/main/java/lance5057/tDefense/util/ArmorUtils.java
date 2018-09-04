package lance5057.tDefense.util;

import lance5057.tDefense.core.tools.armor.cloth.TinkersHood;
import lance5057.tDefense.core.tools.armor.cloth.TinkersRobe;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShawl;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShoes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArmorUtils {
	public static boolean isCloth(ItemStack item) {
		Item i = item.getItem();
		if (i instanceof TinkersHood || i instanceof TinkersShawl || i instanceof TinkersRobe
				|| i instanceof TinkersShoes) {
			return true;
		}
		return false;
	}
}
