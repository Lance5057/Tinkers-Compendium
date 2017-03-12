package lance5057.tDefense;

import java.util.Iterator;
import java.util.List;

import lance5057.tDefense.core.CoreBase;
import lance5057.tDefense.core.materials.TDMaterials;
import lance5057.tDefense.core.tools.TDTools;
import lance5057.tDefense.holiday.HolidayBase;
import lance5057.tDefense.proxy.CommonProxy;
import lance5057.tDefense.util.ModuleBase;
import net.minecraft.block.Block;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
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
	public static final int GUI_ANVIL_INV = modGuiIndex++;
	public static final int GUI_GUIDEBOOK = modGuiIndex++;

	@Instance(Reference.MOD_ID)
	public static TinkersDefense instance = new TinkersDefense();

	HolidayBase holiday;
	ModuleBase core;

	// public static TDEventHandler TDevents;

	public static TD_Config config;

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE
			.newSimpleChannel(Reference.MOD_ID);

	public static Modifiers mods;

	// public static Item item_Guidebook;

	TDTools tools;
	TDMaterials mats;

	public static Block block_aeonsteelBlock;
	public static Fluid moltenaeonsteel;
	public static Block moltenaeonsteelBlock;

	public static Block block_queensgoldBlock;
	public static Fluid moltenqueensgold;
	public static Block moltenqueensgoldBlock;

	public static Block block_dogbeariumBlock;
	public static Fluid moltendogbearium;
	public static Block moltendogbeariumBlock;

	public static Block block_redmintBlock;
	public static Fluid moltenredmint;
	public static Block moltenredmintBlock;

	public static Block block_greenmintBlock;
	public static Fluid moltengreenmint;
	public static Block moltengreenmintBlock;

	// public static Item item_RawSapphire;
	// public static Item item_RawRuby;
	// public static Item item_RawAmethyst;
	// public static Item item_RawAmber;
	//
	// public static Block block_SapphireOre;
	// public static Block block_RubyOre;
	// public static Block block_AmethystOre;
	// public static Block block_AmberOre;

	// public static ToolCore tool_roundShield;
	// public static ToolCore tool_heaterShield;
	// public static ToolCore tool_wrench;
	// public static ToolCore tool_zweihander;
	// public static ToolCore tool_shears;
	// public static ToolCore tool_hookshot;

	// public static Block block_CrestMount;
	// public static Block block_ArmorAnvil;
	// public static Block block_JewelersBench;
	//
	// //public static Item item_ChainArmor;
	// public static Pattern woodPattern;
	// public static Pattern metalPattern;
	//
	// public static Item partRivet;
	// public static Item partArmorplate;
	// public static Item partClasp;
	// public static Item partCloth;
	// public static Item partChainmaille;
	//
	// public static ToolCore tcInject;

	// public static BotaniaMods flowermod;

	@SidedProxy(clientSide = "lance5057.tDefense.proxy.ClientProxy", serverSide = "lance5057.tDefense.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static int month;

	// public TDArmorAddon ArmorAddon = new TDArmorAddon();

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		core = new CoreBase();
		holiday = new HolidayBase();
		mats = new TDMaterials();
		tools = new TDTools();
		config = new TD_Config(e);
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

		core.preInit();
		holiday.preInit();
		tools.preInit(e);
		proxy.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

		// I reject your moss and substitute my own!
		if (config.mossEnabled || config.mossHard) {
		}
		final List<IRecipe> recipes = CraftingManager.getInstance()
				.getRecipeList();
		final Iterator<IRecipe> recipe = recipes.iterator();

		core.init();
		holiday.init();
		mats.setupMaterials(e);
		tools.init(e);
		proxy.Init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		//
		// if(config.ArmorAddon)
		// {
		// ArmorAddon.postInit(e);
		// }
		tools.postInit(e);
	}

	public void castmolten(Fluid fluid, int ID) {
		// // .addCastingRecipe(output, fluid, cast, hardeningDelay)
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.toolRod, 1, ID), new FluidStack(fluid,
		// (int) (144 * 0.5D)), TConstructRegistry.getItemStack("toolRodCast"),
		// 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.pickaxeHead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 1.0D)),
		// TConstructRegistry.getItemStack("pickaxeHeadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.shovelHead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 1.0D)),
		// TConstructRegistry.getItemStack("shovelHeadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.hatchetHead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 1.0D)),
		// TConstructRegistry.getItemStack("hatchetHeadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.swordBlade, 1, ID), new FluidStack(fluid,
		// (int) (144 * 1.0D)),
		// TConstructRegistry.getItemStack("swordBladeCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.fullGuard, 1, ID), new FluidStack(fluid,
		// (int) (144 * 3.0D)),
		// TConstructRegistry.getItemStack("fullGuardCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.wideGuard, 1, ID), new FluidStack(fluid,
		// (int) (144 * 0.5D)),
		// TConstructRegistry.getItemStack("wideGuardCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.crossbar, 1, ID), new FluidStack(fluid,
		// (int) (144 * 0.5D)), TConstructRegistry.getItemStack("crossbarCast"),
		// 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.binding, 1, ID), new FluidStack(fluid,
		// (int) (144 * 0.5D)), TConstructRegistry.getItemStack("bindingCast"),
		// 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.handGuard, 1, ID), new FluidStack(fluid,
		// (int) (144 * 0.5D)),
		// TConstructRegistry.getItemStack("handGuardCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.frypanHead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 1.0D)),
		// TConstructRegistry.getItemStack("frypanHeadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.signHead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 1.0D)), TConstructRegistry.getItemStack("signHeadCast"),
		// 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.knifeBlade, 1, ID), new FluidStack(fluid,
		// (int) (144 * 0.5D)),
		// TConstructRegistry.getItemStack("knifeBladeCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.chiselHead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 0.5D)),
		// TConstructRegistry.getItemStack("chiselHeadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.toughRod, 1, ID), new FluidStack(fluid,
		// (int) (144 * 3.0D)), TConstructRegistry.getItemStack("toughRodCast"),
		// 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.toughBinding, 1, ID), new FluidStack(fluid,
		// (int) (144 * 3.0D)),
		// TConstructRegistry.getItemStack("toughBindingCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.largePlate, 1, ID), new FluidStack(fluid,
		// (int) (144 * 8.0D)),
		// TConstructRegistry.getItemStack("largePlateCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.broadAxeHead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 8.0D)),
		// TConstructRegistry.getItemStack("broadAxeHeadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.scytheBlade, 1, ID), new FluidStack(fluid,
		// (int) (144 * 8.0D)),
		// TConstructRegistry.getItemStack("scytheHeadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.excavatorHead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 8.0D)),
		// TConstructRegistry.getItemStack("excavatorHeadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.largeSwordBlade, 1, ID), new FluidStack(fluid,
		// (int) (144 * 8.0D)),
		// TConstructRegistry.getItemStack("largeBladeCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.hammerHead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 8.0D)),
		// TConstructRegistry.getItemStack("hammerHeadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// TinkerTools.arrowhead, 1, ID), new FluidStack(fluid,
		// (int) (144 * 1.0D)),
		// TConstructRegistry.getItemStack("arrowheadCast"), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// partArmorplate, 1, ID), new FluidStack(fluid,
		// (int) (144 * 4.0D)), new ItemStack(metalPattern, 1, 2), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// partRivet, 1, ID), new FluidStack(fluid, (int) (144 * 0.5D)), new
		// ItemStack(
		// metalPattern, 1, 0), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// partClasp, 1, ID), new FluidStack(fluid, (int) (144 * 1.0D)), new
		// ItemStack(
		// metalPattern, 1, 1), 50);
		// TConstructRegistry.getTableCasting().addCastingRecipe(new ItemStack(
		// partChainmaille, 1, ID), new FluidStack(fluid,
		// (int) (144 * 4.0D)), new ItemStack(metalPattern, 1, 4), 50);
	}

	// public void buildParts(Item item, int meta)
	// {
	// final int[] nonMetals = {0, 1, 3, 4, 5, 6, 7, 8, 9, 17};
	// final int[] liquidDamage = new int[] {2, 13, 10, 11, 12, 14, 15, 6, 16,
	// 18};
	//
	// for(int mat = 0; mat < nonMetals.length; mat++) //
	// {
	// TConstructRegistry.addPartMapping(woodPattern, meta, mat, new ItemStack(
	// item, 1, mat));
	// }
	//
	// final LiquidCasting tableCasting = TConstructRegistry.getTableCasting();
	// // patternOutputs = new Item[] { partShuriken, partCrossbowLimb,
	// // partCrossbowBody, partBowLimb };
	//
	// final ItemStack cast = new ItemStack(metalPattern, 1, meta);
	//
	// tableCasting.addCastingRecipe(cast, new FluidStack(
	// TinkerSmeltery.moltenAlubrassFluid, TConstruct.ingotLiquidValue), new
	// ItemStack(
	// item, 1, Short.MAX_VALUE), false, 50);
	// tableCasting.addCastingRecipe(cast, new FluidStack(
	// TinkerSmeltery.moltenGoldFluid, TConstruct.ingotLiquidValue * 2), new
	// ItemStack(
	// item, 1, Short.MAX_VALUE), false, 50);
	//
	// for(int iterTwo = 0; iterTwo < TinkerSmeltery.liquids.length; iterTwo++)
	// {
	// final Fluid fs = TinkerSmeltery.liquids[iterTwo].getFluid();
	// final int fluidAmount = metalPattern.getPatternCost(cast) *
	// TConstruct.ingotLiquidValue / 2;
	// final ItemStack metalCast = new ItemStack(item, 1,
	// liquidDamage[iterTwo]);
	// tableCasting.addCastingRecipe(metalCast, new FluidStack(fs,
	// fluidAmount), cast, 50);
	// Smeltery.addMelting(FluidType.getFluidType(fs), metalCast, 0,
	// fluidAmount);
	// }
	// }

	

}
