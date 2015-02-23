package gmail.Lance5057.containers;

import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class Container_CrestMount extends Container
{
	private static final int INV_START = TileEntity_CrestMount.invSize, INV_END = INV_START+26,
			HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;
	
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return false;
	}

}
