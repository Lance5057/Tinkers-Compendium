package lance5057.tDefense.armor.events;

import com.google.common.collect.ImmutableList;

import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import slimeknights.tconstruct.library.materials.Material;

public abstract class ArmorBaseEvents extends Event {
	public static class OnArmorBuilding extends ArmorBaseEvents {

		public NBTTagCompound tag;
		public final ImmutableList<Material> materials;
		public final ArmorCore tool;

		public OnArmorBuilding(NBTTagCompound tag, ImmutableList<Material> materials, ArmorCore tool) {
			this.tag = tag;
			this.materials = materials;
			this.tool = tool;
		}

		public static OnArmorBuilding fireEvent(NBTTagCompound tag, ImmutableList<Material> materials,
				ArmorCore armorCore) {
			OnArmorBuilding event = new OnArmorBuilding(tag, materials, armorCore);
			MinecraftForge.EVENT_BUS.post(event);
			return event;
		}
	}
}
