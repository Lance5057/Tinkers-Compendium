package gmail.Lance5057.gui;

import gmail.Lance5057.containers.Container_CrestMount;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
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
private static final ResourceLocation iconLocation = new ResourceLocation("tinkersdefense", "textures/gui/crest_mount.png");

/** The inventory to render on screen */
private final TileEntity_CrestMount inventory;

public Gui_CrestMount(InventoryPlayer invPlayer, TileEntity_CrestMount te_crest)
{
super(new Container_CrestMount(invPlayer, te_crest));
this.inventory = te_crest;


}

@Override
public void initGui()
{
	super.initGui();
	//ScaledResolution resolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
	this.buttonList.add(new GuiButton(1,this.guiLeft + 61, this.guiTop + 10, 16, 16,"Flip"));
	this.buttonList.add(new GuiButton(2,this.guiLeft + 16, this.guiTop + 16, 16, 16,"Flip"));
	this.buttonList.add(new GuiButton(3,this.guiLeft + 16, this.guiTop + 32, 16, 16,"Flip"));
	this.buttonList.add(new GuiButton(4,this.guiLeft + 16, this.guiTop + 48, 16, 16,"Flip"));
}

@Override
protected void actionPerformed(GuiButton button)
{
	for(int i = 1; i<5; i++)
	{
	 if(button.id == i)
	 {
		 if(inventory.flip[i-1]==false)
			 inventory.flip[i-1]=true;
		 else
			 inventory.flip[i-1]=false;
	 }
	}
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