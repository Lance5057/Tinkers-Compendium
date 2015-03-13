package gmail.Lance5057.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class Renderer_JewelersBench extends TileEntitySpecialRenderer
{
	private final ModelJewelersBench model;
	
	public Renderer_JewelersBench() {
        this.model = new ModelJewelersBench();
}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

        ResourceLocation textures = (new ResourceLocation("tinkersdefense:textures/blocks/JewelersBench.png"));
        
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);

        GL11.glPushMatrix();

        int meta = te.getBlockMetadata();
        
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
		
	}

}
