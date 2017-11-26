package lance5057.tDefense.util;

import java.util.ArrayList;

import lance5057.tDefense.Reference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public abstract class ItemsBase {
	protected static ArrayList<Item> itemList = new ArrayList<Item>(); 
	public ItemsBase()
	{
		
	}
	
	public abstract void preInit(FMLPreInitializationEvent e);
	
	public abstract void init(FMLInitializationEvent e);
	
	public abstract void postInit(FMLPostInitializationEvent e);
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry registry = event.getRegistry();
		
		registry.registerAll((Item[]) itemList.toArray());
	}
	
	protected Item register(String name, int size, CreativeTabs tabName) 
	{
		Item item = new Item().setCreativeTab(tabName).setMaxStackSize(size).setUnlocalizedName(name).setRegistryName(Reference.MOD_ID, name);
		itemList.add(item);
		return item;
	}
	
	protected MetaItem registerMeta(String name, String[] names,int size, CreativeTabs tabName) 
	{
		Item item = new MetaItem(names).setCreativeTab(tabName).setMaxStackSize(size).setUnlocalizedName(name).setRegistryName(Reference.MOD_ID, name);

		itemList.add(item);
		return (MetaItem) item;
	}
}
