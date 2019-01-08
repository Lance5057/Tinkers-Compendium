package lance5057.tDefense.core.materials.traits;

import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitGreenthumb extends AbstractTDTrait {

	public TraitGreenthumb() {
		super("greenthum", TextFormatting.GREEN);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if (!world.isRemote && random.nextInt(20) == 0) {
			applyBonemeal(new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.ordinal()), world, player.getPosition(),
					player, null);
		}
	}

	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player,
			@javax.annotation.Nullable EnumHand hand) {
		IBlockState iblockstate = worldIn.getBlockState(target);

		int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate,
				stack, hand);
		if (hook != 0)
			return hook > 0;

		if (iblockstate.getBlock() instanceof IGrowable) {
			IGrowable igrowable = (IGrowable) iblockstate.getBlock();

			if (igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote)) {
				if (!worldIn.isRemote) {
					if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate)) {
						igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
					}

					stack.shrink(1);
				}

				return true;
			}
		}

		return false;
	}
}
