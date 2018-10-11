package lance5057.tDefense.core.worldgen;

import java.util.Random;

import com.google.common.base.Predicate;

import lance5057.tDefense.core.materials.TDMaterials;
import lance5057.tDefense.util.MaterialHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		for (MaterialHelper mat : TDMaterials.materials) {
			genOre(mat, world, random, chunkX, chunkZ);
			genGravelOre(mat, world, random, chunkX, chunkZ);
			genSandOre(mat, world, random, chunkX, chunkZ);
		}
	}

	private void genOre(MaterialHelper mat, World world, Random rand, int chunk_X, int chunk_Z) {
		{
			if (mat.genOre) {
				if (mat.oreDim == world.provider.getDimension()) {
					WorldGenMinable generator = new WorldGenMinable(mat.ore.getDefaultState(), mat.oreSize,
							(Predicate<IBlockState>) Blocks.STONE.getDefaultState());

					int heightdiff = mat.oreYMax - mat.oreYMin + 1;
					for (int i = 0; i < mat.oreChance; i++) {
						int x = chunk_X * 16 + rand.nextInt(16);
						int y = mat.oreYMin + rand.nextInt(heightdiff);
						int z = chunk_Z * 16 + rand.nextInt(16);

						generator.generate(world, rand, new BlockPos(x, y, z));
					}
				}

			}
		}
	}
	private void genGravelOre(MaterialHelper mat, World world, Random rand, int chunk_X, int chunk_Z) {
		{
			if (mat.genGravelOre) {
				if (mat.gravelOreDim == world.provider.getDimension()) {
					WorldGenMinable generator = new WorldGenMinable(mat.gravelOre.getDefaultState(), mat.gravelOreSize,
							(Predicate<IBlockState>) Blocks.GRAVEL.getDefaultState());

					int heightdiff = mat.gravelOreYMax - mat.gravelOreYMin + 1;
					for (int i = 0; i < mat.gravelOreChance; i++) {
						int x = chunk_X * 16 + rand.nextInt(16);
						int y = mat.gravelOreYMin + rand.nextInt(heightdiff);
						int z = chunk_Z * 16 + rand.nextInt(16);

						generator.generate(world, rand, new BlockPos(x, y, z));
					}
				}

			}
		}
	}
	private void genSandOre(MaterialHelper mat, World world, Random rand, int chunk_X, int chunk_Z) {
		{
			if (mat.genSandOre) {
				if (mat.sandOreDim == world.provider.getDimension()) {
					WorldGenMinable generator = new WorldGenMinable(mat.sandOre.getDefaultState(), mat.sandOreSize,
							(Predicate<IBlockState>) Blocks.STONE.getDefaultState());

					int heightdiff = mat.sandOreYMax - mat.sandOreYMin + 1;
					for (int i = 0; i < mat.sandOreChance; i++) {
						int x = chunk_X * 16 + rand.nextInt(16);
						int y = mat.sandOreYMin + rand.nextInt(heightdiff);
						int z = chunk_Z * 16 + rand.nextInt(16);

						generator.generate(world, rand, new BlockPos(x, y, z));
					}
				}

			}
		}
	}
}
