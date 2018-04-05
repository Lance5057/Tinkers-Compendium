package lance5057.tDefense.core.materials.traits.shields;

import java.util.Optional;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.mantle.util.RecipeMatch.Match;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitBarbed extends AbstractTrait {

	public TraitBarbed() {
		super("barbed", TextFormatting.GREEN);
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
		if (event.getSource() != DamageSource.GENERIC) {
			player.attackEntityFrom(DamageSource.GENERIC, 1);
			event.getSource().getTrueSource().attackEntityFrom(DamageSource.GENERIC, 1);
		}
	}

	@Override
	public Optional<Match> matches(NonNullList<ItemStack> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
