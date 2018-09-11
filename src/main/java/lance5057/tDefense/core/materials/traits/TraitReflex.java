package lance5057.tDefense.core.materials.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitReflex extends AbstractTDTrait {

	public TraitReflex() {
		super("reflex", TextFormatting.DARK_PURPLE);
	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		if (e.getEntityLiving().world.rand.nextInt() % 100 == 0) {
			Vec3d source = e.getSource().getTrueSource().getPositionVector();
			Vec3d player = e.getEntityLiving().getPositionVector();

			double dist = source.distanceTo(player);

			if (dist < 2) {
				Vec3d forward = e.getSource().getTrueSource().getForward();
				e.getEntityLiving().posX = source.x - forward.x;
				e.getEntityLiving().posY = source.y - forward.y;
				e.getEntityLiving().posZ = source.z - forward.z;
			}
		}
	}
}
