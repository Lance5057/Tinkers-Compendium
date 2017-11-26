package lance5057.tDefense.core.materials.traits;

import java.util.Optional;

import net.minecraft.block.BlockFence;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.mantle.util.RecipeMatch.Match;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitDogToy extends AbstractTrait {

	public TraitDogToy() {
		super("dogtoy", TextFormatting.WHITE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {

		if (event.getSource().getTrueSource() instanceof EntityLiving || event.getSource().getImmediateSource() instanceof EntityLiving ) {
			BlockPos pos = new BlockPos(player.posX + player.world.rand.nextInt(10) - 5, player.posY,
					player.posZ + player.world.rand.nextInt(10) - 5);
			IBlockState iblockstate = player.world.getBlockState(pos);

			EnumFacing facing = player.getHorizontalFacing();
			pos = pos.offset(facing);
			double d0 = 0.0D;

			if (facing == EnumFacing.UP && iblockstate.getBlock() instanceof BlockFence) // Forge:
																							// Fix
																							// Vanilla
																							// bug
																							// comparing
																							// state
																							// instead
																							// of
																							// block
			{
				d0 = 0.5D;
			}

			EntityWolf entWolf = new EntityWolf(player.world);
			entWolf.setLocationAndAngles(pos.getX() + 0.5D, (double) pos.getY() + d0, (double) pos.getZ() + 0.5D,
					MathHelper.wrapDegrees(player.world.rand.nextFloat() * 360.0F), 0.0F);
			entWolf.rotationYawHead = entWolf.rotationYaw;
			entWolf.renderYawOffset = entWolf.rotationYaw;
			entWolf.onInitialSpawn(player.world.getDifficultyForLocation(new BlockPos(entWolf)),
					(IEntityLivingData) null);
			
			if(event.getSource().getTrueSource() instanceof EntityLiving)
				entWolf.setAttackTarget((EntityLivingBase) event.getSource().getTrueSource());
			else
				entWolf.setAttackTarget((EntityLivingBase) event.getSource().getImmediateSource());
			
			entWolf.setAngry(true);
			entWolf.setCollarColor(EnumDyeColor.BLACK);
			entWolf.setTamed(true);
			player.world.spawnEntity(entWolf);
			entWolf.playLivingSound();

			entWolf.setCustomNameTag("Guard Dog");
			entWolf.setDropItemsWhenDead(false);

			// applyItemEntityDataToEntity(player.world, player, null, entity);
		}
	}

	@Override
	public Optional<Match> matches(NonNullList<ItemStack> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
