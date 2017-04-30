package lance5057.tDefense.core.blocks.crestMount;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class Message_CrestMount implements IMessage
{
	public BlockPos			pos;
	public boolean[]	flip	= new boolean[4];

	public Message_CrestMount()
	{

	}

	public Message_CrestMount(BlockPos			pos, boolean[] flip)
	{
		this.pos = pos;
		this.flip = flip;
		//System.arraycopy(flip, 0, this.flip, 0, flip.length);

	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());

		for(int i = 0; i < flip.length; i++)
		{
			flip[i] = buf.readBoolean();
		}
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
		for(final boolean element : flip)
		{
			buf.writeBoolean(element);
		}
	}

}