package lance5057.tDefense.core.library.materialutilities;

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
	public void setupPre(Material mat) {
		if (fluid != null) {
			mat.setCraftable(false).setCastable(true);
			mat.setFluid(fluid);
		}
		else
		{
			mat.setCraftable(true).setCastable(false);
		}

		if (head != null)
			TinkerRegistry.addMaterialStats(mat, head);
		if (handle != null)
			TinkerRegistry.addMaterialStats(mat, handle);
		if (extra != null)
			TinkerRegistry.addMaterialStats(mat, extra);
		if (shield != null)
			TinkerRegistry.addMaterialStats(mat, shield);
		if (bow != null)
			TinkerRegistry.addMaterialStats(mat, bow);
	}

	@Override
	public void setupPost(Material mat) {
		mat.addItem(nugget, 1, Material.VALUE_Nugget);
		mat.addItem(ingot, 1, Material.VALUE_Ingot);
		mat.addItem(block, Material.VALUE_Block);
	}

	@Override
	public void setupClient(Material mat) {

	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		mi.fluid = fluid;

	}

	@Override
	public void setupModels(Material mat) {

	}

	@Override
	public void setupInit(Material mat) {
		// TODO Auto-generated method stub

	}
}
