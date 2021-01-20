package lance5057.tDefense.core.workstations.gui.armorstation;

import lance5057.tDefense.core.workstations.gui.armorstation.ArmorStationContainer;
import c4.conarm.client.gui.PreviewPlayer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLiving;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import slimeknights.mantle.client.gui.GuiMultiModule;
import slimeknights.tconstruct.tools.common.client.module.GuiInfoPanel;

public class ArmorStationPreviewPanel extends GuiInfoPanel {

    ArmorStationContainer container;
    public float oldMouseX;
    public float oldMouseY;
    PreviewPlayer previewPlayer;

    public ArmorStationPreviewPanel(GuiMultiModule parent, Container container, int xSize, int ySize, PreviewPlayer previewPlayer) {
        super(parent, container);
        this.container = (ArmorStationContainer) container;
        this.xSize = xSize;
        this.ySize = ySize;
        this.previewPlayer = previewPlayer;
        this.previewPlayer.chasingPosX = this.previewPlayer.posX;
        this.previewPlayer.chasingPosY = this.previewPlayer.posY;
        this.previewPlayer.chasingPosZ = this.previewPlayer.posZ;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        int i = this.guiLeft;
        int j = this.guiTop;
        this.previewPlayer.onUpdate();
        GuiInventory.drawEntityOnScreen(i + 53, j + 135, 60, (float)(i + 50) - this.oldMouseX, (float)(j + 30) - this.oldMouseY, this.previewPlayer);
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    }

    public void givePreviewStack(ItemStack stack) {
        previewPlayer.setItemStackToSlot(EntityLiving.getSlotForItemStack(stack), stack.copy());
    }

    public void resetPreview() {
        previewPlayer.inventory.clear();
    }
}
