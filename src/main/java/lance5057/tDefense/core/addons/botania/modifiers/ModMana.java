package lance5057.tDefense.core.addons.botania.modifiers;

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
import vazkii.botania.api.mana.ManaItemHandler;

public class ModMana extends ModifierTDTrait {

	public ModMana() {
		super("mana", 0x5555FF);
	}

	@Override
	public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			int dur = ToolHelper.getMaxDurability(tool) - ToolHelper.getCurrentDurability(tool);
			if (dur > 0) {
				if(ManaItemHandler.requestManaExactForTool(tool, player, 10, true))
					ToolHelper.repairTool(tool, 1);
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
