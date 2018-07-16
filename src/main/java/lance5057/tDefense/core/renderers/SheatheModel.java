//package lance5057.tDefense.core.renderers;
//
//import lance5057.tDefense.core.tools.bases.Shield;
//import lance5057.tDefense.core.tools.basic.TowerShield;
//import lance5057.tDefense.core.tools.basic.Zweihander;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.model.ModelBiped;
//import net.minecraft.client.model.ModelRenderer;
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
//import net.minecraft.client.renderer.texture.TextureMap;
//import net.minecraft.item.ItemShield;
//import net.minecraft.item.ItemStack;
//import slimeknights.tconstruct.tools.melee.item.Cleaver;
//
///**
// * Sheathe - Lance5057 Created using Tabula 4.1.1
// */
//public class SheatheModel extends ModelBiped {
//	public ModelRenderer Sheathe;
//	public ModelRenderer FrontCap;
//	public ModelRenderer WaistBelt;
//	public ModelRenderer BackCap;
//	public ModelRenderer ShoulderBelt;
//
//	public SheatheModel() {
//
//		// rSword = new RenderItem(Minecraft.getMinecraft().getTextureManager(),
//		// null, null);
//
//		this.textureWidth = 64;
//		this.textureHeight = 64;
//
//		this.WaistBelt = new ModelRenderer(this, 0, 32);
//		this.WaistBelt.setRotationPoint(0.0F, 0.0F, 0.0F);
//		this.WaistBelt.addBox(-4.5F, 4.5F, -2.5F, 9, 2, 5, -0.3F);
//		// this.bipedBody.addChild(WaistBelt);
//
//		this.ShoulderBelt = new ModelRenderer(this, 0, 32);
//		this.ShoulderBelt.setRotationPoint(0.0F, 0.0F, 0.0F);
//		this.ShoulderBelt.addBox(-3.0F, 1.0F, -2.5F, 9, 2, 5, -0.3F);
//		this.setRotateAngle(ShoulderBelt, 0.0F, 0.0F, 0.7853981633974483F);
//		// this.bipedBody.addChild(ShoulderBelt);
//
//		this.BackCap = new ModelRenderer(this, 0, 39);
//		this.BackCap.setRotationPoint(0.0F, 0.0F, 0.0F);
//		this.BackCap.addBox(-2.2F, 3.6F, -2.8F, 3, 3, 2, -0.4F);
//		this.setRotateAngle(BackCap, 0.0F, 0.0F, -0.4363323129985824F);
//		// this.bipedBody.addChild(BackCap);
//
//		this.FrontCap = new ModelRenderer(this, 0, 39);
//		this.FrontCap.setRotationPoint(0.0F, 0.0F, 0.0F);
//		this.FrontCap.addBox(-2.2F, 3.6F, 0.7F, 3, 3, 2, -0.4F);
//		this.setRotateAngle(FrontCap, 0.0F, 0.0F, -0.4363323129985824F);
//		// this.bipedBody.addChild(FrontCap);
//
//		this.Sheathe = new ModelRenderer(this, 28, 32);
//		this.Sheathe.setRotationPoint(0.0F, 0.0F, 0.0F);
//		this.Sheathe.addBox(-1.1F, 1.0F, 3.5F, 11, 3, 1, 0.2F);
//		this.setRotateAngle(Sheathe, 0.0F, 0.0F, 1.1344640137963142F);
//		// this.bipedBody.addChild(Sheathe);
//	}
//
//	public void render(float f5, ItemStack weapon, ItemStack shield, ItemStack active, ItemStack offhand) {
//
//		WaistBelt.render(f5);
//		ShoulderBelt.render(f5);
//		BackCap.render(f5);
//		FrontCap.render(f5);
//		Sheathe.render(f5);
//
//		
//		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
//
//		if (weapon != null && active != weapon) {
//			GlStateManager.pushMatrix();
//			
//			GlStateManager.rotate(20, 0, 0, 1);
//			float s = 13f;
//			GlStateManager.scale(s, s, s);
//			GlStateManager.translate(-0.1F, 0.175f, 0.3f);
//			
//			if(weapon.getItem() instanceof Zweihander || weapon.getItem() instanceof Cleaver)
//			{
//				GlStateManager.scale(1.5f, 1.5f, 1f);
//			}
//
//			Minecraft.getMinecraft().getRenderItem().renderItem(weapon, ItemCameraTransforms.TransformType.NONE);
//			
//			GlStateManager.popMatrix();
//		}
//
//		if (shield != null && shield != active
//				&& (shield.getItem() instanceof ItemShield || shield.getItem() instanceof Shield)) {
//			GlStateManager.pushMatrix();
//			
//			GlStateManager.rotate(20, 0, 0, 1);
//			float s = 13f;
//			GlStateManager.scale(s, s, s);
//			GlStateManager.translate(-0.1F, 0.175f, 0.3f);
//			
//			if (shield.getItem() instanceof Shield) {
//				if(shield.getItem() instanceof TowerShield)
//				{
//					GlStateManager.scale(1.5f, 1.5f, 1f);
//				}
//				GlStateManager.rotate(180 - 45, 0, 0, 1);
//				GlStateManager.translate(-0.0F, -0.3f, 0.1f);
//				GlStateManager.scale(1.35, 1.35, 1.35);
//			} else {
//				GlStateManager.rotate(180 - 45, 0, 0, 1);
//				GlStateManager.translate(0.7F, 0.2f, 0.7f);
//				GlStateManager.scale(1.35, 1.35, 1.35);
//			}
//
//			Minecraft.getMinecraft().getRenderItem().renderItem(shield, ItemCameraTransforms.TransformType.NONE);
//			
//			GlStateManager.popMatrix();
//		}
//
//		
//	}
//
//	/**
//	 * This is a helper function from Tabula to set the rotation of model parts
//	 */
//	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
//		modelRenderer.rotateAngleX = x;
//		modelRenderer.rotateAngleY = y;
//		modelRenderer.rotateAngleZ = z;
//	}
//}
