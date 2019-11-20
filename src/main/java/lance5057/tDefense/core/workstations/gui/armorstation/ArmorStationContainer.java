package lance5057.tDefense.core.workstations.gui.armorstation;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import lance5057.tDefense.core.library.ArmorBuilder;
import lance5057.tDefense.core.library.TCRegistry;
import lance5057.tDefense.core.network.ArmorStationSelectionPacket;
import lance5057.tDefense.core.tools.bases.ArmorBase;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.core.workstations.tileentities.ArmorStationTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.StringUtils;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.inventory.BaseContainer;
import slimeknights.mantle.util.ItemStackList;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.common.TinkerNetwork;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.events.TinkerCraftingEvent;
import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
import slimeknights.tconstruct.library.tinkering.IModifyable;
import slimeknights.tconstruct.library.tinkering.IRepairable;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.common.client.GuiToolStation;
import slimeknights.tconstruct.tools.common.inventory.ContainerTinkerStation;
import slimeknights.tconstruct.tools.common.inventory.SlotToolStationIn;
import slimeknights.tconstruct.tools.common.network.ToolStationTextPacket;

// also tool forge
public class ArmorStationContainer extends ContainerTinkerStation<ArmorStationTile> {

	private final EntityPlayer player;
	protected ArmorStationSlotOut out;
	protected ArmorCore selectedTool; // needed for newly opened containers to sync
	protected int activeSlots;
	public String toolName;
	
    private static final EntityEquipmentSlot[] VALID_EQUIPMENT_SLOTS = new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET};

	public ArmorStationContainer(InventoryPlayer playerInventory, ArmorStationTile tile) {
		super(tile);

		// input slots
		int i;
		for (i = 0; i < tile.getSizeInventory(); i++) {
			addSlotToContainer(new SlotToolStationIn(tile, i, 0, 0, this));
		}

		// output slot
		out = new ArmorStationSlotOut(i, 124, 38, this);
		addSlotToContainer(out);
		
		//Armor Slots
		for (int k = 0; k < 4; ++k)
        {
            final EntityEquipmentSlot entityequipmentslot = VALID_EQUIPMENT_SLOTS[k];
            this.addSlotToContainer(new Slot(playerInventory, 36 + (3 - k), 8 + k * 18, 181)
            {
                /**
                 * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1
                 * in the case of armor slots)
                 */
                public int getSlotStackLimit()
                {
                    return 1;
                }
                /**
                 * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace
                 * fuel.
                 */
                public boolean isItemValid(ItemStack stack)
                {
                    return stack.getItem().isValidArmor(stack, entityequipmentslot, player);
                }
                /**
                 * Return whether this slot's stack can be taken from this slot.
                 */
                public boolean canTakeStack(EntityPlayer playerIn)
                {
                    ItemStack itemstack = this.getStack();
                    return !itemstack.isEmpty() && !playerIn.isCreative() && EnchantmentHelper.hasBindingCurse(itemstack) ? false : super.canTakeStack(playerIn);
                }
                @Nullable
                @SideOnly(Side.CLIENT)
                public String getSlotTexture()
                {
                    return ItemArmor.EMPTY_SLOT_NAMES[entityequipmentslot.getIndex()];
                }
            });
        }
		
		this.addSlotToContainer(new Slot(playerInventory, 40, 8 + 4 * 18, 181)
		{
            @Nullable
            @SideOnly(Side.CLIENT)
            public String getSlotTexture()
            {
                return "minecraft:items/empty_armor_slot_shield";
            }
        });
		
		this.addPlayerInventory(playerInventory, 8, 84 + 8);
		
		onCraftMatrixChanged(null);

		this.player = playerInventory.player;
	}

	public ItemStack getResult() {
		return out.getStack();
	}

	@Override
	protected void syncNewContainer(EntityPlayerMP player) {
		this.activeSlots = tile.getSizeInventory();
		TinkerNetwork.sendTo(new ArmorStationSelectionPacket(null, tile.getSizeInventory()), player);
	}

	@Override
	protected void syncWithOtherContainer(BaseContainer<ArmorStationTile> otherContainer, EntityPlayerMP player) {
		this.syncWithOtherContainer((ArmorStationContainer) otherContainer, player);
	}

	protected void syncWithOtherContainer(ArmorStationContainer otherContainer, EntityPlayerMP player) {
		// set same selection as other container
		this.setToolSelection(otherContainer.selectedTool, otherContainer.activeSlots);
		this.setToolName(otherContainer.toolName);
		// also send the data to the player
		TinkerNetwork.sendTo(new ArmorStationSelectionPacket(otherContainer.selectedTool, otherContainer.activeSlots),
				player);
		if (otherContainer.toolName != null && !otherContainer.toolName.isEmpty()) {
			TinkerNetwork.sendTo(new ToolStationTextPacket(otherContainer.toolName), player);
		}
	}

	public void setToolSelection(ArmorCore selectedTool2, int activeSlots) {
		if (activeSlots > tile.getSizeInventory()) {
			activeSlots = tile.getSizeInventory();
		}

		this.activeSlots = activeSlots;
		this.selectedTool = selectedTool2;

		for (int i = 0; i < tile.getSizeInventory(); i++) {
			Slot slot = inventorySlots.get(i);
			// set part info for the slot
			if (slot instanceof SlotToolStationIn) {
				SlotToolStationIn slotToolPart = (SlotToolStationIn) slot;

				slotToolPart.setRestriction(null);

				// deactivate not needed slots
				if (i >= activeSlots) {
					slotToolPart.deactivate();
				}
				// activate the other slots and set toolpart if possible
				else {
					slotToolPart.activate();
					if (selectedTool2 != null) {
						List<PartMaterialType> pmts = selectedTool2.getToolBuildComponents();
						if (i < pmts.size()) {
							slotToolPart.setRestriction(pmts.get(i));
						}
					}
				}

				if (world.isRemote) {
					slotToolPart.updateIcon();
				}
			}
		}
	}

	public void setToolName(String name) {
		this.toolName = name;

		if (world.isRemote) {
			GuiScreen screen = Minecraft.getMinecraft().currentScreen;
			if (screen instanceof GuiToolStation) {
				((GuiToolStation) screen).textField.setText(name);
			}
		}

		onCraftMatrixChanged(tile);
		if (out.getHasStack()) {
			if (name != null && !name.isEmpty()) {
				out.inventory.getStackInSlot(0).setStackDisplayName(name);
			} else {
				out.inventory.getStackInSlot(0).clearCustomName();
			}
		}
	}

	// update crafting - called whenever the content of an input slot changes
	@Override
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		// reset gui state
		updateGUI();
		try {
			ItemStack result;
			// 1. try repairing
			result = repairTool(false);
			// 2. try swapping tool parts
			if (result.isEmpty()) {
				result = replaceToolParts(false);
			}
			// 3. try modifying
			if (result.isEmpty()) {
				result = modifyTool(false);
			}
			// 4. try renaming
			if (result.isEmpty()) {
				result = renameTool();
			}
			// 5. try building a new tool
			if (result.isEmpty()) {
				result = buildTool();
			}

			out.inventory.setInventorySlotContents(0, result);
			updateGUI();
		} catch (TinkerGuiException e) {
			// error ;(
			out.inventory.setInventorySlotContents(0, ItemStack.EMPTY);
			this.error(e.getMessage());
		}
		// sync output with other open containers on the server
		if (!this.world.isRemote) {
			WorldServer server = (WorldServer) this.world;
			for (EntityPlayer player : server.playerEntities) {
				if (player.openContainer != this && player.openContainer instanceof ArmorStationContainer
						&& this.sameGui((ArmorStationContainer) player.openContainer)) {
					((ArmorStationContainer) player.openContainer).out.inventory.setInventorySlotContents(0,
							out.getStack());
				}
			}
		}
	}

	// Called when the crafting result is taken out of its slot
	public void onResultTaken(EntityPlayer playerIn, ItemStack stack) {
		boolean resultTaken = false;

		try {
			resultTaken = !repairTool(true).isEmpty() || !replaceToolParts(true).isEmpty()
					|| !modifyTool(true).isEmpty();
		} catch (TinkerGuiException e) {
			// no error updating needed
			e.printStackTrace();
		}

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

					setToolName("");
				}
			} catch (TinkerGuiException e) {
				// no error updating needed
				e.printStackTrace();
			}
		}
		onCraftMatrixChanged(null);

		this.playCraftSound(playerIn);
	}

	protected void playCraftSound(EntityPlayer player) {
		Sounds.playSoundForAll(player, Sounds.saw, 0.8f, 0.8f + 0.4f * TConstruct.random.nextFloat());
	}

	private ItemStack repairTool(boolean remove) {
		ItemStack repairable = getToolStack();

		// modifying possible?
		if (repairable.isEmpty() || !(repairable.getItem() instanceof IRepairable)) {
			return ItemStack.EMPTY;
		}

		return ArmorBuilder.tryRepairTool(getInputs(), repairable, remove);
	}

	private ItemStack replaceToolParts(boolean remove) throws TinkerGuiException {
		ItemStack tool = getToolStack();

		if (tool.isEmpty() || !(tool.getItem() instanceof ArmorBase)) {
			return ItemStack.EMPTY;
		}

		NonNullList<ItemStack> inputs = getInputs();
		ItemStack result = ArmorBuilder.tryReplaceToolParts(tool, inputs, remove);
		if (!result.isEmpty()) {
			TinkerCraftingEvent.ToolPartReplaceEvent.fireEvent(result, player, inputs);
		}
		return result;
	}

	private ItemStack modifyTool(boolean remove) throws TinkerGuiException {
		ItemStack modifyable = getToolStack();

		// modifying possible?
		if (modifyable.isEmpty() || !(modifyable.getItem() instanceof IModifyable)) {
			return ItemStack.EMPTY;
		}

		ItemStack result = ArmorBuilder.tryModifyTool(getInputs(), modifyable, remove);
		if (!result.isEmpty()) {
			TinkerCraftingEvent.ToolModifyEvent.fireEvent(result, player, modifyable.copy());
		}
		return result;
	}

	private ItemStack renameTool() throws TinkerGuiException {
		ItemStack tool = getToolStack();

		// modifying possible?
		if (tool.isEmpty() || !(tool.getItem() instanceof ArmorBase) || StringUtils.isNullOrEmpty(toolName)
				|| tool.getDisplayName().equals(toolName)) {
			return ItemStack.EMPTY;
		}

		ItemStack result = tool.copy();
		if (TagUtil.getNoRenameFlag(result)) {
			throw new TinkerGuiException(Util.translate("gui.error.no_rename"));
		}

		result.setStackDisplayName(toolName);

		return result;
	}

	private ItemStack buildTool() throws TinkerGuiException {
		NonNullList<ItemStack> input = ItemStackList.withSize(tile.getSizeInventory());
		for (int i = 0; i < input.size(); i++) {
			input.set(i, tile.getStackInSlot(i));
		}

		ItemStack result = ArmorBuilder.tryBuildArmor(input, toolName, getBuildableTools());
		if (!result.isEmpty()) {
			TinkerCraftingEvent.ToolCraftingEvent.fireEvent(result, player, input);
		}
		return result;
	}

	protected Set<ArmorCore> getBuildableTools() {
		return TCRegistry.getArmorStationCrafting();
	}

	private ItemStack getToolStack() {
		return inventorySlots.get(0).getStack();
	}

	/**
	 * Removes the tool in the input slot and fixes all stacks that have stacksize 0
	 * after being used up.
	 */
	private void updateSlotsAfterToolAction() {
// perfect, items already got removed but we still have to clean up 0-stacks and remove the tool
		tile.setInventorySlotContents(0, ItemStack.EMPTY); // slot where the tool was
		for (int i = 1; i < tile.getSizeInventory(); i++) {
			if (!tile.getStackInSlot(i).isEmpty() && tile.getStackInSlot(i).getCount() == 0) {
				tile.setInventorySlotContents(i, ItemStack.EMPTY);
			}
		}
	}

	private NonNullList<ItemStack> getInputs() {
		NonNullList<ItemStack> input = NonNullList.withSize(tile.getSizeInventory() - 1, ItemStack.EMPTY);
		for (int i = 1; i < tile.getSizeInventory(); i++) {
			input.set(i - 1, tile.getStackInSlot(i));
		}

		return input;
	}

	@Override
	public boolean canMergeSlot(ItemStack stack, Slot slot) {
		return slot != out && super.canMergeSlot(stack, slot);
	}
}