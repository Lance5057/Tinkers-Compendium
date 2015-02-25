package gmail.Lance5057.gui;

import gmail.Lance5057.containers.Container_CrestMount;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class Gui_CrestMount extends GuiContainer
{
/** x and y size of the inventory window in pixels. Defined as float, passed as int
* These are used for drawing the player model. */
private float xSize_lo;
private float ySize_lo;

/** ResourceLocation takes 2 parameters: ModId, path to texture at the location:
* "src/minecraft/assets/modid/" */
private static final ResourceLocation iconLocation = new ResourceLocation("TileEntity_CrestMountmod", "textures/gui/TileEntity_CrestMount.png");

/** The inventory to render on screen */
private final TileEntity_CrestMount inventory;

public Gui_CrestMount(InventoryPlayer invPlayer, TileEntity_CrestMount te_crest)
{
super(new Container_CrestMount(invPlayer, te_crest));
this.inventory = te_crest;
}

/**
* Draws the screen and all the components in it.
*/
public void drawScreen(int par1, int par2, float par3)
{
super.drawScreen(par1, par2, par3);
this.xSize_lo = (float)par1;
this.ySize_lo = (float)par2;
}

/**
* Draw the foreground layer for the GuiContainer (everything in front of the items)
*/
protected void drawGuiContainerForegroundLayer(int par1, int par2)
{
	String s = inventory.hasCustomInventoryName() ? inventory.getInventoryName() : I18n.format(inventory.getInventoryName());
	this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 0, 4210752);
	this.fontRendererObj.drawString(I18n.format("container.inventory"), 26, this.ySize - 96 + 4, 4210752);
}

/**
* Draw the background layer for the GuiContainer (everything behind the items)
*/
protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
{
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
this.mc.getTextureManager().bindTexture(iconLocation);
int k = (this.width - this.xSize) / 2;
int l = (this.height - this.ySize) / 2;
this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
}
}