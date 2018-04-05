package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public abstract class AbstractTDTrait extends AbstractTrait {
	public AbstractTDTrait(String identifier, TextFormatting color) {
		super(identifier, color);
	}

	public AbstractTDTrait(String identifier, int color) {
		super(identifier, color);
	}

	public void onArmorEquip(EntityPlayer e) {

	}
	
	public void onArmorUnequip(EntityPlayer e) {

	}

	public void onDamageTaken(LivingHurtEvent e) {
	}
}
