package lance5057.tDefense.core.blocks.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;
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
			EntityWitherSkeleton wither = new EntityWitherSkeleton(world);
			wither.setPosition(entity.posX, entity.posY, entity.posZ);
			world.spawnEntity(wither);
			entity.setDead();
		}
		if (entity instanceof EntityZombie) {
			EntityHusk husk = new EntityHusk(world);
			husk.setPosition(entity.posX, entity.posY, entity.posZ);
			world.spawnEntity(husk);
			entity.setDead();
		}
		if (entity instanceof EntityHorse) {
			if (world.rand.nextInt(2) == 0) {
				EntitySkeletonHorse horse = new EntitySkeletonHorse(world);
				horse.setPosition(entity.posX, entity.posY, entity.posZ);
				world.spawnEntity(horse);
				entity.setDead();
			} else {
				EntityZombieHorse horse = new EntityZombieHorse(world);
				horse.setPosition(entity.posX, entity.posY, entity.posZ);
				world.spawnEntity(horse);
				entity.setDead();
			}
		}
		if (entity instanceof EntityPig) {
			EntityPigZombie pig = new EntityPigZombie(world);
			pig.setPosition(entity.posX, entity.posY, entity.posZ);
			world.spawnEntity(pig);
			entity.setDead();
		}
	}
}
