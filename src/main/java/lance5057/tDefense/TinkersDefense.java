package lance5057.tDefense;

import lance5057.tDefense.core.CoreBase;
import lance5057.tDefense.core.materials.TDMaterials;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.TDTools;
import lance5057.tDefense.holiday.HolidayBase;
import lance5057.tDefense.proxy.CommonProxy;
import lance5057.tDefense.util.ModuleBase;
import lance5057.tDefense.util.RegEvents;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import scala.reflect.internal.Trees.Modifiers;


@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class TinkersDefense {

	private static int modGuiIndex = 0;
	public static final int GUI_CREST_INV = modGuiIndex++;
	//public static final int GUI_ANVIL_INV = modGuiIndex++;
	//public static final int GUI_GUIDEBOOK = modGuiIndex++;
	public static final int GUI_STRAPS_INV = modGuiIndex++;

	@Instance(Reference.MOD_ID)
	public static TinkersDefense instance = new TinkersDefense();
	
	PacketHandler phandler = new PacketHandler();

	HolidayBase holiday;
	ModuleBase core;
	//ModuleBase armor;

	// public static TDEventHandler TDevents;

	public static TD_Config config;

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE
			.newSimpleChannel(Reference.MOD_ID);

	public static RegEvents reg;
	
	public static Modifiers mods;

	// public static Item item_Guidebook;
	public static TDParts parts;
	public static TDTools tools;
	public static TDMaterials mats;
	
	@SidedProxy(clientSide = "lance5057.tDefense.proxy.ClientProxy", serverSide = "lance5057.tDefense.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static int month;

	// public TDArmorAddon ArmorAddon = new TDArmorAddon();

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(TinkersDefense.instance, new CommonProxy());
		
		//reg = new RegEvents();
		
		core = new CoreBase();
		holiday = new HolidayBase();
		//armor = new ArmorBase();
		
		mats = new TDMaterials();
		parts = new TDParts();
		tools = new TDTools();
		//config = new TD_Config(e);
		// mods = new Modifiers();

		// Blocks
		// block_CrestMount = new
		// CrestMount().setHardness(4.0F).setStepSound(Block.soundTypeStone).setBlockName("crestmount").setCreativeTab(tabName);
		// block_ArmorAnvil = new
		// FinishingAnvil().setHardness(4.0F).setStepSound(Block.soundTypeAnvil).setBlockName("armoranvil").setCreativeTab(tabName);
		// block_JewelersBench = new
		// JewelersBench().setHardness(4.0F).setStepSound(Block.soundTypeWood).setBlockName("jewelersbench").setCreativeTab(tabName);
		//
		// block_aeonsteelBlock = new
		// AeonSteelBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("aeonsteelblock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID
		// + ":aeonsteelblock");
		// block_queensgoldBlock = new
		// QueensGoldBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("queensgoldblock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID
		// + ":queensgoldblock");
		// block_dogbeariumBlock = new
		// DogbeariumBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("dogbeariumblock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID
		// + ":dogbeariumblock");
		// block_redmintBlock = new
		// RedMintBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("redmintblock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID
		// + ":redmintblock");
		// block_greenmintBlock = new
		// GreenMintBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("greenmintblock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID
		// + ":greenmintblock");

		// Items
		// item_Guidebook = new GuideBook();

		// Fluids
		// moltenaeonsteel = new
		// Fluid("moltenaeonsteel").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		// moltenqueensgold = new
		// Fluid("moltenqueensgold").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		// moltendogbearium = new
		// Fluid("moltendogbearium").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		// moltenredmint = new
		// Fluid("moltenredmint").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		// moltengreenmint = new
		// Fluid("moltengreenmint").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);

		// Tools
		// tool_roundShield = new RoundShield();
		// tool_heaterShield = new HeaterShield();
		// tool_shears = new Shears();
		// tool_wrench = new TinkerWrench();
		// tool_zweihander = new TinkerZweihander(0);
		// tool_hookshot = new TinkersHookshot();

		// Patterns
		// woodPattern = new TD_Patterns("pattern_", "Pattern");
		// metalPattern = new TD_Patterns("cast_", "MetalPattern");

		// Minecraft Registrations
		// Blocks
		// GameRegistry.registerBlock(block_CrestMount, "block_crestmount");
		// GameRegistry.registerBlock(block_ArmorAnvil, "block_armoranvil");
		// GameRegistry.registerBlock(block_JewelersBench,
		// "block_jewelersbench");
		// GameRegistry.registerBlock(block_aeonsteelBlock, "aeonsteelblock");
		// GameRegistry.registerBlock(block_queensgoldBlock, "queensgoldblock");
		// GameRegistry.registerBlock(block_dogbeariumBlock, "dogbeariumblock");
		// GameRegistry.registerBlock(block_redmintBlock, "redmintblock");
		// GameRegistry.registerBlock(block_greenmintBlock, "greenmintblock");

		// Items
		// GameRegistry.registerItem(item_Guidebook, "guidebook");

		// GameRegistry.registerItem(item_aeonsteelIngot, "aeonsteelingot");
		// GameRegistry.registerItem(item_queensgoldIngot, "queensgoldingot");
		// GameRegistry.registerItem(item_dogbeariumIngot, "dogbeariumingot");
		//
		// GameRegistry.registerItem(item_redmintcane, "redmintcane");
		// GameRegistry.registerItem(item_redmintIngot, "redmintingot");
		// GameRegistry.registerItem(item_greenmintcane, "greenmintcane");
		// GameRegistry.registerItem(item_greenmintIngot, "greenmintingot");

		// Tools
		// GameRegistry.registerItem(tool_roundShield, "Round Shield");
		// GameRegistry.registerItem(tool_heaterShield, "Heater Shield");
		//
		// GameRegistry.registerItem(tool_shears, "Tinker Shears");
		// GameRegistry.registerItem(tool_wrench, "Tinker Wrench");
		// GameRegistry.registerItem(tool_zweihander, "Zweihander");
		// //GameRegistry.registerItem(tool_hookshot, "Hookshot");

		// Patterns
		// GameRegistry.registerItem(woodPattern, "Pattern");
		// GameRegistry.registerItem(metalPattern, "Cast");

		// TileEntities
		// GameRegistry.registerTileEntity(TileEntity_CrestMount.class,
		// "tile_crestmount");
		// GameRegistry.registerTileEntity(TileEntity_FinishingAnvil.class,
		// "tile_armoranvil");
		// GameRegistry.registerTileEntity(TileEntity_JewelersBench.class,
		// "tile_jewelersbench");

		// Fluids
		// FluidRegistry.registerFluid(moltenaeonsteel);
		// FluidRegistry.registerFluid(moltenqueensgold);
		// FluidRegistry.registerFluid(moltendogbearium);
		// FluidRegistry.registerFluid(moltenredmint);
		// FluidRegistry.registerFluid(moltengreenmint);

		// FluidBlocks
		// moltenaeonsteelBlock = new MoltenFluid(moltenaeonsteel, "aeonsteel");
		// moltenqueensgoldBlock = new MoltenFluid(moltenqueensgold,
		// "queensgold");
		// moltendogbeariumBlock = new MoltenFluid(moltendogbearium,
		// "dogbearium");
		// moltenredmintBlock = new MoltenFluid(moltenredmint, "redmint");
		// moltengreenmintBlock = new MoltenFluid(moltengreenmint, "greenmint");

		// GameRegistry.registerBlock(moltenaeonsteelBlock, "moltenaeonsteel");
		// GameRegistry.registerBlock(moltenqueensgoldBlock,
		// "moltenqueensgold");
		// GameRegistry.registerBlock(moltendogbeariumBlock,
		// "moltendogbearium");
		// GameRegistry.registerBlock(moltenredmintBlock, "moltenredmint");
		// GameRegistry.registerBlock(moltengreenmintBlock, "moltengreenmint");

		// Recipes
		// GameRegistry.addShapedRecipe(new ItemStack(block_CrestMount), new
		// Object[] {"xxx", "-i-", "---", 'x', new ItemStack(
		// TinkerTools.toughRod, 1, 1), 'i', new ItemStack(
		// TinkerTools.toolRod, 1, 1)});
		// GameRegistry.addShapedRecipe(new ItemStack(block_ArmorAnvil), new
		// Object[] {"ai-", "lr-", "---", 'r', new ItemStack(
		// TinkerTools.toughRod, 1, 0), 'a', Blocks.anvil, 'i',
		// Items.iron_ingot, 'l', Blocks.log});
		// GameRegistry.addShapedRecipe(new ItemStack(block_aeonsteelBlock), new
		// Object[] {"xxx", "xxx", "xxx", 'x', item_aeonsteelIngot});
		// GameRegistry.addShapelessRecipe(new ItemStack(item_aeonsteelIngot,
		// 9), new Object[] {new ItemStack(
		// block_aeonsteelBlock)});
		// GameRegistry.addShapedRecipe(new ItemStack(block_queensgoldBlock),
		// new Object[] {"xxx", "xxx", "xxx", 'x', item_queensgoldIngot});
		// GameRegistry.addShapelessRecipe(new ItemStack(item_queensgoldIngot,
		// 9), new Object[] {new ItemStack(
		// block_queensgoldBlock)});
		// GameRegistry.addShapedRecipe(new ItemStack(block_dogbeariumBlock),
		// new Object[] {"xxx", "xxx", "xxx", 'x', item_dogbeariumIngot});
		// GameRegistry.addShapelessRecipe(new ItemStack(item_dogbeariumIngot,
		// 9), new Object[] {new ItemStack(
		// block_dogbeariumBlock)});
		// GameRegistry.addShapedRecipe(new ItemStack(block_redmintBlock), new
		// Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(
		// item_redmintcane, 1, 2)});
		// GameRegistry.addShapelessRecipe(new ItemStack(item_redmintcane, 9,
		// 2), new Object[] {new ItemStack(
		// block_redmintBlock)});
		// GameRegistry.addShapedRecipe(new ItemStack(block_greenmintBlock), new
		// Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(
		// item_greenmintcane, 1, 3)});
		// GameRegistry.addShapelessRecipe(new ItemStack(item_greenmintcane, 9,
		// 3), new Object[] {new ItemStack(
		// block_greenmintBlock)});

		// TinkersConstruct Registrations
		// Tools
		// TConstructRegistry.addItemToDirectory("Round Shield",
		// tool_roundShield);
		// TConstructRegistry.addItemToDirectory("Heater Shield",
		// tool_heaterShield);
		//
		// TConstructRegistry.addItemToDirectory("Tinker Shears", tool_shears);
		// TConstructRegistry.addItemToDirectory("Tinker Wrench", tool_wrench);
		// TConstructRegistry.addItemToDirectory("Zweihander", tool_zweihander);
		// TConstructRegistry.addItemToDirectory("Hookshot", tool_hookshot);

		// Patterns
		// TConstructRegistry.addItemStackToDirectory("rivets Pattern", new
		// ItemStack(
		// woodPattern, 1, 0));
		// TConstructRegistry.addItemStackToDirectory("clasp Pattern", new
		// ItemStack(
		// woodPattern, 1, 1));
		// TConstructRegistry.addItemStackToDirectory("armorplate Pattern", new
		// ItemStack(
		// woodPattern, 1, 2));
		//
		// //Entities
		// // EntityRegistry.registerModEntity(EntityHookshotHook.class,
		// "EntityHookshotHook", 0, this, 64, 10, true);
		//
		// if(config.ArmorAddon)
		// {
		// ArmorAddon.preInit(e);
		// }
		//
		// TDIntegration.Integrate();
		// mods.preInit();
		// proxy.registerRenderers();

		core.preInit(e);
		//armor.preInit(e);
		holiday.preInit(e);
		mats.preInit(e);
		parts.preInit(e);
		tools.preInit(e);
		proxy.preInit();
		
		
	}
	


	@EventHandler
	public void init(FMLInitializationEvent e) {

//		// I reject your moss and substitute my own!
//		if (config.mossEnabled || config.mossHard) {
//		
//		final List<IRecipe> recipes = CraftingManager.class
//				.getRecipeList();
//		final Iterator<IRecipe> recipe = recipes.iterator();
//		}

		core.init(e);
		//armor.init(e);
		holiday.init(e);
		mats.init(e);
		parts.init(e);
		tools.init(e);
		proxy.init();
		
		phandler.init();
		
		mats.integrate(mats.materials, mats.materialIntegrations, mats.deferredMaterials);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		//
		// if(config.ArmorAddon)
		// {
		// ArmorAddon.postInit(e);
		// }
		mats.postInit(e);
		parts.postInit(e);
		//armor.postInit(e);
		tools.postInit(e);
	}

}
