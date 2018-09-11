package lance5057.tDefense.core.materials.traits;

import java.util.UUID;

import lance5057.tDefense.core.tools.TDToolEvents;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TraitDamnation extends AbstractTDTrait
{
	

	public TraitDamnation() {
		super("damnation", TextFormatting.DARK_RED);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		IAttributeInstance att = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		if (player.isInLava()) {
			if (!att.hasModifier(TDToolEvents.td_fins)) {
				att.applyModifier(TDToolEvents.td_fins);
			}

			player.setFire(5);
		}
	}
}
