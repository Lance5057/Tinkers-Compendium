package lance5057.tDefense.core.materials.traits;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;

public class TraitFrostBorn extends AbstractTDTrait {

	public TraitFrostBorn() {
		super("frostborn", TextFormatting.AQUA);
	}

	@Override
	public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
		newDamage = damage;
		Block b = entity.world.getBlockState(new BlockPos(entity.posX, entity.posY - 1, entity.posZ)).getBlock();
		Block b2 = entity.world.getBlockState(new BlockPos(entity.posX, entity.posY, entity.posZ)).getBlock();
		if ((b == Blocks.SNOW || b == Blocks.SNOW_LAYER || b == Blocks.ICE || b == Blocks.FROSTED_ICE
				|| b2 == Blocks.PACKED_ICE)
				|| (b2 == Blocks.SNOW || b2 == Blocks.SNOW_LAYER || b2 == Blocks.ICE || b2 == Blocks.FROSTED_ICE
						|| b2 == Blocks.PACKED_ICE))
			newDamage *= 0.75f;

		return newDamage;
	}
}
