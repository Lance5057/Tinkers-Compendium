package lance5057.tDefense.core.tools.armor.renderers.heavy;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersSabatons extends ArmorRenderer {
    public ModelRenderer BootL;
    public ModelRenderer ShinGuardL;
    public ModelRenderer KneeGuardCapL;
    public ModelRenderer LegBackL;
    public ModelRenderer BootR;
    public ModelRenderer ShinGuardR;
    public ModelRenderer BootCapR;
    public ModelRenderer BootCapL;
    public ModelRenderer LegBackR;
    public ModelRenderer KneeGuardCapR;
    public ModelRenderer KneeGuardR;
    public ModelRenderer KneeGuardL;

    public ModelTinkersSabatons(ItemStack stack) {
    	super(0.25f, 0, 96, 64, stack);
        this.textureWidth = 96;
        this.textureHeight = 64;

        this.ShinGuardL = new ModelRenderer(this, 64, 48);
        this.ShinGuardL.mirror = true;
        this.ShinGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShinGuardL.addBox(-2.0F, 4.0F, -2.5F, 4, 5, 3, 0.26F);
        this.setRotateAngle(ShinGuardL, 0.05759586531581287F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(ShinGuardL);

        this.BootL = new ModelRenderer(this, 64, 56);
        this.BootL.mirror = true;
        this.BootL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BootL.addBox(-2.0F, 9.0F, -3.0F, 4, 3, 5, 0.31F);
        this.bipedLeftLeg.addChild(BootL);
        
        this.LegBackL = new ModelRenderer(this, 64, 40);
        this.LegBackL.mirror = true;
        this.LegBackL.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.LegBackL.addBox(-2.0F, 3.0F, 0.6F, 4, 6, 2, 0.3F);
        this.setRotateAngle(LegBackL, -0.05759586531581287F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(LegBackL);
        
        this.KneeGuardCapL = new ModelRenderer(this, 80, 36);
        this.KneeGuardCapL.mirror = true;
        this.KneeGuardCapL.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.KneeGuardCapL.addBox(-1.5F, 2.4F, -3.8F, 3, 2, 1, 0.2F);
        this.setRotateAngle(KneeGuardCapL, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(KneeGuardCapL);
        
        this.KneeGuardR = new ModelRenderer(this, 64, 32);
        this.KneeGuardR.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.KneeGuardR.addBox(-2.0F, 3.0F, -2.5F, 4, 3, 4, 0.31F);
        this.bipedRightLeg.addChild(KneeGuardR);

        this.BootR = new ModelRenderer(this, 64, 56);
        this.BootR.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.BootR.addBox(-2.0F, 9.0F, -3.0F, 4, 3, 5, 0.31F);
        this.bipedRightLeg.addChild(BootR);

        this.ShinGuardR = new ModelRenderer(this, 64, 48);
        this.ShinGuardR.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.ShinGuardR.addBox(-2.0F, 4.0F, -2.5F, 4, 5, 3, 0.26F);
        this.setRotateAngle(ShinGuardR, 0.05759586531581287F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(ShinGuardR);
        
        this.KneeGuardL = new ModelRenderer(this, 64, 32);
        this.KneeGuardL.mirror = true;
        this.KneeGuardL.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.KneeGuardL.addBox(-2.0F, 3.0F, -2.5F, 4, 3, 4, 0.31F);
        this.bipedLeftLeg.addChild(KneeGuardL);
        
        this.BootCapR = new ModelRenderer(this, 76, 32);
        this.BootCapR.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.BootCapR.addBox(-1.5F, 10.0F, -4.0F, 3, 2, 2, 0.3F);
        this.bipedRightLeg.addChild(BootCapR);
        
        this.KneeGuardCapR = new ModelRenderer(this, 80, 36);
        this.KneeGuardCapR.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.KneeGuardCapR.addBox(-1.5F, 2.4F, -3.8F, 3, 2, 1, 0.2F);
        this.setRotateAngle(KneeGuardCapR, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(KneeGuardCapR);

        this.BootCapL = new ModelRenderer(this, 76, 32);
        this.BootCapL.mirror = true;
        this.BootCapL.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.BootCapL.addBox(-1.5F, 10.0F, -4.0F, 3, 2, 2, 0.3F);
        this.bipedLeftLeg.addChild(BootCapL);
        
        this.LegBackR = new ModelRenderer(this, 64, 40);
        this.LegBackR.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.LegBackR.addBox(-2.0F, 3.0F, 0.6F, 4, 6, 2, 0.3F);
        this.setRotateAngle(LegBackR, -0.05759586531581287F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(LegBackR);
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
