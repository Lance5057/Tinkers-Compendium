package lance5057.tDefense.core.library.materialutilities;

import java.io.PrintWriter;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

public class PresetMaterial implements MaterialBase {

	public FluidMolten fluid;
	public HeadMaterialStats head;
	public HandleMaterialStats handle;
	public ShieldMaterialStats shield;
	public ExtraMaterialStats extra;
	public BowMaterialStats bow;

	int temp;

	public Item ingot;
	public Item nugget;

	public Block block;
	public Item itemBlock;
	boolean hasBlockTexture;
	
	public PresetMaterial(HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra,
			ShieldMaterialStats shield, BowMaterialStats bow) {
		this(0, head, handle, extra, shield, bow, null, false);
	}

	public PresetMaterial(int temp, HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra,
			ShieldMaterialStats shield, BowMaterialStats bow) {
		this(temp, head, handle, extra, shield, bow, null, false);
	}

	public PresetMaterial(int temp, HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra,
			ShieldMaterialStats shield, BowMaterialStats bow, FluidMolten fluid) {
		this(temp, head, handle, extra, shield, bow, fluid, false);
	}

	public PresetMaterial(int temp, HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra,
			ShieldMaterialStats shield, BowMaterialStats bow, FluidMolten fluid, boolean hasBlockTexture) {
		this.temp = temp;
		this.head = head;
		this.handle = handle;
		this.shield = shield;
		this.extra = extra;
		this.bow = bow;

//		this.ingot = ingot;
//		this.block = block;
		this.fluid = fluid;

		this.hasBlockTexture = hasBlockTexture;
	}

	@Override
	public void setupPre(MaterialHelper mat) {
		if (fluid != null) {
			mat.mat.setCraftable(false).setCastable(true);
			mat.mat.setFluid(fluid);
		}
		else
		{
			mat.mat.setCraftable(true).setCastable(false);
		}

		if (head != null)
			TinkerRegistry.addMaterialStats(mat.mat, head);
		if (handle != null)
			TinkerRegistry.addMaterialStats(mat.mat, handle);
		if (extra != null)
			TinkerRegistry.addMaterialStats(mat.mat, extra);
		if (shield != null)
			TinkerRegistry.addMaterialStats(mat.mat, shield);
		if (bow != null)
			TinkerRegistry.addMaterialStats(mat.mat, bow);
	}

	@Override
	public void setupPost(MaterialHelper mat) {
		mat.mat.addItem(nugget, 1, Material.VALUE_Nugget);
		mat.mat.addItem(ingot, 1, Material.VALUE_Ingot);
		mat.mat.addItem(block, Material.VALUE_Block);
	}

	@Override
	public void setupClient(MaterialHelper mat) {

	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		mi.fluid = fluid;

	}

	@Override
	public void setupModels(MaterialHelper mat) {

	}

	@Override
	public void setupInit(MaterialHelper mat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupWiki(MaterialHelper mat,PrintWriter out) {
		
		
		
		out.write("### Tools and Weapons \n\n");
		out.write("|||||\n");
		out.write("|-|-|-|-|\n");
		
		out.write("|Durability|Mining Speed|Harvest Level|Attack|\n");
		
		out.write("|" + head.durability);
		out.write("|" + head.miningspeed);
		out.write("|" + HarvestLevels.getHarvestLevelName(head.harvestLevel).substring(3));
		out.write("|" + head.attack + "|\n");
	}
}
