package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class TraitRetribution extends AbstractTDTrait {

	int level = 0;
	
	public TraitRetribution(int level) {
		super("retribution" + level, TextFormatting.GRAY);
		this.level = level;
	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		if (e.getSource().getTrueSource() instanceof EntityMob) {
			EntityMob ent = (EntityMob) e.getSource().getTrueSource();
			if (ent.isEntityUndead()) {
				
				int count = 0;
				
				for (ItemStack i : e.getEntityLiving().getArmorInventoryList()) {
					if (TinkerUtil.hasTrait(TagUtil.getTagSafe(i), this.identifier)) {
						count++;
					}
				}
				
				ent.attackEntityFrom(DamageSource.MAGIC, count * level);
			}
		}
	}
}
