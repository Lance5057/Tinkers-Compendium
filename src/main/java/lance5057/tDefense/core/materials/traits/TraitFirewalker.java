package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.core.modifiers.TDModifiers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TraitFirewalker extends AbstractTDTrait {
	int width = 3;

	public TraitFirewalker(int width) {
		super("firewalker", TextFormatting.DARK_RED);

		this.width = width;
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		
		for(int i = -width; i < width; i++)
		{
			for(int j = -width; i < width; j++)
			{
				BlockPos pos = new BlockPos(player.posX + i, player.posY, player.posZ + i);
				
				if(world.getBlockState(pos) == Blocks.WATER.getDefaultState())
				{
					world.setBlockState(pos, TDModifiers.unstable_obsidian.getDefaultState()); //TODO make into unstable obsidian
				}
			}
		}
	}
}
