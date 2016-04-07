package lance5057.tDefense.finishingAnvil.blocks.finishingAnvil;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.network.Message_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.utilities.Injector;
import lance5057.tDefense.finishingAnvil.utilities.ToolCoreTip;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.config.GuiButtonExt;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.ToolCore;

public class Gui_FinishingAnvil extends GuiContainer
{
	private float							xSize_lo;
	private float							ySize_lo;

	private ItemStack						bigCopy;
	private Boolean							isNull			= true;
	private ItemStack						editItem;
	private RenderItem						bigRender		= new RenderItem_FinishingAnvil(this);

	public final TileEntity_FinishingAnvil	inventory;
	private ResourceLocation				forGui;

	private int								leftButtonPosX	= 0;
	private int								leftButtonPosY	= 0;
	private int								xLIcon_one, yLIcon_one;
	private int								xLIcon_two, yLIcon_two;
	private int								xLIcon_three, yLIcon_three;
	private int								leftSelect		= 0;

	private int								rightButtonPosX	= 0;
	private int								rightButtonPosY	= 0;
	private int								xRIcon_one, yRIcon_one;
	private int								xRIcon_two, yRIcon_two;
	private int								xRIcon_three, yRIcon_three;

	String[]								renders;

	NBTTagCompound							tags;

	private static final ResourceLocation	iconLocation	= new ResourceLocation("tinkersdefense", "textures/gui/finishinganvil.png");

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
		this.buttonList.add(new GuiButtonExt(1, this.guiLeft + 25, this.guiTop + 10, 10, 10, "⇑"));
		this.buttonList.add(new GuiButtonExt(2, this.guiLeft + 25, this.guiTop + 59, 10, 10, "⇓"));
		this.buttonList.add(new GuiButtonExt(3, this.guiLeft + 47, this.guiTop + 49, 18, 18, "✓"));

		this.buttonList.add(new GuiButtonExt(4, this.guiLeft + 5, this.guiTop + 10, 20, 20, ""));
		this.buttonList.add(new GuiButtonExt(5, this.guiLeft + 5, this.guiTop + 30, 20, 20, ""));
		this.buttonList.add(new GuiButtonExt(6, this.guiLeft + 5, this.guiTop + 50, 20, 20, ""));

		this.buttonList.add(new GuiButtonExt(7, this.guiLeft + 120, this.guiTop + 10, 10, 10, "⇑"));
		this.buttonList.add(new GuiButtonExt(8, this.guiLeft + 120, this.guiTop + 60, 10, 10, "⇓"));

		this.buttonList.add(new GuiButtonExt(9, this.guiLeft + 130, this.guiTop + 10, 20, 20, ""));
		this.buttonList.add(new GuiButtonExt(10, this.guiLeft + 130, this.guiTop + 30, 20, 20, ""));
		this.buttonList.add(new GuiButtonExt(11, this.guiLeft + 130, this.guiTop + 50, 20, 20, ""));

	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if(tags != null)
			switch(button.id)
			{
				case 1:
					if(this.leftButtonPosX > 0)
						this.leftButtonPosX--;
					break;
				case 2:
					if(this.leftButtonPosX + 3 < ((ToolCore) bigCopy.getItem()).getPartAmount())
						this.leftButtonPosX++;
					break;

				case 3:
					TinkersDefense.INSTANCE.sendToServer(new Message_FinishingAnvil(inventory.xCoord, inventory.yCoord, inventory.zCoord, this.bigCopy));
					break;

				case 4:
					leftSelect = 0 + leftButtonPosX;
					rightButtonPosY = 0 + (leftButtonPosX * 3);
					break;
				case 5:
					leftSelect = 1 + leftButtonPosX;
					rightButtonPosY = 3 + (leftButtonPosX * 3);
					break;
				case 6:
					leftSelect = 2 + leftButtonPosX;
					rightButtonPosY = 6 + (leftButtonPosX * 3);
					break;

				case 7:
					if(this.rightButtonPosX > 0)
					{
						this.rightButtonPosX--;
					}
					else if(this.rightButtonPosY > (0 + this.leftSelect * 4))
					{
						this.rightButtonPosY--;
						this.rightButtonPosX = 15;
					}
					break;
				case 8:
					this.rightButtonPosX++;
					if(this.rightButtonPosX >= 16)
					{
						this.rightButtonPosY++;
						this.rightButtonPosX = 0;
					}
					break;

				case 9:
					if(tags.hasKey("Render" + renders[leftSelect]))
					{
						tags.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPosX + ((rightButtonPosY % 3) * 16)) * TinkersDefense.config.MaterialIndex));
						if(rightButtonPosX + (rightButtonPosY * 16) > 0)
							tags.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(tags.getInteger(renders[leftSelect])).primaryColor());
						else
							tags.removeTag(renders[leftSelect] + "Color");
					}
					break;

				case 10:
					if(tags.hasKey("Render" + renders[leftSelect]))
					{
						tags.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPosX + 1 + ((rightButtonPosY % 3) * 16)) * TinkersDefense.config.MaterialIndex));
						tags.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(tags.getInteger(renders[leftSelect])).primaryColor());
					}
					break;

				case 11:
					if(tags.hasKey("Render" + renders[leftSelect]))
					{
						tags.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPosX + 2 + ((rightButtonPosY % 3) * 16)) * TinkersDefense.config.MaterialIndex));
						tags.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(tags.getInteger(renders[leftSelect])).primaryColor());
					}
					break;
			}
	}

	public void drawScreen(int x, int y, float par3)
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

		super.drawScreen(x, y, par3);
		drawTooltip(x, y);
		this.xSize_lo = (float) x;
		this.ySize_lo = (float) y;
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
				this.forGui = new ResourceLocation("tinkersdefense", "textures/gui/" + ((ToolCore) editItem.getItem()).getDefaultFolder() + ".png");
				this.xLIcon_one = 32;
				this.yLIcon_one = 0;
				this.xLIcon_two = 48;
				this.yLIcon_two = 0;
				this.xLIcon_three = 64;
				this.yLIcon_three = 0;

				this.xRIcon_one = 0;
				this.yRIcon_one = 32;
				this.xRIcon_two = 16;
				this.yRIcon_two = 32;
				this.xRIcon_three = 32;
				this.yRIcon_three = 32;
			}
		}

		this.mc.getTextureManager().bindTexture(this.forGui);
		if(inventory.getStackInSlot(0) != null)
			this.drawTexturedModalRect(7, 12 + (leftSelect * 20), 16, 0, 16, 16);

		this.drawTexturedModalRect(7, 12, this.xLIcon_one + (this.leftButtonPosX * 16), this.yLIcon_one + (this.leftButtonPosY * 16), 16, 16);
		this.drawTexturedModalRect(7, 32, this.xLIcon_two + (this.leftButtonPosX * 16), this.yLIcon_two + (this.leftButtonPosY * 16), 16, 16);
		this.drawTexturedModalRect(7, 52, this.xLIcon_three + (this.leftButtonPosX * 16), this.yLIcon_three + (this.leftButtonPosY * 16), 16, 16);

		this.drawTexturedModalRect(132, 12, this.xRIcon_one + (this.rightButtonPosX * 16), this.yRIcon_one + (this.rightButtonPosY * 16), 16, 16);

		if(this.rightButtonPosX + 1 < 16)
			this.drawTexturedModalRect(132, 32, this.xRIcon_two + (this.rightButtonPosX * 16), this.yRIcon_two + (this.rightButtonPosY * 16), 16, 16);
		else
			this.drawTexturedModalRect(132, 32, this.xRIcon_two + ((this.rightButtonPosX - 16) * 16), this.yRIcon_two + ((this.rightButtonPosY + 1) * 16), 16, 16);

		if(this.rightButtonPosX + 2 < 16)
			this.drawTexturedModalRect(132, 52, this.xRIcon_three + (this.rightButtonPosX * 16), this.yRIcon_three + (this.rightButtonPosY * 16), 16, 16);
		else
			this.drawTexturedModalRect(132, 52, this.xRIcon_three + ((this.rightButtonPosX - 16) * 16), this.yRIcon_three + ((this.rightButtonPosY + 1) * 16), 16, 16);

		bigRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), bigCopy, 23, 5);

	}

	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(iconLocation);
		int k = ((this.width - this.xSize) / 2);
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize + 80, this.ySize);
	}

	protected void injectIcons()
	{

	}

	protected void drawTooltip(int x, int y)
	{
		int buttons[] = {4, 5, 6, 9, 10, 11};

		for(int i = 0; i < buttons.length; i++)
		{
			GuiButtonExt button = ((GuiButtonExt) this.buttonList.get(buttons[i] - 1));
			boolean mousehover = x >= button.xPosition && y >= button.yPosition && x < button.xPosition + button.width && y < button.yPosition + button.height;
			int test = button.getHoverState(mousehover);
			if(test == 2)
			{
				if(bigCopy != null)
				{
					ToolCore tool = (ToolCore) bigCopy.getItem();
					ToolCoreTip tt = ((Injector) TinkersDefense.tcInject).tools.get(tool.getToolName());
					List<String> list = new ArrayList();

					switch(i)
					{
						case 0: list.add(tt.getPart(1 + this.leftButtonPosX)); break;
						case 1: list.add(tt.getPart(3 + this.leftButtonPosX)); break;
						case 2: list.add(tt.getPart(2 + this.leftButtonPosX)); break;
						
						case 3: list.add(tt.getPartName(this.leftSelect + 1, (rightButtonPosX + ((rightButtonPosY % 3) * 16)))); break;
						case 4: list.add(tt.getPartName(this.leftSelect + 1, (rightButtonPosX + 1 + ((rightButtonPosY % 3) * 16)))); break;
						case 5: list.add(tt.getPartName(this.leftSelect + 1, (rightButtonPosX + 2 + ((rightButtonPosY % 3) * 16)))); break;
					}

					if(list.get(0).contains("Metallurgy"))
						list.add(" -by Shadowclaimer");
					func_146283_a(list, x, y);

				}
			}
		}
	}
}
