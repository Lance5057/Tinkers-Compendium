package lance5057.tDefense.core.materials.traits.armor;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class TraitEarthbound extends AbstractTDTrait {

	public TraitEarthbound() {
		super("earthbound", TextFormatting.GRAY);
	}

	@Override
	public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
		double y = entity.posY;
		
		if(y <= 64 && y > 0)
		{
			newDamage = (int) (newDamage * (y/64));
		}
		
		return newDamage;
	}
}
