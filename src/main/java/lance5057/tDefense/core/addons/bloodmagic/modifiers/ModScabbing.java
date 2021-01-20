package lance5057.tDefense.core.addons.bloodmagic.modifiers;

import WayofTime.bloodmagic.core.data.SoulNetwork;
import WayofTime.bloodmagic.core.data.SoulTicket;
import WayofTime.bloodmagic.util.helper.NetworkHelper;
import lance5057.tDefense.core.library.ArmorHelper;
import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class ModScabbing extends ModifierTDTrait {

	public ModScabbing() {
		super("scabbing", 0xFF0000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			SoulNetwork s = NetworkHelper.getSoulNetwork(player);
			int dur = ToolHelper.getMaxDurability(tool) - ToolHelper.getCurrentDurability(tool);
			if (dur > 0) {
				s.syphonAndDamage(player, new SoulTicket(5));
				ArmorHelper.repairTool(tool, 1);
			}
		}
	}
	
	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (!(stack.getItem() instanceof ArmorCore || stack.getItem() instanceof ToolCore)) {
			return false;
		}
		
		// not present yet, ok
		if (super.canApplyCustom(stack)) {
			return true;
		}
		// no max level
//		else if (maxLevel == 0) {
//			return false;
//		}

		// already present, limit by level
		NBTTagCompound tag = TinkerUtil.getModifierTag(stack, identifier);

		return ModifierNBT.readTag(tag).level <= maxLevel;
	}

	@Override
	protected ModifierAspect[] getAspects() {
		return new ModifierAspect[] {ModifierAspect.freeModifier};
	}
}
