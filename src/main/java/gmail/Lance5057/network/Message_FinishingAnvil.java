package gmail.Lance5057.network;

import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class Message_FinishingAnvil implements IMessage
{
	ByteBufUtils bbu = new ByteBufUtils();
	
	public int x, y, z;
	public ItemStack item;
	
	public Message_FinishingAnvil()
	{
		
	}
	
	public Message_FinishingAnvil(int x, int y, int z, ItemStack item)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.item = item;
	}
	
	


	@Override
	public void fromBytes(ByteBuf buf) {
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		
		this.item = bbu.readItemStack(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		
		bbu.writeItemStack(buf, item);
	}

}