package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

public class TraitTimewarp extends AbstractTDTrait {

	public TraitTimewarp() {
		super("td_timewarp", 0xa470e0);
	}

	@Override
	public void onJump(LivingJumpEvent e) {
		if (e.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer ent = (EntityPlayer) e.getEntityLiving();

			if (ent.isSneaking()) {
				ent.attemptTeleport(ent.getForward().x * 10, ent.getForward().y * 10, ent.getForward().z * 10);
			}
		}
	}
}
