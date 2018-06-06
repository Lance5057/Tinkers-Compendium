package lance5057.tDefense.core.tools.armor.renderers.cloth;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.ItemStack;

/**
 * TinkersRobe - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersRobe extends ArmorRenderer {
    public ModelRenderer LeftBackL;
    public ModelRenderer CenterBackL;
    public ModelRenderer RightFronL;
    public ModelRenderer RightBackL;
    public ModelRenderer CenterFrontL;
    public ModelRenderer CenterFrontR;
    public ModelRenderer CenterBackR;
    public ModelRenderer BeltRHip;
    public ModelRenderer BeltStraight;
    public ModelRenderer LeftFrontL;

    public ModelTinkersRobe(ItemStack stack) {
    	super(0.25f, 0, 96, 96, stack);
        this.textureWidth = 96;
        this.textureHeight = 96;
        
        this.BeltStraight = new ModelRenderer(this, 66, 24);
        this.BeltStraight.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.BeltStraight.addBox(-4.5F, 0.0F, -3.0F, 9, 3, 6, -0.31F);
        this.bipedBody.addChild(BeltStraight);
        
        this.RightFronL = new ModelRenderer(this, 64, 0);
        this.RightFronL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightFronL.addBox(-2.2F, -0.3F, -2.5F, 4, 11, 4, 0.01F);
        this.setRotateAngle(RightFronL, -0.08726646259971647F, 0.0F, 0.08726646259971647F);
        this.bipedRightLeg.addChild(RightFronL);
        
        this.RightBackL = new ModelRenderer(this, 64, 0);
        this.RightBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightBackL.addBox(-2.2F, -0.3F, -1.5F, 4, 11, 4, 0.0F);
        this.setRotateAngle(RightBackL, 0.08726646259971647F, 0.0F, 0.08726646259971647F);
        this.bipedRightLeg.addChild(RightBackL);
        
        this.BeltRHip = new ModelRenderer(this, 64, 15);
        this.BeltRHip.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.BeltRHip.addBox(-5.3F, 0.0F, -3.0F, 10, 3, 6, -0.3F);
        this.setRotateAngle(BeltRHip, 0.0F, 0.0F, -0.13962634015954636F);
        this.bipedBody.addChild(BeltRHip);
        
        this.CenterBackL = new ModelRenderer(this, 80, 0);
        this.CenterBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CenterBackL.addBox(-2.9F, -0.2F, 0.4F, 2, 11, 2, 0.0F);
        this.setRotateAngle(CenterBackL, 0.08726646259971647F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(CenterBackL);
        
        this.CenterFrontR = new ModelRenderer(this, 80, 0);
        this.CenterFrontR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CenterFrontR.addBox(0.9F, -0.2F, -2.6F, 2, 11, 2, 0.0F);
        this.setRotateAngle(CenterFrontR, -0.08726646259971647F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(CenterFrontR);
        
        this.CenterFrontL = new ModelRenderer(this, 80, 0);
        this.CenterFrontL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CenterFrontL.addBox(-2.9F, -0.2F, -2.6F, 2, 11, 2, 0.0F);
        this.setRotateAngle(CenterFrontL, -0.08726646259971647F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(CenterFrontL);
        
        this.LeftBackL = new ModelRenderer(this, 64, 0);
        this.LeftBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftBackL.addBox(-1.8F, -0.3F, -1.5F, 4, 11, 4, 0.0F);
        this.setRotateAngle(LeftBackL, 0.08726646259971647F, 0.0F, -0.08726646259971647F);
        this.bipedLeftLeg.addChild(LeftBackL);
        
        this.CenterBackR = new ModelRenderer(this, 80, 0);
        this.CenterBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CenterBackR.addBox(0.9F, -0.2F, 0.4F, 2, 11, 2, 0.0F);
        this.setRotateAngle(CenterBackR, 0.08726646259971647F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(CenterBackR);
        
        this.LeftFrontL = new ModelRenderer(this, 64, 0);
        this.LeftFrontL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftFrontL.addBox(-1.8F, -0.3F, -2.5F, 4, 11, 4, 0.0F);
        this.setRotateAngle(LeftFrontL, -0.08726646259971647F, 0.0F, -0.08726646259971647F);
        this.bipedLeftLeg.addChild(LeftFrontL);
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
