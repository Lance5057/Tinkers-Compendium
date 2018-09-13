package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

// chance to use less durability if pretty damaged.
// chance scales quadratically with how much is missing
public class TraitHeroic extends AbstractTrait {

	public TraitHeroic() {
		super("dense", 0xffffff);
	}

	@Override
	public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {

			EntityPlayer p = (EntityPlayer) entity;

			float d = 0;
			float traits = 0;
			for (ItemStack i : p.getArmorInventoryList()) {
				if (TinkerUtil.hasTrait(TagUtil.getTagSafe(i), identifier)) {
					d += damage * (1 - (p.experienceLevel / 100));
					traits++;
				}
			}
			
			if(traits != 0)
			{
				newDamage = (int) (d / traits);
			}
		}
		return super.onToolDamage(tool, damage, newDamage, entity);
	}
}