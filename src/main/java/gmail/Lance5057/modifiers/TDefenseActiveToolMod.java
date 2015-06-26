package gmail.Lance5057.modifiers;

import java.util.ArrayList;
import java.util.Random;

import mods.battlegear2.api.core.IBattlePlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.tools.ToolCore;

public class TDefenseActiveToolMod extends ActiveToolMod {
	@Override
	public void updateTool(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");
		
		if (!tags.getBoolean("Broken")) 
		{
			//stack.getTagCompound().getCompoundTag("InfiTool").setInteger("RenderHead", 100);
			if(((IBattlePlayer)entity).isBlockingWithShield())
			{
				if(tags.hasKey("Crest of Mirrors"))
				{
					AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(((EntityLivingBase)entity).posX - 3, ((EntityLivingBase)entity).posY - 3, ((EntityLivingBase)entity).posZ - 3, ((EntityLivingBase)entity).posX + 3, ((EntityLivingBase)entity).posY + 3, ((EntityLivingBase)entity).posZ + 3);
					
			        ArrayList<EntityFireball> fireballs = (ArrayList<EntityFireball>) world.getEntitiesWithinAABB(EntityFireball.class, boundingBox);
			        for (EntityFireball fireball : fireballs) 
			        {
			            if (fireball.getDistanceSqToEntity(((EntityLivingBase)entity)) <= 25) 
			            {
			            	Vec3 playerlook = ((EntityLivingBase)entity).getLookVec();
			            	
			            	fireball.motionX = playerlook.xCoord;
			            	fireball.motionY = playerlook.yCoord;
			            	fireball.motionZ = playerlook.zCoord;
			            	fireball.accelerationX = fireball.motionX * 0.1D;
							fireball.accelerationY = fireball.motionY * 0.1D;
							fireball.accelerationZ = fireball.motionZ * 0.1D;
							
							fireball.shootingEntity = ((EntityLivingBase)entity);
							
							((EntityLivingBase)entity).worldObj.playSoundAtEntity(((EntityLivingBase)entity), "battlegear2:shield", 1, 1);
			            }
			        }
				}
			}
		}
	}
	
	@Override

	public int baseAttackDamage(int earlyModDamage, int damage, ToolCore tool,
			NBTTagCompound tags, NBTTagCompound toolTags, ItemStack stack,
			EntityLivingBase player, Entity entity) {
		if (!toolTags.hasKey("Broken")) {
			if (toolTags.hasKey("Daze")) {
				int[] array = toolTags.getIntArray("Daze");
				int chance = array[0] * 5;

				Random roll = new Random();
				int num = roll.nextInt(100) + 1;

				if (num <= chance) {
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(2, 3 * 20, 100));
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(9, 3 * 20, 100));
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(15, 3 * 20, 100));
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(18, 3 * 20, 100));
				}
			}
		}

		return 0;
	}
}
