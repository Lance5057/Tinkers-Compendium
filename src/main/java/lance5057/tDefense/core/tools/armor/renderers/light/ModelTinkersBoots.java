//package lance5057.tDefense.armor.renderers.light;
//
//import lance5057.tDefense.armor.renderers.ArmorRenderer;
//import net.minecraft.client.model.ModelRenderer;
//
///**
// * ModelTinkersBoots - Either Mojang or a mod author
// * Created using Tabula 4.1.1
// */
//public class ModelTinkersBoots extends ArmorRenderer
//{
//	public ModelRenderer	BootTopR;
//	public ModelRenderer	BootTopL;
//	public ModelRenderer	FootL;
//	public ModelRenderer	FootR;
//	public ModelRenderer	LegGuardL;
//	public ModelRenderer	LegGuardR;
//	public ModelRenderer	FootTipL;
//	public ModelRenderer	FootTipR;
//
//	public ModelTinkersBoots()
//	{
//		super(0.1f, 0, 64, 64);
//
//		textureWidth = 64;
//		textureHeight = 64;
//
//		bipedRightLeg = new ModelRenderer(this, "Right Leg");
//		bipedRightLeg.setTextureOffset(0, 16);
//		bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.05f);
//		bipedRightLeg.setRotationPoint(-1.9F, 12.0F + 0, 0.0F);
//
//		bipedLeftLeg = new ModelRenderer(this, "Left Leg");
//		bipedLeftLeg.setTextureOffset(0, 16);
//		bipedLeftLeg.mirror = true;
//		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.05f);
//		bipedLeftLeg.setRotationPoint(1.9F, 12.0F + 0, 0.0F);
//
//		FootR = new ModelRenderer(this, "FootR");
//		FootR.setTextureOffset(0, 41);
//		FootR.setRotationPoint(0f, 0f, 0f);
//		FootR.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.1F);
//		bipedRightLeg.addChild(FootR);
//
//		BootTopR = new ModelRenderer(this, "BootTopR");
//		BootTopR.setTextureOffset(0, 32);
//		BootTopR.setRotationPoint(0f, 0f, 0f);
//		BootTopR.addBox(-2.5F, 3.5F, -2.5F, 5, 4, 5, -0.2F);
//		bipedRightLeg.addChild(BootTopR);
//
//		BootTopL = new ModelRenderer(this, "BootTopL");
//		BootTopL.setTextureOffset(0, 32);
//		BootTopL.setRotationPoint(0f, 0f, 0f);
//		BootTopL.addBox(-2.5F, 3.5F, -2.5F, 5, 4, 5, -0.2F);
//		bipedLeftLeg.addChild(BootTopL);
//
//		LegGuardR = new ModelRenderer(this, "LegGuardR");
//		LegGuardR.setTextureOffset(0, 44);
//		LegGuardR.setRotationPoint(0f, 0f, 0f);
//		LegGuardR.addBox(-2.0F, 5.5F, -3.8F, 4, 4, 2, 0.2F);
//		setRotateAngle(LegGuardR, 0.17453292519943295F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(LegGuardR);
//
//		FootTipR = new ModelRenderer(this, "FootTipR");
//		FootTipR.setTextureOffset(10, 41);
//		FootTipR.setRotationPoint(0f, 0f, 0f);
//		FootTipR.addBox(-1.5F, 9.5F, -5.6F, 3, 2, 2, -0.2F);
//		setRotateAngle(FootTipR, 0.17453292519943295F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(FootTipR);
//
//		FootL = new ModelRenderer(this, "FootL");
//		FootL.setTextureOffset(0, 41);
//		FootL.mirror = true;
//		FootL.setRotationPoint(0f, 0f, 0f);
//		FootL.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.1F);
//		bipedLeftLeg.addChild(FootL);
//
//		LegGuardL = new ModelRenderer(this, "LegGuardL");
//		LegGuardL.setTextureOffset(0, 44);
//		LegGuardL.setRotationPoint(0f, 0f, 0f);
//		LegGuardL.addBox(-2.0F, 5.5F, -3.8F, 4, 4, 2, 0.2F);
//		setRotateAngle(LegGuardL, 0.17453292519943295F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(LegGuardL);
//
//		FootTipL = new ModelRenderer(this, "FootTipL");
//		FootTipL.setTextureOffset(10, 41);
//		FootTipL.setRotationPoint(0f, 0f, 0f);
//		FootTipL.addBox(-1.5F, 9.5F, -5.6F, 3, 2, 2, -0.2F);
//		setRotateAngle(FootTipL, 0.17453292519943295F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(FootTipL);
//
//		BootTopL.isHidden = true;
//		BootTopR.isHidden = true;
//		FootTipL.isHidden = true;
//		FootTipR.isHidden = true;
//		LegGuardL.isHidden = true;
//		LegGuardR.isHidden = true;
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
