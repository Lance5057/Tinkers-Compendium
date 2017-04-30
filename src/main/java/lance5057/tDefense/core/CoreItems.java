package lance5057.tDefense.core;

import lance5057.tDefense.util.ItemsBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CoreItems extends ItemsBase
{
	
	
	public static Item							item_aeonsteelIngot;
	public static Item							item_queensgoldIngot;
	public static Item							item_dogbeariumIngot;
	
	public CoreItems()
	{
		
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
	}
	
	@Override
	public void init(FMLInitializationEvent e) 
	{
		item_aeonsteelIngot = register("aeonsteelingot", 64, CoreBase.tab);
		item_queensgoldIngot = register("queensgoldingot", 64, CoreBase.tab);
		item_dogbeariumIngot = register("dogbeariumingot", 64, CoreBase.tab);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

}
