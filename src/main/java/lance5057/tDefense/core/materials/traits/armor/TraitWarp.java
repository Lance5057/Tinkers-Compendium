package lance5057.tDefense.core.materials.traits.armor;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitWarp extends AbstractTDTrait {
	public TraitWarp() {
		super("warp", TextFormatting.WHITE);
		// TODO Auto-generated constructor stub
	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		EnumDifficulty d = e.getEntityLiving().world.getDifficulty();

		int rand = e.getEntityLiving().world.rand.nextInt(100);

		if (60 - d.ordinal() > rand) {
			Entity ent = e.getSource().getTrueSource();
			if (ent instanceof EntityLivingBase) {
				((EntityLivingBase) ent).attemptTeleport(ent.posX + ent.world.rand.nextInt(32) - 16, ent.posY + ent.world.rand.nextInt(32) - 16, ent.posZ = ent.posZ + ent.world.rand.nextInt(32) - 16);
			}
		}
	}

}
