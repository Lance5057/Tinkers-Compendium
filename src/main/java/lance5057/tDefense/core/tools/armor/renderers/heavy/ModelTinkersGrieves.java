package lance5057.tDefense.core.tools.armor.renderers.heavy;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersGrieves extends ArmorRenderer {
    public ModelRenderer LegPlateL;
    public ModelRenderer CodPiece;
    public ModelRenderer LegPlateBackL;
    public ModelRenderer LegPlateBackR;
    public ModelRenderer LegPlateR;
    public ModelRenderer Belt;
    public ModelRenderer BeltBuckle;
    public ModelRenderer ThighR;
    public ModelRenderer ThighL;
    public ModelRenderer ThighRB;
    public ModelRenderer ThighLB;
    public ModelRenderer SecBeltL;

    public ModelTinkersGrieves(ItemStack stack) {
    	super(0.25f, 0, 96, 64, stack);
        this.textureWidth = 96;
        this.textureHeight = 64;
        
        this.Belt = new ModelRenderer(this, 64, 0);
        this.Belt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Belt.addBox(-4.5F, 10.0F, -2.8F, 9, 2, 6, 0.3F);
        this.bipedBody.addChild(Belt);
        
        this.LegPlateR = new ModelRenderer(this, 64, 32);
        this.LegPlateR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegPlateR.addBox(-2.6F, 0.9F, -2.5F, 1, 5, 5, 0.1F);
        this.setRotateAngle(LegPlateR, 0.0F, 0.0F, 0.2617993877991494F);
        this.bipedRightLeg.addChild(LegPlateR);
        
        this.LegPlateL = new ModelRenderer(this, 64, 32);
        this.LegPlateL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegPlateL.addBox(1.8F, 0.8F, -2.5F, 1, 5, 5, 0.1F);
        this.setRotateAngle(LegPlateL, 0.0F, 0.0F, -0.2617993877991494F);
        this.bipedLeftLeg.addChild(LegPlateL);
        
        this.ThighLB = new ModelRenderer(this, 80, 8);
        this.ThighLB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ThighLB.addBox(-2.0F, 0.0F, -1.5F, 4, 6, 4, 0.3F);
        this.setRotateAngle(ThighLB, -0.08726646259971647F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(ThighLB);
        
        this.ThighRB = new ModelRenderer(this, 80, 8);
        this.ThighRB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ThighRB.addBox(-2.0F, 0.0F, -1.5F, 4, 6, 4, 0.3F);
        this.setRotateAngle(ThighRB, -0.08726646259971647F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(ThighRB);
        
        this.CodPiece = new ModelRenderer(this, 64, 49);
        this.CodPiece.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CodPiece.addBox(-2.5F, 11.0F, -3.3F, 5, 5, 3, -0.4F);
        this.bipedBody.addChild(CodPiece);
        
        this.BeltBuckle = new ModelRenderer(this, 64, 58);
        this.BeltBuckle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BeltBuckle.addBox(-2.0F, 9.0F, -3.5F, 4, 4, 2, -0.3F);
        this.bipedBody.addChild(BeltBuckle);

        this.ThighR = new ModelRenderer(this, 64, 8);
        this.ThighR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ThighR.addBox(-2.0F, 1.0F, -2.8F, 4, 5, 4, 0.31F);
        this.setRotateAngle(ThighR, 0.08726646259971647F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(ThighR);

        this.ThighL = new ModelRenderer(this, 64, 8);
        this.ThighL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ThighL.addBox(-2.0F, 1.0F, -2.8F, 4, 5, 4, 0.31F);
        this.setRotateAngle(ThighL, 0.08726646259971647F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(ThighL);

        this.LegPlateBackR = new ModelRenderer(this, 64, 43);
        this.LegPlateBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegPlateBackR.addBox(-2.0F, 0.9F, 2.2F, 4, 5, 1, 0.0F);
        this.setRotateAngle(LegPlateBackR, 0.2617993877991494F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(LegPlateBackR);

        this.LegPlateBackL = new ModelRenderer(this, 64, 43);
        this.LegPlateBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegPlateBackL.addBox(-2.0F, 0.9F, 2.2F, 4, 5, 1, 0.0F);
        this.setRotateAngle(LegPlateBackL, 0.2617993877991494F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(LegPlateBackL);

        this.SecBeltL = new ModelRenderer(this, 64, 0);
        this.SecBeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SecBeltL.addBox(-1.0F, 11.5F, -2.8F, 9, 2, 6, 0.26F);
        this.setRotateAngle(SecBeltL, 0.0F, 0.0F, 0.2617993877991494F);
        this.bipedBody.addChild(SecBeltL);
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
