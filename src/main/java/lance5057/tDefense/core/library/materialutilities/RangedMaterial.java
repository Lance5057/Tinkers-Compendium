package lance5057.tDefense.core.library.materialutilities;

import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ArrowShaftMaterialStats;
import slimeknights.tconstruct.library.materials.FletchingMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

public class RangedMaterial implements MaterialBase{
	
	public ArrowShaftMaterialStats shaft;
	public FletchingMaterialStats fletching;
	
	public RangedMaterial(ArrowShaftMaterialStats shaft, FletchingMaterialStats fletching) {
		this.shaft = shaft;
		this.fletching = fletching;
	}

	@Override
	public void setupPre(Material mat) {
		if (shaft != null)
			TinkerRegistry.addMaterialStats(mat, shaft);
		if (fletching != null)
			TinkerRegistry.addMaterialStats(mat, fletching);
	}

	@Override
	public void setupPost(Material mat) {}

	@Override
	public void setupClient(Material mat) {}

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
