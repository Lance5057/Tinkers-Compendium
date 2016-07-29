package lance5057.tDefense;

import cpw.mods.fml.common.Loader;

public final class TDIntegration
{
	public static boolean	mineAndBlade	= false;
	public static boolean	thaumcraft		= false;
	public static boolean	botania			= false;
	public static boolean	bloodMagic		= false;

	public static void Integrate()
	{
		if(Loader.isModLoaded("battlegear2") && TinkersDefense.config.MineAndBladeAddon)
		{
			mineAndBlade = true;
		}
		if(Loader.isModLoaded("Thaumcraft") && TinkersDefense.config.ThaumcraftAddon)
		{
			thaumcraft = true;
		}
		if(Loader.isModLoaded("Botania") && TinkersDefense.config.BotaniaAddon)
		{
			botania = true;
		}
		if(Loader.isModLoaded("AWWayofTime") && TinkersDefense.config.BloodMagicAddon)
		{
			bloodMagic = true;
		}
	}
}
