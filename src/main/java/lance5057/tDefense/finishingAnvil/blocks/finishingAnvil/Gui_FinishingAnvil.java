package lance5057.tDefense.finishingAnvil.blocks.finishingAnvil;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import lance5057.tDefense.core.network.Message_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.utilities.Injector;
import lance5057.tDefense.finishingAnvil.utilities.ToolCoreTip;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.util.glu.Project;

import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.ToolCore;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.config.GuiButtonExt;

public class Gui_FinishingAnvil extends GuiContainer
{
	private float							xSize_lo;
	private float							ySize_lo;

	private ItemStack						bigCopy;
	//private Boolean							isNull			= true;
	private ItemStack						editItem;
	private final RenderItem				bigRender		= new RenderItem_FinishingAnvil(
																	this);

	public final TileEntity_FinishingAnvil	inventory;
	private ResourceLocation				forGui;

	private int								leftButtonPosX	= 0;
	private final int						leftButtonPosY	= 0;
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

	boolean									renderFlat		= true;
	boolean									renderBiped		= true;
	int										rotation		= 0;

	InventoryPlayer							player;

	private static final ResourceLocation	iconLocation	= new ResourceLocation(
																	"tinkersdefense",
																	"textures/gui/finishinganvil.png");

	public Gui_FinishingAnvil(InventoryPlayer invPlayer, TileEntity_FinishingAnvil te)
	{
		super(new Container_FinishingAnvil(invPlayer, te));
		inventory = te;

		renders = new String[4];
		renders[0] = "Head";
		renders[1] = "Accessory";
		renders[2] = "Handle";
		renders[3] = "Extra";

		player = invPlayer;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		buttonList.add(new GuiButtonExt(1, guiLeft + 25, guiTop + 11, 10, 10,
				"⇑"));
		buttonList.add(new GuiButtonExt(2, guiLeft + 25, guiTop + 61, 10, 10,
				"⇓"));
		buttonList.add(new GuiButtonExt(3, guiLeft + 38, guiTop + 53, 18, 18,
				"✓"));

		buttonList.add(new GuiButtonExt(4, guiLeft + 5, guiTop + 11, 20, 20, ""));
		buttonList.add(new GuiButtonExt(5, guiLeft + 5, guiTop + 31, 20, 20, ""));
		buttonList.add(new GuiButtonExt(6, guiLeft + 5, guiTop + 51, 20, 20, ""));

		buttonList.add(new GuiButtonExt(7, guiLeft + 141, guiTop + 11, 10, 10,
				"⇑"));
		buttonList.add(new GuiButtonExt(8, guiLeft + 141, guiTop + 61, 10, 10,
				"⇓"));

		buttonList.add(new GuiButtonExt(9, guiLeft + 151, guiTop + 11, 20, 20,
				""));
		buttonList.add(new GuiButtonExt(10, guiLeft + 151, guiTop + 31, 20, 20,
				""));
		buttonList.add(new GuiButtonExt(11, guiLeft + 151, guiTop + 51, 20, 20,
				""));

		buttonList.add(new GuiButtonExt(12, guiLeft + 38, guiTop + 11, 18, 18,
				"∅"));
		buttonList.add(new GuiButtonExt(13, guiLeft + 120, guiTop + 11, 18, 18,
				"3D"));
		buttonList.add(new GuiButtonExt(14, guiLeft + 120, guiTop + 53, 18, 18,
				""));

		buttonList.add(new GuiButtonExt(15, guiLeft + 59, guiTop + 60, 10, 10,
				"<"));
		buttonList.add(new GuiButtonExt(16, guiLeft + 107, guiTop + 60, 10, 10,
				">"));
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if(tags != null)
		{
			switch(button.id)
			{
				case 1:
					if(leftButtonPosX > 0)
					{
						leftButtonPosX--;
					}
					break;
				case 2:
					if(leftButtonPosX + 3 < ((ToolCore) bigCopy.getItem()).getPartAmount())
					{
						leftButtonPosX++;
					}
					break;

				case 3:
					TinkersDefense.INSTANCE.sendToServer(new Message_FinishingAnvil(
							inventory.xCoord, inventory.yCoord,
							inventory.zCoord, bigCopy));
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
					if(rightButtonPosX > 0)
					{
						rightButtonPosX--;
					}
					else if(rightButtonPosY > (0 + leftSelect * 4))
					{
						rightButtonPosY--;
						rightButtonPosX = 15;
					}
					break;

				case 13:
					renderFlat = !renderFlat;
					break;

				case 14:
					renderBiped = !renderBiped;
					break;

				case 15:
					if(rotation <= 0)
					{
						rotation += 360;
					}
					rotation -= 8;
					break;

				case 16:
					if(rotation >= 360)
					{
						rotation -= 360;
					}
					rotation += 8;
					break;

				default:
					if(bigCopy.getItem() instanceof ArmorCore)
					{
						doArmorEdit(button.id);
					}
					else
					{
						doToolEdit(button.id);
					}
			}
		}
	}

	public void doToolEdit(int id)
	{
		switch(id)
		{
			case 9:
				if(tags.hasKey("Render" + renders[leftSelect]))
				{
					tags.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPosX + ((rightButtonPosY % 3) * 16)) * TinkersDefense.config.MaterialIndex));
					if(rightButtonPosX > 0)
					{
						tags.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(tags.getInteger(renders[leftSelect])).primaryColor());
					}
					else
					{
						tags.removeTag(renders[leftSelect] + "Color");
					}
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

			case 12:
				tags.setInteger("RenderHead", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[0]));
				tags.setInteger("RenderAccessory", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[1]));
				tags.setInteger("RenderHandle", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[2]));
				tags.setInteger("RenderExtra", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[3]));

				tags.removeTag(renders[0] + "Color");
				tags.removeTag(renders[1] + "Color");
				tags.removeTag(renders[2] + "Color");
				tags.removeTag(renders[3] + "Color");
				break;

			case 8:
				rightButtonPosX++;
				if(rightButtonPosX >= 16)
				{
					rightButtonPosY++;
					rightButtonPosX = 0;
				}
				break;

		}
	}

	public void doArmorEdit(int id)
	{
		final NBTTagCompound aTags = bigCopy.getTagCompound().getCompoundTag("ArmorRenderer");
		final ArmorCore armor = (ArmorCore) bigCopy.getItem();
		final List<ModelRenderer> boxes = armor.getRenderer().boxList;

		switch(id)
		{
			case 9:
				aTags.setBoolean(boxes.get(rightButtonPosX + 9).boxName, !aTags.getBoolean(boxes.get(rightButtonPosX + (rightButtonPosY % 3) + 9).boxName));
				break;

			case 10:
				aTags.setBoolean(boxes.get(rightButtonPosX + 1 + 9).boxName, !aTags.getBoolean(boxes.get(rightButtonPosX + 1 + (rightButtonPosY % 3) + 9).boxName));
				break;

			case 11:
				aTags.setBoolean(boxes.get(rightButtonPosX + 2 + 9).boxName, !aTags.getBoolean(boxes.get(rightButtonPosX + 2 + (rightButtonPosY % 3) + 9).boxName));
				break;

			case 12:
				tags.setInteger("RenderHead", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[0]));
				tags.setInteger("RenderAccessory", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[1]));
				tags.setInteger("RenderHandle", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[2]));
				tags.setInteger("RenderExtra", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[3]));

				tags.removeTag(renders[0] + "Color");
				tags.removeTag(renders[1] + "Color");
				tags.removeTag(renders[2] + "Color");
				tags.removeTag(renders[3] + "Color");
				break;

			case 8:
				if(rightButtonPosX < boxes.size() - 12)
				{
					rightButtonPosX++;
				}
				break;

		}
	}

	@Override
	public void drawScreen(int x, int y, float par3)
	{

		if(inventory.getStackInSlot(0) != null)
		{
			if(bigCopy == null)
			{
				bigCopy = inventory.getStackInSlot(0).copy();
				if(bigCopy.hasTagCompound() && bigCopy.getTagCompound().hasKey("InfiTool"))
				{
					tags = bigCopy.getTagCompound().getCompoundTag("InfiTool");
				}
			}
			else if(inventory.getStackInSlot(0).getItem() != bigCopy.getItem() || inventory.getStackInSlot(0).getItemDamage() != bigCopy.getItemDamage())
			{
				bigCopy = null;
			}
		}
		else if(inventory.getStackInSlot(0) == null)
		{
			bigCopy = null;
		}

		super.drawScreen(x, y, par3);
		drawTooltip(x, y);
		xSize_lo = x;
		ySize_lo = y;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		mc.getTextureManager().bindTexture(iconLocation);

		drawTexturedModalRect(121, 54, 16, 176, 16, 16);

		xLIcon_one = 0;
		yLIcon_one = 176;
		xLIcon_two = 0;
		yLIcon_two = 176;
		xLIcon_three = 0;
		yLIcon_three = 176;

		xRIcon_one = 0;
		yRIcon_one = 176;
		xRIcon_two = 0;
		yRIcon_two = 176;
		xRIcon_three = 0;
		yRIcon_three = 176;

		if(inventory.getStackInSlot(0) != null)
		{
			editItem = inventory.getStackInSlot(0);
			if(editItem.getItem() instanceof ToolCore)
			{
				//this.drawTexturedModelRectFromIcon(this.guiLeft+4, this.guiTop+14, 
				//		((ToolCore)this.inventorySlots.inventorySlots.get(0)).getHeadItem(), 16, 16);

				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				forGui = new ResourceLocation(
						"tinkersdefense",
						"textures/gui/" + ((ToolCore) editItem.getItem()).getDefaultFolder() + ".png");
				xLIcon_one = 32;
				yLIcon_one = 0;
				xLIcon_two = 48;
				yLIcon_two = 0;
				xLIcon_three = 64;
				yLIcon_three = 0;

				xRIcon_one = 0;
				yRIcon_one = 32;
				xRIcon_two = 16;
				yRIcon_two = 32;
				xRIcon_three = 32;
				yRIcon_three = 32;
			}
		}

		if(forGui != null && bigCopy != null)
		{
			if(!(bigCopy.getItem() instanceof ArmorCore))
			{
				mc.getTextureManager().bindTexture(forGui);

				if(inventory.getStackInSlot(0) != null)
				{
					//			int leftMax = leftSelect;
					//			if(leftMax > 2)
					//				leftMax = 2;
					drawTexturedModalRect(7, 13 + ((leftSelect - leftButtonPosX) * 20), 16, 0, 16, 16);
				}

				drawTexturedModalRect(7, 13, xLIcon_one + (leftButtonPosX * 16), yLIcon_one + 0, 16, 16);
				drawTexturedModalRect(7, 33, xLIcon_two + (leftButtonPosX * 16), yLIcon_two + 0, 16, 16);
				drawTexturedModalRect(7, 53, xLIcon_three + (leftButtonPosX * 16), yLIcon_three + 0, 16, 16);

				drawTexturedModalRect(153, 13, xRIcon_one + (rightButtonPosX * 16), yRIcon_one + (rightButtonPosY * 16), 16, 16);

				if(rightButtonPosX + 1 < 16)
				{
					drawTexturedModalRect(153, 33, xRIcon_two + (rightButtonPosX * 16), yRIcon_two + (rightButtonPosY * 16), 16, 16);
				}
				else
				{
					drawTexturedModalRect(153, 33, xRIcon_two + ((rightButtonPosX - 16) * 16), yRIcon_two + ((rightButtonPosY + 1) * 16), 16, 16);
				}

				if(rightButtonPosX + 2 < 16)
				{
					drawTexturedModalRect(153, 53, xRIcon_three + (rightButtonPosX * 16), yRIcon_three + (rightButtonPosY * 16), 16, 16);
				}
				else
				{
					drawTexturedModalRect(153, 53, xRIcon_three + ((rightButtonPosX - 16) * 16), yRIcon_three + ((rightButtonPosY + 1) * 16), 16, 16);
				}
			}
			else
			{
				final NBTTagCompound aTags = bigCopy.getTagCompound().getCompoundTag("ArmorRenderer");
				final ArmorCore armor = (ArmorCore) bigCopy.getItem();
				final List<ModelRenderer> boxes = armor.getRenderer().boxList;

				drawTexturedModalRect(7, 13, 0, 176, 16, 16);
				drawTexturedModalRect(7, 33, 0, 176, 16, 16);
				drawTexturedModalRect(7, 53, 0, 176, 16, 16);

				//drawTexturedModalRect(153, 13, xRIcon_one + (rightButtonPosX * 16), yRIcon_one + (rightButtonPosY * 16), 16, 16);

				drawTexturedModalRect(153, 13, 64 + ((aTags.getBoolean(boxes.get(rightButtonPosX + 9).boxName) ? 0 : 1) * 16), 176, 16, 16);
				drawTexturedModalRect(153, 33, 64 + ((aTags.getBoolean(boxes.get(rightButtonPosX + 1 + 9).boxName) ? 0 : 1) * 16), 176, 16, 16);
				drawTexturedModalRect(153, 53, 64 + ((aTags.getBoolean(boxes.get(rightButtonPosX + 2 + 9).boxName) ? 0 : 1) * 16), 176, 16, 16);

			}
		}
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{

		mc.getTextureManager().bindTexture(iconLocation);
		final int k = ((width - xSize) / 2);
		final int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize + 80, ySize);

		if(renderFlat)
		{
			((GuiButtonExt) buttonList.get(14)).enabled = false;
			((GuiButtonExt) buttonList.get(15)).enabled = false;
			((GuiButtonExt) buttonList.get(12)).displayString = "3D";

			final ScaledResolution scaledresolution = new ScaledResolution(mc,
					mc.displayWidth, mc.displayHeight);
			bigRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), bigCopy, (int) (((scaledresolution.getScaledWidth() - 58) / 2) / 3.4), (int) (((scaledresolution.getScaledHeight() - 136) / 2) / 3.4));
		}
		else
		{
			if(bigCopy != null && bigCopy.getItem() instanceof ArmorCore)
			{
				((GuiButtonExt) buttonList.get(14)).enabled = true;
				((GuiButtonExt) buttonList.get(15)).enabled = true;

				((GuiButtonExt) buttonList.get(12)).displayString = "2D";

				final ArmorCore armor = (ArmorCore) bigCopy.getItem();

				final ArmorRenderer renderer = (ArmorRenderer) armor.getArmorModel(null, bigCopy, 0);
				renderer.isChild = false;

				final float yaw = player.player.prevRotationYawHead + (player.player.rotationYawHead - player.player.prevRotationYawHead);
				final float yawOffset = player.player.prevRenderYawOffset + (player.player.renderYawOffset - player.player.prevRenderYawOffset);
				final float limbs = player.player.prevLimbSwingAmount + (player.player.limbSwingAmount - player.player.prevLimbSwingAmount);
				final float limbSwing = player.player.limbSwing - player.player.limbSwingAmount * (1.0F);

				GL11.glPushMatrix();
				GL11.glMatrixMode(GL11.GL_PROJECTION);
				GL11.glPushMatrix();
				GL11.glLoadIdentity();

				final ScaledResolution scaledresolution = new ScaledResolution(
						mc, mc.displayWidth, mc.displayHeight);
				//GL11.glViewport(this.guiLeft, this.guiTop, this.width, this.height);
				GL11.glViewport((scaledresolution.getScaledWidth() - 213) / 2 * scaledresolution.getScaleFactor(), (scaledresolution.getScaledHeight() - 240) / 2 * scaledresolution.getScaleFactor(), 320 * scaledresolution.getScaleFactor(), 240 * scaledresolution.getScaleFactor());
				GL11.glTranslatef(-0.34F, 0.23F, -0.1F);
				Project.gluPerspective(90.0F, 1.3333334F, 9.0F, 80.0F);
				final float f1 = 1.0F;
				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glLoadIdentity();
				GL11.glColor3d(1f, 1f, 1f);
				RenderHelper.enableStandardItemLighting();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glTranslatef(0.0F, 3.3F, -16.0F);
				GL11.glScalef(f1, f1, f1);
				final float f2 = 3.0F;
				GL11.glScalef(f2, f2, f2);
				GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);

				GL11.glEnable(GL12.GL_RESCALE_NORMAL);
				//renderer.setRotationAngles(limbSwing, limbs, player.player.ticksExisted, 0, player.player.rotationPitch, 0.0625f, player.player);
				renderer.render(player.player, limbSwing, limbs, player.player.ticksExisted, 0, 0, 0.1f);

				if(renderBiped)
				{
					final ModelBiped biped = new ModelBiped(0f);
					//biped.bipedHeadwear.isHidden = true;
					//biped.bipedHead.isHidden = true;
					ResourceLocation rc = AbstractClientPlayer.getLocationSkin(player.player.getDisplayName());
					;
					FMLClientHandler.instance().getClient().renderEngine.bindTexture(rc);
					final ITextureObject tex = FMLClientHandler.instance().getClient().getTextureManager().getTexture(rc);
					if(tex.getGlTextureId() == 1)
					{
						rc = new ResourceLocation(
								"minecraft:textures/entity/steve.png");
						FMLClientHandler.instance().getClient().renderEngine.bindTexture(rc);
					}

					biped.isChild = false;
					biped.render(player.player, limbSwing, limbs, player.player.ticksExisted, 0, 0, 0.0625f);
				}

				GL11.glDisable(GL12.GL_RESCALE_NORMAL);
				RenderHelper.disableStandardItemLighting();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glMatrixMode(GL11.GL_PROJECTION);
				GL11.glViewport(0, 0, mc.displayWidth, mc.displayHeight);
				GL11.glPopMatrix();
				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glPopMatrix();
				//RenderHelper.disableStandardItemLighting();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
			else
			{
				renderFlat = true;
			}
		}
	}

	protected void drawTooltip(int x, int y)
	{
		final int buttons[] = {4, 5, 6, 9, 10, 11};

		for(int i = 0; i < buttons.length; i++)
		{
			final GuiButtonExt button = ((GuiButtonExt) buttonList.get(buttons[i] - 1));
			final boolean mousehover = x >= button.xPosition && y >= button.yPosition && x < button.xPosition + button.width && y < button.yPosition + button.height;
			final int test = button.getHoverState(mousehover);
			if(test == 2)
			{
				if(bigCopy != null && bigCopy.getItem() instanceof ToolCore)
				{
					final ToolCore tool = (ToolCore) bigCopy.getItem();
					final ToolCoreTip tt = ((Injector) TinkersDefense.tcInject).tools.get(tool.getToolName());
					final List<String> list = new ArrayList();

					if(tt != null)
					{
						switch(i)
						{
							case 0:
								list.add(tt.getPart(1 + leftButtonPosX));
								break;
							case 1:
								list.add(tt.getPart(3 + leftButtonPosX));
								break;
							case 2:
								list.add(tt.getPart(2 + leftButtonPosX));
								break;

							case 3:
								list.add(tt.getPartName(leftSelect + 1, (rightButtonPosX + ((rightButtonPosY % 3) * 16))));
								break;
							case 4:
								list.add(tt.getPartName(leftSelect + 1, (rightButtonPosX + 1 + ((rightButtonPosY % 3) * 16))));
								break;
							case 5:
								list.add(tt.getPartName(leftSelect + 1, (rightButtonPosX + 2 + ((rightButtonPosY % 3) * 16))));
								break;
						}

						if(list.get(0).contains("Metallurgy"))
						{
							list.add(" -by Shadowclaimer");
						}
						func_146283_a(list, x, y);
					}
					else if(bigCopy.getItem() instanceof ArmorCore)
					{
						final NBTTagCompound aTags = bigCopy.getTagCompound().getCompoundTag("ArmorRenderer");
						final ArmorCore armor = (ArmorCore) bigCopy.getItem();
						final List<ModelRenderer> boxes = armor.getRenderer().boxList;

						switch(i)
						{
							case 0:
							case 1:
							case 2:
								break;

							case 3:
								list.add(boxes.get(rightButtonPosX + 9).boxName);
								break;
							case 4:
								list.add(boxes.get(rightButtonPosX + 1 + 9).boxName);
								break;
							case 5:
								list.add(boxes.get(rightButtonPosX + 2 + 9).boxName);
								break;
						}
						func_146283_a(list, x, y);
					}
					else
					{
						list.add("Error - No name/desc!");
						func_146283_a(list, x, y);
					}
				}
			}
		}
	}
}
