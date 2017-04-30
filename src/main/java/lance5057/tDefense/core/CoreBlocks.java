package lance5057.tDefense.core;

import lance5057.tDefense.core.blocks.crestMount.CrestMount;
import lance5057.tDefense.util.BlocksBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CoreBlocks extends BlocksBase
{

	public static Block aeonsteelBlock;
	public static Block dogbeariumBlock;
	public static Block queensgoldBlock;
	public static Block greencandyBlock;
	public static Block redcandyBlock;
	
	public static ItemBlock aeonsteelItemBlock;
	public static ItemBlock dogbeariumItemBlock;
	public static ItemBlock queensgoldItemBlock;
	public static ItemBlock greencandyItemBlock;
	public static ItemBlock redcandyItemBlock;
	
	public static CrestMount crestMount;
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		aeonsteelBlock = register("aeonsteelblock", CoreBase.tab, 5);
		dogbeariumBlock = register("dogbeariumblock", CoreBase.tab, 5);
		queensgoldBlock = register("queensgoldblock", CoreBase.tab, 5);
		greencandyBlock = register("greencandyblock", CoreBase.tab, 5);
		redcandyBlock = register("redcandyblock", CoreBase.tab, 5);

		crestMount = new CrestMount();
		crestMount.setCreativeTab(CoreBase.tab);
		
		aeonsteelItemBlock = register("aeonsteelblock", 64, CoreBase.tab, aeonsteelBlock);
		dogbeariumItemBlock = register("dogbeariumblock", 64, CoreBase.tab, dogbeariumBlock);
		queensgoldItemBlock = register("queensgoldblock", 64, CoreBase.tab, queensgoldBlock);
		greencandyItemBlock = register("greencandyblock", 64, CoreBase.tab, greencandyBlock);
		redcandyItemBlock = register("redcandyblock", 64, CoreBase.tab, redcandyBlock);
		
//		GameRegistry.register(aeonsteelBlock);
//		GameRegistry.register(dogbeariumBlock);
//		GameRegistry.register(queensgoldBlock);
//		GameRegistry.register(greencandyBlock);
//		GameRegistry.register(redcandyBlock);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

}
