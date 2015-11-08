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
						
						armorModel.render(event.entityPlayer, event.entityPlayer.limbSwing, event.entityPlayer.limbSwingAmount,event.entityPlayer.ticksExisted , event.entityPlayer.prevRotationYaw/* - event.entityPlayer.renderYawOffset*/, event.entityPlayer.rotationPitch, 0.0825f);
					}
				}
			}
		}
	}
	
}
