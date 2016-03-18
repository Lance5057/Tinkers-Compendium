package lance5057.tDefense.core.tools.modifiers.ActiveToolMods;

import java.util.ArrayList;

import mods.battlegear2.api.core.IBattlePlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import tconstruct.library.tools.ToolCore;

public class TdefenseToolMods
{
	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(tags.hasKey("Crest of Mirrors"))
			UpdateMirrors(tool, stack, world, entity);
	}

	public void UpdateMirrors(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		if(((IBattlePlayer) entity).isBlockingWithShield())
		{
			AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(((EntityLivingBase) entity).posX - 3, ((EntityLivingBase) entity).posY - 3, ((EntityLivingBase) entity).posZ - 3, ((EntityLivingBase) entity).posX + 3, ((EntityLivingBase) entity).posY + 3, ((EntityLivingBase) entity).posZ + 3);

			ArrayList<EntityFireball> fireballs = (ArrayList<EntityFireball>) world.getEntitiesWithinAABB(EntityFireball.class, boundingBox);
			for(EntityFireball fireball : fireballs)
			{
				if(fireball.getDistanceSqToEntity(((EntityLivingBase) entity)) <= 25)
				{
					Vec3 playerlook = ((EntityLivingBase) entity).getLookVec();

					fireball.motionX = playerlook.xCoord;
					fireball.motionY = playerlook.yCoord;
					fireball.motionZ = playerlook.zCoord;
					fireball.accelerationX = fireball.motionX * 0.1D;
					fireball.accelerationY = fireball.motionY * 0.1D;
					fireball.accelerationZ = fireball.motionZ * 0.1D;

					fireball.shootingEntity = ((EntityLivingBase) entity);

					((EntityLivingBase) entity).worldObj.playSoundAtEntity(((EntityLivingBase) entity), "battlegear2:shield", 1, 1);
				}
			}
		}
	}

	public void UpdateTorchArrow(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		//entity.worldObj.ent
	}
}
