package lance5057.tDefense;

import static net.minecraft.util.EnumChatFormatting.DARK_RED;
import static net.minecraft.util.EnumChatFormatting.GOLD;
import static net.minecraft.util.EnumChatFormatting.LIGHT_PURPLE;
import lance5057.tDefense.armor.items.ChainArmor;
import lance5057.tDefense.armor.items.ClothArmor;
import lance5057.tDefense.armor.items.Sheath;
import lance5057.tDefense.armor.items.TinkerArmor;
import lance5057.tDefense.armor.parts.Item_Cloth;
import lance5057.tDefense.armor.parts.Item_Glowthread;
import lance5057.tDefense.armor.parts.Item_Thread;
import lance5057.tDefense.blocks.JewelersBench;
import lance5057.tDefense.core.Injector;
import lance5057.tDefense.core.TD_Patterns;
import lance5057.tDefense.core.blocks.AeonSteelBlock;
import lance5057.tDefense.core.blocks.DogbeariumBlock;
import lance5057.tDefense.core.blocks.QueensGoldBlock;
import lance5057.tDefense.core.blocks.crestMount.CrestMount;
import lance5057.tDefense.core.blocks.crestMount.TileEntity_CrestMount;
import lance5057.tDefense.core.events.TDEventHandler;
import lance5057.tDefense.core.liquids.moltenAeonsteelFluid;
import lance5057.tDefense.core.liquids.moltenDogbeariumFluid;
import lance5057.tDefense.core.liquids.moltenQueensGoldFluid;
import lance5057.tDefense.core.network.PacketHandler;
import lance5057.tDefense.core.tools.HeaterShield;
import lance5057.tDefense.core.tools.RoundShield;
import lance5057.tDefense.core.tools.TinkerWrench;
import lance5057.tDefense.core.tools.TinkerZweihander;
import lance5057.tDefense.core.tools.modifiers.TDefenseActiveToolMod;
import lance5057.tDefense.core.tools.modifiers.modifierDaze;
import lance5057.tDefense.core.tools.modifiers.shields.modifierCrestofBlades;
import lance5057.tDefense.core.tools.modifiers.shields.modifierCrestofFeathers;
import lance5057.tDefense.core.tools.modifiers.shields.modifierCrestofLegends;
import lance5057.tDefense.core.tools.modifiers.shields.modifierCrestofMirrors;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.FinishingAnvil;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.TileEntity_FinishingAnvil;
import lance5057.tDefense.proxy.CommonProxy;
import lance5057.tDefense.tileentities.TileEntity_JewelersBench;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.client.ToolGuiElement;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.LiquidCasting;
import tconstruct.library.crafting.ModifyBuilder;
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
public class TinkersDefense {

	private static int modGuiIndex = 0;
	public static final int GUI_CREST_INV = modGuiIndex++;
	public static final int GUI_ANVIL_INV = modGuiIndex++;

	@Instance(Reference.MOD_ID)
	public static TinkersDefense instance = new TinkersDefense();

	public static CreativeTabs tabName = new CreativeTabs("tabName") {

		public Item getTabIconItem() {
	        return TinkersDefense.tabIcon;
		}

	};
	
	public static TDEventHandler TDevents;
	
	public static TD_Config config;

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE
			.newSimpleChannel(Reference.MOD_ID);

	public static Item tabIcon;
	
	public static Item item_AeonSteelIngot;
	public static Block block_AeonSteelBlock;

	public static Fluid moltenAeonsteel;
	public static Block moltenAeonsteelBlock;

	public static Item item_QueensGoldIngot;
	public static Block block_QueensGoldBlock;

	public static Fluid moltenQueensGold;
	public static Block moltenQueensGoldBlock;

	public static Item item_DogbeariumIngot;
	public static Block block_DogbeariumBlock;

	public static Fluid moltenDogbearium;
	public static Block moltenDogbeariumBlock;

	public static ToolCore tool_roundShield;
	public static ToolCore tool_heaterShield;
	public static ToolCore tool_wrench;
	public static ToolCore tool_sheath;
	public static ToolCore tool_zweihander;
	
	public static Block block_CrestMount;
	public static Block block_ArmorAnvil;
	public static Block block_JewelersBench;

	public static Item item_TinkerArmor;
	public static Item item_ChainArmor;
	public static Item item_ClothArmor;
	

	public static Item item_thread;
	public static Item item_glowthread;
	public static Item item_cloth;
	
	public static Item item_relic;

	public static Pattern woodPattern;
	public static Pattern metalPattern;

	public static Item partRivet;
	public static Item partArmorplate;
	public static Item partClasp;
	public static Item partCloth;
	public static Item partChainmaille;
	
	public static Injector tcInject;

	@SidedProxy(clientSide = "lance5057.tDefense.proxy.ClientProxy", serverSide = "lance5057.tDefense.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		PacketHandler.init();
		//TDevents = new TDEventHandler();
		config = new TD_Config(e);
		

		block_CrestMount = new CrestMount().setHardness(4.0F)
				.setStepSound(Block.soundTypeStone).setBlockName("CrestMount")
				.setCreativeTab(tabName);

		GameRegistry.registerBlock(block_CrestMount, "Block_CrestMount");
		GameRegistry.registerTileEntity(TileEntity_CrestMount.class,
				"Tile_CrestMount");

		GameRegistry.addShapedRecipe(new ItemStack(block_CrestMount),
				new Object[] { "xxx", "-i-", "---", 'x',
						new ItemStack(TinkerTools.toughRod, 1, 1), 'i',
						new ItemStack(TinkerTools.toolRod, 1, 1) });

		block_ArmorAnvil = new FinishingAnvil().setHardness(4.0F)
				.setStepSound(Block.soundTypeAnvil).setBlockName("ArmorAnvil")
				.setCreativeTab(tabName);

		GameRegistry.registerBlock(block_ArmorAnvil, "Block_ArmorAnvil");
		GameRegistry.registerTileEntity(TileEntity_FinishingAnvil.class,
				"Tile_ArmorAnvil");

		block_JewelersBench = new JewelersBench().setHardness(4.0F)
				.setStepSound(Block.soundTypeWood)
				.setBlockName("JewelersBench").setCreativeTab(tabName);

		GameRegistry.registerBlock(block_JewelersBench, "Block_JewelersBench");
		GameRegistry.registerTileEntity(TileEntity_JewelersBench.class,
				"Tile_JewelersBench");

		NetworkRegistry.INSTANCE.registerGuiHandler(TinkersDefense.instance,
				new CommonProxy());
		MinecraftForge.EVENT_BUS.register(this);
		
		tabIcon = new Item().setMaxStackSize(1).setCreativeTab(tabName).setUnlocalizedName("tabIcon").setTextureName(Reference.MOD_ID + ":Icon");
		GameRegistry.registerItem(tabIcon, "tabIcon");
		
		item_relic = new Item().setCreativeTab(tabName).setMaxStackSize(1)
				.setUnlocalizedName("AncientRelic")
				.setTextureName(Reference.MOD_ID + ":AncientRelic");
		
		GameRegistry.registerItem(item_relic, "Ancient Relic");
		
		// AeonSteel
		item_AeonSteelIngot = new Item().setCreativeTab(tabName)
				.setMaxStackSize(64).setUnlocalizedName("AeonSteelIngot")
				.setTextureName(Reference.MOD_ID + ":AeonSteelIngot");

		GameRegistry.registerItem(item_AeonSteelIngot, "AeonSteel Ingot");

		block_AeonSteelBlock = new AeonSteelBlock(Material.iron)
				.setHardness(4.0F).setStepSound(Block.soundTypeMetal)
				.setBlockName("AeonSteelBlock").setCreativeTab(tabName)
				.setBlockTextureName(Reference.MOD_ID + ":AeonSteelBlock");

		GameRegistry.registerBlock(block_AeonSteelBlock, "aeonsteelblock");

		GameRegistry.addShapedRecipe(new ItemStack(block_AeonSteelBlock),
				new Object[] { "xxx", "xxx", "xxx", 'x', item_AeonSteelIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(item_AeonSteelIngot, 9),
				new Object[] { new ItemStack(block_AeonSteelBlock) });

		moltenAeonsteel = new Fluid("moltenAeonsteel").setLuminosity(15)
				.setDensity(3000).setViscosity(6000).setTemperature(1300);
		FluidRegistry.registerFluid(moltenAeonsteel);

		moltenAeonsteelFluid moltenAeonsteelBlock = new moltenAeonsteelFluid(
				moltenAeonsteel);

		GameRegistry.registerBlock(moltenAeonsteelBlock, "moltenaeonsteel");

		// Queen's Gold
		item_QueensGoldIngot = new Item().setCreativeTab(tabName)
				.setMaxStackSize(64).setUnlocalizedName("QueensGoldIngot")
				.setTextureName(Reference.MOD_ID + ":QueensGoldIngot");

		GameRegistry.registerItem(item_QueensGoldIngot, "Queen's Gold Ingot");

		block_QueensGoldBlock = new QueensGoldBlock(Material.iron)
				.setHardness(4.0F).setStepSound(Block.soundTypeMetal)
				.setBlockName("QueensGoldBlock").setCreativeTab(tabName)
				.setBlockTextureName(Reference.MOD_ID + ":QueensGoldBlock");

		GameRegistry.registerBlock(block_QueensGoldBlock, "QueensGoldblock");

		GameRegistry
				.addShapedRecipe(new ItemStack(block_QueensGoldBlock),
						new Object[] { "xxx", "xxx", "xxx", 'x',
								item_QueensGoldIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(item_QueensGoldIngot, 9),
				new Object[] { new ItemStack(block_QueensGoldBlock) });

		moltenQueensGold = new Fluid("moltenQueensGold").setLuminosity(15)
				.setDensity(3000).setViscosity(6000).setTemperature(1300);
		FluidRegistry.registerFluid(moltenQueensGold);

		moltenQueensGoldFluid moltenQueensGoldBlock = new moltenQueensGoldFluid(
				moltenQueensGold);

		GameRegistry.registerBlock(moltenQueensGoldBlock, "moltenQueensGold");

		// Dogbearium
		item_DogbeariumIngot = new Item().setCreativeTab(tabName)
				.setMaxStackSize(64).setUnlocalizedName("DogbeariumIngot")
				.setTextureName(Reference.MOD_ID + ":DogbeariumIngot");

		GameRegistry.registerItem(item_DogbeariumIngot, "DogbeariumIngot");

		block_DogbeariumBlock = new DogbeariumBlock(Material.iron)
				.setHardness(4.0F).setStepSound(Block.soundTypeMetal)
				.setBlockName("DogbeariumBlock").setCreativeTab(tabName)
				.setBlockTextureName(Reference.MOD_ID + ":DogbeariumBlock");

		GameRegistry.registerBlock(block_DogbeariumBlock, "Dogbeariumblock");

		GameRegistry
				.addShapedRecipe(new ItemStack(block_DogbeariumBlock),
						new Object[] { "xxx", "xxx", "xxx", 'x',
								item_DogbeariumIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(item_DogbeariumIngot, 9),
				new Object[] { new ItemStack(block_DogbeariumBlock) });

		moltenDogbearium = new Fluid("moltenDogbearium").setLuminosity(15)
				.setDensity(3000).setViscosity(6000).setTemperature(1300);
		FluidRegistry.registerFluid(moltenDogbearium);

		moltenDogbeariumFluid moltenDogbeariumBlock = new moltenDogbeariumFluid(
				moltenDogbearium);

		GameRegistry.registerBlock(moltenDogbeariumBlock, "moltenDogbearium");

		tool_roundShield = new RoundShield();
		tool_heaterShield = new HeaterShield();

		tool_wrench = new TinkerWrench();
		tool_sheath = new Sheath();
		
		tool_zweihander = new TinkerZweihander(0);

		//Register Tools
		GameRegistry.registerItem(tool_roundShield, "Round Shield");
		GameRegistry.registerItem(tool_heaterShield, "Heater Shield");
		GameRegistry.registerItem(tool_wrench, "Tinker Wrench");
		GameRegistry.registerItem(tool_sheath, "Sheath");
		GameRegistry.registerItem(tool_zweihander, "Zweihander");
		
		//Add Tools to TiCo directory
		TConstructRegistry.addItemToDirectory("Round Shield", tool_roundShield);
		TConstructRegistry.addItemToDirectory("Heater Shield", tool_heaterShield);
		TConstructRegistry.addItemToDirectory("Tinker Wrench", tool_wrench);
		TConstructRegistry.addItemToDirectory("Sheath", tool_sheath);
		TConstructRegistry.addItemToDirectory("Zweihander", tool_zweihander);

		//Register Items
		GameRegistry.registerItem(item_thread = new Item_Thread(), "thread");
		GameRegistry.registerItem(item_glowthread = new Item_Glowthread(),
				"glowthread");
		GameRegistry.registerItem(item_cloth = new Item_Cloth(), "cloth");

		woodPattern = new TD_Patterns("pattern_", "Pattern");
		metalPattern = new TD_Patterns("cast_", "MetalPattern");

		GameRegistry.registerItem(woodPattern, "Pattern");
		// TConstructRegistry.addItemToDirectory("woodPattern", woodPattern);

		GameRegistry.registerItem(metalPattern, "Cast");

		TConstructRegistry.addItemStackToDirectory("rivets Pattern",
				new ItemStack(woodPattern, 1, 0));
		TConstructRegistry.addItemStackToDirectory("clasp Pattern",
				new ItemStack(woodPattern, 1, 1));
		TConstructRegistry.addItemStackToDirectory("armorplate Pattern",
				new ItemStack(woodPattern, 1, 2));

		// Renderers
		proxy.registerRenderers();

		 item_TinkerArmor = new TinkerArmor(ArmorMaterial.IRON, 4,
		 1).setUnlocalizedName("Tinker_Armor");
		 GameRegistry.registerItem(item_TinkerArmor,"Tinker Armor");
		 
		 item_ChainArmor = new ChainArmor(ArmorMaterial.IRON, 4,
				 1).setUnlocalizedName("Chain_Armor");
		 GameRegistry.registerItem(item_ChainArmor,"Chain Armor");
		 
		 item_ClothArmor = new ClothArmor(ArmorMaterial.IRON, 4,
				 1).setUnlocalizedName("Cloth_Armor");
				 GameRegistry.registerItem(item_ClothArmor,"Cloth Armor");
		
		//tool_Sheath = new Sheath().setUnlocalizedName("Sheath");
		

		// network.registerMessage(messageHandler, requestMessageType,
		// discriminator, side);
		

	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		System.out.print(Reference.MOD_ID);
		
		StencilBuilder.registerStencil(50, woodPattern, 0); // rivets
		StencilBuilder.registerStencil(51, woodPattern, 1); // clasp
		StencilBuilder.registerStencil(52, woodPattern, 2); // armorplate
		StencilBuilder.registerStencil(53, woodPattern, 3); // cloth
		StencilBuilder.registerStencil(54, woodPattern, 4);	// chainmaille

		PatternBuilder.instance.addToolPattern(woodPattern);

		partRivet = new DynamicToolPart("_rivets", "Rivets");
		GameRegistry.registerItem(partRivet, "RivetPart");
		
		partClasp = new DynamicToolPart("_clasp", "Clasp");
		GameRegistry.registerItem(partClasp, "ClaspPart");

		partArmorplate = new DynamicToolPart("_armorplate", "Armor Plate");
		GameRegistry.registerItem(partArmorplate, "ArmorPlatePart");
		
		partCloth = new DynamicToolPart("_cloth", "Cloth");
		GameRegistry.registerItem(partCloth, "clothPart");

		partChainmaille = new DynamicToolPart("_chainmaille", "Chainmaille");
		GameRegistry.registerItem(partChainmaille, "chainmaillePart");
		
		buildParts(partRivet, 0);
		buildParts(partClasp, 1);
		buildParts(partArmorplate, 2);
		buildParts(partCloth, 3);
		buildParts(partChainmaille, 4);
		
		PatternBuilder pb = PatternBuilder.instance;
		
		ModifyBuilder.registerModifier(new modifierDaze("Daze", config.DazeID, new ItemStack[] { new ItemStack(Blocks.light_weighted_pressure_plate), new ItemStack(Items.potionitem,1,8202)},
				new int[] {1,0}));
		
		ModifyBuilder.registerModifier(new modifierCrestofFeathers("Crest of Feathers", config.CrestFeathersID, new ItemStack[] { new ItemStack(Items.feather)},
				new int[] {1}));
		
		ModifyBuilder.registerModifier(new modifierCrestofMirrors("Crest of Mirrors", config.CrestMirrorsID, new ItemStack[] { new ItemStack(Blocks.glass_pane)},
				new int[] {1}));
		
		ModifyBuilder.registerModifier(new modifierCrestofLegends("Crest of Legends", config.CrestLegendsID, new ItemStack[] { new ItemStack(item_relic)},
				new int[] {1}));
		
		ModifyBuilder.registerModifier(new modifierCrestofBlades("Crest of Blades", config.CrestBladesID, new ItemStack[] { new ItemStack(Items.iron_sword)},new int[] {1}));
		
		TConstructRegistry.registerActiveToolMod(new TDefenseActiveToolMod());
		
		for (ToolCore tool : TConstructRegistry.getToolMapping())
        {
			TConstructClientRegistry.addEffectRenderMapping(tool, config.DazeID, "tinker", "daze", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, config.CrestFeathersID, "tinker", "feathers", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, config.CrestMirrorsID, "tinker", "mirrors", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, config.CrestLegendsID, "tinker", "legends", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, config.CrestBladesID, "tinker", "blades", true);
        }

		
		TConstructClientRegistry.toolButtons
				.add(TConstructClientRegistry.toolButtons.size(),
						new ToolGuiElement(
								1,
								0,
								0,
								new int[] { 9, 0, 4, 0 },
								new int[] { 2, 3, 2, 0 },
								StatCollector
										.translateToLocal("gui.toolstation.roundshield.name"),
								StatCollector
										.translateToLocal("gui.toolstation.roundshield.desc"),
								"tinkersdefense", "textures/gui/icons.png"));
		TConstructClientRegistry.tierTwoButtons
				.add(TConstructClientRegistry.tierTwoButtons.size(),
						new ToolGuiElement(
								5,
								0,
								0,
								new int[] { 9, 8, 9, 9 },
								new int[] { 2, 3, 2, 3 },
								StatCollector
										.translateToLocal("gui.toolstation.heatershield.name"),
								StatCollector
										.translateToLocal("gui.toolstation.heatershield.desc"),
								"tinkersdefense", "textures/gui/icons.png"));
		
		

		// Aeonsteel
		pb.registerMaterialSet("aeonsteel", new ItemStack(
				TinkerTools.toolShard, 1, 10), new ItemStack(
				TinkerTools.toolRod, 1, 10), config.AeonsteelMatID);

		TConstructClientRegistry.addMaterialRenderMapping(config.AeonsteelMatID, "tinker",
				"aeonsteel", true);

		// Tool Materials: id, name, harvestlevel, durability, speed, damage,
		// handlemodifier, reinforced, shoddy, style color, primary color for
		// block use
		TConstructRegistry.addToolMaterial(config.AeonsteelMatID, "AeonSteel", 4, 822, 1100, 3,
				1.6F, 2, 0f, LIGHT_PURPLE.toString(), 0xb565e6);
		TinkerTools.registerPatternMaterial("AeonSteelIngot", 2, "AeonSteel");
		TConstructRegistry.addDefaultToolPartMaterial(config.AeonsteelMatID);

		Smeltery.addMelting(new ItemStack(item_AeonSteelIngot, 1, 0),
				block_AeonSteelBlock, 0, 500, new FluidStack(moltenAeonsteel,
						TConstruct.ingotLiquidValue));
		Smeltery.addMelting(block_AeonSteelBlock, 0, 500, new FluidStack(
				moltenAeonsteel, TConstruct.ingotLiquidValue * 9));

		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(item_AeonSteelIngot, 1, 0),
				new FluidStack(moltenAeonsteel, TConstruct.ingotLiquidValue),
				TConstructRegistry.getItemStack("ingotCast"), false, 50);

		TConstructRegistry.instance.getBasinCasting()
				.addCastingRecipe(
						new ItemStack(block_AeonSteelBlock, 1, 0),
						new FluidStack(moltenAeonsteel,
								TConstruct.ingotLiquidValue * 9), 100);

		castMolten(moltenAeonsteel, config.AeonsteelMatID);

		PatternBuilder.instance.registerFullMaterial(new ItemStack(
				item_AeonSteelIngot, 1, 0), 2, "Aeonsteel", new ItemStack(
				TinkerTools.toolShard, 1, config.AeonsteelMatID), new ItemStack(
				TinkerTools.toolRod, 1, config.AeonsteelMatID), config.AeonsteelMatID);

		Smeltery.addAlloyMixing(new FluidStack(moltenAeonsteel, 144),
				new FluidStack[] {
						new FluidStack(TinkerSmeltery.moltenAlumiteFluid, 144),
						new FluidStack(TinkerSmeltery.moltenCobaltFluid, 144) });
		
		
		// Queen's Gold
		pb.registerMaterialSet("queensgold", new ItemStack(
				TinkerTools.toolShard, 1, 10), new ItemStack(
				TinkerTools.toolRod, 1, 10), config.QueensGoldMatID);
		
		TConstructClientRegistry.addMaterialRenderMapping(config.QueensGoldMatID, "tinker",
				"queensgold", true);
		TConstructRegistry.addToolMaterial(config.QueensGoldMatID, "QueensGold", 3, 100, 500, 2,
				1.0F, 0, 0f, GOLD.toString(), 0xeaee57);
		TinkerTools.registerPatternMaterial("QueensGoldIngot", 2, "QueensGold");
		TConstructRegistry.addDefaultToolPartMaterial(config.QueensGoldMatID);

		Smeltery.addMelting(new ItemStack(item_QueensGoldIngot, 1, 0),
				block_QueensGoldBlock, 0, 500, new FluidStack(moltenQueensGold,
						TConstruct.ingotLiquidValue));
		Smeltery.addMelting(block_QueensGoldBlock, 0, 500, new FluidStack(
				moltenQueensGold, TConstruct.ingotLiquidValue * 9));

		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(item_QueensGoldIngot, 1, 0),
				new FluidStack(moltenQueensGold, TConstruct.ingotLiquidValue),
				TConstructRegistry.getItemStack("ingotCast"), false, 50);

		TConstructRegistry.instance.getBasinCasting().addCastingRecipe(
				new ItemStack(block_QueensGoldBlock, 1, 0),
				new FluidStack(moltenQueensGold,
						TConstruct.ingotLiquidValue * 9), 100);

		castMolten(moltenQueensGold, config.QueensGoldMatID);

		PatternBuilder.instance.registerFullMaterial(new ItemStack(
				item_QueensGoldIngot, 1, 0), 2, "QueensGold", new ItemStack(
				TinkerTools.toolShard, 1, config.QueensGoldMatID), new ItemStack(
				TinkerTools.toolRod, 1, config.QueensGoldMatID), config.QueensGoldMatID);

		Smeltery.addAlloyMixing(
				new FluidStack(moltenQueensGold, 144 * 8),
				new FluidStack[] {
						new FluidStack(TinkerSmeltery.moltenGoldFluid, 144 * 8),
						new FluidStack(TinkerSmeltery.moltenEmeraldFluid, 80) });

		// Dogbearium
		pb.registerMaterialSet("dogbearium", new ItemStack(
				TinkerTools.toolShard, 1, 10), new ItemStack(
				TinkerTools.toolRod, 1, 10), config.DogbeariumMatID);
		
		TConstructClientRegistry.addMaterialRenderMapping(config.DogbeariumMatID, "tinker",
				"dogbearium", true);
		TConstructRegistry.addToolMaterial(config.DogbeariumMatID, "Dogbearium", 4, 600, 800, 2,
				1.6F, 0, -2f, DARK_RED.toString(), 0x754200);
		TinkerTools.registerPatternMaterial("DogbeariumIngot", 2, "Dogbearium");
		TConstructRegistry.addDefaultToolPartMaterial(config.DogbeariumMatID);

		Smeltery.addMelting(new ItemStack(item_DogbeariumIngot, 1, 0),
				block_DogbeariumBlock, 0, 500, new FluidStack(moltenDogbearium,
						TConstruct.ingotLiquidValue));
		Smeltery.addMelting(block_DogbeariumBlock, 0, 500, new FluidStack(
				moltenDogbearium, TConstruct.ingotLiquidValue * 9));

		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(item_DogbeariumIngot, 1, 0),
				new FluidStack(moltenDogbearium, TConstruct.ingotLiquidValue),
				TConstructRegistry.getItemStack("ingotCast"), false, 50);

		TConstructRegistry.instance.getBasinCasting().addCastingRecipe(
				new ItemStack(block_DogbeariumBlock, 1, 0),
				new FluidStack(moltenDogbearium,
						TConstruct.ingotLiquidValue * 9), 100);

		castMolten(moltenDogbearium, config.DogbeariumMatID);

		PatternBuilder.instance.registerFullMaterial(new ItemStack(
				item_DogbeariumIngot, 1, 0), 2, "Dogbearium", new ItemStack(
				TinkerTools.toolShard, 1, config.DogbeariumMatID), new ItemStack(
				TinkerTools.toolRod, 1, config.DogbeariumMatID), config.DogbeariumMatID);

		Smeltery.addAlloyMixing(new FluidStack(moltenDogbearium, 144 * 2),
				new FluidStack[] {
						new FluidStack(TinkerSmeltery.moltenArditeFluid, 144),
						new FluidStack(TinkerSmeltery.bloodFluid, 160),
						new FluidStack(TinkerSmeltery.moltenEnderFluid, 250) });

		// Shields
		TConstructRegistry.addToolRecipe(tool_roundShield,
				partArmorplate, TinkerTools.toolRod,
				TinkerTools.frypanHead);

		TConstructRegistry.addToolRecipe(tool_heaterShield,
				partArmorplate, TinkerTools.toughRod,
				partArmorplate, partRivet);

		// Wrench
		TConstructRegistry.addToolRecipe(tool_wrench, TinkerTools.handGuard,
				TinkerTools.toolRod, TinkerTools.binding);
		
		//Zweihander
		TConstructRegistry.addToolRecipe(tool_zweihander, TinkerTools.largeSwordBlade,
				TinkerTools.toughRod, TinkerTools.wideGuard, TinkerTools.swordBlade);
		
		//Armor
		TConstructRegistry.addToolRecipe(tool_sheath, partArmorplate,TinkerTools.toolRod, partCloth, partClasp);

		tcInject = new Injector(0,TinkerTools.broadsword);
		GameRegistry.registerItem(tcInject, "debugger");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

	public void castMolten(Fluid fluid, int ID) {
		// .addCastingRecipe(output, fluid, cast, hardeningDelay)
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.toolRod, 1, ID),
				new FluidStack(fluid, (int) (144 * 0.5D)),
				TConstructRegistry.getItemStack("toolRodCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.pickaxeHead, 1, ID),
				new FluidStack(fluid, (int) (144 * 1.0D)),
				TConstructRegistry.getItemStack("pickaxeHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.shovelHead, 1, ID),
				new FluidStack(fluid, (int) (144 * 1.0D)),
				TConstructRegistry.getItemStack("shovelHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.hatchetHead, 1, ID),
				new FluidStack(fluid, (int) (144 * 1.0D)),
				TConstructRegistry.getItemStack("hatchetHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.swordBlade, 1, ID),
				new FluidStack(fluid, (int) (144 * 1.0D)),
				TConstructRegistry.getItemStack("swordBladeCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.fullGuard, 1, ID),
				new FluidStack(fluid, (int) (144 * 3.0D)),
				TConstructRegistry.getItemStack("fullGuardCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.wideGuard, 1, ID),
				new FluidStack(fluid, (int) (144 * 0.5D)),
				TConstructRegistry.getItemStack("wideGuardCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.crossbar, 1, ID),
				new FluidStack(fluid, (int) (144 * 0.5D)),
				TConstructRegistry.getItemStack("crossbarCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.binding, 1, ID),
				new FluidStack(fluid, (int) (144 * 0.5D)),
				TConstructRegistry.getItemStack("bindingCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.handGuard, 1, ID),
				new FluidStack(fluid, (int) (144 * 0.5D)),
				TConstructRegistry.getItemStack("handGuardCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.frypanHead, 1, ID),
				new FluidStack(fluid, (int) (144 * 1.0D)),
				TConstructRegistry.getItemStack("frypanHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.signHead, 1, ID),
				new FluidStack(fluid, (int) (144 * 1.0D)),
				TConstructRegistry.getItemStack("signHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.knifeBlade, 1, ID),
				new FluidStack(fluid, (int) (144 * 0.5D)),
				TConstructRegistry.getItemStack("knifeBladeCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.chiselHead, 1, ID),
				new FluidStack(fluid, (int) (144 * 0.5D)),
				TConstructRegistry.getItemStack("chiselHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.toughRod, 1, ID),
				new FluidStack(fluid, (int) (144 * 3.0D)),
				TConstructRegistry.getItemStack("toughRodCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.toughBinding, 1, ID),
				new FluidStack(fluid, (int) (144 * 3.0D)),
				TConstructRegistry.getItemStack("toughBindingCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.largePlate, 1, ID),
				new FluidStack(fluid, (int) (144 * 8.0D)),
				TConstructRegistry.getItemStack("largePlateCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.broadAxeHead, 1, ID),
				new FluidStack(fluid, (int) (144 * 8.0D)),
				TConstructRegistry.getItemStack("broadAxeHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.scytheBlade, 1, ID),
				new FluidStack(fluid, (int) (144 * 8.0D)),
				TConstructRegistry.getItemStack("scytheHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.excavatorHead, 1, ID),
				new FluidStack(fluid, (int) (144 * 8.0D)),
				TConstructRegistry.getItemStack("excavatorHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.largeSwordBlade, 1, ID),
				new FluidStack(fluid, (int) (144 * 8.0D)),
				TConstructRegistry.getItemStack("largeBladeCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.hammerHead, 1, ID),
				new FluidStack(fluid, (int) (144 * 8.0D)),
				TConstructRegistry.getItemStack("hammerHeadCast"), 50);
		TConstructRegistry.instance.getTableCasting().addCastingRecipe(
				new ItemStack(TinkerTools.arrowhead, 1, ID),
				new FluidStack(fluid, (int) (144 * 1.0D)),
				TConstructRegistry.getItemStack("arrowheadCast"), 50);

	}

	public void buildParts(Item item, int meta) {
		int[] nonMetals = { 0, 1, 3, 4, 5, 6, 7, 8, 9, 17 };
		int[] liquidDamage = new int[] { 2, 13, 10, 11, 12, 14, 15, 6, 16, 18 };

		for (int mat = 0; mat < nonMetals.length; mat++) {
			TConstructRegistry.addPartMapping(woodPattern, meta, mat,
					new ItemStack(item, 1, mat));
		}

		LiquidCasting tableCasting = TConstructRegistry.getTableCasting();
		// patternOutputs = new Item[] { partShuriken, partCrossbowLimb,
		// partCrossbowBody, partBowLimb };

		ItemStack cast = new ItemStack(metalPattern, 1, meta);

		tableCasting.addCastingRecipe(cast,
				new FluidStack(TinkerSmeltery.moltenAlubrassFluid,
						TConstruct.ingotLiquidValue), new ItemStack(item, 1,
						Short.MAX_VALUE), false, 50);
		tableCasting.addCastingRecipe(cast,
				new FluidStack(TinkerSmeltery.moltenGoldFluid,
						TConstruct.ingotLiquidValue * 2), new ItemStack(item,
						1, Short.MAX_VALUE), false, 50);

		for (int iterTwo = 0; iterTwo < TinkerSmeltery.liquids.length; iterTwo++) {
			Fluid fs = TinkerSmeltery.liquids[iterTwo].getFluid();
			int fluidAmount = metalPattern.getPatternCost(cast)
					* TConstruct.ingotLiquidValue / 2;
			ItemStack metalCast = new ItemStack(item, 1, liquidDamage[iterTwo]);
			tableCasting.addCastingRecipe(metalCast, new FluidStack(fs,
					fluidAmount), cast, 50);
			Smeltery.addMelting(FluidType.getFluidType(fs), metalCast, 0,
					fluidAmount);
		}
	}
	
	public static int[] hexToRGB(String hex)
	{
		int color[] = new int[3];
		
		color[0] = Integer.parseUnsignedInt(hex.substring(0, 2), 16);
		color[1] = Integer.parseUnsignedInt(hex.substring(2, 4), 16);
		color[2] = Integer.parseUnsignedInt(hex.substring(4, 6), 16);
		
		return color;
	}

}

