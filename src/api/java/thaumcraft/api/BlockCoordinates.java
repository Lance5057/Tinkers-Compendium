package thaumcraft.api;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class BlockCoordinates implements Comparable
{
	public int	x;

	/** the y coordinate */
	public int	y;

	/** the z coordinate */
	public int	z;

	public BlockCoordinates()
	{
	}

	public BlockCoordinates(int par1, int par2, int par3)
	{
		x = par1;
		y = par2;
		z = par3;
	}

	public BlockCoordinates(TileEntity tile)
	{
		x = tile.xCoord;
		y = tile.yCoord;
		z = tile.zCoord;
	}

	public BlockCoordinates(BlockCoordinates par1ChunkCoordinates)
	{
		x = par1ChunkCoordinates.x;
		y = par1ChunkCoordinates.y;
		z = par1ChunkCoordinates.z;
	}

	@Override
	public boolean equals(Object par1Obj)
	{
		if(!(par1Obj instanceof BlockCoordinates))
		{
			return false;
		}
		else
		{
			final BlockCoordinates coordinates = (BlockCoordinates) par1Obj;
			return x == coordinates.x && y == coordinates.y && z == coordinates.z;
		}
	}

	@Override
	public int hashCode()
	{
		return x + y << 8 + z << 16;
	}

	/**
	 * Compare the coordinate with another coordinate
	 */
	public int compareWorldCoordinate(BlockCoordinates par1)
	{
		return y == par1.y ? (z == par1.z ? x - par1.x : z - par1.z) : y - par1.y;
	}

	public void set(int par1, int par2, int par3, int d)
	{
		x = par1;
		y = par2;
		z = par3;
	}

	/**
	 * Returns the squared distance between this coordinates and the coordinates given as argument.
	 */
	public float getDistanceSquared(int par1, int par2, int par3)
	{
		final float f = x - par1;
		final float f1 = y - par2;
		final float f2 = z - par3;
		return f * f + f1 * f1 + f2 * f2;
	}

	/**
	 * Return the squared distance between this coordinates and the ChunkCoordinates given as argument.
	 */
	public float getDistanceSquaredToWorldCoordinates(BlockCoordinates par1ChunkCoordinates)
	{
		return getDistanceSquared(par1ChunkCoordinates.x, par1ChunkCoordinates.y, par1ChunkCoordinates.z);
	}

	@Override
	public int compareTo(Object par1Obj)
	{
		return compareWorldCoordinate((BlockCoordinates) par1Obj);
	}

	public void readNBT(NBTTagCompound nbt)
	{
		x = nbt.getInteger("b_x");
		y = nbt.getInteger("b_y");
		z = nbt.getInteger("b_z");
	}

	public void writeNBT(NBTTagCompound nbt)
	{
		nbt.setInteger("b_x", x);
		nbt.setInteger("b_y", y);
		nbt.setInteger("b_z", z);
	}

}
