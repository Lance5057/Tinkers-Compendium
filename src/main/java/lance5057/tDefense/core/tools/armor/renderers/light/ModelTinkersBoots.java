package lance5057.tDefense.core.tools.armor.renderers.light;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * ModelTinkersBoots - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersBoots extends ArmorRenderer {
    public ModelRenderer BootTopR;
    public ModelRenderer BootTopL;
    public ModelRenderer FootL;
    public ModelRenderer FootR;
    public ModelRenderer LegGuardL;
    public ModelRenderer LegGuardR;
    public ModelRenderer FootTipL;
    public ModelRenderer FootTipR;

    public ModelTinkersBoots(ItemStack stack) {
    	super(0.25f, 0, 96, 64, stack);
        this.textureWidth = 96;
        this.textureHeight = 64;
        
        this.FootTipR = new ModelRenderer(this, 74, 9);
        this.FootTipR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootTipR.addBox(-1.5F, 9.5F, -5.6F, 3, 2, 2, -0.2F);
        this.setRotateAngle(FootTipR, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(FootTipR);
        
        this.BootTopL = new ModelRenderer(this, 64, 0);
        this.BootTopL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BootTopL.addBox(-2.5F, 3.5F, -2.5F, 5, 4, 5, -0.2F);
        this.bipedLeftLeg.addChild(BootTopL);
        
        this.FootL = new ModelRenderer(this, 64, 9);
        this.FootL.mirror = true;
        this.FootL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootL.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.0F);
        this.bipedLeftLeg.addChild(FootL);
        
        this.LegGuardL = new ModelRenderer(this, 64, 12);
        this.LegGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegGuardL.addBox(-2.0F, 5.5F, -3.8F, 4, 4, 2, 0.1F);
        this.setRotateAngle(LegGuardL, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(LegGuardL);
        
        this.LegGuardR = new ModelRenderer(this, 64, 12);
        this.LegGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegGuardR.addBox(-2.0F, 5.5F, -3.8F, 4, 4, 2, 0.1F);
        this.setRotateAngle(LegGuardR, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(LegGuardR);
        
        this.FootR = new ModelRenderer(this, 64, 9);
        this.FootR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootR.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.0F);
        this.bipedRightLeg.addChild(FootR);
        
        this.BootTopR = new ModelRenderer(this, 64, 0);
        this.BootTopR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BootTopR.addBox(-2.5F, 3.5F, -2.5F, 5, 4, 5, -0.2F);
        this.bipedRightLeg.addChild(BootTopR);
        
        this.FootTipL = new ModelRenderer(this, 74, 9);
        this.FootTipL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootTipL.addBox(-1.5F, 9.5F, -5.6F, 3, 2, 2, -0.2F);
        this.setRotateAngle(FootTipL, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(FootTipL);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.FootTipR.render(f5);
        this.BootTopL.render(f5);
        this.FootL.render(f5);
        this.LegGuardL.render(f5);
        this.LegGuardR.render(f5);
        this.FootR.render(f5);
        this.BootTopR.render(f5);
        this.FootTipL.render(f5);
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
