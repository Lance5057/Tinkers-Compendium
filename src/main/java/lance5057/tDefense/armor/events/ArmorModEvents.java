package lance5057.tDefense.armor.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class ArmorModEvents 
{
	@SubscribeEvent
	public void AddProtections(LivingHurtEvent event)
	{
//		if(event.entityLiving instanceof EntityPlayer)
//			((EntityPlayer)event.entity).addChatComponentMessage(new ChatComponentText("Damage Recieved:" + Double.toString(event.ammount)));
	}
}
