package lance5057.tDefense.core.library;

import java.util.List;

import javax.annotation.Nonnull;

import org.lwjgl.util.Point;

import com.google.common.collect.Lists;

import lance5057.tDefense.core.tools.bases.ArmorBase;
import net.minecraft.item.ItemStack;

public class ArmorBuildGuiInfo {

  @Nonnull
  public final ItemStack armor;
  // the positions where the slots are located
  public final List<Point> positions = Lists.newArrayList();

  public ArmorBuildGuiInfo() {
    // for repairing
    this.armor = ItemStack.EMPTY;
  }

  public ArmorBuildGuiInfo(@Nonnull ArmorBase tool) {
    this.armor = tool.buildItemForRenderingInGui();
  }

  public static ArmorBuildGuiInfo default3Part(@Nonnull ArmorBase tool) {
    ArmorBuildGuiInfo info = new ArmorBuildGuiInfo(tool);
    info.addSlotPosition(33 - 20, 42 + 20);
    info.addSlotPosition(33 + 20, 42 - 20);
    info.addSlotPosition(33, 42);
    return info;
  }

  /**
   * Add another slot at the specified position for the tool.
   * The positions are usually located between:
   * X: 7 - 69
   * Y: 18 - 64
   */
  public void addSlotPosition(int x, int y) {
    positions.add(new Point(x, y));
  }

}