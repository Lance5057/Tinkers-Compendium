package lance5057.tDefense.core.library.materialutilities;

import lance5057.tDefense.Reference;
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

	private Block oreBlock;
	private Item oreClump;
	private Item oreGravel;
	private Item oreSand;

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

	public MaterialOre(String prefix, String style, int color, float hardness, int level, float resistance) {
		this(prefix, style, color, hardness, level, resistance, 64, 0, 8, 10);
	}

	public MaterialOre(String prefix, String style, int color, float hardness, int level, float resistance, int ymax,
			int ymin, int veinSize, int veinChance) {
		this(prefix, style, color, hardness, level, resistance, 64, 0, 8, 10, -2, -2, -2, -2, -2, -2);
	}

	public MaterialOre(String prefix, String style, int color, float hardness, int level, float resistance, int ymax,
			int ymin, int veinSize, int veinChance, float elevationMin, float elevationMax, float tempMin,
			float tempMax, float humidityMin, float humidityMax) {
		this.prefix = prefix;
		this.style = style;
		this.oreColor = color;
		this.hardness = hardness;
		this.mininglevel = level;
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
	public void setupPre(Material mat) {

		oreClump = registerItem("clump_" + mat.identifier, TinkersCompendium.tab);
		CompendiumMaterials.itemList.add(oreClump);
		oreGravel = registerItem("gravelclump_" + mat.identifier, TinkersCompendium.tab);
		CompendiumMaterials.itemList.add(oreGravel);
		oreSand = registerItem("sandclump_" + mat.identifier, TinkersCompendium.tab);
		CompendiumMaterials.itemList.add(oreSand);
		
		// TODO add ore clumps
		oreBlock = new TDOreBlock(oreClump, hardness, resistance, mininglevel)
				.setRegistryName(new ResourceLocation(Reference.MOD_ID, prefix + "_ore_" + mat.identifier))
				.setUnlocalizedName(prefix + "_ore_" + mat.identifier);
		CompendiumMaterials.itemList.add(
				registerItemBlock("item_" + prefix + "_ore_" + mat.identifier, this.oreBlock, TinkersCompendium.tab));

		CompendiumMaterials.blockList.add(oreBlock);
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
	public void setupPost(Material mat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupClient(Material mat) {
		if (this.oreColor >= 0) {
			TinkersCompendium.proxy.registerBlockColorHandler(this.oreColor, oreBlock);
			TinkersCompendium.proxy.registerItemColorHandler(this.oreColor, Item.getItemFromBlock(oreBlock));
		} else {
			TinkersCompendium.proxy.registerBlockColorHandler(mat.materialTextColor, oreBlock);
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, Item.getItemFromBlock(oreBlock));
		}
	}

	@Override
	public void setupModels(Material mat) {
		TinkersCompendium.proxy.registerBlockRenderer(oreBlock, "ore_" + style);
		TinkersCompendium.proxy.registerItemRenderer(Item.getItemFromBlock(oreBlock), 0, "ore_" + style);
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
	public void setupInit(Material mat) {
		// TODO Auto-generated method stub

	}
}
