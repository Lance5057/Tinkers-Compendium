package lance5057.tDefense.core.blocks.crestMount;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Container_CrestMount extends Container
{

	public Container_CrestMount(InventoryPlayer inventoryPlayer, TileEntity_CrestMount te)
	{
		addSlotToContainer(new Slot(te, 0, 62, 28));
		addSlotToContainer(new Slot(te, 1, 98, 28));
		addSlotToContainer(new Slot(te, 2, 80, 28));
		addSlotToContainer(new Slot(te, 3, 80, 46));

		for(int x = 0; x < 9; x++)
		{
			addSlotToContainer(new Slot(inventoryPlayer, x, 8 + 18 * x, 142));
		}

		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9,
						8 + 18 * x, 84 + y * 18));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{

		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		return null;
	}
}
