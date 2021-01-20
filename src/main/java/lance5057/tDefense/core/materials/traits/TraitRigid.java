package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class TraitRigid extends AbstractTDTrait {

  public TraitRigid() {
    super("rigid", 0xffffff);
  }


  public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
    if (e.getSource().getTrueSource() instanceof EntityMob) {
      EntityMob ent = (EntityMob) e.getSource().getTrueSource();

      int count = 0;

      for (ItemStack i : e.getEntityLiving().getArmorInventoryList()) {
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(i), this.identifier)) {
          count++;
        }
      }
      ent.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 40));
    }
  }

}