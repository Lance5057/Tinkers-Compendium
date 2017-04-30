package lance5057.tDefense.core.tools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

import java.util.List;

import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.SwordCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.TinkerTools;

public class Zweihander extends SwordCore {

  public static final float DURABILITY_MODIFIER = 1.1f;

  public Zweihander() {
    super(PartMaterialType.head(TinkerTools.largeSwordBlade),
         PartMaterialType.head(TinkerTools.swordBlade),
         PartMaterialType.handle(TinkerTools.toughToolRod),
         PartMaterialType.extra(TinkerTools.toughBinding));

    addCategory(Category.WEAPON);
  }

  @Override
  public float damagePotential() {
    return 1.0f;
  }

  @Override
  public double attackSpeed() {
    return 1.0d;
  }

//  // sword sweep attack
//  @Override
//  public boolean dealDamage(ItemStack stack, EntityLivingBase player, Entity entity, float damage) {
//    // deal damage first
//    boolean hit = super.dealDamage(stack, player, entity, damage);
//    // and then sweep
//    if(hit && !ToolHelper.isBroken(stack)) {
//      // sweep code from EntityPlayer#attackTargetEntityWithCurrentItem()
//      // basically: no crit, no sprinting and has to stand on the ground for sweep. Also has to move regularly slowly
//      double d0 = (double) (player.field_70140_Q - player.field_70141_P);
//      boolean flag = true;
//      if(player instanceof EntityPlayer) {
//        flag = ((EntityPlayer) player).func_184825_o(0.5F) > 0.9f;
//      }
//      boolean flag2 = player.field_70143_R > 0.0F && !player.field_70122_E && !player.func_70617_f_() && !player.func_70090_H() && !player.func_70644_a(MobEffects.field_76440_q) && !player.func_184218_aH();
//      if(flag && !player.func_70051_ag() && !flag2 && player.field_70122_E && d0 < (double) player.func_70689_ay()) {
//        for(EntityLivingBase entitylivingbase : player.func_130014_f_().func_72872_a(EntityLivingBase.class, entity.func_174813_aQ().func_72314_b(1.0D, 0.25D, 1.0D))) {
//          if(entitylivingbase != player && entitylivingbase != entity && !player.func_184191_r(entitylivingbase) && player.func_70068_e(entitylivingbase) < 9.0D) {
//            entitylivingbase.func_70653_a(player, 0.4F, (double) MathHelper.func_76126_a(player.field_70177_z * 0.017453292F), (double) (-MathHelper.func_76134_b(player.field_70177_z * 0.017453292F)));
//            super.dealDamage(stack, player, entitylivingbase, 1f);
//          }
//        }
//
//        player.func_130014_f_().func_184148_a(null, player.field_70165_t, player.field_70163_u, player.field_70161_v, SoundEvents.field_187730_dW, player.func_184176_by(), 1.0F, 1.0F);
//        if(player instanceof EntityPlayer) {
//          ((EntityPlayer) player).func_184810_cG();
//        }
//      }
//    }
//
//    return hit;
//  }

  @Override
  public float getRepairModifierForPart(int index) {
    return DURABILITY_MODIFIER;
  }

  @Override
  public ToolNBT buildTagData(List<Material> materials) {
    ToolNBT data = buildDefaultTag(materials);
    // 2 base damage, like vanilla swords
    data.attack += 1f;
    data.durability *= DURABILITY_MODIFIER;
    return data;
  }
}
