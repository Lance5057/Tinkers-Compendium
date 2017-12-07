//package lance5057.tDefense.armor.renderers.cloth;
//
//import lance5057.tDefense.armor.renderers.ArmorRenderer;
//import net.minecraft.client.model.ModelRenderer;
//
///**
// * ModelBiped - Either Mojang or a mod author
// * Created using Tabula 4.1.1
// */
//public class ModelTinkersRobe extends ArmorRenderer
//{
//	public ModelRenderer	LeftFrontL;
//	public ModelRenderer	LeftBackL;
//	public ModelRenderer	CenterBackL;
//	public ModelRenderer	RightFronL;
//	public ModelRenderer	RightBackL;
//	public ModelRenderer	CenterFrontL;
//	public ModelRenderer	CenterFrontR;
//	public ModelRenderer	CenterBackR;
//	public ModelRenderer	FrontMidL;
//	public ModelRenderer	FrontRightMid;
//	public ModelRenderer	BackMidR;
//	public ModelRenderer	BackRightMid;
//	public ModelRenderer	FrontLeftMid;
//	public ModelRenderer	UnderFrontLeftMid;
//	public ModelRenderer	UnderBackRightMid;
//	public ModelRenderer	UnderBackLeftMid;
//	public ModelRenderer	UnderFrontRightMid;
//	public ModelRenderer	UnderLeftMid;
//	public ModelRenderer	UnderRightMid;
//	public ModelRenderer	FrontMidR;
//	public ModelRenderer	BackLeftMid;
//	public ModelRenderer	BackMidL;
//	public ModelRenderer	FrontLHigh;
//	public ModelRenderer	UnderFrontRightHigh;
//	public ModelRenderer	UnderBackRightHigh;
//	public ModelRenderer	BackUnderHigh;
//	public ModelRenderer	UnderBackLeftHigh;
//	public ModelRenderer	RightHigh;
//	public ModelRenderer	LeftHigh;
//	public ModelRenderer	FrontRightHigh;
//	public ModelRenderer	BackRightHigh;
//	public ModelRenderer	UnderFrontHigh;
//	public ModelRenderer	UnderFrontLeftHigh;
//	public ModelRenderer	BackLHigh;
//	public ModelRenderer	BeltLHip;
//	public ModelRenderer	BeltStraight;
//	public ModelRenderer	BeltRHip;
//
//	//public ModelRenderer	BeltStraightSmall;
//
//	public ModelTinkersRobe()
//	{
//		super(0.1f, 0, 64, 64);
//
//		textureWidth = 64;
//		textureHeight = 64;
//
//		//High
//
//		LeftHigh = new ModelRenderer(this, "Left Skirt");
//		LeftHigh.setTextureOffset(52, 38);
//		LeftHigh.mirror = true;
//		LeftHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		LeftHigh.addBox(-7.5F, 8.0F, -2.0F, 2, 7, 4, -0.01F);
//		setRotateAngle(LeftHigh, 0.0F, 0.0F, -0.9599310885968813F);
//		bipedBody.addChild(LeftHigh);
//
//		UnderBackLeftHigh = new ModelRenderer(this, "Underside BackLeft Skirt");
//		UnderBackLeftHigh.setTextureOffset(8, 57);
//		UnderBackLeftHigh.mirror = true;
//		UnderBackLeftHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderBackLeftHigh.addBox(-0.2F, 8.5F, -7.5F, 4, 6, 1, 0.0F);
//		setRotateAngle(UnderBackLeftHigh, 0.9599310885968813F, 0.7853981633974483F, 0.0F);
//		bipedBody.addChild(UnderBackLeftHigh);
//
//		FrontRightHigh = new ModelRenderer(this, "Front Right Skirt");
//		FrontRightHigh.setTextureOffset(18, 55);
//		FrontRightHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		FrontRightHigh.addBox(-3.3F, 6.6F, 6.1F, 4, 7, 2, 0.0F);
//		setRotateAngle(FrontRightHigh, -0.9599310885968813F, 0.2617993877991494F, 0.0F);
//		bipedBody.addChild(FrontRightHigh);
//
//		RightHigh = new ModelRenderer(this, "Right Skirt");
//		RightHigh.setTextureOffset(52, 38);
//		RightHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		RightHigh.addBox(5.5F, 8.0F, -2.0F, 2, 7, 4, -0.01F);
//		setRotateAngle(RightHigh, 0.0F, 0.0F, 0.9599310885968813F);
//		bipedBody.addChild(RightHigh);
//
//		BackUnderHigh = new ModelRenderer(this, "Underside Back Skirt");
//		BackUnderHigh.setTextureOffset(8, 57);
//		BackUnderHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BackUnderHigh.addBox(-2.0F, 8.0F, -8.0F, 4, 6, 1, 0.0F);
//		setRotateAngle(BackUnderHigh, 0.9599310885968813F, 0.0F, 0.0F);
//		bipedBody.addChild(BackUnderHigh);
//
//		UnderFrontHigh = new ModelRenderer(this, "Underside Front Skirt");
//		UnderFrontHigh.setTextureOffset(8, 57);
//		UnderFrontHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderFrontHigh.addBox(-2.0F, 8.0F, 7.0F, 4, 6, 1, 0.0F);
//		setRotateAngle(UnderFrontHigh, -0.9599310885968813F, 0.0F, 0.0F);
//		bipedBody.addChild(UnderFrontHigh);
//
//		UnderBackRightHigh = new ModelRenderer(this,
//				"Underside BackRight Skirt");
//		UnderBackRightHigh.setTextureOffset(8, 57);
//		UnderBackRightHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderBackRightHigh.addBox(-3.8F, 8.5F, -7.5F, 4, 6, 1, 0.0F);
//		setRotateAngle(UnderBackRightHigh, 0.9599310885968813F, -0.7853981633974483F, 0.0F);
//		bipedBody.addChild(UnderBackRightHigh);
//
//		BackLHigh = new ModelRenderer(this, "Back Left Skirt");
//		BackLHigh.setTextureOffset(18, 55);
//		BackLHigh.mirror = true;
//		BackLHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BackLHigh.addBox(-0.7F, 6.6F, -8.1F, 4, 7, 2, 0.0F);
//		setRotateAngle(BackLHigh, 0.9599310885968813F, 0.2617993877991494F, 0.0F);
//		bipedBody.addChild(BackLHigh);
//
//		BackRightHigh = new ModelRenderer(this, "Back Right Skirt");
//		BackRightHigh.setTextureOffset(18, 55);
//		BackRightHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BackRightHigh.addBox(-3.3F, 6.6F, -8.1F, 4, 7, 2, 0.0F);
//		setRotateAngle(BackRightHigh, 0.9599310885968813F, -0.2617993877991494F, 0.0F);
//		bipedBody.addChild(BackRightHigh);
//
//		UnderFrontRightHigh = new ModelRenderer(this,
//				"Underside FrontRight Skirt");
//		UnderFrontRightHigh.setTextureOffset(8, 57);
//		UnderFrontRightHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderFrontRightHigh.addBox(-3.8F, 8.5F, 6.5F, 4, 6, 1, 0.0F);
//		setRotateAngle(UnderFrontRightHigh, -0.9599310885968813F, 0.7853981633974483F, 0.0F);
//		bipedBody.addChild(UnderFrontRightHigh);
//
//		FrontLHigh = new ModelRenderer(this, "Front Left Skirt");
//		FrontLHigh.setTextureOffset(18, 55);
//		FrontLHigh.mirror = true;
//		FrontLHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		FrontLHigh.addBox(-0.7F, 6.6F, 6.1F, 4, 7, 2, 0.0F);
//		setRotateAngle(FrontLHigh, -0.9599310885968813F, -0.2617993877991494F, 0.0F);
//		bipedBody.addChild(FrontLHigh);
//
//		UnderFrontLeftHigh = new ModelRenderer(this, "Under FrontLeft Skirt");
//		UnderFrontLeftHigh.setTextureOffset(8, 57);
//		UnderFrontLeftHigh.mirror = true;
//		UnderFrontLeftHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderFrontLeftHigh.addBox(-0.2F, 8.5F, 6.5F, 4, 6, 1, 0.0F);
//		setRotateAngle(UnderFrontLeftHigh, -0.9599310885968813F, -0.7853981633974483F, 0.0F);
//		bipedBody.addChild(UnderFrontLeftHigh);
//
//		//Mid
//		FrontMidL = new ModelRenderer(this, "Front Left Dress");
//		FrontMidL.setTextureOffset(16, 32);
//		FrontMidL.mirror = true;
//		FrontMidL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		FrontMidL.addBox(-1.9F, -0.6F, -3.2F, 4, 8, 2, 0.0F);
//		setRotateAngle(FrontMidL, -0.4363323129985824F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(FrontMidL);
//
//		UnderBackRightMid = new ModelRenderer(this, "Underside BackRight Dress");
//		UnderBackRightMid.setTextureOffset(34, 42);
//		UnderBackRightMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderBackRightMid.addBox(-3.0F, 3.0F, 0.2F, 6, 8, 2, 0.0F);
//		setRotateAngle(UnderBackRightMid, 0.4363323129985824F, -0.3490658503988659F, 0.0F);
//		bipedRightLeg.addChild(UnderBackRightMid);
//
//		BackMidR = new ModelRenderer(this, "BackRight Dress");
//		BackMidR.setTextureOffset(28, 32);
//		BackMidR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BackMidR.addBox(-2.1F, -0.7F, 1.1F, 4, 8, 2, 0.0F);
//		setRotateAngle(BackMidR, 0.4363323129985824F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(BackMidR);
//
//		UnderLeftMid = new ModelRenderer(this, "Underside Left Dress");
//		UnderLeftMid.setTextureOffset(18, 42);
//		UnderLeftMid.mirror = true;
//		UnderLeftMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderLeftMid.addBox(0.0F, 3.8F, -3.0F, 2, 7, 6, 0.0F);
//		setRotateAngle(UnderLeftMid, 0.0F, 0.0F, -0.4363323129985824F);
//		bipedLeftLeg.addChild(UnderLeftMid);
//
//		UnderFrontLeftMid = new ModelRenderer(this, "Underside FrontLeft Dress");
//		UnderFrontLeftMid.setTextureOffset(40, 32);
//		UnderFrontLeftMid.mirror = true;
//		UnderFrontLeftMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderFrontLeftMid.addBox(-3.0F, 3.0F, -2.3F, 6, 8, 2, 0.0F);
//		setRotateAngle(UnderFrontLeftMid, -0.4363323129985824F, -0.3490658503988659F, 0.0F);
//		bipedLeftLeg.addChild(UnderFrontLeftMid);
//
//		BackLeftMid = new ModelRenderer(this, "Back Left Dress");
//		BackLeftMid.setTextureOffset(8, 47);
//		BackLeftMid.mirror = true;
//		BackLeftMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BackLeftMid.addBox(-1.3F, -0.4F, 1.5F, 3, 8, 2, 0.0F);
//		setRotateAngle(BackLeftMid, 0.4363323129985824F, 1.0471975511965976F, 0.0F);
//		bipedLeftLeg.addChild(BackLeftMid);
//
//		UnderBackLeftMid = new ModelRenderer(this, "Underside BackLeft Dress");
//		UnderBackLeftMid.setTextureOffset(34, 42);
//		UnderBackLeftMid.mirror = true;
//		UnderBackLeftMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderBackLeftMid.addBox(-3.0F, 3.0F, 0.2F, 6, 8, 2, 0.0F);
//		setRotateAngle(UnderBackLeftMid, 0.4363323129985824F, 0.3490658503988659F, 0.0F);
//		bipedLeftLeg.addChild(UnderBackLeftMid);
//
//		UnderFrontRightMid = new ModelRenderer(this,
//				"Underside FrontRight Dress");
//		UnderFrontRightMid.setTextureOffset(40, 32);
//		UnderFrontRightMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderFrontRightMid.addBox(-3.0F, 3.0F, -2.3F, 6, 8, 2, 0.0F);
//		setRotateAngle(UnderFrontRightMid, -0.4363323129985824F, 0.3490658503988659F, 0.0F);
//		bipedRightLeg.addChild(UnderFrontRightMid);
//
//		FrontRightMid = new ModelRenderer(this, "Front Right Dress");
//		FrontRightMid.setTextureOffset(8, 47);
//		FrontRightMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		FrontRightMid.addBox(-1.7F, -0.4F, -3.5F, 3, 8, 2, 0.0F);
//		setRotateAngle(FrontRightMid, -0.4363323129985824F, 1.0471975511965976F, 0.0F);
//		bipedRightLeg.addChild(FrontRightMid);
//
//		FrontLeftMid = new ModelRenderer(this, "Front Left Dress");
//		FrontLeftMid.setTextureOffset(8, 47);
//		FrontLeftMid.mirror = true;
//		FrontLeftMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		FrontLeftMid.addBox(-1.3F, -0.4F, -3.5F, 3, 8, 2, 0.0F);
//		setRotateAngle(FrontLeftMid, -0.4363323129985824F, -1.0471975511965976F, 0.0F);
//		bipedLeftLeg.addChild(FrontLeftMid);
//
//		UnderRightMid = new ModelRenderer(this, "Under Right Dress");
//		UnderRightMid.setTextureOffset(18, 42);
//		UnderRightMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		UnderRightMid.addBox(-2.0F, 3.8F, -3.0F, 2, 7, 6, 0.0F);
//		setRotateAngle(UnderRightMid, 0.0F, 0.0F, 0.4363323129985824F);
//		bipedRightLeg.addChild(UnderRightMid);
//
//		BackRightMid = new ModelRenderer(this, "Back Right Dress");
//		BackRightMid.setTextureOffset(8, 47);
//		BackRightMid.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BackRightMid.addBox(-1.7F, -0.4F, 1.5F, 3, 8, 2, 0.0F);
//		setRotateAngle(BackRightMid, 0.4363323129985824F, -1.0471975511965976F, 0.0F);
//		bipedRightLeg.addChild(BackRightMid);
//
//		FrontMidR = new ModelRenderer(this, "Front Right Dress");
//		FrontMidR.setTextureOffset(16, 32);
//		FrontMidR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		FrontMidR.addBox(-2.1F, -0.6F, -3.2F, 4, 8, 2, 0.0F);
//		setRotateAngle(FrontMidR, -0.4363323129985824F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(FrontMidR);
//
//		BackMidL = new ModelRenderer(this, "BackLeft Dress");
//		BackMidL.setTextureOffset(28, 32);
//		BackMidL.mirror = true;
//		BackMidL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BackMidL.addBox(-1.9F, -0.7F, 1.1F, 4, 8, 2, 0.0F);
//		setRotateAngle(BackMidL, 0.4363323129985824F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(BackMidL);
//
//		//Low
//		CenterBackL = new ModelRenderer(this, "Center BackLeft Robe");
//		CenterBackL.setTextureOffset(0, 49);
//		CenterBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		CenterBackL.addBox(-2.9F, -0.2F, 0.5F, 2, 11, 2, 0.0F);
//		setRotateAngle(CenterBackL, 0.08726646259971647F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(CenterBackL);
//
//		CenterFrontR = new ModelRenderer(this, "Center FrontRight Robe");
//		CenterFrontR.setTextureOffset(0, 49);
//		CenterFrontR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		CenterFrontR.addBox(0.9F, -0.2F, -2.5F, 2, 11, 2, 0.0F);
//		setRotateAngle(CenterFrontR, -0.08726646259971647F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(CenterFrontR);
//
//		CenterFrontL = new ModelRenderer(this, "Center FrontLeft Robe");
//		CenterFrontL.setTextureOffset(0, 49);
//		CenterFrontL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		CenterFrontL.addBox(-2.9F, -0.2F, -2.5F, 2, 11, 2, 0.0F);
//		setRotateAngle(CenterFrontL, -0.08726646259971647F, 0.0F, 0.0F);
//		bipedLeftLeg.addChild(CenterFrontL);
//
//		RightBackL = new ModelRenderer(this, "Right Back Robe");
//		RightBackL.setTextureOffset(0, 32);
//		RightBackL.mirror = true;
//		RightBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		RightBackL.addBox(-2.2F, -0.3F, -1.5F, 4, 11, 4, 0.0F);
//		setRotateAngle(RightBackL, 0.08726646259971647F, 0.0F, 0.08726646259971647F);
//		bipedRightLeg.addChild(RightBackL);
//
//		CenterBackR = new ModelRenderer(this, "Center BackRight Robe");
//		CenterBackR.setTextureOffset(0, 49);
//		CenterBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		CenterBackR.addBox(0.9F, -0.2F, 0.5F, 2, 11, 2, 0.0F);
//		setRotateAngle(CenterBackR, 0.08726646259971647F, 0.0F, 0.0F);
//		bipedRightLeg.addChild(CenterBackR);
//
//		LeftBackL = new ModelRenderer(this, "Left Back Robe");
//		LeftBackL.setTextureOffset(0, 32);
//		LeftBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		LeftBackL.addBox(-1.8F, -0.3F, -1.5F, 4, 11, 4, 0.0F);
//		setRotateAngle(LeftBackL, 0.08726646259971647F, 0.0F, -0.08726646259971647F);
//		bipedLeftLeg.addChild(LeftBackL);
//
//		RightFronL = new ModelRenderer(this, "Right Front Robe");
//		RightFronL.setTextureOffset(0, 32);
//		RightFronL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		RightFronL.addBox(-2.2F, -0.3F, -2.5F, 4, 11, 4, 0.01F);
//		setRotateAngle(RightFronL, -0.08726646259971647F, 0.0F, 0.08726646259971647F);
//		bipedRightLeg.addChild(RightFronL);
//
//		LeftFrontL = new ModelRenderer(this, "Left Front Robe");
//		LeftFrontL.setTextureOffset(0, 32);
//		LeftFrontL.mirror = true;
//		LeftFrontL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		LeftFrontL.addBox(-1.8F, -0.3F, -2.5F, 4, 11, 4, 0.01F);
//		setRotateAngle(LeftFrontL, -0.08726646259971647F, 0.0F, -0.08726646259971647F);
//		bipedLeftLeg.addChild(LeftFrontL);
//
//		//Belts
//		BeltRHip = new ModelRenderer(this, "Belt Right Hip");
//		BeltRHip.setTextureOffset(32, 55);
//		BeltRHip.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BeltRHip.addBox(-3.3F, 0.0F, -3.0F, 10, 3, 6, -0.11F);
//		setRotateAngle(BeltRHip, 0.0F, 0.0F, -0.13962634015954636F);
//		bipedRightLeg.addChild(BeltRHip);
//
//		BeltLHip = new ModelRenderer(this, "Belt Left Hip");
//		BeltLHip.setTextureOffset(32, 55);
//		BeltLHip.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BeltLHip.addBox(-6.7F, 0.0F, -3.0F, 10, 3, 6, -0.1F);
//		setRotateAngle(BeltLHip, 0.0F, 0.0F, 0.13962634015954636F);
//		bipedLeftLeg.addChild(BeltLHip);
//
//		BeltStraight = new ModelRenderer(this, "Belt Straight");
//		BeltStraight.setTextureOffset(34, 55);
//		BeltStraight.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BeltStraight.addBox(-4.5F, 10.5F, -3.0F, 9, 3, 6, -0.1F);
//		bipedBody.addChild(BeltStraight);
//
//		BackLHigh.isHidden = true;
//		BackRightHigh.isHidden = true;
//		BackUnderHigh.isHidden = true;
//		FrontLHigh.isHidden = true;
//		FrontRightHigh.isHidden = true;
//		LeftHigh.isHidden = true;
//		RightHigh.isHidden = true;
//		UnderBackLeftHigh.isHidden = true;
//		UnderBackRightHigh.isHidden = true;
//		UnderFrontHigh.isHidden = true;
//		UnderFrontLeftHigh.isHidden = true;
//		UnderFrontRightHigh.isHidden = true;
//
//		BackLeftMid.isHidden = true;
//		BackMidL.isHidden = true;
//		BackMidR.isHidden = true;
//		BackRightMid.isHidden = true;
//		FrontLeftMid.isHidden = true;
//		FrontMidL.isHidden = true;
//		FrontMidR.isHidden = true;
//		FrontRightMid.isHidden = true;
//		UnderBackLeftMid.isHidden = true;
//		UnderBackRightMid.isHidden = true;
//		UnderFrontLeftMid.isHidden = true;
//		UnderFrontRightMid.isHidden = true;
//		UnderLeftMid.isHidden = true;
//		UnderRightMid.isHidden = true;
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
