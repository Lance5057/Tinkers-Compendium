package ic2.api.event;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.Cancelable;

@Cancelable
public class RetextureEvent extends WorldEvent
{
	// target block
	public final int	x;
	public final int	y;
	public final int	z;
	public final int	side;

	// referenced block (to grab the texture from)
	public final Block	referencedBlock;
	public final int	referencedMeta;
	public final int	referencedSide;

	// set to true to confirm the operation
	public boolean		applied	= false;

	public RetextureEvent(World world1, int x1, int y1, int z1, int side1, Block referencedBlock, int referencedMeta1, int referencedSide1)
	{
		super(world1);

		x = x1;
		y = y1;
		z = z1;
		side = side1;
		this.referencedBlock = referencedBlock;
		referencedMeta = referencedMeta1;
		referencedSide = referencedSide1;
	}
}
