package gmail.Lance5057.gui;

import gmail.Lance5057.TinkersDefense;
import gmail.Lance5057.containers.Container_CrestMount;
import gmail.Lance5057.containers.Container_FinishingAnvil;
import gmail.Lance5057.network.Message_CrestMount;
import gmail.Lance5057.network.Message_FinishingAnvil;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import gmail.Lance5057.tileentities.TileEntity_FinishingAnvil;

import org.lwjgl.opengl.GL11;

import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.ToolCore;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class Gui_FinishingAnvil extends GuiContainer
{
	private float xSize_lo;
	private float ySize_lo;
	
	private ItemStack bigCopy;
	private Boolean isNull = true;
	private ItemStack editItem;
	private RenderItem bigRender = new RenderItem_FinishingAnvil(this);
	
	public final TileEntity_FinishingAnvil inventory;
	private ResourceLocation forGui;
	
	private int leftButtonPosX = 0;
	private int leftButtonPosY = 0;
	private int xLIcon_one, yLIcon_one;
	private int xLIcon_two, yLIcon_two;
	private int xLIcon_three, yLIcon_three;
	private int leftSelect = 0;
	
	private int rightButtonPosX = 0;
	private int rightButtonPosY = 2;
	private int xRIcon_one, yRIcon_one;
	private int xRIcon_two, yRIcon_two;
	private int xRIcon_three, yRIcon_three;
	
	String[] renders;
	
	NBTTagCompound tags;
	
	private static final ResourceLocation iconLocation = new ResourceLocation("tinkersdefense", "textures/gui/finishinganvil.png");

	public Gui_FinishingAnvil(InventoryPlayer invPlayer, TileEntity_FinishingAnvil te)
	{
		super(new Container_FinishingAnvil(invPlayer, te));
		this.inventory = te;
		
		renders = new String[4];
		renders[0] = "Head";
		renders[1] = "Accessory";
		renders[2] = "Handle";
		renders[3] = "Extra";
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
		
		this.buttonList.add(new GuiButton(9 ,this.guiLeft+130, this.guiTop+10, 20, 20,""));
		this.buttonList.add(new GuiButton(10 ,this.guiLeft+130, this.guiTop+30, 20, 20,""));
		this.buttonList.add(new GuiButton(11 ,this.guiLeft+130, this.guiTop+50, 20, 20,""));

	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if(tags != null)
		switch(button.id)
		{
		case 1: if(this.leftButtonPosX > 0) this.leftButtonPosX--; break;
		case 2: if(this.leftButtonPosX+2 < ((ToolCore)bigCopy.getItem()).getPartAmount() - 1) this.leftButtonPosX++; break;
		
		case 3: 
			 TinkersDefense.INSTANCE.sendToServer(new Message_FinishingAnvil(inventory.xCoord, inventory.yCoord, inventory.zCoord, this.bigCopy));
		break;
		
		case 4: leftSelect = 0; rightButtonPosY = 2; break;
		case 5: leftSelect = 1; rightButtonPosY = 3; break;
		case 6: leftSelect = 2; rightButtonPosY = 4; break;
		
		case 7: if(this.rightButtonPosX > 0) this.rightButtonPosX--; break;
		case 8: this.rightButtonPosX++; break;
		
		case 9: 
			if(tags.hasKey("Render"+renders[leftSelect]))
			{
				tags.setInteger("Render"+renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPosX) * TinkersDefense.config.MaterialIndex));
				if(rightButtonPosX > 0)
					tags.setInteger(renders[leftSelect]+"Color", TConstructRegistry.getMaterial(tags.getInteger(renders[leftSelect])).primaryColor());
				else
					tags.removeTag(renders[leftSelect]+"Color");
			}
			break;
			
		case 10:
		if(tags.hasKey("Render"+renders[leftSelect]))
		{
			tags.setInteger("Render"+renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPosX + 1) * TinkersDefense.config.MaterialIndex));
			tags.setInteger(renders[leftSelect]+"Color", TConstructRegistry.getMaterial(tags.getInteger(renders[leftSelect])).primaryColor());
		}
		break;
		
		case 11:
			if(tags.hasKey("Render"+renders[leftSelect]))
			{
				tags.setInteger("Render"+renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPosX + 2) * TinkersDefense.config.MaterialIndex));
				tags.setInteger(renders[leftSelect]+"Color", TConstructRegistry.getMaterial(tags.getInteger(renders[leftSelect])).primaryColor());
			}
			break;
		}
	}
	public void drawScreen(int par1, int par2, float par3)
	{
		
		
		if(inventory.getStackInSlot(0) != null && isNull == true
				/*inventory.getStackInSlot(0).getItem() != this.bigCopy*/)
		{
					this.bigCopy = inventory.getStackInSlot(0).copy();
					if(bigCopy.hasTagCompound() && bigCopy.getTagCompound().hasKey("InfiTool"))
						tags = bigCopy.getTagCompound().getCompoundTag("InfiTool");
					isNull = false;
		}
		else if(inventory.getStackInSlot(0) == null)
		{
			this.bigCopy = null;
			isNull = true;
		}
		
		super.drawScreen(par1, par2, par3);
		this.xSize_lo = (float)par1;
		this.ySize_lo = (float)par2;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.forGui = new ResourceLocation("tinkersdefense", "textures/gui/finishinganvil.png");
		
		this.xLIcon_one = 0;
		this.yLIcon_one = 176;
		this.xLIcon_two = 0;
		this.yLIcon_two = 176;
		this.xLIcon_three = 0;
		this.yLIcon_three = 176;
		
		this.xRIcon_one = 0;
		this.yRIcon_one = 176;
		this.xRIcon_two = 0;
		this.yRIcon_two = 176;
		this.xRIcon_three = 0;
		this.yRIcon_three = 176;
		
		if(inventory.getStackInSlot(0) != null)
		{
			editItem = inventory.getStackInSlot(0);
			if(editItem.getItem() instanceof ToolCore)
			{
				//this.drawTexturedModelRectFromIcon(this.guiLeft+4, this.guiTop+14, 
				//		((ToolCore)this.inventorySlots.inventorySlots.get(0)).getHeadItem(), 16, 16);
				
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				this.forGui = new ResourceLocation("tinkersdefense","textures/gui/"+((ToolCore)editItem.getItem()).getDefaultFolder()+".png");
				this.xLIcon_one = 32;
				this.yLIcon_one = 0;
				this.xLIcon_two = 48;
				this.yLIcon_two = 0;
				this.xLIcon_three = 64;
				this.yLIcon_three = 0;
				
				this.xRIcon_one = 0;
				this.yRIcon_one = 0;
				this.xRIcon_two = 16;
				this.yRIcon_two = 0;
				this.xRIcon_three = 32;
				this.yRIcon_three = 0;
			}
		}
		
		this.mc.getTextureManager().bindTexture(this.forGui);
		if(inventory.getStackInSlot(0) != null)
			this.drawTexturedModalRect(7,12 + (leftSelect * 20),16,0,16,16);
		
		this.drawTexturedModalRect(7,12,this.xLIcon_one+(this.leftButtonPosX*16),this.yLIcon_one+(this.leftButtonPosY*16),16,16);
		this.drawTexturedModalRect(7,32,this.xLIcon_two+(this.leftButtonPosX*16),this.yLIcon_two+(this.leftButtonPosY*16),16,16);
		this.drawTexturedModalRect(7,52,this.xLIcon_three+(this.leftButtonPosX*16),this.yLIcon_three+(this.leftButtonPosY*16),16,16);

		this.drawTexturedModalRect(132,12,this.xRIcon_one+(this.rightButtonPosX*16),this.yRIcon_one+(this.rightButtonPosY*16),16,16);
		this.drawTexturedModalRect(132,32,this.xRIcon_two+(this.rightButtonPosX*16),this.yRIcon_two+(this.rightButtonPosY*16),16,16);
		this.drawTexturedModalRect(132,52,this.xRIcon_three+(this.rightButtonPosX*16),this.yRIcon_three+(this.rightButtonPosY*16),16,16);
		
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
	
	protected void injectIcons()
	{
		
	}
}
