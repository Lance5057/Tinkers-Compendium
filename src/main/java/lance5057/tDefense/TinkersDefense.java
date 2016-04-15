package lance5057.tDefense;

import static net.minecraft.util.EnumChatFormatting.DARK_RED;
import static net.minecraft.util.EnumChatFormatting.GOLD;
import static net.minecraft.util.EnumChatFormatting.LIGHT_PURPLE;

import java.util.Date;

import lance5057.tDefense.armor.blocks.GlowstoneCrumbs;
import lance5057.tDefense.armor.blocks.UnstableBlock;
import lance5057.tDefense.armor.blocks.UnstableItemBlock;
import lance5057.tDefense.armor.events.ArmorModEvents;
import lance5057.tDefense.armor.events.ArmorRenderEvent;
import lance5057.tDefense.armor.items.Sheath;
import lance5057.tDefense.armor.items.cloth.TinkersHood;
import lance5057.tDefense.armor.items.cloth.TinkersRobe;
import lance5057.tDefense.armor.items.cloth.TinkersShawl;
import lance5057.tDefense.armor.items.cloth.TinkersShoes;
import lance5057.tDefense.armor.items.heavy.TinkersBreastplate;
import lance5057.tDefense.armor.items.heavy.TinkersGauntlets;
import lance5057.tDefense.armor.items.heavy.TinkersGrieves;
import lance5057.tDefense.armor.items.heavy.TinkersHelm;
import lance5057.tDefense.armor.items.heavy.TinkersSabatons;
import lance5057.tDefense.armor.items.light.TinkersBoots;
import lance5057.tDefense.armor.items.light.TinkersChausses;
import lance5057.tDefense.armor.items.light.TinkersCoif;
import lance5057.tDefense.armor.items.light.TinkersHauberk;
import lance5057.tDefense.armor.parts.Cloth;
import lance5057.tDefense.armor.parts.ClothMaterial;
import lance5057.tDefense.blocks.JewelersBench;
import lance5057.tDefense.core.TD_Patterns;
import lance5057.tDefense.core.blocks.AeonSteelBlock;
import lance5057.tDefense.core.blocks.DogbeariumBlock;
import lance5057.tDefense.core.blocks.GreenMintBlock;
import lance5057.tDefense.core.blocks.QueensGoldBlock;
import lance5057.tDefense.core.blocks.RedMintBlock;
import lance5057.tDefense.core.blocks.crestMount.CrestMount;
import lance5057.tDefense.core.blocks.crestMount.TileEntity_CrestMount;
import lance5057.tDefense.core.events.TDEventHandler;
import lance5057.tDefense.core.liquids.MoltenFluid;
import lance5057.tDefense.core.network.PacketHandler;
import lance5057.tDefense.core.tools.HeaterShield;
import lance5057.tDefense.core.tools.RoundShield;
import lance5057.tDefense.core.tools.Shears;
import lance5057.tDefense.core.tools.TinkerWrench;
import lance5057.tDefense.core.tools.TinkerZweihander;
import lance5057.tDefense.core.tools.modifiers.Modifiers;
import lance5057.tDefense.core.tools.modifiers.Botania.BotaniaMods;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.FinishingAnvil;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.TileEntity_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.utilities.Injector;
import lance5057.tDefense.proxy.CommonProxy;
import lance5057.tDefense.tileentities.TileEntity_JewelersBench;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.StencilGuiElement;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.client.ToolGuiElement;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.LiquidCasting;
import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.crafting.Smeltery;
import tconstruct.library.crafting.StencilBuilder;
import tconstruct.library.tools.DynamicToolPart;
import tconstruct.library.tools.ToolCore;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.tools.TinkerTools;
import tconstruct.tools.items.Pattern;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class TinkersDefense
{

	private static int							modGuiIndex		= 0;
	public static final int						GUI_CREST_INV	= modGuiIndex++;
	public static final int						GUI_ANVIL_INV	= modGuiIndex++;

	@Instance(Reference.MOD_ID)
	public static TinkersDefense				instance		= new TinkersDefense();

	public static CreativeTabs					tabName			= new CreativeTabs("tabName")
																{

																	public Item getTabIconItem()
																	{
																		return TinkersDefense.tabIcon;
																	}

																};

	public static TDEventHandler				TDevents;
	public static ArmorRenderEvent				AREvent;
	public static ArmorModEvents				AMEvent;

	public static TD_Config						config;

	public static final SimpleNetworkWrapper	INSTANCE		= NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

	static Date									date			= new Date();

	public static Item							tabIcon;

	public static Modifiers						mods;

	public static Item							item_AeonSteelIngot;
	public static Block							block_AeonSteelBlock;
	public static Fluid							moltenAeonsteel;
	public static Block							moltenAeonsteelBlock;

	public static Item							item_QueensGoldIngot;
	public static Block							block_QueensGoldBlock;
	public static Fluid							moltenQueensGold;
	public static Block							moltenQueensGoldBlock;

	public static Item							item_DogbeariumIngot;
	public static Block							block_DogbeariumBlock;
	public static Fluid							moltenDogbearium;
	public static Block							moltenDogbeariumBlock;

	public static Item							item_RedMintcane;
	public static Item							item_GreenMintcane;

	public static Item							item_RedMintIngot;
	public static Block							block_RedMintBlock;
	public static Fluid							moltenRedMint;
	public static Block							moltenRedMintBlock;

	public static Item							item_GreenMintIngot;
	public static Block							block_GreenMintBlock;
	public static Fluid							moltenGreenMint;
	public static Block							moltenGreenMintBlock;

	public static Item							item_RawSapphire;
	public static Item							item_RawRuby;
	public static Item							item_RawAmethyst;
	public static Item							item_RawAmber;

	public static Block							block_SapphireOre;
	public static Block							block_RubyOre;
	public static Block							block_AmethystOre;
	public static Block							block_AmberOre;

	public static ToolCore						tool_roundShield;
	public static ToolCore						tool_heaterShield;
	public static ToolCore						tool_wrench;
	public static ToolCore						tool_sheath;
	//	public static ToolCore tool_mask;
	public static ToolCore						tool_zweihander;
	public static ToolCore						tool_shears;

	public static Block							block_CrestMount;
	public static Block							block_ArmorAnvil;
	public static Block							block_JewelersBench;

	public static Block							block_Unstable;
	public static Block							block_GlowCrumbs;

	public static ToolCore						armor_TinkerHood;
	public static ToolCore						armor_TinkerShawl;
	public static ToolCore						armor_TinkerRobe;
	public static ToolCore						armor_TinkerShoes;

	public static ToolCore						armor_TinkerCoif;
	public static ToolCore						armor_TinkerHalberd;
	public static ToolCore						armor_TinkerChausses;
	public static ToolCore						armor_TinkerBoots;

	public static ToolCore						armor_TinkerHelm;
	public static ToolCore						armor_TinkerBreastplate;
	public static ToolCore						armor_TinkerGrieves;
	public static ToolCore						armor_TinkerSabatons;
	public static ToolCore						armor_TinkerGauntlets;

	public static Item							item_ChainArmor;
	public static Pattern						woodPattern;
	public static Pattern						metalPattern;

	public static Item							partRivet;
	public static Item							partArmorplate;
	public static Item							partClasp;
	public static Item							partCloth;
	public static Item							partChainmaille;

	public static ToolCore						tcInject;

	public static BotaniaMods				flowermod;

	@SidedProxy(clientSide = "lance5057.tDefense.proxy.ClientProxy", serverSide = "lance5057.tDefense.proxy.CommonProxy")
	public static CommonProxy					proxy;
	public static int							month;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		month = this.date.getMonth();
		TDIntegration.Integrate();

		PacketHandler.init();

		TDevents = new TDEventHandler();
		AMEvent = new ArmorModEvents();
		AREvent = new ArmorRenderEvent();

		MinecraftForge.EVENT_BUS.register(AREvent);
		MinecraftForge.EVENT_BUS.register(AMEvent);

		config = new TD_Config(e);

		NetworkRegistry.INSTANCE.registerGuiHandler(TinkersDefense.instance, new CommonProxy());
		MinecraftForge.EVENT_BUS.register(this);

		ClientCommandHandler.instance.registerCommand(new TD_Commands());

		tabIcon = new Item().setMaxStackSize(1).setCreativeTab(tabName).setUnlocalizedName("tabIcon").setTextureName(Reference.MOD_ID + ":Icon");
		GameRegistry.registerItem(tabIcon, "tabIcon");

		//flowermod = new TDAddonBotania();

		mods = new Modifiers();
		mods.preInit();

		//		item_RawSapphire = new RawGem("sapphire");
		//		item_RawRuby = new RawGem("ruby");
		//		item_RawAmethyst = new RawGem("amethyst");
		//		item_RawAmber = new RawGem("amber");
		//		
		//		block_SapphireOre = new TD_Ore(Material.ground, "sapphire", item_RawSapphire);
		//		block_RubyOre = new TD_Ore(Material.ground, "ruby", item_RawRuby);
		//		block_AmethystOre = new TD_Ore(Material.ground, "amethyst", item_RawAmethyst);
		//		block_AmberOre = new TD_Ore(Material.ground, "amber", item_RawAmber);
		//		
		//		GameRegistry.registerItem(item_RawSapphire, "rawsapphire");
		//		GameRegistry.registerItem(item_RawRuby, "rawruby");
		//		GameRegistry.registerItem(item_RawAmethyst, "rawamethyst");
		//		GameRegistry.registerItem(item_RawAmber, "rawamber");
		//		
		//		GameRegistry.registerBlock(block_SapphireOre, "sapphireore");
		//		GameRegistry.registerBlock(block_RubyOre, "rubyore");
		//		GameRegistry.registerBlock(block_AmethystOre, "amethystore");
		//		GameRegistry.registerBlock(block_AmberOre, "amber ore");

		block_Unstable = new UnstableBlock();
		GameRegistry.registerBlock(block_Unstable, UnstableItemBlock.class, "Unstable");

		block_GlowCrumbs = new GlowstoneCrumbs();
		GameRegistry.registerBlock(block_GlowCrumbs, "Block_GlowCrumbs");

		block_CrestMount = new CrestMount().setHardness(4.0F).setStepSound(Block.soundTypeStone).setBlockName("CrestMount").setCreativeTab(tabName);

		GameRegistry.registerBlock(block_CrestMount, "Block_CrestMount");
		GameRegistry.registerTileEntity(TileEntity_CrestMount.class, "Tile_CrestMount");

		GameRegistry.addShapedRecipe(new ItemStack(block_CrestMount), new Object[] {"xxx", "-i-", "---", 'x', new ItemStack(TinkerTools.toughRod, 1, 1), 'i', new ItemStack(TinkerTools.toolRod, 1, 1)});

		block_ArmorAnvil = new FinishingAnvil().setHardness(4.0F).setStepSound(Block.soundTypeAnvil).setBlockName("ArmorAnvil").setCreativeTab(tabName);

		GameRegistry.registerBlock(block_ArmorAnvil, "Block_ArmorAnvil");
		GameRegistry.registerTileEntity(TileEntity_FinishingAnvil.class, "Tile_ArmorAnvil");

		GameRegistry.addShapedRecipe(new ItemStack(block_ArmorAnvil), new Object[] {"ai-", "lr-", "---", 'r', new ItemStack(TinkerTools.toughRod, 1, 0), 'a', Blocks.anvil, 'i', Items.iron_ingot, 'l', Blocks.log});

		block_JewelersBench = new JewelersBench().setHardness(4.0F).setStepSound(Block.soundTypeWood).setBlockName("JewelersBench").setCreativeTab(tabName);

		GameRegistry.registerBlock(block_JewelersBench, "Block_JewelersBench");
		GameRegistry.registerTileEntity(TileEntity_JewelersBench.class, "Tile_JewelersBench");

		item_AeonSteelIngot = new Item().setCreativeTab(tabName).setMaxStackSize(64).setUnlocalizedName("AeonsteelIngot").setTextureName(Reference.MOD_ID + ":AeonsteelIngot");

		GameRegistry.registerItem(item_AeonSteelIngot, "AeonsteelIngot");

		block_AeonSteelBlock = new AeonSteelBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("AeonsteelBlock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID + ":AeonsteelBlock");

		GameRegistry.registerBlock(block_AeonSteelBlock, "Aeonsteelblock");

		GameRegistry.addShapedRecipe(new ItemStack(block_AeonSteelBlock), new Object[] {"xxx", "xxx", "xxx", 'x', item_AeonSteelIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(item_AeonSteelIngot, 9), new Object[] {new ItemStack(block_AeonSteelBlock)});

		moltenAeonsteel = new Fluid("moltenAeonsteel").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		FluidRegistry.registerFluid(moltenAeonsteel);

		moltenAeonsteelBlock = new MoltenFluid(moltenAeonsteel, "Aeonsteel");

		GameRegistry.registerBlock(moltenAeonsteelBlock, "moltenAeonsteel");

		item_QueensGoldIngot = new Item().setCreativeTab(tabName).setMaxStackSize(64).setUnlocalizedName("QueensGoldIngot").setTextureName(Reference.MOD_ID + ":QueensGoldIngot");

		GameRegistry.registerItem(item_QueensGoldIngot, "QueensGoldIngot");

		block_QueensGoldBlock = new QueensGoldBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("QueensGoldBlock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID + ":QueensGoldBlock");

		GameRegistry.registerBlock(block_QueensGoldBlock, "QueensGoldblock");

		GameRegistry.addShapedRecipe(new ItemStack(block_QueensGoldBlock), new Object[] {"xxx", "xxx", "xxx", 'x', item_QueensGoldIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(item_QueensGoldIngot, 9), new Object[] {new ItemStack(block_QueensGoldBlock)});

		moltenQueensGold = new Fluid("moltenQueensGold").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		FluidRegistry.registerFluid(moltenQueensGold);

		moltenQueensGoldBlock = new MoltenFluid(moltenQueensGold, "QueensGold");

		GameRegistry.registerBlock(moltenQueensGoldBlock, "moltenQueensGold");

		// Dogbearium
		item_DogbeariumIngot = new Item().setCreativeTab(tabName).setMaxStackSize(64).setUnlocalizedName("DogbeariumIngot").setTextureName(Reference.MOD_ID + ":DogbeariumIngot");

		GameRegistry.registerItem(item_DogbeariumIngot, "DogbeariumIngot");

		block_DogbeariumBlock = new DogbeariumBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("DogbeariumBlock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID + ":DogbeariumBlock");

		GameRegistry.registerBlock(block_DogbeariumBlock, "Dogbeariumblock");

		GameRegistry.addShapedRecipe(new ItemStack(block_DogbeariumBlock), new Object[] {"xxx", "xxx", "xxx", 'x', item_DogbeariumIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(item_DogbeariumIngot, 9), new Object[] {new ItemStack(block_DogbeariumBlock)});

		moltenDogbearium = new Fluid("moltenDogbearium").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		FluidRegistry.registerFluid(moltenDogbearium);

		moltenDogbeariumBlock = new MoltenFluid(moltenDogbearium, "dogbearium");

		GameRegistry.registerBlock(moltenDogbeariumBlock, "moltenDogbearium");

		//Candy Canes
		item_RedMintcane = new Item().setCreativeTab(tabName).setMaxStackSize(64).setUnlocalizedName("RedMintcane").setTextureName(Reference.MOD_ID + ":redmintcane");

		item_RedMintIngot = new Item().setCreativeTab(tabName).setMaxStackSize(64).setUnlocalizedName("RedMintIngot").setTextureName(Reference.MOD_ID + ":redmintingot");

		GameRegistry.registerItem(item_RedMintcane, "RedMintCane");
		GameRegistry.registerItem(item_RedMintIngot, "RedMintIngot");

		block_RedMintBlock = new RedMintBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("RedMintBlock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID + ":redmintblock");

		GameRegistry.registerBlock(block_RedMintBlock, "redmintblock");

		GameRegistry.addShapedRecipe(new ItemStack(block_RedMintBlock), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(item_RedMintcane, 1, 2)});
		GameRegistry.addShapelessRecipe(new ItemStack(item_RedMintcane, 9, 2), new Object[] {new ItemStack(block_RedMintBlock)});

		moltenRedMint = new Fluid("moltenRedMint").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		FluidRegistry.registerFluid(moltenRedMint);

		moltenRedMintBlock = new MoltenFluid(moltenRedMint, "RedMint");

		GameRegistry.registerBlock(moltenRedMintBlock, "moltenRedMint");

		item_GreenMintcane = new Item().setCreativeTab(tabName).setMaxStackSize(64).setUnlocalizedName("GreenMintcane").setTextureName(Reference.MOD_ID + ":greenmintcane");

		item_GreenMintIngot = new Item().setCreativeTab(tabName).setMaxStackSize(64).setUnlocalizedName("GreenMintIngot").setTextureName(Reference.MOD_ID + ":greenmintingot");

		GameRegistry.registerItem(item_GreenMintcane, "GreenMintCane");
		GameRegistry.registerItem(item_GreenMintIngot, "GreenMintIngot");

		block_GreenMintBlock = new GreenMintBlock(Material.iron).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockName("GreenMintBlock").setCreativeTab(tabName).setBlockTextureName(Reference.MOD_ID + ":greenmintblock");

		GameRegistry.registerBlock(block_GreenMintBlock, "GreenMintblock");

		GameRegistry.addShapedRecipe(new ItemStack(block_GreenMintBlock), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(item_GreenMintcane, 1, 3)});
		GameRegistry.addShapelessRecipe(new ItemStack(item_GreenMintcane, 9, 3), new Object[] {new ItemStack(block_GreenMintBlock)});

		moltenGreenMint = new Fluid("moltenGreenMint").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		FluidRegistry.registerFluid(moltenGreenMint);

		moltenGreenMintBlock = new MoltenFluid(moltenGreenMint, "GreenMint");

		GameRegistry.registerBlock(moltenGreenMintBlock, "moltenGreenMint");

		tool_roundShield = new RoundShield();
		tool_heaterShield = new HeaterShield();

		tool_shears = new Shears();
		tool_wrench = new TinkerWrench();
		tool_sheath = new Sheath();
		//		tool_mask = new Mask();

		tool_zweihander = new TinkerZweihander(0);

		armor_TinkerHelm = new TinkersHelm();
		armor_TinkerBreastplate = new TinkersBreastplate();
		armor_TinkerGrieves = new TinkersGrieves();
		armor_TinkerSabatons = new TinkersSabatons();
		armor_TinkerGauntlets = new TinkersGauntlets();

		armor_TinkerRobe = new TinkersRobe();
		armor_TinkerShawl = new TinkersShawl();
		armor_TinkerHood = new TinkersHood();
		armor_TinkerShoes = new TinkersShoes();

		armor_TinkerCoif = new TinkersCoif();
		armor_TinkerHalberd = new TinkersHauberk();
		armor_TinkerChausses = new TinkersChausses();
		armor_TinkerBoots = new TinkersBoots();

		//Register Tools

		GameRegistry.registerItem(tool_roundShield, "Round Shield");
		GameRegistry.registerItem(tool_heaterShield, "Heater Shield");

		GameRegistry.registerItem(tool_shears, "Tinker Shears");
		GameRegistry.registerItem(tool_wrench, "Tinker Wrench");
		GameRegistry.registerItem(tool_sheath, "Sheath");
		//		GameRegistry.registerItem(tool_mask, "Mask");
		GameRegistry.registerItem(tool_zweihander, "Zweihander");

		GameRegistry.registerItem(armor_TinkerHelm, "tinkerhelm");
		GameRegistry.registerItem(armor_TinkerBreastplate, "tinkerbreastplate");
		GameRegistry.registerItem(armor_TinkerGrieves, "tinkergrieves");
		GameRegistry.registerItem(armor_TinkerSabatons, "tinkersabatons");
		GameRegistry.registerItem(armor_TinkerGauntlets, "tinkergauntlets");

		GameRegistry.registerItem(armor_TinkerCoif, "tinkercoif");
		GameRegistry.registerItem(armor_TinkerHalberd, "tinkerhalberd");
		GameRegistry.registerItem(armor_TinkerChausses, "tinkerchausses");
		GameRegistry.registerItem(armor_TinkerBoots, "tinkerboots");

		GameRegistry.registerItem(armor_TinkerRobe, "tinkerrobe");
		GameRegistry.registerItem(armor_TinkerShawl, "tinkershawl");
		GameRegistry.registerItem(armor_TinkerHood, "tinkerhood");
		GameRegistry.registerItem(armor_TinkerShoes, "tinkershoes");

		//Add Tools to TiCo directory
		TConstructRegistry.addItemToDirectory("Round Shield", tool_roundShield);
		TConstructRegistry.addItemToDirectory("Heater Shield", tool_heaterShield);
		TConstructRegistry.addItemToDirectory("Tinker Shears", tool_shears);
		TConstructRegistry.addItemToDirectory("Tinker Wrench", tool_wrench);
		TConstructRegistry.addItemToDirectory("Sheath", tool_sheath);
		//		TConstructRegistry.addItemToDirectory("Mask", tool_mask);
		TConstructRegistry.addItemToDirectory("Zweihander", tool_zweihander);

		TConstructRegistry.addItemToDirectory("tinkerhelm", armor_TinkerHelm);
		TConstructRegistry.addItemToDirectory("tinkerbreastplate", armor_TinkerBreastplate);
		TConstructRegistry.addItemToDirectory("tinkergrieves", armor_TinkerGrieves);
		TConstructRegistry.addItemToDirectory("tinkersabatons", armor_TinkerSabatons);
		TConstructRegistry.addItemToDirectory("tinkergauntlets", armor_TinkerGauntlets);

		TConstructRegistry.addItemToDirectory("tinkercoif", armor_TinkerCoif);
		TConstructRegistry.addItemToDirectory("tinkerhalberd", armor_TinkerHalberd);
		TConstructRegistry.addItemToDirectory("tinkerchausses", armor_TinkerChausses);
		TConstructRegistry.addItemToDirectory("tinkerboots", armor_TinkerBoots);

		TConstructRegistry.addItemToDirectory("tinkerrobe", armor_TinkerRobe);
		TConstructRegistry.addItemToDirectory("tinkershawl", armor_TinkerShawl);
		TConstructRegistry.addItemToDirectory("tinkerhood", armor_TinkerHood);
		TConstructRegistry.addItemToDirectory("tinkershoes", armor_TinkerShoes);

		woodPattern = new TD_Patterns("pattern_", "Pattern");
		metalPattern = new TD_Patterns("cast_", "MetalPattern");

		GameRegistry.registerItem(woodPattern, "Pattern");
		// TConstructRegistry.addItemToDirectory("woodPattern", woodPattern);

		GameRegistry.registerItem(metalPattern, "Cast");

		TConstructRegistry.addItemStackToDirectory("rivets Pattern", new ItemStack(woodPattern, 1, 0));
		TConstructRegistry.addItemStackToDirectory("clasp Pattern", new ItemStack(woodPattern, 1, 1));
		TConstructRegistry.addItemStackToDirectory("armorplate Pattern", new ItemStack(woodPattern, 1, 2));

		// Renderers
		proxy.registerRenderers();
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		//System.out.print(Reference.MOD_ID);

		//flowermod.RegisterRecipes();
		//flowermod.RegisterModifiers();

		StencilBuilder.registerStencil(50, woodPattern, 0); // rivets
		StencilBuilder.registerStencil(51, woodPattern, 1); // clasp
		StencilBuilder.registerStencil(52, woodPattern, 2); // armorplate
		StencilBuilder.registerStencil(53, woodPattern, 3); // cloth
		StencilBuilder.registerStencil(54, woodPattern, 4); // chainmaille

		PatternBuilder.instance.addToolPattern(woodPattern);

		partRivet = new DynamicToolPart("_rivets", "Rivets");
		GameRegistry.registerItem(partRivet, "RivetPart");

		partClasp = new DynamicToolPart("_clasp", "Clasp");
		GameRegistry.registerItem(partClasp, "ClaspPart");

		partArmorplate = new DynamicToolPart("_armorplate", "Armor Plate");
		GameRegistry.registerItem(partArmorplate, "ArmorPlatePart");

		partCloth = new Cloth().setUnlocalizedName("TD.Cloth");
		GameRegistry.registerItem(partCloth, "clothPart");

		partChainmaille = new DynamicToolPart("_chainmaille", "Chainmaille");
		GameRegistry.registerItem(partChainmaille, "chainmaillePart");

		buildParts(partRivet, 0);
		buildParts(partClasp, 1);
		buildParts(partArmorplate, 2);
		//buildParts(partCloth, 3);
		buildParts(partChainmaille, 4);

		

		PatternBuilder pb = PatternBuilder.instance;

		TConstructClientRegistry.toolButtons.add(new ToolGuiElement(1, 0, 0, new int[] {9, 0, 4, 0}, new int[] {2, 3, 2, 0}, StatCollector.translateToLocal("gui.toolstation.roundshield.name"), StatCollector.translateToLocal("gui.toolstation.roundshield.desc"), "tinkersdefense", "textures/gui/icons.png"));

		ToolGuiElement button2 = new ToolGuiElement(5, 0, 0, new int[] {9, 8, 9, 9}, new int[] {2, 3, 2, 3}, StatCollector.translateToLocal("gui.toolstation.heatershield.name"), StatCollector.translateToLocal("gui.toolstation.heatershield.desc"), "tinkersdefense:", "textures/gui/icons.png");
		TConstructClientRegistry.tierTwoButtons.add(button2);

		TConstructClientRegistry.stencilButtons2.add(new StencilGuiElement(0, 0, 50, "tinkersdefense", "textures/gui/icons.png"));
		TConstructClientRegistry.stencilButtons2.add(new StencilGuiElement(0, 0, 51, "tinkersdefense", "textures/gui/icons.png"));
		TConstructClientRegistry.stencilButtons2.add(new StencilGuiElement(0, 0, 52, "tinkersdefense", "textures/gui/icons.png"));
		TConstructClientRegistry.stencilButtons2.add(new StencilGuiElement(0, 0, 53, "tinkersdefense", "textures/gui/icons.png"));
		TConstructClientRegistry.stencilButtons2.add(new StencilGuiElement(0, 0, 54, "tinkersdefense", "textures/gui/icons.png"));

		// Aeonsteel
		pb.registerMaterialSet("aeonsteel", new ItemStack(TinkerTools.toolShard, 1, 10), new ItemStack(TinkerTools.toolRod, 1, 10), config.AeonsteelMatID);

		TConstructClientRegistry.addMaterialRenderMapping(config.AeonsteelMatID, "tinker", "aeonsteel", true);

		// Tool Materials: id, name, harvestlevel, durability, speed, damage,
		// handlemodifier, reinforced, shoddy, style color, primary color for
		// block use
		TConstructRegistry.addToolMaterial(config.AeonsteelMatID, "AeonSteel", 4, 822, 1100, 3, 1.6F, 2, 0f, LIGHT_PURPLE.toString(), 0xb565e6);
		TinkerTools.registerPatternMaterial("AeonSteelIngot", 2, "AeonSteel");
		TConstructRegistry.addDefaultToolPartMaterial(config.AeonsteelMatID);

		Smeltery.addMelting(new ItemStack(item_AeonSteelIngot, 1, 0), block_AeonSteelBlock, 0, 500, new FluidStack(moltenAeonsteel, TConstruct.ingotLiquidValue));
		Smeltery.addMelting(block_AeonSteelBlock, 0, 500, new FluidStack(moltenAeonsteel, TConstruct.ingotLiquidValue * 9));

		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(item_AeonSteelIngot, 1, 0), new FluidStack(moltenAeonsteel, TConstruct.ingotLiquidValue), TConstructRegistry.getItemStack("ingotCast"), false, 50);

		TConstructRegistry.instance.getBasinCasting().addCastingRecipe(new ItemStack(block_AeonSteelBlock, 1, 0), new FluidStack(moltenAeonsteel, TConstruct.ingotLiquidValue * 9), 100);

		castMolten(moltenAeonsteel, config.AeonsteelMatID);

		PatternBuilder.instance.registerFullMaterial(new ItemStack(item_AeonSteelIngot, 1, 0), 2, "Aeonsteel", new ItemStack(TinkerTools.toolShard, 1, config.AeonsteelMatID), new ItemStack(TinkerTools.toolRod, 1, config.AeonsteelMatID), config.AeonsteelMatID);

		Smeltery.addAlloyMixing(new FluidStack(moltenAeonsteel, 144), new FluidStack[] {new FluidStack(TinkerSmeltery.moltenAlumiteFluid, 144), new FluidStack(TinkerSmeltery.moltenCobaltFluid, 144)});

		// Queen's Gold
		pb.registerMaterialSet("queensgold", new ItemStack(TinkerTools.toolShard, 1, 10), new ItemStack(TinkerTools.toolRod, 1, 10), config.QueensGoldMatID);

		TConstructClientRegistry.addMaterialRenderMapping(config.QueensGoldMatID, "tinker", "queensgold", true);
		TConstructRegistry.addToolMaterial(config.QueensGoldMatID, "QueensGold", 3, 100, 500, 2, 1.0F, 0, 0f, GOLD.toString(), 0xeaee57);
		TinkerTools.registerPatternMaterial("QueensGoldIngot", 2, "QueensGold");
		TConstructRegistry.addDefaultToolPartMaterial(config.QueensGoldMatID);

		Smeltery.addMelting(new ItemStack(item_QueensGoldIngot, 1, 0), block_QueensGoldBlock, 0, 500, new FluidStack(moltenQueensGold, TConstruct.ingotLiquidValue));
		Smeltery.addMelting(block_QueensGoldBlock, 0, 500, new FluidStack(moltenQueensGold, TConstruct.ingotLiquidValue * 9));

		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(item_QueensGoldIngot, 1, 0), new FluidStack(moltenQueensGold, TConstruct.ingotLiquidValue), TConstructRegistry.getItemStack("ingotCast"), false, 50);

		TConstructRegistry.instance.getBasinCasting().addCastingRecipe(new ItemStack(block_QueensGoldBlock, 1, 0), new FluidStack(moltenQueensGold, TConstruct.ingotLiquidValue * 9), 100);

		castMolten(moltenQueensGold, config.QueensGoldMatID);

		PatternBuilder.instance.registerFullMaterial(new ItemStack(item_QueensGoldIngot, 1, 0), 2, "QueensGold", new ItemStack(TinkerTools.toolShard, 1, config.QueensGoldMatID), new ItemStack(TinkerTools.toolRod, 1, config.QueensGoldMatID), config.QueensGoldMatID);

		Smeltery.addAlloyMixing(new FluidStack(moltenQueensGold, 144 * 8), new FluidStack[] {new FluidStack(TinkerSmeltery.moltenGoldFluid, 144 * 8), new FluidStack(TinkerSmeltery.moltenEmeraldFluid, 80)});

		// Dogbearium
		pb.registerMaterialSet("dogbearium", new ItemStack(TinkerTools.toolShard, 1, 10), new ItemStack(TinkerTools.toolRod, 1, 10), config.DogbeariumMatID);

		TConstructClientRegistry.addMaterialRenderMapping(config.DogbeariumMatID, "tinker", "dogbearium", true);
		TConstructRegistry.addToolMaterial(config.DogbeariumMatID, "Dogbearium", 4, 600, 800, 2, 1.6F, 0, -2f, DARK_RED.toString(), 0x754200);
		TinkerTools.registerPatternMaterial("DogbeariumIngot", 2, "Dogbearium");
		TConstructRegistry.addDefaultToolPartMaterial(config.DogbeariumMatID);

		Smeltery.addMelting(new ItemStack(item_DogbeariumIngot, 1, 0), block_DogbeariumBlock, 0, 500, new FluidStack(moltenDogbearium, TConstruct.ingotLiquidValue));
		Smeltery.addMelting(block_DogbeariumBlock, 0, 500, new FluidStack(moltenDogbearium, TConstruct.ingotLiquidValue * 9));

		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(item_DogbeariumIngot, 1, 0), new FluidStack(moltenDogbearium, TConstruct.ingotLiquidValue), TConstructRegistry.getItemStack("ingotCast"), false, 50);

		TConstructRegistry.instance.getBasinCasting().addCastingRecipe(new ItemStack(block_DogbeariumBlock, 1, 0), new FluidStack(moltenDogbearium, TConstruct.ingotLiquidValue * 9), 100);

		castMolten(moltenDogbearium, config.DogbeariumMatID);

		PatternBuilder.instance.registerFullMaterial(new ItemStack(item_DogbeariumIngot, 1, 0), 2, "Dogbearium", new ItemStack(TinkerTools.toolShard, 1, config.DogbeariumMatID), new ItemStack(TinkerTools.toolRod, 1, config.DogbeariumMatID), config.DogbeariumMatID);

		Smeltery.addAlloyMixing(new FluidStack(moltenDogbearium, 144 * 2), new FluidStack[] {new FluidStack(TinkerSmeltery.moltenArditeFluid, 144), new FluidStack(TinkerSmeltery.bloodFluid, 160), new FluidStack(TinkerSmeltery.moltenEnderFluid, 250)});

		//Red Mint
		pb.registerMaterialSet("RedMint", new ItemStack(TinkerTools.toolShard, 1, 10), new ItemStack(TinkerTools.toolRod, 1, 10), config.RedMintMatID);

		TConstructClientRegistry.addMaterialRenderMapping(config.RedMintMatID, "tinker", "RedMint", true);
		TConstructRegistry.addToolMaterial(config.RedMintMatID, "RedMint", 1, 50, 10, 0, 0F, 0, 0f, DARK_RED.toString(), 0xFF0000);
		TinkerTools.registerPatternMaterial("RedMintIngot", 2, "RedMint");
		TConstructRegistry.addDefaultToolPartMaterial(config.RedMintMatID);

		Smeltery.addMelting(new ItemStack(item_RedMintcane, 1, 0), block_RedMintBlock, 0, 250, new FluidStack(moltenRedMint, TConstruct.chunkLiquidValue));
		Smeltery.addMelting(new ItemStack(item_RedMintIngot, 1, 0), block_RedMintBlock, 0, 500, new FluidStack(moltenRedMint, TConstruct.ingotLiquidValue));
		Smeltery.addMelting(block_RedMintBlock, 0, 500, new FluidStack(moltenRedMint, TConstruct.ingotLiquidValue * 9));

		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(item_RedMintIngot, 1, 0), new FluidStack(moltenRedMint, TConstruct.ingotLiquidValue), TConstructRegistry.getItemStack("ingotCast"), false, 50);

		TConstructRegistry.instance.getBasinCasting().addCastingRecipe(new ItemStack(block_RedMintBlock, 1, 0), new FluidStack(moltenRedMint, TConstruct.ingotLiquidValue * 9), 100);

		castMolten(moltenRedMint, config.RedMintMatID);

		PatternBuilder.instance.registerFullMaterial(new ItemStack(item_RedMintcane, 1, 0), 2, "RedMint", new ItemStack(TinkerTools.toolShard, 1, config.RedMintMatID), new ItemStack(TinkerTools.toolRod, 1, config.RedMintMatID), config.RedMintMatID);

		//Green Mint
		pb.registerMaterialSet("GreenMint", new ItemStack(TinkerTools.toolShard, 1, 10), new ItemStack(TinkerTools.toolRod, 1, 10), config.GreenMintMatID);

		TConstructClientRegistry.addMaterialRenderMapping(config.GreenMintMatID, "tinker", "GreenMint", true);
		TConstructRegistry.addToolMaterial(config.GreenMintMatID, "GreenMint", 1, 50, 10, 0, 0F, 0, 0f, DARK_RED.toString(), 0x5bde4b);
		TinkerTools.registerPatternMaterial("GreenMintIngot", 2, "GreenMint");
		TConstructRegistry.addDefaultToolPartMaterial(config.GreenMintMatID);

		Smeltery.addMelting(new ItemStack(item_GreenMintcane, 1, 0), block_GreenMintBlock, 0, 250, new FluidStack(moltenGreenMint, TConstruct.chunkLiquidValue));
		Smeltery.addMelting(new ItemStack(item_GreenMintIngot, 1, 0), block_GreenMintBlock, 0, 500, new FluidStack(moltenGreenMint, TConstruct.ingotLiquidValue));
		Smeltery.addMelting(block_GreenMintBlock, 0, 500, new FluidStack(moltenGreenMint, TConstruct.ingotLiquidValue * 9));

		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(item_GreenMintIngot, 1, 0), new FluidStack(moltenGreenMint, TConstruct.ingotLiquidValue), TConstructRegistry.getItemStack("ingotCast"), false, 50);

		TConstructRegistry.instance.getBasinCasting().addCastingRecipe(new ItemStack(block_GreenMintBlock, 1, 0), new FluidStack(moltenGreenMint, TConstruct.ingotLiquidValue * 9), 100);

		castMolten(moltenGreenMint, config.GreenMintMatID);

		PatternBuilder.instance.registerFullMaterial(new ItemStack(item_GreenMintcane, 1, 0), 2, "GreenMint", new ItemStack(TinkerTools.toolShard, 1, config.GreenMintMatID), new ItemStack(TinkerTools.toolRod, 1, config.GreenMintMatID), config.GreenMintMatID);

		//Cloth
		TConstructRegistry.addCustomMaterial(new ClothMaterial(0, 2, new ItemStack(Blocks.wool, 1, 0), new ItemStack(TinkersDefense.partCloth, 1, 0), 0xffffff));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(1, 2, new ItemStack(Blocks.wool, 1, 1), new ItemStack(TinkersDefense.partCloth, 1, 1), 0xe08c54));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(2, 2, new ItemStack(Blocks.wool, 1, 2), new ItemStack(TinkersDefense.partCloth, 1, 2), 0xc16bc9));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(3, 2, new ItemStack(Blocks.wool, 1, 3), new ItemStack(TinkersDefense.partCloth, 1, 3), 0x8ba4d6));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(4, 2, new ItemStack(Blocks.wool, 1, 4), new ItemStack(TinkersDefense.partCloth, 1, 4), 0xcfc231));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(5, 2, new ItemStack(Blocks.wool, 1, 5), new ItemStack(TinkersDefense.partCloth, 1, 5), 0x50c447));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(6, 2, new ItemStack(Blocks.wool, 1, 6), new ItemStack(TinkersDefense.partCloth, 1, 6), 0xdea5b3));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(7, 2, new ItemStack(Blocks.wool, 1, 7), new ItemStack(TinkersDefense.partCloth, 1, 7), 0x494949));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(8, 2, new ItemStack(Blocks.wool, 1, 8), new ItemStack(TinkersDefense.partCloth, 1, 8), 0xb6baba));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(9, 2, new ItemStack(Blocks.wool, 1, 9), new ItemStack(TinkersDefense.partCloth, 1, 9), 0x3782a1));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(10, 2, new ItemStack(Blocks.wool, 1, 10), new ItemStack(TinkersDefense.partCloth, 1, 10), 0x9453c9));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(11, 2, new ItemStack(Blocks.wool, 1, 11), new ItemStack(TinkersDefense.partCloth, 1, 11), 0x3543a6));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(12, 2, new ItemStack(Blocks.wool, 1, 12), new ItemStack(TinkersDefense.partCloth, 1, 12), 0x5c3a24));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(13, 2, new ItemStack(Blocks.wool, 1, 13), new ItemStack(TinkersDefense.partCloth, 1, 13), 0x3e5420));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(14, 2, new ItemStack(Blocks.wool, 1, 14), new ItemStack(TinkersDefense.partCloth, 1, 14), 0xb03e38));
		TConstructRegistry.addCustomMaterial(new ClothMaterial(15, 2, new ItemStack(Blocks.wool, 1, 15), new ItemStack(TinkersDefense.partCloth, 1, 15), 0x242222));

		// Shields
		TConstructRegistry.addToolRecipe(tool_roundShield, partArmorplate, TinkerTools.toolRod, TinkerTools.frypanHead);

		TConstructRegistry.addToolRecipe(tool_heaterShield, partArmorplate, TinkerTools.toughRod, partArmorplate, partRivet);

		// Wrench
		TConstructRegistry.addToolRecipe(tool_wrench, TinkerTools.handGuard, TinkerTools.toolRod, TinkerTools.binding);

		TConstructRegistry.addToolRecipe(tool_shears, TinkerTools.knifeBlade, TinkerTools.binding, TinkerTools.knifeBlade);

		//Zweihander
		TConstructRegistry.addToolRecipe(tool_zweihander, TinkerTools.largeSwordBlade, TinkerTools.toughRod, TinkerTools.wideGuard, TinkerTools.swordBlade);

		//Armor
		TConstructRegistry.addToolRecipe(tool_sheath, partArmorplate, TinkerTools.toolRod, partClasp, partCloth);
		//		TConstructRegistry.addToolRecipe(tool_mask, partArmorplate, partCloth, partClasp);

		TConstructRegistry.addToolRecipe(armor_TinkerHelm, TinkerTools.frypanHead, TinkerTools.toughRod, partArmorplate);
		TConstructRegistry.addToolRecipe(armor_TinkerBreastplate, TinkerTools.largePlate, TinkerTools.toughRod, partArmorplate, partChainmaille);
		TConstructRegistry.addToolRecipe(armor_TinkerGrieves, partArmorplate, TinkerTools.toughRod, partChainmaille, partArmorplate);
		TConstructRegistry.addToolRecipe(armor_TinkerSabatons, partArmorplate, TinkerTools.toughRod, partArmorplate, partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerGauntlets, partArmorplate, TinkerTools.toughRod, partRivet);

		TConstructRegistry.addToolRecipe(armor_TinkerRobe, partCloth, partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerShawl, partCloth, partCloth, partClasp);
		TConstructRegistry.addToolRecipe(armor_TinkerHood, partCloth, partCloth, partRivet);
		TConstructRegistry.addToolRecipe(armor_TinkerShoes, partCloth, partClasp, partRivet);

		TConstructRegistry.addToolRecipe(armor_TinkerCoif, partChainmaille, partCloth, TinkerTools.toughRod);
		TConstructRegistry.addToolRecipe(armor_TinkerHalberd, partChainmaille, partArmorplate, partRivet);
		TConstructRegistry.addToolRecipe(armor_TinkerChausses, partChainmaille, partArmorplate);
		TConstructRegistry.addToolRecipe(armor_TinkerBoots, partChainmaille, partCloth, partRivet);

		tcInject = new Injector(0);
		GameRegistry.registerItem(tcInject, "???");
		
		mods.Init();

		//		for(int i = 0; i < TConstructRegistry.tools.size(); i++)
		//		{
		//			if(!(TConstructRegistry.tools.get(i) instanceof Injector))
		//			{
		//				tcInject.add(new Injector(i, TConstructRegistry.tools.get(i), injectLoc));
		//				GameRegistry.registerItem(tcInject.get(i), "debugger_" + TConstructRegistry.tools.get(i).getLocalizedToolName());
		//			}
		//		}

		//AMEvent.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		//		List list = ModifyBuilder.instance.itemModifiers;
		//		list = ModifyBuilder.instance.itemModifiers;
	}

	public void castMolten(Fluid fluid, int ID)
	{
		// .addCastingRecipe(output, fluid, cast, hardeningDelay)
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.toolRod, 1, ID), new FluidStack(fluid, (int) (144 * 0.5D)), TConstructRegistry.getItemStack("toolRodCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.pickaxeHead, 1, ID), new FluidStack(fluid, (int) (144 * 1.0D)), TConstructRegistry.getItemStack("pickaxeHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.shovelHead, 1, ID), new FluidStack(fluid, (int) (144 * 1.0D)), TConstructRegistry.getItemStack("shovelHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.hatchetHead, 1, ID), new FluidStack(fluid, (int) (144 * 1.0D)), TConstructRegistry.getItemStack("hatchetHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.swordBlade, 1, ID), new FluidStack(fluid, (int) (144 * 1.0D)), TConstructRegistry.getItemStack("swordBladeCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.fullGuard, 1, ID), new FluidStack(fluid, (int) (144 * 3.0D)), TConstructRegistry.getItemStack("fullGuardCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.wideGuard, 1, ID), new FluidStack(fluid, (int) (144 * 0.5D)), TConstructRegistry.getItemStack("wideGuardCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.crossbar, 1, ID), new FluidStack(fluid, (int) (144 * 0.5D)), TConstructRegistry.getItemStack("crossbarCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.binding, 1, ID), new FluidStack(fluid, (int) (144 * 0.5D)), TConstructRegistry.getItemStack("bindingCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.handGuard, 1, ID), new FluidStack(fluid, (int) (144 * 0.5D)), TConstructRegistry.getItemStack("handGuardCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.frypanHead, 1, ID), new FluidStack(fluid, (int) (144 * 1.0D)), TConstructRegistry.getItemStack("frypanHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.signHead, 1, ID), new FluidStack(fluid, (int) (144 * 1.0D)), TConstructRegistry.getItemStack("signHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.knifeBlade, 1, ID), new FluidStack(fluid, (int) (144 * 0.5D)), TConstructRegistry.getItemStack("knifeBladeCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.chiselHead, 1, ID), new FluidStack(fluid, (int) (144 * 0.5D)), TConstructRegistry.getItemStack("chiselHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.toughRod, 1, ID), new FluidStack(fluid, (int) (144 * 3.0D)), TConstructRegistry.getItemStack("toughRodCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.toughBinding, 1, ID), new FluidStack(fluid, (int) (144 * 3.0D)), TConstructRegistry.getItemStack("toughBindingCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.largePlate, 1, ID), new FluidStack(fluid, (int) (144 * 8.0D)), TConstructRegistry.getItemStack("largePlateCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.broadAxeHead, 1, ID), new FluidStack(fluid, (int) (144 * 8.0D)), TConstructRegistry.getItemStack("broadAxeHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.scytheBlade, 1, ID), new FluidStack(fluid, (int) (144 * 8.0D)), TConstructRegistry.getItemStack("scytheHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.excavatorHead, 1, ID), new FluidStack(fluid, (int) (144 * 8.0D)), TConstructRegistry.getItemStack("excavatorHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.largeSwordBlade, 1, ID), new FluidStack(fluid, (int) (144 * 8.0D)), TConstructRegistry.getItemStack("largeBladeCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.hammerHead, 1, ID), new FluidStack(fluid, (int) (144 * 8.0D)), TConstructRegistry.getItemStack("hammerHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.arrowhead, 1, ID), new FluidStack(fluid, (int) (144 * 1.0D)), TConstructRegistry.getItemStack("arrowheadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(partArmorplate, 1, ID), new FluidStack(fluid, (int) (144 * 4.0D)), new ItemStack(metalPattern, 1, 2), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(partRivet, 1, ID), new FluidStack(fluid, (int) (144 * 0.5D)), new ItemStack(metalPattern, 1, 0), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(partClasp, 1, ID), new FluidStack(fluid, (int) (144 * 1.0D)), new ItemStack(metalPattern, 1, 1), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(partChainmaille, 1, ID), new FluidStack(fluid, (int) (144 * 4.0D)), new ItemStack(metalPattern, 1, 3), 50);
	}

	public void buildParts(Item item, int meta)
	{
		int[] nonMetals = {0, 1, 3, 4, 5, 6, 7, 8, 9, 17};
		int[] liquidDamage = new int[] {2, 13, 10, 11, 12, 14, 15, 6, 16, 18};

		for(int mat = 0; mat < nonMetals.length; mat++)
		{
			TConstructRegistry.addPartMapping(woodPattern, meta, mat, new ItemStack(item, 1, mat));
		}

		LiquidCasting tableCasting = TConstructRegistry.getTableCasting();
		// patternOutputs = new Item[] { partShuriken, partCrossbowLimb,
		// partCrossbowBody, partBowLimb };

		ItemStack cast = new ItemStack(metalPattern, 1, meta);

		tableCasting.addCastingRecipe(cast, new FluidStack(TinkerSmeltery.moltenAlubrassFluid, TConstruct.ingotLiquidValue), new ItemStack(item, 1, Short.MAX_VALUE), false, 50);
		tableCasting.addCastingRecipe(cast, new FluidStack(TinkerSmeltery.moltenGoldFluid, TConstruct.ingotLiquidValue * 2), new ItemStack(item, 1, Short.MAX_VALUE), false, 50);

		for(int iterTwo = 0; iterTwo < TinkerSmeltery.liquids.length; iterTwo++)
		{
			Fluid fs = TinkerSmeltery.liquids[iterTwo].getFluid();
			int fluidAmount = metalPattern.getPatternCost(cast) * TConstruct.ingotLiquidValue / 2;
			ItemStack metalCast = new ItemStack(item, 1, liquidDamage[iterTwo]);
			tableCasting.addCastingRecipe(metalCast, new FluidStack(fs, fluidAmount), cast, 50);
			Smeltery.addMelting(FluidType.getFluidType(fs), metalCast, 0, fluidAmount);
		}
	}

	public static int[] hexToRGB(String hex)
	{
		int color[] = new int[3];

		color[0] = Integer.parseInt(hex.substring(0, 2), 16);
		color[1] = Integer.parseInt(hex.substring(2, 4), 16);
		color[2] = Integer.parseInt(hex.substring(4, 6), 16);

		return color;
	}

}
