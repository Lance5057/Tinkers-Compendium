package lance5057.tDefense.core.modifiers.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelNightVisionGoggles extends ModelBase {
    public ModelRenderer Band;
    public ModelRenderer Faceplate;
    public ModelRenderer GoggleR;
    public ModelRenderer GoggleL;
    public ModelRenderer GoggleR2;
    public ModelRenderer GoggleL2;
    public ModelRenderer GoggleM;
    public ModelRenderer GoggleM2;

    public ModelNightVisionGoggles() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.GoggleL2 = new ModelRenderer(this, 0, 0);
        this.GoggleL2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.GoggleL2.addBox(2.0F, -6.0F, -8.5F, 2, 2, 2, 0.0F);
        this.Faceplate = new ModelRenderer(this, 27, 0);
        this.Faceplate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Faceplate.addBox(-5.0F, -7.0F, -5.5F, 10, 4, 1, 0.0F);
        this.GoggleM = new ModelRenderer(this, 0, 4);
        this.GoggleM.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.GoggleM.addBox(-1.5F, -8.5F, -6.5F, 3, 3, 1, 0.0F);
        this.GoggleR = new ModelRenderer(this, 0, 0);
        this.GoggleR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.GoggleR.addBox(-4.0F, -6.0F, -8.5F, 2, 2, 2, 0.0F);
        this.GoggleM2 = new ModelRenderer(this, 0, 0);
        this.GoggleM2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.GoggleM2.addBox(-1.0F, -8.0F, -8.5F, 2, 2, 2, 0.0F);
        this.GoggleL = new ModelRenderer(this, 0, 4);
        this.GoggleL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.GoggleL.addBox(1.5F, -6.5F, -6.5F, 3, 3, 1, 0.0F);
        this.Band = new ModelRenderer(this, 0, 0);
        this.Band.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Band.addBox(-4.5F, -5.5F, -4.5F, 9, 1, 9, 0.0F);
        this.GoggleR2 = new ModelRenderer(this, 0, 4);
        this.GoggleR2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.GoggleR2.addBox(-4.5F, -6.5F, -6.5F, 3, 3, 1, 0.0F);
        this.Faceplate.addChild(this.GoggleL2);
        this.Faceplate.addChild(this.GoggleM);
        this.Faceplate.addChild(this.GoggleR);
        this.Faceplate.addChild(this.GoggleM2);
        this.Faceplate.addChild(this.GoggleL);
        this.Faceplate.addChild(this.GoggleR2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Faceplate.render(f5);
        this.Band.render(f5);
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
