package lance5057.tDefense.core.network;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class Message_CrestMount implements IMessage
{
	public int			x, y, z;
	public boolean[]	flip	= new boolean[4];

	public Message_CrestMount()
	{

	}

	public Message_CrestMount(int x, int y, int z, boolean[] flip)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.flip = flip;
		//System.arraycopy(flip, 0, this.flip, 0, flip.length);

	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		for(int i = 0; i < flip.length; i++)
		{
			this.flip[i] = buf.readBoolean();
		}
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		for(int i = 0; i < flip.length; i++)
		{
			buf.writeBoolean(flip[i]);
		}
	}

}
