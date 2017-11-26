package lance5057.tDefense.core.materials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.eventbus.Subscribe;

import gnu.trove.map.hash.THashMap;
import gnu.trove.set.hash.THashSet;
import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.materials.MaterialCloth;
import lance5057.tDefense.core.items.TDOreDictItem;
import lance5057.tDefense.core.materials.traits.TraitAxeLover;
import lance5057.tDefense.core.materials.traits.TraitBarbed;
import lance5057.tDefense.core.materials.traits.TraitDogToy;
import lance5057.tDefense.core.materials.traits.TraitDulling;
import lance5057.tDefense.core.materials.traits.TraitFirestarter;
import lance5057.tDefense.util.TDMatHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
//import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.smeltery.block.BlockMolten;
import slimeknights.tconstruct.tools.TinkerMaterials;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDMaterials {

	// public static final List<Material> materials = Lists.newArrayList();

	String SHIELD = ShieldMaterialStats.TYPE;

	public static final Map<String, Material> materials = new THashMap<>();
	public static final Map<String, MaterialIntegration> materialIntegrations = new THashMap<>();
	public static final Collection<String> deferredMaterials = new THashSet<>();

	public static final Map<String, Integer> colors = new THashMap();
	public static final Map<String, FluidMolten> fluids = new THashMap();

	public static Material black;
	public static Material red;
	public static Material green;
	public static Material brown;
	public static Material blue;
	public static Material purple;
	public static Material cyan;
	public static Material lightgray;
	public static Material gray;
	public static Material pink;
	public static Material lime;
	public static Material yellow;
	public static Material lightblue;
	public static Material magenta;
	public static Material orange;
	public static Material white;

	// public static FluidMolten fluidAeonsteel = new FluidMolten("aeonsteel",
	// 0xa470e0);
	// public static FluidMolten fluidQueensGold = new FluidMolten("queensgold",
	// 0xdcff00);
	// public static FluidMolten fluidDogbearium = new FluidMolten("dogbearium",
	// 0x6d3300);
	// public static FluidMolten fluidRedCandy = new FluidMolten("redcandy",
	// 0xff0000);
	// public static FluidMolten fluidGreenCandy = new FluidMolten("greencandy",
	// 0x00ff00);
	public static FluidMolten fluidVile = new FluidMolten("vile", 0x111111);
	// public static FluidMolten fluidSinisterium = new
	// FluidMolten("sinisterium", 0x210000);
	// public static FluidMolten fluidNihilite = new FluidMolten("nihilite",
	// 0x000021);
	public static FluidMolten fluidVibrant = new FluidMolten("vibrant", 0x76ff00);
	// public static FluidMolten fluidOrichalcum = new FluidMolten("orichalcum",
	// 0xffc700);
	// public static FluidMolten fluidPandorium = new FluidMolten("pandorium",
	// 0x7f6a00);
	// public static FluidMolten fluidChorusJuice = new
	// FluidMolten("chorusjuice", 0xd982ff);
	// public static FluidMolten fluidDragonsBreath = new
	// FluidMolten("dragonsbreath", 0x7f00b7);
	// public static FluidMolten fluidRoseGold = new FluidMolten("rosegold",
	// 0xff9b84);
	// public static FluidMolten fluidPlatinum = new FluidMolten("platinum",
	// 0xe8e8e8);
	// public static FluidMolten fluidBrass = new FluidMolten("brass",
	// 0xdbb332);
	// public static FluidMolten fluidSilver = new FluidMolten("silver",
	// 0x9e9e9e);
	// public static FluidMolten fluidCheese = new FluidMolten("cheese",
	// 0xffe731);
	// public static FluidMolten fluidGold = new FluidMolten("gold", 0xffe330);

	List<TDMatHelper> materials_master = new ArrayList<>();

	// Base
	List<TDMatHelper> materials_base = new ArrayList<>(Arrays.asList(
			new TDMatHelper("aeonsteel", 0xa470e0, new FluidMolten("aeonsteel", 0xa470e0))
					.setHead(new HeadMaterialStats(500, 15.00f, 4.0f, HarvestLevels.COBALT))
					.setHandle(new HandleMaterialStats(1.1f, 0)).setExtra(new ExtraMaterialStats(50)),
			new TDMatHelper("queensgold", 0xdcff00, new FluidMolten("queensgold", 0xdcff00)),
			new TDMatHelper("dogbearium", 0x6d3300, new FluidMolten("dogbearium", 0x6d3300)),
			new TDMatHelper("sinisterium", 0x210000, new FluidMolten("sinisterium", 0x210000)),
			new TDMatHelper("nihilite", 0x000021, new FluidMolten("nihilite", 0x000021)),
			new TDMatHelper("orichalcum", 0xffc700, new FluidMolten("orichalcum", 0xffc700)),
			new TDMatHelper("pandorium", 0x7f6a00, new FluidMolten("pandorium", 0x7f6a00)),
			new TDMatHelper("rosegold", 0xff9b84, new FluidMolten("rosegold", 0xff9b84)),
			new TDMatHelper("platinum", 0xe8e8e8, new FluidMolten("platinum", 0xe8e8e8)),
			new TDMatHelper("brass", 0xdbb332, new FluidMolten("brass", 0xdbb332)),
			// new TDMatHelper("silver", 0x9e9e9e, new FluidMolten("silver",
			// 0x9e9e9e)),
			new TDMatHelper("valyriansteel", 0xe2d9e2, new FluidMolten("valyriansteel", 0xe2d9e2)),
			new TDMatHelper("froststeel", 0xc6dcff, new FluidMolten("froststeel", 0xc6dcff)),
			new TDMatHelper("resonatingcrystal", 0xffffff, new FluidMolten("resonatingcrystal", 0xffffff)),
			new TDMatHelper("pureardite", 0xff4300, new FluidMolten("pureardite", 0xff4300)),
			new TDMatHelper("purecobalt", 0x547eff, new FluidMolten("purecobalt", 0x547eff)),
			new TDMatHelper("puremanyullyn", 0xd044ff, new FluidMolten("puremanyullyn", 0xd044ff)),
			new TDMatHelper("glass", 0xffffff, TinkerFluids.glass),
			// new TDMatHelper("ice", 0xdcff00, new FluidMolten("queensgold",
			// 0xdcff00)),
			new TDMatHelper("purifiedgold", 0xffe242, new FluidMolten("purifiedgold", 0xffe242)),
			new TDMatHelper("purifiedsilver", 0xefefef, new FluidMolten("purifiedsilver", 0xefefef))));

	// Jokes
	List<TDMatHelper> materials_joke = new ArrayList<>(
			Arrays.asList(new TDMatHelper("cheese", 0xffe900, new FluidMolten("cheese", 0xffe900)),
					new TDMatHelper("bread", 0x89732a), new TDMatHelper("melon", 0xff77a4)));

	// Holiday
	List<TDMatHelper> materials_xmas = new ArrayList<>(
			Arrays.asList(new TDMatHelper("redcandy", 0xff0000), new TDMatHelper("greencandy", 0x00ff00)));

	// Gems
	List<TDMatHelper> materials_gems = new ArrayList<>(
			Arrays.asList(new TDMatHelper("sapphire", 0x6e00ff),
					new TDMatHelper("ruby", 0xff0061, true),
					new TDMatHelper("emerald", 0x16cc4f, true),
					new TDMatHelper("diamond", 0x96ecf2, true),
					new TDMatHelper("starsapphire", 0x6e00ff, true),
					new TDMatHelper("starruby", 0xff0061, true),
					new TDMatHelper("citrine", 0xffe877, true),
					new TDMatHelper("ghasttear", 0xe8fbff, true),
					new TDMatHelper("quartz", 0xede8e8, true),
					new TDMatHelper("glowstonecrystal", 0xfff956, true),
					new TDMatHelper("enderpearl", 0x2bad3a, true),
					new TDMatHelper("amethyst", 0xb436e2, true),
					new TDMatHelper("lapis", 0x4349bc, true),
					new TDMatHelper("topaz", 0xffc551, true),
					new TDMatHelper("garnet", 0x9e1c1c, true),
					new TDMatHelper("opal", 0xe2e2e2, true),
					new TDMatHelper("tanzanite", 0x8860e5, true),
					new TDMatHelper("amber", 0xdba827, true)));
	
	// // Blood Magic
	// List<String> materials_bm = new ArrayList<>(
	// Arrays.asList("blankslate", "reinforcedslate", "imbued", "demonic",
	// "ethereal"));
	//
	// // Twilight Forest
	// List<String> materials_tf = new ArrayList<>(Arrays.asList("rainbowoak",
	// "ravenfeather", "horn", "ironwood",
	// "steelleaf", "nagascale", "fiery", "caminite", "knightmetal"));
	//
	// // Pam's Harvestcraft
	// List<String> materials_pam = new
	// ArrayList<>(Arrays.asList("hardenedleather"));

	public static TDOreDictItem ingot;
	public static TDOreDictItem dust;
	public static TDOreDictItem nugget;
	public static TDOreDictItem grain;
	public static TDOreDictItem gem;

	public static final AbstractTrait axelover = new TraitAxeLover();
	public static final AbstractTrait dulling = new TraitDulling();
	public static final AbstractTrait firestarter = new TraitFirestarter();
	public static final AbstractTrait barbed = new TraitBarbed();
	public static final AbstractTrait dogtoy = new TraitDogToy();

	static ArrayList<Item> itemList = new ArrayList<Item>();
	static ArrayList<Block> blockList = new ArrayList<Block>();

	private static Material mat(String name, int color) {
		Material mat = new Material(name, color);
		// materials.add(mat);
		return mat;
	}

	List<String> getMatNames(List<TDMatHelper> mats) {
		List<String> r = new ArrayList<String>();

		for (TDMatHelper m : mats) {
			r.add(m.name);
		}

		return r;
	}

	List<Integer> getMatColors(List<TDMatHelper> mats) {
		List<Integer> r = new ArrayList<Integer>();

		for (TDMatHelper m : mats) {
			r.add(m.color);
		}

		return r;
	}

	List<FluidMolten> getMatFluids(List<TDMatHelper> mats) {
		List<FluidMolten> r = new ArrayList<FluidMolten>();

		for (TDMatHelper m : mats) {
			r.add(m.fluid);
		}

		return r;
	}

	@Subscribe
	public void preInit(FMLPreInitializationEvent event) {

		if (TinkersDefense.config.materials.enableBaseMaterials)
			this.materials_master.addAll(materials_base);
		if (TinkersDefense.config.materials.enableJokeMaterials)
			this.materials_master.addAll(this.materials_joke);
		if (TinkersDefense.config.materials.enableHolidayMaterials)
			this.materials_master.addAll(materials_xmas);
		if (TinkersDefense.config.materials.enableGemMaterials)
			this.materials_master.addAll(materials_gems);
		// if (TinkersDefense.config.materials.enableTwilightForestMaterials)
		// this.materials_master.addAll(materials_tf);
		// if (TinkersDefense.config.materials.enableBloodMagicMaterials)
		// this.materials_master.addAll(materials_bm);
		// if (TinkersDefense.config.materials.enableHarvestCraftMaterials)
		// this.materials_master.addAll(materials_pam);

		nugget = new TDOreDictItem("nugget", getMatNames(materials_master));
		dust = new TDOreDictItem("dust", getMatNames(materials_master));
		grain = new TDOreDictItem("grain", getMatNames(materials_master));

		List<TDMatHelper> gemMaster = new ArrayList<TDMatHelper>();
		List<TDMatHelper> ingotMaster = new ArrayList<TDMatHelper>();

		for (TDMatHelper i : materials_master) {
			if (i.isGem)
				gemMaster.add(i);
			else
				ingotMaster.add(i);
		}

		gem = new TDOreDictItem("gem", getMatNames(gemMaster));
		ingot = new TDOreDictItem("ingot", getMatNames(ingotMaster));

		Material.UNKNOWN.addStats(new ShieldMaterialStats(35, 33));

		// TinkerRegistry.addMaterialStats(Material.UNKNOWN,
		// new ShieldMaterialStats(35, 33));

		// TinkerRegistry.addMaterialStats(Material.UNKNOWN,
		// new ShieldMaterialStats(35, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new ShieldMaterialStats(35, 33));
		TinkerMaterials.wood.addTrait(axelover, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new ShieldMaterialStats(120, 33));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.stone, dulling,
		// SHIELD);
		TinkerMaterials.stone.addTrait(dulling, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new ShieldMaterialStats(150, 33));
		TinkerRegistry.addMaterialTrait(TinkerMaterials.flint, firestarter, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new ShieldMaterialStats(210, 33));
		TinkerRegistry.addMaterialTrait(TinkerMaterials.cactus, barbed, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new ShieldMaterialStats(200, 33));
		TinkerRegistry.addMaterialTrait(TinkerMaterials.bone, dogtoy, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new ShieldMaterialStats(139, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new ShieldMaterialStats(430, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new ShieldMaterialStats(420, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new ShieldMaterialStats(12, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new ShieldMaterialStats(550, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new ShieldMaterialStats(550, 33));

		// Slime
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new ShieldMaterialStats(1000, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new ShieldMaterialStats(850, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new ShieldMaterialStats(600, 33));

		// Nether
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new ShieldMaterialStats(270, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new ShieldMaterialStats(990, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new ShieldMaterialStats(820, 33));

		// Metals
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new ShieldMaterialStats(204, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new ShieldMaterialStats(380, 33));

		// Mod Integration
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new ShieldMaterialStats(210, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new ShieldMaterialStats(430, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new ShieldMaterialStats(334, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new ShieldMaterialStats(250, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new ShieldMaterialStats(50, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new ShieldMaterialStats(540, 33));

		for (TDMatHelper m : materials_master) {
			createMaterial(m);
		}

		// TAIGA TEST
		// Collection<Material> mats = TinkerRegistry.getAllMaterials();
		for (Material i : TinkerRegistry.getAllMaterials()) {
			if (!i.hasStats(SHIELD)) {
				if (i.hasStats(MaterialTypes.HEAD)) {
					int dur = ((HeadMaterialStats) i.getStats(MaterialTypes.HEAD)).durability;
					i.addStats(new ShieldMaterialStats(dur, 33));
				}
			}
		}

		registerClothMaterials();

		createFluid("vibrant", fluidVibrant);
		FluidRegistry.registerFluid(fluidVibrant);
		FluidRegistry.addBucketForFluid(fluidVibrant);

		createFluid("vile", fluidVile);
		FluidRegistry.registerFluid(fluidVile);
		FluidRegistry.addBucketForFluid(fluidVile);

		// integrate(materials, materialIntegrations, deferredMaterials);

	}

	void createMaterial(TDMatHelper tdmat) {
		Material mat = new Material(tdmat.name, tdmat.color);

		if(tdmat.isGem)
		{
			mat.addItem("gem" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
			mat.addItem(gem.getItembyName(tdmat.name), 1, Material.VALUE_Ingot);
		}
		else
			mat.addItem("ingot" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
		mat.addItem("nugget" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
		mat.addItem("dust" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
		mat.addItem("grain" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));

		if(tdmat.isGem)
			mat.setCraftable(true).setCastable(false);
		else
			mat.setCraftable(false).setCastable(true);
		TinkersDefense.proxy.registerMatColor(mat, tdmat.color);

		if (tdmat.fluid != null) {
			createFluid(tdmat.name, tdmat.fluid);
			tdmat.fluid.setTemperature(800);
			mat.setFluid(tdmat.fluid);
		}

		ItemStack i;
		if(tdmat.isGem)
			i = gem.getItembyName(tdmat.name);
		else
			i = ingot.getItembyName(tdmat.name);
		mat.setRepresentativeItem(i);

		setStats(mat, tdmat);
		materials.put(tdmat.name, mat);

		if (tdmat.fluid != null)
			TinkerRegistry.integrate(new MaterialIntegration(mat, tdmat.fluid).toolforge()).preInit();
		else
			TinkerRegistry.integrate(new MaterialIntegration(mat).toolforge()).preInit();
	}

	void setStats(Material m, TDMatHelper tdm) {
		if (tdm.head != null)
			TinkerRegistry.addMaterialStats(m, tdm.head);
		else
			TinkerRegistry.addMaterialStats(m, new HeadMaterialStats(0,0,0,0));
		if (tdm.handle != null)
			TinkerRegistry.addMaterialStats(m, tdm.handle);
		else
			TinkerRegistry.addMaterialStats(m, new HandleMaterialStats(0,0));
		if (tdm.extra != null)
			TinkerRegistry.addMaterialStats(m, tdm.extra);
		else
			TinkerRegistry.addMaterialStats(m, new ExtraMaterialStats(0));
		if (tdm.bow != null)
			TinkerRegistry.addMaterialStats(m, tdm.bow);
		if (tdm.shaft != null)
			TinkerRegistry.addMaterialStats(m, tdm.shaft);
		if (tdm.bowstring != null)
			TinkerRegistry.addMaterialStats(m, tdm.bowstring);
		if (tdm.shield != null)
			TinkerRegistry.addMaterialStats(m, tdm.shield);
	}

	public void registerItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry registry = event.getRegistry();

		registry.register(ingot);
		registry.register(dust);
		registry.register(nugget);
		registry.register(grain);
		registry.register(gem);
	}

	@Subscribe
	public void init(FMLInitializationEvent event) {
		for (int i = 0; i < ingot.mats.size(); i++)
			OreDictionary.registerOre(
					"ingot" + ingot.mats.get(i).substring(0, 1).toUpperCase() + ingot.mats.get(i).substring(1),
					new ItemStack(ingot, 1, i));
		for (int i = 0; i < nugget.mats.size(); i++)
			OreDictionary.registerOre(
					"nugget" + nugget.mats.get(i).substring(0, 1).toUpperCase() + nugget.mats.get(i).substring(1),
					new ItemStack(nugget, 1, i));
		for (int i = 0; i < dust.mats.size(); i++)
			OreDictionary.registerOre(
					"dust" + dust.mats.get(i).substring(0, 1).toUpperCase() + dust.mats.get(i).substring(1),
					new ItemStack(dust, 1, i));
		for (int i = 0; i < grain.mats.size(); i++)
			OreDictionary.registerOre(
					"grain" + grain.mats.get(i).substring(0, 1).toUpperCase() + grain.mats.get(i).substring(1),
					new ItemStack(grain, 1, i));
		for (int i = 0; i < gem.mats.size(); i++)
			OreDictionary.registerOre(
					"gem" + gem.mats.get(i).substring(0, 1).toUpperCase() + gem.mats.get(i).substring(1),
					new ItemStack(gem, 1, i));
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		for (Block i : blockList) {
			event.getRegistry().register(i);
		}
	}

	static void createFluid(String name, FluidMolten fluid) {
		FluidRegistry.registerFluid(fluid);

		BlockMolten block = new BlockMolten(fluid);
		// Sets names
		block.setUnlocalizedName("molten_" + fluid.getName());
		block.setRegistryName(Reference.MOD_ID, "molten_" + fluid.getName());

		blockList.add(block);
		itemList.add(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		// Registers the fluid's model but only on the client side
		TinkersDefense.proxy.registerFluidModels(fluid);

		FluidRegistry.addBucketForFluid(fluid);
	}

	private void registerClothMaterials() {
		black = new Material("blackCloth", 0x191616);
		red = new Material("redCloth", 0x963430);
		green = new Material("greeCloth", 0x35461B);
		brown = new Material("brownCloth", 0x4F321F);
		blue = new Material("blueCloth", 0x2E388D);
		purple = new Material("purpleCloth", 0x7E3DB5);
		cyan = new Material("cyanCloth", 0x2E6E89);
		lightgray = new Material("lightgrayCloth", 0x9AA1A1);
		gray = new Material("grayCloth", 0x404040);
		pink = new Material("pinkCloth", 0xD08499);
		lime = new Material("limeCloth", 0x41AE38);
		yellow = new Material("yellowCloth", 0xB1A627);
		lightblue = new Material("lightblueCloth", 0x6B8AC9);
		magenta = new Material("magentaCloth", 0xB350BC);
		orange = new Material("orangeCloth", 0xDB7D3E);
		white = new Material("whiteCloth", 0xDDDDDD);

		Material.UNKNOWN.addStats(new MaterialCloth(100));
		black.addItem(new ItemStack(Blocks.WOOL, 15), 1, Material.VALUE_Ingot);
		red.addItem(new ItemStack(Blocks.WOOL, 14), 1, Material.VALUE_Ingot);
		green.addItem(new ItemStack(Blocks.WOOL, 13), 1, Material.VALUE_Ingot);
		brown.addItem(new ItemStack(Blocks.WOOL, 12), 1, Material.VALUE_Ingot);
		blue.addItem(new ItemStack(Blocks.WOOL, 11), 1, Material.VALUE_Ingot);
		purple.addItem(new ItemStack(Blocks.WOOL, 10), 1, Material.VALUE_Ingot);
		cyan.addItem(new ItemStack(Blocks.WOOL, 9), 1, Material.VALUE_Ingot);
		lightgray.addItem(new ItemStack(Blocks.WOOL, 8), 1, Material.VALUE_Ingot);
		gray.addItem(new ItemStack(Blocks.WOOL, 7), 1, Material.VALUE_Ingot);
		pink.addItem(new ItemStack(Blocks.WOOL, 6), 1, Material.VALUE_Ingot);
		lime.addItem(new ItemStack(Blocks.WOOL, 5), 1, Material.VALUE_Ingot);
		yellow.addItem(new ItemStack(Blocks.WOOL, 4), 1, Material.VALUE_Ingot);
		lightblue.addItem(new ItemStack(Blocks.WOOL, 3), 1, Material.VALUE_Ingot);
		magenta.addItem(new ItemStack(Blocks.WOOL, 2), 1, Material.VALUE_Ingot);
		orange.addItem(new ItemStack(Blocks.WOOL, 1), 1, Material.VALUE_Ingot);
		white.addItem(new ItemStack(Blocks.WOOL, 0), 1, Material.VALUE_Ingot);

		black.setRepresentativeItem(new ItemStack(Blocks.WOOL, 15));
		red.setRepresentativeItem(new ItemStack(Blocks.WOOL, 14));
		green.setRepresentativeItem(new ItemStack(Blocks.WOOL, 13));
		brown.setRepresentativeItem(new ItemStack(Blocks.WOOL, 12));
		blue.setRepresentativeItem(new ItemStack(Blocks.WOOL, 11));
		purple.setRepresentativeItem(new ItemStack(Blocks.WOOL, 10));
		cyan.setRepresentativeItem(new ItemStack(Blocks.WOOL, 9));
		lightgray.setRepresentativeItem(new ItemStack(Blocks.WOOL, 8));
		gray.setRepresentativeItem(new ItemStack(Blocks.WOOL, 7));
		pink.setRepresentativeItem(new ItemStack(Blocks.WOOL, 6));
		lime.setRepresentativeItem(new ItemStack(Blocks.WOOL, 5));
		yellow.setRepresentativeItem(new ItemStack(Blocks.WOOL, 4));
		lightblue.setRepresentativeItem(new ItemStack(Blocks.WOOL, 3));
		magenta.setRepresentativeItem(new ItemStack(Blocks.WOOL, 2));
		orange.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1));
		white.setRepresentativeItem(new ItemStack(Blocks.WOOL, 0));

		TinkerRegistry.addMaterial(black);
		TinkerRegistry.addMaterial(red);
		TinkerRegistry.addMaterial(green);
		TinkerRegistry.addMaterial(brown);
		TinkerRegistry.addMaterial(blue);
		TinkerRegistry.addMaterial(purple);
		TinkerRegistry.addMaterial(cyan);
		TinkerRegistry.addMaterial(lightgray);
		TinkerRegistry.addMaterial(gray);
		TinkerRegistry.addMaterial(pink);
		TinkerRegistry.addMaterial(lime);
		TinkerRegistry.addMaterial(yellow);
		TinkerRegistry.addMaterial(lightblue);
		TinkerRegistry.addMaterial(magenta);
		TinkerRegistry.addMaterial(orange);
		TinkerRegistry.addMaterial(white);

		TinkerRegistry.addMaterialStats(black, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(red, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(green, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(brown, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(blue, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(purple, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(cyan, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(lightgray, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(gray, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(pink, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(lime, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(yellow, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(lightblue, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(magenta, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(orange, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(white, new MaterialCloth(100));
	}

	// PlusTIC to the rescue
	public static void integrate(Map<String, Material> materials, Map<String, MaterialIntegration> materialIntegrations,
			Collection<String> excludedMaterials) {
		materials.forEach((k, v) -> {
			if (!materialIntegrations.containsKey(k) && !excludedMaterials.contains(k)) {
				MaterialIntegration mi;
				if (v.getFluid() != null && v.getFluid() != TinkerFluids.emerald) {
					mi = new MaterialIntegration(v, v.getFluid(), StringUtils.capitalize(k)).toolforge();
				} else {
					mi = new MaterialIntegration(v);
				}
				mi.integrate();
				// mi.integrateRecipes();
				materialIntegrations.put(k, mi);
			}
		});

		// Utils.displace(TinkerMaterials.wood.getIdentifier()); // so that
		// natura
		// woods are
		// prioritized
	}
}
