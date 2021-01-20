package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.armor.heavy.TinkersBreastplate;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class ModDeadMansSwitch extends ModifierTDTrait {

	public ModDeadMansSwitch() {
		super("deadmansswitch", 0xa80000);
	}

	@Override
	public void onDeath(LivingDeathEvent e) {
		boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(e.getEntityLiving().world,
				e.getEntityLiving());

		e.getEntityLiving().world.createExplosion(e.getEntityLiving(), e.getEntityLiving().posX,
				e.getEntityLiving().posY, e.getEntityLiving().posZ, 3, flag);
	}

	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (stack.getItem() instanceof TinkersBreastplate) {
			// not present yet, ok
			if (super.canApplyCustom(stack)) {
				return true;
			}
			// no max level
			else if (maxLevel == 0) {
				return false;
			}

			// already present, limit by level
			NBTTagCompound tag = TinkerUtil.getModifierTag(stack, identifier);

			return ModifierNBT.readTag(tag).level <= maxLevel;
		}
		return false;
	}

	@Override
	protected ModifierAspect[] getAspects() {
		return new ModifierAspect[] {ModifierAspect.freeModifier};
	}
}
