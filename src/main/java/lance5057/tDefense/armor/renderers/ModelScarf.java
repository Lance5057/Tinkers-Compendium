package lance5057.tDefense.armor.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Scarf - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelScarf extends ModelBiped
{
    public ModelRenderer ScarfNeck;
    public ModelRenderer ScarfExtra1;
    public ModelRenderer ScarfExtra1_1;

    public ModelScarf() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.ScarfExtra1_1 = new ModelRenderer(this, 0, 32);
        this.ScarfExtra1_1.setRotationPoint(0.0F, 1.0F, 3.5F);
        this.ScarfExtra1_1.addBox(-3.0F, 0.0F, 0.0F, 3, 11, 1, 0.0F);
        this.setRotateAngle(ScarfExtra1_1, 0.0F, 0.0F, 0.17453292519943295F);
        this.ScarfNeck = new ModelRenderer(this, 8, 32);
        this.ScarfNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ScarfNeck.addBox(-4.0F, -2.0F, -4.0F, 8, 3, 8, 0.6F);
        this.ScarfExtra1 = new ModelRenderer(this, 8, 32);
        this.ScarfExtra1.setRotationPoint(0.0F, 1.0F, 3.5F);
        this.ScarfExtra1.addBox(-0.5F, 0.0F, 0.0F, 3, 7, 1, 0.0F);
        this.setRotateAngle(ScarfExtra1, 0.0F, 0.0F, -0.17453292519943295F);
        this.ScarfNeck.addChild(this.ScarfExtra1_1);
        this.ScarfNeck.addChild(this.ScarfExtra1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.ScarfNeck.render(f5);
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
