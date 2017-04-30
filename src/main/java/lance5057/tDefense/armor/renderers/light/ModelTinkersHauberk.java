//package lance5057.tDefense.armor.renderers.light;
//
//import lance5057.tDefense.armor.renderers.ArmorRenderer;
//import net.minecraft.client.model.ModelRenderer;
//
///**
// * ModelTinkersHauberk - Either Mojang or a mod author
// * Created using Tabula 4.1.1
// */
//public class ModelTinkersHauberk extends ArmorRenderer
//{
//	public ModelRenderer	ChestBeltR;
//	public ModelRenderer	ChestBelt;
//	public ModelRenderer	ChestBeltR_1;
//	public ModelRenderer	ChestBelt_1;
//	public ModelRenderer	ChestBeltL;
//	public ModelRenderer	ChestBeltL_1;
//	public ModelRenderer	ChestBelt_2;
//	public ModelRenderer	Pauldron1;
//	public ModelRenderer	Pauldron2;
//	public ModelRenderer	PauldronStudR;
//	public ModelRenderer	Pauldron3R;
//	public ModelRenderer	PauldronFlairR;
//	public ModelRenderer	Pauldron1L;
//	public ModelRenderer	Pauldron2L;
//	public ModelRenderer	PauldronStudL;
//	public ModelRenderer	Pauldron3L;
//	public ModelRenderer	PauldronFlairL;
//
//	public ModelTinkersHauberk()
//	{
//		super(0.1f, 0, 64, 64);
//
//		textureWidth = 64;
//		textureHeight = 64;
//
//		bipedBody = new ModelRenderer(this, "Body");
//		bipedBody.setTextureOffset(16, 16);
//		bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.05f);
//		bipedBody.setRotationPoint(0.0F, 0.0F + 0, 0.0F);
//
//		bipedRightArm = new ModelRenderer(this, "Right Arm");
//		bipedRightArm.setTextureOffset(40, 16);
//		bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.05f);
//		bipedRightArm.setRotationPoint(-5.0F, 2.0F + 0, 0.0F);
//
//		bipedLeftArm = new ModelRenderer(this, "Left Arm");
//		bipedLeftArm.setTextureOffset(40, 16);
//		bipedLeftArm.mirror = true;
//		bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.05f);
//		bipedLeftArm.setRotationPoint(5.0F, 2.0F + 0, 0.0F);
//
//		ChestBelt_1 = new ModelRenderer(this, "ChestBelt_1");
//		ChestBelt_1.setTextureOffset(0, 57);
//		ChestBelt_1.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ChestBelt_1.addBox(-4.5F, 9.0F, -2.5F, 9, 2, 5, -0.19F);
//		bipedBody.addChild(ChestBelt_1);
//
//		ChestBelt_2 = new ModelRenderer(this, "ChestBelt_2");
//		ChestBelt_2.setTextureOffset(28, 32);
//		ChestBelt_2.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ChestBelt_2.addBox(-4.5F, 5.0F, -2.5F, 9, 2, 5, -0.19F);
//		bipedBody.addChild(ChestBelt_2);
//
//		Pauldron3R = new ModelRenderer(this, "Pauldron3R");
//		Pauldron3R.setTextureOffset(0, 32);
//		Pauldron3R.setRotationPoint(-0.0F, 0.0F, 0.0F);
//		Pauldron3R.addBox(-3.2F, -0.5F, -2.0F, 3, 4, 4, 0.1F);
//		setRotateAngle(Pauldron3R, 0.0F, 0.0F, 0.08726646259971647F);
//		bipedRightArm.addChild(Pauldron3R);
//
//		Pauldron2L = new ModelRenderer(this, "Pauldron2L");
//		Pauldron2L.setTextureOffset(0, 49);
//		Pauldron2L.mirror = true;
//		Pauldron2L.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Pauldron2L.addBox(-1.0F, -3.0F, -2.0F, 3, 3, 4, 0.1F);
//		setRotateAngle(Pauldron2L, 0.0F, 0.0F, 0.2617993877991494F);
//		bipedLeftArm.addChild(Pauldron2L);
//
//		Pauldron3L = new ModelRenderer(this, "Pauldron3L");
//		Pauldron3L.setTextureOffset(0, 32);
//		Pauldron3L.mirror = true;
//		Pauldron3L.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Pauldron3L.addBox(0.2F, -0.5F, -2.0F, 3, 4, 4, 0.1F);
//		setRotateAngle(Pauldron3L, 0.0F, 0.0F, -0.08726646259971647F);
//		bipedLeftArm.addChild(Pauldron3L);
//
//		ChestBeltR = new ModelRenderer(this, "ChestBeltR");
//		ChestBeltR.setTextureOffset(0, 57);
//		ChestBeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ChestBeltR.addBox(-1.7F, 5.7F, -2.5F, 11, 2, 5, -0.2F);
//		setRotateAngle(ChestBeltR, 0.0F, 0.0F, 0.5235987755982988F);
//		bipedBody.addChild(ChestBeltR);
//
//		ChestBeltL = new ModelRenderer(this, "ChestBeltL");
//		ChestBeltL.setTextureOffset(0, 57);
//		ChestBeltL.mirror = true;
//		ChestBeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ChestBeltL.addBox(-7.5F, 2.3F, -2.5F, 11, 2, 5, -0.2F);
//		setRotateAngle(ChestBeltL, 0.0F, 0.0F, -0.5235987755982988F);
//		bipedBody.addChild(ChestBeltL);
//
//		ChestBeltL_1 = new ModelRenderer(this, "ChestBeltL_1");
//		ChestBeltL_1.setTextureOffset(0, 57);
//		ChestBeltL_1.mirror = true;
//		ChestBeltL_1.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ChestBeltL_1.addBox(-9.3F, 5.7F, -2.5F, 11, 2, 5, -0.21F);
//		setRotateAngle(ChestBeltL_1, 0.0F, 0.0F, -0.5235987755982988F);
//		bipedBody.addChild(ChestBeltL_1);
//
//		PauldronStudR = new ModelRenderer(this, "PauldronStudR");
//		PauldronStudR.setTextureOffset(14, 32);
//		PauldronStudR.setRotationPoint(-0.0F, 0.0F, 0.0F);
//		PauldronStudR.addBox(-1.0F, -1.5F, -2.5F, 2, 2, 5, 0.1F);
//		setRotateAngle(PauldronStudR, 0.0F, 0.0F, -0.2617993877991494F);
//		bipedRightArm.addChild(PauldronStudR);
//
//		Pauldron1 = new ModelRenderer(this, "Pauldron1");
//		Pauldron1.setTextureOffset(0, 40);
//		Pauldron1.setRotationPoint(-0.0F, 0.0F, 0.0F);
//		Pauldron1.addBox(-3.5F, -1.9F, -2.5F, 4, 4, 5, 0.0F);
//		setRotateAngle(Pauldron1, 0.0F, 0.0F, 0.2617993877991494F);
//		bipedRightArm.addChild(Pauldron1);
//
//		ChestBeltR_1 = new ModelRenderer(this, "ChestBeltR_1");
//		ChestBeltR_1.setTextureOffset(0, 57);
//		ChestBeltR_1.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ChestBeltR_1.addBox(-3.5F, 2.3F, -2.5F, 11, 2, 5, -0.21F);
//		setRotateAngle(ChestBeltR_1, 0.0F, 0.0F, 0.5235987755982988F);
//		bipedBody.addChild(ChestBeltR_1);
//
//		PauldronFlairR = new ModelRenderer(this, "PauldronFlairR");
//		PauldronFlairR.setTextureOffset(18, 39);
//		PauldronFlairR.mirror = true;
//		PauldronFlairR.setRotationPoint(-0.0F, 0.0F, 0.0F);
//		PauldronFlairR.addBox(-8.5F, -4.5F, 0.0F, 7, 9, 0, 0.0F);
//		setRotateAngle(PauldronFlairR, 0.0F, 0.0F, 0.2617993877991494F);
//		bipedRightArm.addChild(PauldronFlairR);
//
//		PauldronFlairL = new ModelRenderer(this, "PauldronFlairL");
//		PauldronFlairL.setTextureOffset(18, 39);
//		PauldronFlairL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		PauldronFlairL.addBox(1.5F, -4.5F, 0.0F, 7, 9, 0, 0.0F);
//		setRotateAngle(PauldronFlairL, 0.0F, 0.0F, -0.2617993877991494F);
//		bipedLeftArm.addChild(PauldronFlairL);
//
//		Pauldron2 = new ModelRenderer(this, "Pauldron2");
//		Pauldron2.setTextureOffset(0, 49);
//		Pauldron2.setRotationPoint(-0.0F, 0.0F, 0.0F);
//		Pauldron2.addBox(-2.0F, -3.0F, -2.0F, 3, 3, 4, 0.1F);
//		setRotateAngle(Pauldron2, 0.0F, 0.0F, -0.2617993877991494F);
//		bipedRightArm.addChild(Pauldron2);
//
//		PauldronStudL = new ModelRenderer(this, "PauldronStudL");
//		PauldronStudL.setTextureOffset(14, 32);
//		PauldronStudL.mirror = true;
//		PauldronStudL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		PauldronStudL.addBox(-1.0F, -1.5F, -2.5F, 2, 2, 5, 0.1F);
//		setRotateAngle(PauldronStudL, 0.0F, 0.0F, 0.2617993877991494F);
//		bipedLeftArm.addChild(PauldronStudL);
//
//		Pauldron1L = new ModelRenderer(this, "Pauldron1L");
//		Pauldron1L.setTextureOffset(0, 40);
//		Pauldron1L.mirror = true;
//		Pauldron1L.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Pauldron1L.addBox(-0.5F, -1.9F, -2.5F, 4, 4, 5, 0.0F);
//		setRotateAngle(Pauldron1L, 0.0F, 0.0F, -0.2617993877991494F);
//		bipedLeftArm.addChild(Pauldron1L);
//
//		ChestBelt = new ModelRenderer(this, "ChestBelt");
//		ChestBelt.setTextureOffset(28, 32);
//		ChestBelt.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ChestBelt.addBox(-4.5F, 3.0F, -2.5F, 9, 2, 5, -0.19F);
//		bipedBody.addChild(ChestBelt);
//
//		//ChestBelt.isHidden = true;
//		ChestBelt_1.isHidden = true;
//		ChestBelt_2.isHidden = true;
//		ChestBeltL.isHidden = true;
//		ChestBeltL_1.isHidden = true;
//		ChestBeltR.isHidden = true;
//		ChestBeltR_1.isHidden = true;
//		PauldronFlairL.isHidden = true;
//		PauldronFlairR.isHidden = true;
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
