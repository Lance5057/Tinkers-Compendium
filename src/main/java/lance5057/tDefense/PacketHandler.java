
package lance5057.tDefense;

import lance5057.tDefense.core.blocks.crestMount.Handler_CrestMount;
import lance5057.tDefense.core.blocks.crestMount.Message_CrestMount;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler
{
	private static int	id	= 0;

	public static void init()
	{
		TinkersDefense.INSTANCE.registerMessage(Handler_CrestMount.class, Message_CrestMount.class, id++, Side.SERVER);
		//TinkersDefense.INSTANCE.registerMessage(Handler_FinishingAnvil.class, Message_FinishingAnvil.class, id++, Side.SERVER);

	}
}