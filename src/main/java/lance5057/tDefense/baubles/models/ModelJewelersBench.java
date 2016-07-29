package lance5057.tDefense.baubles.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * JewelersBench - lance5057
 * Created using Tabula 4.1.1
 */
public class ModelJewelersBench extends ModelBase
{
	public ModelRenderer	TableSide2;
	public ModelRenderer	SawBlock1;
	public ModelRenderer	SawBlock2;
	public ModelRenderer	SawBlock3;
	public ModelRenderer	SawBlockClamp;
	public ModelRenderer	Leg1;
	public ModelRenderer	Leg2;
	public ModelRenderer	Leg3;
	public ModelRenderer	Leg4;
	public ModelRenderer	TableTop;
	public ModelRenderer	TableBack;
	public ModelRenderer	TableSide1;
	public ModelRenderer	Drawer;
	public ModelRenderer	Handle;

	public ModelJewelersBench()
	{
		textureWidth = 64;
		textureHeight = 64;
		SawBlock1 = new ModelRenderer(this, 0, 0);
		SawBlock1.setRotationPoint(2.0F, 8.2F, -12.0F);
		SawBlock1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		Leg4 = new ModelRenderer(this, 0, 0);
		Leg4.setRotationPoint(6.0F, 10.0F, 6.0F);
		Leg4.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
		Drawer = new ModelRenderer(this, 0, 46);
		Drawer.setRotationPoint(-6.0F, 11.5F, -8.0F);
		Drawer.addBox(0.0F, 0.0F, 0.0F, 12, 2, 16, 0.0F);
		TableSide2 = new ModelRenderer(this, 0, 0);
		TableSide2.setRotationPoint(-8.0F, 7.0F, -7.0F);
		TableSide2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
		Leg2 = new ModelRenderer(this, 0, 0);
		Leg2.setRotationPoint(6.0F, 10.0F, -8.0F);
		Leg2.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
		TableSide1 = new ModelRenderer(this, 0, 0);
		TableSide1.setRotationPoint(7.0F, 7.0F, -7.0F);
		TableSide1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
		SawBlock3 = new ModelRenderer(this, 0, 0);
		SawBlock3.setRotationPoint(3.0F, 8.2F, -11.0F);
		SawBlock3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		Handle = new ModelRenderer(this, 55, 0);
		Handle.setRotationPoint(-2.0F, 12.0F, -9.0F);
		Handle.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		Leg1 = new ModelRenderer(this, 0, 0);
		Leg1.setRotationPoint(-8.0F, 10.0F, -8.0F);
		Leg1.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
		TableTop = new ModelRenderer(this, 0, 28);
		TableTop.setRotationPoint(-8.0F, 8.0F, -8.0F);
		TableTop.addBox(0.0F, 0.0F, 0.0F, 16, 2, 16, 0.0F);
		TableBack = new ModelRenderer(this, 0, 0);
		TableBack.setRotationPoint(-8.0F, 7.0F, 7.0F);
		TableBack.addBox(0.0F, 0.0F, 0.0F, 16, 1, 1, 0.0F);
		SawBlockClamp = new ModelRenderer(this, 54, 0);
		SawBlockClamp.setRotationPoint(1.5F, 8.0F, -9.0F);
		SawBlockClamp.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
		Leg3 = new ModelRenderer(this, 0, 0);
		Leg3.setRotationPoint(-8.0F, 10.0F, 6.0F);
		Leg3.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
		SawBlock2 = new ModelRenderer(this, 0, 0);
		SawBlock2.setRotationPoint(4.0F, 8.2F, -12.0F);
		SawBlock2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		SawBlock1.render(f5);
		Leg4.render(f5);
		Drawer.render(f5);
		TableSide2.render(f5);
		Leg2.render(f5);
		TableSide1.render(f5);
		SawBlock3.render(f5);
		Handle.render(f5);
		Leg1.render(f5);
		TableTop.render(f5);
		TableBack.render(f5);
		SawBlockClamp.render(f5);
		Leg3.render(f5);
		SawBlock2.render(f5);
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
