package lance5057.tDefense.finishingAnvil.blocks.finishingAnvil;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import lance5057.tDefense.core.network.Message_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.utilities.Injector;
import lance5057.tDefense.finishingAnvil.utilities.ToolCoreTip;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
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
	private ItemStack						bigCopy;
	NBTTagCompound							bigCopyTags;
	private final RenderItem				bigRender		= new RenderItem_FinishingAnvil(
																	this,
																	3.5f,
																	3.5f, 1.0f);

	private ItemStack						rightCopy1, rightCopy2, rightCopy3;
	NBTTagCompound							rightCopyTags1, rightCopyTags2,
											rightCopyTags3;
	private final RenderItem				normalRender	= new RenderItem_FinishingAnvil(
																	this, 1.0f,
																	1.0f, 1.0f);

	//private Boolean							isNull			= true;
	private ItemStack						editItem;

	public final TileEntity_FinishingAnvil	inventory;
	private ResourceLocation				forGui;

	private int								leftButtonPosX	= 0;
	private int								leftSelect		= 0;

	private int								rightButtonPos	= 0;
	private final int						rightSelect		= 0;

	String[]								renders;

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
				""));
		buttonList.add(new GuiButtonExt(2, guiLeft + 25, guiTop + 61, 10, 10,
				""));
		buttonList.add(new GuiButtonExt(3, guiLeft + 38, guiTop + 53, 18, 18,
				""));

		buttonList.add(new GuiButtonExt(4, guiLeft + 5, guiTop + 11, 20, 20, ""));
		buttonList.add(new GuiButtonExt(5, guiLeft + 5, guiTop + 31, 20, 20, ""));
		buttonList.add(new GuiButtonExt(6, guiLeft + 5, guiTop + 51, 20, 20, ""));

		buttonList.add(new GuiButtonExt(7, guiLeft + 141, guiTop + 11, 10, 10,
				""));
		buttonList.add(new GuiButtonExt(8, guiLeft + 141, guiTop + 61, 10, 10,
				""));

		buttonList.add(new GuiButtonExt(9, guiLeft + 151, guiTop + 11, 20, 20,
				""));
		buttonList.add(new GuiButtonExt(10, guiLeft + 151, guiTop + 31, 20, 20,
				""));
		buttonList.add(new GuiButtonExt(11, guiLeft + 151, guiTop + 51, 20, 20,
				""));

		buttonList.add(new GuiButtonExt(12, guiLeft + 38, guiTop + 11, 18, 18,
				""));
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
		if(bigCopy != null && bigCopyTags != null)
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
					rightButtonPos = 0;
					setRenders();
					break;
				case 5:
					leftSelect = 1 + leftButtonPosX;
					rightButtonPos = 0;
					setRenders();
					break;
				case 6:
					leftSelect = 2 + leftButtonPosX;
					rightButtonPos = 0;
					setRenders();
					break;

				case 7:
					if(rightButtonPos > 0)
					{
						rightButtonPos--;
					}
					setRenders();
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
				if(bigCopyTags.hasKey("Render" + renders[leftSelect]))
				{
					bigCopyTags.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + (rightButtonPos * TinkersDefense.config.MaterialIndex));
					if(rightButtonPos > 0)
					{
						bigCopyTags.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(bigCopyTags.getInteger(renders[leftSelect])).primaryColor());
					}
					else
					{
						bigCopyTags.removeTag(renders[leftSelect] + "Color");
					}
				}
				break;

			case 10:
				if(bigCopyTags.hasKey("Render" + renders[leftSelect]))
				{
					bigCopyTags.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPos + 1) * TinkersDefense.config.MaterialIndex));
					bigCopyTags.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(bigCopyTags.getInteger(renders[leftSelect])).primaryColor());
				}
				break;

			case 11:
				if(bigCopyTags.hasKey("Render" + renders[leftSelect]))
				{
					bigCopyTags.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPos + 2) * TinkersDefense.config.MaterialIndex));
					bigCopyTags.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(bigCopyTags.getInteger(renders[leftSelect])).primaryColor());
				}
				break;

			case 12:
				bigCopyTags.setInteger("RenderHead", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[0]));
				bigCopyTags.setInteger("RenderAccessory", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[1]));
				bigCopyTags.setInteger("RenderHandle", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[2]));
				bigCopyTags.setInteger("RenderExtra", bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[3]));

				bigCopyTags.removeTag(renders[0] + "Color");
				bigCopyTags.removeTag(renders[1] + "Color");
				bigCopyTags.removeTag(renders[2] + "Color");
				bigCopyTags.removeTag(renders[3] + "Color");

				setRenders();
				break;

			case 8:
				rightButtonPos++;
				setRenders();
				break;

		}
	}

	public void doArmorEdit(int id)
	{
		NBTTagCompound aTags = bigCopy.getTagCompound().getCompoundTag("ArmorRenderer");
		final ArmorCore armor = (ArmorCore) bigCopy.getItem();
		final List<ModelRenderer> boxes = armor.getRenderer().boxList;

		switch(id)
		{
			case 9:
				aTags.setBoolean(boxes.get(rightButtonPos + 9).boxName, !aTags.getBoolean(boxes.get(rightButtonPos + 9).boxName));
				break;

			case 10:
				aTags.setBoolean(boxes.get(rightButtonPos + 1 + 9).boxName, !aTags.getBoolean(boxes.get(rightButtonPos + 1 + 9).boxName));
				break;

			case 11:
				aTags.setBoolean(boxes.get(rightButtonPos + 2 + 9).boxName, !aTags.getBoolean(boxes.get(rightButtonPos + 2 + 9).boxName));
				break;

			case 12:
				aTags = armor.getRenderer().defaultTags;
				break;

			case 8:
				if(rightButtonPos < boxes.size() - 12)
				{
					rightButtonPos++;
				}
				break;

		}
	}

	@Override
	public void drawScreen(int x, int y, float par3)
	{

		if(inventory.getStackInSlot(0) != null && inventory.getStackInSlot(0).getItem() instanceof ToolCore)
		{
			if(bigCopy == null)
			{
				rightButtonPos = 0;
				leftButtonPosX = 0;
				bigCopy = inventory.getStackInSlot(0).copy();
				if(bigCopy.hasTagCompound() && bigCopy.getTagCompound().hasKey("InfiTool"))
				{
					bigCopyTags = bigCopy.getTagCompound().getCompoundTag("InfiTool");
				}
				setRenders();
			}
			else if(bigCopy != null && inventory.getStackInSlot(0).getItem() != bigCopy.getItem() || inventory.getStackInSlot(0).getItemDamage() != bigCopy.getItemDamage())
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
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{

		mc.getTextureManager().bindTexture(iconLocation);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		drawTexturedModalRect(144, 14, 5, 167, 5, 3);
		drawTexturedModalRect(144, 64, 0, 167, 5, 3);
		drawTexturedModalRect(39, 54, 32, 176, 16, 16);
		drawTexturedModalRect(39, 12, 48, 176, 16, 16);
		drawTexturedModalRect(28, 14, 5, 167, 5, 3);
		drawTexturedModalRect(28, 64, 0, 167, 5, 3);
		drawTexturedModalRect(121, 54, 16, 176, 16, 16);

		if(bigCopy != null)
		{

			if(!(bigCopy.getItem() instanceof ArmorCore))
			{
				if(renderFlat)
				{
					if(leftSelect > 2)
					{
						drawTexturedModalRect(7, 13, 16, 192, 16, 16);
						drawTexturedModalRect(7, 33, 32, 192, 16, 16);
						drawTexturedModalRect(7, 53, 48, 192, 16, 16);
					}
					else
					{
						drawTexturedModalRect(7, 13, 0, 192, 16, 16);
						drawTexturedModalRect(7, 33, 16, 192, 16, 16);
						drawTexturedModalRect(7, 53, 32, 192, 16, 16);
					}

					((GuiButtonExt) buttonList.get(14)).enabled = false;
					((GuiButtonExt) buttonList.get(15)).enabled = false;
					((GuiButtonExt) buttonList.get(12)).displayString = "3D";

					normalRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), rightCopy1, 153, 13);
					normalRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), rightCopy2, 153, 33);
					normalRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), rightCopy3, 153, 53);

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

				//drawTexturedModalRect(153, 13, xRIcon_one + (rightButtonPos * 16), yRIcon_one + (rightButtonPosY * 16), 16, 16);

				drawTexturedModalRect(153, 13, 64 + ((aTags.getBoolean(boxes.get(rightButtonPos + 9).boxName) ? 0 : 1) * 16), 176, 16, 16);
				drawTexturedModalRect(153, 33, 64 + ((aTags.getBoolean(boxes.get(rightButtonPos + 1 + 9).boxName) ? 0 : 1) * 16), 176, 16, 16);
				drawTexturedModalRect(153, 53, 64 + ((aTags.getBoolean(boxes.get(rightButtonPos + 2 + 9).boxName) ? 0 : 1) * 16), 176, 16, 16);

			}

			if(renderFlat)
			{
				bigRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), bigCopy, 17, 4);
			}

		}

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		mc.getTextureManager().bindTexture(iconLocation);
		final int k = ((width - xSize) / 2);
		final int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize + 80, ySize);

		if(!renderFlat)
		{
			if(bigCopy != null && bigCopy.getItem() instanceof ArmorCore)
			{
				((GuiButtonExt) buttonList.get(14)).enabled = true;
				((GuiButtonExt) buttonList.get(15)).enabled = true;

				((GuiButtonExt) buttonList.get(12)).displayString = "2D";

				final ArmorCore armor = (ArmorCore) bigCopy.getItem();

				final ArmorRenderer renderer = (ArmorRenderer) armor.getArmorModel(null, bigCopy, 0);
				renderer.isChild = false;

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
					final ResourceLocation rc = new ResourceLocation(
							Minecraft.getMinecraft().thePlayer.getLocationSkin().toString());

					FMLClientHandler.instance().getClient().renderEngine.bindTexture(rc);
					//					final ITextureObject tex = FMLClientHandler.instance().getClient().getTextureManager().getTexture(rc);
					//					if(tex.getGlTextureId() == 1)
					//					{
					//						rc = new ResourceLocation(
					//								"minecraft:textures/entity/steve.png");
					//						FMLClientHandler.instance().getClient().renderEngine.bindTexture(rc);
					//					}

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
				final List<String> list = new ArrayList();

				if(bigCopy.getItem() instanceof ArmorCore)
				{
					bigCopy.getTagCompound().getCompoundTag("ArmorRenderer");
					final ArmorCore armor = (ArmorCore) bigCopy.getItem();
					final List<ModelRenderer> boxes = armor.getRenderer().boxList;

					switch(i)
					{
						case 0:
						case 1:
						case 2:
							break;

						case 3:
							list.add(boxes.get(rightButtonPos + 9).boxName);
							break;
						case 4:
							list.add(boxes.get(rightButtonPos + 1 + 9).boxName);
							break;
						case 5:
							list.add(boxes.get(rightButtonPos + 2 + 9).boxName);
							break;
					}
					func_146283_a(list, x, y);
				}
				else if(bigCopy != null && bigCopy.getItem() instanceof ToolCore)
				{
					final ToolCore tool = (ToolCore) bigCopy.getItem();
					final String toolName = tool.getUnlocalizedName().toLowerCase().substring(tool.getUnlocalizedName().lastIndexOf('.') + 1, tool.getUnlocalizedName().length());
					final ToolCoreTip tt = ((Injector) TinkersDefense.tcInject).tools.get(toolName);

					if(tt != null)
					{
						switch(i)
						{
							case 0:
								list.add(tt.getPart(1 + leftButtonPosX));
								break;
							case 2:
								list.add(tt.getPart(3 + leftButtonPosX));
								break;
							case 1:
								list.add(tt.getPart(2 + leftButtonPosX));
								break;

							case 3:
								list.add(tt.getPartName(leftSelect + 1, (rightButtonPos)));
								break;
							case 4:
								list.add(tt.getPartName(leftSelect + 1, (rightButtonPos + 1)));
								break;
							case 5:
								list.add(tt.getPartName(leftSelect + 1, (rightButtonPos + 2)));
								break;
						}

						if(list.get(0).contains("m5"))
						{
							list.add(" -by Shadowclaimer");
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

	void setRenders()
	{
		rightCopy1 = bigCopy.copy();
		rightCopyTags1 = (NBTTagCompound) bigCopyTags.copy();
		rightCopyTags1.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPos) * TinkersDefense.config.MaterialIndex));
		rightCopyTags1.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(bigCopyTags.getInteger(renders[leftSelect])).primaryColor());
		rightCopy1.getTagCompound().setTag("InfiTool", rightCopyTags1);

		rightCopy2 = bigCopy.copy();
		rightCopyTags2 = (NBTTagCompound) bigCopyTags.copy();
		rightCopyTags2.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPos + 1) * TinkersDefense.config.MaterialIndex));
		rightCopyTags2.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(bigCopyTags.getInteger(renders[leftSelect])).primaryColor());
		rightCopy2.getTagCompound().setTag("InfiTool", rightCopyTags2);

		rightCopy3 = bigCopy.copy();
		rightCopyTags3 = (NBTTagCompound) bigCopyTags.copy();
		rightCopyTags3.setInteger("Render" + renders[leftSelect], bigCopy.getTagCompound().getCompoundTag("InfiTool").getInteger(renders[leftSelect]) + ((rightButtonPos + 2) * TinkersDefense.config.MaterialIndex));
		rightCopyTags3.setInteger(renders[leftSelect] + "Color", TConstructRegistry.getMaterial(bigCopyTags.getInteger(renders[leftSelect])).primaryColor());
		rightCopy3.getTagCompound().setTag("InfiTool", rightCopyTags3);
	}
}
