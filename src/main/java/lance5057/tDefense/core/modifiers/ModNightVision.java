package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ModNightVision extends ModifierTDTrait {

	public ModNightVision() {
		super("nightvision", 0x00ff00);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20));
	}
}
