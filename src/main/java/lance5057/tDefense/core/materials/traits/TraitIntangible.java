package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class TraitIntangible extends AbstractTDTrait
{
	public TraitIntangible() {
		super("td_intangible", 0xa470e0);
	}
	
	@Override
	public void onDamagePre(ItemStack tool, LivingAttackEvent e) {
		if(e.getSource().getImmediateSource() instanceof EntityArrow)
		{
			EntityArrow arrow = (EntityArrow) e.getSource().getImmediateSource();
			arrow.moveRelative(0, 0, 2, 0);
		}
	}
}
