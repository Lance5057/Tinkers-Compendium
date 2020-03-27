package lance5057.tDefense.core.addons.ebwizardry.modifiers;

import java.util.Arrays;

import electroblob.wizardry.constants.Constants;
import electroblob.wizardry.constants.Element;
import electroblob.wizardry.event.SpellCastEvent;
import electroblob.wizardry.item.ItemWizardArmour;
import electroblob.wizardry.util.SpellModifiers;
import electroblob.wizardry.util.WizardryUtilities;
import lance5057.tDefense.core.library.ArmorHelper;
import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.util.ArmorTagUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;

public class ModElementalFocus extends ModifierTDTrait {

	Element element;

	public ModElementalFocus(String identifier, int color, Element element) {
		super("focus" + identifier, color);
		this.element = element;
	}

	public void onSpellCastPre(ItemStack tool, SpellCastEvent.Pre event) {
		// Armour cost reduction
		if (event.getCaster() == null)
			return;
		// int armourPieces = getMatchingArmourCount(event.getCaster(),
		// event.getSpell().getElement());
		if (element != event.getSpell().getElement())
			return;
		
		float multiplier = 1f - Constants.COST_REDUCTION_PER_ARMOUR;
		// if(armourPieces == WizardryUtilities.ARMOUR_SLOTS.length) multiplier -=
		// Constants.FULL_ARMOUR_SET_BONUS;
		event.getModifiers().set(SpellModifiers.COST, event.getModifiers().get(SpellModifiers.COST) * multiplier * ArmorTagUtil.getToolStats(tool).armorPotency,
				false);
	}

	@Override
	protected ModifierAspect[] getAspects() {
		return new ModifierAspect[] { ModifierAspect.freeModifier };
	}

}
