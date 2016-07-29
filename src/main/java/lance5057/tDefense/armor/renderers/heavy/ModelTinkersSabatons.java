package lance5057.tDefense.armor.renderers.heavy;

import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;

/**
 * TinkersSabatons - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersSabatons extends ArmorRenderer
{
	public ModelRenderer	BootL;
	public ModelRenderer	FlairBackR;
	public ModelRenderer	ShinGuardL;
	public ModelRenderer	KneeGuardCapL;
	public ModelRenderer	LegBackL;
	public ModelRenderer	BootR;
	public ModelRenderer	ShinGuardR;
	public ModelRenderer	BootCapR;
	public ModelRenderer	BootCapL;
	public ModelRenderer	LegBackR;
	public ModelRenderer	FlairL;
	public ModelRenderer	KneeGuardCapR;
	public ModelRenderer	BootTipR;
	public ModelRenderer	BootTipL;
	public ModelRenderer	KneeGuardR;
	public ModelRenderer	KneeGuardL;
	public ModelRenderer	FlairR;
	public ModelRenderer	BackFlairL;

	public ModelTinkersSabatons()
	{
		super(0.1f, 0, 64, 64);

		textureWidth = 64;
		textureHeight = 64;

		BootR = new ModelRenderer(this, "Boot Right");
		BootR.setTextureOffset(0, 56);
		BootR.setRotationPoint(0.0F, 0.0F, 0.0F);
		BootR.addBox(-2.0F, 9.0F, -3.0F, 4, 3, 5, 0.2F);
		bipedRightLeg.addChild(BootR);

		BootL = new ModelRenderer(this, "Boot Left");
		BootL.setTextureOffset(0, 56);
		BootL.mirror = true;
		BootL.setRotationPoint(0.0F, 0.0F, 0.0F);
		BootL.addBox(-2.0F, 9.0F, -3.0F, 4, 3, 5, 0.2F);
		bipedLeftLeg.addChild(BootL);

		KneeGuardR = new ModelRenderer(this, "Knee Guard Right");
		KneeGuardR.setTextureOffset(0, 32);
		KneeGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
		KneeGuardR.addBox(-2.0F, 3.1F, -2.5F, 4, 3, 4, 0.3F);
		bipedRightLeg.addChild(KneeGuardR);

		KneeGuardL = new ModelRenderer(this, "Knee Guard Left");
		KneeGuardL.setTextureOffset(0, 32);
		KneeGuardL.mirror = true;
		KneeGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
		KneeGuardL.addBox(-2.0F, 3.1F, -2.5F, 4, 3, 4, 0.3F);
		bipedLeftLeg.addChild(KneeGuardL);

		ShinGuardR = new ModelRenderer(this, "Shin Guard Right");
		ShinGuardR.setTextureOffset(0, 48);
		ShinGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ShinGuardR.addBox(-2.0F, 4.0F, -2.5F, 4, 5, 3, 0.11F);
		setRotateAngle(ShinGuardR, 0.05759586531581287F, 0.0F, 0.0F);
		bipedRightLeg.addChild(ShinGuardR);

		ShinGuardL = new ModelRenderer(this, "Shin Guard Left");
		ShinGuardL.setTextureOffset(0, 48);
		ShinGuardL.mirror = true;
		ShinGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
		ShinGuardL.addBox(-2.0F, 4.0F, -2.5F, 4, 5, 3, 0.11F);
		setRotateAngle(ShinGuardL, 0.05759586531581287F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(ShinGuardL);

		LegBackL = new ModelRenderer(this, "Leg Back Left");
		LegBackL.setTextureOffset(0, 40);
		LegBackL.mirror = true;
		LegBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegBackL.addBox(-2.0F, 3.0F, 0.6F, 4, 6, 2, 0.1F);
		setRotateAngle(LegBackL, -0.05759586531581287F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(LegBackL);

		LegBackR = new ModelRenderer(this, "Leg Back Right");
		LegBackR.setTextureOffset(0, 40);
		LegBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegBackR.addBox(-2.0F, 3.0F, 0.6F, 4, 6, 2, 0.1F);
		setRotateAngle(LegBackR, -0.05759586531581287F, 0.0F, 0.0F);
		bipedRightLeg.addChild(LegBackR);

		FlairR = new ModelRenderer(this, "Flair Right");
		FlairR.setTextureOffset(18, 53);
		FlairR.setRotationPoint(0.0F, 0.0F, 0.0F);
		FlairR.addBox(0.9F, 0.2F, -2.5F, 5, 11, 0, 0.0F);
		setRotateAngle(FlairR, 0.0F, -0.6108652381980153F, 0.0F);
		bipedLeftLeg.addChild(FlairR);

		FlairL = new ModelRenderer(this, "Flair Left");
		FlairL.setTextureOffset(18, 53);
		FlairL.mirror = true;
		FlairL.setRotationPoint(0.0F, 0.0F, 0.0F);
		FlairL.addBox(-5.9F, 0.2F, -2.5F, 5, 11, 0, 0.0F);
		setRotateAngle(FlairL, 0.0F, 0.6108652381980153F, 0.0F);
		bipedRightLeg.addChild(FlairL);

		FlairBackR = new ModelRenderer(this, "Flair Back Right");
		FlairBackR.setTextureOffset(28, 47);
		FlairBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
		FlairBackR.addBox(0.0F, 0.0F, 2.0F, 0, 12, 5, 0.0F);
		bipedRightLeg.addChild(FlairBackR);

		BackFlairL = new ModelRenderer(this, "Flair Back Left");
		BackFlairL.setTextureOffset(28, 47);
		BackFlairL.mirror = true;
		BackFlairL.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackFlairL.addBox(0.0F, 0.0F, 2.0F, 0, 12, 5, 0.0F);
		bipedLeftLeg.addChild(BackFlairL);

		KneeGuardCapR = new ModelRenderer(this, "Knee Guard Cap Right");
		KneeGuardCapR.setTextureOffset(16, 36);
		KneeGuardCapR.setRotationPoint(0.0F, 0.0F, 0.0F);
		KneeGuardCapR.addBox(-1.5F, 2.4F, -3.8F, 3, 2, 1, 0.2F);
		setRotateAngle(KneeGuardCapR, 0.17453292519943295F, 0.0F, 0.0F);
		bipedRightLeg.addChild(KneeGuardCapR);

		KneeGuardCapL = new ModelRenderer(this, "Knee Guard Cap Left");
		KneeGuardCapL.setTextureOffset(16, 36);
		KneeGuardCapL.mirror = true;
		KneeGuardCapL.setRotationPoint(0.0F, 0.0F, 0.0F);
		KneeGuardCapL.addBox(-1.5F, 2.4F, -3.8F, 3, 2, 1, 0.2F);
		setRotateAngle(KneeGuardCapL, 0.17453292519943295F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(KneeGuardCapL);

		BootTipR = new ModelRenderer(this, "Boot Tip Right");
		BootTipR.setTextureOffset(22, 32);
		BootTipR.setRotationPoint(0.0F, 0.0F, 0.0F);
		BootTipR.addBox(-1.4F, 10.0F, -2.5F, 3, 2, 2, -0.1F);
		setRotateAngle(BootTipR, -0.3490658503988659F, 0.0F, 0.0F);
		bipedRightLeg.addChild(BootTipR);

		BootCapR = new ModelRenderer(this, "Boot Cap Right");
		BootCapR.setTextureOffset(12, 32);
		BootCapR.setRotationPoint(0.0F, 0.0F, 0.0F);
		BootCapR.addBox(-1.5F, 10.0F, -2.5F, 3, 2, 2, 0.3F);
		setRotateAngle(BootCapR, -0.17453292519943295F, 0.0F, 0.0F);
		bipedRightLeg.addChild(BootCapR);

		BootTipL = new ModelRenderer(this, "Boot Tip Left");
		BootTipL.setTextureOffset(22, 32);
		BootTipL.mirror = true;
		BootTipL.setRotationPoint(0.0F, 0.0F, 0.0F);
		BootTipL.addBox(-1.5F, 10.0F, -2.6F, 3, 2, 2, -0.1F);
		setRotateAngle(BootTipL, -0.3490658503988659F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(BootTipL);

		BootCapL = new ModelRenderer(this, "Boot Cap Left");
		BootCapL.setTextureOffset(12, 32);
		BootCapL.mirror = true;
		BootCapL.setRotationPoint(0.0F, 0.0F, 0.0F);
		BootCapL.addBox(-1.5F, 10.0F, -2.5F, 3, 2, 2, 0.3F);
		setRotateAngle(BootCapL, -0.17453292519943295F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(BootCapL);

		BootCapL.isHidden = true;
		BootCapR.isHidden = true;
		BootTipL.isHidden = true;
		BootTipR.isHidden = true;
		FlairBackR.isHidden = true;
		BackFlairL.isHidden = true;
		FlairL.isHidden = true;
		FlairR.isHidden = true;

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
