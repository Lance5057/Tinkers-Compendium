package lance5057.tDefense.core.library;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import jline.internal.Log;
import lance5057.tDefense.Reference;
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
public class ArmorTextureBuilder
{
	@SideOnly(Side.CLIENT)
	public static ResourceLocation createArmorTexture(String type, String[] parts, List<Material> materials)
	{
		List<BufferedImage> looseTex = new ArrayList<BufferedImage>();

		TextureMap map = Minecraft.getMinecraft().getTextureMapBlocks();

		for (int i = 0; i < materials.size(); i++)
		{
			String s;
			BufferedImage bi = null;
			if (materials.get(i).renderInfo instanceof MaterialRenderInfo.Default)
			{
				MaterialRenderInfo.Default render = (MaterialRenderInfo.Default)materials.get(i).renderInfo;
				s = String.format("tinkerscompendium:armor/%s/_%s_%s", type, type, parts[i]);
				TextureAtlasSprite tex = map.getTextureExtry(s);
				bi = new BufferedImage(tex.getIconWidth(), tex.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
				
				Graphics2D g2d = bi.createGraphics();
				int vert = render.getVertexColor();
				Color c = new Color(vert);
				g2d.drawImage(createBufferedImage(tex), 0, 0, null);
				g2d.setPaint(c);  
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.9f));
				g2d.fillRect(0, 0, tex.getIconWidth(), tex.getIconHeight());
				
				g2d.dispose(); 
				
			} else
			{
				s = String.format("tinkerscompendium:armor/%s/_%s_%s_%s", type, type, parts[i], materials.get(i).identifier);
				bi = createBufferedImage(map.getTextureExtry(s));
			}

			if (bi != null)
				looseTex.add(bi);
			else
				Log.error(s + " not found!");
		}

		if (looseTex.size() != 0)
		{
			BufferedImage fullTex = new BufferedImage(looseTex.get(0).getWidth(), looseTex.get(0).getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g2d = fullTex.createGraphics();

			for (BufferedImage tex : looseTex)
				g2d.drawImage(tex, 0, 0, null);
			g2d.dispose();

			return Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation(Reference.MOD_ID, new DynamicTexture(fullTex));
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
	private static BufferedImage createBufferedImage(TextureAtlasSprite sprite)
	{
		if (sprite != null)
		{
			int w = sprite.getIconWidth();
			int h = sprite.getIconHeight();
			int count = sprite.getFrameCount();

			BufferedImage buff = new BufferedImage(w, h * count, BufferedImage.TYPE_4BYTE_ABGR);

			for (int i = 0; i < count; i++)
			{
				buff.setRGB(0, i * h, w, h, sprite.getFrameTextureData(i)[0], 0, w);
			}

			return buff;
		}
		return null;
	}
}
