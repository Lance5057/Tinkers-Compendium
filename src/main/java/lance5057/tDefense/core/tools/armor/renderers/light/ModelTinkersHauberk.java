package lance5057.tDefense.core.tools.armor.renderers.light;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TinkersHauberk - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersHauberk extends ModelBase {
    public ModelRenderer ChestBelt;
    public ModelRenderer ChestBeltR;
    public ModelRenderer ChestBelt2;
    public ModelRenderer ChestBeltL;
    public ModelRenderer Pauldron1;
    public ModelRenderer Pauldron2;
    public ModelRenderer PauldronStudR;
    public ModelRenderer Pauldron3R;
    public ModelRenderer Pauldron1L;
    public ModelRenderer Pauldron2L;
    public ModelRenderer PauldronStudL;
    public ModelRenderer Pauldron3L;

    public ModelTinkersHauberk() {
        this.textureWidth = 96;
        this.textureHeight = 64;
        this.ChestBelt = new ModelRenderer(this, 64, 17);
        this.ChestBelt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ChestBelt.addBox(-4.5F, 3.0F, -2.5F, 9, 2, 5, -0.19F);
        this.Pauldron3R = new ModelRenderer(this, 78, 9);
        this.Pauldron3R.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.Pauldron3R.addBox(-3.2F, -0.5F, -2.0F, 3, 4, 4, 0.1F);
        this.setRotateAngle(Pauldron3R, 0.0F, 0.0F, 0.08726646259971647F);
        this.Pauldron1 = new ModelRenderer(this, 64, 0);
        this.Pauldron1.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.Pauldron1.addBox(-3.5F, -1.9F, -2.5F, 4, 4, 5, 0.0F);
        this.setRotateAngle(Pauldron1, 0.0F, 0.0F, 0.2617993877991494F);
        this.PauldronStudL = new ModelRenderer(this, 64, 9);
        this.PauldronStudL.mirror = true;
        this.PauldronStudL.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.PauldronStudL.addBox(-1.0F, -1.5F, -2.5F, 2, 2, 5, 0.1F);
        this.setRotateAngle(PauldronStudL, 0.0F, 0.0F, 0.2617993877991494F);
        this.Pauldron3L = new ModelRenderer(this, 78, 9);
        this.Pauldron3L.mirror = true;
        this.Pauldron3L.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.Pauldron3L.addBox(0.2F, -0.5F, -2.0F, 3, 4, 4, 0.1F);
        this.setRotateAngle(Pauldron3L, 0.0F, 0.0F, -0.08726646259971647F);
        this.Pauldron2 = new ModelRenderer(this, 81, 0);
        this.Pauldron2.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.Pauldron2.addBox(-2.0F, -3.0F, -2.0F, 3, 3, 4, 0.1F);
        this.setRotateAngle(Pauldron2, 0.0F, 0.0F, -0.2617993877991494F);
        this.PauldronStudR = new ModelRenderer(this, 64, 9);
        this.PauldronStudR.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.PauldronStudR.addBox(-1.0F, -1.5F, -2.5F, 2, 2, 5, 0.1F);
        this.setRotateAngle(PauldronStudR, 0.0F, 0.0F, -0.2617993877991494F);
        this.ChestBeltR = new ModelRenderer(this, 64, 24);
        this.ChestBeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ChestBeltR.addBox(-3.5F, 2.3F, -2.5F, 11, 2, 5, -0.21F);
        this.setRotateAngle(ChestBeltR, 0.0F, 0.0F, 0.5235987755982988F);
        this.ChestBelt2 = new ModelRenderer(this, 64, 17);
        this.ChestBelt2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ChestBelt2.addBox(-4.5F, 5.0F, -2.5F, 9, 2, 5, -0.19F);
        this.Pauldron2L = new ModelRenderer(this, 81, 0);
        this.Pauldron2L.mirror = true;
        this.Pauldron2L.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.Pauldron2L.addBox(-1.0F, -3.0F, -2.0F, 3, 3, 4, 0.1F);
        this.setRotateAngle(Pauldron2L, 0.0F, 0.0F, 0.2617993877991494F);
        this.ChestBeltL = new ModelRenderer(this, 64, 24);
        this.ChestBeltL.mirror = true;
        this.ChestBeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ChestBeltL.addBox(-7.5F, 2.3F, -2.5F, 11, 2, 5, 0.0F);
        this.setRotateAngle(ChestBeltL, 0.0F, 0.0F, -0.5235987755982988F);
        this.Pauldron1L = new ModelRenderer(this, 64, 0);
        this.Pauldron1L.mirror = true;
        this.Pauldron1L.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.Pauldron1L.addBox(-0.5F, -1.9F, -2.5F, 4, 4, 5, 0.0F);
        this.setRotateAngle(Pauldron1L, 0.0F, 0.0F, -0.2617993877991494F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.ChestBelt.render(f5);
        this.Pauldron3R.render(f5);
        this.Pauldron1.render(f5);
        this.PauldronStudL.render(f5);
        this.Pauldron3L.render(f5);
        this.Pauldron2.render(f5);
        this.PauldronStudR.render(f5);
        this.ChestBeltR.render(f5);
        this.ChestBelt2.render(f5);
        this.Pauldron2L.render(f5);
        this.ChestBeltL.render(f5);
        this.Pauldron1L.render(f5);
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
