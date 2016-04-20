package lance5057.tDefense.armor.events;

import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.items.cloth.TinkersRobe;
import lance5057.tDefense.armor.items.heavy.TinkersGrieves;
import lance5057.tDefense.armor.items.light.TinkersChausses;
import lance5057.tDefense.armor.modifiers.ArmorMods;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import tconstruct.library.tools.ToolCore;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ArmorModEvents
{
	@SubscribeEvent
	public void AddProtections(LivingHurtEvent event)
	{
		int epf = 0;

		if(event.entityLiving instanceof EntityPlayer)
		{
			((EntityPlayer) event.entityLiving).addChatComponentMessage(new ChatComponentText(event.source.getDamageType() + " - Max: " + Double.toString(event.ammount)));
		}

		for(int i = 0; i < 4; i++)
		{
			ItemStack armor = event.entityLiving.getEquipmentInSlot(i + 1);
			if(armor != null && armor.getItem() instanceof ArmorCore)
			{
				NBTTagCompound tags = armor.getTagCompound().getCompoundTag("InfiTool");

				if(!event.source.isUnblockable())
				{
					if(tags.hasKey("Protection"))
						epf += (calcModifierDamage(tags.getInteger("Protection"), 1f, event.source));
					else if(tags.hasKey("Fire Protection") && event.source.isFireDamage())
						epf += (calcModifierDamage(tags.getInteger("Fire Protection"), 2f, event.source));
					else if(tags.hasKey("Blast Protection") && event.source.isExplosion())
						epf += (calcModifierDamage(tags.getInteger("Blast Protection"), 2f, event.source));
					else if(tags.hasKey("Projectile Protection") && event.source.isProjectile())
						epf += (calcModifierDamage(tags.getInteger("Projectile Protection"), 2f, event.source));
				}
				else if(tags.hasKey("Featherfall") && event.source.getDamageType() == event.source.fall.getDamageType())
					epf += (calcModifierDamage(tags.getInteger("Featherfall"), 3f, event.source));
			}
		}

		if(epf > 20)
			epf = 20;

		float adjustedPerc = (float) (1f - (epf * 0.04));
		event.ammount = adjustedPerc * event.ammount;

		if(event.entityLiving instanceof EntityPlayer)
		{
			((EntityPlayer) event.entityLiving).addChatComponentMessage(new ChatComponentText(event.source.getDamageType() + " - Adjusted: " + Double.toString(event.ammount)));
		}
	}

	public int calcModifierDamage(int level, float typeMod, DamageSource source)
	{
		if(source.canHarmInCreative())
		{
			return 0;
		}
		else
		{
			float f = (float) (6 + level * level) / 3.0F;
			return MathHelper.floor_float(f * typeMod);
		}
	}
}
