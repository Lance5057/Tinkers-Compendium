package lance5057.tDefense.core.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import slimeknights.tconstruct.tools.common.inventory.ContainerToolStation;

import javax.annotation.Nonnull;

public class ArmorStationSlotOut extends Slot {

  public ArmorStationContainer parent;

  public ArmorStationSlotOut(int index, int xPosition, int yPosition, ArmorStationContainer container) {
    super(new InventoryCraftResult(), index, xPosition, yPosition);

    this.parent = container;
  }

  @Override
  public boolean isItemValid(ItemStack stack) {
    return false;
  }

  @Nonnull
  @Override
  public ItemStack onTake(EntityPlayer playerIn, @Nonnull ItemStack stack) {
    FMLCommonHandler.instance().firePlayerCraftingEvent(playerIn, stack, parent.getTile());
    parent.onResultTaken(playerIn, stack);
    stack.onCrafting(playerIn.getEntityWorld(), playerIn, 1);

    return super.onTake(playerIn, stack);
  }
}