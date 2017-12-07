//package lance5057.tDefense.armor.renderers.light;
//
//import lance5057.tDefense.armor.renderers.ArmorRenderer;
//import net.minecraft.client.model.ModelRenderer;
//
///**
// * ModelBiped - Either Mojang or a mod author
// * Created using Tabula 4.1.1
// */
//public class ModelTinkersCoif extends ArmorRenderer
//{
//	public ModelRenderer	Coif;
//	public ModelRenderer	WingR;
//	public ModelRenderer	Mask;
//	public ModelRenderer	Overlay;
//	public ModelRenderer	WingL;
//	public ModelRenderer	Mohawk;
//	public ModelRenderer	MohawkR;
//	public ModelRenderer	MohawkL;
//
//	public ModelTinkersCoif()
//	{
//		super(0.1f, 0, 128, 64);
//
//		textureWidth = 128;
//		textureHeight = 64;
//
//		Overlay = new ModelRenderer(this, "Overlay");
//		Overlay.setTextureOffset(32, 32);
//		Overlay.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Overlay.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.7F);
//		bipedHead.addChild(Overlay);
//
//		WingL = new ModelRenderer(this, "WingL");
//		WingL.setTextureOffset(64, 0);
//		WingL.setRotationPoint(-0.7F, 0.0F, 0.0F);
//		WingL.addBox(2.3F, -13.5F, -6.6F, 8, 18, 0, 0.0F);
//		setRotateAngle(WingL, 0.0F, -0.5235987755982988F, 0.0F);
//		bipedHead.addChild(WingL);
//
//		MohawkR = new ModelRenderer(this, "MohawkR");
//		MohawkR.setTextureOffset(80, -14);
//		MohawkR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		MohawkR.addBox(-3.0F, -14.0F, -3.6F, 0, 18, 14, 0.0F);
//		setRotateAngle(MohawkR, 0.0F, -0.4363323129985824F, 0.0F);
//		bipedHead.addChild(MohawkR);
//
//		Mohawk = new ModelRenderer(this, "Mohawk");
//		Mohawk.setTextureOffset(64, 4);
//		Mohawk.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Mohawk.addBox(0.0F, -14.0F, -4.6F, 0, 18, 14, 0.0F);
//		bipedHead.addChild(Mohawk);
//
//		Mask = new ModelRenderer(this, "Mask");
//		Mask.setTextureOffset(0, 43);
//		Mask.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Mask.addBox(-4.5F, -8.0F, -5.0F, 9, 10, 4, 0.11F);
//		bipedHead.addChild(Mask);
//
//		WingR = new ModelRenderer(this, "WingR");
//		WingR.setTextureOffset(64, 0);
//		WingR.mirror = true;
//		WingR.setRotationPoint(-0.5F, 0.0F, 0.0F);
//		WingR.addBox(-9.2F, -13.5F, -6.0F, 8, 18, 0, 0.0F);
//		setRotateAngle(WingR, 0.0F, 0.5235987755982988F, 0.0F);
//		bipedHead.addChild(WingR);
//
//		MohawkL = new ModelRenderer(this, "MohawkL");
//		MohawkL.setTextureOffset(80, -14);
//		MohawkL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		MohawkL.addBox(3.0F, -14.0F, -3.6F, 0, 18, 14, 0.0F);
//		setRotateAngle(MohawkL, 0.0F, 0.4363323129985824F, 0.0F);
//		bipedHead.addChild(MohawkL);
//
//		Coif = new ModelRenderer(this, "Coif");
//		Coif.setTextureOffset(0, 32);
//		Coif.setRotationPoint(0.0F, 0.0F, 0.0F);
//		Coif.addBox(-4.0F, 1.0F, -4.0F, 8, 3, 8, 0.6F);
//		bipedHead.addChild(Coif);
//
//		Mask.isHidden = true;
//		Mohawk.isHidden = true;
//		MohawkL.isHidden = true;
//		MohawkR.isHidden = true;
//		WingL.isHidden = true;
//		WingR.isHidden = true;
//
//		init();
//	}
//
//	/**
//	 * This is a helper function from Tabula to set the rotation of model parts
//	 */
//	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
//	{
//		modelRenderer.rotateAngleX = x;
//		modelRenderer.rotateAngleY = y;
//		modelRenderer.rotateAngleZ = z;
//	}
//}
