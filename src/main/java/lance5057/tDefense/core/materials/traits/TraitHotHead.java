package lance5057.tDefense.core.materials.traits;

import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitHotHead extends AbstractTDTrait {

	public TraitHotHead() {
		super("hothead", TextFormatting.RED);
	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		e.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.STRENGTH,7,1));
	}
}
