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
public class ModelTinkersBoots extends ModelBiped
{
    public ModelRenderer LegR;
    public ModelRenderer LegL;
    public ModelRenderer FootL;
    public ModelRenderer FootR;
    
    public String[] colors;
    
    public String[] textures;
    public String defaultFolder;

    public ModelTinkersBoots(String[] colors, String defaultFolder, String[] textures) {
    	super(1.1f, 0, 64,64);
    	
        this.textureWidth = 64;
        this.textureHeight = 64;
        
        this.colors = colors;
    	this.textures = textures;
    	this.defaultFolder = defaultFolder;
    	
        this.FootL = new ModelRenderer(this, 0, 43);
        this.FootL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootL.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.0F);
        this.bipedLeftLeg.addChild(this.FootL);
        
        this.LegL = new ModelRenderer(this, 0, 48);
        this.LegL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedLeftLeg.addChild(this.LegL);
        
        this.FootR = new ModelRenderer(this, 0, 43);
        this.FootR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FootR.addBox(-2.0F, 10.0F, -3.0F, 4, 2, 1, 0.0F);
        this.bipedRightLeg.addChild(this.FootR);
        
        this.LegR = new ModelRenderer(this, 0, 48);
        this.LegR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegR.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedRightLeg.addChild(this.LegR);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	GL11.glPushMatrix();
    	for(int i = 0; i<3; i++)
    	{
	    	GL11.glPushMatrix();
	    	
	        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("tinkersdefense:textures/" + defaultFolder + "/" + textures[i] + ".png"));
	    	
	        float size =1.45f;
	        GL11.glScalef(1.0F / size, 1.0F / size, 1.0F / size);
            GL11.glTranslatef(0.0F, -1F*f5, 0.0F);
	    			
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
