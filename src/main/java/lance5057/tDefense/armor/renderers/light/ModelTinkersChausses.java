package lance5057.tDefense.armor.renderers.light;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersChausses extends ArmorRenderer
{
	public ModelRenderer	LegL;
	public ModelRenderer	FrontL;
	public ModelRenderer	HipGuardL;
	public ModelRenderer	HipGuardR;
	public ModelRenderer	LegR;
	public ModelRenderer	BackL;
	public ModelRenderer	FrontR;
	public ModelRenderer	BackR;
	public ModelRenderer	Belt;

	public ModelTinkersChausses()
	{
		super(1.1f, 0, 64, 64);

		this.textureWidth = 64;
		this.textureHeight = 64;

		this.Belt = new ModelRenderer(this, 16, 54);
		this.Belt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Belt.addBox(-4.5F, 10.0F, -3F, 9, 2, 6, 0.1F);
		this.bipedBody.addChild(this.Belt);

		this.HipGuardR = new ModelRenderer(this, 10, 37);
		this.HipGuardR.setRotationPoint(0F, 0F, 0F);
		this.HipGuardR.addBox(-2.5F, 0.0F, -2.5F, 4, 6, 5, 0.01F);
		this.setRotateAngle(HipGuardR, 0.0F, 0.0F, 0.17453292519943295F);
		this.bipedRightLeg.addChild(this.HipGuardR);

		this.LegL = new ModelRenderer(this, 0, 48);
		this.LegL.setRotationPoint(0F, 0F, 0F);
		this.LegL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.01F);
		this.bipedLeftLeg.addChild(this.LegL);

		this.BackR = new ModelRenderer(this, 0, 40);
		this.BackR.setRotationPoint(0F, 0F, 0F);
		this.BackR.addBox(-0.1F, 0.0F, 1.7F, 4, 7, 1, 0.02F);
		this.bipedRightLeg.addChild(this.BackR);

		this.FrontL = new ModelRenderer(this, 0, 40);
		this.FrontL.setRotationPoint(0F, 0F, 0F);
		this.FrontL.addBox(-4.0F, 0.0F, -2.7F, 4, 7, 1, 0.01F);
		this.bipedLeftLeg.addChild(this.FrontL);

		this.LegR = new ModelRenderer(this, 0, 48);
		this.LegR.setRotationPoint(0F, 0F, 0F);
		this.LegR.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.01F);
		this.bipedRightLeg.addChild(this.LegR);

		this.BackL = new ModelRenderer(this, 0, 40);
		this.BackL.setRotationPoint(0F, 0F, 0F);
		this.BackL.addBox(-4.0F, 0.0F, 1.7F, 4, 7, 1, 0.01F);
		this.bipedLeftLeg.addChild(this.BackL);

		this.FrontR = new ModelRenderer(this, 0, 40);
		this.FrontR.setRotationPoint(0F, 0F, 0F);
		this.FrontR.addBox(-0.1F, 0.0F, -2.7F, 4, 7, 1, 0.02F);
		this.bipedRightLeg.addChild(this.FrontR);

		this.HipGuardL = new ModelRenderer(this, 10, 37);
		this.HipGuardL.mirror = true;
		this.HipGuardL.setRotationPoint(0F, 0F, 0F);
		this.HipGuardL.addBox(-1.5F, 0.0F, -2.5F, 4, 6, 5, 0.01F);
		this.setRotateAngle(HipGuardL, 0.0F, 0.0F, -0.17453292519943295F);
		this.bipedLeftLeg.addChild(this.HipGuardL);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		GL11.glPushMatrix();

		for(int i = 0; i < 10; i++)
		{
			String texture = ((ArmorCore) this.stack.getItem()).getTexture(i, stack);
			if(texture != "")
			{

				GL11.glPushMatrix();

				((ArmorCore) this.stack.getItem()).renderArmor(entity, f, f1, f2, f3, f4, f5, colors, stack, i);
				super.render(entity, f, f1, f2, f3, f4, f5);

				GL11.glPopMatrix();
			}
		}

		GL11.glPopMatrix();
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
