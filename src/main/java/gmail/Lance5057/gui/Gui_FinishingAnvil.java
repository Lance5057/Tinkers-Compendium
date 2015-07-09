package gmail.Lance5057.gui;

import gmail.Lance5057.TinkersDefense;
import gmail.Lance5057.containers.Container_CrestMount;
import gmail.Lance5057.containers.Container_FinishingAnvil;
import gmail.Lance5057.network.Message_CrestMount;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import gmail.Lance5057.tileentities.TileEntity_FinishingAnvil;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class Gui_FinishingAnvil extends GuiContainer
{
	private float xSize_lo;
	private float ySize_lo;
	
	private final TileEntity_FinishingAnvil inventory;
	
	private static int buttonIndex = 0;
	
	private static final ResourceLocation iconLocation = new ResourceLocation("tinkersdefense", "textures/gui/finishinganvil.png");

	public Gui_FinishingAnvil(InventoryPlayer invPlayer, TileEntity_FinishingAnvil te)
	{
		super(new Container_FinishingAnvil(invPlayer, te));
		this.inventory = te;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		this.buttonList.add(new GuiButton(buttonIndex++ ,this.guiLeft+7, this.guiTop+13, 18, 18,""));
		this.buttonList.add(new GuiButton(buttonIndex++ ,this.guiLeft+183, this.guiTop+13, 33, 10,"Part"));
		this.buttonList.add(new GuiButton(buttonIndex++ ,this.guiLeft+215, this.guiTop+13, 33, 10,"Sets"));
		this.buttonList.add(new GuiButton(buttonIndex++ ,this.guiLeft+183, this.guiTop+33, 65, 10,"^"));
		this.buttonList.add(new GuiButton(buttonIndex++ ,this.guiLeft+183, this.guiTop+148, 65, 10,"v"));

		//((GuiButton)this.buttonList.get(0)).displayString = "9";
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
//		for(int i = 1; i<5; i++)
//		{
//			 if(button.id == i)
//			 {
//				 
//			 }
//		}
	}
	public void drawScreen(int par1, int par2, float par3)
	{
	super.drawScreen(par1, par2, par3);
	this.xSize_lo = (float)par1;
	this.ySize_lo = (float)par2;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		
	}

	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.getTextureManager().bindTexture(iconLocation);
	int k = ((this.width - this.xSize) / 2);
	int l = (this.height - this.ySize) / 2;
	this.drawTexturedModalRect(k, l, 0, 0, this.xSize+80, this.ySize);
	}
}
