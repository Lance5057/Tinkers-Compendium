package lance5057.tDefense.core.materials.traits;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.events.TinkerProjectileImpactEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitPhasing extends AbstractTrait {

    public TraitPhasing() {
        super("phasing", 0xF1E9D4);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onImpact(TinkerProjectileImpactEvent event) {
        if (event.getEntity() != null && !event.getEntity().getEntityWorld().isRemote) {
            if (event.getRayTraceResult().typeOfHit.equals(RayTraceResult.Type.BLOCK)) {
                if (event.getEntity() instanceof EntityArrow && ((EntityArrow)event.getEntity()).shootingEntity instanceof EntityPlayer) {
                    EntityPlayer shooter = ((EntityPlayer) ((EntityArrow) event.getEntity()).shootingEntity);

                    for (ItemStack toolStack : shooter.getArmorInventoryList()) {
                        if (this.isToolWithTrait(toolStack)) {
                            event.setCanceled(true);
                        }
                    }
                }
                else {
                    return;
                }
            }
        }
    }

    @SubscribeEvent
    public void onImpact(ProjectileImpactEvent event) {
        if (event.getEntity() != null && !event.getEntity().getEntityWorld().isRemote) {
            if (event.getRayTraceResult().typeOfHit.equals(RayTraceResult.Type.BLOCK)) {
                if (event.getEntity() instanceof EntityArrow && ((EntityArrow)event.getEntity()).shootingEntity instanceof EntityPlayer) {
                    EntityPlayer shooter = ((EntityPlayer) ((EntityArrow) event.getEntity()).shootingEntity);

                    for (ItemStack toolStack : shooter.getArmorInventoryList()) {
                        if (this.isToolWithTrait(toolStack)) {
                            event.setCanceled(true);
                        }
                    }
                }
                else {
                    return;
                }
            }
        }
    }
}