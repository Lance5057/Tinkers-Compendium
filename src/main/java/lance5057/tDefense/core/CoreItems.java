package lance5057.tDefense.core;

import lance5057.tDefense.Reference;
import lance5057.tDefense.armor.items.straps.ItemStraps;
import lance5057.tDefense.util.ItemsBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CoreItems extends ItemsBase
{
	public static Item item_straps;
	
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
		
		item_straps = new ItemStraps().setMaxStackSize(1).setUnlocalizedName("straps").setRegistryName(Reference.MOD_ID, "straps");
		itemList.add(item_straps);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

}
