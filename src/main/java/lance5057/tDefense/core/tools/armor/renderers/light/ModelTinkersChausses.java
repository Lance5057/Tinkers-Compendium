package lance5057.tDefense.core.tools.armor.renderers.light;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersChausses extends ArmorRenderer {
    public ModelRenderer Front;
    public ModelRenderer HipGuardL;
    public ModelRenderer HipGuardR;
    public ModelRenderer Back;
    public ModelRenderer HipGuardL_1;
    public ModelRenderer HipGuardR_1;
    public ModelRenderer Belt;
    public ModelRenderer BeltR;
    public ModelRenderer BeltL;

    public ModelTinkersChausses(ItemStack stack) {
    	super(0.25f, 0, 96, 64, stack);
        this.textureWidth = 96;
        this.textureHeight = 64;
        
        this.HipGuardL = new ModelRenderer(this, 74, 37);
        this.HipGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HipGuardL.addBox(-1.5F, 0.0F, -2.6F, 4, 6, 5, 0.0F);
        this.setRotateAngle(HipGuardL, 0.0F, -0.0F, -0.17453292519943295F);
        this.bipedLeftLeg.addChild(HipGuardL);
        
        this.BeltR = new ModelRenderer(this, 62, 10);
        this.BeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BeltR.addBox(-9.5F, 12.5F, -3.0F, 11, 2, 6, -0.2F);
        this.setRotateAngle(BeltR, 0.0F, -0.0F, -0.27052603405912107F);
        this.bipedBody.addChild(BeltR);
        
        this.Back = new ModelRenderer(this, 64, 40);
        this.Back.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Back.addBox(-2.0F, 0.0F, 1.9F, 4, 7, 1, 0.0F);
        this.bipedBody.addChild(Back);
        
        this.Front = new ModelRenderer(this, 64, 40);
        this.Front.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Front.addBox(-2.0F, 0.0F, -2.7F, 4, 7, 1, 0.0F);
        this.bipedBody.addChild(Front);
        
        this.BeltL = new ModelRenderer(this, 62, 10);
        this.BeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BeltL.addBox(-1.5F, 12.5F, -3.0F, 11, 2, 6, -0.19F);
        this.setRotateAngle(BeltL, 0.0F, -0.0F, 0.27052603405912107F);
        this.bipedBody.addChild(BeltL);
        
        this.HipGuardR = new ModelRenderer(this, 74, 37);
        this.HipGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HipGuardR.addBox(-2.5F, 0.0F, -2.6F, 4, 6, 5, 0.0F);
        this.setRotateAngle(HipGuardR, 0.0F, -0.0F, 0.17453292519943295F);
        this.bipedRightLeg.addChild(HipGuardR);
        
        this.HipGuardR_1 = new ModelRenderer(this, 64, 49);
        this.HipGuardR_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HipGuardR_1.addBox(-2.5F, 0.0F, -2.6F, 4, 10, 5, 0.0F);
        this.setRotateAngle(HipGuardR_1, 0.0F, -0.0F, 0.08726646259971647F);
        this.bipedRightLeg.addChild(HipGuardR_1);
        
        this.Belt = new ModelRenderer(this, 64, 0);
        this.Belt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Belt.addBox(-5.0F, 10.5F, -3.0F, 10, 2, 6, -0.2F);
        this.bipedBody.addChild(Belt);
        
        this.HipGuardL_1 = new ModelRenderer(this, 64, 49);
        this.HipGuardL_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HipGuardL_1.addBox(-1.5F, 0.0F, -2.6F, 4, 10, 5, 0.0F);
        this.setRotateAngle(HipGuardL_1, 0.0F, -0.0F, -0.08726646259971647F);
        this.bipedLeftLeg.addChild(HipGuardL_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.HipGuardL.render(f5);
        this.BeltR.render(f5);
        this.Back.render(f5);
        this.Front.render(f5);
        this.BeltL.render(f5);
        this.HipGuardR.render(f5);
        this.HipGuardR_1.render(f5);
        this.Belt.render(f5);
        this.HipGuardL_1.render(f5);
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
