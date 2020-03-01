package lance5057.tDefense.core.workstations.gui.finishinganvil;

import java.util.Set;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.library.ArmorTags;
import lance5057.tDefense.core.library.TCRegistry;
import lance5057.tDefense.core.network.FinishingAnvilSelectionPacket;
import lance5057.tDefense.core.tools.bases.ArmorBase;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.core.workstations.gui.armorstation.ArmorStationGuiButtonRepair;
import lance5057.tDefense.core.workstations.tileentities.FinishingAnvilTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.gui.GuiElement;
import slimeknights.mantle.client.gui.GuiElementScalable;
import slimeknights.mantle.client.gui.GuiMultiModule;
import slimeknights.tconstruct.common.TinkerNetwork;
import slimeknights.tconstruct.library.client.Icons;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.common.client.module.GuiInfoPanel;
import slimeknights.tconstruct.tools.common.inventory.SlotToolStationIn;

@SideOnly(Side.CLIENT)
public class FinishingAnvilGui extends GuiMultiModule {

	private static final ResourceLocation BACKGROUND = new ResourceLocation(Reference.MOD_ID,
			"textures/gui/finishinganvil.png");

	protected FinishingAnvilGuiButtons buttons;
	protected GuiInfoPanel toolInfo;

	public static final int Column_Count = 6;

	private static final GuiElement ArmorSlots = new GuiElement(152, 224, 104, 32);
	private static final GuiElement ToolDisplay = new GuiElement(188, 70, 68, 68);
	private static final GuiElement PlayerDisplay = new GuiElement(188, 138, 68, 86);

	private static final GuiElement TextFieldActive = new GuiElement(0, 210, 102, 12, 256, 256);
	private static final GuiElement ItemCover = new GuiElement(176, 18, 80, 64);
	private static final GuiElement SlotBackground = new GuiElement(176, 0, 18, 18);
	private static final GuiElement SlotBorder = new GuiElement(194, 0, 18, 18);

	private static final GuiElement SlotSpaceTop = new GuiElement(0, 174 + 2, 18, 2);
	private static final GuiElement SlotSpaceBottom = new GuiElement(0, 174, 18, 2);
	private static final GuiElement PanelSpaceL = new GuiElement(0, 174, 5, 4);
	private static final GuiElement PanelSpaceR = new GuiElement(9, 174, 9, 4);

	private static final GuiElement BeamLeft = new GuiElement(0, 180, 2, 7);
	private static final GuiElement BeamRight = new GuiElement(131, 180, 2, 7);
	private static final GuiElementScalable BeamCenter = new GuiElementScalable(2, 180, 129, 7);
	private static final int Table_slot_count = 6;

	protected GuiElement buttonDecorationTop = SlotSpaceTop;
	protected GuiElement buttonDecorationBot = SlotSpaceBottom;
	protected GuiElement panelDecorationL = PanelSpaceL;
	protected GuiElement panelDecorationR = PanelSpaceR;

	protected GuiElement beamL = new GuiElement(0, 0, 0, 0);
	protected GuiElement beamR = new GuiElement(0, 0, 0, 0);
	protected GuiElementScalable beamC = new GuiElementScalable(0, 0, 0, 0);

	protected GuiElement test = new GuiElement(0, 0, 0, 0);

	// protected ArmorStationGuiButtons buttons;
	protected int activeSlots; // how many of the available slots are active

	public GuiTextField textField;

	// protected GuiInfoPanel toolInfo;
	protected GuiInfoPanel traitInfo;

	public FinishingAnvilGui(InventoryPlayer playerInv, World world, BlockPos pos, FinishingAnvilTile tile) {
		super((FinishingAnvilContainer) tile.createContainer(playerInv, world, pos));
		// TODO Auto-generated constructor stub

		buttons = new FinishingAnvilGuiButtons(this, inventorySlots, 0);
		this.addModule(buttons);
		//buttons.xOffset = -(buttons.spacing);
		buttons.width = 18 * 2;

//		buttons1 = new FinishingAnvilGuiButtons(this, inventorySlots, 1);
//		buttons1.xOffset = -(buttons.spacing * 2 + 18 * 2);
//		this.addModule(buttons1);
//
//		buttons2 = new FinishingAnvilGuiButtons(this, inventorySlots, 1);
//		buttons2.xOffset = -(buttons.spacing * 4 + 18 * 4);
//		this.addModule(buttons2);
//
//		buttons3 = new FinishingAnvilGuiButtons(this, inventorySlots, 1);
//		buttons3.xOffset = -(buttons.spacing * 6 + 18 * 6);
//		this.addModule(buttons3);
//
//		buttons4 = new FinishingAnvilGuiButtons(this, inventorySlots, 1);
//		buttons4.xOffset = -(buttons.spacing * 8 + 18 * 8);
//		this.addModule(buttons4);

		toolInfo = new GuiInfoPanel(this, inventorySlots);
		this.addModule(toolInfo);

		test = new GuiElement(buttons.xOffset, buttons.yOffset, buttons.width, buttons.height);

		// buttons.addSideButton(new GuiButton(0, 0, 0, 32, 32, "")); // TODO make
		// custom sidebuttons module

		this.ySize = 174;

//		buttons.wood();
//		buttons2.wood();
		wood();
	}

	protected void wood() {
		toolInfo.wood();
		// traitInfo.wood();

		buttonDecorationTop = SlotSpaceTop.shift(SlotSpaceTop.w, 0);
		buttonDecorationBot = SlotSpaceBottom.shift(SlotSpaceBottom.w, 0);
		panelDecorationL = PanelSpaceL.shift(18, 0);
		panelDecorationR = PanelSpaceR.shift(18, 0);

		buttons.wood();
//		buttons1.wood();
//		buttons2.wood();
//		buttons3.wood();
//		buttons4.wood();

		beamL = BeamLeft;
		beamR = BeamRight;
		beamC = BeamCenter;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		drawBackground(BACKGROUND);

		ItemStack s = this.inventorySlots.inventorySlots.get(1).getStack();
		if (s.getItem() instanceof ToolCore) {
			ToolDisplay.draw(this.guiLeft + 54, this.guiTop + 16);
			this.drawItemStack(s, this.guiLeft + 65,
					this.guiTop + 25, 3);
		} else if (s.getItem() instanceof ArmorCore) {
			PlayerDisplay.draw(this.guiLeft + 54, this.guiTop + 4);
			// this.drawEntityOnScreen(this.guiLeft+88, this.guiTop+80, 35, this.guiLeft+88
			// - mouseX, this.guiTop+80 - mouseY, Minecraft.getMinecraft().player);
			this.renderArmor(this.guiLeft + 88, this.guiTop + 80, 30, this.guiLeft + 88 - mouseX,
					this.guiTop + 80 - mouseY, Minecraft.getMinecraft().player,
					s);
		}

		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/test.png"));
		test.draw(0, 0);

		this.mc.getTextureManager().bindTexture(BACKGROUND);

		updateSubmodule(buttons);
//		updateSubmodule(buttons1);
//		updateSubmodule(buttons2);
//		updateSubmodule(buttons3);
//		updateSubmodule(buttons4);
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);

	}

	private void drawItemStack(ItemStack stack, int x, int y, float scale) {
		GlStateManager.pushMatrix();
		// GlStateManager.translate(0.0F, 0.0F, 32.0F);
		GlStateManager.scale(scale, scale, 1);
		this.zLevel = 200.0F;
		this.itemRender.zLevel = 200.0F;
		this.itemRender.renderItemAndEffectIntoGUI(stack, (int) (x / scale), (int) (y / scale));
		// this.itemRender.renderItemOverlayIntoGUI(font, stack, x, y, altText);
		this.zLevel = 0.0F;
		this.itemRender.zLevel = 0.0F;
		GlStateManager.popMatrix();
	}

	public void onToolSelection() {

		NBTTagCompound tag = TagUtil.getTagSafe(this.inventorySlots.inventorySlots.get(1).getStack());
		if (!tag.hasKey(ArmorTags.AnvilBase)) {
			tag.setTag(ArmorTags.AnvilBase, new NBTTagCompound());
		}
		NBTTagCompound anvil = tag.getCompoundTag(ArmorTags.AnvilBase);
		//anvil.setInteger(ArmorTags.ModelType + "0", buttons.selected);
		
		//int bit = (buttons4.selected << 32) | (buttons3.selected << 24) | (buttons2.selected << 16) | (buttons1.selected << 8) | buttons.selected;
		anvil.setInteger(ArmorTags.ModelType, buttons.selected);
		
		tag.setTag(ArmorTags.AnvilBase, anvil);

		((FinishingAnvilContainer) inventorySlots).anvil0 = buttons.selected;
//		((FinishingAnvilContainer) inventorySlots).anvil1 = buttons1.selected;
//		((FinishingAnvilContainer) inventorySlots).anvil2 = buttons2.selected;
//		((FinishingAnvilContainer) inventorySlots).anvil3 = buttons3.selected;
//		((FinishingAnvilContainer) inventorySlots).anvil4 = buttons4.selected;

		TinkerNetwork.sendToServer(new FinishingAnvilSelectionPacket(buttons.selected));

		updateGUI();
	}

	public void updateGUI() {
		int i = 0;
//	    for(i = 0; i < activeSlots; i++) {
//	      //Point point = currentInfo.positions.get(i);
//
//	      Slot slot = inventorySlots.getSlot(i); 
//	      slot.xPos = point.getX();
//	      slot.yPos = point.getY();
//	    }

		// remaining slots
//		int stillFilled = 0;
//		for (; i < Table_slot_count; i++) {
//			Slot slot = inventorySlots.getSlot(i);
//
//			if (slot.getHasStack()) {
//				slot.xPos = 87 + 20 * stillFilled;
//				slot.yPos = 62;
//				stillFilled++;
//			} else {
//				// todo: slot.disable
//				slot.xPos = 0;
//				slot.yPos = 0;
//			}
//		}

		updateDisplay();
	}

	public void updateDisplay() {
		// tool info of existing or tool to build
		FinishingAnvilContainer container = (FinishingAnvilContainer) inventorySlots;
		// ItemStack toolStack = container.getResult();
//		if (toolStack.isEmpty()) {
//			toolStack = inventorySlots.getSlot(0).getStack();
//		}
//
//		// current tool to build or repair/modify
//		if (toolStack.getItem() instanceof IModifyable) {
//			if (toolStack.getItem() instanceof IToolStationDisplay) {
//				IToolStationDisplay tool = (IToolStationDisplay) toolStack.getItem();
//				toolInfo.setCaption(tool.getLocalizedToolName());
//				toolInfo.setText(tool.getInformation(toolStack));
//			} else {
//				toolInfo.setCaption(toolStack.getDisplayName());
//				toolInfo.setText();
//			}
//
//			traitInfo.setCaption(I18n.translateToLocal("gui.toolstation.traits"));
//
//			List<String> mods = Lists.newLinkedList();
//			List<String> tips = Lists.newLinkedList();
//			NBTTagList tagList = TagUtil.getModifiersTagList(toolStack);
//			for (int i = 0; i < tagList.tagCount(); i++) {
//				NBTTagCompound tag = tagList.getCompoundTagAt(i);
//				ModifierNBT data = ModifierNBT.readTag(tag);
//
//				// get matching modifier
//				IModifier modifier = TinkerRegistry.getModifier(data.identifier);
//				if (modifier == null || modifier.isHidden()) {
//					continue;
//				}
//
//				mods.add(data.getColorString() + modifier.getTooltip(tag, true));
//				tips.add(data.getColorString() + modifier.getLocalizedDesc());
//			}
//
//			if (mods.isEmpty()) {
//				mods.add(I18n.translateToLocal("gui.toolstation.noTraits"));
//			}
//
//			traitInfo.setText(mods, tips);
//		}
//		// repair info
////	    else if(currentInfo.armor.isEmpty()) {
////	      toolInfo.setCaption(I18n.translateToLocal("gui.toolstation.repair"));
////	      toolInfo.setText();
////
////	      traitInfo.setCaption(null);
////	      String c = TextFormatting.DARK_GRAY.toString();
////	      String[] art = new String[]{
////	          c + "",
////	          c + "",
////	          c + "       .",
////	          c + "     /( _________",
////	          c + "     |  >:=========`",
////	          c + "     )(  ",
////	          c + "     \"\""
////	      };
////	      traitInfo.setText(art);
////	    }
//		// tool build info
//		else {
		// ArmorCore tool = (ArmorCore) currentInfo.armor.getItem();
		toolInfo.setCaption("beep beep");
		toolInfo.setText("Im a sheep");

		// Components
//	      List<String> text = Lists.newLinkedList();
//	      List<PartMaterialType> pms = tool.getRequiredComponents();
//	      for(int i = 0; i < pms.size(); i++) {
//	        PartMaterialType pmt = pms.get(i);
//	        StringBuilder sb = new StringBuilder();
//
//	        ItemStack slotStack = container.getSlot(i).getStack();
//	        if(!pmt.isValid(slotStack)) {
//	          sb.append(TextFormatting.RED);
//
//	          // is an item in the slot?
//	          if(slotStack.getItem() instanceof IToolPart) {
//	            if(pmt.isValidItem((IToolPart) slotStack.getItem())) {
//	              // the item has an invalid material
//	              warning(Util.translate("gui.error.wrong_material_part"));
//	            }
//	          }
//	        }
//
//	        sb.append(" * ");
//	        for(IToolPart part : pmt.getPossibleParts()) {
//	          if(part instanceof Item) {
//	            sb.append(((Item) part).getItemStackDisplayName(new ItemStack((Item) part)));
//	            sb.append("/");
//	          }
//	        }
//	        sb.deleteCharAt(sb.length() - 1); // removes last '/'
//	        text.add(sb.toString());
//	      }
//			traitInfo.setCaption(I18n.translateToLocal("gui.toolstation.components"));
//			traitInfo.setText("test", "test2");
		// }
	}

	private void renderArmor(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent,
			ItemStack armor) {

		// drawEntityOnScreen(posX, posY, scale, mouseX, mouseY, ent);

		EntityArmorStand stand = new EntityArmorStand(ent.world);
		stand.setItemStackToSlot(((ArmorCore) armor.getItem()).getEquipmentSlot(), armor);

//		ModelBiped biped = ((ArmorCore) armor.getItem()).getArmorModel(ent, armor,
//				((ArmorCore) armor.getItem()).getEquipmentSlot(), null);

		GlStateManager.enableColorMaterial();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) posX, (float) posY, 50.0F);
		GlStateManager.scale((float) (-scale), (float) scale, (float) scale);
		GlStateManager.rotate(180.0F, 0, 1F, 0);
		GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
		// GlStateManager.rotate(-((float) Math.atan((double) (mouseY / 40.0F))) *
		// 20.0F, 1.0F, 0.0F, 0.0F);

		float f = ent.renderYawOffset;
		float f1 = ent.rotationYaw;
		float f2 = ent.rotationPitch;
		float f3 = ent.prevRotationYawHead;
		float f4 = ent.rotationYawHead;
		float f5 = ent.prevRotationPitch;

		ent.renderYawOffset = 0;
		ent.rotationYaw = 0;
		ent.rotationPitch = 0;
		ent.rotationYawHead = 0;
		ent.prevRotationYawHead = 0;
		ent.cameraPitch = 0;
		ent.prevCameraPitch = 0;
		ent.prevRotationPitch = 0;

		GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-((float) Math.atan((double) (mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(((float) Math.atan((double) (mouseX / 40.0F))) * 120.0F, 0.0F, 1.0F, 0.0F);
		float t = (float) Math.atan((double) (mouseX / 40.0F)) * 20.0F;
		float t2 = (float) Math.atan((double) (mouseX / 40.0F)) * 40.0F;
		// stand.rotationPitch = -((float) Math.atan((double) (mouseY / 40.0F))) *
		// 20.0F;
		// stand.rotationYawHead = stand.rotationYaw;
		// stand.prevRotationYawHead = stand.rotationYaw;

		GlStateManager.pushMatrix();
		GlStateManager.rotate(180.0F, 0, 0, 1f);
		GlStateManager.rotate(180.0F, 0, 1f, 0);
		GlStateManager.translate(0.0F, 0.2F, 0.0F);
		RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
		rendermanager.setPlayerViewY(180.0F);
		// rendermanager.setRenderShadow(false);
		rendermanager.renderEntity(stand, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
		GlStateManager.popMatrix();

		// GlStateManager.scale(0.15f,0.15f,0.15f);

//		this.mc.getTextureManager()
//				.bindTexture(new ResourceLocation(((ArmorCore) armor.getItem()).getArmorTexture(armor, ent, null, "")));
//		biped.render(ent, 0, 0, 0, 0, 0, 1f);

		ent.renderYawOffset = f;
		ent.rotationYaw = f1;
		ent.rotationPitch = f2;
		ent.prevRotationYawHead = f3;
		ent.rotationYawHead = f4;
		ent.prevRotationPitch = f5;

		GlStateManager.popMatrix();
		RenderHelper.disableStandardItemLighting();
		GlStateManager.disableRescaleNormal();
		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GlStateManager.disableTexture2D();
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);

		stand.setDead();
	}

	public Set<ArmorCore> getBuildableItems() {
		return TCRegistry.getArmorStationCrafting();
	}
}