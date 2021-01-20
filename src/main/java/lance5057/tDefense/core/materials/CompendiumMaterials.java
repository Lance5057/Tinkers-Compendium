package lance5057.tDefense.core.materials;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.eventbus.Subscribe;

import gnu.trove.map.hash.THashMap;
import lance5057.tDefense.Reference;
import lance5057.tDefense.TCConfig;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.library.materialutilities.CraftableFabricMaterial;
import lance5057.tDefense.core.library.materialutilities.MaterialHelper;
import lance5057.tDefense.core.materials.stats.ArmorMaterialStats;
import lance5057.tDefense.core.materials.stats.BaubleMaterialStats;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import lance5057.tDefense.core.parts.ComponentPart;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidBase;
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
import net.minecraftforge.registries.IForgeRegistryEntry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.fluid.FluidColored;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.BowStringMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.smeltery.AlloyRecipe;
import slimeknights.tconstruct.smeltery.block.BlockMolten;
import slimeknights.tconstruct.smeltery.block.BlockTinkerFluid;
import slimeknights.tconstruct.tools.TinkerMaterials;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CompendiumMaterials {
	ArmorMaterialStats ams = new ArmorMaterialStats(0, 0, 0, 0, "");

	public static BowMaterialStats whyWouldYouMakeABowOutOfThis = new BowMaterialStats(0.2f, 0.4f, -1f);

	String SHIELD = ShieldMaterialStats.TYPE;
	String HELM = HelmMaterialStats.TYPE;
	String CHEST = ChestMaterialStats.TYPE;
	String LEGS = LegsMaterialStats.TYPE;
	String BOOTS = FeetMaterialStats.TYPE;
	String BAUBLE = BaubleMaterialStats.TYPE;

	public static final Map<String, Integer> colors = new THashMap();

//
	public static List<MaterialHelper> materials = new ArrayList<>();

	// Wool Colors

	public static MaterialHelper black;
	public static MaterialHelper red;
	public static MaterialHelper green;
	public static MaterialHelper brown;
	public static MaterialHelper blue;
	public static MaterialHelper purple;
	public static MaterialHelper cyan;
	public static MaterialHelper lightgray;
	public static MaterialHelper gray;
	public static MaterialHelper pink;
	public static MaterialHelper lime;
	public static MaterialHelper yellow;
	public static MaterialHelper lightblue;
	public static MaterialHelper magenta;
	public static MaterialHelper orange;
	public static MaterialHelper white;

	@Subscribe
	public void preInit(FMLPreInitializationEvent event) {

		if (TCConfig.materials.cloth) {
			if (TinkerRegistry.getMaterial("blackcloth") == Material.UNKNOWN && TCConfig.materials.black) {
				black = new MaterialHelper("blackcloth", 0x191616);
				black.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 15)));
				materials.add(black);
			}

			if (TinkerRegistry.getMaterial("redcloth") == Material.UNKNOWN && TCConfig.materials.red) {
				red = new MaterialHelper("redcloth", 0x963430);
				red.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 14)));
				materials.add(red);
			}

			if (TinkerRegistry.getMaterial("greencloth") == Material.UNKNOWN && TCConfig.materials.green) {
				green = new MaterialHelper("greencloth", 0x35461B);
				green.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 13)));
				materials.add(green);
			}

			if (TinkerRegistry.getMaterial("browncloth") == Material.UNKNOWN && TCConfig.materials.brown) {
				brown = new MaterialHelper("browncloth", 0x4F321F);
				brown.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 12)));
				materials.add(brown);
			}

			if (TinkerRegistry.getMaterial("bluecloth") == Material.UNKNOWN && TCConfig.materials.blue) {
				blue = new MaterialHelper("bluecloth", 0x2E388D);
				blue.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 11)));
				materials.add(blue);
			}

			if (TinkerRegistry.getMaterial("purplecloth") == Material.UNKNOWN && TCConfig.materials.purple) {
				purple = new MaterialHelper("purplecloth", 0x7E3DB5);
				purple.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 10)));
				materials.add(purple);
			}

			if (TinkerRegistry.getMaterial("cyancloth") == Material.UNKNOWN && TCConfig.materials.cyan) {
				cyan = new MaterialHelper("cyancloth", 0x2E6E89);
				cyan.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 9)));
				materials.add(cyan);
			}

			if (TinkerRegistry.getMaterial("lightgraycloth") == Material.UNKNOWN && TCConfig.materials.lightgray) {
				lightgray = new MaterialHelper("lightgraycloth", 0x9AA1A1);
				lightgray.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 8)));
				materials.add(lightgray);
			}

			if (TinkerRegistry.getMaterial("graycloth") == Material.UNKNOWN && TCConfig.materials.gray) {
				gray = new MaterialHelper("graycloth", 0x404040);
				gray.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 7)));
				materials.add(gray);
			}

			if (TinkerRegistry.getMaterial("pinkcloth") == Material.UNKNOWN && TCConfig.materials.pink) {
				pink = new MaterialHelper("pinkcloth", 0xD08499);
				pink.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 6)));
				materials.add(pink);
			}

			if (TinkerRegistry.getMaterial("limecloth") == Material.UNKNOWN && TCConfig.materials.lime) {
				lime = new MaterialHelper("limecloth", 0x41AE38);
				lime.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 5)));
				materials.add(lime);
			}

			if (TinkerRegistry.getMaterial("yellowcloth") == Material.UNKNOWN && TCConfig.materials.yellow) {
				yellow = new MaterialHelper("yellowcloth", 0xB1A627);
				yellow.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 4)));
				materials.add(yellow);
			}

			if (TinkerRegistry.getMaterial("lightbluecloth") == Material.UNKNOWN && TCConfig.materials.lightblue) {
				lightblue = new MaterialHelper("lightbluecloth", 0x6B8AC9);
				lightblue.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 3)));
				materials.add(lightblue);
			}

			if (TinkerRegistry.getMaterial("magentacloth") == Material.UNKNOWN && TCConfig.materials.magenta) {
				magenta = new MaterialHelper("magentacloth", 0xB350BC);
				magenta.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 2)));
				materials.add(magenta);
			}

			if (TinkerRegistry.getMaterial("orangecloth") == Material.UNKNOWN && TCConfig.materials.orange) {
				orange = new MaterialHelper("orangecloth", 0xDB7D3E);
				orange.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 1)));
				materials.add(orange);
			}

			if (TinkerRegistry.getMaterial("whitecloth") == Material.UNKNOWN && TCConfig.materials.white) {
				white = new MaterialHelper("whitecloth", 0xDDDDDD);
				white.addons.add(new CraftableFabricMaterial(new FabricMaterialStats(100, 0, 0, 100),
						new BowStringMaterialStats(1), null,
						new ItemStack(Blocks.WOOL, 1, 0)));
				materials.add(white);
			}
		}


		Material.UNKNOWN.addStats(new ShieldMaterialStats(35, 33));
		Material.UNKNOWN.addStats(new HelmMaterialStats(35, 1, 0, 0));
		Material.UNKNOWN.addStats(new ChestMaterialStats(35, 1, 0, 0));
		Material.UNKNOWN.addStats(new LegsMaterialStats(35, 1, 0, 0));
		Material.UNKNOWN.addStats(new FeetMaterialStats(35, 1, 0, 0));
		Material.UNKNOWN.addStats(new FabricMaterialStats(35, 0, 0, 0));
		Material.UNKNOWN.addStats(new BaubleMaterialStats(35));

		for (MaterialHelper m : materials)
			m.pre();
		for (MaterialHelper m : materials)
			m.integrate();

		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new ShieldMaterialStats(35, 25));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new HelmMaterialStats(35, 1, 0, 0.2f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new ChestMaterialStats(35, 3, 0, 0.4f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new LegsMaterialStats(35, 2, 0, 0.3f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new FeetMaterialStats(35, 1, 0, 0.1f));
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
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new HelmMaterialStats(200, 2, 3, 0.8f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new ChestMaterialStats(200, 4, 3, 1.4f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new LegsMaterialStats(200, 4, 3, 1.0f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new FeetMaterialStats(200, 2, 3, 0.5f));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.bone, dogtoy,
		// SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new ShieldMaterialStats(139, 50));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new HelmMaterialStats(139, 2, 0, 1.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new ChestMaterialStats(139, 6, 0, 2.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new LegsMaterialStats(139, 5, 0, 1.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new FeetMaterialStats(139, 2, 0, 0.5f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new ShieldMaterialStats(430, 45));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new HelmMaterialStats(430, 2, 0, 2.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new ChestMaterialStats(430, 5, 0, 3.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new LegsMaterialStats(430, 5, 0, 3.0f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new FeetMaterialStats(430, 2, 0, 2.5f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new ShieldMaterialStats(420, 50));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new HelmMaterialStats(420, 3, 1, 0.4f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new ChestMaterialStats(420, 6, 1, 0.8f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new LegsMaterialStats(420, 5, 1, 0.6f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new FeetMaterialStats(420, 3, 1, 0.2f));

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
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new HelmMaterialStats(550, 1, 0, 0.2f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new ChestMaterialStats(550, 3, 0, 0.4f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new LegsMaterialStats(550, 2, 0, 0.4f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new FeetMaterialStats(550, 1, 0, 0.2f));

		// Slime
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new ShieldMaterialStats(1000, 5));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new HelmMaterialStats(1000, 1, 0, 0.6f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new ChestMaterialStats(1000, 2, 0, 1.0f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new LegsMaterialStats(1000, 2, 0, 0.9f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new FeetMaterialStats(1000, 1, 0, 0.4f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new ShieldMaterialStats(780, 7));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new HelmMaterialStats(780, 1, 0, 0.6f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new ChestMaterialStats(780, 2, 0, 1.0f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new LegsMaterialStats(780, 2, 0, 0.9f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new FeetMaterialStats(780, 1, 0, 0.4f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new ShieldMaterialStats(850, 27));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new HelmMaterialStats(850, 2, 1, 1.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new ChestMaterialStats(850, 6, 1, 2.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new LegsMaterialStats(850, 5, 1, 2.0f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new FeetMaterialStats(850, 2, 1, 1.5f));

		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new ShieldMaterialStats(600, 6));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new HelmMaterialStats(600, 1, 0, 1.0f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new ChestMaterialStats(600, 2, 0, 2.0f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new LegsMaterialStats(600, 2, 0, 1.5f));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new FeetMaterialStats(600, 1, 0, 0.9f));

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
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new HelmMaterialStats(990, 3, 3, 1));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new ChestMaterialStats(990, 8, 4, 1));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new LegsMaterialStats(990, 6, 4, 1));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new FeetMaterialStats(990, 3, 3, 1));

		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new ShieldMaterialStats(820, 60));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new HelmMaterialStats(820, 3, 2, 6));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new ChestMaterialStats(820, 8, 2, 6));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new LegsMaterialStats(820, 6, 2, 6));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new FeetMaterialStats(820, 3, 2, 6));

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

	}

//	public void registerItems(final RegistryEvent.Register<Item> event) {
//		final IForgeRegistry registry = event.getRegistry();
//
//		for (Item i : itemList) {
//			registry.register(i);
//		}
//	}

	@Subscribe
	public void init(FMLInitializationEvent event) {

		// if (!TD_Config.materials.isBlacklisted("pureardite") &&
		// !TD_Config.materials.isBlacklisted("purifiedgold"))
		// TinkerRegistry.registerAlloy(new
		// FluidStack(getMaterialHelper("pureardite").fluid, 1),
		// new FluidStack(TinkerFluids.ardite, 1), new FluidStack(fluidDragonsBreath,
		// 2),
		// new FluidStack(TinkerFluids.blood, 2), new
		// FluidStack(getMaterialHelper("purifiedgold").fluid, 2));
		//
		// if (!TD_Config.materials.isBlacklisted("purecobalt")
		// &&!TD_Config.materials.isBlacklisted("purifiedsilver"))
		// TinkerRegistry.registerAlloy(new
		// FluidStack(getMaterialHelper("purecobalt").fluid, 1),
		// new FluidStack(TinkerFluids.cobalt, 1), new FluidStack(fluidDragonsBreath,
		// 2),
		// new FluidStack(fluidSlush, 2), new
		// FluidStack(getMaterialHelper("purifiedsilver").fluid, 2));
		//
		// if (!TD_Config.materials.isBlacklisted("puremanyullyn") &&
		// !TD_Config.materials.isBlacklisted("purecobalt")
		// && !TD_Config.materials.isBlacklisted("pureardite"))
		// TinkerRegistry.registerAlloy(new
		// FluidStack(getMaterialHelper("puremanyullyn").fluid, 2),
		// new FluidStack(getMaterialHelper("pureardite").fluid, 1),
		// new FluidStack(getMaterialHelper("purecobalt").fluid, 1));
		//
		// if (!TD_Config.materials.isBlacklisted("purifiedgold"))
		// TinkerRegistry.registerAlloy(new
		// FluidStack(getMaterialHelper("purifiedgold").fluid, 1),
		// new FluidStack(TinkerFluids.gold, 1), new FluidStack(fluidQuartz, 8),
		// new FluidStack(TinkerFluids.glass, 2), new
		// FluidStack(TinkerFluids.purpleSlime, 2));
		//
		// if (!TD_Config.materials.isBlacklisted("purifiedsilver"))
		// TinkerRegistry.registerAlloy(new
		// FluidStack(getMaterialHelper("purifiedsilver").fluid, 1),
		// new FluidStack(TinkerFluids.silver, 1), new FluidStack(fluidQuartz, 8),
		// new FluidStack(TinkerFluids.glass, 2), new
		// FluidStack(TinkerFluids.purpleSlime, 2));

		// if (!TD_Config.materials.isBlacklisted("nihilite"))
		// TinkerRegistry.registerAlloy(new FluidStack(fluids.get("solarium"), 1),
		// new FluidStack(TinkerFluids.steel, 1), new FluidStack(fluids.get("sundrop"),
		// 1));
		//
		// if (!TD_Config.materials.isBlacklisted("nihilite"))
		// TinkerRegistry.registerAlloy(new FluidStack(fluids.get("dragonsteel"), 1),
		// new FluidStack(TinkerFluids.steel, 1), new FluidStack(fluids.get("gallite"),
		// 1));
		//
		// if (!TD_Config.materials.isBlacklisted("nihilite"))
		// TinkerRegistry.registerAlloy(new FluidStack(fluids.get("blacksteel"), 1), new
		// FluidStack(TinkerFluids.steel, 1),
		// new FluidStack(fluids.get("voidite"), 1));
		//
		// if (!TD_Config.materials.isBlacklisted("nihilite"))
		// TinkerRegistry.registerAlloy(new FluidStack(fluids.get("abyssalium"), 1),
		// new FluidStack(fluids.get("voidite"), 1), new
		// FluidStack(fluids.get("sundrop"), 1));
		// TinkerRegistry.registerAlloy(new FluidStack(fluids.get("depthsilver"), 1),
		// new FluidStack(TinkerFluids.silver, 1), new
		// FluidStack(fluids.get("abyssalium"), 1));
		// TinkerRegistry.registerAlloy(new FluidStack(fluids.get("moonsilver"), 1),
		// new FluidStack(TinkerFluids.silver, 1), new FluidStack(fluids.get("voidite"),
		// 1));
		// TinkerRegistry.registerAlloy(new FluidStack(fluids.get("novagold"), 1), new
		// FluidStack(TinkerFluids.gold, 1),
		// new FluidStack(fluids.get("sundrop"), 1));

//		if (TinkersCompendium.bloodmagic)
//			addonbloodmagic.init(event);

//		for (MaterialHelper m : materials) {
//			if (!TCConfig.materials.isBlacklisted(m.name))
//				m.setupClient();
//		}

		for (MaterialHelper m : materials)
			m.init();
		for (MaterialHelper m : materials)
			m.client();

		Collection<Material> mats = TinkerRegistry.getAllMaterials();
		for (Material m : TinkerRegistry.getAllMaterials()) {
			if (!m.hasStats(SHIELD)) {
				if (m.hasStats(MaterialTypes.HEAD)) {
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

	}

	@Subscribe
	public void postInit(FMLPostInitializationEvent event) {

		for (MaterialHelper m : materials)
			m.post();
	}

	void oreDictComponent(String name, ComponentPart item) {
		NonNullList<ItemStack> stacks = null;
		stacks = NonNullList.create();

		item.getSubItems(item.getCreativeTab(), stacks);

		for (ItemStack s : stacks) {
			String str = s.getTagCompound().getString("Material");
			OreDictionary.registerOre(name + StringUtils.capitalize(str), s);
		}
	}

	public static void registerAlloy(FluidStack output, FluidStack... components) {
		AlloyRecipe r = new AlloyRecipe(output, components);
		TinkerRegistry.registerAlloy(r);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		for (MaterialHelper m : materials)
			m.models();
	}

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
//		for (MaterialHelper m : materials) {
//			if (!TCConfig.materials.isBlacklisted(m.name))
//				m.setupRecipes(event);
//		}
	}

	static FluidColored regFluid(String name, int color, RegistryEvent.Register<Block> event) {
		FluidColored f = new FluidColored(name, color);
		f.setUnlocalizedName(Reference.MOD_ID + "." + name);
		FluidRegistry.registerFluid(f);
		FluidRegistry.addBucketForFluid(f);
		return f;
	}

	static FluidMolten regMoltenFluid(String name, int color, RegistryEvent.Register<Block> event) {
		FluidMolten f = new FluidMolten(name, color);
		f.setUnlocalizedName(Reference.MOD_ID + "." + name);
		FluidRegistry.registerFluid(f);
		FluidRegistry.addBucketForFluid(f);

		registerMoltenBlock(event.getRegistry(), f);

		TinkersCompendium.proxy.registerFluidModels(f);

		return f;
	}

	/** Registers a non-burning water based block for the fluid */
	public static BlockFluidBase registerClassicBlock(IForgeRegistry<Block> registry, Fluid fluid) {
		return registerBlock(registry, new BlockTinkerFluid(fluid, net.minecraft.block.material.Material.WATER),
				fluid.getName());
	}

	/** Registers a hot lava-based block for the fluid, prefix with molten_ */
	public static BlockMolten registerMoltenBlock(IForgeRegistry<Block> registry, Fluid fluid) {
		return registerBlock(registry, new BlockMolten(fluid), "molten_" + fluid.getName()); // molten_foobar prefix
	}

	protected static <T extends Block> T registerBlock(IForgeRegistry<Block> registry, T block, String name) {
		if (!name.equals(name.toLowerCase(Locale.US))) {
			throw new IllegalArgumentException(
					String.format("Unlocalized names need to be all lowercase! Block: %s", name));
		}

		String prefixedName = Util.prefix(name);
		block.setUnlocalizedName(prefixedName);

		register(registry, block, name);
		return block;
	}

	protected static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, String name) {
		thing.setRegistryName(Util.getResource(name));
		registry.register(thing);
		return thing;
	}
}
