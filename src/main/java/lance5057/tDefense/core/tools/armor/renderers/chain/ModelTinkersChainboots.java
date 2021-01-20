package lance5057.tDefense.core.tools.armor.renderers.chain;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * TinkersBoots - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersChainboots  extends ArmorRenderer {
    public ModelRenderer BootTopR;
    public ModelRenderer BootTopL;
    public ModelRenderer FootL;
    public ModelRenderer FootR;
    public ModelRenderer LegGuardL;
    public ModelRenderer LegGuardR;
    public ModelRenderer FootTipL;
    public ModelRenderer FootTipR;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftLeg;

    public ModelTinkersChainboots(ItemStack stack) {
		super(0.25f, 0, 32, 32, stack);
		
        this.textureWidth = 32;
        this.textureHeight = 32;
        
        //Left Leg
        
        this.LeftLeg = new ModelRenderer(this, 0, 0);
        this.LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.bipedLeftLeg = this.LeftLeg;
        
        this.FootL = new ModelRenderer(this, 16, 6);
        this.FootL.mirror = true;
        this.FootL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootL.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.1F);
        this.LeftLeg.addChild(FootL);
        
        this.LegGuardL = new ModelRenderer(this, 16, 0);
        this.LegGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegGuardL.addBox(-2.0F, 5.5F, -3.8F, 4, 4, 2, 0.3F);
        this.setRotateAngle(LegGuardL, 0.17453292519943295F, 0.0F, 0.0F);
        this.LeftLeg.addChild(LegGuardL);
        
        this.FootTipL = new ModelRenderer(this, 16, 9);
        this.FootTipL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootTipL.addBox(-1.5F, 9.5F, -5.6F, 3, 2, 2, -0.1F);
        this.setRotateAngle(FootTipL, 0.17453292519943295F, 0.0F, 0.0F);
        this.LeftLeg.addChild(FootTipL);
        
        this.BootTopL = new ModelRenderer(this, 0, 16);
        this.BootTopL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BootTopL.addBox(-2.5F, 3.5F, -2.55F, 5, 4, 5, -0.1F);
        this.LeftLeg.addChild(BootTopL);
        
        //Right Leg
        
        this.RightLeg = new ModelRenderer(this, 0, 0);
        this.RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.bipedRightLeg = this.RightLeg;
        
        this.FootTipR = new ModelRenderer(this, 16, 9);
        this.FootTipR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootTipR.addBox(-1.5F, 9.5F, -5.6F, 3, 2, 2, -0.1F);
        this.setRotateAngle(FootTipR, 0.17453292519943295F, 0.0F, 0.0F);
        this.RightLeg.addChild(FootTipR);
        
        this.BootTopR = new ModelRenderer(this, 0, 16);
        this.BootTopR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BootTopR.addBox(-2.5F, 3.5F, -2.55F, 5, 4, 5, -0.1F);
        this.RightLeg.addChild(BootTopR);
        
        this.FootR = new ModelRenderer(this, 16, 6);
        this.FootR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootR.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.1F);
        this.RightLeg.addChild(FootR);
        
        this.LegGuardR = new ModelRenderer(this, 16, 0);
        this.LegGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegGuardR.addBox(-2.0F, 5.5F, -3.8F, 4, 4, 2, 0.3F);
        this.setRotateAngle(LegGuardR, 0.17453292519943295F, 0.0F, 0.0F);
        this.RightLeg.addChild(LegGuardR);
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
