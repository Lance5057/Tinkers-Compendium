package lance5057.tDefense.finishingAnvil.blocks.finishingAnvil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntity_FinishingAnvil extends TileEntity implements IInventory
{
	public static int		invSize	= 1;
	public ItemStack[]		inventory;

	private final String	name	= "Anvil Inventory";

	public TileEntity_FinishingAnvil()
	{
		super();
		inventory = new ItemStack[invSize];
	}

	@Override
	public void updateEntity()
	{
		super.updateEntity();
	}

	@Override
	public Packet getDescriptionPacket()
	{
		final NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.func_148857_g());
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

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		final ItemStack stack = getStackInSlot(slot);

		if(stack != null)
		{
			setInventorySlotContents(slot, stack);
		}
		return stack;
	}

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
	public String getInventoryName()
	{
		return name;
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return name.length() > 0;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
	{
		return true;
	}

	@Override
	public void openInventory()
	{

	}

	@Override
	public void closeInventory()
	{

	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
	{
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		writeInventoryToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
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
}
