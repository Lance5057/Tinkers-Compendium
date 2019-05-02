package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.util.ArmorUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolBuilder;

public class ModProtection extends ArmorModifierTrait {
	protected static final int maxLevel = 1;

	Enchantment enchant;

	public ModProtection(String name, int color, Enchantment e) {
		super(name, color, maxLevel, 4);
		enchant = e;
	}

	@Override
	public boolean canApplyTogether(Enchantment enchantment) {
		return (enchantment != Enchantments.PROJECTILE_PROTECTION || enchant == Enchantments.PROJECTILE_PROTECTION)
				&& (enchantment != Enchantments.BLAST_PROTECTION || enchant == Enchantments.BLAST_PROTECTION)
				&& (enchantment != Enchantments.FIRE_PROTECTION || enchant == Enchantments.FIRE_PROTECTION)
				&& (enchantment != Enchantments.PROTECTION || enchant == Enchantments.PROTECTION);
	}

	@SuppressWarnings("unused")
	@Override
	public boolean canApplyCustom(ItemStack stack) {
		if (ArmorUtils.isCloth(stack)) {
			return false;
		}
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

	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
		super.applyEffect(rootCompound, modifierTag);

		ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(modifierTag);

		while (data.current > ToolBuilder.getEnchantmentLevel(rootCompound, enchant)) {
			ToolBuilder.addEnchantment(rootCompound, enchant);
		}
	}
}
