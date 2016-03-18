package lance5057.tDefense.armor.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * HornedBand - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelMask extends ModelBiped
{
	public ModelRenderer	Plate;
	public ModelRenderer	Band;
	public ModelRenderer	HornTipR;
	public ModelRenderer	HornTipL;
	public ModelRenderer	HornBaseR;
	public ModelRenderer	HornBaseL;

	String					Color[];
	int						rgbColors[];

	public ModelMask(String color[] /*3*/)
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.HornBaseR = new ModelRenderer(this, 0, 35);
		this.HornBaseR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HornBaseR.addBox(-3.5F, -6.1F, -7.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(HornBaseR, -0.17453292519943295F, 0.0F, 0.0F);
		this.HornTipL = new ModelRenderer(this, 0, 39);
		this.HornTipL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HornTipL.addBox(2.0F, -0.5F, -10.8F, 1, 1, 2, 0.1F);
		this.setRotateAngle(HornTipL, -0.7853981633974483F, 0.0F, 0.0F);
		this.HornTipR = new ModelRenderer(this, 0, 39);
		this.HornTipR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HornTipR.addBox(-3.0F, -0.5F, -10.8F, 1, 1, 2, 0.1F);
		this.setRotateAngle(HornTipR, -0.7853981633974483F, 0.0F, 0.0F);
		this.Plate = new ModelRenderer(this, 0, 32);
		this.Plate.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Plate.addBox(-4.0F, -7.0F, -5.0F, 8, 2, 1, 0.0F);
		this.Band = new ModelRenderer(this, 0, 39);
		this.Band.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Band.addBox(-4.0F, -6.5F, -4.0F, 8, 1, 8, 0.1F);
		this.HornBaseL = new ModelRenderer(this, 0, 35);
		this.HornBaseL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HornBaseL.addBox(1.5F, -6.1F, -7.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(HornBaseL, -0.17453292519943295F, 0.0F, 0.0F);
		this.Plate.addChild(this.HornBaseR);
		this.Plate.addChild(this.HornBaseL);

		this.bipedHead.addChild(this.Plate);
		this.bipedHead.addChild(this.HornTipL);
		this.bipedHead.addChild(this.HornTipR);
		this.bipedHead.addChild(this.Band);

		Color = color;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
