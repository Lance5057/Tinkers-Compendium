package lance5057.tDefense.core.library.capabilities.handlers;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import baubles.api.cap.BaublesCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import vazkii.botania.api.mana.IManaItem;

public class BackpackHandler implements ICapabilitySerializable<NBTBase> {

		private final IItemHandler inv = new ItemStackHandler(27) {
			@Nonnull
			@Override
			public ItemStack insertItem(int slot, @Nonnull ItemStack toInsert, boolean simulate) {
//				if(!toInsert.isEmpty()) {
//					boolean isBauble = toInsert.hasCapability(BaublesCapabilities.CAPABILITY_ITEM_BAUBLE, null);
//					if(toInsert.getItem() instanceof IManaItem || isBauble)
//						return super.insertItem(slot, toInsert, simulate);
//				}
				return super.insertItem(slot, toInsert, simulate);
			}
		};

		@Override
		public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
			return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
		}

		@Override
		public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) { 
			if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(inv);
			else return null;
		}

		@Override
		public NBTBase serializeNBT() {
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(inv, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(inv, null, nbt);
		}
	}