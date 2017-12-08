package lance5057.tDefense.core.tools.armor.straps;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class ItemStrapsInv extends ItemStackHandler
{

	private ItemStack		invItem	= ItemStack.EMPTY;
	public static final int	INVSIZE	= 1;
	private final String	name	= "ArmorHolder";

	private final ItemStackHandler inventory;

	public ItemStrapsInv(ItemStack stack)
	{
		invItem = stack;
		inventory = (ItemStackHandler) invItem.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
	}

	@Override
	public void setStackInSlot(int slot, @Nonnull ItemStack stack)
	{
		inventory.setStackInSlot(slot, stack);
	}

	@Override
	public int getSlots()
	{
		return inventory.getSlots();
	}

	@Nonnull
	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return inventory.getStackInSlot(slot);
	}

	@Nonnull
	@Override
	public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
	{
		return inventory.insertItem(slot, stack, simulate);
	}

	@Nonnull
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate)
	{
		return inventory.extractItem(slot, amount, simulate);
	}

	@Override
	public int getSlotLimit(int slot)
	{
		return inventory.getSlotLimit(slot);
	}
}
