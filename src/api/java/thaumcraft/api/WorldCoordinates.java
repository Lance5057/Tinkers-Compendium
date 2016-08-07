package thaumcraft.api;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class WorldCoordinates implements Comparable
{
	public int	x;

	/** the y coordinate */
	public int	y;

	/** the z coordinate */
	public int	z;

	public int	dim;

	public WorldCoordinates()
	{
	}

	public WorldCoordinates(int par1, int par2, int par3, int d)
	{
		x = par1;
		y = par2;
		z = par3;
		dim = d;
	}

	public WorldCoordinates(TileEntity tile)
	{
		x = tile.xCoord;
		y = tile.yCoord;
		z = tile.zCoord;
		dim = tile.getWorldObj().provider.dimensionId;
	}

	public WorldCoordinates(WorldCoordinates par1ChunkCoordinates)
	{
		x = par1ChunkCoordinates.x;
		y = par1ChunkCoordinates.y;
		z = par1ChunkCoordinates.z;
		dim = par1ChunkCoordinates.dim;
	}

	@Override
	public boolean equals(Object par1Obj)
	{
		if(!(par1Obj instanceof WorldCoordinates))
		{
			return false;
		}
		else
		{
			final WorldCoordinates coordinates = (WorldCoordinates) par1Obj;
			return x == coordinates.x && y == coordinates.y && z == coordinates.z && dim == coordinates.dim;
		}
	}

	@Override
	public int hashCode()
	{
		return x + y << 8 + z << 16 + dim << 24;
	}

	/**
	 * Compare the coordinate with another coordinate
	 */
	public int compareWorldCoordinate(WorldCoordinates par1)
	{
		return dim == par1.dim ? (y == par1.y ? (z == par1.z ? x - par1.x : z - par1.z) : y - par1.y) : -1;
	}

	public void set(int par1, int par2, int par3, int d)
	{
		x = par1;
		y = par2;
		z = par3;
		dim = d;
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
	public float getDistanceSquaredToWorldCoordinates(WorldCoordinates par1ChunkCoordinates)
	{
		return getDistanceSquared(par1ChunkCoordinates.x, par1ChunkCoordinates.y, par1ChunkCoordinates.z);
	}

	@Override
	public int compareTo(Object par1Obj)
	{
		return compareWorldCoordinate((WorldCoordinates) par1Obj);
	}

	public void readNBT(NBTTagCompound nbt)
	{
		x = nbt.getInteger("w_x");
		y = nbt.getInteger("w_y");
		z = nbt.getInteger("w_z");
		dim = nbt.getInteger("w_d");
	}

	public void writeNBT(NBTTagCompound nbt)
	{
		nbt.setInteger("w_x", x);
		nbt.setInteger("w_y", y);
		nbt.setInteger("w_z", z);
		nbt.setInteger("w_d", dim);
	}

}
