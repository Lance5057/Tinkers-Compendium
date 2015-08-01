package gmail.Lance5057.containers;

import gmail.Lance5057.tileentities.TileEntity_FinishingAnvil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Container_FinishingAnvil extends Container
{
	public Container_FinishingAnvil(InventoryPlayer inventoryPlayer, TileEntity_FinishingAnvil te)
	{
		addSlotToContainer(new Slot(te, 0, 48, 32));
		
		for (int x = 0; x < 9; x++)
		{
			addSlotToContainer(new Slot(inventoryPlayer, x, 8 + 18 * x, 142));
		}
		
			for (int y = 0; y < 3; y++) 
			{
				for (int x = 0; x < 9; x++) 
				{
					addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
				}
			}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) 
	{
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		return null;
	}
}
