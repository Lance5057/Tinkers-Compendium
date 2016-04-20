package lance5057.tDefense;

import scala.Int;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class TD_Config
{
	static int		count	= 18;
	public int		AeonsteelMatID;
	public int		QueensGoldMatID;
	public int		DogbeariumMatID;
	public int		RedMintMatID;
	public int		GreenMintMatID;

	public int		SoulBoundID;
	public int		DazeID;
	public int		CrestFeathersID;
	public int		CrestMirrorsID;
	public int		CrestLegendsID;
	public int		CrestBladesID;

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
	public int		TerraCoreIvyModID;
	public int		ArmorPixieCoreModID;
	public int		ArmorManaDiscountModID;

	public boolean	ThaumcraftAddon;
	public int		RevealingModID;
	public int		VisDiscountModID;
	public int		CapsModID;
	//public int		SpellbindModID;

	public boolean	BloodMagicAddon;
	public int		BloodLustModID;
	public int		BloodOathModID;
	public int		ScabbingModID;

	public TD_Config(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());

		config.load();

		MaterialIndex = config.getInt("Material Index","Highest material ID" , 206, 30, Int.MaxValue(), "TDefense - 206 MFR - 1001 ExtraTIC - 1024");

		AeonsteelMatID = config.get("Material Configs", "Aeonsteel Material ID", 201).getInt();
		QueensGoldMatID = config.get("Material Configs", "QueensGold Material ID", 202).getInt();
		DogbeariumMatID = config.get("Material Configs", "Dogbearium Material ID", 203).getInt();
		RedMintMatID = config.get("Material Configs", "RedMint Material ID", 204).getInt();
		GreenMintMatID = config.get("Material Configs", "GreenMint Material ID", 205).getInt();

		DazeID = config.get("Modifier Configs", "Daze ID", count++).getInt();
		CrestFeathersID = config.get("Modifier Configs", "Crest of Feathers ID", count++).getInt();
		CrestMirrorsID = config.get("Modifier Configs", "Crest of Mirrors ID", count++).getInt();
		CrestLegendsID = config.get("Modifier Configs", "Crest of Legends ID", count++).getInt();
		CrestLegendsID = config.get("Modifier Configs", "Crest of Legends ID", count++).getInt();
		SoulBoundID = config.get("Modifier Configs", "Soulbound ID", count++).getInt();

		ArmorProtectionID = config.get("Armor Modifier Configs", "Protection ID", count++).getInt();
		ArmorFireProtectionID = config.get("Armor Modifier Configs", "Fire Protection ID", count++).getInt();
		ArmorBlastProtectionID = config.get("Armor Modifier Configs", "Blast Protection ID", count++).getInt();
		ArmorProjectileProtectionID = config.get("Armor Modifier Configs", "Projectile Protection ID", count++).getInt();
		ArmorFeatherfallID = config.get("Armor Modifier Configs", "Featherfall ID", count++).getInt();
		ArmorGlowstepID = config.get("Armor Modifier Configs", "Glowstep ID", count++).getInt();
		ArmorFrostwalkerID = config.get("Armor Modifier Configs", "Frostwalker ID", count++).getInt();
		ArmorFirewalkerID = config.get("Armor Modifier Configs", "Firewalker ID", count++).getInt();
		ArmorDepthstriderID = config.get("Armor Modifier Configs", "Depthstrider ID", count++).getInt();
		ArmorRebreatherID = config.get("Armor Modifier Configs", "Rebreather ID", count++).getInt();
		ArmorNightvisionID = config.get("Armor Modifier Configs", "Nightvision ID", count++).getInt();
		ArmorAntiBlindnessID = config.get("Armor Modifier Configs", "Anti Blindness ID", count++).getInt();
		ArmorPumpkinID = config.get("Armor Modifier Configs", "Pumpkin ID", count++).getInt();
		ArmorDodgeID = config.get("Armor Modifier Configs", "Dodge ID", count++).getInt();
		ArmorThornsID = config.get("Armor Modifier Configs", "Thorns ID", count++).getInt();
		ArmorAbsorptionID = config.get("Armor Modifier Configs", "Absorbtion ID", count++).getInt();
		ArmorJumpboostID = config.get("Armor Modifier Configs", "Jump Boost ID", count++).getInt();
		ArmorSpeedID = config.get("Armor Modifier Configs", "Speed ID", count++).getInt();
		ArmorHighstepID = config.get("Armor Modifier Configs", "High Step ID", count++).getInt();
		ArmorKnockbackResistID = config.get("Armor Modifier Configs", "Knockback Resistance ID", count++).getInt();

		MineAndBladeAddon = config.getBoolean("Integration", "Enable Mine and Blade Addon", true, "");

		BotaniaAddon = config.getBoolean("Integration", "Enable Botania Addon", true, "");
		CorpseIvyModID = config.get("Botania Addon", "Corpse Drinker Ivy Modifier ID", count++).getInt();

		ThaumcraftAddon = config.getBoolean("Integration", "Enable Thaumcraft Addon", true, "Requires Thaumcraft to use");
		RevealingModID = config.get("Thaumcraft Addon", "Revealing Modifier ID", count++).getInt();
		VisDiscountModID = config.get("Thaumcraft Addon", "Vis Discount Modifier ID", count++).getInt();
		CapsModID = config.get("Thaumcraft Addon", "Cap Repair Modifier ID", count++).getInt();
		//SpellbindModID = config.getInt("Spellbinding Modifier ID", "Thaumcraft Addon", 73, 0, Integer.MAX_VALUE, "");

		config.save();
	}
}
