package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class ModWalker extends ArmorModifierTrait {
	
	
	Block toBlock;
	Block fromBlock;
	Block fromBlockFlowing;
	
	public ModWalker(String name, int color, Block fluid, Block fluidFlowing, Block changeto) {
		super(name, color);
		
		this.toBlock = changeto;
		this.fromBlock = fluid;
		this.fromBlockFlowing = fluidFlowing;
	}
	
	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		freezeNearby(player, world, player.getPosition(), 1);
	}
	
	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (!(stack.getItem() instanceof ArmorCore)) {
			return false;
		}
		
		//Helmet only
		if(((ArmorCore)stack.getItem()).armorType != EntityEquipmentSlot.FEET)
			return false;
		
		// not present yet, ok
		if (super.canApplyCustom(stack)) {
			return true;
		}
		// no max level
		else if (maxLevel == 0) {
			return false;
		}

		// already present, limit by level
		NBTTagCompound tag = TinkerUtil.getModifierTag(stack, identifier);

		return ModifierNBT.readTag(tag).level <= maxLevel;
	}
	
	public void freezeNearby(EntityLivingBase living, World worldIn, BlockPos pos, int level)
    {
//        if (living.onGround)
//        {
            float f = (float)Math.min(16, 2 + level);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(0, 0, 0);

            for (BlockPos.MutableBlockPos blockpos$mutableblockpos1 : BlockPos.getAllInBoxMutable(pos.add((double)(-f), -1.0D, (double)(-f)), pos.add((double)f, -1.0D, (double)f)))
            {
                if (blockpos$mutableblockpos1.distanceSqToCenter(living.posX, living.posY, living.posZ) <= (double)(f * f))
                {
                    blockpos$mutableblockpos.setPos(blockpos$mutableblockpos1.getX(), blockpos$mutableblockpos1.getY() + 1, blockpos$mutableblockpos1.getZ());
                    IBlockState iblockstate = worldIn.getBlockState(blockpos$mutableblockpos);

                    if (iblockstate.getMaterial() == Material.AIR)
                    {
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos$mutableblockpos1);

                        if ((iblockstate1.getBlock() == fromBlock || iblockstate1.getBlock() == fromBlockFlowing) && ((Integer)iblockstate1.getValue(BlockLiquid.LEVEL)).intValue() == 0 && worldIn.mayPlace(toBlock, blockpos$mutableblockpos1, false, EnumFacing.DOWN, (Entity)null))
                        {
                            worldIn.setBlockState(blockpos$mutableblockpos1, toBlock.getDefaultState());
                            worldIn.scheduleUpdate(blockpos$mutableblockpos1.toImmutable(), toBlock, MathHelper.getInt(living.getRNG(), 60, 120));
                        }
                    }
                }
            }
        //}
    }
}
