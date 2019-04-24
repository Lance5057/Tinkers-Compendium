//package lance5057.tDefense.core.worldgen;
//
//import java.util.Random;
//
//import lance5057.tDefense.core.materials.CompendiumMaterials;
//import lance5057.tDefense.util.MaterialHelper;
//import net.minecraft.block.Block;
//import net.minecraft.block.state.pattern.BlockMatcher;
//import net.minecraft.init.Blocks;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.chunk.IChunkProvider;
//import net.minecraft.world.gen.IChunkGenerator;
//import net.minecraft.world.gen.feature.WorldGenMinable;
//import net.minecraftforge.fml.common.IWorldGenerator;
//
//public class OreGenerator implements IWorldGenerator {
//
//	@Override
//	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
//			IChunkProvider chunkProvider) {
//		for (MaterialHelper mat : CompendiumMaterials.materials) {
//			genOres(mat, world, random, chunkX, chunkZ);
//		}
//	}
//
//	private void genOres(MaterialHelper mat, World world, Random rand, int chunk_X, int chunk_Z) {
//		{
//			if (mat.stoneOreGen != null)
//				genOre(mat.stoneOreGen, Blocks.STONE, world, rand, chunk_X, chunk_Z);
//			if (mat.gravelOreGen != null)
//				genOre(mat.gravelOreGen, Blocks.GRAVEL, world, rand, chunk_X, chunk_Z);
//			if (mat.sandOreGen != null)
//				genOre(mat.sandOreGen, Blocks.SAND, world, rand, chunk_X, chunk_Z);
//			if (mat.netherOreGen != null)
//				genOre(mat.netherOreGen, Blocks.NETHERRACK, world, rand, chunk_X, chunk_Z);
//			if (mat.endOreGen != null)
//				genOre(mat.endOreGen, Blocks.END_STONE, world, rand, chunk_X, chunk_Z);
//		}
//	}
//
//	private void genOre(MaterialHelper.oreGen ore, Block replace, World world, Random rand, int chunk_X, int chunk_Z) {
//		int dim = world.provider.getDimension();
//		if ((ore.oreDimWhite == null 
//				|| checkInt(dim, ore.oreDimWhite)) 
//				&& (ore.oreDimBlack == null 
//				|| !checkInt(dim, ore.oreDimBlack))) {
//
//			WorldGenMinable generator = new WorldGenMinable(ore.oreBlock.getDefaultState(), ore.oreSize,
//					BlockMatcher.forBlock(replace));
//
//			int heightdiff = ore.oreYMax - ore.oreYMin + 1;
//			for (int i = 0; i < ore.oreChance; i++) {
//				int x = chunk_X * 16 + rand.nextInt(16);
//				int y = ore.oreYMin + rand.nextInt(heightdiff);
//				int z = chunk_Z * 16 + rand.nextInt(16);
//
//				BlockPos pos = new BlockPos(x, y, z);
//				Biome biome = world.getBiome(pos);
//
//				if ((ore.oreBiomeWhite == null 
//						|| checkBiome(biome, ore.oreBiomeWhite) )
//						&& (ore.oreBiomeBlack == null 
//						|| !checkBiome(biome, ore.oreBiomeBlack))) {
//					float temp = biome.getTemperature(pos);
//					float elevation = biome.getBaseHeight();
//					float humidity = biome.getRainfall();
//
//					if (ore.biomeTempMax == -2 || ore.biomeTempMin == -2 || (temp >= ore.biomeTempMin && temp <= ore.biomeTempMax))
//						if (ore.biomeElevationMax == -2 || ore.biomeElevationMin == -2 || (elevation >= ore.biomeElevationMin && elevation <= ore.biomeElevationMax))
//							if (ore.biomeHumidityMax == -2 || ore.biomeHumidityMin == -2 || (humidity >= ore.biomeHumidityMin && humidity <= ore.biomeHumidityMax))
//								generator.generate(world, rand, new BlockPos(x, y, z));
//				}
//			}
//		}
//	}
//
//	private boolean checkBiome(Biome current, Biome[] biomes) {
//		if (biomes != null) {
//			for (Biome b : biomes) {
//				if (current == b)
//					return true;
//			}
//		}
//		else
//			return true;
//		return false;
//	}
//
//	private boolean checkInt(int current, int[] biomes) {
//		if (biomes != null) {
//			for (int b : biomes) {
//				if (current == b)
//					return true;
//			}
//		}
//		else
//			return true;
//		return false;
//	}
//}
