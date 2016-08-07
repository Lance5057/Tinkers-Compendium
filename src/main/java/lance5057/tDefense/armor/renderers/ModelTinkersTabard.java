package lance5057.tDefense.armor.renderers;

import lance5057.tDefense.armor.ArmorCore;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersTabard extends ArmorRenderer
{
	public ModelRenderer	Tabard;
	public ModelRenderer	TabardBottomF;
	public ModelRenderer	TabardBottomB;

	public ModelTinkersTabard()
	{
		super(0.5f, 0, 64, 64);

		textureWidth = 64;
		textureHeight = 64;

		Tabard = new ModelRenderer(this, 0, 32);
		Tabard.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tabard.addBox(-4.0F, 0.0F, -2.5F, 8, 12, 5, 0.1F);

		TabardBottomF = new ModelRenderer(this, 26, 32);
		TabardBottomF.setRotationPoint(0.0F, 12.0F, 0.0F);
		TabardBottomF.addBox(-4.0F, 0.2F, -2.5F, 8, 8, 1, 0.1F);
		TabardBottomB = new ModelRenderer(this, 26, 32);
		TabardBottomB.mirror = true;

		TabardBottomB.setRotationPoint(0.0F, 12.0F, 0.0F);
		TabardBottomB.addBox(-4.0F, 0.2F, 1.5F, 8, 8, 1, 0.1F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		GL11.glPushMatrix();

		for(int i = 0; i < 10; i++)
		{
			final String texture = ((ArmorCore) stack.getItem()).getTexture(i, stack);
			if(texture != "")
			{

				GL11.glPushMatrix();

				((ArmorCore) stack.getItem()).renderArmor(entity, f, f1, f2, f3, f4, f5, colors, stack, i);
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
