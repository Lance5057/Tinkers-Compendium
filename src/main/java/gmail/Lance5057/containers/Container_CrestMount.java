package gmail.Lance5057.containers;

import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Container_CrestMount extends Container
{
	private static final int INV_START = TileEntity_CrestMount.invSize, INV_END = INV_START+26,
			HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;
	
	public final TileEntity_CrestMount inventory;
	
	public Container_CrestMount(EntityPlayer par1Player, InventoryPlayer inventoryPlayer, TileEntity_CrestMount TileEntity_CrestMount)
	{
	this.inventory = TileEntity_CrestMount;

	int i;

	// ITEM INVENTORY - you'll need to adjust the slot locations to match your texture file
	// I have them set vertically in columns of 4 to the right of the player model
	for (i = 0; i < TileEntity_CrestMount.invSize; ++i)
	{
	// You can make a custom Slot if you need different behavior,
	// such as only certain item types can be put into this slot
	// We made a custom slot to prevent our inventory-storing item
	// from being stored within itself, but if you want to allow that and
	// you followed my advice at the end of the above step, then you
	// could get away with using the vanilla Slot class
	this.addSlotToContainer(new Slot(this.inventory, i, 80 + (18 * (int)(i/4)), 8 + (18*(i%4))));
	}

	// If you want, you can add ARMOR SLOTS here as well, but you need to
	// make a public version of SlotArmor. I won't be doing that in this tutorial.
	/*
	for (i = 0; i < 4; ++i)
	{
	// These are the standard positions for survival inventory layout
	this.addSlotToContainer(new SlotArmor(this.player, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - i, 8, 8 + i * 18, i));
	}
	*/

	// PLAYER INVENTORY - uses default locations for standard inventory texture file
	for (i = 0; i < 3; ++i)
	{
	for (int j = 0; j < 9; ++j)
	{
	this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	}
	}

	// PLAYER ACTION BAR - uses default locations for standard action bar texture file
	for (i = 0; i < 9; ++i)
	{
	this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
	}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
	// be sure to return the inventory's isUseableByPlayer method
	// if you defined special behavior there:
	return inventory.isUseableByPlayer(player);
	}

	/**
	* Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	* Only real change we make to this is to set needsUpdate to true at the end
	*/
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
	ItemStack itemstack = null;
	Slot slot = (Slot) this.inventorySlots.get(par2);

	if (slot != null && slot.getHasStack())
	{
	ItemStack itemstack1 = slot.getStack();
	itemstack = itemstack1.copy();

	// If item is in our custom Inventory or armor slot
	if (par2 < INV_START)
	{
	// try to place in player inventory / action bar
	if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true))
	{
	return null;
	}

	slot.onSlotChange(itemstack1, itemstack);
	}
	// Item is in inventory / hotbar, try to place in custom inventory or armor slots
	else
	{
	/* If your inventory only stores certain instances of Items,
	* you can implement shift-clicking to your inventory like this:
	// Check that the item is the right type
	if (itemstack1.getItem() instanceof ItemCustom)
	{
	// Try to merge into your custom inventory slots
	// We use 'InventoryItem.INV_SIZE' instead of INV_START just in case
	// you also add armor or other custom slots
	if (!this.mergeItemStack(itemstack1, 0, InventoryItem.INV_SIZE, false))
	{
	return null;
	}
	}
	// If you added armor slots, check them here as well:
	// Item being shift-clicked is armor - try to put in armor slot
	if (itemstack1.getItem() instanceof ItemArmor)
	{
	int type = ((ItemArmor) itemstack1.getItem()).armorType;
	if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type + 1, false))
	{
	return null;
	}
	}
	* Otherwise, you have basically 2 choices:
	* 1. shift-clicking between action bar and inventory
	* 2. shift-clicking between player inventory and custom inventory
	* I've implemented number 1:
	*/
	// item is in player's inventory, but not in action bar
	if (par2 >= INV_START && par2 < HOTBAR_START)
	{
	// place in action bar
	if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_END + 1, false))
	{
	return null;
	}
	}
	// item in action bar - place in player inventory
	else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1)
	{
	if (!this.mergeItemStack(itemstack1, INV_START, INV_END + 1, false))
	{
	return null;
	}
	}
	}

	if (itemstack1.stackSize == 0)
	{
	slot.putStack((ItemStack) null);
	}
	else
	{
	slot.onSlotChanged();
	}

	if (itemstack1.stackSize == itemstack.stackSize)
	{
	return null;
	}

	slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	}

	return itemstack;
	}
}

