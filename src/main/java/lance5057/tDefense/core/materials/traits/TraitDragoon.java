package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class TraitDragoon extends AbstractTDTrait {
	
	public TraitDragoon() {
	    super("dragoon", TextFormatting.YELLOW);
	  }

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {

		if (player.isRiding()) {
			// 10% damage boost against unarmed targets!
			newDamage += damage + 5;
		}
		return super.damage(tool, player, target, damage, newDamage, isCritical);
	}
}
