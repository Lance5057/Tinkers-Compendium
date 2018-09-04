package lance5057.tDefense.core.gui.armorstation;

import java.io.IOException;

import lance5057.tDefense.core.library.ArmorBuildGuiInfo;
import lance5057.tDefense.core.library.TDClientRegistry;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.client.Icons;
import slimeknights.tconstruct.tools.common.client.GuiButtonItem;
import slimeknights.tconstruct.tools.common.client.module.GuiSideButtons;

public class ArmorStationGuiButtons extends GuiSideButtons {

  protected final ArmorStationGui parent;

  public ArmorStationGuiButtons(ArmorStationGui parent, Container container) {
    super(parent, container, ArmorStationGui.Column_Count);

    this.parent = parent;
  }

  protected int selected = 0;

  private int style = 0;


  @Override
  public void updatePosition(int parentX, int parentY, int parentSizeX, int parentSizeY) {
    super.updatePosition(parentX, parentY, parentSizeX, parentSizeY);

    int index = 0;
    buttonCount = 0;

    {
      GuiButtonItem<ArmorBuildGuiInfo> button = new ArmorStationGuiButtonRepair(index++, -1, -1);
      shiftButton(button, 0, -18 * style);
      addSideButton(button);
    }

    for(Item item : parent.getBuildableItems()) {
      ArmorBuildGuiInfo info = TDClientRegistry.getArmorBuildInfoForArmor(item);
      if(info != null) {
        GuiButtonItem<ArmorBuildGuiInfo> button = new GuiButtonItem<ArmorBuildGuiInfo>(index++, -1, -1, info.armor, info);
        shiftButton(button, 0, -18 * style);
        addSideButton(button);

        if(index - 1 == selected) {
          button.pressed = true;
        }
      }
    }

    super.updatePosition(parentX, parentY, parentSizeX, parentSizeY);

    // activate currently selected/default
    parent.updateGUI();
  }

  public void setSelectedButtonByTool(ItemStack stack) {
    for(Object o : buttonList) {
      if(o instanceof GuiButtonItem) {
        @SuppressWarnings("unchecked")
        GuiButtonItem<ArmorBuildGuiInfo> btn = (GuiButtonItem<ArmorBuildGuiInfo>) o;
        btn.pressed = ItemStack.areItemStacksEqual(btn.data.armor, stack);
      }
    }
  }


  @Override
  @SuppressWarnings("unchecked")
  protected void actionPerformed(GuiButton button) throws IOException {
    for(Object o : buttonList) {
      if(o instanceof GuiButtonItem) {
        ((GuiButtonItem<ArmorBuildGuiInfo>) o).pressed = false;
      }
    }
    if(button instanceof GuiButtonItem) {
      ((GuiButtonItem<ArmorBuildGuiInfo>) button).pressed = true;
      selected = button.id;

      parent.onToolSelection(((GuiButtonItem<ArmorBuildGuiInfo>) button).data);
    }
  }

  @SuppressWarnings("unchecked")
  public void wood() {
    for(Object o : buttonList) {
      shiftButton((GuiButtonItem<ArmorBuildGuiInfo>) o, 0, -36);
    }

    style = 2;
  }

  @SuppressWarnings("unchecked")
  public void metal() {
    for(Object o : buttonList) {
      shiftButton((GuiButtonItem<ArmorBuildGuiInfo>) o, 0, -18);
    }

    style = 1;
  }

  protected void shiftButton(GuiButtonItem<ArmorBuildGuiInfo> button, int xd, int yd) {
    button.setGraphics(Icons.ICON_Button.shift(xd, yd),
                       Icons.ICON_ButtonHover.shift(xd, yd),
                       Icons.ICON_ButtonPressed.shift(xd, yd),
                       Icons.ICON);
  }
}