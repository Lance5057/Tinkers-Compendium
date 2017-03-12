package lance5057.tDefense.holiday.xmas;

import lance5057.tDefense.util.Color16Util;
import lance5057.tDefense.util.ItemsBase;
import lance5057.tDefense.util.MetaItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class XmasItems extends ItemsBase {
	public static Item item_redmintcane;
	public static Item item_greenmintcane;
	public static Item item_redmintIngot;
	public static Item item_greenmintIngot;
	public static Item item_gingerbread;

	public static MetaItem item_gumdrop;

	public void preInit() {
		setTab("TDefense_Xmas", new ItemStack(Items.SHIELD));
	}

	public void init() {
		item_redmintcane = register("redmintcane", 64);
		item_redmintIngot = register("redmintIngot", 64);
		item_greenmintcane = register("greenmintcane", 64);
		item_greenmintIngot = register("greenmintIngot", 64);
		item_gingerbread = register("gingerbread", 64);
		
		item_gumdrop = registerMeta("gumdrop", Color16Util.colors, 64);

		this.tabName.setDisplayIcon(new ItemStack(item_redmintcane));
	}
}
