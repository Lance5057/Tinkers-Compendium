package lance5057.tDefense.armor.renderers.heavy;

import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;

/**
 * TinkerHelm - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersHelm extends ArmorRenderer
{
	public ModelRenderer	Visor;
	public ModelRenderer	Helm2;
	public ModelRenderer	WingR;
	public ModelRenderer	WingL;
	public ModelRenderer	Helm;
	public ModelRenderer	Trim;
	public ModelRenderer	HornR;
	public ModelRenderer	HornL;
	public ModelRenderer	HornTipR;
	public ModelRenderer	HornTipL;
	public ModelRenderer	FeatherRod;
	public ModelRenderer	Feathers;
	public ModelRenderer	FeatherBase;
	public ModelRenderer	HornR_1;
	public ModelRenderer	HornL_1;
	public ModelRenderer	HornTipR_1;
	public ModelRenderer	HornTipL_1;
	public ModelRenderer	HornR_2;
	public ModelRenderer	HornL_2;
	public ModelRenderer	HornTipR_2;
	public ModelRenderer	HornTipL_2;
	public ModelRenderer	SpikeBase;
	public ModelRenderer	Spike2;
	public ModelRenderer	Spike1;

	public ModelTinkersHelm()
	{
		super(0.1f, 0, 128, 64);

		textureWidth = 128;
		textureHeight = 64;

		HornR = new ModelRenderer(this, "Horn Right");
		HornR.setTextureOffset(26, 32);
		HornR.setRotationPoint(0.0F, -2.0F, 0.0F);
		HornR.addBox(-1.0F, -10.0F, -1.0F, 2, 5, 2, 0.25F);
		setRotateAngle(HornR, 0.0F, 0.0F, 0.7853981633974483F);
		bipedHead.addChild(HornR);

		HornTipR = new ModelRenderer(this, "Horn Tip Right");
		HornTipR.setTextureOffset(26, 32);
		HornTipR.setRotationPoint(0.0F, -10.0F, 0.0F);
		HornTipR.addBox(-0.8F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		setRotateAngle(HornTipR, 0.0F, 0.0F, 2.007128639793479F);

		HornR_1 = new ModelRenderer(this, "Horn Right 2");
		HornR_1.setTextureOffset(26, 32);
		HornR_1.setRotationPoint(2.25F, -6.0F, 2.0F);
		HornR_1.addBox(-1.0F, -10.0F, -1.0F, 2, 5, 2, 0.25F);
		setRotateAngle(HornR_1, 1.3962634015954636F, 0.2617993877991494F, 1.5707963267948966F);
		bipedHead.addChild(HornR_1);

		HornTipR_1 = new ModelRenderer(this, "Horn Tip Right 2");
		HornTipR_1.setTextureOffset(26, 32);
		HornTipR_1.setRotationPoint(0.0F, -10.0F, 0.0F);
		HornTipR_1.addBox(-0.8F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		setRotateAngle(HornTipR_1, 0.0F, 0.0F, 2.007128639793479F);

		HornR_2 = new ModelRenderer(this, "Horn Right 3");
		HornR_2.setTextureOffset(26, 32);
		HornR_2.setRotationPoint(1.75F, -3.0F, 4.0F);
		HornR_2.addBox(-1.0F, -10.0F, -1.0F, 2, 5, 2, 0.25F);
		setRotateAngle(HornR_2, 1.3962634015954636F, -0.2617993877991494F, 1.5707963267948966F);
		bipedHead.addChild(HornR_2);

		HornTipR_2 = new ModelRenderer(this, "Horn Tip Right 3");
		HornTipR_2.setTextureOffset(26, 32);
		HornTipR_2.setRotationPoint(0.0F, -10.0F, 0.0F);
		HornTipR_2.addBox(-0.8F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		setRotateAngle(HornTipR_2, 0.0F, 0.0F, 2.007128639793479F);

		HornL = new ModelRenderer(this, "Horn Left");
		HornL.setTextureOffset(26, 32);
		HornL.setRotationPoint(0.0F, -2.0F, 0.0F);
		HornL.addBox(-1.0F, -10.0F, -1.0F, 2, 5, 2, 0.25F);
		setRotateAngle(HornL, 0.0F, 0.0F, -0.7853981633974483F);
		bipedHead.addChild(HornL);

		HornTipL = new ModelRenderer(this, "Horn Tip Left");
		HornTipL.setTextureOffset(26, 32);
		HornTipL.setRotationPoint(0.0F, -10.0F, 0.0F);
		HornTipL.addBox(-1.2F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		setRotateAngle(HornTipL, 0.0F, 0.0F, -2.007128639793479F);

		HornL_1 = new ModelRenderer(this, "Horn Left 2");
		HornL_1.setTextureOffset(26, 32);
		HornL_1.setRotationPoint(-2.25F, -6.0F, 2.0F);
		HornL_1.addBox(-1.0F, -10.0F, -1.0F, 2, 5, 2, 0.25F);
		setRotateAngle(HornL_1, 1.3962634015954636F, -0.2617993877991494F, -1.5707963267948966F);
		bipedHead.addChild(HornL_1);

		HornTipL_1 = new ModelRenderer(this, "Horn Tip Left 2");
		HornTipL_1.setTextureOffset(26, 32);
		HornTipL_1.setRotationPoint(0.0F, -10.0F, 0.0F);
		HornTipL_1.addBox(-1.2F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		setRotateAngle(HornTipL_1, 0.0F, 0.0F, -2.007128639793479F);

		HornL_2 = new ModelRenderer(this, "Horn Left 3");
		HornL_2.setTextureOffset(26, 32);
		HornL_2.setRotationPoint(-1.75F, -3.0F, 4.0F);
		HornL_2.addBox(-1.0F, -10.0F, -1.0F, 2, 5, 2, 0.25F);
		setRotateAngle(HornL_2, 1.3962634015954636F, 0.2617993877991494F, -1.5707963267948966F);
		bipedHead.addChild(HornL_2);

		HornTipL_2 = new ModelRenderer(this, "Horn Tip Left 3");
		HornTipL_2.setTextureOffset(26, 32);
		HornTipL_2.setRotationPoint(0.0F, -10.0F, 0.0F);
		HornTipL_2.addBox(-1.2F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		setRotateAngle(HornTipL_2, 0.0F, 0.0F, -2.007128639793479F);

		FeatherBase = new ModelRenderer(this, "Feather Base");
		FeatherBase.setTextureOffset(64, 13);
		FeatherBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		FeatherBase.addBox(-2.0F, -10.0F, -5.3F, 4, 1, 9, 0.0F);
		setRotateAngle(FeatherBase, -0.08726646259971647F, 0.0F, 0.0F);
		bipedHead.addChild(FeatherBase);

		WingL = new ModelRenderer(this, "Wing Left");
		WingL.setTextureOffset(0, 44);
		WingL.setRotationPoint(0.0F, 0.0F, 0.0F);
		WingL.addBox(5.7F, -11.0F, -3.5F, 0, 12, 8, 0.0F);
		setRotateAngle(WingL, 0.0F, 0.2617993877991494F, 0.0F);
		bipedHead.addChild(WingL);

		Trim = new ModelRenderer(this, "Trim");
		Trim.setTextureOffset(64, 23);
		Trim.setRotationPoint(0.0F, 0.0F, 0.0F);
		Trim.addBox(-1.0F, -8.3F, -4.0F, 2, 9, 8, 0.7F);
		bipedHead.addChild(Trim);

		Visor = new ModelRenderer(this, "Visor");
		Visor.setTextureOffset(0, 32);
		Visor.setRotationPoint(0.0F, 0.0F, 0.0F);
		Visor.addBox(-4.5F, -9.5F, -4.7F, 9, 12, 8, 0.1F);
		bipedHead.addChild(Visor);

		Feathers = new ModelRenderer(this, "Feathers");
		Feathers.setTextureOffset(64, 0);
		Feathers.setRotationPoint(0.0F, 0.0F, 0.0F);
		Feathers.addBox(-2.0F, -12.7F, -6.1F, 4, 4, 9, -0.3F);
		setRotateAngle(Feathers, -0.17453292519943295F, 0.0F, 0.0F);
		bipedHead.addChild(Feathers);

		FeatherRod = new ModelRenderer(this, "Feather Rod");
		FeatherRod.setTextureOffset(0, 32);
		FeatherRod.setRotationPoint(0.0F, 0.0F, 0.0F);
		FeatherRod.addBox(-1.0F, -9.3F, -1.2F, 2, 1, 2, 0.2F);
		bipedHead.addChild(FeatherRod);

		Helm2 = new ModelRenderer(this, "Heavy Visor");
		Helm2.setTextureOffset(34, 32);
		Helm2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Helm2.addBox(-4.0F, -9.0F, -4.0F, 8, 10, 8, 0.6F);
		bipedHead.addChild(Helm2);

		Spike1 = new ModelRenderer(this, "Spike");
		Spike1.setTextureOffset(16, 52);
		Spike1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Spike1.addBox(-2.5F, -14.0F, 0.0F, 5, 5, 0, 0.0F);
		bipedHead.addChild(Spike1);

		SpikeBase = new ModelRenderer(this, "Spike Base");
		SpikeBase.setTextureOffset(66, 40);
		SpikeBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		SpikeBase.addBox(-2.0F, -8.6F, -2.0F, 4, 1, 4, 0.5F);
		bipedHead.addChild(SpikeBase);

		Spike2 = new ModelRenderer(this, "Spike");
		Spike2.setTextureOffset(16, 47);
		Spike2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Spike2.addBox(0.0F, -14.0F, -2.5F, 0, 5, 5, 0.0F);
		bipedHead.addChild(Spike2);

		Helm = new ModelRenderer(this, "Helm");
		Helm.setTextureOffset(64, 47);
		Helm.setRotationPoint(0.0F, 0.0F, 0.0F);
		Helm.addBox(-4.0F, -8.0F, -4.0F, 8, 9, 8, 0.5F);
		bipedHead.addChild(Helm);

		WingR = new ModelRenderer(this, "Wing Right");
		WingR.setTextureOffset(0, 44);
		WingR.setRotationPoint(0.0F, 0.0F, 0.0F);
		WingR.addBox(-5.7F, -11.0F, -3.5F, 0, 12, 8, 0.0F);
		setRotateAngle(WingR, 0.0F, -0.2617993877991494F, 0.0F);
		bipedHead.addChild(WingR);

		HornR.addChild(HornTipR);
		HornL.addChild(HornTipL);

		HornL_1.addChild(HornTipL_1);
		HornR_1.addChild(HornTipR_1);

		HornL_2.addChild(HornTipL_2);
		HornR_2.addChild(HornTipR_2);

		HornL.isHidden = true;
		HornR.isHidden = true;
		HornL_1.isHidden = true;
		HornL_2.isHidden = true;
		HornR_1.isHidden = true;
		HornR_2.isHidden = true;
		FeatherBase.isHidden = true;
		FeatherRod.isHidden = true;
		Feathers.isHidden = true;
		Spike1.isHidden = true;
		Spike2.isHidden = true;
		SpikeBase.isHidden = true;
		WingL.isHidden = true;
		WingR.isHidden = true;
		Helm2.isHidden = true;

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
