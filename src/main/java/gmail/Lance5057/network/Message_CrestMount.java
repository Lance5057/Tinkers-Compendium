package gmail.Lance5057.network;

import net.minecraft.item.Item;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class Message_CrestMount implements IMessage
{
	public int x,y,z;
	public int[] inv;
	
	Message_CrestMount() {}
	
	Message_CrestMount(TileEntity_CrestMount te)
	{
		this.x = te.xCoord;
		this.y = te.yCoord;
		this.z = te.zCoord;
		
		inv = new int[te.invSize*3];
		for(int i = 0; i<te.invSize; i+=3)
		{
			if(te.inventory[i]!=null)
			{
				inv[i] = Item.getIdFromItem(te.inventory[i].getItem());
				inv[i+1] = te.inventory[i].getItemDamage();
				inv[i+2] = te.inventory[i].stackSize;
			}
		}
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		
		for(int i = 0; i<inv.length; i++)
		{
			inv[i] = buf.readInt();
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		
		for(int i = 0; i<inv.length; i++)
		{
			buf.writeInt(inv[i]);
		}
	}

}
