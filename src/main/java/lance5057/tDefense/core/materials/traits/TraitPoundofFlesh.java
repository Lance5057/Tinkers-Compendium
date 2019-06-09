package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitPoundofFlesh extends AbstractTDTrait {

	public TraitPoundofFlesh() {
		super("poundofflesh", 0x6d3300);
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
		if (player.getFoodStats().getSaturationLevel() < 5)
			player.getFoodStats().setFoodSaturationLevel(event.getAmount() / 2);
	}

}
