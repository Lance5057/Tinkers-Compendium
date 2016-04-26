package lance5057.tDefense.armor.renderers.heavy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * TinkerHelm - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersHelm extends ArmorRenderer
{
	public ModelRenderer	Visor;
	public ModelRenderer	Helm;
	public ModelRenderer	Trim;

	public ModelTinkersHelm()
	{
		super(1.5f, 0, 64, 64);

		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Helm = new ModelRenderer(this, 0, 47);
		this.Helm.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Helm.addBox(-4.0F, -8.0F, -4.0F, 8, 9, 8, 0.5F);
		this.bipedHead.addChild(this.Helm);

		this.Visor = new ModelRenderer(this, 0, 32);
		this.Visor.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Visor.addBox(-4.5F, -6.5F, -4.7F, 9, 5, 8, 0.1F);
		this.bipedHead.addChild(this.Visor);

		this.Trim = new ModelRenderer(this, 44, 47);
		this.Trim.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Trim.addBox(-1.0F, -8.3F, -4.0F, 2, 9, 8, 0.7F);
		this.bipedHead.addChild(this.Trim);

		this.bipedBody.isHidden = true;
		this.bipedCloak.isHidden = true;
		this.bipedLeftArm.isHidden = true;
		this.bipedLeftLeg.isHidden = true;
		this.bipedRightArm.isHidden = true;
		this.bipedRightLeg.isHidden = true;
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
