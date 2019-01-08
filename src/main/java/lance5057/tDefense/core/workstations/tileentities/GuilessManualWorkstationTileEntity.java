package lance5057.tDefense.core.workstations.tileentities;

import lance5057.tDefense.core.workstations.WorkstationRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import slimeknights.tconstruct.library.tools.ToolCore;

public abstract class GuilessManualWorkstationTileEntity extends TileEntity {

	private String tag = "";

	public ToolCore requiredTool;

	public ItemStack[] items;
	public ItemStack output;

	public int usesMax = -1;
	public int uses = -1;

	public GuilessManualWorkstationTileEntity(int inputs, String tag, int timerMax) {
		items = new ItemStack[inputs];
		this.tag = tag;
		this.usesMax = timerMax;
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		this.readFromNBT(packet.getNbtCompound());
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		NBTTagCompound custom = (NBTTagCompound) compound.getTag(tag);
		for (int i = 0; i < items.length; i++) {
			items[i] = new ItemStack(custom.getCompoundTag("inventory_" + i));
		}

		uses = custom.getInteger("timer");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagCompound custom = new NBTTagCompound();
		for (int i = 0; i < items.length; i++) {
			custom.setTag("inventory_" + i, items[i].serializeNBT());
		}

		custom.setInteger("timer", uses);
		compound.setTag(tag, custom);

		return compound;
	}

	public abstract void interact(EntityPlayer player, EnumHand hand);

	public void addItemToBlock(EntityPlayer player, EnumHand hand) {
		ItemStack held = player.getHeldItem(hand);
		// Add Item to block
		for (ItemStack i : items) {
			if (i == null || i == ItemStack.EMPTY) {
				i = held;
				player.setHeldItem(hand, ItemStack.EMPTY);
				return;
			}
		}
	}

	public void removeItemFromBlock(EntityPlayer player, EnumHand hand) {
		if (player.getHeldItem(hand).equals(ItemStack.EMPTY)) {
			// Add Item to block
			for (ItemStack i : items) {
				if (i != null || i != ItemStack.EMPTY) {

					player.setHeldItem(hand, i);
					i = ItemStack.EMPTY;
					return;
				}
			}
		}
	}
}
