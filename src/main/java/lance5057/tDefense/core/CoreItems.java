package lance5057.tDefense.core;

import lance5057.tDefense.Reference;
import lance5057.tDefense.proxy.ClientProxy;
import lance5057.tDefense.util.ItemsBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CoreItems extends ItemsBase
{
	
	
	public static Item							item_aeonsteelIngot;
	public static Item							item_queensgoldIngot;
	public static Item							item_dogbeariumIngot;
	
	public CoreItems()
	{
		
	}
	
	public void preInit()
	{
		this.setTab("TDefense_Items", new ItemStack(Items.SHIELD));
	}
	
	public void init() 
	{
		item_aeonsteelIngot = register("aeonsteelingot", 64);
		item_queensgoldIngot = register("queensgoldingot", 64);
		item_dogbeariumIngot = register("dogbeariumingot", 64);

		this.tabName.setDisplayIcon(new ItemStack(item_aeonsteelIngot));
	}

}
