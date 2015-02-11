package gmail.Lance5057.blocks;

import gmail.Lance5057.com.mod_TinkersDefense;
import gmail.Lance5057.gui.Container_CrestMount;
import gmail.Lance5057.proxy.Handler_CrestMount;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntity_CrestMount extends TileEntity implements IInventory{

	private ItemStack[] inventory = new ItemStack[4];
	private String name = "Item";
	private int facing;
	private int numUsingPlayers;
	private int ticksSinceSync;
	private boolean inventoryTouched;
	
	public TileEntity_CrestMount()
	{
		super();
	}
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}
	
	@Override
	public void markDirty()
	{
		super.markDirty();
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if(stack != null)
		{
		if(stack.stackSize > amount)
		{
		stack = stack.splitStack(amount);
		markDirty();
		}
		else
		{
		setInventorySlotContents(slot, null);
		}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if(stack != null)
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

		markDirty();
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
	public boolean isUseableByPlayer(EntityPlayer player) {
		 if (worldObj == null)
		 {
		 return true;
		 }
		 if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
		 {
		 return false;
		 }
		 return player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
	}

	@Override
	public void openInventory() {
		if (worldObj == null) return;
		numUsingPlayers++;
		worldObj.addBlockEvent(xCoord, yCoord, zCoord, mod_TinkersDefense.block_CrestMount, 1, numUsingPlayers);
	}

	@Override
	public void closeInventory() {
		if (worldObj == null) return;
		numUsingPlayers--;
		worldObj.addBlockEvent(xCoord, yCoord, zCoord, mod_TinkersDefense.block_CrestMount, 1, numUsingPlayers);
	}
	
	@Override
	public boolean receiveClientEvent(int p_145842_1_, int p_145842_2_)
    {
        if (p_145842_1_ == 1)
        {
            this.numUsingPlayers = p_145842_2_;
            return true;
        }
        else
        {
            return super.receiveClientEvent(p_145842_1_, p_145842_2_);
        }
    }

	@Override
	   public void updateEntity()
	    {
		super.updateEntity();
		// Resynchronize clients with the server state
		if (worldObj != null && !this.worldObj.isRemote && this.numUsingPlayers != 0 && (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0)
		{
		this.numUsingPlayers = 0;
		float var1 = 5.0F;
		@SuppressWarnings("unchecked")
		List<EntityPlayer> var2 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox((double)((float)this.xCoord - var1), (double)((float)this.yCoord - var1), (double)((float)this.zCoord - var1), (double)((float)(this.xCoord + 1) + var1), (double)((float)(this.yCoord + 1) + var1), (double)((float)(this.zCoord + 1) + var1)));
		Iterator<EntityPlayer> var3 = var2.iterator();
		while (var3.hasNext())
		{
		EntityPlayer var4 = var3.next();
		if (var4.openContainer instanceof Container_CrestMount)
		{
		++this.numUsingPlayers;
		}
		}
		}
		if (worldObj != null && !worldObj.isRemote && ticksSinceSync < 0)
		{
		worldObj.addBlockEvent(xCoord, yCoord, zCoord, mod_TinkersDefense.block_CrestMount, 3, ((numUsingPlayers << 3) & 0xF8));
		}
		if (!worldObj.isRemote && inventoryTouched)
		{
		inventoryTouched = false;
		}
		this.ticksSinceSync++;
		
		}
	
	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack itemstack) {
		return true;
	}

	public int getFacing()
	{
		return this.facing;
	}
	
	public void setFacing(int facing_o)
	{
		facing = facing_o;
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		return Handler_CrestMount.getPacket(this);
	}
	
	 public void handlePacketData(int[] intData)
	 {
	 TileEntity_CrestMount te = this;
	 if (intData != null)
	 {
	 int pos = 0;
	 for (int i = 0; i < te.inventory.length; i++)
	 {
	 if (intData[pos + 2] != 0)
	 {
	 Item it = Item.getItemById(intData[pos]);
	 ItemStack is = new ItemStack(it, intData[pos], intData[pos]);
	 te.inventory[i] = is;
	 }
	 else
	 {
	 te.inventory[i] = null;
	 }
	 pos += 3;
	 }
	 }
	 }
	
	 public void readFromNBT(NBTTagCompound p_145839_1_)
	    {
	        super.readFromNBT(p_145839_1_);
	        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
	        this.inventory = new ItemStack[this.getSizeInventory()];

	        if (p_145839_1_.hasKey("CustomName", 8))
	        {
	            this.name = p_145839_1_.getString("CustomName");
	        }

	        for (int i = 0; i < nbttaglist.tagCount(); ++i)
	        {
	            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	            int j = nbttagcompound1.getByte("Slot") & 255;

	            if (j >= 0 && j < this.inventory.length)
	            {
	                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	            }
	        }
	    }

	    public void writeToNBT(NBTTagCompound p_145841_1_)
	    {
	        super.writeToNBT(p_145841_1_);
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 0; i < this.inventory.length; ++i)
	        {
	            if (this.inventory[i] != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                this.inventory[i].writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }

	        p_145841_1_.setTag("Items", nbttaglist);

	        if (this.hasCustomInventoryName())
	        {
	            p_145841_1_.setString("CustomName", this.name);
	        }
	    }
}
