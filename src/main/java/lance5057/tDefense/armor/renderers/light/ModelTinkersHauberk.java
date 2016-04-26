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
public class ModelTinkersHauberk extends ArmorRenderer
{
	public ModelRenderer	Pauldron1;
	public ModelRenderer	Pauldron2;
	public ModelRenderer	Pauldron3;
	public ModelRenderer	ArmR;
	public ModelRenderer	Body;
	public ModelRenderer	Pauldron1_1;
	public ModelRenderer	Pauldron2_1;
	public ModelRenderer	Pauldron3_1;
	public ModelRenderer	ArmL;

	public ModelTinkersHauberk()
	{
		super(1.1f, 0, 64, 64);

		this.textureWidth = 64;
		this.textureHeight = 64;

		this.Pauldron2_1 = new ModelRenderer(this, 0, 32);
		this.Pauldron2_1.mirror = true;
		this.Pauldron2_1.setRotationPoint(0.0F, 0.0F, 0.01F);
		this.Pauldron2_1.addBox(-0.7F, -2.7F, -2.0F, 3, 3, 4, 0.1F);
		this.setRotateAngle(Pauldron2_1, 0.0F, 0.0F, 0.2617993877991494F);
		this.bipedLeftArm.addChild(this.Pauldron2_1);

		this.Body = new ModelRenderer(this, 16, 48);
		this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.01F);
		this.bipedBody.addChild(this.Body);

		this.Pauldron1_1 = new ModelRenderer(this, 30, 32);
		this.Pauldron1_1.mirror = true;
		this.Pauldron1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Pauldron1_1.addBox(0.5F, -1.9F, -2.5F, 3, 4, 5, 0.01F);
		this.setRotateAngle(Pauldron1_1, 0.0F, 0.0F, -0.2617993877991494F);
		this.bipedLeftArm.addChild(this.Pauldron1_1);

		this.Pauldron3 = new ModelRenderer(this, 16, 32);
		this.Pauldron3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Pauldron3.addBox(-1.2F, -1.5F, -2.5F, 2, 2, 5, 0.11F);
		this.setRotateAngle(Pauldron3, 0.0F, 0.0F, -0.2617993877991494F);
		this.bipedRightArm.addChild(this.Pauldron3);

		this.ArmL = new ModelRenderer(this, 0, 48);
		this.ArmL.mirror = true;
		this.ArmL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.ArmL.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.02F);
		this.bipedLeftArm.addChild(this.ArmL);

		this.Pauldron1 = new ModelRenderer(this, 30, 32);
		this.Pauldron1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Pauldron1.addBox(-3.5F, -1.9F, -2.5F, 3, 4, 5, 0.01F);
		this.setRotateAngle(Pauldron1, 0.0F, 0.0F, 0.2617993877991494F);
		this.bipedRightArm.addChild(this.Pauldron1);

		this.Pauldron3_1 = new ModelRenderer(this, 16, 32);
		this.Pauldron3_1.mirror = true;
		this.Pauldron3_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Pauldron3_1.addBox(-0.8F, -1.5F, -2.5F, 2, 2, 5, 0.11F);
		this.setRotateAngle(Pauldron3_1, 0.0F, 0.0F, 0.2617993877991494F);
		this.bipedLeftArm.addChild(this.Pauldron3_1);

		this.Pauldron2 = new ModelRenderer(this, 0, 32);
		this.Pauldron2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Pauldron2.addBox(-2.3F, -2.7F, -2.0F, 3, 3, 4, 0.11F);
		this.setRotateAngle(Pauldron2, 0.0F, 0.0F, -0.2617993877991494F);
		this.bipedRightArm.addChild(this.Pauldron2);

		this.ArmR = new ModelRenderer(this, 0, 48);
		this.ArmR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.ArmR.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.02F);
		this.bipedRightArm.addChild(this.ArmR);
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
