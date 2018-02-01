//package lance5057.tDefense.armor.events;
//
//import lance5057.tDefense.core.tools.bases.ArmorCore;
//import net.minecraft.client.model.ModelBiped;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.EnumAction;
//import net.minecraft.item.ItemStack;
//import net.minecraftforge.client.event.RenderPlayerEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import slimeknights.tconstruct.library.tools.ToolCore;
//import tconstruct.armor.ArmorProxyClient;
//import tconstruct.armor.player.ArmorExtended;
//
//public class ArmorRenderEvent
//{
//
//	@SideOnly(Side.CLIENT)
//	@SubscribeEvent
//	public void renderArmorEvent(RenderPlayerEvent.SetArmorModel event)
//	{
//		if(event.entityPlayer != null)
//		{
//			final ArmorExtended armorEx = ArmorProxyClient.armorExtended;
//
//			final ItemStack Armor = event.entityPlayer.inventory.armorItemInSlot(event.slot);
//
//			if(Armor != null && Armor.getItem() instanceof ArmorCore)
//			{
//				final ModelBiped armorModel = Armor.getItem().getArmorModel(event.entityLiving, Armor, event.slot);
//
//				TrimArmor(armorModel, event);
//			}
//
//			final ItemStack Accessory = armorEx.getStackInSlot(event.slot);
//
//			if(Accessory != null && Accessory.getItem() instanceof ToolCore)
//			{
//				final ModelBiped accessoryModel = Accessory.getItem().getArmorModel(event.entityLiving, Accessory, event.slot);
//
//				TrimArmor(accessoryModel, event);
//			}
//
//		}
//	}
//
//	private void TrimArmor(ModelBiped armorModel, RenderPlayerEvent.SetArmorModel event)
//	{
//		if(armorModel != null)
//		{
//			armorModel.isSneak = event.entityPlayer.isSneaking();
//			armorModel.isRiding = event.entityPlayer.isRiding();
//			armorModel.isChild = event.entityPlayer.isChild();
//
//			armorModel.onGround = event.entityPlayer.getSwingProgress(event.partialRenderTick);
//
//			if(event.entityPlayer instanceof EntityPlayer)
//			{
//				final ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();
//				armorModel.heldItemRight = 0;
//				armorModel.aimedBow = false;
//				if(itemstack != null)
//				{
//					if(event.entityPlayer.getItemInUseCount() > 0)
//					{
//						final EnumAction enumaction = itemstack.getItemUseAction();
//
//						if(enumaction == EnumAction.block)
//						{
//							armorModel.heldItemRight = 3;
//						}
//						else if(enumaction == EnumAction.bow)
//						{
//							armorModel.aimedBow = true;
//						}
//					}
//					else
//					{
//						armorModel.heldItemRight = event.entityPlayer.getHeldItem() != null ? 1 : 0;
//					}
//				}
//			}
//
//			final float yaw = event.entityPlayer.prevRotationYawHead + (event.entityPlayer.rotationYawHead - event.entityPlayer.prevRotationYawHead) * event.partialRenderTick;
//			final float yawOffset = event.entityPlayer.prevRenderYawOffset + (event.entityPlayer.renderYawOffset - event.entityPlayer.prevRenderYawOffset) * event.partialRenderTick;
//			final float limbs = event.entityPlayer.prevLimbSwingAmount + (event.entityPlayer.limbSwingAmount - event.entityPlayer.prevLimbSwingAmount) * event.partialRenderTick;
//			final float limbSwing = event.entityPlayer.limbSwing - event.entityPlayer.limbSwingAmount * (1.0F - event.partialRenderTick);
//
//			armorModel.setRotationAngles(limbSwing, limbs, event.entityPlayer.ticksExisted, yaw - yawOffset, event.entityPlayer.rotationPitch, 0.1f, event.entityPlayer);
//			armorModel.render(event.entityPlayer, limbSwing, limbs, event.entityPlayer.ticksExisted, yaw - yawOffset, event.entityPlayer.rotationPitch, 0.1f);
//		}
//	}
//}
