package lance5057.tDefense.core.materials.traits.armor;

import java.util.UUID;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TraitStoned extends AbstractTDTrait {

	AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "td_speed", -0.01f, 0);

	public TraitStoned() {
		super("stoned", TextFormatting.DARK_GRAY);
	}

	@Override
	public void onArmorEquip(EntityPlayer e) {
		IAttributeInstance att = e.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		if (!att.hasModifier(speed)) {
			att.applyModifier(speed);
		}
	}

	@Override
	public void onArmorUnequip(EntityPlayer e) {
		IAttributeInstance att = e.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		if (att.hasModifier(speed)) {
			att.removeModifier(speed);
		}
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.isInWater())
		{
			player.motionY += -0.005f;
		}
	}
}
