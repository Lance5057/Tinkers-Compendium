package gmail.Lance5057.armor.renderers;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelSheath extends ModelBiped {
    public ModelRenderer shape9;
    public ModelRenderer shape10;

    public ModelSheath() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.shape10 = new ModelRenderer(this, 16, 0);
        this.shape10.setRotationPoint(-4.5F, 0.0F, 0.5F);
        this.shape10.addBox(0.0F, 0.0F, -3.0F, 1, 12, 5, 0.0F);
        this.setRotateAngle(shape10, 0.0F, 0.0F, -0.7853981633974483F);
        this.shape9 = new ModelRenderer(this, 0, 0);
        this.shape9.setRotationPoint(-0.3F, 3.5F, 2.0F);
        this.shape9.addBox(-3.0F, 0.0F, 0.0F, 6, 24, 2, 0.0F);
        this.setRotateAngle(shape9, 0.0F, 0.0F, -0.45F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape10.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape9.offsetX, this.shape9.offsetY, this.shape9.offsetZ);
        GL11.glTranslatef(this.shape9.rotationPointX * f5, this.shape9.rotationPointY * f5, this.shape9.rotationPointZ * f5);
        GL11.glScaled(0.65D, 0.65D, 0.5D);
        GL11.glTranslatef(-this.shape9.offsetX, -this.shape9.offsetY, -this.shape9.offsetZ);
        GL11.glTranslatef(-this.shape9.rotationPointX * f5, -this.shape9.rotationPointY * f5, -this.shape9.rotationPointZ * f5);
        this.shape9.render(f5);
        GL11.glPopMatrix();
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
