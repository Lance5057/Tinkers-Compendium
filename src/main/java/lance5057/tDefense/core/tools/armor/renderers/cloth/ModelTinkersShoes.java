package lance5057.tDefense.core.tools.armor.renderers.cloth;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersShoes extends ArmorRenderer {
    public ModelRenderer FootL;
    public ModelRenderer FootR;

    public ModelTinkersShoes(ItemStack stack) {
    	super(0.25f, 0, 64, 64, stack);
    	
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.FootL = new ModelRenderer(this, 52, 17);
        this.FootL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootL.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.25F);
        this.bipedLeftLeg.addChild(FootL);
        
        this.FootR = new ModelRenderer(this, 52, 17);
        this.FootR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootR.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.25F);
        this.bipedRightLeg.addChild(FootR);
       
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
