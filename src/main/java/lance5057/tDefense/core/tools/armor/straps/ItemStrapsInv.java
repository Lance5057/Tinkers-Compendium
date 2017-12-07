package lance5057.tDefense.core.tools.armor.straps;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
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
}
