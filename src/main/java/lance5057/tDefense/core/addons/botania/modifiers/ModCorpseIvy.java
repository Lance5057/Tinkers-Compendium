package lance5057.tDefense.core.addons.botania.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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

public class ModCorpseIvy extends ModifierTDTrait {

	public ModCorpseIvy() {
		super("corpseivy", 0x550000);
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt,
			boolean wasCritical, boolean wasHit) {
		if (target.getHealth() <= 0) {
			if (player instanceof EntityPlayer)
				ManaItemHandler.dispatchMana(tool, (EntityPlayer) player, (int)target.getMaxHealth(), true);
		}
	}

	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (!(stack.getItem() instanceof ToolCore)) {
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
		return new ModifierAspect[] { ModifierAspect.freeModifier };
	}

}
