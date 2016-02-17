package lance5057.tDefense.armor.renderers.cloth;

import lance5057.tDefense.TinkersDefense;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersShawl extends ModelBiped {
    public ModelRenderer ShawlLeft1;
    public ModelRenderer ShawlLeft2;
    public ModelRenderer ShawlRight1;
    public ModelRenderer ShawlRight2;
    public ModelRenderer Button;
    public ModelRenderer TopLeft;
    public ModelRenderer TopRight;
    public ModelRenderer ArmLeft;
    public ModelRenderer ArmRight;
    public ModelRenderer Chest;
    
    public String[] colors;
    
    public String[] textures;
    public String defaultFolder;

    public ModelTinkersShawl(String[] colors, String defaultFolder, String[] textures)
    {
    	super(1f, 0, 64,64);
    	
    	this.colors = colors;
    	this.textures = textures;
    	this.defaultFolder = defaultFolder;
    	
        this.textureWidth = 64;
        this.textureHeight = 64;
        
        this.ArmLeft = new ModelRenderer(this, 48, 48);
        this.ArmLeft.mirror = true;
        this.ArmLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmLeft.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedLeftArm.addChild(this.ArmLeft);
        
        this.ArmRight = new ModelRenderer(this, 48, 48);
        this.ArmRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmRight.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedRightArm.addChild(this.ArmRight);
        
        this.Chest = new ModelRenderer(this, 40, 32);
        this.Chest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Chest.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.bipedBody.addChild(this.Chest);
        
        this.TopRight = new ModelRenderer(this, 0, 52);
        this.TopRight.mirror = true;
        this.TopRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TopRight.addBox(-3.5F, -2.3F, -3.0F, 9, 3, 6, -0.01F);
        this.bipedRightArm.addChild(this.TopRight);
        
        this.Button = new ModelRenderer(this, 0, 61);
        this.Button.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Button.addBox(0.0F, 0.0F, -3.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(Button, 0.0F, 0.0F, 0.7853981633974483F);
        this.bipedBody.addChild(this.Button);
        
        this.TopLeft = new ModelRenderer(this, 0, 52);
        this.TopLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TopLeft.addBox(-5.5F, -2.3F, -3.0F, 9, 3, 6, -0.01F);
        this.bipedLeftArm.addChild(this.TopLeft);
        
        this.ShawlRight1 = new ModelRenderer(this, 0, 32);
        this.ShawlRight1.mirror = true;
        this.ShawlRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShawlRight1.addBox(-4.0F, -1.3F, -3.0F, 6, 5, 6, 0.0F);
        this.setRotateAngle(ShawlRight1, 0.0F, 0.0F, 0.2617993877991494F);
        this.bipedRightArm.addChild(this.ShawlRight1);
        
        this.ShawlRight2 = new ModelRenderer(this, 0, 43);
        this.ShawlRight2.mirror = true;
        this.ShawlRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShawlRight2.addBox(-1.9F, 0.8F, -3.0F, 6, 3, 6, 0.01F);
        this.setRotateAngle(ShawlRight2, 0.0F, 0.0F, -0.6981317007977318F);
        this.bipedRightArm.addChild(this.ShawlRight2);
        
        this.ShawlLeft1 = new ModelRenderer(this, 0, 32);
        this.ShawlLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShawlLeft1.addBox(-2.0F, -1.3F, -3.0F, 6, 5, 6, 0.0F);
        this.setRotateAngle(ShawlLeft1, 0.0F, 0.0F, -0.2617993877991494F);
        this.bipedLeftArm.addChild(this.ShawlLeft1);
        
        this.ShawlLeft2 = new ModelRenderer(this, 0, 43);
        this.ShawlLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShawlLeft2.addBox(-4.1F, 0.8F, -3.0F, 6, 3, 6, 0.1F);
        this.setRotateAngle(ShawlLeft2, 0.0F, 0.0F, 0.6981317007977318F);
        this.bipedLeftArm.addChild(this.ShawlLeft2);
        
        this.bipedHead.isHidden = true;
        this.bipedHeadwear.isHidden = true;
        this.bipedCloak.isHidden = true;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	GL11.glPushMatrix();
    	for(int i = 0; i<3; i++)
    	{
	    	GL11.glPushMatrix();
	    	
	        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("tinkersdefense:textures/" + defaultFolder + "/" + textures[i] + ".png"));
	    	
	        float size = 1.5f;
	        GL11.glScalef(1.0F / size, 1.0F / size, 1.0F / size);
            GL11.glTranslatef(0F, -0F*f5, -0F);
	    			
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
