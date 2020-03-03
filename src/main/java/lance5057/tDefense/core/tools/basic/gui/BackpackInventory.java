package lance5057.tDefense.core.tools.basic.gui;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

public class BackpackInventory implements IItemHandlerModifiable {

	private final IItemHandlerModifiable bagInventory;
	final ItemStack bag;

	public BackpackInventory(ItemStack box) {
		this.bag = box;
		bagInventory = (IItemHandlerModifiable) box.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
	}

	@Override
	public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
		bagInventory.setStackInSlot(slot, stack);
	}

	@Override
	public int getSlots() {
		return bagInventory.getSlots();
	}

	@Nonnull
	@Override
	public ItemStack getStackInSlot(int slot) {
		return bagInventory.getStackInSlot(slot);
	}

	@Nonnull
	@Override
	public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
		return bagInventory.insertItem(slot, stack, simulate);
	}

	@Nonnull
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		return bagInventory.extractItem(slot, amount, simulate);
	}

	@Override
	public int getSlotLimit(int slot) {
		return bagInventory.getSlotLimit(slot);
	}

}