package lance5057.tDefense.core.workstations.gui.finishinganvil;

import java.io.IOException;

import lance5057.tDefense.core.library.ArmorBuildGuiInfo;
import lance5057.tDefense.core.library.ArmorTags;
import lance5057.tDefense.core.library.TDClientRegistry;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.client.Icons;
import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
import slimeknights.tconstruct.library.tinkering.TinkersItem;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolBuilder;
import slimeknights.tconstruct.tools.common.client.GuiButtonItem;
import slimeknights.tconstruct.tools.common.client.module.GuiSideButtons;

public class FinishingAnvilGuiButtons extends GuiSideButtons {

	protected final FinishingAnvilGui parent;
	protected int layer;

	public FinishingAnvilGuiButtons(FinishingAnvilGui parent, Container container, int layer) {
		super(parent, container, FinishingAnvilGui.Column_Count);

		this.parent = parent;
		this.layer = layer;
	}

	protected int selected = 0;

	private int style = 0;

	@Override
	public void updatePosition(int parentX, int parentY, int parentSizeX, int parentSizeY) {
		super.updatePosition(parentX, parentY, parentSizeX, parentSizeY);

		int index = 0;
		buttonCount = 0;
		this.buttonList.clear();

//    {
//      GuiButtonItem<ArmorBuildGuiInfo> button = new ArmorStationGuiButtonRepair(index++, -1, -1);
//      shiftButton(button, 0, -18 * style);
//      addSideButton(button);
//    }

		if (parent.inventorySlots.inventorySlots.get(1).getStack().getItem() instanceof TinkersItem) {
			TinkersItem item = (TinkersItem) parent.inventorySlots.inventorySlots.get(1).getStack().getItem();
			ItemStack stack = parent.inventorySlots.inventorySlots.get(1).getStack().copy();
			int info = TDClientRegistry.getVarient(item);
			if (info != 0) {
				for (int i = 0; i < info+1; i++) {

					NBTTagCompound tag = TagUtil.getTagSafe(stack.copy());
					if (!tag.hasKey(ArmorTags.AnvilBase)) {
						tag.setTag(ArmorTags.AnvilBase, new NBTTagCompound());
					}
					NBTTagCompound anvil = tag.getCompoundTag(ArmorTags.AnvilBase);
					//int b = (i << (layer * 8));
					//int bit = anvil.getInteger(ArmorTags.ModelType) | b;
					anvil.setInteger(ArmorTags.ModelType, i);
					tag.setTag(ArmorTags.AnvilBase, anvil);

					ItemStack outStack = new ItemStack(item);
					// TagUtil.setBaseTag(outStack, tag);
					outStack.setTagCompound(tag);

					GuiButtonItem button = new GuiButtonItem(index++, -1, -1, outStack, "");
					shiftButton(button, 0, -18 * style);
					addSideButton(button);
					

					if (index - 1 == selected) {
						button.pressed = true;
					}
				}
			}
		}

		super.updatePosition(parentX, parentY, parentSizeX, parentSizeY);

		// activate currently selected/default
		parent.updateGUI();
	}

//	public void setSelectedButtonByTool(ItemStack stack) {
//		for (Object o : buttonList) {
//			if (o instanceof GuiButtonItem) {
//				@SuppressWarnings("unchecked")
//				GuiButtonItem btn = (GuiButtonItem) o;
//				btn.pressed = ItemStack.areItemStacksEqual(btn.data.armor, stack);
//			}
//		}
//	}

	@Override
	@SuppressWarnings("unchecked")
	protected void actionPerformed(GuiButton button) throws IOException {
		for (Object o : buttonList) {
			if (o instanceof GuiButtonItem) {
				((GuiButtonItem) o).pressed = false;
			}
		}
		if (button instanceof GuiButtonItem) {
			((GuiButtonItem) button).pressed = true;
			selected = button.id;

			parent.onToolSelection();
		}
	}

	@SuppressWarnings("unchecked")
	public void wood() {
		for (Object o : buttonList) {
			shiftButton((GuiButtonItem) o, 0, -36);
		}

		style = 2;
	}

	@SuppressWarnings("unchecked")
	public void metal() {
		for (Object o : buttonList) {
			shiftButton((GuiButtonItem) o, 0, -18);
		}

		style = 1;
	}

	protected void shiftButton(GuiButtonItem button, int xd, int yd) {
		button.setGraphics(Icons.ICON_Button.shift(xd, yd), Icons.ICON_ButtonHover.shift(xd, yd),
				Icons.ICON_ButtonPressed.shift(xd, yd), Icons.ICON);
	}
	
	@Override
	  protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	  {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
	  }
}