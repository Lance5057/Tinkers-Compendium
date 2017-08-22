package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitBarbed extends AbstractTrait {

	public TraitBarbed() {
		super("barbed", TextFormatting.GREEN);
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
		if (event.getSource() != DamageSource.generic) {
			player.attackEntityFrom(DamageSource.generic, 1);
			event.getSource().getSourceOfDamage().attackEntityFrom(DamageSource.generic, 1);
		}
	}
}
