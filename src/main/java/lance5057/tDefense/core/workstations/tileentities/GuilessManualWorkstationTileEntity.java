package lance5057.tDefense.core.workstations.tileentities;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.tools.ToolCore;

public abstract class GuilessManualWorkstationTileEntity extends TileEntity {

	private String tag = "";

	public ToolCore requiredTool;

	public ItemStack[] items;
	public ItemStack output;

	protected String oreIn;
	protected String oreOut;

	public int usesMax = -1;
	public int uses = -1;

	public GuilessManualWorkstationTileEntity(int inputs, String tag, int timerMax, String in, String out) {
		items = new ItemStack[inputs];
		this.tag = tag;
		this.usesMax = timerMax;
		oreIn = in;
		oreOut = out;
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
		if (items != null)
			for (int i = 0; i < items.length; i++) {
				items[i] = new ItemStack(custom.getCompoundTag("inventory_" + i));
			}

		output = new ItemStack(custom.getCompoundTag("output"));
		uses = custom.getInteger("timer");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagCompound custom = new NBTTagCompound();
		if (items != null)
			for (int i = 0; i < items.length; i++) {
				if (items[i] != null)
					custom.setTag("inventory_" + i, items[i].serializeNBT());
			}

		if (output != null) {
			custom.setTag("output", output.serializeNBT());
		}

		custom.setInteger("timer", uses);
		compound.setTag(tag, custom);

		return compound;
	}

	public void interact(EntityPlayer player, EnumHand hand) {
		if (!isEmpty()) {
			if (uses < this.usesMax) {
				if (world.isRemote) {
					
					
					this.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, (double) this.pos.getX() + 0.5f,
							(double) this.pos.getY() + 1, (double) this.pos.getZ() + 0.5f, 0f, 0f, 0f,
							Block.getIdFromBlock(blockType));

				} else {
					this.world.playSound(null, pos, SoundEvents.BLOCK_STONE_HIT, SoundCategory.BLOCKS, 1, 1);
					player.swingArm(hand);
					uses++;
				}
				
			} else {
				if (!world.isRemote) {
					this.createItem();
				}
			}
		}
		else
			uses = 0;
	}
	
	public abstract void createItem();

	private boolean isOreIn(ItemStack stack) {
		if (stack != null && stack != ItemStack.EMPTY) {
			for (int i : OreDictionary.getOreIDs(stack)) {
				String s = OreDictionary.getOreName(i).substring(0, oreIn.length());
				if (this.oreIn.equalsIgnoreCase(s)) {
					return true;
				}
			}
		}
		return false;
	}

	private ItemStack getOreOut(ItemStack stack) {
		for (int i : OreDictionary.getOreIDs(stack)) {
			String s = OreDictionary.getOreName(i).substring(oreIn.length());

			NonNullList<ItemStack> list = OreDictionary
					.getOres(oreOut + s.substring(0, 1).toUpperCase() + s.substring(1));

			return list.get(0);

		}
		return null;
	}

	public void addItemToBlock(EntityPlayer player, EnumHand hand) {
		ItemStack held = player.getHeldItem(hand);
		// Add Item to block
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null || items[i] == ItemStack.EMPTY) {
				items[i] = held;
				player.setHeldItem(hand, ItemStack.EMPTY);
				uses = 0;
				return;
			}
		}
	}

	public void removeItemFromBlock(EntityPlayer player, EnumHand hand) {
		if (output != ItemStack.EMPTY && output != null) {
			player.addItemStackToInventory(output);
			output = ItemStack.EMPTY;
		}
		// remove Item from block
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i] != ItemStack.EMPTY) {

				player.addItemStackToInventory(items[i]);
				items[i] = ItemStack.EMPTY;
				uses = 0;
				return;
			}
		}
	}

	public boolean isEmpty() {
		for (ItemStack i : items) {
			if (i != null || i != ItemStack.EMPTY)
				return false;
		}
		return true;
	}
}
