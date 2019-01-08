package lance5057.tDefense.core.materials;

import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import lance5057.tDefense.core.materials.traits.TraitAcknowledged;
import lance5057.tDefense.core.materials.traits.TraitApplyPotion;
import lance5057.tDefense.core.materials.traits.TraitAqualung;
import lance5057.tDefense.core.materials.traits.TraitArrowCatcher;
import lance5057.tDefense.core.materials.traits.TraitBattleHardened;
import lance5057.tDefense.core.materials.traits.TraitBoneSpurs;
import lance5057.tDefense.core.materials.traits.TraitBuoyant;
import lance5057.tDefense.core.materials.traits.TraitCombatAdvantage;
import lance5057.tDefense.core.materials.traits.TraitCurrentRider;
import lance5057.tDefense.core.materials.traits.TraitDamageNegation;
import lance5057.tDefense.core.materials.traits.TraitDamageReductionDimension;
import lance5057.tDefense.core.materials.traits.TraitDamageSourceAlteration;
import lance5057.tDefense.core.materials.traits.TraitDamnation;
import lance5057.tDefense.core.materials.traits.TraitDemonic;
import lance5057.tDefense.core.materials.traits.TraitEarthbound;
import lance5057.tDefense.core.materials.traits.TraitFins;
import lance5057.tDefense.core.materials.traits.TraitFirewalker;
import lance5057.tDefense.core.materials.traits.TraitFlexible;
import lance5057.tDefense.core.materials.traits.TraitForestMask;
import lance5057.tDefense.core.materials.traits.TraitGills;
import lance5057.tDefense.core.materials.traits.TraitGlassine;
import lance5057.tDefense.core.materials.traits.TraitGoggles;
import lance5057.tDefense.core.materials.traits.TraitGreenthumb;
import lance5057.tDefense.core.materials.traits.TraitHeavyweight;
import lance5057.tDefense.core.materials.traits.TraitHeroic;
import lance5057.tDefense.core.materials.traits.TraitHog;
import lance5057.tDefense.core.materials.traits.TraitHotFoot;
import lance5057.tDefense.core.materials.traits.TraitHotHead;
import lance5057.tDefense.core.materials.traits.TraitHydrophobic;
import lance5057.tDefense.core.materials.traits.TraitIgnite;
import lance5057.tDefense.core.materials.traits.TraitIncinerate;
import lance5057.tDefense.core.materials.traits.TraitIronclad;
import lance5057.tDefense.core.materials.traits.TraitMagnetism;
import lance5057.tDefense.core.materials.traits.TraitNovel;
import lance5057.tDefense.core.materials.traits.TraitPeyote;
import lance5057.tDefense.core.materials.traits.TraitPhotosynthetic;
import lance5057.tDefense.core.materials.traits.TraitPiggy;
import lance5057.tDefense.core.materials.traits.TraitPotionRemoval;
import lance5057.tDefense.core.materials.traits.TraitPricked;
import lance5057.tDefense.core.materials.traits.TraitPyrosynthesis;
import lance5057.tDefense.core.materials.traits.TraitReduceKnockback;
import lance5057.tDefense.core.materials.traits.TraitReflex;
import lance5057.tDefense.core.materials.traits.TraitRetribution;
import lance5057.tDefense.core.materials.traits.TraitRigid;
import lance5057.tDefense.core.materials.traits.TraitShifting;
import lance5057.tDefense.core.materials.traits.TraitSoggy;
import lance5057.tDefense.core.materials.traits.TraitSounder;
import lance5057.tDefense.core.materials.traits.TraitSpiny;
import lance5057.tDefense.core.materials.traits.TraitStatuesque;
import lance5057.tDefense.core.materials.traits.TraitStoned;
import lance5057.tDefense.core.materials.traits.TraitStonekin;
import lance5057.tDefense.core.materials.traits.TraitSuperSonic;
import lance5057.tDefense.core.materials.traits.TraitTempered;
import lance5057.tDefense.core.materials.traits.TraitToasty;
import lance5057.tDefense.core.materials.traits.TraitTrotters;
import lance5057.tDefense.core.materials.traits.TraitVoidCall;
import lance5057.tDefense.core.materials.traits.TraitWarp;
import lance5057.tDefense.core.materials.traits.TraitWarpedMind;
import lance5057.tDefense.core.materials.traits.TraitWindy;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DimensionType;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTraits;

public class CompendiumTraits {

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
	public TraitSounder sounder = new TraitSounder();
	public TraitTrotters trotters = new TraitTrotters();

	public TraitShifting shifting = new TraitShifting(blockhead, glassine, hothead, incinerate, magnetism, novel, warp);
	public TraitReduceKnockback gumshoe2 = new TraitReduceKnockback("gumshoe2", TextFormatting.LIGHT_PURPLE, 0.5f);

	public TraitDamageReductionDimension hellbound = new TraitDamageReductionDimension("hellbound",
			TextFormatting.DARK_RED, DimensionType.NETHER, 0.75f);
	public TraitPyrosynthesis pyrosynthetic = new TraitPyrosynthesis(1);
	public TraitPyrosynthesis pyrosynthetic2 = new TraitPyrosynthesis(2);
	public TraitFirewalker firewalker = new TraitFirewalker(3);

	public TraitForestMask forestmask = new TraitForestMask();
	public TraitPotionRemoval slick = new TraitPotionRemoval("slick", TextFormatting.GREEN, MobEffects.SLOWNESS,
			MobEffects.MINING_FATIGUE);
	public TraitGreenthumb greenthumb = new TraitGreenthumb();

	public TraitGoggles goggles = new TraitGoggles();
	public TraitAqualung aqualung = new TraitAqualung();

	public TraitDemonic demonic = new TraitDemonic();
	public TraitDamnation damnation = new TraitDamnation();
	public TraitIgnite ignite = new TraitIgnite();

	public TraitWindy windy = new TraitWindy();
	public TraitPotionRemoval aerodynamic = new TraitPotionRemoval("aerodynamic", TextFormatting.BLUE,
			MobEffects.SLOWNESS);
	public TraitSuperSonic supersonic = new TraitSuperSonic();
	public TraitFlexible flexible = new TraitFlexible();

	public TraitStatuesque statuesque = new TraitStatuesque();
	public TraitStonekin stonekin = new TraitStonekin();
	public TraitHeavyweight heavyweight = new TraitHeavyweight();

	public TraitCombatAdvantage combatadvantage = new TraitCombatAdvantage();
	public TraitBattleHardened battlehardened = new TraitBattleHardened("battlehardened", TextFormatting.DARK_PURPLE,
			1);
	public TraitReflex reflex = new TraitReflex();

	public TraitAcknowledged acknowledged = new TraitAcknowledged();
	public TraitBattleHardened workhardened = new TraitBattleHardened("workhardened", TextFormatting.RED, 5);

	public TraitHeroic heroic = new TraitHeroic();

	public TraitApplyPotion slowing = new TraitApplyPotion("slowing", TextFormatting.LIGHT_PURPLE, false,
			new PotionEffect(MobEffects.SLOWNESS, 5, 1));

	public TraitRetribution retribution_1 = new TraitRetribution(1);

	public TraitRigid rigid = new TraitRigid();
	public TraitTempered tempered = new TraitTempered();

	public TraitDamageSourceAlteration ohm = new TraitDamageSourceAlteration("ohm", TextFormatting.YELLOW,
			new TraitDamageSourceAlteration.DamagePercent(DamageSource.LIGHTNING_BOLT, -0.5f));

	public void preInit() {

	}

	public void init() {
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
		TinkerMaterials.pigiron.addTrait(sounder, LegsMaterialStats.TYPE);
		TinkerMaterials.pigiron.addTrait(trotters, FeetMaterialStats.TYPE);

		TinkerMaterials.knightslime.addTrait(shifting, HelmMaterialStats.TYPE);
		TinkerMaterials.knightslime.addTrait(shifting, ChestMaterialStats.TYPE);
		TinkerMaterials.knightslime.addTrait(shifting, LegsMaterialStats.TYPE);
		TinkerMaterials.knightslime.addTrait(gumshoe2, FeetMaterialStats.TYPE);

		TinkerMaterials.magmaslime.addTrait(pyrosynthetic, HelmMaterialStats.TYPE);
		TinkerMaterials.magmaslime.addTrait(pyrosynthetic2, ChestMaterialStats.TYPE);
		TinkerMaterials.magmaslime.addTrait(slick, LegsMaterialStats.TYPE);
		TinkerMaterials.magmaslime.addTrait(firewalker, FeetMaterialStats.TYPE);
		TinkerMaterials.magmaslime.addTrait(hellbound, HelmMaterialStats.TYPE);
		TinkerMaterials.magmaslime.addTrait(hellbound, ChestMaterialStats.TYPE);
		TinkerMaterials.magmaslime.addTrait(hellbound, LegsMaterialStats.TYPE);
		TinkerMaterials.magmaslime.addTrait(hellbound, FeetMaterialStats.TYPE);

		TinkerMaterials.slime.addTrait(forestmask, HelmMaterialStats.TYPE);
		TinkerMaterials.slime.addTrait(photosynth, ChestMaterialStats.TYPE);
		TinkerMaterials.slime.addTrait(slick, LegsMaterialStats.TYPE);
		TinkerMaterials.slime.addTrait(greenthumb, FeetMaterialStats.TYPE);

		TinkerMaterials.blueslime.addTrait(goggles, HelmMaterialStats.TYPE);
		TinkerMaterials.blueslime.addTrait(aqualung, ChestMaterialStats.TYPE);
		TinkerMaterials.blueslime.addTrait(slick, LegsMaterialStats.TYPE);
		TinkerMaterials.blueslime.addTrait(fins, FeetMaterialStats.TYPE);

		TinkerMaterials.netherrack.addTrait(demonic, HelmMaterialStats.TYPE);
		TinkerMaterials.netherrack.addTrait(hellbound, ChestMaterialStats.TYPE);
		TinkerMaterials.netherrack.addTrait(damnation, LegsMaterialStats.TYPE);
		TinkerMaterials.netherrack.addTrait(ignite, FeetMaterialStats.TYPE);

		TinkerMaterials.cobalt.addTrait(windy, HelmMaterialStats.TYPE);
		TinkerMaterials.cobalt.addTrait(aerodynamic, ChestMaterialStats.TYPE);
		TinkerMaterials.cobalt.addTrait(supersonic, LegsMaterialStats.TYPE);
		TinkerMaterials.cobalt.addTrait(flexible, FeetMaterialStats.TYPE);

		TinkerMaterials.ardite.addTrait(hardhat, HelmMaterialStats.TYPE);
		TinkerMaterials.ardite.addTrait(statuesque, ChestMaterialStats.TYPE);
		TinkerMaterials.ardite.addTrait(stonekin, LegsMaterialStats.TYPE);
		TinkerMaterials.ardite.addTrait(heavyweight, FeetMaterialStats.TYPE);

		TinkerMaterials.copper.addTrait(acknowledged, HelmMaterialStats.TYPE);
		TinkerMaterials.copper.addTrait(workhardened, ChestMaterialStats.TYPE);
		TinkerMaterials.copper.addTrait(workhardened, LegsMaterialStats.TYPE);
		TinkerMaterials.copper.addTrait(acknowledged, FeetMaterialStats.TYPE);

		TinkerMaterials.bronze.addTrait(TinkerTraits.dense, HelmMaterialStats.TYPE);
		TinkerMaterials.bronze.addTrait(TinkerTraits.dense, ChestMaterialStats.TYPE);
		TinkerMaterials.bronze.addTrait(TinkerTraits.dense, LegsMaterialStats.TYPE);
		TinkerMaterials.bronze.addTrait(TinkerTraits.dense, FeetMaterialStats.TYPE);
		TinkerMaterials.bronze.addTrait(heroic, HelmMaterialStats.TYPE);
		TinkerMaterials.bronze.addTrait(heroic, ChestMaterialStats.TYPE);
		TinkerMaterials.bronze.addTrait(heroic, LegsMaterialStats.TYPE);
		TinkerMaterials.bronze.addTrait(heroic, FeetMaterialStats.TYPE);

		TinkerMaterials.silver.addTrait(retribution_1, HelmMaterialStats.TYPE);
		TinkerMaterials.silver.addTrait(retribution_1, ChestMaterialStats.TYPE);
		TinkerMaterials.silver.addTrait(retribution_1, LegsMaterialStats.TYPE);
		TinkerMaterials.silver.addTrait(retribution_1, FeetMaterialStats.TYPE);

		TinkerMaterials.steel.addTrait(rigid, HelmMaterialStats.TYPE);
		TinkerMaterials.steel.addTrait(rigid, ChestMaterialStats.TYPE);
		TinkerMaterials.steel.addTrait(rigid, LegsMaterialStats.TYPE);
		TinkerMaterials.steel.addTrait(rigid, FeetMaterialStats.TYPE);
		TinkerMaterials.steel.addTrait(tempered, HelmMaterialStats.TYPE);
		TinkerMaterials.steel.addTrait(tempered, ChestMaterialStats.TYPE);
		TinkerMaterials.steel.addTrait(tempered, LegsMaterialStats.TYPE);
		TinkerMaterials.steel.addTrait(tempered, FeetMaterialStats.TYPE);

		TinkerMaterials.electrum.addTrait(tempered, HelmMaterialStats.TYPE);
		TinkerMaterials.electrum.addTrait(tempered, ChestMaterialStats.TYPE);
		TinkerMaterials.electrum.addTrait(tempered, LegsMaterialStats.TYPE);
		TinkerMaterials.electrum.addTrait(maglock, FeetMaterialStats.TYPE);
	}

	public void postInit() {

	}
}
