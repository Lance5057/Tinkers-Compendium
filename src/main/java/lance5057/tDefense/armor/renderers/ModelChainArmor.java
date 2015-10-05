package lance5057.tDefense.armor.renderers;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChainArmor extends ModelBiped
{
    public ModelRenderer Pauldron1R;
    public ModelRenderer Pauldron2R;
    public ModelRenderer Pauldron3R;
    public ModelRenderer ArmR;
    public ModelRenderer Belt;
    public ModelRenderer BeltBuckle;
    public ModelRenderer Body;
    public ModelRenderer Coif;
    public ModelRenderer Head;
    public ModelRenderer LegR;
    public ModelRenderer FootR;
    public ModelRenderer HipGuardR;
    public ModelRenderer HipGuardBR;
    public ModelRenderer Pauldron1L;
    public ModelRenderer Pauldron2L;
    public ModelRenderer Pauldron3L;
    public ModelRenderer ArmL;
    public ModelRenderer LegL;
    public ModelRenderer FootL;
    public ModelRenderer HipGuardL;
    public ModelRenderer HipGuardBL;

    public ModelChainArmor(float f) {
    	super(f, 0, 64,96);
    	
        this.textureWidth = 64;
        this.textureHeight = 96;
        
        this.BeltBuckle = new ModelRenderer(this, 0, 32);
        this.BeltBuckle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BeltBuckle.addBox(-1.0F, 10.0F, -2.4F, 2, 2, 1, 0.2F);
        this.bipedBody.addChild(BeltBuckle);
        
        this.Pauldron3L = new ModelRenderer(this, 16, 64);
        this.Pauldron3L.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron3L.addBox(-1.3F, -1.3F, -2.5F, 2, 2, 5, 0.1F);
        this.setRotateAngle(Pauldron3L, 0.0F, 3.141592653589793F, 0.2617993877991494F);
        this.bipedLeftArm.addChild(Pauldron3L);
        
        this.LegL = new ModelRenderer(this, 0, 48);
        this.LegL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.1F);
        this.bipedLeftLeg.addChild(LegL);
        
        this.LegR = new ModelRenderer(this, 0, 48);
        this.LegR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegR.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.1F);
        this.bipedRightLeg.addChild(LegR);
        
        this.FootR = new ModelRenderer(this, 0, 75);
        this.FootR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootR.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.0F);
        this.bipedRightLeg.addChild(FootR);
        
        this.Pauldron1R = new ModelRenderer(this, 30, 64);
        this.Pauldron1R.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron1R.addBox(-3.5F, -1.6F, -2.5F, 3, 4, 5, 0.0F);
        this.setRotateAngle(Pauldron1R, 0.0F, 0.0F, 0.2617993877991494F);
        this.bipedRightArm.addChild(Pauldron1R);
        
        this.ArmR = new ModelRenderer(this, 40, 48);
        this.ArmR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmR.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.1F);
        this.bipedRightArm.addChild(ArmR);
        
        this.ArmL = new ModelRenderer(this, 40, 48);
        this.ArmL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmL.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.1F);
        this.setRotateAngle(ArmL, 0.0F, 3.141592653589793F, 0.0F);
        this.bipedLeftArm.addChild(ArmL);
        
        this.HipGuardL = new ModelRenderer(this, 24, 32);
        this.HipGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HipGuardL.addBox(-2.1F, 0.0F, 1.5F, 4, 6, 1, -0.1F);
        this.setRotateAngle(HipGuardL, 0.17453292519943295F, 1.5707963267948966F, 0.0F);
        this.bipedLeftLeg.addChild(HipGuardL);
        
        this.Pauldron2R = new ModelRenderer(this, 0, 64);
        this.Pauldron2R.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron2R.addBox(-2.4F, -2.7F, -2.5F, 3, 3, 5, -0.1F);
        this.setRotateAngle(Pauldron2R, 0.0F, 0.0F, -0.2617993877991494F);
        this.bipedRightArm.addChild(Pauldron2R);
        
        this.Body = new ModelRenderer(this, 16, 48);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.1F);
        this.bipedBody.addChild(Body);
        
        this.Pauldron2L = new ModelRenderer(this, 0, 64);
        this.Pauldron2L.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron2L.addBox(-2.4F, -2.7F, -2.5F, 3, 3, 5, -0.1F);
        this.setRotateAngle(Pauldron2L, 0.0F, 3.141592653589793F, 0.2617993877991494F);
        this.bipedLeftArm.addChild(Pauldron2L);
        
        this.Coif = new ModelRenderer(this, 0, 78);
        this.Coif.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Coif.addBox(-4.0F, -8.0F, -4.0F, 8, 10, 8, 0.5F);
        this.bipedHead.addChild(Coif);
        
        this.HipGuardBR = new ModelRenderer(this, 24, 32);
        this.HipGuardBR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HipGuardBR.addBox(-2.0F, 0.0F, 1.0F, 4, 6, 1, 0.0F);
        this.setRotateAngle(HipGuardBR, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(HipGuardBR);
        
        this.Pauldron3R = new ModelRenderer(this, 16, 64);
        this.Pauldron3R.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron3R.addBox(-1.3F, -1.3F, -2.5F, 2, 2, 5, 0.1F);
        this.setRotateAngle(Pauldron3R, 0.0F, 0.0F, -0.2617993877991494F);
        this.bipedRightArm.addChild(Pauldron3R);
        
        this.Head = new ModelRenderer(this, 0, 32);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.1F);
        this.bipedHead.addChild(Head);
        
        this.FootL = new ModelRenderer(this, 0, 75);
        this.FootL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootL.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.0F);
        this.bipedLeftLeg.addChild(FootL);
        
        this.Belt = new ModelRenderer(this, 32, 90);
        this.Belt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Belt.addBox(-4.0F, 10.0F, -2.0F, 8, 2, 4, 0.2F);
        this.bipedBody.addChild(Belt);
        
        this.HipGuardBL = new ModelRenderer(this, 24, 32);
        this.HipGuardBL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HipGuardBL.addBox(-2.0F, 0.0F, 1.0F, 4, 6, 1, 0.0F);
        this.setRotateAngle(HipGuardBL, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(HipGuardBL);
        
        this.Pauldron1L = new ModelRenderer(this, 30, 64);
        this.Pauldron1L.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron1L.addBox(-3.5F, -1.6F, -2.5F, 3, 4, 5, 0.0F);
        this.setRotateAngle(Pauldron1L, 0.0F, 3.141592653589793F, -0.2617993877991494F);
        this.bipedLeftArm.addChild(Pauldron1L);
        
        this.HipGuardR = new ModelRenderer(this, 24, 32);
        this.HipGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HipGuardR.addBox(-2.1F, 0.0F, -2.5F, 4, 6, 1, -0.1F);
        this.setRotateAngle(HipGuardR, -0.17453292519943295F, 1.5707963267948966F, 0.0F);
        this.bipedRightLeg.addChild(HipGuardR);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
