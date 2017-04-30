package lance5057.tDefense.util;

import lance5057.tDefense.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.mantle.client.CreativeTab;

public abstract class ItemsBase {
	public ItemsBase()
	{
		
	}
	
	public abstract void preInit(FMLPreInitializationEvent e);
	
	public abstract void init(FMLInitializationEvent e);
	
	public abstract void postInit(FMLPostInitializationEvent e);
	
	protected Item register(String name, int size, CreativeTabs tabName) 
	{
		Item item = new Item().setCreativeTab(tabName).setMaxStackSize(size).setUnlocalizedName(name).setRegistryName(Reference.MOD_ID, name);
		GameRegistry.register(item);
		return item;
	}
	
	protected MetaItem registerMeta(String name, String[] names,int size, CreativeTabs tabName) 
	{
		Item item = new MetaItem(names).setCreativeTab(tabName).setMaxStackSize(size).setUnlocalizedName(name).setRegistryName(Reference.MOD_ID, name);

		GameRegistry.register(item);
		return (MetaItem) item;
	}
}
