package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitClockstopper extends AbstractTrait {

	public TraitClockstopper() {
		super("td_clockstopper", 0xa470e0);
	}
	
	@Override
	  public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
		if(event.getSource().getTrueSource() instanceof EntityLivingBase)
		{
			EntityLivingBase ent = (EntityLivingBase) event.getSource().getTrueSource();
			
			ent.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 5, 3));
		}
	  }


}
