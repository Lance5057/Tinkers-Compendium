package lance5057.tDefense.core.workstations.gui.finishinganvil;

import lance5057.tDefense.core.library.ArmorBuilder;
import lance5057.tDefense.core.workstations.tileentities.FinishingAnvilTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import slimeknights.mantle.inventory.ContainerMultiModule;
import slimeknights.mantle.util.ItemStackList;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.library.events.TinkerCraftingEvent;
import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
import slimeknights.tconstruct.tools.common.inventory.SlotToolStationIn;

public class FinishingAnvilContainer extends ContainerMultiModule<FinishingAnvilTile> {

	private final EntityPlayer player;
	protected FinishingAnvilSlotOut out;

	public FinishingAnvilContainer(InventoryPlayer inventoryPlayer, FinishingAnvilTile tile) {
		super(tile);

		player = inventoryPlayer.player;

		addSlotToContainer(new SlotToolStationIn(tile, 0, 0, 0, this));
		out = new FinishingAnvilSlotOut(1, 124, 38, this);
		addSlotToContainer(out);

		this.addPlayerInventory(inventoryPlayer, 8, 84);

	}

	public void onResultTaken(EntityPlayer playerIn, ItemStack stack) {
		boolean resultTaken = false;

//	    try {
//	      resultTaken = !repairTool(true).isEmpty() ||
//	                    !replaceToolParts(true).isEmpty() ||
//	                    !modifyTool(true).isEmpty() ||
//	                    !renameTool().isEmpty();
//	    } catch(TinkerGuiException e) {
//	      // no error updating needed
//	      e.printStackTrace();
//	    }

		if (resultTaken) {
			updateSlotsAfterToolAction();
		} else {
			// calculate the result again (serverside)
			try {
				ItemStack tool = buildTool();

				// we built a tool
				if (!tool.isEmpty()) {
					// remove 1 of each in the slots
					// it's guaranteed that each slot that has an item has used exactly 1 item to
					// build the tool
					for (int i = 0; i < tile.getSizeInventory(); i++) {
						tile.decrStackSize(i, 1);
					}

					// setToolName("");
				}
			} catch (TinkerGuiException e) {
				// no error updating needed
				e.printStackTrace();
			}
		}
		onCraftMatrixChanged(null);

		this.playCraftSound(playerIn);
	}

	private void updateSlotsAfterToolAction() {
		// perfect, items already got removed but we still have to clean up 0-stacks and
		// remove the tool
		tile.setInventorySlotContents(0, ItemStack.EMPTY); // slot where the tool was
		for (int i = 1; i < tile.getSizeInventory(); i++) {
			if (!tile.getStackInSlot(i).isEmpty() && tile.getStackInSlot(i).getCount() == 0) {
				tile.setInventorySlotContents(i, ItemStack.EMPTY);
			}
		}
	}

	private ItemStack buildTool() throws TinkerGuiException {
		NonNullList<ItemStack> input = ItemStackList.withSize(tile.getSizeInventory());
		for (int i = 0; i < input.size(); i++) {
			input.set(i, tile.getStackInSlot(i));
		}

		ItemStack result = new ItemStack(Items.AIR); // TODO Fix
		if (!result.isEmpty()) {
			TinkerCraftingEvent.ToolCraftingEvent.fireEvent(result, player, input);
		}
		return result;
	}

//	public void setToolName(String name) {
//	    this.toolName = name;
//
//	    if(world.isRemote) {
//	      GuiScreen screen = Minecraft.getMinecraft().currentScreen;
//	      if(screen instanceof GuiToolStation) {
//	        ((GuiToolStation) screen).textField.setText(name);
//	      }
//	    }
//
//	    onCraftMatrixChanged(tile);
//	    if(out.getHasStack()) {
//	      if(name != null && !name.isEmpty()) {
//	        out.inventory.getStackInSlot(0).setStackDisplayName(name);
//	      }
//	      else {
//	        out.inventory.getStackInSlot(0).clearCustomName();
//	      }
//	    }
//	  }

	protected void playCraftSound(EntityPlayer player) {
		Sounds.playSoundForAll(player, Sounds.saw, 0.8f, 0.8f + 0.4f * TConstruct.random.nextFloat());
	}
}