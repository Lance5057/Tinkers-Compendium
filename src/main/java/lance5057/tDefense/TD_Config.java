package lance5057.tDefense;

import net.minecraftforge.common.config.Configuration;
import scala.Int;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class TD_Config
{
	public boolean	debug;
	public boolean	ArmorAddon;
	public boolean	transparency;
	public boolean	mossEnabled;
	public boolean	mossHard;

	static int		count	= 18;
	public int		AeonsteelMatID;
	public int		QueensGoldMatID;
	public int		DogbeariumMatID;
	public int		RedMintMatID;
	public int		GreenMintMatID;

	public int		SoulBoundID;
	public int		DazeID;
	public int		RainbowID;
	public int		XPBoostID;
	public int		ShearFortuneID;

	public int[]	CrestFeathersID;
	public int[]	CrestMirrorsID;
	public int[]	CrestLegendsID;
	public int[]	CrestBladesID;
	public int[]	CrestGluttonyID;
	public int[]	CrestPitchID;
	public int[]	CrestThornsID;
	public int[]	CrestSanguisugaID;
	public int[]	CrestWindsID;
	public int[]	CrestRetributionID;
	public int[]	CrestLightID;

	//public int		JokeInsultID;
	public int		JokePyrotechID;
	//public int		JokeCompensateID;

	public int		SoulSteveID;

	public int		ArmorProtectionID;
	public int		ArmorFireProtectionID;
	public int		ArmorBlastProtectionID;
	public int		ArmorProjectileProtectionID;
	public int		ArmorFeatherfallID;
	public int		ArmorGlowstepID;
	public int		ArmorFrostwalkerID;
	public int		ArmorFirewalkerID;
	public int		ArmorDepthstriderID;
	public int		ArmorRebreatherID;
	public int		ArmorNightvisionID;
	public int		ArmorAntiBlindnessID;
	public int		ArmorPumpkinID;
	public int		ArmorDodgeID;
	public int		ArmorThornsID;
	public int		ArmorAbsorptionID;
	public int		ArmorJumpboostID;
	public int		ArmorSpeedID;
	public int		ArmorHighstepID;
	public int		ArmorKnockbackResistID;

	public int		MaterialIndex;

	public boolean	MineAndBladeAddon;

	public boolean	BotaniaAddon;
	public int		CorpseIvyModID;
	public int		ManaRepairModID;
	public int		TerraCoreModID;
	public int		ArmorPixieCoreModID;
	public int		ArmorManaDiscountModID;

	public boolean	ThaumcraftAddon;
	public int		RevealingModID;
	public int		VisDiscountModID;
	public int		CapsModID;
	//public int		SpellbindModID;

	public boolean	BloodMagicAddon;
	public int		SuppingModID;
	public int		BloodOathModID;
	public int		ScabbingModID;
	public int		DivinationModID;

	public TD_Config(FMLPreInitializationEvent e)
	{
		final Configuration config = new Configuration(
				e.getSuggestedConfigurationFile());

		config.load();

		debug = config.getBoolean("Should debug mode be enabled?", "Debug Mode", false, null);
		ArmorAddon = config.getBoolean("Should the armor addon be enabled?", "Armor Addon", true, null);
		transparency = config.getBoolean("Should Transparent Textures be enabled?", "General Settings", true, "May help fps if disabled");
		mossEnabled = config.getBoolean("Should the moss recipe be enabled?", "General Settings", true, null);
		mossHard = config.getBoolean("Should the moss recipe be hard?", "General Settings", true, null);

		MaterialIndex = config.getInt("Material Index", "Highest material ID", 206, 30, Int.MaxValue(), "TDefense - 206 MFR - 1001 ExtraTIC - 1024");

		AeonsteelMatID = config.getInt("Aeonsteel Material ID", "Material Configs", 201, 30, Int.MaxValue(), null);
		QueensGoldMatID = config.getInt("QueensGold Material ID", "Material Configs", 202, 30, Int.MaxValue(), null);
		DogbeariumMatID = config.getInt("Dogbearium Material ID", "Material Configs", 203, 30, Int.MaxValue(), null);
		RedMintMatID = config.getInt("RedMint Material ID", "Material Configs", 204, 30, Int.MaxValue(), null);
		GreenMintMatID = config.getInt("GreenMint Material ID", "Material Configs", 205, 30, Int.MaxValue(), null);

		DazeID = config.getInt("Daze ID", "Modifier Configs", count++, 18, Int.MaxValue(), null);
		SoulBoundID = config.getInt("Soulbound ID", "Modifier Configs", count++, 18, Int.MaxValue(), null);
		RainbowID = config.getInt("Rainbow ID", "Modifier Configs", count++, 18, Int.MaxValue(), null);
		XPBoostID = config.getInt("XPBoost ID", "Modifier Configs", count++, 18, Int.MaxValue(), null);
		ShearFortuneID = config.getInt("Fortune for Shears ID", "Modifier Configs", count++, 18, Int.MaxValue(), null);

		CrestFeathersID = ConfigCrest(config, "Feathers");
		CrestMirrorsID = ConfigCrest(config, "Mirrors");
		CrestLegendsID = ConfigCrest(config, "Legends");
		CrestBladesID = ConfigCrest(config, "Blades");
		CrestGluttonyID = ConfigCrest(config, "Gluttony");
		CrestPitchID = ConfigCrest(config, "Pitch");
		CrestThornsID = ConfigCrest(config, "Thorns");
		CrestSanguisugaID = ConfigCrest(config, "Sanguisuga");
		CrestWindsID = ConfigCrest(config, "Winds");
		CrestRetributionID = ConfigCrest(config, "Retribution");
		CrestLightID = ConfigCrest(config, "Light");

		SoulSteveID = config.getInt("Soulstone Steve ID", "Modifier Configs", count++, 18, Int.MaxValue(), null);

		ArmorProtectionID = config.getInt("Protection ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorFireProtectionID = config.getInt("Fire Protection ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorBlastProtectionID = config.getInt("Blast Protection ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorProjectileProtectionID = config.getInt("Projectile Protection ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorFeatherfallID = config.getInt("Featherfall ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorGlowstepID = config.getInt("Glowstep ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorFrostwalkerID = config.getInt("Frostwalker ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorFirewalkerID = config.getInt("Firewalker ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorDepthstriderID = config.getInt("Depthstrider ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorRebreatherID = config.getInt("Rebreather ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorNightvisionID = config.getInt("Nightvision ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorAntiBlindnessID = config.getInt("Anti Blindness ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorPumpkinID = config.getInt("Pumpkin ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorDodgeID = config.getInt("Dodge ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorThornsID = config.getInt("Thorns ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorAbsorptionID = config.getInt("Absorbtion ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorJumpboostID = config.getInt("Jump Boost ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorSpeedID = config.getInt("Speed ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorHighstepID = config.getInt("High Step ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);
		ArmorKnockbackResistID = config.getInt("Knockback Resistance ID", "Armor Modifier Configs", count++, 18, Int.MaxValue(), null);

		MineAndBladeAddon = config.getBoolean("Enable Mine and Blade Addon", "Integration", true, "");

		BotaniaAddon = config.getBoolean("Enable Botania Addon", "Integration", true, "");
		CorpseIvyModID = config.getInt("Corpse Drinker Ivy Modifier ID", "Botania Addon", count++, 18, Int.MaxValue(), null);
		ManaRepairModID = config.getInt("Mana Repair Modifier ID", "Botania Addon", count++, 18, Int.MaxValue(), null);
		TerraCoreModID = config.getInt("Terra Core Modifier ID", "Botania Addon", count++, 18, Int.MaxValue(), null);
		ArmorPixieCoreModID = config.getInt("Elementium Core Modifier ID", "Botania Addon", count++, 18, Int.MaxValue(), null);
		ArmorManaDiscountModID = config.getInt("Mana Embroidery Modifier ID", "Botania Addon", count++, 18, Int.MaxValue(), null);

		ThaumcraftAddon = config.getBoolean("Enable Thaumcraft Addon", "Integration", true, "Requires Thaumcraft to use");
		RevealingModID = config.getInt("Revealing Modifier ID", "Thaumcraft Addon", count++, 18, Int.MaxValue(), null);
		VisDiscountModID = config.getInt("Vis Discount Modifier ID", "Thaumcraft Addon", count++, 18, Int.MaxValue(), null);
		CapsModID = config.getInt("Cap Repair Modifier ID", "Thaumcraft Addon", count++, 18, Int.MaxValue(), null);
		//SpellbindModID = config.getIntInt("Spellbinding Modifier ID", "Thaumcraft Addon", 73, 0, Integer.MAX_VALUE, "");

		BloodMagicAddon = config.getBoolean("Enable BloodMagic Addon", "Integration", true, "Requires BloodMagic to use");
		DivinationModID = config.getInt("Divination Modifier ID", "BloodMagic Addon", count++, 18, Int.MaxValue(), null);
		SuppingModID = config.getInt("Supping Modifier ID", "BloodMagic Addon", count++, 18, Int.MaxValue(), null);
		BloodOathModID = config.getInt("Blood Oath Modifier ID", "BloodMagic Addon", count++, 18, Int.MaxValue(), null);
		ScabbingModID = config.getInt("Scabbing Modifier ID", "BloodMagic Addon", count++, 18, Int.MaxValue(), null);

		//JokeInsultID = config.getInt("Insult ID", "Joke Modifier Configs", count++, 18, Int.MaxValue(), null);
		JokePyrotechID = config.getInt("Pyrotech ID", "Joke Modifier Configs", count++, 18, Int.MaxValue(), null);

		config.save();
	}

	private int[] ConfigCrest(Configuration config, String name)
	{
		final int[] crest = new int[TinkersDefense.colors.length];

		for(int i = 0; i < TinkersDefense.colors.length; i++)
		{
			crest[i] = config.getInt("Crest of " + name + " (" + TinkersDefense.colors[i] + ") ID", "Shield Modifier Configs", count++, 18, Int.MaxValue(), null);
		}

		return crest;
	}
}
