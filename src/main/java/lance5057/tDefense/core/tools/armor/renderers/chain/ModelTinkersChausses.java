package lance5057.tDefense.core.tools.armor.renderers.chain;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * ModelModelTinkersChausses.tcn - TechneToTabulaImporter Created using Tabula
 * 7.0.0
 */
public class ModelTinkersChausses extends ArmorRenderer {
	public ModelRenderer Front;
	public ModelRenderer HipGuardL;
	public ModelRenderer HipGuardR;
	public ModelRenderer Back;
	public ModelRenderer HipGuardL_1;
	public ModelRenderer HipGuardR_1;
	public ModelRenderer Belt;
	public ModelRenderer BeltR;
	public ModelRenderer BeltL;
	public ModelRenderer LeftLeg;
	public ModelRenderer RightLeg;

	public ModelTinkersChausses(ItemStack stack) {
		super(0.25f, 0, 48, 48, stack);

		this.textureWidth = 48;
		this.textureHeight = 48;

		// Right Leg

		this.RightLeg = new ModelRenderer(this, 18, 8);
		this.RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
		this.bipedRightLeg = this.RightLeg;

		this.HipGuardR = new ModelRenderer(this, 0, 32);
		this.HipGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HipGuardR.addBox(-2.5F, 0.0F, -2.6F, 4, 6, 5, 0.1F);
		this.setRotateAngle(HipGuardR, 0.0F, -0.0F, 0.17453292519943295F);
		this.RightLeg.addChild(HipGuardR);

		this.HipGuardR_1 = new ModelRenderer(this, 0, 8);
		this.HipGuardR_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HipGuardR_1.addBox(-2.5F, 0.0F, -2.6F, 4, 10, 5, 0.0F);
		this.setRotateAngle(HipGuardR_1, 0.0F, -0.0F, 0.08726646259971647F);
		this.RightLeg.addChild(HipGuardR_1);

		// Left Leg

		this.LeftLeg = new ModelRenderer(this, 18, 8);
		this.LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
		this.bipedLeftLeg = this.LeftLeg;

		this.HipGuardL_1 = new ModelRenderer(this, 0, 8);
		this.HipGuardL_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HipGuardL_1.addBox(-1.5F, 0.0F, -2.6F, 4, 10, 5, 0.0F);
		this.setRotateAngle(HipGuardL_1, 0.0F, -0.0F, -0.08726646259971647F);
		this.LeftLeg.addChild(HipGuardL_1);

		this.HipGuardL = new ModelRenderer(this, 0, 32);
		this.HipGuardL.mirror = true;
		this.HipGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HipGuardL.addBox(-1.5F, 0.0F, -2.6F, 4, 6, 5, 0.1F);
		this.setRotateAngle(HipGuardL, 0.0F, -0.0F, -0.17453292519943295F);
		this.LeftLeg.addChild(HipGuardL);

		// Body

		this.Belt = new ModelRenderer(this, 0, 24);
		this.Belt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Belt.addBox(-5.0F, 10.5F, -3.0F, 10, 2, 6, 0.0F);
		this.bipedBody = this.Belt;

		this.BeltR = new ModelRenderer(this, 10, 0);
		this.BeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BeltR.addBox(-12.2F, 10.5F, -3.0F, 12, 2, 6, 0.01F);
		this.setRotateAngle(BeltR, 0.0F, -0.0F, -0.4363323129985824F);
		this.Belt.addChild(BeltR);

		this.BeltL = new ModelRenderer(this, 10, 0);
		this.BeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BeltL.addBox(0.2F, 10.5F, -3.0F, 12, 2, 6, 0.02F);
		this.setRotateAngle(BeltL, 0.0F, -0.0F, 0.4363323129985824F);
		this.Belt.addChild(BeltL);

		this.Front = new ModelRenderer(this, 0, 0);
		this.Front.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.Front.addBox(-2.0F, 0F, -2.7F, 4, 7, 1, 0.0F);
		this.Belt.addChild(Front);

		this.Back = new ModelRenderer(this, 0, 0);
		this.Back.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.Back.addBox(-2.0F, 0F, 1.9F, 4, 7, 1, 0.0F);
		this.Belt.addChild(Back);

	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {

		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

		Front.rotateAngleX = Math.min(this.LeftLeg.rotateAngleX, this.RightLeg.rotateAngleX);
		Back.rotateAngleX = Math.max(this.LeftLeg.rotateAngleX, this.RightLeg.rotateAngleX);
	}
}
