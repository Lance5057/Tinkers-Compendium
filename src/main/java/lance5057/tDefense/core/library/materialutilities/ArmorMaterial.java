package lance5057.tDefense.core.library.materialutilities;

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
	public void setupPre(Material mat) {

		if (helm != null)
			TinkerRegistry.addMaterialStats(mat, helm);
		if (chest != null)
			TinkerRegistry.addMaterialStats(mat, chest);
		if (legs != null)
			TinkerRegistry.addMaterialStats(mat, legs);
		if (feet != null)
			TinkerRegistry.addMaterialStats(mat, feet);
	}

	@Override
	public void setupPost(Material mat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupClient(Material mat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupModels(Material mat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupInit(Material mat) {
		// TODO Auto-generated method stub
		
	}
}
