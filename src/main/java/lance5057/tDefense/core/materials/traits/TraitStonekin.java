package lance5057.tDefense.core.materials.traits;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitStonekin extends AbstractTDTrait
{
	public TraitStonekin() {
		super("stonekin", TextFormatting.RED);
	}
	
	@Override
	  public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		
		if(ToolHelper.getCurrentDurability(tool) < ToolHelper.getMaxDurability(tool))
		{
			BlockPos underPlayer = new BlockPos(player.posX, player.posY -1, player.posZ);

			IBlockState block = world.getBlockState(underPlayer);
			if(block == Blocks.STONE)
			{
				ToolHelper.repairTool(tool, 5);
				world.setBlockState(underPlayer, Blocks.COBBLESTONE.getDefaultState());
			}
			else if(block == Blocks.COBBLESTONE)
			{
				ToolHelper.repairTool(tool, 5);
				world.setBlockState(underPlayer, Blocks.GRAVEL.getDefaultState());
			}
			else if(block == Blocks.GRAVEL)
			{
				ToolHelper.repairTool(tool, 5);
				world.setBlockState(underPlayer, Blocks.SAND.getDefaultState());
			}
			else if(block == Blocks.SAND)
			{
				ToolHelper.repairTool(tool, 5);
				world.setBlockState(underPlayer, Blocks.AIR.getDefaultState());
			}
		}
	  }
}
