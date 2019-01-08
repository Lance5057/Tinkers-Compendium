package lance5057.tDefense.core.workstations.tileentities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public abstract class GuilessWorkstationTileEntity extends TileEntity implements ITickable {

	private String tag = "";
	
	public ItemStack[] items;
	public ItemStack output;
	
	public int timerMax = -1;
	public int timer = -1;

	public GuilessWorkstationTileEntity(int inputs, String tag, int timerMax)
	{
		items = new ItemStack[inputs];
		this.tag = tag;
		this.timerMax = timerMax;
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
		
		timer = custom.getInteger("timer");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagCompound custom = new NBTTagCompound();
		for (int i = 0; i < items.length; i++) {
			custom.setTag("inventory_" + i, items[i].serializeNBT());
		}

		custom.setInteger("timer", timer);
		compound.setTag(tag, custom);

		return compound;
	}
	
	@Override
	public abstract void update();

}
