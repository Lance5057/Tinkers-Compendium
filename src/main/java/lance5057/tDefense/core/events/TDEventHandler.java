package lance5057.tDefense.core.events;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.parts.ClothMaterial;
import mods.battlegear2.api.PlayerEventChild.ShieldBlockEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.event.PartBuilderEvent;
import tconstruct.library.tools.BowstringMaterial;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Optional.InterfaceList({@Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.PlayerEventChild.ShieldBlockEvent"),})
public class TDEventHandler
{

	public TDEventHandler()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void craftTDPart(PartBuilderEvent.NormalPart event)
	{
		// Cloth
		if(event.pattern.getItem() == TinkersDefense.woodPattern && event.pattern.getItemDamage() == 3)
		{
			ItemStack result = null;

			ClothMaterial mat = (ClothMaterial) TConstructRegistry.getCustomMaterial(event.material, ClothMaterial.class);
			if(mat != null && event.material.stackSize >= 3)
				result = mat.craftingItem.copy();

			if(result != null)
			{
				event.overrideResult(new ItemStack[] {result, null});
			}
		}
	}

	@SubscribeEvent
	@Optional.Method(modid = "battlegear2")
	public void TD_ShieldBlock(ShieldBlockEvent event)
	{
		NBTTagCompound tags = event.shield.getTagCompound().getCompoundTag("InfiTool");

		if(!tags.getBoolean("Broken"))
		{

			if(tags.hasKey("Crest of Mirrors"))
			{
				Entity test = event.source.getSourceOfDamage();

				if(event.source.getSourceOfDamage() instanceof EntityLargeFireball || event.source.getSourceOfDamage() instanceof EntityFireball)
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

					ent.motionX += ent.accelerationX * 2;
					ent.motionY += ent.accelerationY * 2;
					ent.motionZ += ent.accelerationZ * 2;

					//ent.

					ent.setDead();
				}
			}

			if(tags.hasKey("Crest of Legends"))
			{
				event.getPlayer().addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 4, 30));
				event.getPlayer().addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 4, 30));
				event.getPlayer().addPotionEffect(new PotionEffect(Potion.resistance.getId(), 4, 30));
			}

			if(tags.hasKey("Crest of Vampires"))
			{
				event.getPlayer().heal(event.ammount / tags.getInteger("Crest of Vampires"));
			}
		}
	}

	//	public void TD_LivingHurt(LivingHurtEvent event)
	//	{
	//		if(event.entityLiving instanceof EntityPlayer)
	//		event.entityLiving
	//	}

	//	@SubscribeEvent
	//	public void dropEasterEggs(LivingDropsEvent event)
	//	{
	//		if(!event.entityLiving.worldObj.isRemote)
	//		{
	//			if(event.entityLiving.getHeldItem() != null)
	//					if(event.entityLiving.getHeldItem().getItem() == TinkersDefense.item_RedMintcane)
	//							event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(TinkersDefense.item_RedMintcane,1,0)));
	//					if(event.entityLiving.getHeldItem().getItem() == TinkersDefense.item_GreenMintcane)
	//							event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(TinkersDefense.item_GreenMintcane,1,0)));
	//
	//		}
	//	}

	@SubscribeEvent
	public void giveCandyToUndead(LivingSpawnEvent event)
	{
		//if(!Minecraft.getMinecraft().theWorld.isRemote)
		if(TinkersDefense.month == 12)
		{
			if(event.entityLiving.isEntityUndead())
			{
				Integer chance = Minecraft.getMinecraft().theWorld.rand.nextInt(100);
				Boolean candy = Minecraft.getMinecraft().theWorld.rand.nextBoolean();
				if(chance < 25)
				{
					if(candy == true)
						event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(TinkersDefense.item_RedMintcane, 1, 0));
					else
						event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(TinkersDefense.item_GreenMintcane, 1, 0));
				}
			}
		}
	}
}
