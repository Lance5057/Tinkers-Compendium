package lance5057.tDefense.core.materials.traits;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;

public class TraitShiverBurn extends AbstractTDTrait {
	
	public TraitShiverBurn(AbstractTDTrait... traits) {
		super("shiverburn", TextFormatting.AQUA);
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {
		
		newDamage = damage;
		if(target.isPotionActive(MobEffects.SLOWNESS))
		{
			newDamage *= 1.25f;
		}
		return newDamage;
	}
}
