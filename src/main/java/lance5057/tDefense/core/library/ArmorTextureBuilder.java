package lance5057.tDefense.core.library;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TCConfig.Materials;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.materials.Material;

@SideOnly(Side.CLIENT)
public class ArmorTextureBuilder {
	@SideOnly(Side.CLIENT)
	public static ResourceLocation createArmorTexture(String type, String[] parts, List<Material> materials, int width, int height) {
		List<BufferedImage> looseTex = new ArrayList<BufferedImage>();

		TextureMap map = Minecraft.getMinecraft().getTextureMapBlocks();

		for (int i = 0; i < materials.size(); i++) {
			String s;
			BufferedImage bi = null;
			if (materials.get(i).renderInfo.useVertexColoring()) {
				MaterialRenderInfo.Default render = (MaterialRenderInfo.Default) materials.get(i).renderInfo;
				s = String.format("tinkerscompendium:armor/%s/_%s_%s", type, type, parts[i]);
				TextureAtlasSprite tex = map.getTextureExtry(s);
				bi = new BufferedImage(tex.getIconWidth(), tex.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);

				Graphics2D g2d = bi.createGraphics();
				int vert = render.getVertexColor();

				bi = createBufferedImage(tex);
				colorizeBufferedImage(bi, vert);

			} else {
				s = String.format("tinkerscompendium:armor/%s/_%s_%s_%s", type, type, parts[i],
						materials.get(i).identifier);
				bi = createBufferedImage(map.getTextureExtry(s));
			}

			if (bi != null)
				looseTex.add(bi);
//			else
//				Log.error(s + " not found!");
		}

		if (looseTex.size() != 0) {
			BufferedImage fullTex = new BufferedImage(width, height,
					BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g2d = fullTex.createGraphics();

			for (BufferedImage tex : looseTex)
				g2d.drawImage(tex, 0, 0, null);
			g2d.dispose();

			String texName = Reference.MOD_ID + "_" + type;
			for (Material m : materials) {
				texName += "_" + m.identifier;
			}

			return Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation(texName,
					new DynamicTexture(fullTex));
		}
		return null;
	}
	
	private static void getDefaultSize()
	{
		
	}

	private static void colorizeBufferedImage(BufferedImage bi, int color) {
		int a = (color >> 24);
		if (a == 0) {
			a = 255;
		}
		int r = (color >> 16) & 0xFF;
		int g = (color >> 8) & 0xFF;
		int b = (color) & 0xFF;
		float R = (float) r / 255f;
		float G = (float) g / 255f;
		float B = (float) b / 255f;
		float A = (float) a / 255f;

		for (int k = 0; k < bi.getWidth(); k++) {
			for (int l = 0; l < bi.getHeight(); l++) {
				int ax = bi.getColorModel().getAlpha(bi.getRaster().getDataElements(k, l, null));
				int rx = bi.getColorModel().getRed(bi.getRaster().getDataElements(k, l, null));
				int gx = bi.getColorModel().getGreen(bi.getRaster().getDataElements(k, l, null));
				int bx = bi.getColorModel().getBlue(bi.getRaster().getDataElements(k, l, null));
				rx *= R;
				gx *= G;
				bx *= B;
				ax *= A;
				bi.setRGB(k, l, (ax << 24) | (rx << 16) | (gx << 8) | (bx));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private static BufferedImage createBufferedImage(TextureAtlasSprite sprite) {
		if (sprite != null) {
			int w = sprite.getIconWidth();
			int h = sprite.getIconHeight();
			int count = sprite.getFrameCount();

			BufferedImage buff = new BufferedImage(w, h * count, BufferedImage.TYPE_4BYTE_ABGR);

			for (int j = 0; j < count; j++) {
				int[][] frameTextureData = sprite.getFrameTextureData(j);
				int[] largestMipMapTextureData = frameTextureData[0];
				buff.setRGB(0, j * h, w, h, largestMipMapTextureData, 0, w);
			}

			return buff;
		}
		return null;
	}
}
