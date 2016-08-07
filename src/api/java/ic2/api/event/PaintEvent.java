package ic2.api.event;

import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.Cancelable;

@Cancelable
public class PaintEvent extends WorldEvent
{
	// target block
	public final int	x;
	public final int	y;
	public final int	z;
	public final int	side;

	// color to paint the block
	public final int	color;

	// set to true to confirm the operation
	public boolean		painted	= false;

	public PaintEvent(World world1, int x1, int y1, int z1, int side1, int color1)
	{
		super(world1);

		x = x1;
		y = y1;
		z = z1;
		side = side1;
		color = color1;
	}
}
