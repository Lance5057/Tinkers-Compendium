package gmail.Lance5057.gui;

import gmail.Lance5057.TinkersDefense;
import gmail.Lance5057.containers.Container_CrestMount;
import gmail.Lance5057.containers.Container_FinishingAnvil;
import gmail.Lance5057.network.Message_CrestMount;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import gmail.Lance5057.tileentities.TileEntity_FinishingAnvil;

import org.lwjgl.opengl.GL11;

import tconstruct.library.tools.ToolCore;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Gui_FinishingAnvil extends GuiContainer
{
	private float xSize_lo;
	private float ySize_lo;
	
	private ItemStack bigCopy;
	private ItemStack editItem;
	private RenderItem bigRender = new RenderItem_FinishingAnvil(this);
	
	public final TileEntity_FinishingAnvil inventory;
	private ResourceLocation forGui;
	
	private int leftButtonPosX = 0;
	private int leftButtonPosY = 0;
	private int xIcon_one, yIcon_one;
	private int xIcon_two, yIcon_two;
	private int xIcon_three, yIcon_three;
	
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
		this.buttonList.add(new GuiButton(1 ,this.guiLeft+25, this.guiTop+10, 10, 10,"▲"));
		this.buttonList.add(new GuiButton(2 ,this.guiLeft+25, this.guiTop+59, 10, 10,"▼"));
		this.buttonList.add(new GuiButton(3 ,this.guiLeft+47, this.guiTop+49, 18, 18,"✓"));
		
		this.buttonList.add(new GuiButton(4 ,this.guiLeft+5, this.guiTop+10, 20, 20,""));
		this.buttonList.add(new GuiButton(5 ,this.guiLeft+5, this.guiTop+30, 20, 20,""));
		this.buttonList.add(new GuiButton(6 ,this.guiLeft+5, this.guiTop+50, 20, 20,""));
		
		this.buttonList.add(new GuiButton(7 ,this.guiLeft+120, this.guiTop+10, 10, 10,"▲"));
		this.buttonList.add(new GuiButton(8 ,this.guiLeft+120, this.guiTop+59, 10, 10,"▼"));

		//((GuiButton)this.buttonList.get(0)).displayString = "9";
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{
		case 1: if(this.leftButtonPosX > 0) this.leftButtonPosX--; break;
		case 2: this.leftButtonPosX++; break;
		}
	}
	public void drawScreen(int par1, int par2, float par3)
	{
		if(inventory.getStackInSlot(0) != null //&&
				/*inventory.getStackInSlot(0).getItem() != this.bigCopy*/)
					this.bigCopy = inventory.getStackInSlot(0).copy();
		else
			this.bigCopy = null;
		super.drawScreen(par1, par2, par3);
		this.xSize_lo = (float)par1;
		this.ySize_lo = (float)par2;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.forGui = new ResourceLocation("tinkersdefense", "textures/gui/finishinganvil.png");
		
		this.xIcon_one = 0;
		this.yIcon_one = 176;
		this.xIcon_two = 0;
		this.yIcon_two = 176;
		this.xIcon_three = 0;
		this.yIcon_three = 176;
		
		if(inventory.getStackInSlot(0) != null)
		{
			editItem = inventory.getStackInSlot(0);
			if(editItem.getItem() instanceof ToolCore)
			{
				//this.drawTexturedModelRectFromIcon(this.guiLeft+4, this.guiTop+14, 
				//		((ToolCore)this.inventorySlots.inventorySlots.get(0)).getHeadItem(), 16, 16);
				
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				this.forGui = new ResourceLocation("tinkersdefense","textures/gui/"+((ToolCore)editItem.getItem()).getDefaultFolder()+".png");
				this.xIcon_one = 16;
				this.yIcon_one = 0;
				this.xIcon_two = 32;
				this.yIcon_two = 0;
				this.xIcon_three = 48;
				this.yIcon_three = 0;
			}
		}
		
		this.mc.getTextureManager().bindTexture(this.forGui);
		this.drawTexturedModalRect(7,12,this.xIcon_one+(this.leftButtonPosX*16),this.yIcon_one+(this.leftButtonPosY*16),16,16);
		this.drawTexturedModalRect(7,32,this.xIcon_two+(this.leftButtonPosX*16),this.yIcon_two+(this.leftButtonPosY*16),16,16);
		this.drawTexturedModalRect(7,52,this.xIcon_three+(this.leftButtonPosX*16),this.yIcon_three+(this.leftButtonPosY*16),16,16);

		bigRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), bigCopy, 23, 5);

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
