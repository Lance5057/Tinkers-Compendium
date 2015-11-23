package lance5057.tDefense.armor.events;

import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersHelm;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ArmorRenderEvent
{

	@SubscribeEvent
	public void renderArmorEvent(RenderPlayerEvent.Specials.Post event) {
		if (event.entityPlayer != null) 
		{
			for(int i = 0; i < 4 ; i++)
			{
				if(event.entityPlayer.inventory.armorItemInSlot(i) != null)
				{
					ItemStack Armor = event.entityPlayer.inventory.armorItemInSlot(i);
					
					if(Armor.getItem() instanceof ArmorCore)
					{
						ArmorCore AArmor = (ArmorCore)Armor.getItem();
						String color[] = new String[10];
						
						for(int j = 0; j<10; j++)
							color[j] = Integer.toHexString(AArmor.getColorFromItemStack(Armor, j));
						
						ModelBiped armorModel = AArmor.getModel(color);
						
						float size;
						switch(AArmor.getSlot())
						{
						case 0: size = 0.085f; break;
						case 1: size = .126f; break;
						
						default: size = 0.1f; break;
						}
						
						float yaw = event.entityPlayer.prevRotationYawHead + (event.entityPlayer.rotationYawHead - event.entityPlayer.prevRotationYawHead) * event.partialRenderTick;
						float yawOffset = event.entityPlayer.prevRenderYawOffset + (event.entityPlayer.renderYawOffset - event.entityPlayer.prevRenderYawOffset) * event.partialRenderTick;
			            float limbs = event.entityPlayer.prevLimbSwingAmount + (event.entityPlayer.limbSwingAmount - event.entityPlayer.prevLimbSwingAmount) * event.partialRenderTick;
						
						armorModel.render(event.entityPlayer, event.entityPlayer.limbSwing, limbs,event.entityPlayer.ticksExisted ,
								yaw - yawOffset
								, event.entityPlayer.rotationPitch, size);
					}
				}
			}
		}
	}
	
}
