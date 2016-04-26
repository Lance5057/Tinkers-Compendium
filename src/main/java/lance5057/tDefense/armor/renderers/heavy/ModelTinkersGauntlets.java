package lance5057.tDefense.armor.renderers.heavy;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * TinkersGauntlets - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersGauntlets extends ArmorRenderer
{
	public ModelRenderer	BracerL;
	public ModelRenderer	RivetL;
	public ModelRenderer	MittL;
	public ModelRenderer	BracerR;
	public ModelRenderer	RivetR;
	public ModelRenderer	MittR;

	public ModelTinkersGauntlets()
	{
		super(0.15f, 0, 64, 64);

		this.textureWidth = 64;
		this.textureHeight = 64;

		this.BracerR = new ModelRenderer(this, 0, 56);
		this.BracerR.mirror = true;
		this.BracerR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BracerR.addBox(-3.3F, 4.0F, -2.0F, 3, 4, 4, 0.2F);
		this.setRotateAngle(BracerR, 0.0F, 0.0F, -0.03490658503988659F);
		this.bipedRightArm.addChild(BracerR);

		this.RivetL = new ModelRenderer(this, 0, 47);
		this.RivetL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RivetL.addBox(0.0F, 7.0F, -3.0F, 2, 2, 6, -0.5F);
		this.bipedLeftArm.addChild(RivetL);

		this.BracerL = new ModelRenderer(this, 0, 56);
		this.BracerL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BracerL.addBox(0.3F, 4.0F, -2.0F, 3, 4, 4, 0.2F);
		this.setRotateAngle(BracerL, 0.0F, 0.0F, 0.03490658503988659F);
		this.bipedLeftArm.addChild(BracerL);

		this.MittL = new ModelRenderer(this, 0, 41);
		this.MittL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.MittL.addBox(1.4F, 7.9F, -2.0F, 2, 2, 4, 0.3F);
		this.setRotateAngle(MittL, 0.0F, 0.0F, 0.03490658503988659F);
		this.bipedLeftArm.addChild(MittL);

		this.RivetR = new ModelRenderer(this, 0, 47);
		this.RivetR.mirror = true;
		this.RivetR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RivetR.addBox(-2.0F, 7.0F, -3.0F, 2, 2, 6, -0.5F);
		this.bipedRightArm.addChild(RivetR);

		this.MittR = new ModelRenderer(this, 0, 41);
		this.MittR.mirror = true;
		this.MittR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.MittR.addBox(-3.4F, 7.9F, -2.0F, 2, 2, 4, 0.3F);
		this.setRotateAngle(MittR, 0.0F, 0.0F, -0.03490658503988659F);
		this.bipedRightArm.addChild(MittR);
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
