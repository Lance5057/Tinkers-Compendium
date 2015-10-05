package lance5057.tDefense.core.network;

import lance5057.tDefense.TinkersDefense;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {
	private static int id = 0;
	
	public static void init()
	{
	TinkersDefense.INSTANCE.registerMessage(Handler_CrestMount.class, Message_CrestMount.class,id++,Side.SERVER);
	TinkersDefense.INSTANCE.registerMessage(Handler_FinishingAnvil.class, Message_FinishingAnvil.class,id++,Side.SERVER);

	}
}
