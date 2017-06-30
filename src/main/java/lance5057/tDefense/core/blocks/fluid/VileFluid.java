package lance5057.tDefense.core.blocks.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.entity.monster.ZombieType;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.HorseType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class VileFluid extends BlockFluidClassic {
	public VileFluid(Fluid fluid) {
		super(fluid, Material.WATER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		if (entity instanceof EntitySkeleton) {
			((EntitySkeleton) entity).setSkeletonType(SkeletonType.WITHER);
		}
		if (entity instanceof EntityZombie) {
			((EntityZombie) entity).setZombieType(ZombieType.HUSK);
		}
		if (entity instanceof EntityHorse) {
			if (world.rand.nextInt(2) == 0 && !(((EntityHorse) entity).getType() != HorseType.SKELETON || ((EntityHorse) entity).getType() != HorseType.ZOMBIE))
				((EntityHorse) entity).setType(HorseType.SKELETON);
			else
				((EntityHorse) entity).setType(HorseType.ZOMBIE);
		}
		if (entity instanceof EntityPig) {
			EntityPigZombie pig = new EntityPigZombie(world);
			pig.setPosition(entity.posX, entity.posY, entity.posZ);
			world.spawnEntity(pig);
			entity.setDead();
		}
	}
}
