package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TraitIgnite extends AbstractTDTrait {

	public TraitIgnite() {
		super("ignite", TextFormatting.DARK_RED);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		
		BlockPos underPlayer = new BlockPos(player.posX, player.posY -1, player.posZ);
		if(world.getBlockState(underPlayer) == Blocks.NETHERRACK.getDefaultState())
		{
			 world.setBlockState(player.getPosition(), Blocks.FIRE.getDefaultState(), 11);
		}
	}
}
