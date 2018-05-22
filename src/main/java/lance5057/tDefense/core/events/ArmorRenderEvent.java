//package lance5057.tDefense.core.events;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
//import lance5057.tDefense.core.tools.bases.ArmorCore;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.model.ModelBase;
//import net.minecraft.client.model.ModelBiped;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagList;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.client.event.RenderPlayerEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import slimeknights.tconstruct.library.utils.TagUtil;
//
//public class ArmorRenderEvent {
//
//	@SideOnly(Side.CLIENT)
//	@SubscribeEvent
//	public static void renderArmorEvent(RenderPlayerEvent.Post event) {
//		Iterable<ItemStack> armor = event.getEntityPlayer().getArmorInventoryList();
//		for (ItemStack i : armor)
//			renderArmor(event, i);
//	}
//
//	private static void renderArmor(RenderPlayerEvent.Post event, ItemStack stack) {
//		if (stack.getItem() instanceof ArmorCore) {
//			ArmorCore ac = (ArmorCore) stack.getItem();
//
//			NBTTagList list = TagUtil.getBaseMaterialsTagList(stack);
//			ArmorRenderer mb = ac.getArmorModel(event.getEntityLiving(), stack);
//			List<String> textures = ac.getArmorTexture(stack);
//			List<String> textures2 = new ArrayList();
//			for (int i = 0; i < textures.size(); i++) {
//				textures2.add(textures.get(i) + "_" + list.getStringTagAt(i) + ".png");
//			}
//
//			TrimArmor(mb, textures2, event);
//		}
//	}
//
//	private static void TrimArmor(ModelBiped armorModel, List<String> textures, RenderPlayerEvent.Post event) {
//		if (armorModel != null) {
//			ModelBase.copyModelAngles(event.getRenderer().getMainModel().bipedBody, armorModel.bipedBody);
//			ModelBase.copyModelAngles(event.getRenderer().getMainModel().bipedHead, armorModel.bipedHead);
//			ModelBase.copyModelAngles(event.getRenderer().getMainModel().bipedLeftArm, armorModel.bipedLeftArm);
//			ModelBase.copyModelAngles(event.getRenderer().getMainModel().bipedLeftLeg, armorModel.bipedLeftLeg);
//			ModelBase.copyModelAngles(event.getRenderer().getMainModel().bipedRightArm, armorModel.bipedRightArm);
//			ModelBase.copyModelAngles(event.getRenderer().getMainModel().bipedRightLeg, armorModel.bipedRightLeg);
//
//			// armorModel.isSneak = event.getEntityPlayer().isSneaking();
//			// armorModel.isRiding = event.getEntityPlayer().isRiding();
//			// armorModel.isChild = event.getEntityPlayer().isChild();
//			//
//			// armorModel.swingProgress =
//			// event.getEntityPlayer().getSwingProgress(event.getPartialRenderTick());
//			//
//			// if (event.getEntityPlayer() instanceof EntityPlayer) {
//			// final ItemStack itemstack =
//			// event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
//			// final ItemStack itemstackoff =
//			// event.getEntityPlayer().getHeldItem(EnumHand.OFF_HAND);
//			// // armorModel.heldItemRight = 0;
//			// // armorModel.aimedBow = false;
//			// if (itemstack != null) // main hand
//			// {
//			// if (event.getEntityPlayer().getItemInUseCount() > 0) {
//			// final EnumAction enumaction = itemstack.getItemUseAction();
//			//
//			// if (enumaction == EnumAction.BLOCK) {
//			// armorModel.rightArmPose = ModelBiped.ArmPose.BLOCK;
//			// } else if (enumaction == EnumAction.BOW) {
//			//
//			// armorModel.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
//			// }
//			// } else {
//			// armorModel.rightArmPose =
//			// event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND) != null
//			// ? ModelBiped.ArmPose.ITEM
//			// : ModelBiped.ArmPose.EMPTY;
//			// }
//			// }
//			//
//			// if (itemstack != null) // off hand
//			// {
//			// if (event.getEntityPlayer().getItemInUseCount() > 0) {
//			// final EnumAction enumaction = itemstack.getItemUseAction();
//			//
//			// if (enumaction == EnumAction.BLOCK) {
//			// armorModel.leftArmPose = ModelBiped.ArmPose.BLOCK;
//			// } else if (enumaction == EnumAction.BOW) {
//			//
//			// armorModel.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
//			// }
//			// } else {
//			// armorModel.leftArmPose =
//			// event.getEntityPlayer().getHeldItem(EnumHand.OFF_HAND) != null
//			// ? ModelBiped.ArmPose.ITEM
//			// : ModelBiped.ArmPose.EMPTY;
//			// }
//			// }
//			// }
//
//			// final float yaw = event.getEntityPlayer().prevRotationYawHead
//			// + (event.getEntityPlayer().rotationYawHead -
//			// event.getEntityPlayer().prevRotationYawHead)
//			// * event.getPartialRenderTick();
//			// final float yawOffset = event.getEntityPlayer().prevRenderYawOffset
//			// + (event.getEntityPlayer().renderYawOffset -
//			// event.getEntityPlayer().prevRenderYawOffset)
//			// * event.getPartialRenderTick();
//			// final float limbs = event.getEntityPlayer().prevLimbSwingAmount
//			// + (event.getEntityPlayer().limbSwingAmount -
//			// event.getEntityPlayer().prevLimbSwingAmount)
//			// * event.getPartialRenderTick();
//			// final float limbSwing = event.getEntityPlayer().limbSwing
//			// - event.getEntityPlayer().limbSwingAmount * (1.0F -
//			// event.getPartialRenderTick());
//			//
//
//			// armorModel.setRotationAngles(limbSwing, limbs,
//			// event.getEntityPlayer().ticksExisted, yaw - yawOffset,
//			// event.getEntityPlayer().rotationPitch, 0.1f, event.getEntityPlayer());
//
//			// GL11.glRotatef(180, 1.0f, 0, 0);
//
//			for (String t : textures) {
//				Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(t));
//				armorModel.render(event.getEntityPlayer(), 0, 0, 0, 0, 0, 0.15f);
//			}
//		}
//	}
//}
