package lance5057.tDefense.core.renderers;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;

public class BaubleRenderer implements LayerRenderer<EntityPlayer> {

	@Override
	public void doRenderLayer(EntityPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

//		ItemStack stack = entitylivingbaseIn.inventory.getStackInSlot(0);
//		ItemStack stackShield = entitylivingbaseIn.inventory.getStackInSlot(1);
//		
//		ItemStack stackTest = entitylivingbaseIn.getHeldItem(EnumHand.MAIN_HAND);
//		
//		if (stack != null 
//				&& (stack.getItem() instanceof ToolCore || stack.getItem() instanceof ItemSword) 
//				&& !(stack.getItem() instanceof Shield)
//				&& stack != stackTest) {
//			GlStateManager.pushMatrix();
//			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
////			Helper.rotateIfSneaking(player);
////			boolean armor = !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty();
//			//GlStateManager.rotate(90, 0, 1, 0);
//			GlStateManager.rotate(20, 0, 0, 1);
//			GlStateManager.translate(-0.125, 0.1, 0.25);
//			//GlStateManager.scale(0.55, 0.55, 0.55);
//
////			if (renderedOne)
////				GlStateManager.translate(0F, 0F, armor ? 0.55F : 0.5F);
////			else
////				GlStateManager.translate(0F, 0F, armor ? -0.55F : -0.5F);
//
//			if(stack.getItem() instanceof Zweihander || stack.getItem() instanceof Cleaver)
//			{
//				GlStateManager.scale(1.5F, 1.5F, 0.75F);
//				GlStateManager.translate(0.1, 0.1, 0);
//			}
//			else
//				GlStateManager.scale(0.75F, 0.75F, 0.75F);
//
//			GlStateManager.color(1F, 1F, 1F);
//			int light = 15728880;
//			int lightmapX = light % 65536;
//			int lightmapY = light / 65536;
//			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lightmapX, lightmapY);
//			Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);
//			GlStateManager.popMatrix();
//		}
//		
//		//Shield
//		if (stackShield != null 
//				&& (stackShield.getItem() instanceof Shield || stackShield.getItem() instanceof ItemShield) 
//				&& stackShield != stackTest) {
//			GlStateManager.pushMatrix();
//			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
////			Helper.rotateIfSneaking(player);
////			boolean armor = !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty();
//			//GlStateManager.rotate(90, 0, 1, 0);
//			GlStateManager.rotate(160, 0, 0, 1);
//			GlStateManager.translate(0.125, -0.3, 0.3);
//			//GlStateManager.scale(0.55, 0.55, 0.55);
//
////			if (renderedOne)
////				GlStateManager.translate(0F, 0F, armor ? 0.55F : 0.5F);
////			else
////				GlStateManager.translate(0F, 0F, armor ? -0.55F : -0.5F);
//
//			if(stackShield.getItem() instanceof ItemShield)
//			{
//				//GlStateManager.scale(1.5F, 1.5F, 0.75F);
//				GlStateManager.translate(0.5, 0.5, 0.5);
//			}
////			else
//			//GlStateManager.scale(0.75F, 0.75F, 0.75F);
//
//			GlStateManager.color(1F, 1F, 1F);
//			int light = 15728880;
//			int lightmapX = light % 65536;
//			int lightmapY = light / 65536;
//			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lightmapX, lightmapY);
//			Minecraft.getMinecraft().getRenderItem().renderItem(stackShield, ItemCameraTransforms.TransformType.NONE);
//			GlStateManager.popMatrix();
//		}
	}

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}

}
