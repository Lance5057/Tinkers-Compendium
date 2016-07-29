package lance5057.tDefense.core.events;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.parts.ClothMaterial;
import lance5057.tDefense.core.tools.RoundShield;
import mods.battlegear2.api.PlayerEventChild.ShieldBlockEvent;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.event.PartBuilderEvent;
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

			final ClothMaterial mat = (ClothMaterial) TConstructRegistry.getCustomMaterial(event.material, ClothMaterial.class);
			if(mat != null && event.material.stackSize >= 3)
			{
				result = mat.craftingItem.copy();
			}

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
		if(event.shield.getItem() instanceof RoundShield)
		{
			final EntityLiving entity = (EntityLiving) event.source.getEntity();
			entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 5,
					10));
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

	//	@SubscribeEvent
	//	public void giveCandyToUndead(LivingSpawnEvent event)
	//	{
	//		//if(!Minecraft.getMinecraft().theWorld.isRemote)
	//		if(TinkersDefense.month == 12)
	//		{
	//			if(event.entityLiving.isEntityUndead())
	//			{
	//				Integer chance = Minecraft.getMinecraft().theWorld.rand.nextInt(100);
	//				Boolean candy = Minecraft.getMinecraft().theWorld.rand.nextBoolean();
	//				if(chance < 25)
	//				{
	//					if(candy == true)
	//						event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(TinkersDefense.item_RedMintcane, 1, 0));
	//					else
	//						event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(TinkersDefense.item_GreenMintcane, 1, 0));
	//				}
	//			}
	//		}
	//	}
}
