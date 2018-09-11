package lance5057.tDefense.core.materials.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitAqualung extends AbstractTDTrait {

	public TraitAqualung() {
		super("aqualung", TextFormatting.AQUA);
	}
	
	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		e.getEntityLiving().setAir((int) e.getAmount());
	}
}
