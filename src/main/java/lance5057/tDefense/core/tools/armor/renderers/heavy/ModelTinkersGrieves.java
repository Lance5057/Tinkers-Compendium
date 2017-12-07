//package lance5057.tDefense.armor.renderers.heavy;
//
//import lance5057.tDefense.armor.renderers.ArmorRenderer;
//import net.minecraft.client.model.ModelRenderer;
//
///**
// * TinkersGrieves - Either Mojang or a mod author
// * Created using Tabula 4.1.1
// */
//public class ModelTinkersGrieves extends ArmorRenderer
//{
//	public ModelRenderer	LegPlateL;
//	public ModelRenderer	CodPiece;
//	public ModelRenderer	LegPlateBackL;
//	public ModelRenderer	LegPlateBackR;
//	public ModelRenderer	LegPlateR;
//	public ModelRenderer	Belt;
//	public ModelRenderer	BeltBuckle;
//	public ModelRenderer	ThighR;
//	public ModelRenderer	ThighL;
//	public ModelRenderer	ThighRB;
//	public ModelRenderer	ThighLB;
//	public ModelRenderer	SecBeltR;
//	public ModelRenderer	SecBeltL;
//	public ModelRenderer	LeftFrontL;
//	public ModelRenderer	LeftBackL;
//	public ModelRenderer	CenterBackL;
//	public ModelRenderer	CenterBackR;
//	public ModelRenderer	RightFrontL;
//	public ModelRenderer	RightBackL;
//	public ModelRenderer	CenterFrontL;
//	public ModelRenderer	CenterFrontR;
//
//	public ModelTinkersGrieves()
//	{
//		super(0.1f, 0, 64, 64);
//
//		textureWidth = 64;
//		textureHeight = 64;
//
//		SecBeltL = new ModelRenderer(this, "Hip Belt Left");
//		SecBeltL.setTextureOffset(12, 56);
//		SecBeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		SecBeltL.addBox(-1.0F, 11.5F, -2.8F, 9, 2, 6, 0.16F);
//		setRotateAngle(SecBeltL, 0.0F, 0.0F, 0.2617993877991494F);
//		bipedBody.addChild(SecBeltL);
//
//		CodPiece = new ModelRenderer(this, "CodPiece");
//		CodPiece.setTextureOffset(0, 49);
//		CodPiece.setRotationPoint(0.0F, 0.0F, 0.0F);
//		CodPiece.addBox(-2.5F, 11.0F, -3.2F, 5, 5, 3, -0.4F);
//		bipedBody.addChild(CodPiece);
//
//		ThighL = new ModelRenderer(this, "Thigh Left Front");
//		ThighL.setTextureOffset(12, 32);
//		ThighL.mirror = true;
//		ThighL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ThighL.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 4, 0.2F);
//		setRotateAngle(ThighL, 0.08726646259971647F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(ThighL);
//
//		ThighLB = new ModelRenderer(this, "Thigh Left Back");
//		ThighLB.setTextureOffset(13, 42);
//		ThighLB.mirror = true;
//		ThighLB.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ThighLB.addBox(-2.0F, 0.0F, -1.5F, 4, 6, 4, 0.1F);
//		setRotateAngle(ThighLB, -0.08726646259971647F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(ThighLB);
//
//		SecBeltR = new ModelRenderer(this, "Hip Belt Right");
//		SecBeltR.setTextureOffset(12, 56);
//		SecBeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		SecBeltR.addBox(-8.0F, 11.5F, -2.8F, 9, 2, 6, 0.15F);
//		setRotateAngle(SecBeltR, 0.0F, 0.0F, -0.2617993877991494F);
//		bipedBody.addChild(SecBeltR);
//
//		CenterFrontL = new ModelRenderer(this, "Center Front");
//		CenterFrontL.setTextureOffset(29, 43);
//		CenterFrontL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		CenterFrontL.addBox(-2.9F, -0.2F, -2.5F, 2, 11, 2, 0.0F);
//		setRotateAngle(CenterFrontL, -0.08726646259971647F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(CenterFrontL);
//
//		CenterFrontR = new ModelRenderer(this, "Center Front");
//		CenterFrontR.setTextureOffset(29, 43);
//		CenterFrontR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		CenterFrontR.addBox(0.9F, -0.2F, -2.5F, 2, 11, 2, 0.0F);
//		setRotateAngle(CenterFrontR, -0.08726646259971647F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(CenterFrontR);
//
//		LegPlateBackR = new ModelRenderer(this, "Leg Plate Back Right");
//		LegPlateBackR.setTextureOffset(0, 43);
//		LegPlateBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		LegPlateBackR.addBox(-2.0F, 0.1F, 2.1F, 4, 5, 1, 0.0F);
//		setRotateAngle(LegPlateBackR, 0.2617993877991494F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(LegPlateBackR);
//
//		Belt = new ModelRenderer(this, "Belt");
//		Belt.setTextureOffset(12, 56);
//		Belt.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Belt.addBox(-4.5F, 10.0F, -2.8F, 9, 2, 6, 0.25F);
//		bipedBody.addChild(Belt);
//
//		ThighR = new ModelRenderer(this, "Thigh Right");
//		ThighR.setTextureOffset(12, 32);
//		ThighR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ThighR.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 4, 0.2F);
//		setRotateAngle(ThighR, 0.08726646259971647F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(ThighR);
//
//		ThighRB = new ModelRenderer(this, "Thigh Right Back");
//		ThighRB.setTextureOffset(13, 42);
//		ThighRB.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ThighRB.addBox(-2.0F, 0.0F, -1.5F, 4, 6, 4, 0.1F);
//		setRotateAngle(ThighRB, -0.08726646259971647F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(ThighRB);
//
//		LegPlateL = new ModelRenderer(this, "Leg Plate Left");
//		LegPlateL.setTextureOffset(0, 32);
//		LegPlateL.mirror = true;
//		LegPlateL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		LegPlateL.addBox(1.6F, -0.1F, -2.5F, 1, 5, 5, 0.1F);
//		setRotateAngle(LegPlateL, 0.0F, 0.0F, -0.2617993877991494F);
//		bipedLeftLeg.addChild(LegPlateL);
//
//		RightBackL = new ModelRenderer(this, "Right Back Left");
//		RightBackL.setTextureOffset(42, 34);
//		RightBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		RightBackL.addBox(-2.2F, -0.3F, -1.5F, 4, 11, 4, 0.0F);
//		setRotateAngle(RightBackL, 0.08726646259971647F, 0.0F, 0.08726646259971647F);
//		bipedRightLeg.addChild(RightBackL);
//
//		LeftBackL = new ModelRenderer(this, "Left Back Left");
//		LeftBackL.setTextureOffset(42, 34);
//		LeftBackL.mirror = true;
//		LeftBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		LeftBackL.addBox(-1.8F, -0.3F, -1.5F, 4, 11, 4, 0.0F);
//		setRotateAngle(LeftBackL, 0.08726646259971647F, 0.0F, -0.08726646259971647F);
//		bipedLeftLeg.addChild(LeftBackL);
//
//		LegPlateR = new ModelRenderer(this, "Leg Plate Right");
//		LegPlateR.setTextureOffset(0, 32);
//		LegPlateR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		LegPlateR.addBox(-2.6F, -0.1F, -2.5F, 1, 5, 5, 0.1F);
//		setRotateAngle(LegPlateR, 0.0F, 0.0F, 0.2617993877991494F);
//		bipedRightLeg.addChild(LegPlateR);
//
//		RightFrontL = new ModelRenderer(this, "Right Front Left");
//		RightFrontL.setTextureOffset(42, 49);
//		RightFrontL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		RightFrontL.addBox(-2.2F, -0.3F, -2.5F, 4, 11, 4, 0.0F);
//		setRotateAngle(RightFrontL, -0.08726646259971647F, 0.0F, 0.08726646259971647F);
//		bipedRightLeg.addChild(RightFrontL);
//
//		BeltBuckle = new ModelRenderer(this, "Belt Buckle");
//		BeltBuckle.setTextureOffset(0, 58);
//		BeltBuckle.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BeltBuckle.addBox(-2.0F, 9.0F, -3.5F, 4, 4, 2, -0.3F);
//		bipedBody.addChild(BeltBuckle);
//
//		LegPlateBackL = new ModelRenderer(this, "Leg Plate Back Left");
//		LegPlateBackL.setTextureOffset(0, 43);
//		LegPlateBackL.mirror = true;
//		LegPlateBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		LegPlateBackL.addBox(-2.0F, 0.1F, 2.1F, 4, 5, 1, 0.0F);
//		setRotateAngle(LegPlateBackL, 0.2617993877991494F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(LegPlateBackL);
//
//		LeftFrontL = new ModelRenderer(this, "Left Front Left");
//		LeftFrontL.setTextureOffset(42, 49);
//		LeftFrontL.mirror = true;
//		LeftFrontL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		LeftFrontL.addBox(-1.8F, -0.3F, -2.5F, 4, 11, 4, 0.0F);
//		setRotateAngle(LeftFrontL, -0.08726646259971647F, 0.0F, -0.08726646259971647F);
//		bipedLeftLeg.addChild(LeftFrontL);
//
//		CenterBackL = new ModelRenderer(this, "Center Back Left");
//		CenterBackL.setTextureOffset(29, 43);
//		CenterBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		CenterBackL.addBox(-2.9F, -0.2F, 0.5F, 2, 11, 2, 0.0F);
//		setRotateAngle(CenterBackL, 0.08726646259971647F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(CenterBackL);
//
//		CenterBackR = new ModelRenderer(this, "Center Back Right");
//		CenterBackR.setTextureOffset(29, 43);
//		CenterBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		CenterBackR.addBox(0.9F, -0.2F, 0.5F, 2, 11, 2, 0.0F);
//		setRotateAngle(CenterBackR, 0.08726646259971647F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(CenterBackR);
//
//		SecBeltL.isHidden = true;
//		SecBeltR.isHidden = true;
//		CenterBackL.isHidden = true;
//		CenterBackR.isHidden = true;
//		CenterFrontL.isHidden = true;
//		CenterFrontR.isHidden = true;
//		LeftBackL.isHidden = true;
//		LeftFrontL.isHidden = true;
//		RightBackL.isHidden = true;
//		RightFrontL.isHidden = true;
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
