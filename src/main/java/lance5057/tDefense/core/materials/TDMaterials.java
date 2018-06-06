package lance5057.tDefense.core.materials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.eventbus.Subscribe;

import gnu.trove.map.hash.THashMap;
import gnu.trove.set.hash.THashSet;
import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.items.TDOreDictItem;
import lance5057.tDefense.core.library.TDMatHelper;
import lance5057.tDefense.core.materials.stats.ArmorMaterialStats;
import lance5057.tDefense.core.materials.stats.BaubleMaterialStats;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
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
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.shared.TinkerCommons;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.smeltery.block.BlockMolten;
import slimeknights.tconstruct.tools.TinkerMaterials;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDMaterials
{

	// public static final List<Material> materials = Lists.newArrayList();
	ArmorMaterialStats ams = new ArmorMaterialStats(0, 0, 0, 0, "");

	String	SHIELD	= ShieldMaterialStats.TYPE;
	String	HELM	= HelmMaterialStats.TYPE;
	String	CHEST	= ChestMaterialStats.TYPE;
	String	LEGS	= LegsMaterialStats.TYPE;
	String	BOOTS	= FeetMaterialStats.TYPE;
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
				.setShield(new ShieldMaterialStats(500 / 4, 85))
				.setBow(new BowMaterialStats(0.75f, 1.0f, 2.5f))
				.setHelm(new HelmMaterialStats(500, 2, 2, 0f))
				.setChest(new ChestMaterialStats(500, 6, 3, 0f))
				.setLegs(new LegsMaterialStats(500, 5, 3, 0f))
				.setBoots(new FeetMaterialStats(500, 3, 2, 0f)),
		new TDMatHelper("queensgold", 0xdcff00, fluids.put("queensgold", new FluidMolten("queensgold", 0xdcff00)), true).setHead(new HeadMaterialStats(70, 3.00f, 3.00f, HarvestLevels.IRON))
				.setHandle(new HandleMaterialStats(1.05f, -45))
				.setExtra(new ExtraMaterialStats(20))
				.setShield(new ShieldMaterialStats(70 / 4, 57))
				.setBow(new BowMaterialStats(1.1f, 1.0f, 0.5f))
				.setHelm(new HelmMaterialStats(70, 2, 1, 20f))
				.setChest(new ChestMaterialStats(70, 6, 2, 30f))
				.setLegs(new LegsMaterialStats(70, 5, 2, 20f))
				.setBoots(new FeetMaterialStats(70, 2, 1, 15f)),
		new TDMatHelper("dogbearium", 0x6d3300, fluids.put("dogbearium", new FluidMolten("dogbearium", 0x6d3300)), true).setHead(new HeadMaterialStats(150, 5.00f, 9.00f, HarvestLevels.DIAMOND))
				.setHandle(new HandleMaterialStats(0.85f, 75))
				.setExtra(new ExtraMaterialStats(75))
				.setShield(new ShieldMaterialStats(150 / 4, 75))
				.setBow(new BowMaterialStats(0.1f, 0.5f, 5.5f))
				.setHelm(new HelmMaterialStats(150, 3, 3, -60f))
				.setChest(new ChestMaterialStats(150, 8, 4, -60f))
				.setLegs(new LegsMaterialStats(150, 6, 4, -60f))
				.setBoots(new FeetMaterialStats(150, 3, 3, -60f)),
		new TDMatHelper("sinisterium", 0x210000, fluids.put("sinisterium", new FluidMolten("sinisterium", 0x210000)), true).setHead(new HeadMaterialStats(224, 5.00f, 5.00f, HarvestLevels.DIAMOND))
				.setHandle(new HandleMaterialStats(0.75f, 99))
				.setExtra(new ExtraMaterialStats(99))
				.setShield(new ShieldMaterialStats(224 / 4, 55))
				.setBow(new BowMaterialStats(2.1f, 1.6f, 7.2f))
				.setHelm(new HelmMaterialStats(224, 2, 0, 9.5f))
				.setChest(new ChestMaterialStats(224, 6, 0, 10.5f))
				.setLegs(new LegsMaterialStats(224, 5, 0, 10.0f))
				.setBoots(new FeetMaterialStats(224, 2, 0, 9.5f)),
		new TDMatHelper("nihilite", 0x000021, fluids.put("nihilite", new FluidMolten("nihilite", 0x000021)), true).setHead(new HeadMaterialStats(400, 9.7f, 7.1f, HarvestLevels.COBALT))
				.setHandle(new HandleMaterialStats(0.9f, 70))
				.setExtra(new ExtraMaterialStats(74))
				.setShield(new ShieldMaterialStats(400 / 4, 95))
				.setBow(new BowMaterialStats(0.9f, 1.7f, -1f))
				.setHelm(new HelmMaterialStats(400, 2, 0, 19))
				.setChest(new ChestMaterialStats(400, 5, 0, 15))
				.setLegs(new LegsMaterialStats(400, 4, 0, 15))
				.setBoots(new FeetMaterialStats(400, 2, 0, 19)),
		new TDMatHelper("orichalcum", 0xffc700, fluids.put("orichalcum", new FluidMolten("orichalcum", 0xffc700)), true).setHead(new HeadMaterialStats(180, 5.3f, 6.23f, HarvestLevels.OBSIDIAN))
				.setHandle(new HandleMaterialStats(1.1f, 25))
				.setExtra(new ExtraMaterialStats(35))
				.setShield(new ShieldMaterialStats(180 / 4, 70))
				.setBow(new BowMaterialStats(1.9f, 1.9f, 2.3f))
				.setHelm(new HelmMaterialStats(180, 2, 2, 20.5f))
				.setChest(new ChestMaterialStats(180, 6, 3, 20.5f))
				.setLegs(new LegsMaterialStats(180, 5, 3, 20.5f))
				.setBoots(new FeetMaterialStats(180, 2, 3, 20.5f)),
		new TDMatHelper("pandorium", 0x7f6a00, fluids.put("pandorium", new FluidMolten("pandorium", 0x7f6a00)), true).setHead(new HeadMaterialStats(999, 10.2f, 8.72f, HarvestLevels.OBSIDIAN))
				.setHandle(new HandleMaterialStats(0.4f, 999))
				.setExtra(new ExtraMaterialStats(99))
				.setShield(new ShieldMaterialStats(999 / 4, 100))
				.setBow(new BowMaterialStats(3f, 0.9f, 9f))
				.setHelm(new HelmMaterialStats(999, 3, 3, -70.0f))
				.setChest(new ChestMaterialStats(999, 8, 4, -70.0f))
				.setLegs(new LegsMaterialStats(999, 6, 4, -70.0f))
				.setBoots(new FeetMaterialStats(999, 3, 3, -70.0f)),
		new TDMatHelper("rosegold", 0xff9b84, fluids.put("rosegold", new FluidMolten("rosegold", 0xff9b84)), true).setHead(new HeadMaterialStats(99, 4f, 1f, HarvestLevels.STONE))
				.setHandle(new HandleMaterialStats(1.5f, -90))
				.setExtra(new ExtraMaterialStats(-90))
				.setShield(new ShieldMaterialStats(99 / 4, 24))
				.setBow(new BowMaterialStats(0.1f, 0.1f, -2f))
				.setHelm(new HelmMaterialStats(99, 1, 0, 23.0f))
				.setChest(new ChestMaterialStats(99, 4, 0, 23.0f))
				.setLegs(new LegsMaterialStats(99, 3, 0, 23.0f))
				.setBoots(new FeetMaterialStats(99, 1, 0, 23.0f)),
		new TDMatHelper("platinum", 0xe8e8e8, fluids.put("platinum", new FluidMolten("platinum", 0xe8e8e8)), true).setHead(new HeadMaterialStats(99, 3.7f, 4f, HarvestLevels.IRON))
				.setHandle(new HandleMaterialStats(1.5f, -90))
				.setExtra(new ExtraMaterialStats(-90))
				.setShield(new ShieldMaterialStats(99 / 4, 14))
				.setBow(new BowMaterialStats(0.1f, 0.1f, -2f))
				.setHelm(new HelmMaterialStats(99, 1, 1, 19.0f))
				.setChest(new ChestMaterialStats(99, 4, 1, 19.0f))
				.setLegs(new LegsMaterialStats(99, 3, 1, 19.0f))
				.setBoots(new FeetMaterialStats(99, 1, 1, 19.0f)),
		new TDMatHelper("brass", 0xdbb332, fluids.put("brass", new FluidMolten("brass", 0xdbb332)), true).setHead(new HeadMaterialStats(380, 5f, 3f, HarvestLevels.IRON))
				.setHandle(new HandleMaterialStats(0.85f, 90))
				.setExtra(new ExtraMaterialStats(75))
				.setShield(new ShieldMaterialStats(380 / 4, 50))
				.setBow(new BowMaterialStats(0.1f, 0.5f, -1f))
				.setHelm(new HelmMaterialStats(380, 2, 1, 4.5f))
				.setChest(new ChestMaterialStats(380, 3, 2, 4.5f))
				.setLegs(new LegsMaterialStats(380, 2, 2, 4.5f))
				.setBoots(new FeetMaterialStats(380, 2, 2, 4.5f)),
		new TDMatHelper("silver", 0x9e9e9e, new FluidMolten("silver", 0x9e9e9e), false),
		new TDMatHelper("gold", 0xfff428, TinkerFluids.gold, true).setIngot(Items.GOLD_INGOT)
				.setNugget(Items.GOLD_NUGGET)
				.setHead(new HeadMaterialStats(100, 1f, 1f, HarvestLevels.STONE))
				.setHandle(new HandleMaterialStats(0.25f, 10))
				.setExtra(new ExtraMaterialStats(25))
				.setShield(new ShieldMaterialStats(100 / 4, 14))
				.setBow(new BowMaterialStats(0.2f, 0.4f, -1f))
				.setHelm(new HelmMaterialStats(100, 1, 0, 33f))
				.setChest(new ChestMaterialStats(100, 4, 0, 33f))
				.setLegs(new LegsMaterialStats(100, 3, 0, 33f))
				.setBoots(new FeetMaterialStats(100, 1, 0, 33f)),
		new TDMatHelper("valyriansteel", 0xe2d9e2, fluids.put("valyriansteel", new FluidMolten("valyriansteel", 0xe2d9e2)), true).setHead(new HeadMaterialStats(610, 7f, 7f, HarvestLevels.OBSIDIAN))
				.setHandle(new HandleMaterialStats(0.9f, 180))
				.setExtra(new ExtraMaterialStats(125))
				.setShield(new ShieldMaterialStats(610 / 4, 85))
				.setBow(new BowMaterialStats(1.6f, 1.5f, 3f))
				.setHelm(new HelmMaterialStats(610, 3, 3, 0))
				.setChest(new ChestMaterialStats(610, 7, 4, 0))
				.setLegs(new LegsMaterialStats(610, 6, 2, 0))
				.setBoots(new FeetMaterialStats(610, 3, 3, 0)),
		new TDMatHelper("froststeel", 0xc6dcff, fluids.put("froststeel", new FluidMolten("froststeel", 0xc6dcff)), true).setHead(new HeadMaterialStats(610, 7f, 7f, HarvestLevels.OBSIDIAN))
				.setHandle(new HandleMaterialStats(1.1f, 110))
				.setExtra(new ExtraMaterialStats(125))
				.setShield(new ShieldMaterialStats(610 / 4, 85))
				.setBow(new BowMaterialStats(1.6f, 1.5f, 3f))
				.setHelm(new HelmMaterialStats(610, 2, 2, 0))
				.setChest(new ChestMaterialStats(610, 6, 3, 0))
				.setLegs(new LegsMaterialStats(610, 5, 2, 0))
				.setBoots(new FeetMaterialStats(610, 3, 1, 0)),
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
	//
	// new TDMatHelper("white cloth", 0xDDDDDD, null, true, true,
	// false).setGem(new ItemStack(Blocks.WOOL, 0, 1)).setCloth(new
	// ClothMaterialStats(100, 0, 0, 25)),
	// new TDMatHelper("orange cloth", 0xDB7D3E, null, true, true,
	// false).setGem(new ItemStack(Blocks.WOOL, 0, 1)).setCloth(new
	// ClothMaterialStats(100, 0, 0, 25))

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
		// if (TinkersDefense.config.materials.enableJokeMaterials)
		// this.materials_master.addAll(this.materials_joke);
		// if (TinkersDefense.config.materials.enableHolidayMaterials)
		// this.materials_master.addAll(materials_xmas);
		// if (TinkersDefense.config.materials.enableGemMaterials)
		// this.materials_master.addAll(materials_gems);
		// if (TinkersDefense.config.materials.enableCornucopiaMaterials)
		// this.materials_master.addAll(materials_cornucopia);
		// if (TinkersDefense.config.materials.enableTwilightForestMaterials)
		// this.materials_master.addAll(materials_tf);
		// if (TinkersDefense.config.materials.enableBloodMagicMaterials)
		// this.materials_master.addAll(materials_bm);
		// if (TinkersDefense.config.materials.enableHarvestCraftMaterials)
		// this.materials_master.addAll(materials_pam);

		Material.UNKNOWN.addStats(new ShieldMaterialStats(35, 33));
		Material.UNKNOWN.addStats(new HelmMaterialStats(35, 1, 0, 0));
		Material.UNKNOWN.addStats(new ChestMaterialStats(35, 1, 0, 0));
		Material.UNKNOWN.addStats(new LegsMaterialStats(35, 1, 0, 0));
		Material.UNKNOWN.addStats(new FeetMaterialStats(35, 1, 0, 0));
		Material.UNKNOWN.addStats(new FabricMaterialStats(35, 0, 0, 0));
		Material.UNKNOWN.addStats(new BaubleMaterialStats(35));

		registerClothMaterials();

		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new ShieldMaterialStats(35, 25));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new HelmMaterialStats(35, 1, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new ChestMaterialStats(35, 3, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new LegsMaterialStats(35, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new FeetMaterialStats(35, 1, 0, 0));
		// TinkerMaterials.wood.addTrait(axelover, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new ShieldMaterialStats(120, 30));
		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new HelmMaterialStats(120, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new ChestMaterialStats(120, 4, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new LegsMaterialStats(120, 3, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new FeetMaterialStats(120, 2, 0, 0));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.stone, dulling,
		// SHIELD);
		// TinkerMaterials.stone.addTrait(dulling, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new ShieldMaterialStats(150, 30));
		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new HelmMaterialStats(150, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new ChestMaterialStats(150, 4, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new LegsMaterialStats(150, 3, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new FeetMaterialStats(150, 2, 0, 0));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.flint,
		// firestarter,
		// SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new ShieldMaterialStats(210, 25));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new HelmMaterialStats(210, 1, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new ChestMaterialStats(210, 3, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new LegsMaterialStats(210, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new FeetMaterialStats(210, 1, 0, 0));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.cactus, barbed,
		// SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new ShieldMaterialStats(200, 40));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new HelmMaterialStats(200, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new ChestMaterialStats(200, 4, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new LegsMaterialStats(200, 4, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new FeetMaterialStats(200, 2, 0, 0));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.bone, dogtoy,
		// SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new ShieldMaterialStats(139, 50));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new HelmMaterialStats(139, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new ChestMaterialStats(139, 6, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new LegsMaterialStats(139, 5, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new FeetMaterialStats(139, 2, 0, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new ShieldMaterialStats(430, 45));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new HelmMaterialStats(430, 2, 0, 2.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new ChestMaterialStats(430, 5, 0, 3.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new LegsMaterialStats(430, 5, 0, 3.0f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new FeetMaterialStats(430, 2, 0, 2.5f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new ShieldMaterialStats(420, 50));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new HelmMaterialStats(420, 3, 1, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new ChestMaterialStats(420, 6, 1, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new LegsMaterialStats(420, 5, 1, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new FeetMaterialStats(420, 3, 1, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new ShieldMaterialStats(12, 10));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new HelmMaterialStats(12, 1, 0, 4));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new ChestMaterialStats(12, 2, 0, 5.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new LegsMaterialStats(12, 1, 0, 5));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new FeetMaterialStats(12, 1, 0, 4));

		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new ShieldMaterialStats(550, 20));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new HelmMaterialStats(550, 1, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new ChestMaterialStats(550, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new LegsMaterialStats(550, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new FeetMaterialStats(550, 1, 0, 0));
		// TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new
		// FabricMaterialStats(550, 0, 0, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new ShieldMaterialStats(550, 25));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new HelmMaterialStats(550, 1, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new ChestMaterialStats(550, 3, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new LegsMaterialStats(550, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new FeetMaterialStats(550, 1, 0, 0));

		// Slime
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new ShieldMaterialStats(1000, 5));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new HelmMaterialStats(1000, 1, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new ChestMaterialStats(1000, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new LegsMaterialStats(1000, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new FeetMaterialStats(1000, 1, 0, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new ShieldMaterialStats(780, 7));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new HelmMaterialStats(780, 1, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new ChestMaterialStats(780, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new LegsMaterialStats(780, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new FeetMaterialStats(780, 1, 0, 0));

		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new ShieldMaterialStats(850, 27));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new HelmMaterialStats(850, 2, 1, 1.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new ChestMaterialStats(850, 6, 1, 2.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new LegsMaterialStats(850, 5, 1, 2.0f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new FeetMaterialStats(850, 2, 1, 1.5f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new ShieldMaterialStats(600, 6));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new HelmMaterialStats(600, 1, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new ChestMaterialStats(600, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new LegsMaterialStats(600, 2, 0, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new FeetMaterialStats(600, 1, 0, 0));

		// Nether
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new ShieldMaterialStats(270, 20));
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new HelmMaterialStats(270, 1, 0, -12));
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new ChestMaterialStats(270, 3, 0, -12));
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new LegsMaterialStats(270, 2, 0, -12));
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new FeetMaterialStats(270, 1, 0, -12));

		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new ShieldMaterialStats(780, 55));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new HelmMaterialStats(780, 3, 0, 5));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new ChestMaterialStats(780, 7, 0, 5));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new LegsMaterialStats(780, 5, 0, 5));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new FeetMaterialStats(780, 3, 0, 5));

		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new ShieldMaterialStats(990, 75));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new HelmMaterialStats(990, 3, 3, -100));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new ChestMaterialStats(990, 8, 4, -100));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new LegsMaterialStats(990, 6, 4, -100));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new FeetMaterialStats(990, 3, 3, -100));

		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new ShieldMaterialStats(820, 60));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new HelmMaterialStats(820, 3, 2, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new ChestMaterialStats(820, 8, 2, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new LegsMaterialStats(820, 6, 2, 0));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new FeetMaterialStats(820, 3, 2, 0));

		// Metals
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new ShieldMaterialStats(204, 50));
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new HelmMaterialStats(204, 2, 0, -4));
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new ChestMaterialStats(204, 6, 0, -5));
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new LegsMaterialStats(204, 5, 0, -4));
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new FeetMaterialStats(204, 2, 0, -3));

		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new ShieldMaterialStats(380, 52));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new HelmMaterialStats(380, 2, 0, 0.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new ChestMaterialStats(380, 6, 0, 1.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new LegsMaterialStats(380, 5, 0, 1));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new FeetMaterialStats(380, 2, 0, 0.5f));

		// Mod Integration
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new ShieldMaterialStats(210, 34));
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new HelmMaterialStats(210, 1, 0, 3));
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new ChestMaterialStats(210, 4, 0, 3));
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new LegsMaterialStats(210, 3, 0, 3));
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new FeetMaterialStats(210, 1, 0, 3));

		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new ShieldMaterialStats(430, 50));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new HelmMaterialStats(430, 2, 0, 0.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new ChestMaterialStats(430, 6, 0, 0.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new LegsMaterialStats(430, 5, 0, 0.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new FeetMaterialStats(430, 2, 0, 0.5f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new ShieldMaterialStats(334, 42));
		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new HelmMaterialStats(334, 1, 0, -20));
		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new ChestMaterialStats(334, 5, 0, -20));
		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new LegsMaterialStats(334, 4, 0, -20));
		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new FeetMaterialStats(334, 1, 0, -20));

		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new ShieldMaterialStats(250, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new HelmMaterialStats(250, 1, 0, 1.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new ChestMaterialStats(250, 3, 0, 1.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new LegsMaterialStats(250, 2, 0, 1.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new FeetMaterialStats(250, 1, 0, 1.5f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new ShieldMaterialStats(50, 22));
		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new HelmMaterialStats(50, 1, 0, 2.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new ChestMaterialStats(50, 3, 0, 2.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new LegsMaterialStats(50, 2, 0, 2.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new FeetMaterialStats(50, 1, 0, 2.5f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new ShieldMaterialStats(540, 55));
		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new HelmMaterialStats(540, 3, 1, -12));
		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new ChestMaterialStats(540, 7, 1, -12));
		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new LegsMaterialStats(540, 6, 1, -12));
		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new FeetMaterialStats(540, 3, 1, -12));

		for (String s : fluids.keySet())
		{
			createFluid(s, fluids.get(s));
			FluidRegistry.registerFluid(fluids.get(s));
			FluidRegistry.addBucketForFluid(fluids.get(s));

		}

		

		// TAIGA TEST
		Collection<Material> mats = TinkerRegistry.getAllMaterials();
		for (Material m : TinkerRegistry.getAllMaterials())
		{
			if (!m.hasStats(SHIELD))
			{
				if (m.hasStats(MaterialTypes.HEAD))
				{
					int dur = ((HeadMaterialStats) m.getStats(MaterialTypes.HEAD)).durability;
					m.addStats(new ShieldMaterialStats(dur, 33));
					m.addStats(new HelmMaterialStats(dur, 1, 0, 0));
					m.addStats(new ChestMaterialStats(dur, 1, 0, 0));
					m.addStats(new LegsMaterialStats(dur, 1, 0, 0));
					m.addStats(new FeetMaterialStats(dur, 1, 0, 0));
					// m.addStats(new ClothMaterialStats(dur, 1, 0, 0));
				}
			}
		}

		// Collection<Material> mats = TinkerRegistry.getAllMaterials();
		// mats.isEmpty();
		//
		// Set<IToolPart> parts = TinkerRegistry.getToolParts();
		// parts.size();
	}

	void createMaterial(TDMatHelper tdmat)
	{
		Material mat = new Material(tdmat.name, tdmat.color);

		if (tdmat.isGem)
		{
			if (tdmat.gem == null)
			{
				if (tdmat.createParts)
				{
					mat.addItem("gem" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
					mat.addItem(gem.getItembyName(tdmat.name), 1, Material.VALUE_Ingot);
				}
			} else
				mat.addItem(tdmat.gem, 1, Material.VALUE_Ingot);
		} else
		{
			if (tdmat.ingot == null)
			{
				if (tdmat.createParts)
				{
					mat.addItem("ingot" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
					mat.addItem(ingot.getItembyName(tdmat.name), 1, Material.VALUE_Ingot);
				}
			} else
				mat.addItem(tdmat.ingot, 1, Material.VALUE_Ingot);
		}
		if (tdmat.nugget == null)
		{
			if (tdmat.createParts)
			{
				mat.addItem("nugget" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
				mat.addItem(nugget.getItembyName(tdmat.name), 1, Material.VALUE_Nugget);
			}
		} else
			mat.addItem(tdmat.nugget, 1, Material.VALUE_Nugget);
		if (tdmat.dust == null)
		{
			if (tdmat.createParts)
			{
				mat.addItem("dust" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
				mat.addItem(nugget.getItembyName(tdmat.name), 1, Material.VALUE_Ingot);
			}
		} else
			mat.addItem(tdmat.nugget, 1, Material.VALUE_Ingot);
		if (tdmat.grain == null)
		{
			if (tdmat.createParts)
			{
				mat.addItem("grain" + tdmat.name.substring(0, 1).toUpperCase() + tdmat.name.substring(1));
				mat.addItem(nugget.getItembyName(tdmat.name), 1, Material.VALUE_Ingot / 4);
			}
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

		if (tdm.handle != null)
			TinkerRegistry.addMaterialStats(m, tdm.handle);

		if (tdm.extra != null)
			TinkerRegistry.addMaterialStats(m, tdm.extra);

		if (tdm.bow != null)
			TinkerRegistry.addMaterialStats(m, tdm.bow);

		if (tdm.shaft != null)
			TinkerRegistry.addMaterialStats(m, tdm.shaft);

		if (tdm.bowstring != null)
			TinkerRegistry.addMaterialStats(m, tdm.bowstring);

		if (tdm.shield != null)
			TinkerRegistry.addMaterialStats(m, tdm.shield);

		if (tdm.helm != null)
			TinkerRegistry.addMaterialStats(m, tdm.helm);

		if (tdm.chest != null)
			TinkerRegistry.addMaterialStats(m, tdm.chest);

		if (tdm.legs != null)
			TinkerRegistry.addMaterialStats(m, tdm.legs);

		if (tdm.boots != null)
			TinkerRegistry.addMaterialStats(m, tdm.boots);

		if (tdm.cloth != null)
			TinkerRegistry.addMaterialStats(m, tdm.cloth);
	}

	public void registerItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry registry = event.getRegistry();

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
		registry.register(ingot);
		registry.register(dust);
		registry.register(nugget);
		registry.register(grain);
		registry.register(gem);
		
		for (TDMatHelper m : materials_master)
		{
			Material test = TinkerRegistry.getMaterial(m.name);
			if (m.createMat && test.getIdentifier() == "unknown" && !TinkersDefense.config.materials.isBlacklisted(m.name))
				createMaterial(m);
		}
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
		black = new Material("blackCloth", 0x191616).setCraftable(true).setCastable(false);
		;
		red = new Material("redCloth", 0x963430).setCraftable(true).setCastable(false);
		;
		green = new Material("greeCloth", 0x35461B).setCraftable(true).setCastable(false);
		;
		brown = new Material("brownCloth", 0x4F321F).setCraftable(true).setCastable(false);
		;
		blue = new Material("blueCloth", 0x2E388D).setCraftable(true).setCastable(false);
		;
		purple = new Material("purpleCloth", 0x7E3DB5).setCraftable(true).setCastable(false);
		;
		cyan = new Material("cyanCloth", 0x2E6E89).setCraftable(true).setCastable(false);
		;
		lightgray = new Material("lightgrayCloth", 0x9AA1A1).setCraftable(true).setCastable(false);
		;
		gray = new Material("grayCloth", 0x404040).setCraftable(true).setCastable(false);
		;
		pink = new Material("pinkCloth", 0xD08499).setCraftable(true).setCastable(false);
		;
		lime = new Material("limeCloth", 0x41AE38).setCraftable(true).setCastable(false);
		;
		yellow = new Material("yellowCloth", 0xB1A627).setCraftable(true).setCastable(false);
		;
		lightblue = new Material("lightblueCloth", 0x6B8AC9).setCraftable(true).setCastable(false);
		;
		magenta = new Material("magentaCloth", 0xB350BC).setCraftable(true).setCastable(false);
		;
		orange = new Material("orangeCloth", 0xDB7D3E).setCraftable(true).setCastable(false);
		;
		white = new Material("whiteCloth", 0xDDDDDD).setCraftable(true).setCastable(false);
		;

		// Material.UNKNOWN.addStats(new MaterialCloth(100));
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

		TinkerRegistry.addMaterialStats(this.white, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.black, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.blue, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.brown, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.cyan, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.gray, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.green, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.lightblue, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.lightgray, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.lime, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.magenta, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.orange, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.pink, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.purple, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.red, new FabricMaterialStats(100, 10, 0, 25));
		TinkerRegistry.addMaterialStats(this.yellow, new FabricMaterialStats(100, 10, 0, 25));

		// TinkerRegistry.addMaterialStats(this.white, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.black, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.blue, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.brown, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.cyan, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.gray, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.green, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.lightblue, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.lightgray, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.lime, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.magenta, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.orange, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.pink, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.purple, new
		// ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.red, new ExtraMaterialStats(5));
		// TinkerRegistry.addMaterialStats(this.yellow, new
		// ExtraMaterialStats(5));

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

		// TinkerRegistry.addMaterialStats(black, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(red, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(green, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(brown, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(blue, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(purple, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(cyan, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(lightgray, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(gray, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(pink, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(lime, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(yellow, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(lightblue, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(magenta, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(orange, new MaterialCloth(100));
		// TinkerRegistry.addMaterialStats(white, new MaterialCloth(100));
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
