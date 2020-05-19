package lance5057.tDefense;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.items.ItemCompendiumBook;
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
	
	public static Item book;
	
	public static List<Item> items = new ArrayList<Item>();
	

	public void preInit(FMLPreInitializationEvent e) {
		book = registerItem("book", new ItemCompendiumBook(), TinkersCompendium.tab );
		TinkersCompendium.proxy.registerItemRenderer(book, 0, "book");
	}

	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub

	}

	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub

	}
	
	public static Item registerItem(String name, CreativeTabs tab) {
		Item item = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
		item.setCreativeTab(tab);
		items.add(item);
		return item;
	}
	
	public static Item registerItem(String name, Item item, CreativeTabs tab) {
		item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
		item.setCreativeTab(tab);
		items.add(item);
		return item;
	}

	public static Item registerItemBlock(String name, Block b, CreativeTabs tab) {
		Item item = new ItemBlock(b).setRegistryName(new ResourceLocation(Reference.MOD_ID, name))
				.setUnlocalizedName(name);
		item.setCreativeTab(tab);
		items.add(item);
		return item;
	}
	
	public static Item registerItemBlock(String name, Item item, Block b, CreativeTabs tab) {
		item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name))
				.setUnlocalizedName(name);
		item.setCreativeTab(tab);
		items.add(item);
		return item;
	}
	
	public void registerItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry registry = event.getRegistry();

		for (Item i : items) {
			registry.register(i);
		}
	}

}
