package lance5057.tDefense.core.renderer;

import lance5057.tDefense.core.entity.EntityHookshotHook;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class HookRenderer extends Render
{
	ResourceLocation	head	= new ResourceLocation(
										"tinkersdefense:textures/entity/swordhead.png");
	ResourceLocation	chain	= new ResourceLocation(
										"tinkersdefense:textures/entity/chain.png");

	public HookRenderer()
	{

	}

	@Override
	public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		drawHook(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
		drawChain(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	}

	void drawHook(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		bindEntityTexture(p_76986_1_);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) p_76986_2_, (float) p_76986_4_, (float) p_76986_6_);
		GL11.glRotatef(p_76986_1_.prevRotationYaw + (p_76986_1_.rotationYaw - p_76986_1_.prevRotationYaw) * p_76986_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(p_76986_1_.prevRotationPitch + (p_76986_1_.rotationPitch - p_76986_1_.prevRotationPitch) * p_76986_9_, 0.0F, 0.0F, 1.0F);
		final Tessellator tessellator = Tessellator.instance;
		final float f2 = 0.0F;
		final float f3 = 1.0F;
		final float f10 = 0.5F;
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(f10, f10, f10);
		for(int i = 0; i < 4; ++i)
		{
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f10);
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-1.0D, -1.0D, 0.0D, f2, f2);
			tessellator.addVertexWithUV(1.0D, -1.0D, 0.0D, f2, f3);
			tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, f3, f3);
			tessellator.addVertexWithUV(-1.0D, 1.0D, 0.0D, f3, f2);
			tessellator.draw();
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	void drawChain(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		final EntityHookshotHook hook = (EntityHookshotHook) p_76986_1_;
		final EntityPlayer player = hook.worldObj.getPlayerEntityByName(hook.getPlayer());

		final float f2 = 0;
		float f3 = MathHelper.sin(f2 * 0.2F) / 2.0F + 0.5F;
		f3 = (f3 * f3 + f3) * 0.2F;
		final float f4 = (float) (player.posX - p_76986_1_.posX - (p_76986_1_.prevPosX - p_76986_1_.posX) * (1.0F - p_76986_9_));
		final float f5 = (float) (f3 + player.posY - 1.0D - p_76986_1_.posY - (p_76986_1_.prevPosY - p_76986_1_.posY) * (1.0F - p_76986_9_));
		final float f6 = (float) (player.posZ - p_76986_1_.posZ - (p_76986_1_.prevPosZ - p_76986_1_.posZ) * (1.0F - p_76986_9_));
		final float f7 = MathHelper.sqrt_float(f4 * f4 + f6 * f6);
		final float f8 = MathHelper.sqrt_float(f4 * f4 + f5 * f5 + f6 * f6);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) p_76986_2_, (float) p_76986_4_, (float) p_76986_6_);
		GL11.glRotatef((float) (-Math.atan2(f6, f4)) * 180.0F / (float) Math.PI - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef((float) (-Math.atan2(f7, f5)) * 180.0F / (float) Math.PI - 90.0F, 1.0F, 0.0F, 0.0F);
		final Tessellator tessellator = Tessellator.instance;
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL11.GL_CULL_FACE);
		bindTexture(chain);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		final float f9 = 0.0F - (f8) * 0.1F;
		final float f10 = MathHelper.sqrt_float(f4 * f4 + f5 * f5 + f6 * f6) / 32.0F - (p_76986_1_.ticksExisted + p_76986_9_) * 0.01F;

		GL11.glScalef(0.5f, 0.5f, 1);
		for(int j = 0; j < 2; j++)
		{
			tessellator.startDrawing(5);
			final byte b0 = 2;
			GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
			for(int i = 0; i < b0; ++i)
			{

				final float f11 = MathHelper.sin(i % b0 * (float) Math.PI * 2.0F / b0) * 0.75F;
				final float f12 = MathHelper.cos(i % b0 * (float) Math.PI * 2.0F / b0) * 0.75F;
				final float f13 = i % b0 * 1.0F / b0;
				tessellator.addVertexWithUV(f11, f12, 0.0D, 0, 0);
				tessellator.addVertexWithUV(f11, f12, f8, 0, f9);
				tessellator.addVertexWithUV(f11, f12, 0.0D, 1, 0);
				tessellator.addVertexWithUV(f11, f12, f8, 1, f9);
			}
			tessellator.draw();
		}

		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glShadeModel(GL11.GL_FLAT);
		RenderHelper.enableStandardItemLighting();
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		// TODO Auto-generated method stub
		return head;
	}
}
