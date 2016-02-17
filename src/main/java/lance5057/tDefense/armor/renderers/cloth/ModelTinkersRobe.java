package lance5057.tDefense.armor.renderers.cloth;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * ClothRobes - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelTinkersRobe extends ModelBiped {
    public ModelRenderer Left;
    public ModelRenderer Right;
    public ModelRenderer RightBack;
    public ModelRenderer LeftFront;
    public ModelRenderer RightFront;
    public ModelRenderer Belt;
    public ModelRenderer LeftBack;
    
    public String[] colors;
    
    public String[] textures;
    public String defaultFolder;

    public ModelTinkersRobe(String[] colors, String defaultFolder, String[] textures) 
    {
    	super(1f, 0, 64,64);
    	
    	this.colors = colors;
    	this.textures = textures;
    	this.defaultFolder = defaultFolder;
    	
        this.textureWidth = 64;
        this.textureHeight = 64;
        
        this.Right = new ModelRenderer(this, 18, 41);
        this.Right.mirror = true;
        this.Right.setRotationPoint(0F, 0F, 0F);
        this.Right.addBox(-2.5F, 0.0F, -2.5F, 6, 11, 5, 0.01F);
        this.setRotateAngle(Right, 0.0F, 0.0F, 0.08726646259971647F);
        this.bipedRightLeg.addChild(this.Right);
        
        this.RightBack = new ModelRenderer(this, 40, 43);
        this.RightBack.mirror = true;
        this.RightBack.setRotationPoint(0F, 0F, 0F);
        this.RightBack.addBox(-2.5F, 0.27F, -0.6F, 6, 11, 3, 0.0F);
        this.setRotateAngle(RightBack, 0.2617993877991494F, 0.0F, 0.08726646259971647F);
        this.bipedRightLeg.addChild(this.RightBack);
        
        this.LeftBack = new ModelRenderer(this, 40, 43);
        this.LeftBack.setRotationPoint(0F, 0F, 0F);
        this.LeftBack.addBox(-3.5F, 0.27F, -0.6F, 6, 11, 3, 0.0F);
        this.setRotateAngle(LeftBack, 0.2617993877991494F, 0.0F, -0.08726646259971647F);
        this.bipedLeftLeg.addChild(this.LeftBack);
        
        this.Belt = new ModelRenderer(this, 0, 32);
        this.Belt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Belt.addBox(-6.8F, 10.0F, -3.0F, 10, 3, 6, 0.0F);
        this.setRotateAngle(Belt, 0.0F, 0.0F, -0.13962634015954636F);
        this.bipedBody.addChild(this.Belt);
        
        this.Left = new ModelRenderer(this, 18, 41);
        this.Left.setRotationPoint(0F, 0F, 0F);
        this.Left.addBox(-3.5F, 0.0F, -2.5F, 6, 11, 5, 0.01F);
        this.setRotateAngle(Left, 0.0F, 0.0F, -0.08726646259971647F);
        this.bipedLeftLeg.addChild(this.Left);
        
        this.LeftFront = new ModelRenderer(this, 0, 43);
        this.LeftFront.setRotationPoint(0F, 0F, 0F);
        this.LeftFront.addBox(-3.5F, 0.27F, -2.4F, 6, 11, 3, 0.0F);
        this.setRotateAngle(LeftFront, -0.2617993877991494F, 0.0F, -0.08726646259971647F);
        this.bipedLeftLeg.addChild(this.LeftFront);
        
        this.RightFront = new ModelRenderer(this, 0, 43);
        this.RightFront.mirror = true;
        this.RightFront.setRotationPoint(0F, 0F, 0F);
        this.RightFront.addBox(-2.5F, 0.27F, -2.4F, 6, 11, 3, 0.0F);
        this.setRotateAngle(RightFront, -0.2617993877991494F, 0.0F, 0.08726646259971647F);
        this.bipedRightLeg.addChild(this.RightFront);
        
        //this.bipedBody.isHidden = true;
        this.bipedHead.isHidden = true;
        this.bipedHeadwear.isHidden = true;
        //this.bipedRightLeg.isHidden = true;
        //this.bipedLeftLeg.isHidden = true;
        this.bipedRightArm.isHidden = true;
        this.bipedLeftArm.isHidden = true;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	GL11.glPushMatrix();
    	for(int i = 0; i<2; i++)
    	{
	    	GL11.glPushMatrix();
	    	
	        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("tinkersdefense:textures/" + defaultFolder + "/" + textures[i] + ".png"));
	    	
	        float size = 1.45f;
	        GL11.glScalef(1.0F / size, 1.0F / size, 1.0F / size);
            GL11.glTranslatef(0F, -1.5F*f5, -0F);
	    			
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
