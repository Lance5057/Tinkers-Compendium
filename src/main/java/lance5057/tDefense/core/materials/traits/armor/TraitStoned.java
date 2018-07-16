package lance5057.tDefense.core.materials.traits.armor;

import java.util.UUID;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import lance5057.tDefense.core.tools.TDToolEvents;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TraitStoned extends AbstractTDTrait {

	public TraitStoned() {
		super("stoned", TextFormatting.DARK_GRAY);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		IAttributeInstance att = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		if (!att.hasModifier(TDToolEvents.td_stoned)) {
			att.applyModifier(TDToolEvents.td_stoned);
		}

		if (player.isInWater()) {
			player.motionY += -0.005f;
		}
	}
}
