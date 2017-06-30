//package lance5057.tDefense.armor;
//
//import java.util.List;
//import java.util.Locale;
//
//import com.google.common.collect.Lists;
//import org.apache.commons.lang3.tuple.Pair;
//
//import lance5057.tDefense.Reference;
//import lance5057.tDefense.armor.items.cloth.TinkersHood;
//import lance5057.tDefense.armor.materials.MaterialArmor;
//import lance5057.tDefense.armor.materials.MaterialCloth;
//import lance5057.tDefense.core.materials.ShieldMaterialStats;
//import lance5057.tDefense.util.Color16Util;
//import lance5057.tDefense.util.ModuleBase;
//import net.minecraft.block.Block;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//import slimeknights.tconstruct.library.TinkerRegistry;
//import slimeknights.tconstruct.library.materials.Material;
//import slimeknights.tconstruct.library.modifiers.IModifier;
//import slimeknights.tconstruct.library.tinkering.PartMaterialType;
//import slimeknights.tconstruct.library.tools.IPattern;
//import slimeknights.tconstruct.library.tools.Pattern;
//import slimeknights.tconstruct.library.tools.ToolCore;
//import slimeknights.tconstruct.library.tools.ToolPart;
//import slimeknights.tconstruct.tools.TinkerMaterials;
//import slimeknights.tconstruct.tools.TinkerTools;
//
//public class ArmorBase extends ModuleBase
//{
//	public static CreativeTabs tabName;
//
//	private static List<Item> tools = Lists.newLinkedList();
//	private static List<ToolPart> toolParts = Lists.newLinkedList();
//	private static List<IModifier> modifiers = Lists.newLinkedList();
//	private static List<Pair<Item, ToolPart>> toolPartPatterns = Lists.newLinkedList();
//
//
//
//	public static Block block_Unstable;
//	public static Block block_GlowCrumbs;
//
//	// private static Material mat(String name, int color) {
//	// Material mat = new Material(name, color);
//	// materials.add(mat);
//	// return mat;
//	// }
//
//	@Override
//	public void preInit(FMLPreInitializationEvent e) {
//
//
//		registerMaterials();
//		
//
//		for (Pair<Item, ToolPart> toolPartPattern : toolPartPatterns) {
//			registerStencil(toolPartPattern.getLeft(), toolPartPattern.getRight());
//		}
//
//		//regTool(armor_TinkerHood, "tinkerhood");
//		registerTools();
//	}
//
//	@Override
//	public void init(FMLInitializationEvent e) {
//		regToolBuilding();
//	}
//
//	@Override
//	public void postInit(FMLPostInitializationEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void regTool(ToolCore tool, String name) {
//		tool.setRegistryName(new ResourceLocation("tinkersdefense:" + name));
//		TinkerRegistry.registerTool(tool);
//		GameRegistry.register(tool);
//	}
//
//	private void registerMaterials() {
//		Material.UNKNOWN.addStats(new MaterialArmor(35, 1F));
//
//		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new MaterialArmor(35, 0.5f));
//		// TinkerMaterials.wood.addTrait(axelover, SHIELD);
//
//		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new MaterialArmor(120, 0.6F));
//		// TinkerRegistry.addMaterialTrait(TinkerMaterials.stone, dulling,
//		// SHIELD);
//		// TinkerMaterials.stone.addTrait(dulling, SHIELD);
//
//		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new MaterialArmor(150, 0.5F));
//		// TinkerRegistry.addMaterialTrait(TinkerMaterials.flint, firestarter,
//		// SHIELD);
//
//		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new MaterialArmor(210, 0.3F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new MaterialArmor(200, 0.75F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new MaterialArmor(139, 0.6F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new MaterialArmor(430, 0.6F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new MaterialArmor(420, 0.8F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new MaterialArmor(12, 0.1F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new MaterialArmor(550, 0.2F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new MaterialArmor(550, 1F));
//
//		// Slime
//		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new MaterialArmor(1000, 0.9F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new MaterialArmor(780, 0.9F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new MaterialArmor(850, 1.1F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new MaterialArmor(600, 0.9F));
//
//		// Nether
//		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new MaterialArmor(270, 0.5F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new MaterialArmor(780, 1.4F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new MaterialArmor(990, 1.3F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new MaterialArmor(820, 1.5F));
//
//		// Metals
//		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new MaterialArmor(204, 1F));
//		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new MaterialArmor(380, 1.1F));
//
//		// Mod Integration
//		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new MaterialArmor(210, 0.9F));
//
//		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new MaterialArmor(430, 1F));
//
//		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new MaterialArmor(334, 1F));
//
//		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new MaterialArmor(250, 0.8F));
//
//		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new MaterialArmor(50, 0.8F));
//
//		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new MaterialArmor(540, 1.3F));
//	}
//
//	
//
//	private void registerTools()
//	{
//		armor_TinkerHood = new TinkersHood();
//		regTool(armor_TinkerHood, "tinkerhood");
//		//TinkerRegistry.registerToolCrafting(armor_TinkerHood);
//	}
//	
//	private void regToolBuilding() {
//	    TinkerRegistry.registerToolCrafting(armor_TinkerHood);
//	  }
//	
//	private static <T extends Item> T registerTool(T item, String name) {
//		tools.add(item);
//		return registerItem(item, name);
//	}
//
//	private static ToolPart registerToolPart(ToolPart part, String name) {
//		return registerToolPart(part, name, TinkerTools.pattern);
//	}
//
//	private static <T extends Item & IPattern> ToolPart registerToolPart(ToolPart part, String name, T pattern) {
//		ToolPart ret = registerItem(part, name);
//
//		if (pattern != null) {
//			toolPartPatterns.add(Pair.of(pattern, ret));
//		}
//
//		toolParts.add(ret);
//
//		return ret;
//	}
//
//	private static void registerStencil(Item pattern, ToolPart toolPart) {
//		for (ToolCore toolCore : TinkerRegistry.getTools()) {
//			for (PartMaterialType partMaterialType : toolCore.getRequiredComponents()) {
//				if (partMaterialType.getPossibleParts().contains(toolPart)) {
//					ItemStack stencil = new ItemStack(pattern);
//					Pattern.setTagForPart(stencil, toolPart);
//					TinkerRegistry.registerStencilTableCrafting(stencil);
//					return;
//				}
//			}
//		}
//	}
//
//	private static <T extends Item> T registerItem(T item, String name) {
//		if (!name.equals(name.toLowerCase(Locale.US))) {
//			throw new IllegalArgumentException(
//					String.format("Unlocalized names need to be all lowercase! Item: %s", name));
//		}
//
//		item.setUnlocalizedName(name);
//		item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
//		GameRegistry.register(item);
//		return item;
//	}
//
//	private static <T extends IModifier> T registerModifier(T modifier) {
//		TinkerRegistry.registerModifier(modifier);
//		modifiers.add(modifier);
//		return modifier;
//	}
//}
