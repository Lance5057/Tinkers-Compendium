package lance5057.tDefense.core.network;

import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.TileEntity_FinishingAnvil;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class Handler_FinishingAnvil implements IMessageHandler<Message_FinishingAnvil, IMessage>
{
	@Override
	public IMessage onMessage(Message_FinishingAnvil message, MessageContext ctx)
	{
		TileEntity te = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
		if(te instanceof TileEntity_FinishingAnvil)
		{
			//((TileEntity_FinishingAnvil) te).flip = message.flip;
			((TileEntity_FinishingAnvil) te).inventory[0] = message.item;
		}
		return null;
	}
}
