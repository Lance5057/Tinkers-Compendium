package lance5057.tDefense.core.tools.basic.gui;

import lance5057.tDefense.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import vazkii.botania.client.lib.LibResources;

public class BackpackGUI extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/test.png");
	
	public BackpackGUI(EntityPlayer player, BackpackInventory bag) {
		super(new BackpackContainer(player, bag));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
