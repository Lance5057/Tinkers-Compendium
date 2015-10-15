package lance5057.tDefense.core.tools.modifiers;

import java.util.ArrayList;
import java.util.Random;

import mods.battlegear2.api.core.IBattlePlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.tools.ToolCore;
import vazkii.botania.common.entity.EntityManaBurst;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.equipment.tool.ToolCommons;
import vazkii.botania.common.item.equipment.tool.terrasteel.ItemTerraSword;

public class TDefenseActiveToolMod extends ActiveToolMod 
{
	@Override
	public void updateTool(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");
		
		if (!tags.getBoolean("Broken")) 
		{
			//Crest of Mirrors
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
			
			if(entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entity;
				PotionEffect haste = player.getActivePotionEffect(Potion.digSpeed);
				float check = haste == null ? 0.16666667F : haste.getAmplifier() == 1 ? 0.5F : 0.4F;

				if(player.getCurrentEquippedItem() == stack && player.swingProgress == check && !world.isRemote && world.rand.nextInt(2) == 0) 
				{
					EntityManaBurst burst = ((ItemTerraSword)ModItems.terraSword).getBurst(player, new ItemStack(ModItems.terraSword));
					world.spawnEntityInWorld(burst);
					ToolCommons.damageItem(stack, 1, player, 100);
					world.playSoundAtEntity(player, "botania:terraBlade", 0.4F, 1.4F);
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
