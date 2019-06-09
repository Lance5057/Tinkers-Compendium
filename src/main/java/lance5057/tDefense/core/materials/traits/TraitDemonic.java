package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitDemonic extends AbstractTDTrait {

	public TraitDemonic() {
		super("demonic", TextFormatting.DARK_RED);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if (player.dimension == -1)
			for (Entity e : world.getLoadedEntityList()) {
				if (e instanceof EntityMob) {
					EntityMob mob = (EntityMob) e;

					mob.setAttackTarget(null);
				}
			}
	}
}