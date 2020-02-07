package lance5057.tDefense.core.workstations.tileentities;

import lance5057.tDefense.core.workstations.gui.finishinganvil.FinishingAnvilContainer;
import lance5057.tDefense.core.workstations.gui.finishinganvil.FinishingAnvilGui;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.common.IInventoryGui;
import slimeknights.mantle.tileentity.TileInventory;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.shared.block.BlockTable;
import slimeknights.tconstruct.shared.block.PropertyTableItem;
import slimeknights.tconstruct.shared.inventory.ConfigurableInvWrapperCapability;
import slimeknights.tconstruct.tools.common.client.GuiButtonRepair;

public class FinishingAnvilTile extends TileInventory implements IInventoryGui {

  public FinishingAnvilTile() {
    super("gui.finishinganvil.name", 1);
    this.itemHandler = new ConfigurableInvWrapperCapability(this, false, false); 
  }

  @Override
  public Container createContainer(InventoryPlayer inventoryplayer, World world, BlockPos pos) {
    return new FinishingAnvilContainer(inventoryplayer, this); 
  } 

  @Override
  @SideOnly(Side.CLIENT)
  public GuiContainer createGui(InventoryPlayer inventoryplayer, World world, BlockPos pos) {
    return new FinishingAnvilGui(inventoryplayer, world, pos, this);
  }
}