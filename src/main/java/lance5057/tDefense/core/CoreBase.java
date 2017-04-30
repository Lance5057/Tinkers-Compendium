package lance5057.tDefense.core;

import lance5057.tDefense.util.BlocksBase;
import lance5057.tDefense.util.ItemsBase;
import lance5057.tDefense.util.ModuleBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.client.CreativeTab;

public class CoreBase extends ModuleBase
{
	public static CreativeTabs tab;
	
	public ItemsBase items;
	public BlocksBase blocks;
	
	public CoreBase()
	{
		items = new CoreItems();
		blocks = new CoreBlocks();
	}

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		tab = new CreativeTab("TDefense_Core", new ItemStack(Items.SHIELD));
		
		// TODO Auto-generated method stub
		items.preInit(e);
		blocks.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		items.init(e);
		blocks.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		items.postInit(e);
		blocks.postInit(e);
	}
}
