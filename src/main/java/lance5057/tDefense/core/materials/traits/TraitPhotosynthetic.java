package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class TraitPhotosynthetic extends AbstractTraitLeveled {

	public TraitPhotosynthetic(int level) {
		super("photosynthetic", 0x875e21, 2, level);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if (!world.isRemote && random.nextInt(200) == 0) {

			ModifierNBT data = new ModifierNBT(TinkerUtil.getModifierTag(tool, name));

			if (player.getFoodStats().getSaturationLevel() < player.getFoodStats().getFoodLevel()) {
				if (world.canBlockSeeSky(new BlockPos(player)))
					player.getFoodStats()
							.setFoodSaturationLevel(player.getFoodStats().getSaturationLevel() + (data.level * 0.5f));
				if (world.isRainingAt(new BlockPos(player)))
					player.getFoodStats()
							.setFoodSaturationLevel(player.getFoodStats().getSaturationLevel() + (data.level * 0.5f));
			}
			if (player.getFoodStats().getSaturationLevel() < player.getFoodStats().getFoodLevel())
				player.getFoodStats().setFoodSaturationLevel(player.getFoodStats().getFoodLevel());
		}
	}
}
