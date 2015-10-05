package lance5057.tDefense.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * JewelersBench - lance5057
 * Created using Tabula 4.1.1
 */
public class ModelJewelersBench extends ModelBase {
    public ModelRenderer TableSide2;
    public ModelRenderer SawBlock1;
    public ModelRenderer SawBlock2;
    public ModelRenderer SawBlock3;
    public ModelRenderer SawBlockClamp;
    public ModelRenderer Leg1;
    public ModelRenderer Leg2;
    public ModelRenderer Leg3;
    public ModelRenderer Leg4;
    public ModelRenderer TableTop;
    public ModelRenderer TableBack;
    public ModelRenderer TableSide1;
    public ModelRenderer Drawer;
    public ModelRenderer Handle;

    public ModelJewelersBench() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.SawBlock1 = new ModelRenderer(this, 0, 0);
        this.SawBlock1.setRotationPoint(2.0F, 8.2F, -12.0F);
        this.SawBlock1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.Leg4 = new ModelRenderer(this, 0, 0);
        this.Leg4.setRotationPoint(6.0F, 10.0F, 6.0F);
        this.Leg4.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
        this.Drawer = new ModelRenderer(this, 0, 46);
        this.Drawer.setRotationPoint(-6.0F, 11.5F, -8.0F);
        this.Drawer.addBox(0.0F, 0.0F, 0.0F, 12, 2, 16, 0.0F);
        this.TableSide2 = new ModelRenderer(this, 0, 0);
        this.TableSide2.setRotationPoint(-8.0F, 7.0F, -7.0F);
        this.TableSide2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
        this.Leg2 = new ModelRenderer(this, 0, 0);
        this.Leg2.setRotationPoint(6.0F, 10.0F, -8.0F);
        this.Leg2.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
        this.TableSide1 = new ModelRenderer(this, 0, 0);
        this.TableSide1.setRotationPoint(7.0F, 7.0F, -7.0F);
        this.TableSide1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
        this.SawBlock3 = new ModelRenderer(this, 0, 0);
        this.SawBlock3.setRotationPoint(3.0F, 8.2F, -11.0F);
        this.SawBlock3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.Handle = new ModelRenderer(this, 55, 0);
        this.Handle.setRotationPoint(-2.0F, 12.0F, -9.0F);
        this.Handle.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Leg1 = new ModelRenderer(this, 0, 0);
        this.Leg1.setRotationPoint(-8.0F, 10.0F, -8.0F);
        this.Leg1.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
        this.TableTop = new ModelRenderer(this, 0, 28);
        this.TableTop.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.TableTop.addBox(0.0F, 0.0F, 0.0F, 16, 2, 16, 0.0F);
        this.TableBack = new ModelRenderer(this, 0, 0);
        this.TableBack.setRotationPoint(-8.0F, 7.0F, 7.0F);
        this.TableBack.addBox(0.0F, 0.0F, 0.0F, 16, 1, 1, 0.0F);
        this.SawBlockClamp = new ModelRenderer(this, 54, 0);
        this.SawBlockClamp.setRotationPoint(1.5F, 8.0F, -9.0F);
        this.SawBlockClamp.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
        this.Leg3 = new ModelRenderer(this, 0, 0);
        this.Leg3.setRotationPoint(-8.0F, 10.0F, 6.0F);
        this.Leg3.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
        this.SawBlock2 = new ModelRenderer(this, 0, 0);
        this.SawBlock2.setRotationPoint(4.0F, 8.2F, -12.0F);
        this.SawBlock2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.SawBlock1.render(f5);
        this.Leg4.render(f5);
        this.Drawer.render(f5);
        this.TableSide2.render(f5);
        this.Leg2.render(f5);
        this.TableSide1.render(f5);
        this.SawBlock3.render(f5);
        this.Handle.render(f5);
        this.Leg1.render(f5);
        this.TableTop.render(f5);
        this.TableBack.render(f5);
        this.SawBlockClamp.render(f5);
        this.Leg3.render(f5);
        this.SawBlock2.render(f5);
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
