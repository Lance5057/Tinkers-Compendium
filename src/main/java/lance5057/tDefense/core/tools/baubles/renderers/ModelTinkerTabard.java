package lance5057.tDefense.core.tools.baubles.renderers;

import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * ModelTinkerBreastPlate - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkerTabard extends ArmorRenderer {
    public ModelRenderer Tabard_Back;
    public ModelRenderer Tabard_BackBottom;
    public ModelRenderer Tabard_Front;
    public ModelRenderer Tabard_FrontBottom;
    public ModelRenderer Tabard_TopFront;
    public ModelRenderer Tabard_FrontTop;
    public ModelRenderer Tabard_TopBack;

    public ModelTinkerTabard(ItemStack stack) {
    	super(0.25f, 0, 32, 32, stack);
    	
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Tabard_FrontTop = new ModelRenderer(this, 0, 0);
        this.Tabard_FrontTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tabard_FrontTop.addBox(-5.0F, -1.0F, -4.5F, 10, 8, 1, -0.2F);
        
        this.Tabard_Back = new ModelRenderer(this, 0, 0);
        this.Tabard_Back.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tabard_Back.addBox(-5.0F, -1.0F, 4.0F, 10, 12, 1, -0.2F);
        this.setRotateAngle(Tabard_Back, -0.15219271077390556F, 0.0F, 0.0F);
        
        this.Tabard_Front = new ModelRenderer(this, 0, 8);
        this.Tabard_Front.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tabard_Front.addBox(-5.0F, 4.0F, -6.9F, 10, 4, 1, -0.2F);
        this.setRotateAngle(Tabard_Front, 0.4363323129985824F, 0.0F, 0.0F);
        
        this.Tabard_TopBack = new ModelRenderer(this, 0, 0);
        this.Tabard_TopBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tabard_TopBack.addBox(-5.0F, -5.0F, -1.2F, 10, 5, 1, -0.2F);
        this.setRotateAngle(Tabard_TopBack, 4.556880144031995F, 0.0F, 0.0F);
        
        this.Tabard_TopFront = new ModelRenderer(this, 0, 0);
        this.Tabard_TopFront.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tabard_TopFront.addBox(-5.0F, -4.5F, 0.2F, 10, 5, 1, -0.2F);
        this.setRotateAngle(Tabard_TopFront, 1.5788908473017518F, 0.0F, 0.0F);
        
        this.Tabard_BackBottom = new ModelRenderer(this, 0, 12);
        this.Tabard_BackBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tabard_BackBottom.addBox(-5.0F, 11.0F, -0.7F, 10, 8, 1, -0.2F);
        this.setRotateAngle(Tabard_BackBottom, 0.2792526803190927F, 0.0F, 0.0F);
        
        this.Tabard_FrontBottom = new ModelRenderer(this, 0, 12);
        this.Tabard_FrontBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tabard_FrontBottom.addBox(-5.0F, 9.8F, -2.2F, 10, 8, 1, -0.2F);
        this.setRotateAngle(Tabard_FrontBottom, -0.06981317007977318F, 0.0F, 0.0F);
        
        this.bipedHead.addChild(Tabard_FrontTop);
        this.bipedHead.addChild(Tabard_Back);
        this.bipedHead.addChild(Tabard_Front);
        this.bipedHead.addChild(Tabard_TopBack);
        this.bipedHead.addChild(Tabard_TopFront);
        this.bipedHead.addChild(Tabard_BackBottom);
        this.bipedHead.addChild(Tabard_FrontBottom);
    }
}
