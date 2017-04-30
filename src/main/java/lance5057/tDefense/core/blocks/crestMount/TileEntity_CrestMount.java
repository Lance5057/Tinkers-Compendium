package lance5057.tDefense.core.blocks.crestMount;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntity_CrestMount extends TileEntity implements IInventory
{
	public static int		invSize	= 4;
	public ItemStack[]		inventory;
	public boolean[]		flip;

	private final String	name	= "Crest Inventory";

	public TileEntity_CrestMount()
	{
		super();
		inventory = new ItemStack[invSize];
		flip = new boolean[4];
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		final NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new SPacketUpdateTileEntity(getPos(), 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
	{
		readFromNBT(packet.getNbtCompound());
	}

	@Override
	public int getSizeInventory()
	{
		return invSize;
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount)
	{
		ItemStack stack = getStackInSlot(slot);
		if(stack != null)
		{
			if(stack.stackSize > amount)
			{
				stack = stack.splitStack(amount);

				if(stack.stackSize == 0)
				{
					setInventorySlotContents(slot, null);
				}
			}
			else
			{
				setInventorySlotContents(slot, null);
			}

			markDirty();
		}
		return stack;
		
	}

//	@Override
//	public ItemStack getStackInSlotOnClosing(int slot)
//	{
//		final ItemStack stack = getStackInSlot(slot);
//
//		if(stack != null)
//		{
//			setInventorySlotContents(slot, stack);
//		}
//		return stack;
//	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		inventory[slot] = itemstack;

		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
		{
			itemstack.stackSize = getInventoryStackLimit();
		}

		markDirty();
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public boolean hasCustomName()
	{
		return name.length() > 0;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 1;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player)
	{

	}

	@Override
	public void closeInventory(EntityPlayer player)
	{

	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
	{
		return true;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		if(flip != null)
		{
			compound.setBoolean("flip_1", flip[0]);
			compound.setBoolean("flip_2", flip[1]);
			compound.setBoolean("flip_3", flip[2]);
			compound.setBoolean("flip_4", flip[3]);
		}

		writeInventoryToNBT(compound);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		flip[0] = compound.getBoolean("flip_1");
		flip[1] = compound.getBoolean("flip_2");
		flip[2] = compound.getBoolean("flip_3");
		flip[3] = compound.getBoolean("flip_4");

		readInventoryFromNBT(compound);
	}

	public void readInventoryFromNBT(NBTTagCompound tags)
	{
		final NBTTagList nbttaglist = tags.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		for(int iter = 0; iter < nbttaglist.tagCount(); iter++)
		{
			final NBTTagCompound tagList = nbttaglist.getCompoundTagAt(iter);
			final byte slotID = tagList.getByte("Slot");
			if(slotID >= 0 && slotID < inventory.length)
			{
				inventory[slotID] = ItemStack.loadItemStackFromNBT(tagList);
			}
		}
	}

	public void writeInventoryToNBT(NBTTagCompound tags)
	{
		final NBTTagList nbttaglist = new NBTTagList();
		for(int iter = 0; iter < inventory.length; iter++)
		{
			if(inventory[iter] != null)
			{
				final NBTTagCompound tagList = new NBTTagCompound();
				tagList.setByte("Slot", (byte) iter);
				inventory[iter].writeToNBT(tagList);
				nbttaglist.appendTag(tagList);
			}
		}

		tags.setTag("Items", nbttaglist);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return this.getStackInSlot(index);
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
