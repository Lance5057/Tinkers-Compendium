package lance5057.tDefense.core.modifiers.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelGoggles extends ModelBiped {
    public ModelRenderer Band;
    public ModelRenderer Goggles;

    public ModelGoggles() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Band = new ModelRenderer(this, 0, 11);
        this.Band.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Band.addBox(-4.5F, -5.5F, -4.5F, 9, 1, 9, 0.0F);
        this.Goggles = new ModelRenderer(this, 0, 0);
        this.Goggles.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Goggles.addBox(-6.0F, -8.5F, -6.5F, 12, 7, 4, -1.4F);
        
        this.bipedHeadwear.addChild(Band);
        this.bipedHeadwear.addChild(Goggles);
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
