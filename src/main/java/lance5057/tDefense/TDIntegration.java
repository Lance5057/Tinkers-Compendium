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
		if(Loader.isModLoaded("battlegear2"))
		{
			mineAndBlade = true;
		}
		if(Loader.isModLoaded("Thaumcraft"))
		{
			thaumcraft = true;
		}
		if(Loader.isModLoaded("Botania"))
		{
			botania = true;
		}
		if(Loader.isModLoaded("bloodmagic"))
		{
			bloodMagic = true;
		}
	}
}
