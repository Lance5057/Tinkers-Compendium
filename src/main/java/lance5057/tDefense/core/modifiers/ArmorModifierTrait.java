package lance5057.tDefense.core.modifiers;

import java.util.List;

import com.google.common.collect.ImmutableList;

import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.modifiers.IModifierDisplay;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TinkerUtil;

/**
 * Represents a modifier that has trait-logic Modifier can have multiple levels.
 * Since this is intended for modifiers it uses a modifier
 */
public class ArmorModifierTrait extends AbstractTrait implements IModifierDisplay {

	protected final int maxLevel;

	public ArmorModifierTrait(String identifier, int color) {
		this(identifier, color, 0, 0);
	}

	public ArmorModifierTrait(String identifier, int color, int maxLevel, int countPerLevel) {
		super(identifier, color);

		// register the modifier trait
		TinkerRegistry.addTrait(this);

		this.maxLevel = maxLevel;
		this.aspects.clear();

		if (maxLevel > 0 && countPerLevel > 0) {
			addAspects(new ModifierAspect.MultiAspect(this, color, maxLevel, countPerLevel, 1));
		} else {
			if (maxLevel > 0) {
				addAspects(new ModifierAspect.LevelAspect(this, maxLevel));
			}
			addAspects(new ModifierAspect.DataAspect(this, color), ModifierAspect.freeModifier);
		}
	}

	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (!(stack.getItem() instanceof ArmorCore)) {
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
	public String getTooltip(NBTTagCompound modifierTag, boolean detailed) {
		if (maxLevel > 0) {
			return getLeveledTooltip(modifierTag, detailed);
		}
		return super.getTooltip(modifierTag, detailed);
	}

	@Override
	public int getColor() {
		return color;
	}

	@Override
	public List<List<ItemStack>> getItems() {
		ImmutableList.Builder<List<ItemStack>> builder = ImmutableList.builder();

		for (RecipeMatch rm : items) {
			List<ItemStack> in = rm.getInputs();
			if (!in.isEmpty()) {
				builder.add(in);
			}
		}

		return builder.build();
	}

	public ModifierNBT.IntegerNBT getData(ItemStack tool) {
		NBTTagCompound tag = TinkerUtil.getModifierTag(tool, getModifierIdentifier());
		return ModifierNBT.readInteger(tag);
	}

}