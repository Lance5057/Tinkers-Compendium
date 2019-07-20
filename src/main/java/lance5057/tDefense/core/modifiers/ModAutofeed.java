package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class ModAutofeed extends ModifierTDTrait {

	public ModAutofeed() {
		super("autofeed", 0x752700);
	}

	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (stack.getItem() instanceof ArmorCore)
			if (((ArmorCore) stack.getItem()).armorType == EntityEquipmentSlot.HEAD) {
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
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.canEat(false))
		{
			for(ItemStack i: player.inventory.mainInventory)
			{
				if(i.getItem() instanceof ItemFood)
				{
					player.getFoodStats().addStats((ItemFood) i.getItem(), i);
					i.setCount(i.getCount()-1);
					
					world.playSound(player, player.getPosition(), SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 1, 1);
				}
			}
		}
	}

	@Override
	protected ModifierAspect[] getAspects() {
		return new ModifierAspect[] {ModifierAspect.freeModifier};
	}
}
