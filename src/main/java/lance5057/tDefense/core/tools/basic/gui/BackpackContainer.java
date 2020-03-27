package lance5057.tDefense.core.tools.basic.gui;

import javax.annotation.Nonnull;

import lance5057.tDefense.core.library.SlotLocked;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class BackpackContainer extends Container {

	public BackpackContainer(EntityPlayer player, BackpackInventory bag) {
		int i;
		int j;

		IInventory playerInv = player.inventory;
		
		for(i = 0; i < 3; ++i)
			for(j = 0; j < 9; ++j) {
				int k = j + i * 9;
				addSlotToContainer(new SlotItemHandler(bag, k, 8 + j * 18, 8 + i * 18));
			}

		for (i = 0; i < 3; ++i)
			for (j = 0; j < 9; ++j)
				addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));

		for (i = 0; i < 9; ++i) {
			if (playerInv.getStackInSlot(i) == bag.bag)
				addSlotToContainer(new SlotLocked(playerInv, i, 8 + i * 18, 142));
			else
				addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Nonnull
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(slotIndex);

		if(slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			int bagStart = 0;
			int bagEnd = bagStart + 27;
			int invEnd = bagEnd + 36;
			
			if(slotIndex < bagEnd) {
				if(!mergeItemStack(itemstack1, bagEnd, invEnd, true))
					return ItemStack.EMPTY;
			} else {
				if(!itemstack1.isEmpty() && !mergeItemStack(itemstack1, bagStart, bagEnd, false))
					return ItemStack.EMPTY;
			}

			if(itemstack1.isEmpty())
				slot.putStack(ItemStack.EMPTY);
			else slot.onSlotChanged();

			if(itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;

			slot.onTake(player, itemstack1);
		}

		return itemstack;
	}

}
