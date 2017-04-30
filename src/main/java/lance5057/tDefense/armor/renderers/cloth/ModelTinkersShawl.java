//package lance5057.tDefense.armor.renderers.cloth;
//
//import lance5057.tDefense.armor.renderers.ArmorRenderer;
//import net.minecraft.client.model.ModelRenderer;
//
///**
// * ModelTinkersShawl - Either Mojang or a mod author
// * Created using Tabula 4.1.1
// */
//public class ModelTinkersShawl extends ArmorRenderer
//{
//	public ModelRenderer	Button;
//	public ModelRenderer	Zipper;
//	public ModelRenderer	ArmTrimL;
//	public ModelRenderer	ArmTrimR;
//	public ModelRenderer	TrimNeck;
//	public ModelRenderer	ButtonArmL;
//	public ModelRenderer	ButtonArmR;
//	public ModelRenderer	ShawlLeftShort;
//	public ModelRenderer	ShawlRightShort;
//	public ModelRenderer	ShawlLeftTrim;
//	public ModelRenderer	TrimShawl;
//	public ModelRenderer	ShawlRightTrim;
//	public ModelRenderer	ZipperShort;
//	public ModelRenderer	ShawlLeftLong;
//	public ModelRenderer	ShawlLeftTrimLong;
//	public ModelRenderer	ShawlRightLong;
//	public ModelRenderer	ShawlRightTrimLong;
//
//	public ModelTinkersShawl()
//	{
//		super(0.1f, 0, 64, 64);
//
//		textureWidth = 64;
//		textureHeight = 64;
//
//		TrimNeck = new ModelRenderer(this, "Collar");
//		TrimNeck.setTextureOffset(20, 32);
//		TrimNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
//		TrimNeck.addBox(-4.5F, -0.5F, -2.5F, 9, 2, 5, -0.3F);
//		bipedBody.addChild(TrimNeck);
//
//		Button = new ModelRenderer(this, "Collar Button");
//		Button.setTextureOffset(15, 32);
//		Button.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Button.addBox(-1.5F, -0.5F, -2.5F, 2, 2, 1, -0.2F);
//		setRotateAngle(Button, 0.0F, 0.0F, -0.7853981633974483F);
//		bipedBody.addChild(Button);
//
//		ButtonArmL = new ModelRenderer(this, "Button Arm Left");
//		ButtonArmL.setTextureOffset(23, 39);
//		ButtonArmL.mirror = true;
//		ButtonArmL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ButtonArmL.addBox(2.5F, 3.0F, -5.0F, 1, 2, 2, -0.2F);
//		setRotateAngle(ButtonArmL, 0.7853981633974483F, 0.0F, 0.0F);
//		bipedLeftArm.addChild(ButtonArmL);
//
//		ButtonArmR = new ModelRenderer(this, "Button Arm Right");
//		ButtonArmR.setTextureOffset(23, 39);
//		ButtonArmR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ButtonArmR.addBox(-3.5F, 3.0F, -5.0F, 1, 2, 2, -0.2F);
//		setRotateAngle(ButtonArmR, 0.7853981633974483F, 0.0F, 0.0F);
//		bipedRightArm.addChild(ButtonArmR);
//
//		ArmTrimR = new ModelRenderer(this, "Arm Trim Right");
//		ArmTrimR.setTextureOffset(0, 32);
//		ArmTrimR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ArmTrimR.addBox(-3.5F, 5.0F, -2.5F, 5, 2, 5, -0.3F);
//		bipedRightArm.addChild(ArmTrimR);
//
//		ArmTrimL = new ModelRenderer(this, "Arm Trim Left");
//		ArmTrimL.setTextureOffset(0, 32);
//		ArmTrimL.mirror = true;
//		ArmTrimL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ArmTrimL.addBox(-1.5F, 5.0F, -2.5F, 5, 2, 5, -0.3F);
//		bipedLeftArm.addChild(ArmTrimL);
//
//		ZipperShort = new ModelRenderer(this, "Zipper Bottom");
//		ZipperShort.setTextureOffset(30, 53);
//		ZipperShort.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ZipperShort.addBox(-1.0F, 6.3F, -2.5F, 2, 5, 1, -0.3F);
//		bipedBody.addChild(ZipperShort);
//
//		Zipper = new ModelRenderer(this, "Zipper Top");
//		Zipper.setTextureOffset(30, 52);
//		Zipper.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Zipper.addBox(-1.0F, 0.2F, -2.5F, 2, 7, 1, -0.3F);
//		bipedBody.addChild(Zipper);
//
//		ShawlLeftTrim = new ModelRenderer(this, "Shawl Left Trim");
//		ShawlLeftTrim.setTextureOffset(28, 39);
//		ShawlLeftTrim.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ShawlLeftTrim.addBox(-5.1F, 2.45F, -2.5F, 9, 2, 5, -0.29F);
//		setRotateAngle(ShawlLeftTrim, 0.0F, 0.0F, -0.2792526803190927F);
//		bipedLeftArm.addChild(ShawlLeftTrim);
//
//		ShawlRightTrim = new ModelRenderer(this, "Shawl Right Trim Short");
//		ShawlRightTrim.setTextureOffset(28, 39);
//		ShawlRightTrim.mirror = true;
//		ShawlRightTrim.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ShawlRightTrim.addBox(-3.95F, 2.45F, -2.5F, 9, 2, 5, -0.29F);
//		setRotateAngle(ShawlRightTrim, 0.0F, 0.0F, 0.2792526803190927F);
//		bipedRightArm.addChild(ShawlRightTrim);
//
//		ShawlRightTrimLong = new ModelRenderer(this, "Shawl Right Trim Long");
//		ShawlRightTrimLong.setTextureOffset(0, 39);
//		ShawlRightTrimLong.mirror = true;
//		ShawlRightTrimLong.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ShawlRightTrimLong.addBox(-3.95F, 7.85F, -2.5F, 9, 2, 5, -0.29F);
//		setRotateAngle(ShawlRightTrimLong, 0.0F, 0.0F, 0.2792526803190927F);
//		bipedRightArm.addChild(ShawlRightTrimLong);
//
//		ShawlLeftTrimLong = new ModelRenderer(this, "Shawl Left Trim Long");
//		ShawlLeftTrimLong.setTextureOffset(0, 39);
//		ShawlLeftTrimLong.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ShawlLeftTrimLong.addBox(-5.1F, 7.85F, -2.5F, 9, 2, 5, -0.29F);
//		setRotateAngle(ShawlLeftTrimLong, 0.0F, 0.0F, -0.2792526803190927F);
//		bipedLeftArm.addChild(ShawlLeftTrimLong);
//
//		ShawlLeftLong = new ModelRenderer(this, "Shawl Left Long");
//		ShawlLeftLong.setTextureOffset(38, 50);
//		ShawlLeftLong.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ShawlLeftLong.addBox(-4.55F, -1.05F, -2.0F, 8, 10, 4, 0.11F);
//		setRotateAngle(ShawlLeftLong, 0.0F, 0.0F, -0.2792526803190927F);
//		bipedLeftArm.addChild(ShawlLeftLong);
//
//		ShawlRightLong = new ModelRenderer(this, "Shawl Right Long");
//		ShawlRightLong.setTextureOffset(38, 50);
//		ShawlRightLong.mirror = true;
//		ShawlRightLong.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ShawlRightLong.addBox(-3.45F, -1.05F, -2.0F, 8, 10, 4, 0.11F);
//		setRotateAngle(ShawlRightLong, 0.0F, 0.0F, 0.2792526803190927F);
//		bipedRightArm.addChild(ShawlRightLong);
//
//		ShawlLeftShort = new ModelRenderer(this, "Shawl Left Short");
//		ShawlLeftShort.setTextureOffset(38, 50);
//		ShawlLeftShort.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ShawlLeftShort.addBox(-1.55F, -1.05F, -2.0F, 5, 5, 4, 0.01F);
//		setRotateAngle(ShawlLeftShort, 0.0F, 0.0F, -0.2792526803190927F);
//		bipedLeftArm.addChild(ShawlLeftShort);
//
//		ShawlRightShort = new ModelRenderer(this, "Shawl Right Short");
//		ShawlRightShort.setTextureOffset(38, 50);
//		ShawlRightShort.mirror = true;
//		ShawlRightShort.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ShawlRightShort.addBox(-3.45F, -1.05F, -2.0F, 5, 5, 4, 0.01F);
//		setRotateAngle(ShawlRightShort, 0.0F, 0.0F, 0.2792526803190927F);
//		bipedRightArm.addChild(ShawlRightShort);
//
//		TrimShawl = new ModelRenderer(this, "Trim Shawl Short");
//		TrimShawl.setTextureOffset(20, 32);
//		TrimShawl.setRotationPoint(0.0F, 0.0F, 0.0F);
//		TrimShawl.addBox(-4.5F, 5.5F, -2.5F, 9, 2, 5, -0.31F);
//		bipedBody.addChild(TrimShawl);
//
//		ArmTrimL.isHidden = true;
//		ArmTrimR.isHidden = true;
//		ShawlLeftTrim.isHidden = true;
//		ShawlRightTrim.isHidden = true;
//		TrimShawl.isHidden = true;
//		Zipper.isHidden = true;
//		ZipperShort.isHidden = true;
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
