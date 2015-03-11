package gmail.Lance5057.network;

import gmail.Lance5057.com.mod_TinkersDefense;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {
	private static int id = 0;
	
	public static void init()
	{
	mod_TinkersDefense.INSTANCE.registerMessage(Handler_CrestMount.class, Message_CrestMount.class,id++,Side.SERVER);

	}
}
