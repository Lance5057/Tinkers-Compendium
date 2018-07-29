package lance5057.tDefense.core.materials;

import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import lance5057.tDefense.core.materials.traits.TraitApplyPotion;
import lance5057.tDefense.core.materials.traits.TraitArrowCatcher;
import lance5057.tDefense.core.materials.traits.TraitBoneSpurs;
import lance5057.tDefense.core.materials.traits.TraitBuoyant;
import lance5057.tDefense.core.materials.traits.TraitCurrentRider;
import lance5057.tDefense.core.materials.traits.TraitDamageNegation;
import lance5057.tDefense.core.materials.traits.TraitDamageSourceAlteration;
import lance5057.tDefense.core.materials.traits.TraitEarthbound;
import lance5057.tDefense.core.materials.traits.TraitFins;
import lance5057.tDefense.core.materials.traits.TraitGills;
import lance5057.tDefense.core.materials.traits.TraitGlassine;
import lance5057.tDefense.core.materials.traits.TraitHog;
import lance5057.tDefense.core.materials.traits.TraitHotFoot;
import lance5057.tDefense.core.materials.traits.TraitHotHead;
import lance5057.tDefense.core.materials.traits.TraitHydrophobic;
import lance5057.tDefense.core.materials.traits.TraitIncinerate;
import lance5057.tDefense.core.materials.traits.TraitIronclad;
import lance5057.tDefense.core.materials.traits.TraitMagnetism;
import lance5057.tDefense.core.materials.traits.TraitNovel;
import lance5057.tDefense.core.materials.traits.TraitPeyote;
import lance5057.tDefense.core.materials.traits.TraitPhotosynthetic;
import lance5057.tDefense.core.materials.traits.TraitPiggy;
import lance5057.tDefense.core.materials.traits.TraitPotionRemoval;
import lance5057.tDefense.core.materials.traits.TraitPricked;
import lance5057.tDefense.core.materials.traits.TraitReduceKnockback;
import lance5057.tDefense.core.materials.traits.TraitSoggy;
import lance5057.tDefense.core.materials.traits.TraitSpiny;
import lance5057.tDefense.core.materials.traits.TraitStoned;
import lance5057.tDefense.core.materials.traits.TraitToasty;
import lance5057.tDefense.core.materials.traits.TraitVoidCall;
import lance5057.tDefense.core.materials.traits.TraitWarp;
import lance5057.tDefense.core.materials.traits.TraitWarpedMind;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class TDTraits {

	public TraitPhotosynthetic photosynth = new TraitPhotosynthetic(1);
	public TraitPhotosynthetic photosynth2 = new TraitPhotosynthetic(2);
	public TraitReduceKnockback rooted = new TraitReduceKnockback("rooted", 0x875e21, 0.5f,
			Blocks.DIRT.getDefaultState(), Blocks.GRASS.getDefaultState());

	public TraitDamageSourceAlteration blockhead = new TraitDamageSourceAlteration("blockhead", 0x875e21,
			new TraitDamageSourceAlteration.DamagePercent(DamageSource.GENERIC, -0.5f),
			new TraitDamageSourceAlteration.DamagePercent(DamageSource.MAGIC, 0.5f));
	public TraitStoned stoned = new TraitStoned();
	public TraitEarthbound earthbound = new TraitEarthbound();

	public TraitGlassine glassine = new TraitGlassine();

	public TraitPeyote peyote = new TraitPeyote();
	public TraitSpiny spiny = new TraitSpiny();
	public TraitPricked pricked = new TraitPricked();

	public TraitPotionRemoval thickheaded = new TraitPotionRemoval("thickheaded", TextFormatting.WHITE,
			MobEffects.BLINDNESS, MobEffects.NAUSEA);
	public TraitDamageNegation calcium = new TraitDamageNegation("calcium", TextFormatting.WHITE, 1f);
	public TraitDamageNegation collagen = new TraitDamageNegation("collagen", TextFormatting.WHITE, 1000f,
			DamageSource.FALL);
	public TraitBoneSpurs bonespurs = new TraitBoneSpurs();

	public TraitApplyPotion peleshair = new TraitApplyPotion("peleshair", TextFormatting.DARK_PURPLE, true,
			new PotionEffect(MobEffects.LUCK, 1, 10), new PotionEffect(MobEffects.UNLUCK, 1, 10));
	public TraitReduceKnockback pillarsoftitans = new TraitReduceKnockback("pillarsoftitans",
			TextFormatting.DARK_PURPLE, 0.25f);
	public TraitDamageSourceAlteration emberwalker = new TraitDamageSourceAlteration("emberwalker",
			TextFormatting.DARK_PURPLE, new TraitDamageSourceAlteration.DamagePercent(DamageSource.IN_FIRE, -0.5f),
			new TraitDamageSourceAlteration.DamagePercent(DamageSource.ON_FIRE, -0.5f),
			new TraitDamageSourceAlteration.DamagePercent(DamageSource.HOT_FLOOR, -1.0f));

	public TraitGills gills = new TraitGills();
	public TraitBuoyant buoyant = new TraitBuoyant();
	public TraitCurrentRider currentrider = new TraitCurrentRider();
	public TraitFins fins = new TraitFins();

	public TraitWarpedMind warpedmind = new TraitWarpedMind();
	public TraitWarp warp = new TraitWarp();
	public TraitHydrophobic hydrophobic = new TraitHydrophobic();
	public TraitVoidCall voidcall = new TraitVoidCall();

	public TraitArrowCatcher arrowcatcher = new TraitArrowCatcher();
	public TraitNovel novel = new TraitNovel();

	public TraitSoggy soggy = new TraitSoggy();

	public TraitHotHead hothead = new TraitHotHead();
	public TraitToasty toasty = new TraitToasty();
	public TraitIncinerate incinerate = new TraitIncinerate();
	public TraitHotFoot hotfoot = new TraitHotFoot();

	public TraitMagnetism magnetism = new TraitMagnetism();
	public TraitDamageNegation hardhat = new TraitDamageNegation("hardhat", TextFormatting.GRAY, 1000,
			DamageSource.ANVIL, DamageSource.FALLING_BLOCK);
	public TraitIronclad ironclad = new TraitIronclad();
	public TraitReduceKnockback maglock = new TraitReduceKnockback("maglock", TextFormatting.GRAY, 0.25f,
			Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BLOCK.getDefaultState(), Blocks.IRON_DOOR.getDefaultState(),
			Blocks.IRON_ORE.getDefaultState(), Blocks.IRON_TRAPDOOR.getDefaultState());
	
	public TraitPiggy piggy = new TraitPiggy();
	public TraitHog hog = new TraitHog();

	public void preInit() {

		// TinkerRegistry.addMaterialTrait(TinkerMaterials.wood, rooted,
		// FeetMaterialStats.TYPE);
	}

	public void init() {
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.wood, photosynth2,
		// HelmMaterialStats.TYPE);
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.wood, photosynth,
		// ChestMaterialStats.TYPE);
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.wood, rooted,
		// LegsMaterialStats.TYPE);

		TinkerMaterials.wood.addTrait(photosynth2, HelmMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(photosynth, ChestMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(rooted, LegsMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(rooted, FeetMaterialStats.TYPE);

		TinkerMaterials.stone.addTrait(blockhead, HelmMaterialStats.TYPE);
		TinkerMaterials.stone.addTrait(stoned, ChestMaterialStats.TYPE);
		TinkerMaterials.stone.addTrait(earthbound, LegsMaterialStats.TYPE);
		TinkerMaterials.stone.addTrait(earthbound, FeetMaterialStats.TYPE);

		TinkerMaterials.flint.addTrait(glassine, HelmMaterialStats.TYPE);
		TinkerMaterials.flint.addTrait(glassine, ChestMaterialStats.TYPE);
		TinkerMaterials.flint.addTrait(glassine, LegsMaterialStats.TYPE);
		TinkerMaterials.flint.addTrait(glassine, FeetMaterialStats.TYPE);

		TinkerMaterials.cactus.addTrait(peyote, HelmMaterialStats.TYPE);
		TinkerMaterials.cactus.addTrait(spiny, ChestMaterialStats.TYPE);
		TinkerMaterials.cactus.addTrait(pricked, LegsMaterialStats.TYPE);

		TinkerMaterials.bone.addTrait(thickheaded, HelmMaterialStats.TYPE);
		TinkerMaterials.bone.addTrait(calcium, ChestMaterialStats.TYPE);
		TinkerMaterials.bone.addTrait(collagen, LegsMaterialStats.TYPE);
		TinkerMaterials.bone.addTrait(bonespurs, FeetMaterialStats.TYPE);

		TinkerMaterials.obsidian.addTrait(peleshair, HelmMaterialStats.TYPE);
		TinkerMaterials.obsidian.addTrait(glassine, ChestMaterialStats.TYPE);
		TinkerMaterials.obsidian.addTrait(pillarsoftitans, LegsMaterialStats.TYPE);
		TinkerMaterials.obsidian.addTrait(emberwalker, FeetMaterialStats.TYPE);

		TinkerMaterials.prismarine.addTrait(gills, HelmMaterialStats.TYPE);
		TinkerMaterials.prismarine.addTrait(buoyant, ChestMaterialStats.TYPE);
		TinkerMaterials.prismarine.addTrait(currentrider, LegsMaterialStats.TYPE);
		TinkerMaterials.prismarine.addTrait(fins, FeetMaterialStats.TYPE);

		TinkerMaterials.endstone.addTrait(warpedmind, HelmMaterialStats.TYPE);
		TinkerMaterials.endstone.addTrait(warp, ChestMaterialStats.TYPE);
		TinkerMaterials.endstone.addTrait(hydrophobic, LegsMaterialStats.TYPE);
		TinkerMaterials.endstone.addTrait(voidcall, FeetMaterialStats.TYPE);

		TinkerMaterials.paper.addTrait(arrowcatcher, HelmMaterialStats.TYPE);
		TinkerMaterials.paper.addTrait(arrowcatcher, ChestMaterialStats.TYPE);
		TinkerMaterials.paper.addTrait(arrowcatcher, LegsMaterialStats.TYPE);
		TinkerMaterials.paper.addTrait(arrowcatcher, FeetMaterialStats.TYPE);
		TinkerMaterials.paper.addTrait(novel, HelmMaterialStats.TYPE);
		TinkerMaterials.paper.addTrait(novel, ChestMaterialStats.TYPE);
		TinkerMaterials.paper.addTrait(novel, LegsMaterialStats.TYPE);
		TinkerMaterials.paper.addTrait(novel, FeetMaterialStats.TYPE);

		TinkerMaterials.sponge.addTrait(soggy, HelmMaterialStats.TYPE);
		TinkerMaterials.sponge.addTrait(soggy, ChestMaterialStats.TYPE);
		TinkerMaterials.sponge.addTrait(soggy, LegsMaterialStats.TYPE);
		TinkerMaterials.sponge.addTrait(soggy, FeetMaterialStats.TYPE);

		TinkerMaterials.firewood.addTrait(incinerate, ShieldMaterialStats.TYPE);
		TinkerMaterials.firewood.addTrait(hothead, HelmMaterialStats.TYPE);
		TinkerMaterials.firewood.addTrait(toasty, ChestMaterialStats.TYPE);
		TinkerMaterials.firewood.addTrait(incinerate, LegsMaterialStats.TYPE);
		TinkerMaterials.firewood.addTrait(hotfoot, FeetMaterialStats.TYPE);

		TinkerMaterials.iron.addTrait(magnetism, ShieldMaterialStats.TYPE);
		TinkerMaterials.iron.addTrait(hardhat, HelmMaterialStats.TYPE);
		TinkerMaterials.iron.addTrait(magnetism, ChestMaterialStats.TYPE);
		TinkerMaterials.iron.addTrait(ironclad, LegsMaterialStats.TYPE);
		TinkerMaterials.iron.addTrait(maglock, FeetMaterialStats.TYPE);
		
		TinkerMaterials.pigiron.addTrait(piggy, HelmMaterialStats.TYPE);
		TinkerMaterials.pigiron.addTrait(hog, ChestMaterialStats.TYPE);
	}

	public void postInit() {

	}
}
