package lance5057.tDefense.core.materials.traits;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitBurnAttacker extends AbstractTDTrait {
	public TraitBurnAttacker(String name, int color) {
		super(name, color);
	}
	
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		if(e.getEntityLiving().world.rand.nextInt(100) <= 75)
		{
			e.getSource().getTrueSource().setFire(5);
		}
	}
}
