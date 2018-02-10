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
import lance5057.tDefense.core.items.TDOreDictItem;
import lance5057.tDefense.util.TDMatHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
//import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.shared.TinkerCommons;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.smeltery.block.BlockMolten;
import slimeknights.tconstruct.tools.TinkerMaterials;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDMaterials
{

	// public static final List<Material> materials = Lists.newArrayList();

	String	SHIELD	= ShieldMaterialStats.TYPE;
	String	HELM	= HelmMaterialStats.TYPE;
	String	CHEST	= ChestMaterialStats.TYPE;
	String	LEGS	= LegsMaterialStats.TYPE;
	String	BOOTS	= BootsMaterialStats.TYPE;
	String	BAUBLE	= BaubleMaterialStats.TYPE;

	public static final Map<String, Material>				materials				= new THashMap<>();
	public static final Map<String, MaterialIntegration>	materialIntegrations	= new THashMap<>();
	public static final Collection<String>					deferredMaterials		= new THashSet<>();

	public static final Map<String, Integer>		colors	= new THashMap();
	public static final Map<String, FluidMolten>	fluids	= new THashMap();

	public static Material	black;
	public static Material	red;
	public static Material	green;
	public static Material	brown;
	public static Material	blue;
	public static Material	purple;
	public static Material	cyan;
	public static Material	lightgray;
	public static Material	gray;
	public static Material	pink;
	public static Material	lime;
	public static Material	yellow;
	public static Material	lightblue;
	public static Material	magenta;
	public static Material	orange;
	public static Material	white;

	public static FluidMolten	fluidVile			= fluids.put("vile", (FluidMolten) new FluidMolten("vile", 0x111111).setTemperature(0));
	public static FluidMolten	fluidVibrant		= fluids.put("vibrant", new FluidMolten("vibrant", 0x76ff00));
	public static FluidMolten	fluidSlush			= fluids.put("slush", (FluidMolten) new FluidMolten("slush", 0xbfefff).setTemperature(0));
	public static FluidMolten	fluidQuartz			= fluids.put("quartz", (FluidMolten) new FluidMolten("quartz", 0xdddddd).setTemperature(75));
	public static FluidMolten	fluidChorusJuice	= fluids.put("chorusjuice", new FluidMolten("chorusjuice", 0xd982ff));
	public static FluidMolten	fluidDragonsBreath	= fluids.put("dragonsbreath", new FluidMolten("dragonsbreath", 0x7f00b7));

	List<TDMatHelper> materials_master = new ArrayList<>();

	// Base
	List<TDMatHelper> materials_base = new ArrayList<>(Arrays.asList(
		new TDMatHelper("aeonsteel", 0xa470e0, fluids.put("aeonsteel", new FluidMolten("aeonsteel", 0xa470e0)), true).setHead(new HeadMaterialStats(500, 15.00f, 4.0f, HarvestLevels.COBALT))
				.setHandle(new HandleMaterialStats(1.1f, 0))
				.setExtra(new ExtraMaterialStats(50))
				.setShield(new ShieldMaterialStats(500 / 4, 33))
				.setBow(new BowMaterialStats(0.75f, 1.0f, 2.5f)),
		new TDMatHelper("queensgold", 0xdcff00, fluids.put("queensgold", new FluidMolten("queensgold", 0xdcff00)), true).setHead(new HeadMaterialStats(70, 3.00f, 3.00f, HarvestLevels.IRON))
				.setHandle(new HandleMaterialStats(1.05f, 35))
				.setExtra(new ExtraMaterialStats(20))
				.setShield(new ShieldMaterialStats(70 / 4, 33))
				.setBow(new BowMaterialStats(1.1f, 1.0f, 0.5f)),
		new TDMatHelper("dogbearium", 0x6d3300, fluids.put("dogbearium", new FluidMolten("dogbearium", 0x6d3300)), true).setHead(new HeadMaterialStats(150, 5.00f, 9.00f, HarvestLevels.DIAMOND))
				.setHandle(new HandleMaterialStats(0.85f, 75))
				.setExtra(new ExtraMaterialStats(75))
				.setShield(new ShieldMaterialStats(70 / 4, 33))
				.setBow(new BowMaterialStats(0.1f, 0.5f, 5.5f)),
		new TDMatHelper("sinisterium", 0x210000, fluids.put("sinisterium", new FluidMolten("sinisterium", 0x210000)), true).setHead(new HeadMaterialStats(224, 5.00f, 5.00f, HarvestLevels.DIAMOND))
				.setHandle(new HandleMaterialStats(0.75f, 99))
				.setExtra(new ExtraMaterialStats(99))
				.setShield(new ShieldMaterialStats(224 / 4, 33))
				.setBow(new BowMaterialStats(2.1f, 1.6f, 7.2f)),
		new TDMatHelper("nihilite", 0x000021, fluids.put("nihilite", new FluidMolten("nihilite", 0x000021)), true).setHead(new HeadMaterialStats(400, 9.7f, 7.1f, HarvestLevels.COBALT))
				.setHandle(new HandleMaterialStats(0.9f, 70))
				.setExtra(new ExtraMaterialStats(74))
				.setShield(new ShieldMaterialStats(400 / 4, 33))
				.setBow(new BowMaterialStats(0.9f, 1.7f, -1f)),
		new TDMatHelper("orichalcum", 0xffc700, fluids.put("orichalcum", new FluidMolten("orichalcum", 0xffc700)), true).setHead(new HeadMaterialStats(180, 5.3f, 6.23f, HarvestLevels.OBSIDIAN))
				.setHandle(new HandleMaterialStats(1.1f, 25))
				.setExtra(new ExtraMaterialStats(35))
				.setShield(new ShieldMaterialStats(180 / 4, 33))
				.setBow(new BowMaterialStats(1.9f, 1.9f, 2.3f)),
		new TDMatHelper("pandorium", 0x7f6a00, fluids.put("pandorium", new FluidMolten("pandorium", 0x7f6a00)), true).setHead(new HeadMaterialStats(999, 10.2f, 8.72f, HarvestLevels.OBSIDIAN))
				.setHandle(new HandleMaterialStats(0.4f, 999))
				.setExtra(new ExtraMaterialStats(99))
				.setShield(new ShieldMaterialStats(999 / 4, 33))
				.setBow(new BowMaterialStats(3f, 0.9f, 9f)),
		new TDMatHelper("rosegold", 0xff9b84, fluids.put("rosegold", new FluidMolten("rosegold", 0xff9b84)), true).setHead(new HeadMaterialStats(99, 4f, 1f, HarvestLevels.STONE))
				.setHandle(new HandleMaterialStats(1.5f, -90))
				.setExtra(new ExtraMaterialStats(-90))
				.setShield(new ShieldMaterialStats(99 / 4, 33))
				.setBow(new BowMaterialStats(0.1f, 0.1f, -2f)),
		new TDMatHelper("platinum", 0xe8e8e8, fluids.put("platinum", new FluidMolten("platinum", 0xe8e8e8)), true).setHead(new HeadMaterialStats(99, 3.7f, 4f, HarvestLevels.IRON))
				.setHandle(new HandleMaterialStats(1.5f, -90))
				.setExtra(new ExtraMaterialStats(-90))
				.setShield(new ShieldMaterialStats(99 / 4, 33))
				.setBow(new BowMaterialStats(0.1f, 0.1f, -2f)),
		new TDMatHelper("brass", 0xdbb332, fluids.put("brass", new FluidMolten("brass", 0xdbb332)), true).setHead(new HeadMaterialStats(380, 5f, 3f, HarvestLevels.IRON))
				.setHandle(new HandleMaterialStats(0.85f, 90))
				.setExtra(new ExtraMaterialStats(75))
				.setShield(new ShieldMaterialStats(380 / 4, 33))
				.setBow(new BowMaterialStats(0.1f, 0.5f, -1f)),
		new TDMatHelper("silver", 0x9e9e9e, new FluidMolten("silver", 0x9e9e9e), false),
		new TDMatHelper("gold", 0xfff428, TinkerFluids.gold, true).setIngot(Items.GOLD_INGOT)
				.setNugget(Items.GOLD_NUGGET)
				.setHead(new HeadMaterialStats(100, 1f, 1f, HarvestLevels.STONE))
				.setHandle(new HandleMaterialStats(0.25f, 10))
				.setExtra(new ExtraMaterialStats(25))
				.setShield(new ShieldMaterialStats(100 / 4, 33))
				.setBow(new BowMaterialStats(0.2f, 0.4f, -1f)),
		new TDMatHelper("valyriansteel", 0xe2d9e2, fluids.put("valyriansteel", new FluidMolten("valyriansteel", 0xe2d9e2)), true).setHead(new HeadMaterialStats(610, 7f, 7f, HarvestLevels.OBSIDIAN))
				.setHandle(new HandleMaterialStats(0.9f, 180))
				.setExtra(new ExtraMaterialStats(125))
				.setShield(new ShieldMaterialStats(610 / 4, 33))
				.setBow(new BowMaterialStats(1.6f, 1.5f, 3f)),
		new TDMatHelper("froststeel", 0xc6dcff, fluids.put("froststeel", new FluidMolten("froststeel", 0xc6dcff)), true).setHead(new HeadMaterialStats(610, 7f, 7f, HarvestLevels.OBSIDIAN))
				.setHandle(new HandleMaterialStats(1.1f, 110))
				.setExtra(new ExtraMaterialStats(125))
				.setShield(new ShieldMaterialStats(610 / 4, 33))
				.setBow(new BowMaterialStats(1.6f, 1.5f, 3f)),
		// new TDMatHelper("resonatingcrystal", 0xffffff,
		// fluids.put("resonatingcrystal", new FluidMolten("resonatingcrystal",
		// 0xffffff)), true),
		new TDMatHelper("pureardite", 0xff4300, fluids.put("pureardite", new FluidMolten("pureardite", 0xff4300)), true).setHead(new HeadMaterialStats(1200, 3.5f, 3.6f, HarvestLevels.COBALT))
				.setHandle(new HandleMaterialStats(1.4f, -200))
				.setExtra(new ExtraMaterialStats(450))
				.setShield(new ShieldMaterialStats(1200 / 4, 33))
				.setBow(new BowMaterialStats(0.45f, 0.8f, 1f)),
		new TDMatHelper("purecobalt", 0x547eff, fluids.put("purecobalt", new FluidMolten("purecobalt", 0x547eff)), true).setHead(new HeadMaterialStats(780, 13f, 4.1f, HarvestLevels.COBALT))
				.setHandle(new HandleMaterialStats(1.4f, 100))
				.setExtra(new ExtraMaterialStats(300))
				.setShield(new ShieldMaterialStats(780 / 4, 33))
				.setBow(new BowMaterialStats(0.3f, 1.3f, 3f)),
		new TDMatHelper("puremanyullyn", 0xd044ff, fluids.put("puremanyullyn", new FluidMolten("puremanyullyn", 0xd044ff)), true).setHead(new HeadMaterialStats(820, 7.02f, 9.1f, HarvestLevels.COBALT))
				.setHandle(new HandleMaterialStats(0.5f, 350))
				.setExtra(new ExtraMaterialStats(350))
				.setShield(new ShieldMaterialStats(820 / 4, 33))
				.setBow(new BowMaterialStats(0.65f, 1.2f, 4f)),
		new TDMatHelper("glass", 0xffffff, TinkerFluids.glass, true).setHead(new HeadMaterialStats(6, 4f, 7f, HarvestLevels.STONE))
				.setHandle(new HandleMaterialStats(0.1f, -45))
				.setExtra(new ExtraMaterialStats(-45))
				.setShield(new ShieldMaterialStats(6 / 4, 33))
				.setBow(new BowMaterialStats(0.1f, 0.1f, -2f)),
		new TDMatHelper("ice", 0xdcff00, false),
		new TDMatHelper("purifiedgold", 0xffe242, fluids.put("purifiedgold", new FluidMolten("purifiedgold", 0xffe242)), true),
		new TDMatHelper("purifiedsilver", 0xefefef, fluids.put("purifiedsilver", new FluidMolten("purifiedsilver", 0xefefef)), true)));

	// Jokes
	List<TDMatHelper> materials_joke = new ArrayList<>(Arrays.asList(new TDMatHelper("cheese", 0xffe900, fluids.put("cheese", new FluidMolten("cheese", 0xffe900)), true),
		new TDMatHelper("bread", 0x89732a),
		new TDMatHelper("melon", 0xff77a4)));

	// Holiday
	List<TDMatHelper> materials_xmas = new ArrayList<>(Arrays.asList(new TDMatHelper("redcandy", 0xff0000).setNugget(TinkersDefense.holiday.item_redmintcane),
		new TDMatHelper("greencandy", 0x00ff00).setNugget(TinkersDefense.holiday.item_greenmintcane)));

	// Gems
	List<TDMatHelper> materials_gems = new ArrayList<>(Arrays.asList(new TDMatHelper("sapphire", 0x6e00ff),
		new TDMatHelper("ruby", 0xff0061, true, true),
		new TDMatHelper("emerald", 0x16cc4f, true, true).setGem(Items.EMERALD),
		new TDMatHelper("diamond", 0x96ecf2, true, true).setGem(Items.DIAMOND),
		new TDMatHelper("starsapphire", 0x6e00ff, true, true),
		new TDMatHelper("starruby", 0xff0061, true, true),
		new TDMatHelper("citrine", 0xffe877, true, true),
		new TDMatHelper("ghasttear", 0xe8fbff, true, true),
		new TDMatHelper("quartz", 0xede8e8, true, true),
		new TDMatHelper("glowstonecrystal", 0xfff956, true, true),
		new TDMatHelper("enderpearl", 0x2bad3a, true, true),
		new TDMatHelper("amethyst", 0xb436e2, true, true),
		new TDMatHelper("lapis", 0x4349bc, true, true).setGem(new ItemStack(Items.DYE, 1, 4)),
		new TDMatHelper("topaz", 0xffc551, true, true),
		new TDMatHelper("garnet", 0x9e1c1c, true, true),
		new TDMatHelper("opal", 0xe2e2e2, true, true),
		new TDMatHelper("tanzanite", 0x8860e5, true, true),
		new TDMatHelper("amber", 0xdba827, true, true)));

	// Cornucopia
	List<TDMatHelper> materials_cornucopia = new ArrayList<>(Arrays.asList(new TDMatHelper("gallite", 0x198c09, fluids.put("gallite", new FluidMolten("gallite", 0x198c09)), true),
		new TDMatHelper("sundrop", 0xfff987, fluids.put("sundrop", new FluidMolten("sundrop", 0xfff987)), true),
		new TDMatHelper("voidite", 0x450059, fluids.put("voidite", new FluidMolten("voidite", 0x450059)), true),
		new TDMatHelper("solarium", 0xffff31, fluids.put("solarium", new FluidMolten("solarium", 0xffff31)), true),
		new TDMatHelper("dragonsteel", 0x55914d, fluids.put("dragonsteel", new FluidMolten("dragonsteel", 0x55914d)), true),
		new TDMatHelper("blacksteel", 0x383838, fluids.put("blacksteel", new FluidMolten("blacksteel", 0x383838)), true),
		new TDMatHelper("abyssalium", 0x000633, fluids.put("abyssalium", new FluidMolten("abyssalium", 0x000633)), true),
		new TDMatHelper("depthsilver", 0x646782, fluids.put("depthsilver", new FluidMolten("depthsilver", 0x646782)), true),
		new TDMatHelper("moonsilver", 0x777777, fluids.put("moonsilver", new FluidMolten("moonsilver", 0x777777)), true),
		new TDMatHelper("novagold", 0xffc300, fluids.put("novagold", new FluidMolten("novagold", 0xffc300)), true)));
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

	public static TDOreDictItem	ingot;
	public static TDOreDictItem	dust;
	public static TDOreDictItem	nugget;
	public static TDOreDictItem	grain;
	public static TDOreDictItem	gem;

	// public static final AbstractTrait axelover = new TraitAxeLover();
	// public static final AbstractTrait dulling = new TraitDulling();
	// public static final AbstractTrait firestarter = new TraitFirestarter();
	// public static final AbstractTrait barbed = new TraitBarbed();
	// public static final AbstractTrait dogtoy = new TraitDogToy();

	static ArrayList<Item>	itemList	= new ArrayList<Item>();
	static ArrayList<Block>	blockList	= new ArrayList<Block>();

	private static Material mat(String name, int color)
	{
		Material mat = new Material(name, color);
		// materials.add(mat);
		return mat;
	}

	List<String> getMatNames(List<TDMatHelper> mats)
	{
		List<String> r = new ArrayList<String>();

		for (TDMatHelper m : mats)
		{
			r.add(m.name);
		}

		return r;
	}

	List<Integer> getMatColors(List<TDMatHelper> mats)
	{
		List<Integer> r = new ArrayList<Integer>();

		for (TDMatHelper m : mats)
		{
			r.add(m.color);
		}

		return r;
	}

	List<FluidMolten> getMatFluids(List<TDMatHelper> mats)
	{
		List<FluidMolten> r = new ArrayList<FluidMolten>();

		for (TDMatHelper m : mats)
		{
			r.add(m.fluid);
		}

		return r;
	}

	@Subscribe
	public void preInit(FMLPreInitializationEvent event)
	{

		if (TinkersDefense.config.materials.enableBaseMaterials)
			this.materials_master.addAll(materials_base);
		if (TinkersDefense.config.materials.enableJokeMaterials)
			this.materials_master.addAll(this.materials_joke);
		if (TinkersDefense.config.materials.enableHolidayMaterials)
			this.materials_master.addAll(materials_xmas);
		if (TinkersDefense.config.materials.enableGemMaterials)
			this.materials_master.addAll(materials_gems);
		if (TinkersDefense.config.materials.enableCornucopiaMaterials)
			this.materials_master.addAll(materials_cornucopia);
		// if (TinkersDefense.config.materials.enableTwilightForestMaterials)
		// this.materials_master.addAll(materials_tf);
		// if (TinkersDefense.config.materials.enableBloodMagicMaterials)
		// this.materials_master.addAll(materials_bm);
		// if (TinkersDefense.config.materials.enableHarvestCraftMaterials)
		// this.materials_master.addAll(materials_pam);

		nugget = new TDOreDictItem("nugget", getMatNames(materials_master), getMatColors(materials_master));
		dust = new TDOreDictItem("dust", getMatNames(materials_master), getMatColors(materials_master));
		grain = new TDOreDictItem("grain", getMatNames(materials_master), getMatColors(materials_master));

		List<TDMatHelper> gemMaster = new ArrayList<TDMatHelper>();
		List<TDMatHelper> ingotMaster = new ArrayList<TDMatHelper>();

		for (TDMatHelper i : materials_master)
		{
			if (i.isGem)
				gemMaster.add(i);
			else
				ingotMaster.add(i);
		}

		gem = new TDOreDictItem("gem", getMatNames(gemMaster), getMatColors(gemMaster));
		ingot = new TDOreDictItem("ingot", getMatNames(ingotMaster), getMatColors(ingotMaster));

		registerClothMaterials();

		Material.UNKNOWN.addStats(new ShieldMaterialStats(35, 33));
		Material.UNKNOWN.addStats(new HelmMaterialStats(35, 1, 0));
		Material.UNKNOWN.addStats(new ChestMaterialStats(35, 1, 0));
		Material.UNKNOWN.addStats(new LegsMaterialStats(35, 1, 0));
		Material.UNKNOWN.addStats(new BootsMaterialStats(35, 1, 0));
		Material.UNKNOWN.addStats(new ClothMaterialStats(35, 0));
		Material.UNKNOWN.addStats(new BaubleMaterialStats(35));

		TinkerRegistry.addMaterialStats(this.white, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.black, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.blue, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.brown, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.cyan, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.gray, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.green, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.lightblue, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.lightgray, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.lime, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.magenta, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.orange, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.pink, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.purple, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.red, new ClothMaterialStats(100, 10));
		TinkerRegistry.addMaterialStats(this.yellow, new ClothMaterialStats(100, 10));

		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new ShieldMaterialStats(35, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new HelmMaterialStats(35, 2, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new ChestMaterialStats(35, 5, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new LegsMaterialStats(35, 3, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new BootsMaterialStats(35, 1, 0));
		// TinkerMaterials.wood.addTrait(axelover, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new ShieldMaterialStats(120, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new BootsMaterialStats(35, 0, 0));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.stone, dulling,
		// SHIELD);
		// TinkerMaterials.stone.addTrait(dulling, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new ShieldMaterialStats(150, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new BootsMaterialStats(35, 0, 0));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.flint, firestarter,
		// SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new ShieldMaterialStats(210, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new BootsMaterialStats(35, 0, 0));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.cactus, barbed,
		// SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new ShieldMaterialStats(200, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new BootsMaterialStats(35, 0, 0));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.bone, dogtoy,
		// SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new ShieldMaterialStats(139, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new ShieldMaterialStats(430, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new ShieldMaterialStats(420, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new ShieldMaterialStats(12, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new ShieldMaterialStats(550, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new ShieldMaterialStats(550, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new BootsMaterialStats(35, 0, 0));

		// Slime
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new ShieldMaterialStats(1000, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new ShieldMaterialStats(850, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new ShieldMaterialStats(600, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new BootsMaterialStats(35, 0, 0));

		// Nether
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new ShieldMaterialStats(270, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new ShieldMaterialStats(990, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new ShieldMaterialStats(820, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new BootsMaterialStats(35, 0, 0));

		// Metals
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new ShieldMaterialStats(204, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new BootsMaterialStats(35, 0, 0));
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new ShieldMaterialStats(380, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new BootsMaterialStats(35, 0, 0));

		// Mod Integration
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new ShieldMaterialStats(210, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new BootsMaterialStats(35, 0, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new ShieldMaterialStats(430, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new BootsMaterialStats(35, 0, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new ShieldMaterialStats(334, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new BootsMaterialStats(35, 0, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new ShieldMaterialStats(250, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new BootsMaterialStats(35, 0, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new ShieldMaterialStats(50, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new BootsMaterialStats(35, 0, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new ShieldMaterialStats(540, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new HelmMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new ChestMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new LegsMaterialStats(35, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new BootsMaterialStats(35, 0, 0));

		for (String s : fluids.keySet())
		{
			createFluid(s, fluids.get(s));
			FluidRegistry.registerFluid(fluids.get(s));
			FluidRegistry.addBucketForFluid(fluids.get(s));

		}

		for (TDMatHelper m : materials_master)
		{
			Material test = TinkerRegistry.getMaterial(m.name);
			if (m.createMat && test.getIdentifier() == "unknown" && !TinkersDefense.config.materials.isBlacklisted(m.name))
				createMaterial(m);
		}

		// TAIGA TEST
		// Collection<Material> mats = TinkerRegistry.getAllMaterials();
		for (Material m : TinkerRegistry.getAllMaterials())
		{
			if (!m.hasStats(SHIELD))
			{
				if (m.hasStats(MaterialTypes.HEAD))
				{
					int dur = ((HeadMaterialStats) m.getStats(MaterialTypes.HEAD)).durability;
					m.addStats(new ShieldMaterialStats(dur, 33));
				}
			}
		}

	}

	void createMaterial(TDMatHelper tdmat)
	{
		Material mat = new Material(tdmat.name, tdmat.color);

		if (tdmat.isGem)
		{
			if (tdmat.gem == null)
			{
				mat.addItem("gem" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
				mat.addItem(gem.getItembyName(tdmat.name), 1, Material.VALUE_Ingot);
			} else
				mat.addItem(tdmat.gem, 1, Material.VALUE_Ingot);
		} else
		{
			if (tdmat.ingot == null)
			{
				mat.addItem("ingot" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
				mat.addItem(ingot.getItembyName(tdmat.name), 1, Material.VALUE_Ingot);
			} else
				mat.addItem(tdmat.ingot, 1, Material.VALUE_Ingot);
		}
		if (tdmat.nugget == null)
		{
			mat.addItem("nugget" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
			mat.addItem(nugget.getItembyName(tdmat.name), 1, Material.VALUE_Nugget);
		} else
			mat.addItem(tdmat.nugget, 1, Material.VALUE_Nugget);
		if (tdmat.dust == null)
		{
			mat.addItem("dust" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
			mat.addItem(nugget.getItembyName(tdmat.name), 1, Material.VALUE_Ingot);
		} else
			mat.addItem(tdmat.nugget, 1, Material.VALUE_Ingot);
		if (tdmat.grain == null)
		{
			mat.addItem("grain" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
			mat.addItem(nugget.getItembyName(tdmat.name), 1, Material.VALUE_Ingot / 4);
		} else
			mat.addItem(tdmat.grain, 1, Material.VALUE_Nugget / 4);

		if (tdmat.isGem)
			mat.setCraftable(true).setCastable(false);
		else
			mat.setCraftable(false).setCastable(true);
		TinkersDefense.proxy.registerMatColor(mat, tdmat.color);

		// if (tdmat.fluid != null) {
		// createFluid(tdmat.name, tdmat.fluid);
		// tdmat.fluid.setTemperature(800);
		FluidMolten f = fluids.get(tdmat.name);
		if (f != null)
			mat.setFluid(f);
		// }

		ItemStack i;
		if (tdmat.isGem)
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

	void setStats(Material m, TDMatHelper tdm)
	{
		if (tdm.head != null)
			TinkerRegistry.addMaterialStats(m, tdm.head);
		else
			TinkerRegistry.addMaterialStats(m, new HeadMaterialStats(0, 0, 0, 0));

		if (tdm.handle != null)
			TinkerRegistry.addMaterialStats(m, tdm.handle);
		else
			TinkerRegistry.addMaterialStats(m, new HandleMaterialStats(0, 0));

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

	public void registerItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry registry = event.getRegistry();

		registry.register(ingot);
		registry.register(dust);
		registry.register(nugget);
		registry.register(grain);
		registry.register(gem);
	}

	@Subscribe
	public void init(FMLInitializationEvent event)
	{
		for (int i = 0; i < ingot.mats.size(); i++)
			OreDictionary.registerOre("ingot" + ingot.mats.get(i).substring(0, 1).toUpperCase() + ingot.mats.get(i).substring(1), new ItemStack(ingot, 1, i));
		for (int i = 0; i < nugget.mats.size(); i++)
			OreDictionary.registerOre("nugget" + nugget.mats.get(i).substring(0, 1).toUpperCase() + nugget.mats.get(i).substring(1), new ItemStack(nugget, 1, i));
		for (int i = 0; i < dust.mats.size(); i++)
			OreDictionary.registerOre("dust" + dust.mats.get(i).substring(0, 1).toUpperCase() + dust.mats.get(i).substring(1), new ItemStack(dust, 1, i));
		for (int i = 0; i < grain.mats.size(); i++)
			OreDictionary.registerOre("grain" + grain.mats.get(i).substring(0, 1).toUpperCase() + grain.mats.get(i).substring(1), new ItemStack(grain, 1, i));
		for (int i = 0; i < gem.mats.size(); i++)
			OreDictionary.registerOre("gem" + gem.mats.get(i).substring(0, 1).toUpperCase() + gem.mats.get(i).substring(1), new ItemStack(gem, 1, i));

		TinkerRegistry.registerMelting(Items.CHORUS_FRUIT, fluids.get("chorusjuice"), Material.VALUE_Nugget);
		TinkerRegistry.registerMelting(Items.DRAGON_BREATH, fluids.get("dragonsbreath"), Material.VALUE_Ingot);
		TinkerRegistry.registerMelting(TinkerCommons.matNecroticBone, fluids.get("vile"), Material.VALUE_Nugget);
		TinkerRegistry.registerMelting(new ItemStack(Items.SKULL, 1, 1), fluids.get("vile"), Material.VALUE_Ingot);
		TinkerRegistry.registerMelting(TinkerCommons.matMendingMoss, fluids.get("vibrant"), Material.VALUE_Ingot * 2);
		TinkerRegistry.registerMelting(Blocks.ICE, fluids.get("slush"), Material.VALUE_Ingot);
		TinkerRegistry.registerMelting(Blocks.PACKED_ICE, fluids.get("slush"), Material.VALUE_Ingot * 4);
		TinkerRegistry.registerMelting(Blocks.QUARTZ_BLOCK, fluids.get("quartz"), Material.VALUE_Ingot * 4);
		TinkerRegistry.registerMelting(Items.QUARTZ, fluids.get("quartz"), Material.VALUE_Ingot);

		TinkerRegistry.registerTableCasting(new ItemStack(Items.QUARTZ, 1, 0), ItemStack.EMPTY, (Fluid) fluids.get("quartz"), Material.VALUE_Ingot);

		TinkerRegistry.registerBasinCasting(new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0), ItemStack.EMPTY, (Fluid) fluids.get("quartz"), Material.VALUE_Ingot * 4);
		TinkerRegistry.registerBasinCasting(new ItemStack(Blocks.ICE, 1, 0), ItemStack.EMPTY, (Fluid) fluids.get("slush"), Material.VALUE_Ingot);

		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("aeonsteel"), 4), new FluidStack(fluids.get("chorusjuice"), 1), new FluidStack(TinkerFluids.cobalt, 3));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("queensgold"), 2), new FluidStack(TinkerFluids.gold, 1), new FluidStack(TinkerFluids.knightslime, 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("dogbearium"), 4), new FluidStack(TinkerFluids.ardite, 1), new FluidStack(fluids.get("dragonsbreath"), 3));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("sinisterium"), 6), new FluidStack(TinkerFluids.blood, 1), new FluidStack(fluids.get("vile"), 2), new FluidStack(TinkerFluids.iron, 4));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("nihilite"), 3), new FluidStack(TinkerFluids.cobalt, 1), new FluidStack(fluids.get("vile"), 2));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("orichalcum"), 6),
			new FluidStack(TinkerFluids.bronze, 4),
			new FluidStack(fluids.get("vibrant"), 2),
			new FluidStack(TinkerFluids.gold, 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("pandorium"), 3), new FluidStack(TinkerFluids.ardite, 1), new FluidStack(fluids.get("vibrant"), 2));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("rosegold"), 4), new FluidStack(TinkerFluids.gold, 1), new FluidStack(TinkerFluids.copper, 3));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("brass"), 3), new FluidStack(TinkerFluids.copper, 2), new FluidStack(TinkerFluids.zinc, 2));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("valyriansteel"), 4),
			new FluidStack(TinkerFluids.steel, 2),
			new FluidStack(TinkerFluids.obsidian, 2),
			new FluidStack(fluids.get("dragonsbreath"), 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("froststeel"), 4),
			new FluidStack(TinkerFluids.steel, 2),
			new FluidStack(TinkerFluids.cobalt, 2),
			new FluidStack(fluids.get("slush"), 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("pureardite"), 1),
			new FluidStack(TinkerFluids.ardite, 1),
			new FluidStack(fluids.get("dragonsbreath"), 2),
			new FluidStack(TinkerFluids.blood, 2),
			new FluidStack(fluids.get("purifiedgold"), 2));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("purecobalt"), 1),
			new FluidStack(TinkerFluids.cobalt, 1),
			new FluidStack(fluids.get("dragonsbreath"), 2),
			new FluidStack(fluids.get("slush"), 2),
			new FluidStack(fluids.get("purifiedsilver"), 2));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("puremanyullyn"), 2), new FluidStack(fluids.get("pureardite"), 1), new FluidStack(fluids.get("purecobalt"), 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("purifiedgold"), 1),
			new FluidStack(TinkerFluids.gold, 1),
			new FluidStack(fluids.get("quartz"), 8),
			new FluidStack(TinkerFluids.glass, 2),
			new FluidStack(TinkerFluids.purpleSlime, 2));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("purifiedsilver"), 1),
			new FluidStack(TinkerFluids.silver, 1),
			new FluidStack(fluids.get("quartz"), 8),
			new FluidStack(TinkerFluids.glass, 2),
			new FluidStack(TinkerFluids.purpleSlime, 2));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("solarium"), 1), new FluidStack(TinkerFluids.steel, 1), new FluidStack(fluids.get("sundrop"), 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("dragonsteel"), 1), new FluidStack(TinkerFluids.steel, 1), new FluidStack(fluids.get("gallite"), 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("blacksteel"), 1), new FluidStack(TinkerFluids.steel, 1), new FluidStack(fluids.get("voidite"), 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("abyssalium"), 1), new FluidStack(fluids.get("voidite"), 1), new FluidStack(fluids.get("sundrop"), 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("depthsilver"), 1), new FluidStack(TinkerFluids.silver, 1), new FluidStack(fluids.get("abyssalium"), 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("moonsilver"), 1), new FluidStack(TinkerFluids.silver, 1), new FluidStack(fluids.get("voidite"), 1));
		TinkerRegistry.registerAlloy(new FluidStack(fluids.get("novagold"), 1), new FluidStack(TinkerFluids.gold, 1), new FluidStack(fluids.get("sundrop"), 1));

	}

	@Subscribe
	public void postInit(FMLPostInitializationEvent event)
	{

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		for (int i = 0; i < dust.mats.size(); i++)
		{
			ModelLoader.setCustomModelResourceLocation(dust, i, new ModelResourceLocation(Reference.MOD_ID + ":dust", "inventory"));
		}

		for (int i = 0; i < ingot.mats.size(); i++)
		{
			ModelLoader.setCustomModelResourceLocation(ingot, i, new ModelResourceLocation(Reference.MOD_ID + ":ingot", "inventory"));
		}

		for (int i = 0; i < gem.mats.size(); i++)
		{
			ModelLoader.setCustomModelResourceLocation(gem, i, new ModelResourceLocation(Reference.MOD_ID + ":gem", "inventory"));
		}

		for (int i = 0; i < nugget.mats.size(); i++)
		{
			ModelLoader.setCustomModelResourceLocation(nugget, i, new ModelResourceLocation(Reference.MOD_ID + ":nugget", "inventory"));
		}

		for (int i = 0; i < grain.mats.size(); i++)
		{
			ModelLoader.setCustomModelResourceLocation(grain, i, new ModelResourceLocation(Reference.MOD_ID + ":grain", "inventory"));
		}
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		for (Block i : blockList)
		{
			event.getRegistry().register(i);
		}
	}

	static void createFluid(String name, FluidMolten fluid)
	{
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

	private void registerClothMaterials()
	{
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

		//Material.UNKNOWN.addStats(new MaterialCloth(100));
		black.addItem(new ItemStack(Blocks.WOOL, 1, 15), 1, Material.VALUE_Ingot);
		red.addItem(new ItemStack(Blocks.WOOL, 1, 14), 1, Material.VALUE_Ingot);
		green.addItem(new ItemStack(Blocks.WOOL, 1, 13), 1, Material.VALUE_Ingot);
		brown.addItem(new ItemStack(Blocks.WOOL, 1, 12), 1, Material.VALUE_Ingot);
		blue.addItem(new ItemStack(Blocks.WOOL, 1, 11), 1, Material.VALUE_Ingot);
		purple.addItem(new ItemStack(Blocks.WOOL, 1, 10), 1, Material.VALUE_Ingot);
		cyan.addItem(new ItemStack(Blocks.WOOL, 1, 9), 1, Material.VALUE_Ingot);
		lightgray.addItem(new ItemStack(Blocks.WOOL, 1, 8), 1, Material.VALUE_Ingot);
		gray.addItem(new ItemStack(Blocks.WOOL, 1, 7), 1, Material.VALUE_Ingot);
		pink.addItem(new ItemStack(Blocks.WOOL, 1, 6), 1, Material.VALUE_Ingot);
		lime.addItem(new ItemStack(Blocks.WOOL, 1, 5), 1, Material.VALUE_Ingot);
		yellow.addItem(new ItemStack(Blocks.WOOL, 1, 4), 1, Material.VALUE_Ingot);
		lightblue.addItem(new ItemStack(Blocks.WOOL, 1, 3), 1, Material.VALUE_Ingot);
		magenta.addItem(new ItemStack(Blocks.WOOL, 1, 2), 1, Material.VALUE_Ingot);
		orange.addItem(new ItemStack(Blocks.WOOL, 1, 1), 1, Material.VALUE_Ingot);
		white.addItem(new ItemStack(Blocks.WOOL, 1, 0), 1, Material.VALUE_Ingot);

		black.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 15));
		red.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 14));
		green.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 13));
		brown.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 12));
		blue.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 11));
		purple.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 10));
		cyan.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 9));
		lightgray.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 8));
		gray.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 7));
		pink.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 6));
		lime.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 5));
		yellow.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 4));
		lightblue.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 3));
		magenta.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 2));
		orange.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 1));
		white.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1, 0));

//		TinkerRegistry.addMaterial(black);
//		TinkerRegistry.addMaterial(red);
//		TinkerRegistry.addMaterial(green);
//		TinkerRegistry.addMaterial(brown);
//		TinkerRegistry.addMaterial(blue);
//		TinkerRegistry.addMaterial(purple);
//		TinkerRegistry.addMaterial(cyan);
//		TinkerRegistry.addMaterial(lightgray);
//		TinkerRegistry.addMaterial(gray);
//		TinkerRegistry.addMaterial(pink);
//		TinkerRegistry.addMaterial(lime);
//		TinkerRegistry.addMaterial(yellow);
//		TinkerRegistry.addMaterial(lightblue);
//		TinkerRegistry.addMaterial(magenta);
//		TinkerRegistry.addMaterial(orange);
//		TinkerRegistry.addMaterial(white);
		
		materials.put("white", white);
		materials.put("orange", orange);
		materials.put("magenta", magenta);
		materials.put("lightblue", lightblue);
		materials.put("yellow", yellow);
		materials.put("lime", lime);
		materials.put("pink", pink);
		materials.put("gray", gray);
		materials.put("lightgray", lightgray);
		materials.put("cyan", cyan);
		materials.put("purple", purple);
		materials.put("blue", blue);
		materials.put("brown", brown);
		materials.put("green", green);
		materials.put("red", red);
		materials.put("black", black);
		
		TinkerRegistry.integrate(new MaterialIntegration(white).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(orange).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(magenta).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(lightblue).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(yellow).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(lime).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(pink).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(gray).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(lightgray).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(cyan).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(purple).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(blue).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(brown).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(green).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(red).toolforge()).preInit();
		TinkerRegistry.integrate(new MaterialIntegration(black).toolforge()).preInit();
		
//		TinkerRegistry.addMaterialStats(black, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(red, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(green, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(brown, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(blue, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(purple, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(cyan, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(lightgray, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(gray, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(pink, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(lime, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(yellow, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(lightblue, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(magenta, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(orange, new MaterialCloth(100));
//		TinkerRegistry.addMaterialStats(white, new MaterialCloth(100));
	}

	// PlusTIC to the rescue
	public static void integrate(Map<String, Material> materials, Map<String, MaterialIntegration> materialIntegrations, Collection<String> excludedMaterials)
	{
		materials.forEach((k, v) ->
		{
			if (!materialIntegrations.containsKey(k) && !excludedMaterials.contains(k))
			{
				MaterialIntegration mi;
				if (v.getFluid() != null && v.getFluid() != TinkerFluids.emerald)
				{
					mi = new MaterialIntegration(v, v.getFluid(), StringUtils.capitalize(k)).toolforge();
				} else
				{
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
