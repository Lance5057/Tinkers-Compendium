package lance5057.tDefense.core.materials;

import static slimeknights.tconstruct.library.utils.HarvestLevels.COBALT;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.materials.MaterialCloth;
import lance5057.tDefense.core.blocks.fluid.TDFluid;
import lance5057.tDefense.core.blocks.fluid.VibrantFluid;
import lance5057.tDefense.core.blocks.fluid.VileFluid;
import lance5057.tDefense.core.materials.traits.TraitAxeLover;
import lance5057.tDefense.core.materials.traits.TraitDulling;
import lance5057.tDefense.core.materials.traits.TraitFirestarter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
//import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.smeltery.block.BlockMolten;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class TDMaterials {

	public static final List<Material> materials = Lists.newArrayList();

	String SHIELD = ShieldMaterialStats.TYPE;

	public static final Material aeonsteel = mat("aeonsteel", 0xd200d1);
	public static final Material queensgold = mat("queensgold", 0xdede00);
	public static final Material dogbearium = mat("dogbearium", 0x604933);
	
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

	public static TDFluid fluidAeonsteel = new TDFluid("aeonsteel_fluid", 0xd200d1, 1300, 15, 3000, 6000);
	public static TDFluid fluidQueensGold = new TDFluid("queensgold_fluid", 0xdcff00, 1300, 15, 3000, 6000);
	public static TDFluid fluidDogbearium = new TDFluid("dogbearium_fluid", 0x6d3300, 1300, 15, 3000, 6000);
	public static TDFluid fluidRedCandy = new TDFluid("redcandy_fluid", 0xff0000, 1300, 15, 3000, 6000);
	public static TDFluid fluidGreenCandy = new TDFluid("greencandy_fluid", 0x00ff00, 1300, 15, 3000, 6000);
	public static TDFluid fluidVile = new TDFluid("vile_fluid", 0x111111, 1300, 0, 6000, 600);
	public static TDFluid fluidSinisterium = new TDFluid("sinisterium_fluid", 0x210000, 1300, 0, 3000, 600);
	public static TDFluid fluidNihilite = new TDFluid("nihilite_fluid", 0x000021, 1300, 0, 3000, 600);
	public static TDFluid fluidVibrant = new TDFluid("vibrant_fluid", 0x76ff00, 1300, 15, 6000, 6000);
	public static TDFluid fluidOrichalcum = new TDFluid("orichalcum_fluid", 0xffc700, 1300, 15, 3000, 6000);
	public static TDFluid fluidPandorium = new TDFluid("pandorium_fluid", 0x7f6a00, 1300, 15, 3000, 6000);
	public static TDFluid fluidChorusJuice = new TDFluid("chorusjuice_fluid", 0xd982ff, 0, 0, 3000, 6000);
	public static TDFluid fluidDragonsBreath = new TDFluid("dragonsbreath_fluid", 0x7f00b7, 0, 8, 3000, 6000);
	public static TDFluid fluidRoseGold = new TDFluid("rosegold_fluid", 0xff9b84, 1300, 15, 3000, 6000);
	public static TDFluid fluidPlatinum = new TDFluid("platinum_fluid", 0xe8e8e8, 1300, 15, 3000, 6000);
	public static TDFluid fluidBrass = new TDFluid("brass_fluid", 0xdbb332, 1300, 15, 3000, 6000);
	public static TDFluid fluidSilver = new TDFluid("silver_fluid", 0x9e9e9e, 1300, 15, 3000, 6000);
	public static TDFluid fluidCheese = new TDFluid("cheese_fluid", 0xffe731, 750, 0, 6000, 6000);
	
	public static final AbstractTrait axelover = new TraitAxeLover();
	public static final AbstractTrait dulling = new TraitDulling();
	public static final AbstractTrait firestarter = new TraitFirestarter();

	private static Material mat(String name, int color) {
		Material mat = new Material(name, color);
		materials.add(mat);
		return mat;
	}

	public void registerMaterials() {
		
		addMat("aeonsteel", fluidAeonsteel);
		addMat("queensgold", fluidQueensGold);
		addMat("dogbearium", fluidDogbearium);
		addMat("redcandy", fluidRedCandy);
		addMat("greencandy", fluidGreenCandy);
		
		addMat("sinisterium", fluidSinisterium);
		addMat("nihilite", fluidNihilite);
		
		addMat("orichalcum", fluidOrichalcum);
		addMat("pandorium", fluidPandorium);
		addMat("chorusjuice", fluidChorusJuice);
		addMat("dragonsbreath", fluidDragonsBreath);
		addMat("rosegold", fluidRoseGold);
		addMat("platinum", fluidPlatinum);
		addMat("brass", fluidBrass);
		addMat("silver", fluidSilver);
		addMat("cheese", fluidCheese);
		
		FluidRegistry.registerFluid(fluidVibrant);
		FluidRegistry.addBucketForFluid(fluidVibrant);
		addMat("vibrantfluid", fluidVibrant, new VibrantFluid(fluidVibrant));
		
		FluidRegistry.registerFluid(fluidVile);
		FluidRegistry.addBucketForFluid(fluidVile);
		addMat("vilefluid", fluidVile, new VileFluid(fluidVile));
		
		registerClothMaterials();
	}

	@Subscribe
	public void setupMaterials(FMLInitializationEvent event) {
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
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new ShieldMaterialStats(200, 33));
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

		TinkerRegistry.addMaterialStats(aeonsteel, new HeadMaterialStats(1000, 4.0f, 3.00f, COBALT),
				new HandleMaterialStats(1.10f, 200), new ExtraMaterialStats(500));
		// iron.addItemIngot("ingotIron");
		// iron.setRepresentativeItem(Items.field_151042_j);
		// iron.addTrait(magnetic2, HEAD);
		// iron.addTrait(magnetic);

		// TinkerMaterials.stone.addTrait(TinkerMaterials.cheapskate,
		// ShieldMaterialStats.TYPE);

		// TAIGA TEST
		Collection<Material> mats = TinkerRegistry.getAllMaterials();
		for (Material i : mats) {
			if (!i.hasStats(SHIELD)) {
				if (i.hasStats(MaterialTypes.HEAD)) {
					int dur = ((HeadMaterialStats) i.getStats(MaterialTypes.HEAD)).durability;
					i.addStats(new ShieldMaterialStats(dur, 33));
				}
			}
		}
	}

	void addMat(String name, TDFluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);

        BlockMolten block = new BlockMolten(fluid);
        // Sets names
        block.setUnlocalizedName("molten_" + fluid.getName());
        block.setRegistryName(Reference.MOD_ID, "molten_" + fluid.getName());
        // Registers the fluid in its block form and its corresponding item (block/fluid as item in inventory)
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        // Registers the fluid's model but only on the client side
        TinkersDefense.proxy.registerFluidModels(fluid);
	}
	
	void addMat(String name, TDFluid fluid, Block fluidBlock) {
		
        // Sets names
		fluidBlock.setUnlocalizedName("molten_" + fluid.getName());
        fluidBlock.setRegistryName(Reference.MOD_ID, "molten_" + fluid.getName());
        // Registers the fluid in its block form and its corresponding item (block/fluid as item in inventory)
        GameRegistry.register(fluidBlock);
        GameRegistry.register(new ItemBlock(fluidBlock).setRegistryName(fluidBlock.getRegistryName()));
        // Registers the fluid's model but only on the client side
        TinkersDefense.proxy.registerFluidModels(fluid);
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
		black.addItem(new ItemStack(Blocks.WOOL,15), 1, Material.VALUE_Ingot);
		red.addItem(new ItemStack(Blocks.WOOL,14), 1, Material.VALUE_Ingot);
		green.addItem(new ItemStack(Blocks.WOOL,13), 1, Material.VALUE_Ingot);
		brown.addItem(new ItemStack(Blocks.WOOL,12), 1, Material.VALUE_Ingot);
		blue.addItem(new ItemStack(Blocks.WOOL,11), 1, Material.VALUE_Ingot);
		purple.addItem(new ItemStack(Blocks.WOOL,10), 1, Material.VALUE_Ingot);
		cyan.addItem(new ItemStack(Blocks.WOOL,9), 1, Material.VALUE_Ingot);
		lightgray.addItem(new ItemStack(Blocks.WOOL,8), 1, Material.VALUE_Ingot);
		gray.addItem(new ItemStack(Blocks.WOOL,7), 1, Material.VALUE_Ingot);
		pink.addItem(new ItemStack(Blocks.WOOL,6), 1, Material.VALUE_Ingot);
		lime.addItem(new ItemStack(Blocks.WOOL,5), 1, Material.VALUE_Ingot);
		yellow.addItem(new ItemStack(Blocks.WOOL,4), 1, Material.VALUE_Ingot);
		lightblue.addItem(new ItemStack(Blocks.WOOL,3), 1, Material.VALUE_Ingot);
		magenta.addItem(new ItemStack(Blocks.WOOL,2), 1, Material.VALUE_Ingot);
		orange.addItem(new ItemStack(Blocks.WOOL,1), 1, Material.VALUE_Ingot);
		white.addItem(new ItemStack(Blocks.WOOL,0), 1, Material.VALUE_Ingot);
		
		black.setRepresentativeItem(new ItemStack(Blocks.WOOL,15));
		red.setRepresentativeItem(new ItemStack(Blocks.WOOL,14));
		green.setRepresentativeItem(new ItemStack(Blocks.WOOL,13));
		brown.setRepresentativeItem(new ItemStack(Blocks.WOOL,12));
		blue.setRepresentativeItem(new ItemStack(Blocks.WOOL,11));
		purple.setRepresentativeItem(new ItemStack(Blocks.WOOL,10));
		cyan.setRepresentativeItem(new ItemStack(Blocks.WOOL,9));
		lightgray.setRepresentativeItem(new ItemStack(Blocks.WOOL,8));
		gray.setRepresentativeItem(new ItemStack(Blocks.WOOL,7));
		pink.setRepresentativeItem(new ItemStack(Blocks.WOOL,6));
		lime.setRepresentativeItem(new ItemStack(Blocks.WOOL,5));
		yellow.setRepresentativeItem(new ItemStack(Blocks.WOOL,4));
		lightblue.setRepresentativeItem(new ItemStack(Blocks.WOOL,3));
		magenta.setRepresentativeItem(new ItemStack(Blocks.WOOL,2));
		orange.setRepresentativeItem(new ItemStack(Blocks.WOOL,1));
		white.setRepresentativeItem(new ItemStack(Blocks.WOOL,0));
		
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
}
