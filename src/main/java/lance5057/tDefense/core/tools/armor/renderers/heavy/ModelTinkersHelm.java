package lance5057.tDefense.core.tools.armor.renderers.heavy;

import lance5057.tDefense.core.library.ArmorTags;
import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import lance5057.tDefense.util.ArmorTagUtil;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.utils.TagUtil;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersHelm extends ArmorRenderer {
    public ModelRenderer Visor;
    public ModelRenderer Helm;
    public ModelRenderer Trim;
    public ModelRenderer MouthGuard;
    
    public ModelRenderer Visor_Open;
    public ModelRenderer MouthGuard_Open;

    public ModelRenderer Visor_Closed;
    public ModelRenderer MouthGuard_Closed;
    
    public ModelTinkersHelm(ItemStack stack) {
    	super(0.25f, 0, 64, 64, stack);
    	
    	this.textureWidth = 64;
        this.textureHeight = 64;
        
        this.Trim = new ModelRenderer(this, 0, 12);
        this.Trim.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Trim.addBox(-1.0F, -8.9F, -5.0F, 2, 9, 10, 0.0F);
        
        this.Helm = new ModelRenderer(this, 26, 4);
        this.Helm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Helm.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        
        this.MouthGuard = new ModelRenderer(this, 30, 20);
        this.MouthGuard.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.MouthGuard.addBox(-4.5F, -3.0F, -5.4F, 9, 5, 8, 0.1F);
        this.setRotateAngle(MouthGuard, 0.3490658503988659F, 0.0F, 0.0F);
        
        this.Visor = new ModelRenderer(this, 0, 0);
        this.Visor.setRotationPoint(0.0F, -6.7F, 0.1F);
        this.Visor.addBox(-4.5F, 0.2F, -5.9F, 9, 4, 8, 0.2F);
        this.setRotateAngle(Visor, -0.08726646259971647F, 0.0F, 0.0F);
        
        this.MouthGuard_Closed = new ModelRenderer(this, 30, 20);
        this.MouthGuard_Closed.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.MouthGuard_Closed.addBox(-4.5F, -3.0F, -5.4F, 9, 5, 8, 0.1F);
        this.setRotateAngle(MouthGuard_Closed, 0.3490658503988659F, 0.0F, 0.0F);
        
        this.Visor_Closed = new ModelRenderer(this, 0, 0);
        this.Visor_Closed.setRotationPoint(0.0F, -6.7F, 0.1F);
        this.Visor_Closed.addBox(-4.5F, 0.2F, -5.9F, 9, 4, 8, 0.2F);
        this.setRotateAngle(Visor_Closed, -0.08726646259971647F, 0.0F, 0.0F);
        
        this.Visor_Open = new ModelRenderer(this, 0, 0);
        this.Visor_Open.setRotationPoint(0.0F, -6.7F, 0.1F);
        this.Visor_Open.addBox(-4.5F, 0.2F, -5.9F, 9, 4, 8, 0.2F);
        this.setRotateAngle(Visor_Open, -0.4363323129985824F, 0.0F, 0.0F);
        
        this.MouthGuard_Open = new ModelRenderer(this, 30, 20);
        this.MouthGuard_Open.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.MouthGuard_Open.addBox(-4.5F, -3.0F, -5.4F, 9, 5, 8, 0.1F);
        this.setRotateAngle(MouthGuard_Open, 0.8783138702885441F, 0.0F, 0.0F);
        
        this.Helm.addChild(this.Trim);
        this.Helm.addChild(this.MouthGuard);
        this.Helm.addChild(this.Visor);
        
        this.bipedHead = Helm;
        this.bipedHeadwear.isHidden = true;
        
        this.MouthGuard_Closed.isHidden = true;
        this.MouthGuard_Open.isHidden = true;
        this.Visor_Closed.isHidden = true;
        this.Visor_Open.isHidden = true;
    }
    
    @Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
    	
    	visor = ArmorTagUtil.getVisor(stack);
    	visorTime = ArmorTagUtil.getVisorTime(stack) + 0.1f;
    	ArmorTagUtil.setVisorTime(stack, visorTime);
    	
    	if(visorTime < 0)
    		visorTime = 0;
    	if(visorTime > 1)
    		visorTime = 1;
    	
    	if(visor)
    	{
    		//required since the armor model is reset per frame
    		this.lerpModel(Visor, Visor_Open, 1);
    		this.lerpModel(MouthGuard, MouthGuard_Open, 1);
    		
    		this.lerpModel(Visor, Visor_Closed, visorTime);
    		this.lerpModel(MouthGuard, MouthGuard_Closed, visorTime);
    	}
    	else
    	{
    		this.lerpModel(Visor, Visor_Open, visorTime);
    		this.lerpModel(MouthGuard, MouthGuard_Open, visorTime);
    	}
    	
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
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
