package lance5057.tDefense.armor.renderers.cloth;

import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;

/**
 * TinkersHood - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersHood extends ArmorRenderer
{
	public ModelRenderer	Flop;
	public ModelRenderer	Flop_1;
	public ModelRenderer	Flop_2;
	public ModelRenderer	ScarfNeck;
	public ModelRenderer	Band;
	public ModelRenderer	BandTilted;
	public ModelRenderer	Rim;
	public ModelRenderer	HatTop;
	public ModelRenderer	HatTopTall;
	public ModelRenderer	Tip;
	public ModelRenderer	Tip_1;
	public ModelRenderer	Tip_2;
	public ModelRenderer	ScarfExtra;
	public ModelRenderer	ScarfExtra_1;

	public ModelTinkersHood()
	{
		super(0.1f, 0, 128, 64);

		textureWidth = 128;
		textureHeight = 64;

		bipedHeadwear = new ModelRenderer(this, "Headwear");
		bipedHeadwear.setTextureOffset(32, 0);
		bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.1f + 0.5F);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F + 0, 0.0F);

		Flop = new ModelRenderer(this, "Flop");
		Flop.setTextureOffset(64, 0);
		Flop.setRotationPoint(0.0F, 0.0F, 0.0F);
		Flop.addBox(-3.0F, -7.6F, 1.0F, 6, 6, 3, 0.5F);
		setRotateAngle(Flop, -0.3490658503988659F, 0.0F, 0.0F);
		bipedHead.addChild(Flop);

		Flop_1 = new ModelRenderer(this, "Flop 1");
		Flop_1.setTextureOffset(82, 0);
		Flop_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Flop_1.addBox(-2.0F, -6.8F, -0.1F, 4, 4, 5, 0.5F);
		setRotateAngle(Flop_1, -0.6981317007977318F, 0.0F, 0.0F);
		bipedHead.addChild(Flop_1);

		Flop_2 = new ModelRenderer(this, "Flop 2");
		Flop_2.setTextureOffset(64, 25);
		Flop_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Flop_2.addBox(-1.0F, -6.6F, 2.0F, 2, 2, 4, 0.5F);
		setRotateAngle(Flop_2, -1.0471975511965976F, 0.0F, 0.0F);
		bipedHead.addChild(Flop_2);

		ScarfExtra = new ModelRenderer(this, "ScarfExtra");
		ScarfExtra.setTextureOffset(44, 32);
		ScarfExtra.setRotationPoint(0.0F, 0.0F, 0.0F);
		ScarfExtra.addBox(0.0F, 0.0F, 2.0F, 3, 7, 1, 0.0F);
		setRotateAngle(ScarfExtra, 0.0F, 0.0F, -0.17453292519943295F);
		bipedBody.addChild(ScarfExtra);

		ScarfExtra_1 = new ModelRenderer(this, "ScarfExtra 1");
		ScarfExtra_1.setTextureOffset(36, 32);
		ScarfExtra_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		ScarfExtra_1.addBox(-3.0F, 0.0F, 2.0F, 3, 11, 1, 0.0F);
		setRotateAngle(ScarfExtra_1, 0.0F, 0.0F, 0.17453292519943295F);
		bipedBody.addChild(ScarfExtra_1);

		ScarfNeck = new ModelRenderer(this, "ScarfNeck");
		ScarfNeck.setTextureOffset(0, 32);
		ScarfNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
		ScarfNeck.addBox(-4.5F, -2.0F, -4.5F, 9, 3, 9, 0.3F);
		bipedHead.addChild(ScarfNeck);

		HatTop = new ModelRenderer(this, "HatTop");
		HatTop.setTextureOffset(52, 33);
		HatTop.addBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.1f + 0.5F);
		HatTop.setRotationPoint(0.0F, 0.0F + 0, 0.0F);
		bipedHead.addChild(HatTop);

		HatTopTall = new ModelRenderer(this, "HatTopTall");
		HatTopTall.setTextureOffset(96, 4);
		HatTopTall.setRotationPoint(0.0F, 0.0F, 0.0F);
		HatTopTall.addBox(-4.0F, -14.0F, -4.0F, 8, 5, 8, 0.5F);
		bipedHead.addChild(HatTopTall);

		Rim = new ModelRenderer(this, "Rim");
		Rim.setTextureOffset(64, 20);
		Rim.setRotationPoint(0.0F, 0.0F, 0.0F);
		Rim.addBox(-6.0F, -5.5F, -6.0F, 12, 1, 12, 0.1F);
		bipedHead.addChild(Rim);

		BandTilted = new ModelRenderer(this, "BandTilted");
		BandTilted.setTextureOffset(64, 9);
		BandTilted.setRotationPoint(0.0F, 0.0F, 0.0F);
		BandTilted.addBox(-4.5F, -2.7F, -8.5F, 9, 2, 9, 0.0F);
		setRotateAngle(BandTilted, -1.2f, 0.0F, 0.0F);
		bipedHead.addChild(BandTilted);

		Band = new ModelRenderer(this, "Band");
		Band.setTextureOffset(64, 9);
		Band.setRotationPoint(0.0F, 0.0F, 0.0F);
		Band.addBox(-4.5F, -6.7F, -4.5F, 9, 2, 9, 0.2F);
		bipedHead.addChild(Band);

		Tip = new ModelRenderer(this, "Tip");
		Tip.setTextureOffset(0, 44);
		Tip.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tip.addBox(-3.0F, -10.8F, -5.0F, 6, 3, 6, 0.5F);
		setRotateAngle(Tip, -0.2617993877991494F, 0.0F, 0.0F);
		bipedHead.addChild(Tip);

		Tip_1 = new ModelRenderer(this, "Tip 1");
		Tip_1.setTextureOffset(0, 53);
		Tip_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tip_1.addBox(-2.0F, -12.9F, -6.7F, 4, 3, 4, 0.5F);
		setRotateAngle(Tip_1, -0.5235987755982988F, 0.0F, 0.0F);
		bipedHead.addChild(Tip_1);

		Tip_2 = new ModelRenderer(this, "Tip 2");
		Tip_2.setTextureOffset(18, 45);
		Tip_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tip_2.addBox(-1.0F, -14.6F, -8.8F, 2, 3, 2, 0.5F);
		setRotateAngle(Tip_2, -0.7853981633974483F, 0.0F, 0.0F);
		bipedHead.addChild(Tip_2);

		Rim.isHidden = true;
		Band.isHidden = true;
		HatTop.isHidden = true;
		HatTopTall.isHidden = true;
		BandTilted.isHidden = true;
		Tip.isHidden = true;
		Tip_1.isHidden = true;
		Tip_2.isHidden = true;

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
