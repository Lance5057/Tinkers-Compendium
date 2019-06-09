package lance5057.tDefense.core.modifiers;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class ModExtraHealth extends ModifierTDTrait {

	public ModExtraHealth() {
		super("scabbing", 0xFF0000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onArmorEquip(EntityPlayer e) {
		if(!e.world.isRemote) {
			Multimap<String, AttributeModifier> attributes = HashMultimap.create();
			attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(null, "td_hp", 2, 0).setSaved(false));
			e.getAttributeMap().applyAttributeModifiers(attributes);
		}
	}

	@Override
	public void onArmorUnequip(EntityPlayer e) {
		if(!e.world.isRemote) {
			Multimap<String, AttributeModifier> attributes = HashMultimap.create();
			attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(null, "td_hp", 2, 0).setSaved(false));
			e.getAttributeMap().removeAttributeModifiers(attributes);
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
}
