package lance5057.tDefense.core.materials.traits;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.ITrait;

public interface ITDTrait extends ITrait {

	/*
	 * Called when player takes damage while wearing TD armor
	 */
	void onDamageTaken(LivingHurtEvent e);
}
