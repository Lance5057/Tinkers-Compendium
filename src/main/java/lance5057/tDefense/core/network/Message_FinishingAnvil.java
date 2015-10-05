package lance5057.tDefense.core.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

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