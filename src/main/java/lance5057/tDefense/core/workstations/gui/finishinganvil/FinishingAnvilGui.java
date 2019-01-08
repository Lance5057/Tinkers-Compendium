package lance5057.tDefense.core.workstations.gui.finishinganvil;

import lance5057.tDefense.core.workstations.tileentities.FinishingAnvilTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.gui.GuiMultiModule;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.tools.common.client.module.GuiInfoPanel;
import slimeknights.tconstruct.tools.common.client.module.GuiSideButtons;

@SideOnly(Side.CLIENT)
public class FinishingAnvilGui extends GuiMultiModule {
	
	private static final ResourceLocation BACKGROUND = Util.getResource("textures/gui/toolstation.png");
	
	protected GuiSideButtons buttons;
	protected GuiInfoPanel toolInfo;

	public FinishingAnvilGui(InventoryPlayer playerInv, World world, BlockPos pos, FinishingAnvilTile tile) {
		super((FinishingAnvilContainer) tile.createContainer(playerInv, world, pos));
		// TODO Auto-generated constructor stub
		
		buttons = new GuiSideButtons(this, inventorySlots, 1);
	    this.addModule(buttons);
	    toolInfo = new GuiInfoPanel(this, inventorySlots);
	    this.addModule(toolInfo);
		
	    buttons.addSideButton(new GuiButton(0,0,0,32,32, "")); //TODO make custom sidebuttons module
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		//drawBackground(BACKGROUND);
		
		
		
		//super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		this.drawEntityOnScreen(this.guiLeft, this.guiTop, 20, this.guiLeft - mouseX, this.guiTop - mouseY, Minecraft.getMinecraft().player);
	}
	
	public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent)
    {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 50.0F);
        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        ent.renderYawOffset = (float)Math.atan((double)(mouseX / 40.0F)) * 20.0F;
        ent.rotationYaw = (float)Math.atan((double)(mouseX / 40.0F)) * 40.0F;
        ent.rotationPitch = -((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}