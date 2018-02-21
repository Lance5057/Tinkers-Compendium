package lance5057.tDefense.core.tools.armor.renderers.shaders;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import lance5057.tDefense.util.Color16Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.client.texture.TextureColoredTexture;

public class ArmorShader {

	public static BufferedImage colorize(ResourceLocation r1, int color) {
		IResourceManager manager = Minecraft.getMinecraft().getResourceManager();
		try {
			BufferedImage buff = ImageIO.read(manager.getResource(r1).getInputStream());
			BufferedImage tint = new BufferedImage(buff.getWidth(), buff.getHeight(), BufferedImage.TYPE_INT_ARGB);

			Graphics2D graphics = tint.createGraphics();

			graphics.setPaint(new Color(color));
			graphics.fillRect(0, 0, tint.getWidth(), tint.getHeight());
			graphics.dispose();

			return multiply(buff, tint);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void metalTexture(ResourceLocation r1, ResourceLocation r2, int color) {
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		Minecraft.getMinecraft().getTextureManager().bindTexture(r1);

		int[] colors = Color16Util.hexToRGB(Integer.toHexString(color));
		// glColor3d((float) colors[0] / 255, (float) colors[1] / 255, (float)
		// colors[2] / 255);

		Minecraft.getMinecraft().getTextureManager().bindTexture(r1);
		glColor4f((float) colors[0] / 255, (float) colors[1] / 255, (float) colors[2] / 255, 1.0f);
		glBegin(GL_QUADS);
		glTexCoord2f(0.0f, 0.0f);
		glTexCoord2f(1.0f, 0.0f);
		glTexCoord2f(1.0f, 1.0f);
		glTexCoord2f(0.0f, 1.0f);
		glEnd();

		Minecraft.getMinecraft().getTextureManager().bindTexture(r2);
		glColor4f((float) colors[0] / 255, (float) colors[1] / 255, (float) colors[2] / 255, 1.0f);
		glBegin(GL_QUADS);
		glTexCoord2f(0.0f, 0.0f);
		glTexCoord2f(1.0f, 0.0f);
		glTexCoord2f(1.0f, 1.0f);
		glTexCoord2f(0.0f, 1.0f);
		glEnd();
	}

	public static BufferedImage blockTexture(TextureColoredTexture sprite) {

		List<ResourceLocation> l = (List<ResourceLocation>) sprite.getDependencies();
		String s = l.get(1).toString();

		IResourceManager manager = Minecraft.getMinecraft().getResourceManager();
		if (s.contains("minecraft:")) {
			s = s.substring(s.indexOf(":") + 1);
			s = "textures/" + s + ".png";
		} else {
			s = l.get(1).getResourceDomain() + ":textures/" + l.get(1).getResourcePath() + ".png";
		}
		try {
			BufferedImage buff = ImageIO.read(manager.getResource(l.get(0)).getInputStream());
			BufferedImage buff2 = ImageIO.read(manager.getResource(new ResourceLocation(s)).getInputStream());

			return multiply(buff, buff2);
		} catch (IOException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Somethings Fucky - TinkersDefense:ArmorShader - Line 107");
		}
		return null;

	}

	public static void selectRenderer(BufferedImage b, MaterialRenderInfo info, ResourceLocation r1) {

		Graphics g = b.getGraphics();

		if (info instanceof MaterialRenderInfo.MetalTextured)
			metalTexture(r1, r1, ((MaterialRenderInfo.MetalTextured) info).color);
		else if (info instanceof MaterialRenderInfo.Metal)
			g.drawImage(colorize(r1, ((MaterialRenderInfo.Metal) info).color), 0, 0, null);
		else if (info instanceof MaterialRenderInfo.MultiColor)
			g.drawImage(colorize(r1, ((MaterialRenderInfo.MultiColor) info).getVertexColor()), 0, 0, null);
		else if (info instanceof MaterialRenderInfo.InverseMultiColor)
			g.drawImage(colorize(r1, ((MaterialRenderInfo.InverseMultiColor) info).getVertexColor()), 0, 0, null);
		else if (info instanceof MaterialRenderInfo.BlockTexture)
			g.drawImage(
					blockTexture((TextureColoredTexture) ((MaterialRenderInfo.BlockTexture) info).getTexture(r1, "")),
					0, 0, null);
		else
			g.drawImage(colorize(r1, ((MaterialRenderInfo.Default) info).color), 0, 0, null);
		
		g.dispose();

	}

	public static BufferedImage multiply(BufferedImage buff, BufferedImage buff2) {
		BufferedImage buffImg = new BufferedImage(buff.getWidth(), buff.getHeight(), BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < buff.getWidth(); i++)
			for (int j = 0; j < buff.getHeight(); j++) {
				Color c1 = new Color(buff.getRGB(i, j), true);
				int x = i % buff2.getWidth();
				int y = j % buff2.getHeight();
				Color c2 = new Color(buff2.getRGB(x, y), true);
				float r, g, b, a;
				Color out;

				// multiply here
				r = (((float) c1.getRed()) / 255) * (((float) c2.getRed()) / 255);
				g = (((float) c1.getGreen()) / 255) * (((float) c2.getGreen()) / 255);
				b = (((float) c1.getBlue()) / 255) * (((float) c2.getBlue()) / 255);

				// transparency always comes from the first buffer
				int a2 = c1.getAlpha();
				a = ((float) c1.getAlpha()) / 255;

				out = new Color(r, g, b, a);
				buffImg.setRGB(i, j, out.getRGB());
			}

		return buffImg;
	}
	
	public static BufferedImage Invert(BufferedImage buff) {
		BufferedImage buffImg = new BufferedImage(buff.getWidth(), buff.getHeight(), BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < buff.getWidth(); i++)
			for (int j = 0; j < buff.getHeight(); j++) {
				Color c1 = new Color(buff.getRGB(i, j), true);
				float r, g, b, a;
				Color out;

				// invert here
				r = Math.abs((((float) c1.getRed()) / 255) - 1.0f);
				g = Math.abs((((float) c1.getGreen()) / 255) - 1.0f);
				b = Math.abs((((float) c1.getBlue()) / 255) - 1.0f);

				// transparency always comes from the first buffer
				int a2 = c1.getAlpha();
				a = ((float) c1.getAlpha()) / 255;

				out = new Color(r, g, b, a);
				buffImg.setRGB(i, j, out.getRGB());
			}

		return buffImg;
	}
}
