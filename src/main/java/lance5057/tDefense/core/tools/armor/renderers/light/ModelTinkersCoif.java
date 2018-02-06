package lance5057.tDefense.core.tools.armor.renderers.light;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelTinkersCoif - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersCoif extends ModelBase {
    public ModelRenderer Coif;
    public ModelRenderer Mask;

    public ModelTinkersCoif() {
        this.textureWidth = 96;
        this.textureHeight = 64;
        this.Mask = new ModelRenderer(this, 64, 11);
        this.Mask.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Mask.addBox(-4.5F, -8.0F, -5.0F, 9, 10, 4, 0.11F);
        this.Coif = new ModelRenderer(this, 64, 0);
        this.Coif.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Coif.addBox(-4.0F, 1.0F, -4.0F, 8, 3, 8, 0.5F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Mask.render(f5);
        this.Coif.render(f5);
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
