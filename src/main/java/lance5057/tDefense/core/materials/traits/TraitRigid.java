package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitRigid extends AbstractTDTrait {

  public TraitRigid() {
    super("rigid", 0xffffff);
  }

  @Override
  public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
    e.setAmount(Math.max(1f, e.getAmount() - 1f));
  }
}