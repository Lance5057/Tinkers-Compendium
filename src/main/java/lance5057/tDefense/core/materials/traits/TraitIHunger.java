package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitIHunger extends AbstractTDTrait {

	public TraitIHunger() {
		super("ihunger", 0x6d3300);
	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		if(e.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer p = (EntityPlayer) e.getEntityLiving();
			float mod = Math.max(p.getFoodStats().getFoodLevel() / 20, 0.25f);
			
			e.setAmount(e.getAmount() * mod);
		}
	}
}
