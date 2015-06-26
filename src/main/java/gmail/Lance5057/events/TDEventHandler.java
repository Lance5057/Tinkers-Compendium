package gmail.Lance5057.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.MinecraftForge;
import mods.battlegear2.api.PlayerEventChild.ShieldBlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TDEventHandler {
	
	public TDEventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void TD_ShieldBlock(ShieldBlockEvent event)
	{
		NBTTagCompound tags = event.shield.getTagCompound().getCompoundTag("InfiTool");
		
		if (!tags.getBoolean("Broken")) 
		{
			event.getPlayer().addChatComponentMessage(new ChatComponentText("Pow!"));

			if(tags.hasKey("Crest of Mirrors"))
			{
				Entity test = event.source.getSourceOfDamage();
				
				
				if(event.source.getSourceOfDamage() instanceof EntityLargeFireball ||
						event.source.getSourceOfDamage() instanceof EntityFireball )
				{
					EntityFireball ent = (EntityFireball) event.source.getSourceOfDamage();
					//EntityFireball newEnt = new EntityFireball();
					Vec3 playerlook = event.getPlayer().getLookVec();
					
					//ent.attackEntityFrom(, 1);
					
					
					//ent.setBeenAttacked();
					
					ent.motionX = playerlook.xCoord;
					ent.motionY = playerlook.yCoord;
					ent.motionZ = playerlook.zCoord;
					ent.accelerationX = ent.motionX * 0.1D;
					ent.accelerationY = ent.motionY * 0.1D;
					ent.accelerationZ = ent.motionZ * 0.1D;
					
	                ent.shootingEntity = event.getPlayer();
	                
	                ent.motionX += ent.accelerationX*2;
	                ent.motionY += ent.accelerationY*2;
	                ent.motionZ += ent.accelerationZ*2;
	                
	                //ent.
					
					ent.setDead();
					
					event.getPlayer().addChatComponentMessage(new ChatComponentText("Nom"));
				}
			}
			
			if(tags.hasKey("Crest of Legends"))
			{
				event.getPlayer().addPotionEffect(new PotionEffect(Potion.fireResistance.getId(),4,30));
				event.getPlayer().addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),4,30));
				event.getPlayer().addPotionEffect(new PotionEffect(Potion.resistance.getId(),4,30));
			}
			
			if(tags.hasKey("Crest of Vampires"))
			{
				event.getPlayer().heal(event.ammount/tags.getInteger("Crest of Vampires"));
			}
		}
	}
}
