package lance5057.tDefense.core.tools.armor.renderers.cloth;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.ItemStack;

/**
 * TinkersHood - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersHood extends ArmorRenderer {
    public ModelRenderer Flop;
    public ModelRenderer Flop_1;
    public ModelRenderer Flop_2;
    public ModelRenderer ScarfNeck;

    public ModelTinkersHood(ItemStack stack) {
    	super(0.25f, 0, 96, 96, stack);
        this.textureWidth = 96;
        this.textureHeight = 96;
       
        this.Flop_1 = new ModelRenderer(this, 77, 9);
        this.Flop_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Flop_1.addBox(-2.0F, -6.8F, -0.1F, 4, 4, 5, 0.5F);
        this.setRotateAngle(Flop_1, -0.6981317007977318F, 0.0F, 0.0F);
        this.bipedHead.addChild(Flop_1);
        
        this.Flop = new ModelRenderer(this, 78, 0);
        this.Flop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Flop.addBox(-3.0F, -7.6F, 1.0F, 6, 6, 3, 0.5F);
        this.setRotateAngle(Flop, -0.3490658503988659F, 0.0F, 0.0F);
        this.bipedHead.addChild(Flop);
        
        this.Flop_2 = new ModelRenderer(this, 84, 18);
        this.Flop_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Flop_2.addBox(-1.0F, -6.6F, 2.0F, 2, 2, 4, 0.5F);
        this.setRotateAngle(Flop_2, -1.0471975511965976F, 0.0F, 0.0F);
        this.bipedHead.addChild(Flop_2);
        
        this.ScarfNeck = new ModelRenderer(this, 60, 24);
        this.ScarfNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ScarfNeck.addBox(-4.5F, -2.0F, -4.5F, 9, 3, 9, 0.3F);
        this.bipedHead.addChild(ScarfNeck);
        
        this.bipedHeadwear.isHidden = true;
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
