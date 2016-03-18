package lance5057.tDefense.armor.events;

import lance5057.tDefense.armor.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderPlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorRenderEvent
{

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderArmorEvent(RenderPlayerEvent.SetArmorModel event)
	{
		if(event.entityPlayer != null)
		{
			for(int i = 0; i < 4; i++)
			{
				if(event.entityPlayer.inventory.armorItemInSlot(i) != null)
				{
					ItemStack Armor = event.entityPlayer.inventory.armorItemInSlot(i);
					NBTTagCompound tags = Armor.getTagCompound();

					if(Armor.getItem() instanceof ArmorCore)
					{
						ArmorCore AArmor = (ArmorCore) Armor.getItem();
						ModelBiped armorModel = AArmor.getArmorModel(event.entityLiving, Armor, AArmor.getSlot());

						if(armorModel != null)
						{
							armorModel.isSneak = event.entityPlayer.isSneaking();
							armorModel.isRiding = event.entityPlayer.isRiding();
							armorModel.isChild = event.entityPlayer.isChild();

							armorModel.onGround = event.entityPlayer.getSwingProgress(event.partialRenderTick);

							if(event.entityPlayer instanceof EntityPlayer)
							{
								ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();
								armorModel.heldItemRight = 0;
								armorModel.aimedBow = false;
								if(itemstack != null)
								{
									if(event.entityPlayer.getItemInUseCount() > 0)
									{
										EnumAction enumaction = itemstack.getItemUseAction();

										if(enumaction == EnumAction.block)
										{
											armorModel.heldItemRight = 3;
										}
										else if(enumaction == EnumAction.bow)
										{
											armorModel.aimedBow = true;
										}
									}
									else
									{
										armorModel.heldItemRight = event.entityPlayer.getHeldItem() != null ? 1 : 0;
									}
								}
							}
						}

						float yaw = event.entityPlayer.prevRotationYawHead + (event.entityPlayer.rotationYawHead - event.entityPlayer.prevRotationYawHead) * event.partialRenderTick;
						float yawOffset = event.entityPlayer.prevRenderYawOffset + (event.entityPlayer.renderYawOffset - event.entityPlayer.prevRenderYawOffset) * event.partialRenderTick;
						float limbs = event.entityPlayer.prevLimbSwingAmount + (event.entityPlayer.limbSwingAmount - event.entityPlayer.prevLimbSwingAmount) * event.partialRenderTick;
						float limbSwing = event.entityPlayer.limbSwing - event.entityPlayer.limbSwingAmount * (1.0F - event.partialRenderTick);

						armorModel.setRotationAngles(limbSwing, limbs, event.entityPlayer.ticksExisted, yaw - yawOffset, event.entityPlayer.rotationPitch, 0.1f, event.entityPlayer);
						armorModel.render(event.entityPlayer, limbSwing, limbs, event.entityPlayer.ticksExisted, yaw - yawOffset, event.entityPlayer.rotationPitch, 0.1f);
					}
				}
			}
		}
	}

}
