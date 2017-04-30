//package lance5057.tDefense.armor.renderers.light;
//
//import lance5057.tDefense.armor.renderers.ArmorRenderer;
//import net.minecraft.client.model.ModelRenderer;
//
///**
// * ModelTinkersChausses - Either Mojang or a mod author
// * Created using Tabula 4.1.1
// */
//public class ModelTinkersChausses extends ArmorRenderer
//{
//	public ModelRenderer	FrontL;
//	public ModelRenderer	FrontR;
//	public ModelRenderer	HipGuardL;
//	public ModelRenderer	HipGuardR;
//	public ModelRenderer	BackL;
//	public ModelRenderer	BackR;
//	public ModelRenderer	HipGuardL_1;
//	public ModelRenderer	HipGuardR_1;
//	public ModelRenderer	Belt;
//	public ModelRenderer	BeltR;
//	public ModelRenderer	BeltL;
//
//	public ModelTinkersChausses()
//	{
//		super(0.1f, 0, 64, 64);
//
//		textureWidth = 64;
//		textureHeight = 64;
//
//		bipedRightLeg = new ModelRenderer(this, "Right Leg");
//		bipedRightLeg.setTextureOffset(0, 16);
//		bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.1f);
//		bipedRightLeg.setRotationPoint(-1.9F, 12.0F + 0, 0.0F);
//
//		bipedLeftLeg = new ModelRenderer(this, "Left Leg");
//		bipedLeftLeg.setTextureOffset(0, 16);
//		bipedLeftLeg.mirror = true;
//		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.1f);
//		bipedLeftLeg.setRotationPoint(1.9F, 12.0F + 0, 0.0F);
//
//		HipGuardR = new ModelRenderer(this, "Hip Guard Right");
//		HipGuardR.setTextureOffset(10, 37);
//		HipGuardR.setRotationPoint(0f, 0f, 0f);
//		HipGuardR.addBox(-2.5F, 0.0F, -2.6F, 4, 6, 5, 0.1F);
//		setRotateAngle(HipGuardR, 0.0F, 0.0F, 0.17453292519943295F);
//		bipedRightLeg.addChild(HipGuardR);
//
//		Belt = new ModelRenderer(this, "Belt");
//		Belt.setTextureOffset(18, 48);
//		Belt.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Belt.addBox(-5.0F, 10.5F, -3.0F, 10, 2, 6, -0.19F);
//		bipedBody.addChild(Belt);
//
//		FrontR = new ModelRenderer(this, "Front Right");
//		FrontR.setTextureOffset(0, 40);
//		FrontR.setRotationPoint(1.9f, 0f, -0.1f);
//		FrontR.addBox(-2.0F, 0.0F, -2.6F, 4, 7, 1, 0.0F);
//		setRotateAngle(FrontR, -0.1F, 0.0F, 0.0f);
//		bipedRightLeg.addChild(FrontR);
//
//		FrontL = new ModelRenderer(this, "Front Left");
//		FrontL.setTextureOffset(0, 40);
//		FrontL.setRotationPoint(-1.9f, 0f, -0.1f);
//		FrontL.addBox(-2.0F, 0.0F, -2.6F, 4, 7, 1, 0.0F);
//		setRotateAngle(FrontL, -0.1F, 0.0F, 0.0f);
//		bipedLeftLeg.addChild(FrontL);
//
//		HipGuardL_1 = new ModelRenderer(this, "Hip Guard Left 2");
//		HipGuardL_1.setTextureOffset(0, 49);
//		HipGuardL_1.mirror = true;
//		HipGuardL_1.setRotationPoint(0f, 0f, 0f);
//		HipGuardL_1.addBox(-1.5F, 0.0F, -2.6F, 4, 10, 5, 0.0F);
//		setRotateAngle(HipGuardL_1, 0.0F, 0.0F, -0.08726646259971647F);
//		bipedLeftLeg.addChild(HipGuardL_1);
//
//		BeltR = new ModelRenderer(this, "Belt Right");
//		BeltR.setTextureOffset(18, 56);
//		BeltR.mirror = true;
//		BeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BeltR.addBox(-6F, 1.0F, -3.1F, 12, 2, 6, -0.2F);
//		setRotateAngle(BeltR, 0.0F, 0.0F, -0.4363323129985824F);
//		bipedRightLeg.addChild(BeltR);
//
//		BeltL = new ModelRenderer(this, "Belt Left");
//		BeltL.setTextureOffset(18, 56);
//		BeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BeltL.addBox(-6F, 1.0F, -3.1F, 12, 2, 6, -0.21F);
//		setRotateAngle(BeltL, 0.0F, 0.0F, 0.4363323129985824F);
//		bipedLeftLeg.addChild(BeltL);
//
//		HipGuardR_1 = new ModelRenderer(this, "Hip Guard Right 2");
//		HipGuardR_1.setTextureOffset(0, 49);
//		HipGuardR_1.setRotationPoint(0f, 0f, 0f);
//		HipGuardR_1.addBox(-2.5F, 0.0F, -2.6F, 4, 10, 5, 0.0F);
//		setRotateAngle(HipGuardR_1, 0.0F, 0.0F, 0.08726646259971647F);
//		bipedRightLeg.addChild(HipGuardR_1);
//
//		BackR = new ModelRenderer(this, "Back Right");
//		BackR.setTextureOffset(0, 40);
//		BackR.setRotationPoint(1.9f, 0f, 0f);
//		BackR.addBox(-2.0F, 0.0F, 1.5F, 4, 7, 1, 0.0F);
//		setRotateAngle(BackR, 0.1F, 0.0F, 0.0f);
//		bipedRightLeg.addChild(BackR);
//
//		BackL = new ModelRenderer(this, "Back Light");
//		BackL.setTextureOffset(0, 40);
//		BackL.setRotationPoint(-1.9f, 0f, 0f);
//		BackL.addBox(-2.0F, 0.0F, 1.5F, 4, 7, 1, 0.0F);
//		setRotateAngle(BackL, 0.1F, 0.0F, 0.0f);
//		bipedLeftLeg.addChild(BackL);
//
//		HipGuardL = new ModelRenderer(this, "Hip Guard Left");
//		HipGuardL.setTextureOffset(10, 37);
//		HipGuardL.mirror = true;
//		HipGuardL.setRotationPoint(0f, 0f, 0f);
//		HipGuardL.addBox(-1.5F, 0.0F, -2.6F, 4, 6, 5, 0.1F);
//		setRotateAngle(HipGuardL, 0.0F, 0.0F, -0.17453292519943295F);
//		bipedLeftLeg.addChild(HipGuardL);
//
//		BeltL.isHidden = true;
//		BeltR.isHidden = true;
//		HipGuardL_1.isHidden = true;
//		HipGuardR_1.isHidden = true;
//
//		init();
//	}
//
//	/**
//	 * This is a helper function from Tabula to set the rotation of model parts
//	 */
//	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
//	{
//		modelRenderer.rotateAngleX = x;
//		modelRenderer.rotateAngleY = y;
//		modelRenderer.rotateAngleZ = z;
//	}
//}
