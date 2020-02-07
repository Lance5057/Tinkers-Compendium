package lance5057.tDefense.core.workstations.gui.finishinganvil;

import javax.annotation.Nonnull;

import lance5057.tDefense.core.library.alwaysShowResult;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class FinishingAnvilSlotOut extends Slot {

  public FinishingAnvilContainer parent;

  public FinishingAnvilSlotOut(int index, int xPosition, int yPosition, FinishingAnvilContainer container) {
    super(new alwaysShowResult(), index, xPosition, yPosition);

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