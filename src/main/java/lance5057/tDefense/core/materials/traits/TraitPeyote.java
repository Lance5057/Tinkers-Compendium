package lance5057.tDefense.core.materials.traits;

import java.util.Random;

import lance5057.tDefense.TD_Config;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class TraitPeyote extends AbstractTDTrait {

	public TraitPeyote() {
		super("peyote", TextFormatting.GREEN);
	}

	@Override
	public void onFoodEaten(LivingEntityUseItemEvent.Finish e) {
		EntityLivingBase p = e.getEntityLiving();
		int duration = p.world.rand.nextInt(8) + 2;
		switch (p.world.rand.nextInt(6)) {
		default:
			p.addPotionEffect(new PotionEffect(MobEffects.POISON, duration, 0));
			break;
		case 1:
			p.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, duration, 0));
			break;
		case 2:
			if (!TD_Config.KiddyCoastersMakeMeRetch)
				p.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, duration, 0));
			break;
		case 3:
			p.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, duration, 0));
			break;
		case 4:
			p.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, duration, 0));
			break;
		case 5:
			p.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, duration, 0));
			break;
		}
	}
}
