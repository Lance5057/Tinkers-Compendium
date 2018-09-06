package lance5057.tDefense.core.materials.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DimensionType;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitDamageReductionDimension extends AbstractTDTrait {
	DimensionType dim;
	float percent;

	public TraitDamageReductionDimension(String identifier, TextFormatting color, DimensionType d, float p) {
		super(identifier, color);
		// TODO Auto-generated constructor stub
		this.dim = d;
		this.percent = p;
	}

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e)
	{
		if(e.getEntityLiving().dimension == dim.getId())
		{
			e.setAmount(e.getAmount() * percent);
		}
	}
}
