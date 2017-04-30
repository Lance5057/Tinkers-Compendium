package lance5057.tDefense.armor.renderers.heavy;

import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersBreastplate extends ArmorRenderer 
{
	public ModelRenderer	BackPlate;
	public ModelRenderer	BreastPlate;
	public ModelRenderer	Plackart;
	public ModelRenderer	WingR;
	public ModelRenderer	WingL;
	public ModelRenderer	PauldronR;
	public ModelRenderer	PauldronL;
	public ModelRenderer	ArmR;
	public ModelRenderer	ArmL;
	public ModelRenderer	PauldronExtraR;
	public ModelRenderer	PauldronExtraL;
	public ModelRenderer	PauldronR_1;
	public ModelRenderer	ArmR_1;
	public ModelRenderer	PauldronL_1;
	public ModelRenderer	ArmL_1;

	public ModelTinkersBreastplate()
	{
		super(0.1f, 0, 128, 64);

		textureWidth = 128;
		textureHeight = 64;

		bipedBody = new ModelRenderer(this, "Body");
		bipedBody.setTextureOffset(16, 16);
		bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.1f);
		bipedBody.setRotationPoint(0.0F, 0.0F + 0, 0.0F);

		bipedRightArm = new ModelRenderer(this, "Right Arm");
		bipedRightArm.setTextureOffset(40, 16);
		bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.1f);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F + 0, 0.0F);

		bipedLeftArm = new ModelRenderer(this, "Left Arm");
		bipedLeftArm.setTextureOffset(40, 16);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.1f);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F + 0, 0.0F);

		ArmR = new ModelRenderer(this, "Arm Right Overlay");
		ArmR.setTextureOffset(28, 44);
		ArmR.mirror = true;
		ArmR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ArmR.addBox(-4.0F, -2.2F, -3.0F, 5, 6, 6, 0.0F);
		bipedRightArm.addChild(ArmR);

		ArmR_1 = new ModelRenderer(this, "Arm Overlay Right 2");
		ArmR_1.setTextureOffset(94, 0);
		ArmR_1.mirror = true;
		ArmR_1.setRotationPoint(-0.0F, 0.0F, 0.0F);
		ArmR_1.addBox(-4.5F, -2.0F, -3.0F, 6, 7, 6, 0.1F);
		setRotateAngle(ArmR_1, 0.0F, -0.0F, -0.17453292519943295F);
		bipedRightArm.addChild(ArmR_1);

		ArmL = new ModelRenderer(this, "Arm Overlay Left");
		ArmL.setTextureOffset(28, 44);
		ArmL.setRotationPoint(0.0F, 0.0F, 0.0F);
		ArmL.addBox(-1.0F, -2.2F, -3.0F, 5, 6, 6, 0.0F);
		bipedLeftArm.addChild(ArmL);

		ArmL_1 = new ModelRenderer(this, "Arm Left Overlay 2");
		ArmL_1.setTextureOffset(94, 0);
		ArmL_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		ArmL_1.addBox(-1.0F, -2.0F, -3.0F, 6, 7, 6, 0.1F);
		setRotateAngle(ArmL_1, 0.0F, -0.0F, 0.17453292519943295F);
		bipedLeftArm.addChild(ArmL_1);

		PauldronL = new ModelRenderer(this, "Pauldron Left");
		PauldronL.setTextureOffset(24, 32);
		PauldronL.setRotationPoint(0.0F, 0.0F, 0.0F);
		PauldronL.addBox(0.6F, -2.0F, -3.5F, 4, 5, 7, 0.0F);
		setRotateAngle(PauldronL, 0.0F, -0.0F, -0.4363323129985824F);
		bipedLeftArm.addChild(PauldronL);

		PauldronR = new ModelRenderer(this, "Pauldron Right");
		PauldronR.setTextureOffset(24, 32);
		PauldronR.mirror = true;
		PauldronR.setRotationPoint(-0.0F, 0.0F, 0.0F);
		PauldronR.addBox(-4.8F, -2.0F, -3.5F, 4, 5, 7, 0.0F);
		setRotateAngle(PauldronR, 0.0F, -0.0F, 0.4363323129985824F);
		bipedRightArm.addChild(PauldronR);

		PauldronExtraL = new ModelRenderer(this, "Pauldron Extra Left");
		PauldronExtraL.setTextureOffset(56, 19);
		PauldronExtraL.setRotationPoint(0.0F, 0.0F, 0.0F);
		PauldronExtraL.addBox(0.0F, -12.0F, 0.0F, 13, 18, 0, 0.0F);
		bipedLeftArm.addChild(PauldronExtraL);

		PauldronExtraR = new ModelRenderer(this, "Pauldron Extra Right");
		PauldronExtraR.setTextureOffset(56, 19);
		PauldronExtraR.mirror = true;
		PauldronExtraR.setRotationPoint(0.0F, 0.0F, 0.0F);
		PauldronExtraR.addBox(-12.0F, -12.0F, 0.0F, 13, 18, 0, 0.0F);
		bipedRightArm.addChild(PauldronExtraR);

		PauldronR_1 = new ModelRenderer(this, "Pauldron Right 2");
		PauldronR_1.setTextureOffset(64, 0);
		PauldronR_1.mirror = true;
		PauldronR_1.setRotationPoint(-0.0F, 0.0F, 0.0F);
		PauldronR_1.addBox(-5.5F, -8.0F, -4.0F, 7, 11, 8, 0.1F);
		setRotateAngle(PauldronR_1, 0.0F, -0.0F, 0.2617993877991494F);
		bipedRightArm.addChild(PauldronR_1);

		PauldronL_1 = new ModelRenderer(this, "Pauldron Left 2");
		PauldronL_1.setTextureOffset(64, 0);
		PauldronL_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		PauldronL_1.addBox(-1.5F, -8.0F, -4.0F, 7, 11, 8, 0.1F);
		setRotateAngle(PauldronL_1, 0.0F, -0.0F, -0.2617993877991494F);
		bipedLeftArm.addChild(PauldronL_1);

		WingL = new ModelRenderer(this, "Wing Left");
		WingL.setTextureOffset(82, 5);
		WingL.setRotationPoint(0.0F, 0.0F, 0.0F);
		WingL.addBox(0.0F, -6.0F, 3.0F, 0, 28, 14, 0.0F);
		setRotateAngle(WingL, 0.0F, -0.2617993877991494F, 0.0F);
		bipedBody.addChild(WingL);

		WingR = new ModelRenderer(this, "Wing Right");
		WingR.setTextureOffset(82, 5);
		WingR.setRotationPoint(0.0F, 0.0F, 0.0F);
		WingR.addBox(0.0F, -6.0F, 3.0F, 0, 28, 14, 0.0F);
		setRotateAngle(WingR, 0.0F, 0.2617993877991494F, 0.0F);
		bipedBody.addChild(WingR);

		Plackart = new ModelRenderer(this, "Plackart");
		Plackart.setTextureOffset(0, 42);
		Plackart.setRotationPoint(0.0F, 0.0F, 0.0F);
		Plackart.addBox(-4.0F, 5.0F, -3.0F, 8, 7, 6, 0.0F);
		bipedBody.addChild(Plackart);

		BreastPlate = new ModelRenderer(this, "BreastPlate");
		BreastPlate.setTextureOffset(0, 32);
		BreastPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
		BreastPlate.addBox(-4.0F, 0.1F, -3.6F, 8, 6, 4, 0.1F);
		bipedBody.addChild(BreastPlate);

		BackPlate = new ModelRenderer(this, "Back Plate");
		BackPlate.setTextureOffset(0, 56);
		BackPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackPlate.addBox(-4.0F, 0.0F, 1.0F, 8, 5, 3, 0.0F);
		setRotateAngle(BackPlate, -0.08726646006107329F, -0.0F, 0.0F);
		bipedBody.addChild(BackPlate);

		WingL.isHidden = true;
		WingR.isHidden = true;
		PauldronL_1.isHidden = true;
		PauldronR_1.isHidden = true;
		ArmL_1.isHidden = true;
		ArmR_1.isHidden = true;
		PauldronExtraL.isHidden = true;
		PauldronExtraR.isHidden = true;

		init();
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
