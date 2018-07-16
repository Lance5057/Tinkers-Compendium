package lance5057.tDefense.core.materials.traits.armor;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitNovel extends AbstractTDTrait {

	public TraitNovel() {
		super("novel", TextFormatting.WHITE);
	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {

		if (e.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer ent = (EntityPlayer) e.getEntityLiving();
			float dmg = e.getAmount();
			
			if (dmg >= 1) {
				if(ent.experience >= 5)
				{
					dmg--;
					ent.experience -= 5;
				}
			}
			e.setAmount(dmg);
		}
	}
}
