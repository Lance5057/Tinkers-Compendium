package lance5057.tDefense.core.tools.basic.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class BackpackGUI extends GuiContainer {

	public BackpackGUI(EntityPlayer player, BackpackInventory bag) {
		super(new BackpackContainer(player, bag));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
	}

}
