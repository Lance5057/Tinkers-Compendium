package lance5057.tDefense.core.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UnstableBlock extends Block
{
	Block revert = Blocks.AIR;
	public UnstableBlock(Material blockMaterialIn, MapColor blockMapColorIn, Block revert, float lightValue, float slipValue) {
		super(blockMaterialIn, blockMapColorIn);
		
		this.setTickRandomly(true);
		this.setHardness(5.0F);
        this.setLightOpacity(1);
        this.setLightLevel(lightValue);
        this.setDefaultSlipperiness(slipValue);
        
        this.revert = revert;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		worldIn.setBlockState(pos, revert.getDefaultState());
    }
}
