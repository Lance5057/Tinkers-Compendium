package lance5057.tDefense.core.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.utils.TagUtil;

public class ArmorRenderEvent {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void renderArmorEvent(RenderPlayerEvent.Post event) {
		Iterable<ItemStack> armor = event.getEntityPlayer().getArmorInventoryList();
		for (ItemStack i : armor)
			renderArmor(i);
	}

	private static void renderArmor(ItemStack stack) {
		NBTTagList list = TagUtil.getBaseMaterialsTagList(stack);
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(""));
	}

	private void TrimArmor(ModelBiped armorModel, RenderPlayerEvent.Post event) {
		if (armorModel != null) {
			armorModel.isSneak = event.getEntityPlayer().isSneaking();
			armorModel.isRiding = event.getEntityPlayer().isRiding();
			armorModel.isChild = event.getEntityPlayer().isChild();

			armorModel.swingProgress = event.getEntityPlayer().getSwingProgress(event.getPartialRenderTick());

			if (event.getEntityPlayer() instanceof EntityPlayer) {
				final ItemStack itemstack = event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
				final ItemStack itemstackoff = event.getEntityPlayer().getHeldItem(EnumHand.OFF_HAND);
				// armorModel.heldItemRight = 0;
				// armorModel.aimedBow = false;
				if (itemstack != null) // main hand
				{
					if (event.getEntityPlayer().getItemInUseCount() > 0) {
						final EnumAction enumaction = itemstack.getItemUseAction();

						if (enumaction == EnumAction.BLOCK) {
							armorModel.rightArmPose = ModelBiped.ArmPose.BLOCK;
						} else if (enumaction == EnumAction.BOW) {

							armorModel.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
						}
					} else {
						armorModel.rightArmPose = event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND) != null
								? ModelBiped.ArmPose.ITEM
								: ModelBiped.ArmPose.EMPTY;
					}
				}

				if (itemstack != null) // off hand
				{
					if (event.getEntityPlayer().getItemInUseCount() > 0) {
						final EnumAction enumaction = itemstack.getItemUseAction();

						if (enumaction == EnumAction.BLOCK) {
							armorModel.leftArmPose = ModelBiped.ArmPose.BLOCK;
						} else if (enumaction == EnumAction.BOW) {

							armorModel.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
						}
					} else {
						armorModel.leftArmPose = event.getEntityPlayer().getHeldItem(EnumHand.OFF_HAND) != null
								? ModelBiped.ArmPose.ITEM
								: ModelBiped.ArmPose.EMPTY;
					}
				}
			}

			final float yaw = event.getEntityPlayer().prevRotationYawHead
					+ (event.getEntityPlayer().rotationYawHead - event.getEntityPlayer().prevRotationYawHead)
							* event.getPartialRenderTick();
			final float yawOffset = event.getEntityPlayer().prevRenderYawOffset
					+ (event.getEntityPlayer().renderYawOffset - event.getEntityPlayer().prevRenderYawOffset)
							* event.getPartialRenderTick();
			final float limbs = event.getEntityPlayer().prevLimbSwingAmount
					+ (event.getEntityPlayer().limbSwingAmount - event.getEntityPlayer().prevLimbSwingAmount)
							* event.getPartialRenderTick();
			final float limbSwing = event.getEntityPlayer().limbSwing
					- event.getEntityPlayer().limbSwingAmount * (1.0F - event.getPartialRenderTick());

			armorModel.setRotationAngles(limbSwing, limbs, event.getEntityPlayer().ticksExisted, yaw - yawOffset,
					event.getEntityPlayer().rotationPitch, 0.1f, event.getEntityPlayer());
			armorModel.render(event.getEntityPlayer(), limbSwing, limbs, event.getEntityPlayer().ticksExisted,
					yaw - yawOffset, event.getEntityPlayer().rotationPitch, 0.1f);
		}
	}
}
