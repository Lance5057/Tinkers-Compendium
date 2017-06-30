package lance5057.tDefense.core;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.blocks.TDMetalBlock;
import lance5057.tDefense.core.blocks.TDMetalItemBlock;
import lance5057.tDefense.core.blocks.crestMount.CrestMount;
import lance5057.tDefense.util.BlocksBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CoreBlocks extends BlocksBase {
	public static TDMetalBlock metalBlocks;
	public static TDMetalItemBlock metalItemBlock;

	public static CrestMount crestMount;

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// aeonsteelBlock = register("aeonsteelblock", CoreBase.tab, 5);
		// dogbeariumBlock = register("dogbeariumblock", CoreBase.tab, 5);
		// queensgoldBlock = register("queensgoldblock", CoreBase.tab, 5);
		// greencandyBlock = register("greencandyblock", CoreBase.tab, 5);
		// redcandyBlock = register("redcandyblock", CoreBase.tab, 5);

		crestMount = new CrestMount();
		crestMount.setCreativeTab(CoreBase.tab);

		metalBlocks = (TDMetalBlock) (new TDMetalBlock().setUnlocalizedName("metalblock"));
		metalBlocks.setRegistryName("metalblock");
		GameRegistry.register(metalBlocks);

		// We also need to create and register an ItemBlock for this block
		// otherwise it won't appear in the inventory
		metalItemBlock = new TDMetalItemBlock(metalBlocks);
		metalItemBlock.setRegistryName(metalBlocks.getRegistryName());
		GameRegistry.register(metalItemBlock);

		

		// aeonsteelItemBlock = register("aeonsteelblock", 64, CoreBase.tab,
		// aeonsteelBlock);
		// dogbeariumItemBlock = register("dogbeariumblock", 64, CoreBase.tab,
		// dogbeariumBlock);
		// queensgoldItemBlock = register("queensgoldblock", 64, CoreBase.tab,
		// queensgoldBlock);
		// greencandyItemBlock = register("greencandyblock", 64, CoreBase.tab,
		// greencandyBlock);
		// redcandyItemBlock = register("redcandyblock", 64, CoreBase.tab,
		// redcandyBlock);
		//
		// GameRegistry.register(aeonsteelBlock);
		// GameRegistry.register(dogbeariumBlock);
		// GameRegistry.register(queensgoldBlock);
		// GameRegistry.register(greencandyBlock);
		// GameRegistry.register(redcandyBlock);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		TinkersDefense.proxy.registerItemBlockRenderer(metalBlocks, 0, "aeonsteel");
		TinkersDefense.proxy.registerItemBlockRenderer(metalBlocks, 1, "queensgold");
		TinkersDefense.proxy.registerItemBlockRenderer(metalBlocks, 2, "dogbearium");
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub

	}

}
