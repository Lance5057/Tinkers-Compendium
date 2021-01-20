package lance5057.tDefense.core.materials.traits;


import java.util.*;

import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import slimeknights.tconstruct.library.traits.*;
import slimeknights.tconstruct.library.utils.*;


import java.util.List;

public class TraitIlluminating extends AbstractTDTrait {

    public TraitIlluminating() {
        super("illuminating", 0xFFFF73);
    }


    public static AxisAlignedBB AABBfromVecs(Vec3d v1, Vec3d v2) {
        return new AxisAlignedBB(v1.x, v1.y, v1.z, v2.x, v2.y, v2.z);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (entity instanceof EntityLivingBase) {
            List<EntityLivingBase> lst = world.getEntitiesWithinAABB(EntityLivingBase.class, AABBfromVecs(
                    entity.getPositionVector().subtract(16, 16, 16),
                    entity.getPositionVector().addVector(16, 16, 16)),
                    ent -> !ent.equals(entity) && !TinkerUtil.hasTrait(TagUtil.getTagSafe(ent.getHeldItemMainhand()), identifier));
            for (EntityLivingBase ent: lst) {
                ent.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 20, 0, true, false));
            }
        }
    }

}
