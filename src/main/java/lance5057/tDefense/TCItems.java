package lance5057.tDefense;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TCItems {
	
	public static List<Item> items = new ArrayList<Item>();


	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub

	}

	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void registerItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry registry = event.getRegistry();

		for (Item i : items) {
			registry.register(i);
		}

	}

}
