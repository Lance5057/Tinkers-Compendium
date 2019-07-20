package lance5057.tDefense.core.blocks.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class ChorusJuice extends BlockFluidClassic {
	public ChorusJuice(Fluid fluid) {
		super(fluid, Material.WATER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase ent = (EntityLivingBase) entity;
			double d0 = ent.posX + (world.rand.nextDouble() - 0.5D) * 64.0D;
			double d1 = ent.posY + (double) (world.rand.nextInt(64) - 32);
			double d2 = ent.posZ + (world.rand.nextDouble() - 0.5D) * 64.0D;
			
			this.teleportTo(ent, d0, d1, d2);
		}
	}

	private boolean teleportTo(EntityLivingBase entity, double x, double y, double z) {
		net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(
				entity, x, y, z, 0);
		if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
			return false;
		boolean flag = entity.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());

		if (flag) {
			entity.world.playSound((EntityPlayer) null, entity.prevPosX, entity.prevPosY, entity.prevPosZ,
					SoundEvents.ENTITY_ENDERMEN_TELEPORT, entity.getSoundCategory(), 1.0F, 1.0F);
			entity.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
		}

		return flag;
	}
}
