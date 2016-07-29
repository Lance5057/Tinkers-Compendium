package lance5057.tDefense.armor.renderers.cloth;

import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;

/**
 * ModelTinkersShoes - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersShoes extends ArmorRenderer
{
	public ModelRenderer	FootL;
	public ModelRenderer	FootR;
	public ModelRenderer	OverLegL;
	public ModelRenderer	OverLegR;
	public ModelRenderer	ShoeL;
	public ModelRenderer	ShoeR;

	public ModelTinkersShoes()
	{
		super(0.1f, 0, 64, 64);

		textureWidth = 64;
		textureHeight = 64;

		FootL = new ModelRenderer(this, "Foot Left");
		FootL.setTextureOffset(16, 41);
		FootL.setRotationPoint(0F, 0F, 0F);
		FootL.addBox(-2F, 10.1F, -3.0F, 4, 2, 1, 0.2F);
		bipedLeftLeg.addChild(FootL);

		FootR = new ModelRenderer(this, "Foot Right");
		FootR.setTextureOffset(16, 41);
		FootR.setRotationPoint(0F, 0F, 0F);
		FootR.addBox(-2F, 10.1F, -3.0F, 4, 2, 1, 0.2F);
		bipedRightLeg.addChild(FootR);

		OverLegL = new ModelRenderer(this, "Over Leg Left");
		OverLegL.setTextureOffset(0, 32);
		OverLegL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
		OverLegL.setRotationPoint(0F, 0F, 0F);
		bipedLeftLeg.addChild(OverLegL);

		OverLegR = new ModelRenderer(this, "Over Leg Right");
		OverLegR.setTextureOffset(0, 32);
		OverLegR.mirror = true;
		OverLegR.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
		OverLegR.setRotationPoint(0F, 0F, 0F);
		bipedRightLeg.addChild(OverLegR);

		ShoeL = new ModelRenderer(this, "Shoe Left");
		ShoeL.setTextureOffset(16, 32);
		ShoeL.addBox(-2.0F, 7.0F, -2.0F, 4, 5, 4, 0.21F);
		ShoeL.setRotationPoint(0F, 0F, 0F);
		bipedLeftLeg.addChild(ShoeL);

		ShoeR = new ModelRenderer(this, "Shoe Right");
		ShoeR.setTextureOffset(16, 32);
		ShoeR.mirror = true;
		ShoeR.addBox(-2.0F, 7.0F, -2.0F, 4, 5, 4, 0.21F);
		ShoeR.setRotationPoint(0F, 0F, 0F);
		bipedRightLeg.addChild(ShoeR);

		OverLegL.isHidden = true;
		OverLegR.isHidden = true;

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
