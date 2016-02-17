package lance5057.tDefense.armor.renderers.light;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersChausses extends ModelBiped {
    public ModelRenderer LegL;
    public ModelRenderer FrontL;
    public ModelRenderer HipGuardL;
    public ModelRenderer HipGuardR;
    public ModelRenderer LegR;
    public ModelRenderer BackL;
    public ModelRenderer FrontR;
    public ModelRenderer BackR;
    
    public String[] colors;
    
    public String[] textures;
    public String defaultFolder;

    public ModelTinkersChausses(String[] colors, String defaultFolder, String[] textures) {
    	super(1.1f, 0, 64,64);
    	
        this.textureWidth = 64;
        this.textureHeight = 64;
        
        this.colors = colors;
    	this.textures = textures;
    	this.defaultFolder = defaultFolder;
    	
        this.HipGuardR = new ModelRenderer(this, 10, 37);
        this.HipGuardR.setRotationPoint(0F, 0F, 0F);
        this.HipGuardR.addBox(-2.5F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
        this.setRotateAngle(HipGuardR, 0.0F, 0.0F, 0.17453292519943295F);
        this.bipedRightLeg.addChild(this.HipGuardR);
        
        this.LegL = new ModelRenderer(this, 0, 48);
        this.LegL.setRotationPoint(0F, 0F, 0F);
        this.LegL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedLeftLeg.addChild(this.LegL);
        
        this.BackR = new ModelRenderer(this, 0, 40);
        this.BackR.setRotationPoint(0F, 0F, 0F);
        this.BackR.addBox(-0.1F, 0.0F, 1.7F, 4, 7, 1, 0.01F);
        this.bipedRightLeg.addChild(this.BackR);
        
        this.FrontL = new ModelRenderer(this, 0, 40);
        this.FrontL.setRotationPoint(0F, 0F, 0F);
        this.FrontL.addBox(-4.0F, 0.0F, -2.7F, 4, 7, 1, 0.0F);
        this.bipedLeftLeg.addChild(this.FrontL);
        
        this.LegR = new ModelRenderer(this, 0, 48);
        this.LegR.setRotationPoint(0F, 0F, 0F);
        this.LegR.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedRightLeg.addChild(this.LegR);
        
        this.BackL = new ModelRenderer(this, 0, 40);
        this.BackL.setRotationPoint(0F, 0F, 0F);
        this.BackL.addBox(-4.0F, 0.0F, 1.7F, 4, 7, 1, 0.0F);
        this.bipedLeftLeg.addChild(this.BackL);
        
        this.FrontR = new ModelRenderer(this, 0, 40);
        this.FrontR.setRotationPoint(0F, 0F, 0F);
        this.FrontR.addBox(-0.1F, 0.0F, -2.7F, 4, 7, 1, 0.01F);
        this.bipedRightLeg.addChild(this.FrontR);
        
        this.HipGuardL = new ModelRenderer(this, 10, 37);
        this.HipGuardL.mirror = true;
        this.HipGuardL.setRotationPoint(0F, 0F, 0F);
        this.HipGuardL.addBox(-1.5F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
        this.setRotateAngle(HipGuardL, 0.0F, 0.0F, -0.17453292519943295F);
        this.bipedLeftLeg.addChild(this.HipGuardL);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	GL11.glPushMatrix();
    	for(int i = 0; i<2; i++)
    	{
	    	GL11.glPushMatrix();
	    	
	        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("tinkersdefense:textures/" + defaultFolder + "/" + textures[i] + ".png"));
	    	
	        float size =1.5f;
	        GL11.glScalef(1.0F / size, 1.0F / size, 1.0F / size);
            GL11.glTranslatef(0F, -1F*f5, -0F);
	    			
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
