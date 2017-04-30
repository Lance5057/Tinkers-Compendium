package lance5057.tDefense.core.blocks.crestMount;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class Handler_CrestMount implements IMessageHandler<Message_CrestMount, IMessage>
{
	@Override
	public IMessage onMessage(Message_CrestMount message, MessageContext ctx)
	{
		final TileEntity te = ctx.getServerHandler().playerEntity.world.getTileEntity(message.pos);
		if(te instanceof TileEntity_CrestMount)
		{
			((TileEntity_CrestMount) te).flip = message.flip;
		}
		return null;
	}
}