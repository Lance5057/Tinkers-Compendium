package gmail.Lance5057.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntity_CrestMount extends TileEntity implements IInventory
{
	public static int invSize = 4;
	public ItemStack[] inventory = new ItemStack[invSize];
	
	
	private final String name = "Crest Inventory";
	private final String tagName = "Crest InvTag";
	
	@Override
	public int getSizeInventory() {
		return invSize;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null)
		{
			if (stack.stackSize > amount)
			{
				stack = stack.splitStack(amount);
				
				if (stack.stackSize == 0)
				{
					setInventorySlotContents(slot, null);
				}
			}
			else
			{
				setInventorySlotContents(slot, null);
			}
	
			this.markDirty();
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		
		if (stack != null)
		{
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		this.inventory[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
		{
		itemstack.stackSize = this.getInventoryStackLimit();
		}

		this.markDirty();		
	}

	@Override
	public String getInventoryName() {
		return name;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return name.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return true;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}
	

	public void writeToNBT(NBTTagCompound compound)
	{
		NBTTagList items = new NBTTagList();

		for (int i = 0; i < getSizeInventory(); ++i)
		{
			if (getStackInSlot(i) != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}

		// We're storing our items in a custom tag list using our 'tagName' from above
		// to prevent potential conflicts
		compound.setTag(tagName, items);
	}
	
	 public void readFromNBT(NBTTagCompound compound) 
	 {
			// now you must include the NBTBase type ID when getting the list; NBTTagCompound's ID is 10
			NBTTagList items = compound.getTagList(tagName, compound.getId());
			for (int i = 0; i < items.tagCount(); ++i) 
			{
				// tagAt(int) has changed to getCompoundTagAt(int)
				NBTTagCompound item = items.getCompoundTagAt(i);
				byte slot = item.getByte("Slot");
				
				if (slot >= 0 && slot < getSizeInventory()) 
				{
					inventory[slot] = ItemStack.loadItemStackFromNBT(item);
				}
			}
		}
}
