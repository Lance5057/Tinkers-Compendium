package lance5057.tDefense.core.library.materialutilities;

import java.io.PrintWriter;

import lance5057.tDefense.core.materials.stats.BackpackMaterialStats;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowStringMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

public class CraftableFabricMaterial implements MaterialBase {
	//public ExtraMaterialStats extra;
	public FabricMaterialStats fabric;
	public BowStringMaterialStats bowstring;
	public BackpackMaterialStats backpack;

	public ItemStack cord;
	public ItemStack block;

	public CraftableFabricMaterial( FabricMaterialStats fabric,
			BowStringMaterialStats bowstring, BackpackMaterialStats backpack) {
		//this.extra = extra;
		this.fabric = fabric;
		this.bowstring = bowstring;
		this.backpack = backpack;
	}

	public CraftableFabricMaterial(FabricMaterialStats fabric,
			BowStringMaterialStats bowstring, BackpackMaterialStats backpack, ItemStack string, ItemStack block) {
		this(fabric, bowstring, backpack);
		this.cord = string;
		this.block = block;
	}

	@Override
	public void setupPre(MaterialHelper mat) {

		mat.mat.setCraftable(true).setCastable(false);

		if (fabric != null)
			TinkerRegistry.addMaterialStats(mat.mat, fabric);
		if (bowstring != null)
			TinkerRegistry.addMaterialStats(mat.mat, bowstring);
		if (backpack != null)
			TinkerRegistry.addMaterialStats(mat.mat, backpack);

		if (cord != null)
			mat.mat.addItem(cord, 1, Material.VALUE_Ingot / 4);
		if (block != null) {
			mat.mat.addItem(block, 1, Material.VALUE_Ingot);
		}
	}

	@Override
	public void setupPost(MaterialHelper mat) {

	}

	@Override
	public void setupClient(MaterialHelper mat) {
	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupModels(MaterialHelper mat) {
	}

	@Override
	public void setupInit(MaterialHelper mat) {
		mat.mat.setRepresentativeItem(block);
	}

	@Override
	public void setupWiki(MaterialHelper mat,PrintWriter out) {
		// TODO Auto-generated method stub
		
	}

}
