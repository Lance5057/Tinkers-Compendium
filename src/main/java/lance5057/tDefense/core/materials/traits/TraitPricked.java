package lance5057.tDefense.core.materials.traits;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitPricked extends AbstractTDTrait {
	public TraitPricked() {
		super("pricked", TextFormatting.GREEN);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {

		int roll = world.rand.nextInt(100);

		if (player.isSprinting() || player.moveVertical > 0) {
			if (roll < 5)
				player.attackEntityFrom(DamageSource.CACTUS, 1);
		} else if (player.moveForward > 0 || player.moveStrafing > 0) {
			if (roll < 1)
				player.attackEntityFrom(DamageSource.CACTUS, 1);
		}
	}
}
