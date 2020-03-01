package lance5057.tDefense.core.workstations.gui.finishinganvil;

import javax.annotation.Nullable;

import lance5057.tDefense.core.library.ArmorTags;
import lance5057.tDefense.core.network.ArmorStationSelectionPacket;
import lance5057.tDefense.core.network.FinishingAnvilSelectionPacket;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.core.workstations.gui.armorstation.ArmorStationContainer;
import lance5057.tDefense.core.workstations.tileentities.FinishingAnvilTile;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.gui.GuiElement;
import slimeknights.mantle.inventory.BaseContainer;
import slimeknights.mantle.inventory.ContainerMultiModule;
import slimeknights.mantle.util.ItemStackList;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.common.TinkerNetwork;
import slimeknights.tconstruct.library.events.TinkerCraftingEvent;
import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.common.inventory.SlotToolStationIn;
import slimeknights.tconstruct.tools.common.network.ToolStationTextPacket;

public class FinishingAnvilContainer extends ContainerMultiModule<FinishingAnvilTile> {

	private final EntityPlayer player;
	protected FinishingAnvilSlotOut out;

	public int anvil0 = 0;
	public int anvil1 = 0;
	public int anvil2 = 0;
	public int anvil3 = 0;
	public int anvil4 = 0;

	private static final EntityEquipmentSlot[] VALID_EQUIPMENT_SLOTS = new EntityEquipmentSlot[] {
			EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET };

	private static final GuiElement ToolDisplay = new GuiElement(188, 70, 68, 68);
	private static final GuiElement PlayerDisplay = new GuiElement(188, 138, 68, 86);

	public FinishingAnvilContainer(InventoryPlayer inventoryPlayer, FinishingAnvilTile tile) {
		super(tile);

		player = inventoryPlayer.player;

		addSlotToContainer(new SlotToolStationIn(tile, 0, 20, 38, this));
		out = new FinishingAnvilSlotOut(1, 124 + 15, 38, this);
		addSlotToContainer(out);

		for (int k = 0; k < 4; ++k) {
			final EntityEquipmentSlot entityequipmentslot = VALID_EQUIPMENT_SLOTS[k];
			this.addSlotToContainer(new Slot(inventoryPlayer, 36 + (3 - k), 8 + k * 18, 181) {
				/**
				 * Returns the maximum stack size for a given slot (usually the same as
				 * getInventoryStackLimit(), but 1 in the case of armor slots)
				 */
				public int getSlotStackLimit() {
					return 1;
				}

				/**
				 * Check if the stack is allowed to be placed in this slot, used for armor slots
				 * as well as furnace fuel.
				 */
				public boolean isItemValid(ItemStack stack) {
					return stack.getItem().isValidArmor(stack, entityequipmentslot, player);
				}

				/**
				 * Return whether this slot's stack can be taken from this slot.
				 */
				public boolean canTakeStack(EntityPlayer playerIn) {
					ItemStack itemstack = this.getStack();
					return !itemstack.isEmpty() && !playerIn.isCreative()
							&& EnchantmentHelper.hasBindingCurse(itemstack) ? false : super.canTakeStack(playerIn);
				}

				@Nullable
				@SideOnly(Side.CLIENT)
				public String getSlotTexture() {
					return ItemArmor.EMPTY_SLOT_NAMES[entityequipmentslot.getIndex()];
				}
			});
		}

		this.addPlayerInventory(inventoryPlayer, 8, 84 + 8);

	}

	// update crafting - called whenever the content of an input slot changes
	@Override
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		// reset gui state
		// updateGUI();
		try {
			ItemStack result;

			result = buildTool();

			out.inventory.setInventorySlotContents(0, result);
			// updateGUI();
		} catch (TinkerGuiException e) {
			// error ;(
			out.inventory.setInventorySlotContents(0, ItemStack.EMPTY);
			// this.error(e.getMessage());
		}
		// sync output with other open containers on the server
		if (!this.world.isRemote) {
			WorldServer server = (WorldServer) this.world;
			for (EntityPlayer player : server.playerEntities) {
				if (player.openContainer != this && player.openContainer instanceof FinishingAnvilContainer
						&& this.sameGui((FinishingAnvilContainer) player.openContainer)) {
					((FinishingAnvilContainer) player.openContainer).out.inventory.setInventorySlotContents(0,
							out.getStack());
				}
			}
		}
	}

	@Override
	protected void syncNewContainer(EntityPlayerMP player) {
		// this.activeSlots = tile.getSizeInventory();
		TinkerNetwork.sendTo(
				new FinishingAnvilSelectionPacket(this.anvil0),
				player);
	}

	@Override
	protected void syncWithOtherContainer(BaseContainer<FinishingAnvilTile> otherContainer, EntityPlayerMP player) {
		this.syncWithOtherContainer((FinishingAnvilContainer) otherContainer, player);
	}

	protected void syncWithOtherContainer(FinishingAnvilContainer otherContainer, EntityPlayerMP player) {
		// set same selection as other container
		this.anvil0 = otherContainer.anvil0;
		// this.setToolSelection(otherContainer.selectedTool,
		// otherContainer.activeSlots);
		// this.setToolName(otherContainer.toolName);
		// also send the data to the player
		TinkerNetwork.sendTo(new FinishingAnvilSelectionPacket(otherContainer.anvil0), player);

	}

	public void onResultTaken(EntityPlayer playerIn, ItemStack stack) {
		boolean resultTaken = false;

		if (resultTaken) {
			// updateSlotsAfterToolAction();
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
//		tile.setInventorySlotContents(0, ItemStack.EMPTY); // slot where the tool was
//		for (int i = 1; i < tile.getSizeInventory(); i++) {
//			if (!tile.getStackInSlot(i).isEmpty() && tile.getStackInSlot(i).getCount() == 0) {
//				tile.setInventorySlotContents(i, ItemStack.EMPTY);
//			}
//		}
	}

	private ItemStack buildTool() throws TinkerGuiException {
		NonNullList<ItemStack> input = ItemStackList.withSize(tile.getSizeInventory());
		for (int i = 0; i < input.size(); i++) {
			input.set(i, tile.getStackInSlot(i));
		}

		ItemStack result = ItemStack.EMPTY;
		if (input.size() != 0) {
			if (input.get(0).getItem() instanceof ToolCore || input.get(0).getItem() instanceof ArmorCore) {
				result = input.get(0);

				NBTTagCompound tag = TagUtil.getTagSafe(result);
				if (!tag.hasKey(ArmorTags.AnvilBase)) {
					tag.setTag(ArmorTags.AnvilBase, new NBTTagCompound());
				}
				NBTTagCompound anvil = tag.getCompoundTag(ArmorTags.AnvilBase);
				
				//int bit = (anvil4 << 24) | (anvil3 << 16) | (anvil2 << 8) | (anvil1 << 4) | anvil0;
				anvil.setInteger(ArmorTags.ModelType, anvil0);
				tag.setTag(ArmorTags.AnvilBase, anvil);
			}
			if (!result.isEmpty()) {
				TinkerCraftingEvent.ToolCraftingEvent.fireEvent(result, player, input);
			}
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