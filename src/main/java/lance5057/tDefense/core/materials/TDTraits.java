package lance5057.tDefense.core.materials;

import lance5057.tDefense.core.materials.ArmorMaterialStats.ChestMaterialStats;
import lance5057.tDefense.core.materials.ArmorMaterialStats.FeetMaterialStats;
import lance5057.tDefense.core.materials.ArmorMaterialStats.HelmMaterialStats;
import lance5057.tDefense.core.materials.ArmorMaterialStats.LegsMaterialStats;
import lance5057.tDefense.core.materials.traits.armor.TraitDamageSourceAlteration;
import lance5057.tDefense.core.materials.traits.armor.TraitPhotosynthetic;
import lance5057.tDefense.core.materials.traits.armor.TraitReduceKnockback;
import lance5057.tDefense.core.materials.traits.armor.TraitStoned;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class TDTraits {
	
	public TraitPhotosynthetic photosynth = new TraitPhotosynthetic(1);
	public TraitPhotosynthetic photosynth2 = new TraitPhotosynthetic(2);
	public TraitReduceKnockback rooted = new TraitReduceKnockback("rooted", 0x875e21, 0.5f, Blocks.DIRT.getDefaultState(), Blocks.GRASS.getDefaultState());
	
	public TraitDamageSourceAlteration blockhead = new TraitDamageSourceAlteration("blockhead", 0x875e21,
			new TraitDamageSourceAlteration.DamagePercent(DamageSource.GENERIC, -0.5f),
			new TraitDamageSourceAlteration.DamagePercent(DamageSource.MAGIC, 0.5f));
	public TraitStoned stoned = new TraitStoned();
	
	public void preInit() {
		
		//TinkerRegistry.addMaterialTrait(TinkerMaterials.wood, rooted, FeetMaterialStats.TYPE);
	}

	public void init() {
		//TinkerRegistry.addMaterialTrait(TinkerMaterials.wood, photosynth2, HelmMaterialStats.TYPE);
		//TinkerRegistry.addMaterialTrait(TinkerMaterials.wood, photosynth, ChestMaterialStats.TYPE);
		//TinkerRegistry.addMaterialTrait(TinkerMaterials.wood, rooted, LegsMaterialStats.TYPE);
		
		TinkerMaterials.wood.addTrait(photosynth2, HelmMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(photosynth, ChestMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(rooted, LegsMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(rooted, FeetMaterialStats.TYPE);
		
		TinkerMaterials.stone.addTrait(blockhead, HelmMaterialStats.TYPE);
		TinkerMaterials.stone.addTrait(stoned, ChestMaterialStats.TYPE);
	}

	public void postInit() {

	}
}
