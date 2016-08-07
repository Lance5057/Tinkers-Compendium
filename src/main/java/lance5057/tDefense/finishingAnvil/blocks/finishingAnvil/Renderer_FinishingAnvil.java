package lance5057.tDefense.finishingAnvil.blocks.finishingAnvil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class Renderer_FinishingAnvil extends TileEntitySpecialRenderer
{
	private final ModelFinishingAnvil	model;

	public Renderer_FinishingAnvil()
	{
		model = new ModelFinishingAnvil();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{

		GL11.glPushMatrix();

		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		final ResourceLocation textures = (new ResourceLocation(
				"tinkersdefense:textures/blocks/armoranvil.png"));

		Minecraft.getMinecraft().renderEngine.bindTexture(textures);

		GL11.glPushMatrix();

		te.getBlockMetadata();

		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

	}

}
