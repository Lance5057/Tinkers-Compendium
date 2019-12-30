package lance5057.tDefense.core.materials.traits;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class TraitHeavyweight extends AbstractTDTrait {
	public TraitHeavyweight() {
		super("heavyweight", TextFormatting.RED);
	}

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {

		if (e.getSource() == DamageSource.FALL) {
			EntityLivingBase ent = e.getEntityLiving();

			for (int x = (int) (-1 * ent.fallDistance); x < 1 * ent.fallDistance; x++) {
				for (int y = (int) (-1 * ent.fallDistance); y < 1 * ent.fallDistance; y++) {
					BlockPos underPlayer = new BlockPos(ent.posX + x, ent.posY - 1, ent.posZ + y);

					IBlockState block = ent.world.getBlockState(underPlayer);
					Block b = block.getBlock();
					
					if (b == Blocks.STONE) {
						ent.world.setBlockState(underPlayer, Blocks.COBBLESTONE.getDefaultState());
					}
					
					ent.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, underPlayer.getX(), underPlayer.getY(), underPlayer.getZ(), ent.world.rand.nextInt(5), Math.abs((x+y) + ent.fallDistance), ent.world.rand.nextInt(5), new int[0]);
				}
			}
			
			AxisAlignedBB aabb = new AxisAlignedBB(ent.posX + (-1 * ent.fallDistance), ent.posY + (-1 * ent.fallDistance), ent.posZ + (-1 * ent.fallDistance), ent.posX + (1 * ent.fallDistance), ent.posY + (1 * ent.fallDistance), ent.posZ + (1 * ent.fallDistance));
			for(Entity entity: ent.world.getEntitiesInAABBexcluding(ent, aabb, null))
			{
				entity.attackEntityFrom(DamageSource.MAGIC, 2);
			}

			e.setAmount(e.getAmount() * 1.5f);
		}
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if (player.motionY < 0) {
			player.motionY *= 1.1f;
		}
	}
}
