package lance5057.tDefense.util;

import lance5057.tDefense.Reference;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.mantle.client.CreativeTab;

public abstract class ItemsBase {
	public CreativeTab					tabName;
	
	public ItemsBase()
	{
		
	}
	
	public abstract void preInit();
	
	public abstract void init();
	
	protected void setTab(String tab, ItemStack stack)
	{
		tabName = new CreativeTab(tab, stack);
	}
	
	protected Item register(String name, int size) 
	{
		Item item = new Item().setCreativeTab(tabName).setMaxStackSize(size).setUnlocalizedName(name).setRegistryName(Reference.MOD_ID, name);
		GameRegistry.register(item);
		return item;
	}
	
	protected MetaItem registerMeta(String name, String[] names,int size) 
	{
		Item item = new MetaItem(names).setCreativeTab(tabName).setMaxStackSize(size).setUnlocalizedName(name).setRegistryName(Reference.MOD_ID, name);

		GameRegistry.register(item);
		return (MetaItem) item;
	}
}
