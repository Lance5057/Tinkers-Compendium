package lance5057.tDefense.core.tools.armor.renderers.cloth;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.ItemStack;

/**
 * TinkersShawl - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersShawl extends ArmorRenderer {
    public ModelRenderer Button;
    public ModelRenderer TrimNeck;
    public ModelRenderer ShawlLeftLong;
    public ModelRenderer ShawlLeftTrimLong;
    public ModelRenderer ShawlRightLong;
    public ModelRenderer ShawlRightTrimLong;

    public ModelTinkersShawl(ItemStack stack) {
    	super(0.25f, 0, 96, 64, stack);
        this.textureWidth = 96;
        this.textureHeight = 64;

        this.TrimNeck = new ModelRenderer(this, 68, 49);
        this.TrimNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TrimNeck.addBox(-4.5F, -0.4F, -2.5F, 9, 2, 5, -0.3F);
        this.bipedBody.addChild(TrimNeck);
        
        this.ShawlRightTrimLong = new ModelRenderer(this, 62, 40);
        this.ShawlRightTrimLong.mirror = true;
        this.ShawlRightTrimLong.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShawlRightTrimLong.addBox(-4.5F, 7.85F, -3.0F, 11, 3, 6, -0.5F);
        this.setRotateAngle(ShawlRightTrimLong, 0.0F, 0.0F, 0.2792526803190927F);
        this.bipedRightArm.addChild(ShawlRightTrimLong);
        
        this.ShawlRightLong = new ModelRenderer(this, 70, 26);
        this.ShawlRightLong.mirror = true;
        this.ShawlRightLong.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShawlRightLong.addBox(-3.45F, -0.95F, -2.0F, 9, 10, 4, 0.3F);
        this.setRotateAngle(ShawlRightLong, 0.0F, 0.0F, 0.2792526803190927F);
        this.bipedRightArm.addChild(ShawlRightLong);

        this.Button = new ModelRenderer(this, 67, 58);
        this.Button.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Button.addBox(-1.5F, -0.5F, -2.8F, 2, 2, 1, -0.2F);
        this.setRotateAngle(Button, 0.0F, 0.0F, -0.7853981633974483F);
        this.bipedBody.addChild(Button);

        this.ShawlLeftLong = new ModelRenderer(this, 70, 26);
        this.ShawlLeftLong.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShawlLeftLong.addBox(-5.55F, -1.00F, -2.0F, 9, 10, 4, 0.31F);
        this.setRotateAngle(ShawlLeftLong, 0.0F, 0.0F, -0.2792526803190927F);
        this.bipedLeftArm.addChild(ShawlLeftLong);

        this.ShawlLeftTrimLong = new ModelRenderer(this, 62, 40);
        this.ShawlLeftTrimLong.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShawlLeftTrimLong.addBox(-6.5F, 7.85F, -3.0F, 11, 3, 6, -0.5F);
        this.setRotateAngle(ShawlLeftTrimLong, 0.0F, 0.0F, -0.2792526803190927F);
        this.bipedLeftArm.addChild(ShawlLeftTrimLong);
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
