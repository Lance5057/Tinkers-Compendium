package lance5057.tDefense.core.library.materialutilities;

import java.io.PrintWriter;

import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

public class ArmorMaterial implements MaterialBase {

	public HelmMaterialStats helm;
	public ChestMaterialStats chest;
	public LegsMaterialStats legs;
	public FeetMaterialStats feet;

	public ArmorMaterial(HelmMaterialStats helm, ChestMaterialStats chest,
			LegsMaterialStats legs, FeetMaterialStats feet) {

		this.helm = helm;
		this.chest = chest;
		this.legs = legs;
		this.feet = feet;
	}

	@Override
	public void setupPre(MaterialHelper mat) {

		if (helm != null)
			TinkerRegistry.addMaterialStats(mat.mat, helm);
		if (chest != null)
			TinkerRegistry.addMaterialStats(mat.mat, chest);
		if (legs != null)
			TinkerRegistry.addMaterialStats(mat.mat, legs);
		if (feet != null)
			TinkerRegistry.addMaterialStats(mat.mat, feet);
	}

	@Override
	public void setupPost(MaterialHelper mat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupClient(MaterialHelper mat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupModels(MaterialHelper mat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupInit(MaterialHelper mat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupWiki(MaterialHelper mat,PrintWriter out) {
		// TODO Auto-generated method stub
		
	}
}
