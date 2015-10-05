package lance5057.tDefense.armor.renderers;

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
public class ModelSheath extends ModelBiped {
    public ModelRenderer sheath;
    public ModelRenderer belt;
    
    String Color[];
    int rgbColors[];

    public ModelSheath(String color[] /*4*/) {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.belt = new ModelRenderer(this, 16, 0);
        this.belt.setRotationPoint(-4.5F, 0.0F, 0.5F);
        this.belt.addBox(0.0F, 0.0F, -3.0F, 1, 12, 5, 0.0F);
        this.setRotateAngle(belt, 0.0F, 0.0F, -0.7853981633974483F);
        this.sheath = new ModelRenderer(this, 0, 0);
        this.sheath.setRotationPoint(-0.3F, 3.5F, 2.0F);
        this.sheath.addBox(-3.0F, 0.0F, 0.0F, 6, 24, 2, 0.0F);
        this.setRotateAngle(sheath, 0.0F, 0.0F, -0.45F);
        
        Color = color;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
    GL11.glPushMatrix();
    	
    //Sheath Base
        GL11.glPushMatrix();
	        rgbColors = TinkersDefense.hexToRGB(Color[1]);
	    	GL11.glColor3d((float)rgbColors[0]/255, (float)rgbColors[1]/255, (float)rgbColors[2]/255);
	    	
	        GL11.glTranslatef(this.sheath.offsetX, this.sheath.offsetY, this.sheath.offsetZ);
	        GL11.glTranslatef(this.sheath.rotationPointX * f5, this.sheath.rotationPointY * f5, this.sheath.rotationPointZ * f5);
	        GL11.glScaled(0.65D, 0.65D, 0.5D);
	        GL11.glTranslatef(-this.sheath.offsetX, -this.sheath.offsetY, -this.sheath.offsetZ);
	        GL11.glTranslatef(-this.sheath.rotationPointX * f5, -this.sheath.rotationPointY * f5, -this.sheath.rotationPointZ * f5);
	        
	        this.sheath.render(f5);
        GL11.glPopMatrix();
        
        //Belt
        GL11.glPushMatrix();
	        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("tinkersdefense:textures/armor/Sheath/_sheath_belt.png"));
	
	    	rgbColors = TinkersDefense.hexToRGB(Color[2]);
	    	GL11.glColor3d((float)rgbColors[0]/255, (float)rgbColors[1]/255, (float)rgbColors[2]/255);
	    	
	        this.belt.render(f5);
        GL11.glPopMatrix();
        
        //Buckle
        GL11.glPushMatrix();
	        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("tinkersdefense:textures/armor/Sheath/_sheath_clasp.png"));
	
	        rgbColors = TinkersDefense.hexToRGB(Color[3]);
	    	GL11.glColor3d((float)rgbColors[0]/255, (float)rgbColors[1]/255, (float)rgbColors[2]/255);
	       
	    	this.belt.render(f5);
        GL11.glPopMatrix();
        
        //Filigree
        GL11.glPushMatrix();
        	FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("tinkersdefense:textures/armor/Sheath/_sheath_filigree.png"));

        	rgbColors = TinkersDefense.hexToRGB(Color[0]);
	    	GL11.glColor3d((float)rgbColors[0]/255, (float)rgbColors[1]/255, (float)rgbColors[2]/255);
        	
	        GL11.glTranslatef(this.sheath.offsetX, this.sheath.offsetY, this.sheath.offsetZ);
	        GL11.glTranslatef(this.sheath.rotationPointX * f5, this.sheath.rotationPointY * f5, this.sheath.rotationPointZ * f5);
	        GL11.glScaled(0.65D, 0.65D, 0.5D);
	        GL11.glTranslatef(-this.sheath.offsetX, -this.sheath.offsetY, -this.sheath.offsetZ);
	        GL11.glTranslatef(-this.sheath.rotationPointX * f5, -this.sheath.rotationPointY * f5, -this.sheath.rotationPointZ * f5);
	        
	        this.sheath.render(f5);
        GL11.glPopMatrix();
        
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
