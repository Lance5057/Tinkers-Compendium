package lance5057.tDefense.armor.events;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import tconstruct.library.event.ToolCraftEvent.NormalTool;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorModEvents
{
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void ToolCraftedEvent(NormalTool event)
	{
		if(event.tool instanceof ArmorCore)
		{
			final ArmorCore armor = (ArmorCore) event.tool;
			final ArmorRenderer render = armor.getRenderer();
			final NBTTagCompound tooltags = event.toolTag;
			final NBTTagCompound tags = armor.getRenderer().defaultTags;//stack.setTagCompound();

			//			for(int i = 0; i < render.defaultTags.; i++)
			//			{
			//				final String rendertag = ((ModelRenderer) render.boxList.get(i)).boxName;
			//				if(rendertag != null)
			//				{
			//					tags.setBoolean(rendertag, ((ModelRenderer) render.boxList.get(i)).isHidden);
			//				}
			//			}

			if(!tags.hasNoTags())
			{
				tooltags.setTag("ArmorRenderer", tags);
			}
		}
	}

	@SubscribeEvent
	public void AddProtections(LivingHurtEvent event)
	{
		int epf = 0;

		if(TinkersDefense.config.debug && event.entityLiving instanceof EntityPlayer)
		{
			((EntityPlayer) event.entityLiving).addChatComponentMessage(new ChatComponentText(
					event.source.getDamageType() + " - Max: " + Double.toString(event.ammount)));
		}

		for(int i = 0; i < 4; i++)
		{
			final ItemStack armor = event.entityLiving.getEquipmentInSlot(i + 1);
			if(armor != null && armor.getItem() instanceof ArmorCore)
			{
				final NBTTagCompound tags = armor.getTagCompound().getCompoundTag("InfiTool");

				if(!event.source.isUnblockable())
				{
					if(tags.hasKey("Protection"))
					{
						epf += (calcModifierDamage(tags.getInteger("Protection"), 1f, event.source));
					}
					else if(tags.hasKey("Fire Protection") && event.source.isFireDamage())
					{
						epf += (calcModifierDamage(tags.getInteger("Fire Protection"), 2f, event.source));
					}
					else if(tags.hasKey("Blast Protection") && event.source.isExplosion())
					{
						epf += (calcModifierDamage(tags.getInteger("Blast Protection"), 2f, event.source));
					}
					else if(tags.hasKey("Projectile Protection") && event.source.isProjectile())
					{
						epf += (calcModifierDamage(tags.getInteger("Projectile Protection"), 2f, event.source));
					}
				}
				else if(tags.hasKey("Featherfall") && event.source.getDamageType() == DamageSource.fall.getDamageType())
				{
					epf += (calcModifierDamage(tags.getInteger("Featherfall"), 3f, event.source));
				}
			}
		}

		if(epf > 20)
		{
			epf = 20;
		}

		final float adjustedPerc = (float) (1f - (epf * 0.04));
		event.ammount = adjustedPerc * event.ammount;

		if(TinkersDefense.config.debug && event.entityLiving instanceof EntityPlayer)
		{
			((EntityPlayer) event.entityLiving).addChatComponentMessage(new ChatComponentText(
					event.source.getDamageType() + " - Adjusted: " + Double.toString(event.ammount)));
		}
	}

	public int calcModifierDamage(int level, float typeMod, DamageSource source)
	{
		if(source.canHarmInCreative())
			return 0;
		else
		{
			final float f = (6 + level * level) / 3.0F;
			return MathHelper.floor_float(f * typeMod);
		}
	}
}
