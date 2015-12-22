package lance5057.tDefense.armor.renderers.heavy;

import java.io.File;

import lance5057.tDefense.TinkersDefense;

import org.lwjgl.opengl.GL11;

import tconstruct.library.TConstructRegistry;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersSabatons extends ModelBiped
{
    public ModelRenderer BootL;
    public ModelRenderer KneeGuardR;
    public ModelRenderer ShinGuardL;
    public ModelRenderer KneeGuardCapL;
    public ModelRenderer LegBackL;
    public ModelRenderer BootR;
    public ModelRenderer ShinGuardR;
    public ModelRenderer BootCapR;
    public ModelRenderer BootCapL;
    public ModelRenderer LegBackR;
    public ModelRenderer KneeGuardL;
    public ModelRenderer KneeGuardCapR;

   public String[] colors;
    
    public String[] textures;
    public String defaultFolder;

    public ModelTinkersSabatons(String[] colors, String defaultFolder, String[] textures) 
    {
    	super(1f, 0, 64,64);
    	
    	this.colors = colors;
    	this.textures = textures;
    	this.defaultFolder = defaultFolder;
    	
        this.textureWidth = 64;
        this.textureHeight = 64;
        
        this.ShinGuardL = new ModelRenderer(this, 0, 48);
        this.ShinGuardL.mirror = true;
        this.ShinGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShinGuardL.addBox(-2.0F, 4.0F, -2.6F, 4, 5, 3, 0.11F);
        this.setRotateAngle(ShinGuardL, 0.05759586531581287F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(this.ShinGuardL);
        
        this.KneeGuardL = new ModelRenderer(this, 6, 32);
        this.KneeGuardL.mirror = true;
        this.KneeGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.KneeGuardL.addBox(-2.0F, 3.0F, -2.5F, 4, 3, 4, 0.2F);
        this.bipedLeftLeg.addChild(this.KneeGuardL);
        		
        this.BootL = new ModelRenderer(this, 0, 56);
        this.BootL.mirror = true;
        this.BootL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BootL.addBox(-2.0F, 9.0F, -3.0F, 4, 3, 5, 0.2F);
        this.bipedLeftLeg.addChild(this.BootL);
        
        this.KneeGuardCapL = new ModelRenderer(this, 0, 37);
        this.KneeGuardCapL.mirror = true;
        this.KneeGuardCapL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.KneeGuardCapL.addBox(-1.0F, 2.4F, -3.0F, 2, 2, 1, 0.2F);
        this.bipedLeftLeg.addChild(this.KneeGuardCapL);
        		
        this.KneeGuardR = new ModelRenderer(this, 6, 32);
        this.KneeGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.KneeGuardR.addBox(-2.0F, 3.0F, -2.5F, 4, 3, 4, 0.2F);
        this.bipedRightLeg.addChild(this.KneeGuardR);
        
        this.LegBackL = new ModelRenderer(this, 0, 40);
        this.LegBackL.mirror = true;
        this.LegBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegBackL.addBox(-2.0F, 3.0F, -2.6F, 4, 6, 2, 0.1F);
        this.setRotateAngle(LegBackL, 0.05759586531581287F, 3.141592653589793F, 0.0F);
        this.bipedLeftLeg.addChild(this.LegBackL);
        		
        this.BootCapL = new ModelRenderer(this, 0, 33);
        this.BootCapL.mirror = true;
        this.BootCapL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BootCapL.addBox(-1.0F, 9.1F, -5.2F, 2, 2, 1, 0.2F);
        this.setRotateAngle(BootCapL, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedLeftLeg.addChild(this.BootCapL);
        		
        this.KneeGuardCapR = new ModelRenderer(this, 0, 37);
        this.KneeGuardCapR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.KneeGuardCapR.addBox(-1.0F, 2.4F, -3.0F, 2, 2, 1, 0.2F);
        this.bipedRightLeg.addChild(this.KneeGuardCapR);
        
        this.BootR = new ModelRenderer(this, 0, 56);
        this.BootR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BootR.addBox(-2.0F, 9.0F, -3.0F, 4, 3, 5, 0.2F);
        this.bipedRightLeg.addChild(this.BootR);
        
        this.ShinGuardR = new ModelRenderer(this, 0, 48);
        this.ShinGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShinGuardR.addBox(-2.0F, 4.0F, -2.6F, 4, 5, 3, 0.11F);
        this.setRotateAngle(ShinGuardR, 0.05759586531581287F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(this.ShinGuardR);
        
        this.LegBackR = new ModelRenderer(this, 0, 40);
        this.LegBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegBackR.addBox(-2.0F, 3.0F, -2.6F, 4, 6, 2, 0.1F);
        this.setRotateAngle(LegBackR, 0.05759586531581287F, 3.141592653589793F, 0.0F);
        this.bipedRightLeg.addChild(this.LegBackR);
        
        this.BootCapR = new ModelRenderer(this, 0, 33);
        this.BootCapR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BootCapR.addBox(-1.0F, 9.1F, -5.2F, 2, 2, 1, 0.2F);
        this.setRotateAngle(BootCapR, 0.17453292519943295F, 0.0F, 0.0F);
        this.bipedRightLeg.addChild(this.BootCapR);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	GL11.glPushMatrix();
    	
    	for(int i = 0; i<4; i++)
    	{
    		//TConstructRegistry.getCustomMaterial(arg0, arg1)
	    	GL11.glPushMatrix();
	    	ResourceLocation texture = new ResourceLocation("tinkersdefense:textures/" + defaultFolder + "/" + textures[i] + ".png");
	    	//Boolean exists = new File(texture.getResourceDomain() + ":" + texture.getResourcePath()).exists();
	        FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
	        
	    	
	        float size =0.75f;
	        GL11.glScalef(1.0F / size, 1.0F / size, 1.0F / size);
            GL11.glTranslatef(0.0F, -12.4F*f5, 0.0F);
	    			
	    	int[] intColors = TinkersDefense.hexToRGB(colors[i]);
	    	GL11.glColor3d((float)intColors[0]/255, (float)intColors[1]/255, (float)intColors[2]/255);
	
	    	super.render(entity, f, f1, f2, f3, f4, f5);
	    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    	GL11.glPopMatrix();
    	}
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
