package gmail.Lance5057.proxy;

import gmail.Lance5057.blocks.TileEntity_CrestMount;
import gmail.Lance5057.com.mod_TinkersDefense;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.EnumMap;

import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
* Handles the packet wrangling for CrestMount
* @author cpw
*
*/
public enum Handler_CrestMount {
INSTANCE;
/**
* Our channel "pair" from {@link NetworkRegistry}
*/
private EnumMap<Side, FMLEmbeddedChannel> channels;
/**
* Make our packet handler, and add an {@link CrestMountCodec} always
*/
private Handler_CrestMount()
{
this.channels = NetworkRegistry.INSTANCE.newChannel("tDefense", new CrestMountCodec());
	if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
	{
		addClientHandler();
	}
}


@SideOnly(Side.CLIENT)
private void addClientHandler() {
FMLEmbeddedChannel clientChannel = this.channels.get(Side.CLIENT);

String codec = clientChannel.findChannelHandlerNameForType(CrestMountCodec.class);
clientChannel.pipeline().addAfter(codec, "ClientHandler", new Message_CrestMountHandler());
}

private static class Message_CrestMountHandler extends SimpleChannelInboundHandler<Message_CrestMount>
{
@Override
protected void channelRead0(ChannelHandlerContext ctx, Message_CrestMount msg) throws Exception
{
	World world = mod_TinkersDefense.proxy.getClientWorld();
	TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
//	if (te instanceof TileEntity_CrestMount)
//		{
//			((TileEntity_CrestMount) te).handlePacketData(msg.type, msg.items);
//		}
	}
}
/**
* This is our "message". In fact, {@link FMLIndexedMessageToMessageCodec}
* can handle many messages on the same channel at once, using a
* discriminator byte. But for CrestMount, we only need the one message, so
* we have just this.
*
* @author cpw
*
*/
public static class Message_CrestMount
{
int x;
int y;
int z;
int[] items;
}
/**
* This is the codec that automatically transforms the
* {@link FMLProxyPacket} which wraps the client and server custom payload
* packets into a message we care about.
*
* @author cpw
*
*/
private class CrestMountCodec extends FMLIndexedMessageToMessageCodec<Message_CrestMount>
{
/**
* We register our discriminator bytes here. We only have the one type, so we only
* register one.
*/
public CrestMountCodec()
{
addDiscriminator(0, Message_CrestMount.class);
}
@Override
public void encodeInto(ChannelHandlerContext ctx, Message_CrestMount msg, ByteBuf target) throws Exception
{
target.writeInt(msg.x);
target.writeInt(msg.y);
target.writeInt(msg.z);
target.writeBoolean(msg.items != null);
if (msg.items != null)
{
int[] items = msg.items;
for (int j = 0; j < items.length; j++)
{
int i = items[j];
target.writeInt(i);
}
}
}
@Override
public void decodeInto(ChannelHandlerContext ctx, ByteBuf dat, Message_CrestMount msg)
{
msg.x = dat.readInt();
msg.y = dat.readInt();
msg.z = dat.readInt();
boolean hasStacks = dat.readBoolean();
msg.items = new int[0];
if (hasStacks)
{
msg.items = new int[4];
for (int i = 0; i < msg.items.length; i++)
{
msg.items[i] = dat.readInt();
}
}
}
}
/**
* This is a utility method called to transform a packet from a custom
* packet into a "system packet". We're called from
* {@link TileEntity#getDescriptionPacket()} in this case, but there are
* others. All network packet methods in minecraft have been adapted to
* handle {@link FMLProxyPacket} but general purpose objects can't be
* handled sadly.
*
* This method uses the {@link CrestMountCodec} to transform a custom packet
* {@link Message_CrestMount} into an {@link FMLProxyPacket} by using the
* utility method {@link FMLEmbeddedChannel#generatePacketFrom(Object)} on
* the channel to do exactly that.
*
* @param tileEntityCrestMount
* @return
*/
	public static Packet getPacket(TileEntity_CrestMount te)
	{
		Message_CrestMount msg = new Message_CrestMount();
		msg.x = te.xCoord;
		msg.y = te.yCoord;
		msg.z = te.zCoord;
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg);
	}
}
