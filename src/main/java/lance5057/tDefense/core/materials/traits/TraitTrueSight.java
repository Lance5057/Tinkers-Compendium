package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitTrueSight extends AbstractTrait {

	public TraitTrueSight() {
		super("td_truesight", 0xa470e0);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
			player.removePotionEffect(MobEffects.BLINDNESS);
			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 10, 1));
	}
}
