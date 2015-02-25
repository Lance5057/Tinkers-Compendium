package gmail.Lance5057.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import gmail.Lance5057.com.mod_TinkersDefense;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class Message_CrestMount implements IMessage
{	
	private int id;
	
	Message_CrestMount() {}
	
	Message_CrestMount(int id)
	{
		this.id = id;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		id = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
	}
	
	public static class Handler implements IMessageHandler<Message_CrestMount, IMessage> 
	{
	@Override
	public IMessage onMessage(Message_CrestMount message, MessageContext ctx)
	{
		EntityPlayer player = mod_TinkersDefense.proxy.getPlayerEntity(ctx);
		player.openGui(mod_TinkersDefense.instance, message.id, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
		return null;
	}
}
}
