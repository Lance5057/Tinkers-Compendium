package lance5057.tDefense.core.tools.armor.renderers.heavy;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.ItemStack;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersHelm extends ArmorRenderer {
    public ModelRenderer Visor;
    public ModelRenderer Helm;
    public ModelRenderer Trim;
    public ModelRenderer MouthGuard;

    public ModelTinkersHelm(ItemStack stack) {
    	super(0.25f, 0, 96, 96, stack);
        this.textureWidth = 96;
        this.textureHeight = 96;
        
        this.MouthGuard = new ModelRenderer(this, 64, 32);
        this.MouthGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MouthGuard.addBox(-4.5F, -4.5F, -4.5F, 9, 5, 8, 0.11F);
        this.setRotateAngle(MouthGuard, 0.3490658503988659F, 0.0F, 0.0F);
        this.bipedHead.addChild(MouthGuard);

        this.Helm = new ModelRenderer(this, 64, 47);
        this.Helm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Helm.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.bipedHead.addChild(Helm);
        
        this.Trim = new ModelRenderer(this, 64, 0);
        this.Trim.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Trim.addBox(-1.0F, -8.3F, -4.0F, 2, 8, 8, 0.7F);
        this.bipedHead.addChild(Trim);

        this.Visor = new ModelRenderer(this, 64, 20);
        this.Visor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Visor.addBox(-4.5F, -6.4F, -6.0F, 9, 4, 8, 0.1F);
        this.setRotateAngle(Visor, -0.08726646259971647F, 0.0F, 0.0F);
        this.bipedHead.addChild(Visor);
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
