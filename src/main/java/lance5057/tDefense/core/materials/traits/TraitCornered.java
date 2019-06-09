package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitCornered extends AbstractTrait {

	public TraitCornered() {
		super("td_cornered", 0x6d3300);
	}

	@Override
	  public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		float mod = (player.getHealth() / player.getMaxHealth()) - 1f;
	    return newDamage + (newDamage * mod);
	  }
}
