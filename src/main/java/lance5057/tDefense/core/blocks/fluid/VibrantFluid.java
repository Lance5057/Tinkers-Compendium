package lance5057.tDefense.core.blocks.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class VibrantFluid extends BlockFluidClassic {

	public VibrantFluid(Fluid fluid) {
		super(fluid, Material.WATER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		dirtToGrass(state, worldIn, pos);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
		super.neighborChanged(state, worldIn, pos, blockIn);
		dirtToGrass(state, worldIn, pos);
	}

	private void dirtToGrass(IBlockState state, World worldIn, BlockPos pos) {
		for (EnumFacing enumfacing : EnumFacing.values()) {
			if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() == Blocks.DIRT) {
				if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() != this.getBlockState().getBlock()) {
					worldIn.setBlockState(pos.offset(enumfacing), Blocks.GRASS.getDefaultState());
					break;
				}
			}
			if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() == Blocks.COBBLESTONE) {
				if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() != this.getBlockState().getBlock()) {
					worldIn.setBlockState(pos.offset(enumfacing), Blocks.MOSSY_COBBLESTONE.getDefaultState());
					break;
				}
			}
			if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() == Blocks.STONEBRICK) {
				if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() != this.getBlockState().getBlock()) {
					worldIn.setBlockState(pos.offset(enumfacing), Blocks.STONEBRICK.getStateFromMeta(1));
					break;
				}
			}
		}
	}
}
