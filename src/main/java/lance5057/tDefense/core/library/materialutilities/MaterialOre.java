package lance5057.tDefense.core.library.materialutilities;

import java.io.PrintWriter;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TCBlocks;
import lance5057.tDefense.TCItems;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.blocks.TDOreBlock;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

public class MaterialOre implements MaterialBase {

	public Block oreBlock;
//	public Block gravelBlock;
//	public Block sandBlock;
//	public Block sandstoneBlock;
//	public Block netherBlock;

	public Item oreItemBlock;
//	public Item gravelItemBlock;
//	public Item sandItemBlock;
//	public Item sandstoneItemBlock;
//	public Item netherItemBlock;

	public Item oreClump;
//	public Item oreGravel;
//	public Item oreSand;
	
	String tool;

	public String prefix;
	public String style;
	public int oreColor;
	public float hardness;
	public int mininglevel;
	public float resistance;

	public int oreYMax;
	public int oreYMin;
	public int oreSize;
	public int oreChance;

	public int[] oreDimWhite;
	public int[] oreDimBlack;

	public Biome[] oreBiomeWhite;
	public Biome[] oreBiomeBlack;

	public float biomeElevationMin = -2;
	public float biomeElevationMax = -2;
	public float biomeTempMin = -2;
	public float biomeTempMax = -2;
	public float biomeHumidityMin = -2;
	public float biomeHumidityMax = -2;

	public MaterialOre(String prefix, String style, float hardness, int level, String tool, float resistance) {
		this(prefix, style, 0, hardness, level, tool, resistance, 64, 0, 8, 10);
	}

	public MaterialOre(String prefix, String style, int color, float hardness, int level, String tool,
			float resistance) {
		this(prefix, style, color, hardness, level, tool, resistance, 64, 0, 8, 10);
	}

	public MaterialOre(String prefix, String style, int color, float hardness, int level, String tool, float resistance,
			int ymax, int ymin, int veinSize, int veinChance) {
		this(prefix, style, color, hardness, level, tool, resistance, 64, 0, 8, 10, -2, -2, -2, -2, -2, -2);
	}

	public MaterialOre(String prefix, String style, int color, float hardness, int level, String tool, float resistance,
			int ymax, int ymin, int veinSize, int veinChance, float elevationMin, float elevationMax, float tempMin,
			float tempMax, float humidityMin, float humidityMax) {
		this.prefix = prefix;
		this.style = style;
		this.oreColor = color;
		this.hardness = hardness;
		this.mininglevel = level;
		this.tool = tool;
		this.resistance = resistance;
		this.oreYMax = ymax;
		this.oreYMin = ymin;
		this.oreSize = veinSize;
		this.oreChance = veinChance;
		this.biomeElevationMin = elevationMin;
		this.biomeElevationMax = elevationMax;
		this.biomeTempMin = tempMin;
		this.biomeTempMax = tempMax;
		this.biomeHumidityMin = humidityMin;
		this.biomeHumidityMax = humidityMax;
	}

	@Override
	public void setupPre(MaterialHelper mat) {

		oreClump = TCItems.registerItem(prefix + "clump_" + mat.mat.identifier, TinkersCompendium.tab);
//		oreGravel = TCItems.registerItem("gravelclump_" + mat.mat.identifier, TinkersCompendium.tab);
//		oreSand = TCItems.registerItem("sandclump_" + mat.mat.identifier, TinkersCompendium.tab);

		// TODO add ore clumps
		oreBlock = new TDOreBlock(oreClump, hardness, resistance, mininglevel, tool);
		TCBlocks.registerBlock(oreBlock, prefix + style + "_ore_" + mat.mat.identifier);

		oreItemBlock = TCItems.registerItemBlock("item_" + prefix + style + "_ore_" + mat.mat.identifier, this.oreBlock,
				TinkersCompendium.tab);

//		gravelBlock = new TDOreBlock(oreGravel, hardness, resistance, mininglevel, "shovel");
//		TCBlocks.registerBlock(gravelBlock, "gravel_" + mat.mat.identifier);
//		gravelItemBlock = TCItems.registerItemBlock("item_" + "gravel_" + mat.mat.identifier, this.gravelBlock,
//				TinkersCompendium.tab);
//
//		sandBlock = new TDOreBlock(oreSand, hardness, resistance, mininglevel, "shovel");
//		TCBlocks.registerBlock(sandBlock, "sand_" + mat.mat.identifier);
//
//		sandItemBlock = TCItems.registerItemBlock("item_" + "sand_" + mat.mat.identifier, this.sandBlock,
//				TinkersCompendium.tab);
//		
//		sandstoneBlock = new TDOreBlock(oreSand, hardness, resistance, mininglevel, "pickaxe");
//		TCBlocks.registerBlock(sandBlock, "sandstone_" + mat.mat.identifier);
//
//		sandstoneItemBlock = TCItems.registerItemBlock("item_" + "sandstone_" + mat.mat.identifier, this.sandstoneBlock,
//				TinkersCompendium.tab);

	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		if (mi != null)
			if (mi.fluid != null) {
				TinkerRegistry.registerMelting(oreBlock, mi.fluid, Material.VALUE_Ingot * 2);
				TinkerRegistry.registerMelting(oreClump, mi.fluid, Material.VALUE_Ingot * 2);
			}
	}

	@Override
	public void setupPost(MaterialHelper mat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupClient(MaterialHelper mat) {
		if (this.oreColor > 0) {
			TinkersCompendium.proxy.registerItemColorHandler(this.oreColor, oreClump);
//			TinkersCompendium.proxy.registerItemColorHandler(this.oreColor, oreGravel);
//			TinkersCompendium.proxy.registerItemColorHandler(this.oreColor, oreSand);

			TinkersCompendium.proxy.registerBlockColorHandler(this.oreColor, oreBlock);
			TinkersCompendium.proxy.registerItemColorHandler(this.oreColor, Item.getItemFromBlock(oreBlock));

//			TinkersCompendium.proxy.registerBlockColorHandler(this.oreColor, gravelBlock);
//			TinkersCompendium.proxy.registerItemColorHandler(this.oreColor, Item.getItemFromBlock(gravelBlock));
//
//			TinkersCompendium.proxy.registerBlockColorHandler(this.oreColor, sandBlock);
//			TinkersCompendium.proxy.registerItemColorHandler(this.oreColor, Item.getItemFromBlock(sandBlock));
		} else {
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, oreClump);
//			TinkersCompendium.proxy.registerItemColorHandler(mat.color, oreGravel);
//			TinkersCompendium.proxy.registerItemColorHandler(mat.color, oreSand);

			TinkersCompendium.proxy.registerBlockColorHandler(mat.color, oreBlock);
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, Item.getItemFromBlock(oreBlock));

//			TinkersCompendium.proxy.registerBlockColorHandler(mat.color, gravelBlock);
//			TinkersCompendium.proxy.registerItemColorHandler(mat.color, Item.getItemFromBlock(gravelBlock));
//
//			TinkersCompendium.proxy.registerBlockColorHandler(mat.color, sandBlock);
//			TinkersCompendium.proxy.registerItemColorHandler(mat.color, Item.getItemFromBlock(sandBlock));
		}
	}

	@Override
	public void setupModels(MaterialHelper mat) {
		TinkersCompendium.proxy.registerItemRenderer(oreClump, 0, prefix + "clump");
//		TinkersCompendium.proxy.registerItemRenderer(oreGravel, 0, "gravelclump");
//		TinkersCompendium.proxy.registerItemRenderer(oreSand, 0, "sandclump");

		TinkersCompendium.proxy.registerBlockRenderer(oreBlock, prefix + "ore_" + style);
		TinkersCompendium.proxy.registerItemRenderer(Item.getItemFromBlock(oreBlock), 0, prefix + "ore_" + style);

//		TinkersCompendium.proxy.registerBlockRenderer(gravelBlock, "gravel");
//		TinkersCompendium.proxy.registerItemRenderer(Item.getItemFromBlock(gravelBlock), 0, "gravel_ore");
//
//		TinkersCompendium.proxy.registerBlockRenderer(sandBlock, "sand");
//		TinkersCompendium.proxy.registerItemRenderer(Item.getItemFromBlock(sandBlock), 0, "sand_ore");
	}

	public void setDimensionBlackList(int... list) {
		this.oreDimBlack = list;
	}

	public void setDimensionWhiteList(int... list) {
		this.oreDimWhite = list;
	}

	public void setBiomeBlackList(Biome... list) {
		this.oreBiomeBlack = list;
	}

	public void setBiomeWhiteList(Biome... list) {
		this.oreBiomeWhite = list;
	}

	@Override
	public void setupInit(MaterialHelper mat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupWiki(MaterialHelper mat, PrintWriter out) {
		// TODO Auto-generated method stub

	}
}
