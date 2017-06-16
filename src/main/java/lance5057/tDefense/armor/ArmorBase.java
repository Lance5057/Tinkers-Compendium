package lance5057.tDefense.armor;

import java.util.List;
import java.util.Locale;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;

import lance5057.tDefense.Reference;
import lance5057.tDefense.armor.items.cloth.TinkersHood;
import lance5057.tDefense.armor.materials.MaterialArmor;
import lance5057.tDefense.armor.materials.MaterialCloth;
import lance5057.tDefense.core.materials.ShieldMaterialStats;
import lance5057.tDefense.util.Color16Util;
import lance5057.tDefense.util.ModuleBase;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IPattern;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTools;

public class ArmorBase extends ModuleBase {
	public static CreativeTabs tabName;

	private static List<Item> tools = Lists.newLinkedList();
	private static List<ToolPart> toolParts = Lists.newLinkedList();
	private static List<IModifier> modifiers = Lists.newLinkedList();
	private static List<Pair<Item, ToolPart>> toolPartPatterns = Lists.newLinkedList();

	public static ToolPart armorPlate;
	public static ToolPart chainmail;
	public static ToolPart cloth;
	public static ToolPart rivets;
	public static ToolPart clasp;

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

	public static ArmorCore armor_TinkerHood;
	public static ToolCore armor_TinkerShawl;
	public static ToolCore armor_TinkerRobe;
	public static ToolCore armor_TinkerShoes;

	public static ToolCore armor_TinkerCoif;
	public static ToolCore armor_TinkerHauberk;
	public static ToolCore armor_TinkerChausses;
	public static ToolCore armor_TinkerBoots;

	public static ToolCore armor_TinkerHelm;
	public static ToolCore armor_TinkerBreastplate;
	public static ToolCore armor_TinkerGrieves;
	public static ToolCore armor_TinkerSabatons;

	public static Block block_Unstable;
	public static Block block_GlowCrumbs;

	// private static Material mat(String name, int color) {
	// Material mat = new Material(name, color);
	// materials.add(mat);
	// return mat;
	// }

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		armorPlate = registerToolPart(new ToolPart(Material.VALUE_Ingot * 4), "armor_plate");
		chainmail = registerToolPart(new ToolPart(Material.VALUE_Ingot * 3), "chainmail");
		cloth = registerToolPart(new ToolPart(Material.VALUE_Ingot * 3), "cloth");
		rivets = registerToolPart(new ToolPart(Material.VALUE_Ingot * 1), "rivets");
		clasp = registerToolPart(new ToolPart(Material.VALUE_Ingot * 1), "clasp");

		registerMaterials();
		registerClothMaterials();

		for (Pair<Item, ToolPart> toolPartPattern : toolPartPatterns) {
			registerStencil(toolPartPattern.getLeft(), toolPartPattern.getRight());
		}

		//regTool(armor_TinkerHood, "tinkerhood");
		registerTools();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		regToolBuilding();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub

	}

	private void regTool(ToolCore tool, String name) {
		tool.setRegistryName(new ResourceLocation("tinkersdefense:" + name));
		TinkerRegistry.registerTool(tool);
		GameRegistry.register(tool);
	}

	private void registerMaterials() {
		Material.UNKNOWN.addStats(new MaterialArmor(35, 1F));

		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new MaterialArmor(35, 0.5f));
		// TinkerMaterials.wood.addTrait(axelover, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new MaterialArmor(120, 0.6F));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.stone, dulling,
		// SHIELD);
		// TinkerMaterials.stone.addTrait(dulling, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new MaterialArmor(150, 0.5F));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.flint, firestarter,
		// SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new MaterialArmor(210, 0.3F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new MaterialArmor(200, 0.75F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new MaterialArmor(139, 0.6F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new MaterialArmor(430, 0.6F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new MaterialArmor(420, 0.8F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new MaterialArmor(12, 0.1F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new MaterialArmor(550, 0.2F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new MaterialArmor(550, 1F));

		// Slime
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new MaterialArmor(1000, 0.9F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new MaterialArmor(780, 0.9F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new MaterialArmor(850, 1.1F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new MaterialArmor(600, 0.9F));

		// Nether
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new MaterialArmor(270, 0.5F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new MaterialArmor(780, 1.4F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new MaterialArmor(990, 1.3F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new MaterialArmor(820, 1.5F));

		// Metals
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new MaterialArmor(204, 1F));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new MaterialArmor(380, 1.1F));

		// Mod Integration
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new MaterialArmor(210, 0.9F));

		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new MaterialArmor(430, 1F));

		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new MaterialArmor(334, 1F));

		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new MaterialArmor(250, 0.8F));

		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new MaterialArmor(50, 0.8F));

		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new MaterialArmor(540, 1.3F));
	}

	private void registerClothMaterials() {
		black = new Material("blackCloth", 0xDDDDDD);
		red = new Material("redCloth", 0xDB7D3E);
		green = new Material("greeCloth", 0xB350BC);
		brown = new Material("brownCloth", 0x6B8AC9);
		blue = new Material("blueCloth", 0xB1A627);
		purple = new Material("purpleCloth", 0x41AE38);
		cyan = new Material("cyanCloth", 0xD08499);
		lightgray = new Material("lightgrayCloth", 0x404040);
		gray = new Material("grayCloth", 0x9AA1A1);
		pink = new Material("pinkCloth", 0x2E6E89);
		lime = new Material("limeCloth", 0x7E3DB5);
		yellow = new Material("yellowCloth", 0x2E388D);
		lightblue = new Material("lightblueCloth", 0x4F321F);
		magenta = new Material("magentaCloth", 0x35461B);
		orange = new Material("orangeCloth", 0x963430);
		white = new Material("whiteCloth", 0x191616);
		
		Material.UNKNOWN.addStats(new MaterialCloth(100));
		
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

	private void registerTools()
	{
		armor_TinkerHood = new TinkersHood();
		regTool(armor_TinkerHood, "tinkerhood");
		//TinkerRegistry.registerToolCrafting(armor_TinkerHood);
	}
	
	private void regToolBuilding() {
	    TinkerRegistry.registerToolCrafting(armor_TinkerHood);
	  }
	
	private static <T extends Item> T registerTool(T item, String name) {
		tools.add(item);
		return registerItem(item, name);
	}

	private static ToolPart registerToolPart(ToolPart part, String name) {
		return registerToolPart(part, name, TinkerTools.pattern);
	}

	private static <T extends Item & IPattern> ToolPart registerToolPart(ToolPart part, String name, T pattern) {
		ToolPart ret = registerItem(part, name);

		if (pattern != null) {
			toolPartPatterns.add(Pair.of(pattern, ret));
		}

		toolParts.add(ret);

		return ret;
	}

	private static void registerStencil(Item pattern, ToolPart toolPart) {
		for (ToolCore toolCore : TinkerRegistry.getTools()) {
			for (PartMaterialType partMaterialType : toolCore.getRequiredComponents()) {
				if (partMaterialType.getPossibleParts().contains(toolPart)) {
					ItemStack stencil = new ItemStack(pattern);
					Pattern.setTagForPart(stencil, toolPart);
					TinkerRegistry.registerStencilTableCrafting(stencil);
					return;
				}
			}
		}
	}

	private static <T extends Item> T registerItem(T item, String name) {
		if (!name.equals(name.toLowerCase(Locale.US))) {
			throw new IllegalArgumentException(
					String.format("Unlocalized names need to be all lowercase! Item: %s", name));
		}

		item.setUnlocalizedName(name);
		item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		GameRegistry.register(item);
		return item;
	}

	private static <T extends IModifier> T registerModifier(T modifier) {
		TinkerRegistry.registerModifier(modifier);
		modifiers.add(modifier);
		return modifier;
	}
}
