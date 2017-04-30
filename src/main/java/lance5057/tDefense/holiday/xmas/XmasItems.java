package lance5057.tDefense.holiday.xmas;

import lance5057.tDefense.util.Color16Util;
import lance5057.tDefense.util.ItemsBase;
import lance5057.tDefense.util.MetaItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.client.CreativeTab;

public class XmasItems extends ItemsBase {
	CreativeTab xmas;
	
	public static Item item_redmintcane;
	public static Item item_greenmintcane;
	public static Item item_redmintIngot;
	public static Item item_greenmintIngot;
	public static Item item_gingerbread;

	public static MetaItem item_gumdrop;

	public void preInit(FMLPreInitializationEvent e) {
		xmas = new CreativeTab("TDefense_Xmas", new ItemStack(Items.SHIELD));
	}

	public void init(FMLInitializationEvent e) {
		item_redmintcane = register("redmintcane", 64, xmas);
		item_redmintIngot = register("redmintIngot", 64, xmas);
		item_greenmintcane = register("greenmintcane", 64, xmas);
		item_greenmintIngot = register("greenmintIngot", 64, xmas);
		item_gingerbread = register("gingerbread", 64, xmas);
		
		item_gumdrop = registerMeta("gumdrop", Color16Util.colors, 64, xmas);

		xmas.setDisplayIcon(new ItemStack(item_redmintcane));
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}
}
