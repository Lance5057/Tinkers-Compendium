package lance5057.tDefense.armor.events;

import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersHelm;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderPlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ArmorRenderEvent
{

	@SubscribeEvent
	public void renderArmorEvent(RenderPlayerEvent.SetArmorModel event) {
		if (event.entityPlayer != null) 
		{
			for(int i = 0; i < 4 ; i++)
			{
				if(event.entityPlayer.inventory.armorItemInSlot(i) != null)
				{
					ItemStack Armor = event.entityPlayer.inventory.armorItemInSlot(i);
					NBTTagCompound tags = Armor.getTagCompound();
					
					if(Armor.getItem() instanceof ArmorCore)
					{
						ArmorCore AArmor = (ArmorCore)Armor.getItem();
						String color[] = new String[10];
						
						for(int j = 0; j<10; j++)
							color[j] = Integer.toHexString(AArmor.getColorFromItemStack(Armor, j));
						
						ModelBiped armorModel = AArmor.getModel(color, tags);
						
						if (armorModel != null) {
							armorModel.isSneak = event.entityPlayer.isSneaking();
							armorModel.isRiding = event.entityPlayer.isRiding();
							armorModel.isChild = event.entityPlayer.isChild();
							armorModel.heldItemRight = event.entityPlayer.getHeldItem() != null ? 1
									: 0;

							if (event.entityPlayer instanceof EntityPlayer) {
								armorModel.aimedBow = ((EntityPlayer) event.entityPlayer)
										.getItemInUseDuration() > 2;
							}
						}
						
						float yaw = event.entityPlayer.prevRotationYawHead + (event.entityPlayer.rotationYawHead - event.entityPlayer.prevRotationYawHead) * event.partialRenderTick;
						float yawOffset = event.entityPlayer.prevRenderYawOffset + (event.entityPlayer.renderYawOffset - event.entityPlayer.prevRenderYawOffset) * event.partialRenderTick;
			            float limbs = event.entityPlayer.prevLimbSwingAmount + (event.entityPlayer.limbSwingAmount - event.entityPlayer.prevLimbSwingAmount) * event.partialRenderTick;
			            float limbSwing = event.entityPlayer.limbSwing - event.entityPlayer.limbSwingAmount * (1.0F - event.partialRenderTick);
			            
						armorModel.render(event.entityPlayer, limbSwing, limbs,event.entityPlayer.ticksExisted ,
								yaw - yawOffset
								, event.entityPlayer.rotationPitch, 0.1f);
					}
				}
			}
		}
	}
	
}
