package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ModAntiBlindness extends ModifierTDTrait {

	public ModAntiBlindness() {
		super("antiblindness", 0x222222);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.isPotionActive(MobEffects.BLINDNESS))
			player.removeActivePotionEffect(MobEffects.BLINDNESS);
	}
}
