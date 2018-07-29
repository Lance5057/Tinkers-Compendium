package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;

public class TraitIronclad extends AbstractTDTrait {
	public TraitIronclad() {
		super("ironclad", TextFormatting.GRAY);
	}

	@Override
	public void onDamagePre(ItemStack tool, LivingAttackEvent e) {
		Entity ent = e.getSource().getImmediateSource();
		if (ent instanceof EntityArrow) {
			EntityArrow arrow = (EntityArrow) ent;

			arrow.setDead();

			int chance = arrow.world.rand.nextInt(100);
			if (chance < 25) {
				e.setCanceled(true);

				if (chance < 10) {
					if (arrow instanceof EntityProjectileBase) {
						EntityProjectileBase tarrow = (EntityProjectileBase) arrow;
						tarrow.entityDropItem(tarrow.tinkerProjectile.getItemStack(), 0);
					} else {
						arrow.entityDropItem(new ItemStack(Items.ARROW), 0);
					}
				}
			}
		}
	}
}
