package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitBattleHardened extends AbstractTDTrait {

	int level = 1;
	int time = 0;
	public TraitBattleHardened(String name, TextFormatting color, int time, int level) {
		super(name, color);
		this.level = level;
		this.time = time;
	}

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		EntityLivingBase ent = e.getEntityLiving();

		if (ent.isPotionActive(MobEffects.RESISTANCE)) {
			PotionEffect p = ent.getActivePotionEffect(MobEffects.RESISTANCE);

			if (p.getAmplifier() < 3) {
				ent.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 40 + time, p.getAmplifier() + 1));
				ToolHelper.damageTool(tool, p.getAmplifier() * 1 * level, ent);
			}
		} else {
			ent.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 40 + time, 1));
			ToolHelper.damageTool(tool, 1 * level, ent);
		}

	}

}
