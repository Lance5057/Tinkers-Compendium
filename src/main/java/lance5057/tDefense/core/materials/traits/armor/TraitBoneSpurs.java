package lance5057.tDefense.core.materials.traits.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitBoneSpurs extends AbstractTrait {

	public TraitBoneSpurs() {
		super("bonespurs", TextFormatting.WHITE);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {

		Entity mount = player.getRidingEntity();
		if (mount instanceof EntityLivingBase) {
			EntityLivingBase lmount = (EntityLivingBase) mount;
			lmount.addPotionEffect(new PotionEffect(MobEffects.SPEED, 10));
		}
	}
}
