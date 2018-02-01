package lance5057.tDefense.core.tools.armor.renderers.heavy;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersBreastplate extends ArmorRenderer {
    public ModelRenderer BackPlate;
    public ModelRenderer BreastPlate;
    public ModelRenderer Plackart;
    public ModelRenderer PauldronR;
    public ModelRenderer PauldronL;
    public ModelRenderer ArmR;
    public ModelRenderer ArmL;
    public ModelRenderer Pauldron2L;
    public ModelRenderer Pauldron2R;

    public ModelTinkersBreastplate(ItemStack stack) {
    	super(0.25f, 0, 96, 64, stack);
        this.textureWidth = 128;
        this.textureHeight = 64;

        this.ArmL = new ModelRenderer(this, 92, 12);
        this.ArmL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmL.addBox(-1.0F, -2.3F, -3.0F, 5, 6, 6, 0.0F);
        this.bipedLeftArm.addChild(ArmL);

        this.PauldronR = new ModelRenderer(this, 88, 0);
        this.PauldronR.mirror = true;
        this.PauldronR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PauldronR.addBox(-4.6F, -2.0F, -3.5F, 4, 5, 7, 0.1F);
        this.setRotateAngle(PauldronR, 0.0F, 0.0F, 0.4363323129985824F);
        this.bipedRightArm.addChild(PauldronR);

        this.Plackart = new ModelRenderer(this, 64, 10);
        this.Plackart.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Plackart.addBox(-4.0F, 5.0F, -3.0F, 8, 7, 6, 0.3F);
        this.bipedBody.addChild(Plackart);
        
        this.ArmR = new ModelRenderer(this, 92, 12);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmR.addBox(-4.0F, -2.3F, -3.0F, 5, 6, 6, 0.0F);
        this.bipedRightArm.addChild(ArmR);
        
        this.BackPlate = new ModelRenderer(this, 64, 24);
        this.BackPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackPlate.addBox(-4.0F, -0.1F, 1.0F, 8, 5, 3, 0.41F);
        this.setRotateAngle(BackPlate, -0.08726646259971647F, 0.0F, 0.0F);
        this.bipedBody.addChild(BackPlate);
        
        this.Pauldron2L = new ModelRenderer(this, 88, 0);
        this.Pauldron2L.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron2L.addBox(0.5F, -1.5F, -3.5F, 4, 4, 7, -0.4F);
        this.setRotateAngle(Pauldron2L, 0.0F, 0.0F, -1.1344640137963142F);
        this.bipedLeftArm.addChild(Pauldron2L);
        
        this.Pauldron2R = new ModelRenderer(this, 88, 0);
        this.Pauldron2R.mirror = true;
        this.Pauldron2R.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron2R.addBox(-4.5F, -1.5F, -3.5F, 4, 4, 7, -0.4F);
        this.setRotateAngle(Pauldron2R, 0.0F, 0.0F, 1.1344640137963142F);
        this.bipedRightArm.addChild(Pauldron2R);

        this.BreastPlate = new ModelRenderer(this, 64, 0);
        this.BreastPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BreastPlate.addBox(-4.0F, 0.1F, -3.6F, 8, 6, 4, 0.41F);
        this.bipedBody.addChild(BreastPlate);

        this.PauldronL = new ModelRenderer(this, 88, 0);
        this.PauldronL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PauldronL.addBox(0.5F, -2.0F, -3.5F, 4, 5, 7, 0.1F);
        this.setRotateAngle(PauldronL, 0.0F, 0.0F, -0.4363323129985824F);
        this.bipedLeftArm.addChild(PauldronL);
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
