//package lance5057.tDefense.armor.renderers;
//
//import net.minecraft.client.model.ModelRenderer;
//
///**
// * ModelTinkersGauntlet - Either Mojang or a mod author
// * Created using Tabula 4.1.1
// */
//public class ModelTinkersGauntlets extends ArmorRenderer
//{
//	public ModelRenderer	GloveR;
//	public ModelRenderer	VambraceR;
//	public ModelRenderer	RebraceR;
//	public ModelRenderer	BoltR;
//	public ModelRenderer	KnuckleR;
//	public ModelRenderer	SettingR;
//	public ModelRenderer	GemR;
//	public ModelRenderer	ArmSpikesR;
//	public ModelRenderer	ArmSpikesBackR;
//	public ModelRenderer	KnuckleSpikesL;
//	public ModelRenderer	KnuckleSpikesR;
//	public ModelRenderer	KnuckleSpikesMidR;
//	public ModelRenderer	GloveL;
//	public ModelRenderer	VambraceL;
//	public ModelRenderer	RebraceL;
//	public ModelRenderer	BoltL;
//	public ModelRenderer	ArmSpikesL;
//	public ModelRenderer	KnuckleSpikesBackR;
//	public ModelRenderer	KnuckleSpikesBackL;
//	public ModelRenderer	KnuckleSpikesMidL;
//	public ModelRenderer	KnuckleL;
//	public ModelRenderer	GemL;
//	public ModelRenderer	SettingL;
//	public ModelRenderer	ArmSpikesBackL;
//
//	public ModelTinkersGauntlets()
//	{
//		super(1.0f, 0, 64, 64);
//
//		textureWidth = 64;
//		textureHeight = 64;
//
//		KnuckleSpikesL = new ModelRenderer(this, "Knuckle Spikes Left");
//		KnuckleSpikesL.setTextureOffset(56, 40);
//		KnuckleSpikesL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		KnuckleSpikesL.addBox(3.0F, 6.0F, -0.5F, 4, 8, 0, 0.0F);
//		setRotateAngle(KnuckleSpikesL, 0.0F, 0.3490658503988659F, 0.0F);
//		bipedLeftArm.addChild(KnuckleSpikesL);
//
//		KnuckleSpikesBackL = new ModelRenderer(this, "Knuckle Spikes Back Left");
//		KnuckleSpikesBackL.setTextureOffset(56, 40);
//		KnuckleSpikesBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		KnuckleSpikesBackL.addBox(3.0F, 6.0F, 0.5F, 4, 8, 0, 0.0F);
//		setRotateAngle(KnuckleSpikesBackL, 0.0F, -0.3490658503988659F, 0.0F);
//		bipedLeftArm.addChild(KnuckleSpikesBackL);
//
//		KnuckleL = new ModelRenderer(this, "Knuckle Left");
//		KnuckleL.setTextureOffset(0, 41);
//		KnuckleL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		KnuckleL.addBox(0.1F, 6.8F, -2.0F, 3, 3, 4, 0.4F);
//		bipedLeftArm.addChild(KnuckleL);
//
//		ArmSpikesR = new ModelRenderer(this, "Arm Spikes Right");
//		ArmSpikesR.setTextureOffset(56, 32);
//		ArmSpikesR.mirror = true;
//		ArmSpikesR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ArmSpikesR.addBox(-7.5F, 1.0F, 0.5F, 4, 8, 0, 0.0F);
//		setRotateAngle(ArmSpikesR, 0.0F, -0.3490658503988659F, 0.0F);
//		bipedRightArm.addChild(ArmSpikesR);
//
//		RebraceL = new ModelRenderer(this, "Rebrace Left");
//		RebraceL.setTextureOffset(14, 40);
//		RebraceL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		RebraceL.addBox(-1.1F, 3.0F, -2.0F, 3, 5, 4, 0.2F);
//		bipedLeftArm.addChild(RebraceL);
//
//		BoltL = new ModelRenderer(this, "Bolt Left");
//		BoltL.setTextureOffset(16, 32);
//		BoltL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BoltL.addBox(-5.8F, 3.7F, -3.0F, 2, 2, 6, -0.3F);
//		setRotateAngle(BoltL, 0.0F, 0.0F, -0.7853981633974483F);
//		bipedLeftArm.addChild(BoltL);
//
//		KnuckleSpikesBackR = new ModelRenderer(this,
//				"Knuckle Spikes Back Right");
//		KnuckleSpikesBackR.setTextureOffset(56, 40);
//		KnuckleSpikesBackR.mirror = true;
//		KnuckleSpikesBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		KnuckleSpikesBackR.addBox(-7.0F, 6.0F, 0.5F, 4, 8, 0, 0.0F);
//		setRotateAngle(KnuckleSpikesBackR, 0.0F, 0.3490658503988659F, 0.0F);
//		bipedRightArm.addChild(KnuckleSpikesBackR);
//
//		GloveR = new ModelRenderer(this, "Glove Right");
//		GloveR.setTextureOffset(0, 32);
//		GloveR.mirror = true;
//		GloveR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		GloveR.addBox(-3.0F, 5.0F, -2.0F, 4, 5, 4, 0.1F);
//		bipedRightArm.addChild(GloveR);
//
//		BoltR = new ModelRenderer(this, "Bolt Right");
//		BoltR.setTextureOffset(16, 32);
//		BoltR.mirror = true;
//		BoltR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		BoltR.addBox(3.8F, 3.7F, -3.0F, 2, 2, 6, -0.3F);
//		setRotateAngle(BoltR, 0.0F, 0.0F, 0.7853981633974483F);
//		bipedRightArm.addChild(BoltR);
//
//		KnuckleR = new ModelRenderer(this, "Knuckle Right");
//		KnuckleR.setTextureOffset(0, 41);
//		KnuckleR.mirror = true;
//		KnuckleR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		KnuckleR.addBox(-2.9F, 6.8F, -2.0F, 3, 3, 4, 0.4F);
//		bipedRightArm.addChild(KnuckleR);
//
//		KnuckleSpikesR = new ModelRenderer(this, "Knuckle Spikes Right");
//		KnuckleSpikesR.setTextureOffset(56, 40);
//		KnuckleSpikesR.mirror = true;
//		KnuckleSpikesR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		KnuckleSpikesR.addBox(-7.0F, 6.0F, -0.5F, 4, 8, 0, 0.0F);
//		setRotateAngle(KnuckleSpikesR, 0.0F, -0.3490658503988659F, 0.0F);
//		bipedRightArm.addChild(KnuckleSpikesR);
//
//		KnuckleSpikesMidL = new ModelRenderer(this, "Knuckle Spikes Mid Left");
//		KnuckleSpikesMidL.setTextureOffset(54, 48);
//		KnuckleSpikesMidL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		KnuckleSpikesMidL.addBox(3.0F, 1.0F, 0.0F, 5, 13, 0, 0.0F);
//		bipedLeftArm.addChild(KnuckleSpikesMidL);
//
//		ArmSpikesBackL = new ModelRenderer(this, "Arm Spikes Back Left");
//		ArmSpikesBackL.setTextureOffset(56, 32);
//		ArmSpikesBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ArmSpikesBackL.addBox(3.5F, 1.0F, -0.5F, 4, 8, 0, 0.0F);
//		setRotateAngle(ArmSpikesBackL, 0.0F, -0.3490658503988659F, 0.0F);
//		bipedLeftArm.addChild(ArmSpikesBackL);
//
//		ArmSpikesBackR = new ModelRenderer(this, "Arm Spikes Back Right");
//		ArmSpikesBackR.setTextureOffset(56, 32);
//		ArmSpikesBackR.mirror = true;
//		ArmSpikesBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ArmSpikesBackR.addBox(-7.5F, 1.0F, -0.5F, 4, 8, 0, 0.0F);
//		setRotateAngle(ArmSpikesBackR, 0.0F, 0.3490658503988659F, 0.0F);
//		bipedRightArm.addChild(ArmSpikesBackR);
//
//		VambraceR = new ModelRenderer(this, "Vambrace Right");
//		VambraceR.setTextureOffset(0, 56);
//		VambraceR.mirror = true;
//		VambraceR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		VambraceR.addBox(-3.6F, 2.8F, -2.0F, 3, 4, 4, 0.3F);
//		setRotateAngle(VambraceR, 0.0F, 0.0F, -0.08726646259971647F);
//		bipedRightArm.addChild(VambraceR);
//
//		GemR = new ModelRenderer(this, "Gem Right");
//		GemR.setTextureOffset(0, 48);
//		GemR.mirror = true;
//		GemR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		GemR.addBox(-4.2F, 5.0F, -2.0F, 2, 4, 4, -0.3F);
//		bipedRightArm.addChild(GemR);
//
//		RebraceR = new ModelRenderer(this, "Rebrace Right");
//		RebraceR.setTextureOffset(14, 40);
//		RebraceR.mirror = true;
//		RebraceR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		RebraceR.addBox(-1.9F, 3.0F, -2.0F, 3, 5, 4, 0.2F);
//		bipedRightArm.addChild(RebraceR);
//
//		SettingR = new ModelRenderer(this, "Setting Right");
//		SettingR.setTextureOffset(12, 49);
//		SettingR.mirror = true;
//		SettingR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		SettingR.addBox(-3.7F, 5.0F, -2.0F, 1, 4, 4, 0.0F);
//		bipedRightArm.addChild(SettingR);
//
//		GloveL = new ModelRenderer(this, "Glove Left");
//		GloveL.setTextureOffset(0, 32);
//		GloveL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		GloveL.addBox(-1.0F, 5.0F, -2.0F, 4, 5, 4, 0.1F);
//		bipedLeftArm.addChild(GloveL);
//
//		GemL = new ModelRenderer(this, "Gem Left");
//		GemL.setTextureOffset(0, 48);
//		GemL.mirror = true;
//		GemL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		GemL.addBox(2.4F, 5.0F, -2.0F, 2, 4, 4, -0.3F);
//		bipedLeftArm.addChild(GemL);
//
//		VambraceL = new ModelRenderer(this, "Vambrace Left");
//		VambraceL.setTextureOffset(0, 56);
//		VambraceL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		VambraceL.addBox(0.8F, 2.8F, -2.0F, 3, 4, 4, 0.3F);
//		setRotateAngle(VambraceL, 0.0F, 0.0F, 0.08726646259971647F);
//		bipedLeftArm.addChild(VambraceL);
//
//		KnuckleSpikesMidR = new ModelRenderer(this, "Knuckle Spikes Mid Right");
//		KnuckleSpikesMidR.setTextureOffset(54, 48);
//		KnuckleSpikesMidR.mirror = true;
//		KnuckleSpikesMidR.setRotationPoint(0.0F, 0.0F, 0.0F);
//		KnuckleSpikesMidR.addBox(-8.0F, 1.0F, 0.0F, 5, 13, 0, 0.0F);
//		bipedRightArm.addChild(KnuckleSpikesMidR);
//
//		SettingL = new ModelRenderer(this, "Setting Left");
//		SettingL.setTextureOffset(12, 49);
//		SettingL.mirror = true;
//		SettingL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		SettingL.addBox(2.9F, 5.0F, -2.0F, 1, 4, 4, 0.0F);
//		bipedLeftArm.addChild(SettingL);
//
//		ArmSpikesL = new ModelRenderer(this, "Arm Spikes Left");
//		ArmSpikesL.setTextureOffset(56, 32);
//		ArmSpikesL.setRotationPoint(0.0F, 0.0F, 0.0F);
//		ArmSpikesL.addBox(3.5F, 1.0F, 0.5F, 4, 8, 0, 0.0F);
//		setRotateAngle(ArmSpikesL, 0.0F, 0.3490658503988659F, 0.0F);
//		bipedLeftArm.addChild(ArmSpikesL);
//
//		ArmSpikesBackL.isHidden = true;
//		ArmSpikesBackR.isHidden = true;
//		ArmSpikesL.isHidden = true;
//		ArmSpikesR.isHidden = true;
//		GemL.isHidden = true;
//		GemR.isHidden = true;
//		KnuckleSpikesBackL.isHidden = true;
//		KnuckleSpikesBackR.isHidden = true;
//		KnuckleSpikesL.isHidden = true;
//		KnuckleSpikesMidL.isHidden = true;
//		KnuckleSpikesMidR.isHidden = true;
//		KnuckleSpikesR.isHidden = true;
//		SettingL.isHidden = true;
//		SettingR.isHidden = true;
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
