package lance5057.tDefense.core.tools.armor.renderers.shaders;

import org.lwjgl.opengl.GL11;

import lance5057.tDefense.util.Color16Util;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;

public class ArmorShader
{
	public static void colorize(ResourceLocation r1, int color)
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(r1);

		String hex = Integer.toHexString(color);
		int[] colors;
		if(hex.length() == 8)
			colors = Color16Util.hexToRGB(hex.substring(2));
		else
			colors = Color16Util.hexToRGB(hex);
		GL11.glColor3d((float) colors[0] / 255, (float) colors[1] / 255, (float) colors[2] / 255);
	}

	public static void metalTexture(ResourceLocation r1, ResourceLocation r2, int color)
	{		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Minecraft.getMinecraft().getTextureManager().bindTexture(r1);

		int[] colors = Color16Util.hexToRGB(Integer.toHexString(color));
//		GL11.glColor3d((float) colors[0] / 255, (float) colors[1] / 255, (float) colors[2] / 255);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(r1);
		GL11.glColor4f((float) colors[0] / 255, (float) colors[1] / 255, (float) colors[2] / 255, 1.0f);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glTexCoord2f(1.0f, 1.0f);
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glEnd();
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(r2);
		GL11.glColor4f((float) colors[0] / 255, (float) colors[1] / 255, (float) colors[2] / 255, 1.0f);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glTexCoord2f(1.0f, 1.0f);
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glEnd();
	}

	public static void selectRenderer(MaterialRenderInfo info, ResourceLocation r1)
	{
		if(info instanceof MaterialRenderInfo.MetalTextured)
			metalTexture(r1,r1, ((MaterialRenderInfo.MetalTextured) info).color);
		else if(info instanceof MaterialRenderInfo.Metal)
			colorize(r1, ((MaterialRenderInfo.Metal) info).color);
		else if(info instanceof MaterialRenderInfo.MultiColor)
			colorize(r1, ((MaterialRenderInfo.MultiColor) info).getVertexColor());
		else if(info instanceof MaterialRenderInfo.InverseMultiColor)
			colorize(r1, ((MaterialRenderInfo.InverseMultiColor) info).getVertexColor());
		else
			colorize(r1, ((MaterialRenderInfo.Default) info).color);
		 
	}
}
