package lance5057.tDefense.core.materials;

import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import lance5057.tDefense.core.materials.traits.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DimensionType;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTraits;

public class CompendiumTraits {

	// Wood
	public TraitPhotosynthetic photosynth = new TraitPhotosynthetic(1);
	public TraitPhotosynthetic photosynth2 = new TraitPhotosynthetic(2);
	public TraitReduceKnockback rooted = new TraitReduceKnockback("rooted", 0x875e21, 0.5f,
			Blocks.DIRT.getDefaultState(), Blocks.GRASS.getDefaultState());
	public TraitAxeLover axelover = new TraitAxeLover();

	// Stone
	public TraitDamageSourceAlteration blockhead = new TraitDamageSourceAlteration("blockhead", 0x875e21,
			new TraitDamageSourceAlteration.DamagePercent(DamageSource.GENERIC, -0.5f),
			new TraitDamageSourceAlteration.DamagePercent(DamageSource.MAGIC, 0.5f));
	public TraitStoned stoned = new TraitStoned();
	public TraitEarthbound earthbound = new TraitEarthbound();
	public TraitDulling dulling = new TraitDulling();

	// Flint
	public TraitGlassine glassine = new TraitGlassine();
	public TraitFirestarter firestarter = new TraitFirestarter();

	// Cactus
	public TraitPeyote peyote = new TraitPeyote();
	public TraitSpiny spiny = new TraitSpiny();
	public TraitPricked pricked = new TraitPricked();
	public TraitBarbed barbed = new TraitBarbed();

	public TraitPotionRemoval thickheaded = new TraitPotionRemoval("thickheaded", TextFormatting.WHITE,
			MobEffects.BLINDNESS, MobEffects.NAUSEA);
	public TraitDamageNegation calcium = new TraitDamageNegation("calcium", TextFormatting.WHITE, 1f);
	public TraitDamageNegation collagen = new TraitDamageNegation("collagen", TextFormatting.WHITE, 1000f,
			DamageSource.FALL);
	public TraitBoneSpurs bonespurs = new TraitBoneSpurs();
	public TraitDogToy dogtoy = new TraitDogToy();

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
	public TraitStableStance stablestance = new TraitStableStance();

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

	public TraitTickTock ticktock = new TraitTickTock();
	public TraitEthereal ethereal = new TraitEthereal();
	public TraitClockstopper clockstopper = new TraitClockstopper();
	public TraitTrueSight truesight = new TraitTrueSight();
	public TraitIntangible intangible = new TraitIntangible();
	public TraitUndo undo = new TraitUndo();
	public TraitTimewarp timewarp = new TraitTimewarp();

	public TraitToothy toothy = new TraitToothy();
	public TraitCornered cornered = new TraitCornered();
	public TraitPoundofFlesh poundofflesh = new TraitPoundofFlesh();
	public TraitIHunger ihunger = new TraitIHunger();
	public TraitBurnAttacker hellbeast = new TraitBurnAttacker("hellbeast", 0x6d3300);
	public TraitAlpha alpha = new TraitAlpha();
	public TraitHunt hunt = new TraitHunt();

	private AbstractTrait mythical1 = new TraitMythical(1);
	private AbstractTrait mythical2 = new TraitMythical(2);
	
	public TraitRegal regal = new TraitRegal();
	
	//Froststeel
	

	public void preInit() {

	}

	public void init() {
		TinkerMaterials.wood.addTrait(photosynth2, HelmMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(photosynth, ChestMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(rooted, LegsMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(rooted, FeetMaterialStats.TYPE);
		TinkerMaterials.wood.addTrait(axelover, ShieldMaterialStats.TYPE);

		TinkerMaterials.stone.addTrait(blockhead, HelmMaterialStats.TYPE);
		TinkerMaterials.stone.addTrait(stoned, ChestMaterialStats.TYPE);
		TinkerMaterials.stone.addTrait(earthbound, LegsMaterialStats.TYPE);
		TinkerMaterials.stone.addTrait(earthbound, FeetMaterialStats.TYPE);
		TinkerMaterials.stone.addTrait(dulling, ShieldMaterialStats.TYPE);

		TinkerMaterials.flint.addTrait(glassine, HelmMaterialStats.TYPE);
		TinkerMaterials.flint.addTrait(glassine, ChestMaterialStats.TYPE);
		TinkerMaterials.flint.addTrait(glassine, LegsMaterialStats.TYPE);
		TinkerMaterials.flint.addTrait(glassine, FeetMaterialStats.TYPE);
		TinkerMaterials.flint.addTrait(firestarter, ShieldMaterialStats.TYPE);

		TinkerMaterials.cactus.addTrait(peyote, HelmMaterialStats.TYPE);
		TinkerMaterials.cactus.addTrait(spiny, ChestMaterialStats.TYPE);
		TinkerMaterials.cactus.addTrait(pricked, LegsMaterialStats.TYPE);
		TinkerMaterials.cactus.addTrait(barbed, ShieldMaterialStats.TYPE);

		TinkerMaterials.bone.addTrait(thickheaded, HelmMaterialStats.TYPE);
		TinkerMaterials.bone.addTrait(calcium, ChestMaterialStats.TYPE);
		TinkerMaterials.bone.addTrait(collagen, LegsMaterialStats.TYPE);
		TinkerMaterials.bone.addTrait(bonespurs, FeetMaterialStats.TYPE);
		TinkerMaterials.bone.addTrait(dogtoy, ShieldMaterialStats.TYPE);

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
		
		TinkerMaterials.manyullyn.addTrait(this.combatadvantage, HelmMaterialStats.TYPE);
		TinkerMaterials.manyullyn.addTrait(this.battlehardened, ChestMaterialStats.TYPE);
		TinkerMaterials.manyullyn.addTrait(this.reflex, LegsMaterialStats.TYPE);
		TinkerMaterials.manyullyn.addTrait(this.stablestance, FeetMaterialStats.TYPE);

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

		if (CompendiumMaterials.aeonsteel != null) {
			CompendiumMaterials.aeonsteel.mat.addTrait(ticktock, HandleMaterialStats.TYPE);
			CompendiumMaterials.aeonsteel.mat.addTrait(ticktock, ExtraMaterialStats.TYPE);
			CompendiumMaterials.aeonsteel.mat.addTrait(ethereal, HeadMaterialStats.TYPE);
			CompendiumMaterials.aeonsteel.mat.addTrait(clockstopper, ShieldMaterialStats.TYPE);
			CompendiumMaterials.aeonsteel.mat.addTrait(truesight, HelmMaterialStats.TYPE);
			CompendiumMaterials.aeonsteel.mat.addTrait(intangible, ChestMaterialStats.TYPE);
			CompendiumMaterials.aeonsteel.mat.addTrait(undo, LegsMaterialStats.TYPE);
			CompendiumMaterials.aeonsteel.mat.addTrait(timewarp, FeetMaterialStats.TYPE);
		}

		if (CompendiumMaterials.dogbearium != null) {
			CompendiumMaterials.dogbearium.mat.addTrait(toothy, HandleMaterialStats.TYPE);
			CompendiumMaterials.dogbearium.mat.addTrait(toothy, ExtraMaterialStats.TYPE);
			CompendiumMaterials.dogbearium.mat.addTrait(cornered, HeadMaterialStats.TYPE);
			CompendiumMaterials.dogbearium.mat.addTrait(poundofflesh, ShieldMaterialStats.TYPE);
			CompendiumMaterials.dogbearium.mat.addTrait(ihunger, HelmMaterialStats.TYPE);
			CompendiumMaterials.dogbearium.mat.addTrait(hellbeast, ChestMaterialStats.TYPE);
			CompendiumMaterials.dogbearium.mat.addTrait(alpha, LegsMaterialStats.TYPE);
			CompendiumMaterials.dogbearium.mat.addTrait(hunt, FeetMaterialStats.TYPE);
		}

		if (CompendiumMaterials.mithril != null){
			CompendiumMaterials.mithril.mat.addTrait(mythical1);
			CompendiumMaterials.mithril.mat.addTrait(mythical2, HeadMaterialStats.TYPE);
		}
		
		if(CompendiumMaterials.queensgold != null) {
			CompendiumMaterials.queensgold.mat.addTrait(regal, HeadMaterialStats.TYPE);
		}
	}

	public void postInit() {

	}
}
