package lance5057.tDefense.core.materials.traits;


import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitIntangible extends AbstractTrait {
	public TraitIntangible() {
		super("intangible", 0xa470e0);
		MinecraftForge.EVENT_BUS.register(this);
	}


	public static float chance = 0.8f;

	@SubscribeEvent
	public void onImpact(ProjectileImpactEvent event) {
		if (event.getRayTraceResult().typeOfHit.equals(RayTraceResult.Type.ENTITY)) {
			Entity entity = event.getRayTraceResult().entityHit;
			for (ItemStack toolStack : entity.getArmorInventoryList()) {
				if (this.isToolWithTrait(toolStack)) {
					if (random.nextFloat() < chance) {
						event.setCanceled(true);
					}
				}
			}
		}
	}
}

