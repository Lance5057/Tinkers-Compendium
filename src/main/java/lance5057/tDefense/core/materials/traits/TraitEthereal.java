package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitEthereal extends AbstractTrait {

	public TraitEthereal() {
		super("td_ethereal", 0xa470e0);
	}

	@Override
	  public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		if(player.world.rand.nextInt() < 10)
		{
			if(player instanceof EntityPlayer)
				target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player).setDamageBypassesArmor(), damage);
			else
				target.attackEntityFrom(DamageSource.causeMobDamage(player).setDamageBypassesArmor(), damage);
			return 0;
		}
		return damage;
	}
}
