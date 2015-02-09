package gmail.Lance5057.gui;

import org.lwjgl.opengl.GL11;

import gmail.Lance5057.blocks.TileEntity_CrestMount;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class Gui_CrestMount extends GuiContainer {
	
	private ResourceLocation RL = new ResourceLocation("tinkersdefense", "textures/gui/inv_crestmount.png");
	
	public Gui_CrestMount(Container_CrestMount container) {
		super(container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		this.mc.renderEngine.bindTexture(RL);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
	}

}
