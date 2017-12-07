package lance5057.tDefense;

import lance5057.tDefense.util.Color16Util;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.Int;
import slimeknights.tconstruct.library.materials.Material;

@Config(modid = Reference.MOD_ID)
public class TD_Config
{
	@Config.Comment("Enable Debug Features")
	public static boolean debug = false;
	// public boolean ArmorAddon;
	// public boolean transparency;
	// public boolean mossEnabled;
	// public boolean mossHard;

	@Config.Name("Shields")
	public static Shields	shields		= new Shields();
	@Config.Name("Tools")
	public static Tools		tools		= new Tools();
	@Config.Name("Materials")
	public static Materials	materials	= new Materials();
	@Config.Name("Addons")
	public static Addons	addons		= new Addons();

	public static class Shields
	{
		@Config.RequiresMcRestart()
		@Config.Comment("Enable Shields")
		public static boolean enableShields = true;

		@Config.RequiresMcRestart()
		public static boolean enableHeaterShield = true;

		@Config.RequiresMcRestart()
		public static boolean enableBuckler = true;

		@Config.Comment("How much damage should a shield block percentage wise if the material has no shield data built in?")
		public static int defaultShieldBlockPercentage = 33;
	}

	public static class Tools
	{
		@Config.RequiresMcRestart()
		public boolean enableZweihander = true;

		@Config.RequiresMcRestart()
		public boolean enableShears = true;

		@Config.RequiresMcRestart()
		public boolean enableFishingRod = true;
	}

	public static class Materials
	{
		@Config.RequiresMcRestart()
		public boolean enableCustomMaterials = true;

		@Config.RequiresMcRestart()
		public boolean enableBaseMaterials = true;

		@Config.RequiresMcRestart()
		public boolean enableJokeMaterials = true;

		@Config.RequiresMcRestart()
		public boolean enableHolidayMaterials = true;

		@Config.RequiresMcRestart()
		public boolean enableGemMaterials = true;

		@Config.RequiresMcRestart()
		public boolean enableBloodMagicMaterials = true;

		@Config.RequiresMcRestart()
		public boolean enableTwilightForestMaterials = true;

		@Config.RequiresMcRestart()
		public boolean enableHarvestCraftMaterials = true;

		@Config.RequiresMcRestart()
		public boolean enableCornucopiaMaterials = true;

		@Config.RequiresMcRestart()
		public String[] materialBlacklist = {

		};
		
		public boolean isBlacklisted(String s)
		{
			for(String str: materialBlacklist)
			{
				if(str.equals(s))
					return true;
			}
			return false;
		}
	}

	public static class Addons
	{

	}

	// public int SoulBoundID;
	// public int DazeID;
	// public int RainbowID;
	// public int XPBoostID;
	// public int ShearFortuneID;
	//
	// public int[] CrestFeathersID;
	// public int[] CrestMirrorsID;
	// public int[] CrestLegendsID;
	// public int[] CrestBladesID;
	// public int[] CrestGluttonyID;
	// public int[] CrestPitchID;
	// public int[] CrestThornsID;
	// public int[] CrestSanguisugaID;
	// public int[] CrestWindsID;
	// public int[] CrestRetributionID;
	// public int[] CrestLightID;
	//
	// //public int JokeInsultID;
	// //public int JokePyrotechID;
	// //public int JokeCompensateID;
	//
	// public int SoulSteveID;
	//
	// public int ArmorProtectionID;
	// public int ArmorFireProtectionID;
	// public int ArmorBlastProtectionID;
	// public int ArmorProjectileProtectionID;
	// public int ArmorFeatherfallID;
	// public int ArmorGlowstepID;
	// public int ArmorFrostwalkerID;
	// public int ArmorFirewalkerID;
	// public int ArmorDepthstriderID;
	// public int ArmorRebreatherID;
	// public int ArmorNightvisionID;
	// public int ArmorAntiBlindnessID;
	// public int ArmorPumpkinID;
	// public int ArmorDodgeID;
	// public int ArmorThornsID;
	// public int ArmorAbsorptionID;
	// public int ArmorJumpboostID;
	// public int ArmorSpeedID;
	// public int ArmorHighstepID;
	// public int ArmorKnockbackResistID;
	//
	// public boolean BotaniaAddon;
	// public int CorpseIvyModID;
	// public int ManaRepairModID;
	// public int TerraCoreModID;
	// public int ArmorPixieCoreModID;
	// public int ArmorManaDiscountModID;

	// public boolean ThaumcraftAddon;
	// public int RevealingModID;
	// public int VisDiscountModID;
	// public int CapsModID;
	// public int SpellbindModID;

	// public boolean BloodMagicAddon;
	// public int SuppingModID;
	// public int BloodOathModID;
	// public int ScabbingModID;
	// public int DivinationModID;

	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	private static class EventHandler
	{

		/**
		 * Inject the new values and save to the config file when the config has
		 * been changed from the GUI.
		 *
		 * @param event
		 *            The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event)
		{
			if (event.getModID().equals(Reference.MOD_ID))
			{
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}
}
