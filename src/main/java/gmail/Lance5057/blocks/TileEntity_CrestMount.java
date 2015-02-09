package gmail.Lance5057.blocks;

import java.util.Iterator;
import java.util.List;

import gmail.Lance5057.com.mod_TinkersDefense;
import gmail.Lance5057.proxy.Handler_CrestMount;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TileEntity_CrestMount extends TileEntity implements IInventory{

	private ItemStack[] inventory = new ItemStack[4];
	private String name = "Item";
	private int facing;
	private int numUsingPlayers;
	private int ticksSinceSync;
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
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
		return true;
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
	        ++this.ticksSinceSync;
	        float f;

	        if (!this.worldObj.isRemote && this.numUsingPlayers != 0 && (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0)
	        {
	            this.numUsingPlayers = 0;
	            f = 5.0F;
	            List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox((double)((float)this.xCoord - f), (double)((float)this.yCoord - f), (double)((float)this.zCoord - f), (double)((float)(this.xCoord + 1) + f), (double)((float)(this.yCoord + 1) + f), (double)((float)(this.zCoord + 1) + f)));
	            Iterator iterator = list.iterator();

	            while (iterator.hasNext())
	            {
	                EntityPlayer entityplayer = (EntityPlayer)iterator.next();

	                if (entityplayer.openContainer instanceof ContainerChest)
	                {
	                    IInventory iinventory = ((ContainerChest)entityplayer.openContainer).getLowerChestInventory();

	                    if (iinventory == this || iinventory instanceof InventoryLargeChest && ((InventoryLargeChest)iinventory).isPartOfLargeChest(this))
	                    {
	                        ++this.numUsingPlayers;
	                    }
	                }
	            }
	        }
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
