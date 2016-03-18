package lance5057.tDefense.finishingAnvil.blocks.finishingAnvil;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Armor Anvil - lance5057
 * Created using Tabula 4.1.1
 */
public class ModelFinishingAnvil extends ModelBase
{
	public ModelRenderer	Log;
	public ModelRenderer	HammerHead;
	public ModelRenderer	HammerHandle;
	public ModelRenderer	AnvilBase;
	public ModelRenderer	AnvilStem;
	public ModelRenderer	AnvilTop;

	public ModelFinishingAnvil()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.AnvilTop = new ModelRenderer(this, 0, 22);
		this.AnvilTop.setRotationPoint(-4.0F, 6.0F, -6.0F);
		this.AnvilTop.addBox(0.0F, 0.0F, 0.0F, 8, 6, 12, 0.0F);
		this.HammerHead = new ModelRenderer(this, 15, 21);
		this.HammerHead.setRotationPoint(-1.3F, 4.0F, 0.0F);
		this.HammerHead.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
		this.setRotateAngle(HammerHead, 0.091106186954104F, -0.5462880558742251F, 0.0F);
		this.AnvilStem = new ModelRenderer(this, 10, 32);
		this.AnvilStem.setRotationPoint(-2.0F, 12.0F, -3.0F);
		this.AnvilStem.addBox(0.0F, 0.0F, 0.0F, 4, 2, 6, 0.0F);
		this.HammerHandle = new ModelRenderer(this, 17, 47);
		this.HammerHandle.setRotationPoint(1.0F, 0.5F, -6.0F);
		this.HammerHandle.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
		this.AnvilBase = new ModelRenderer(this, 2, 28);
		this.AnvilBase.setRotationPoint(-4.0F, 14.0F, -5.0F);
		this.AnvilBase.addBox(0.0F, 0.0F, 0.0F, 8, 2, 10, 0.0F);
		this.Log = new ModelRenderer(this, 0, 40);
		this.Log.setRotationPoint(-8.0F, 16.0F, -8.0F);
		this.Log.addBox(0.0F, 0.0F, 0.0F, 16, 8, 16, 0.0F);
		this.HammerHead.addChild(this.HammerHandle);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.AnvilTop.render(f5);
		this.HammerHead.render(f5);
		this.AnvilStem.render(f5);
		this.AnvilBase.render(f5);
		this.Log.render(f5);
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
