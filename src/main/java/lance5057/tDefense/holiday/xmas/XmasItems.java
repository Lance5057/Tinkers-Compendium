package lance5057.tDefense.holiday.xmas;

import lance5057.tDefense.util.Color16Util;
import lance5057.tDefense.util.ItemsBase;
import lance5057.tDefense.util.MetaItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.client.CreativeTab;

public class XmasItems extends ItemsBase {
	CreativeTab xmas;
	
	

	public static MetaItem item_gumdrop;

	public void preInit(FMLPreInitializationEvent e) {
		xmas = new CreativeTab("TDefense_Xmas", new ItemStack(Items.SHIELD));
	}

	public void init(FMLInitializationEvent e) {
		
		
		//item_gumdrop = registerMeta("gumdrop", Color16Util.colors, 64, xmas);

		//xmas.setDisplayIcon(new ItemStack(item_redmintcane));
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}
}
