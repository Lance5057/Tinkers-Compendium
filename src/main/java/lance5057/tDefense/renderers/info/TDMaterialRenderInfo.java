package lance5057.tDefense.renderers.info;

import lance5057.tDefense.renderers.AlphaColorTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;

public interface TDMaterialRenderInfo {

	  TextureAtlasSprite getTexture(ResourceLocation baseTexture, String location);

	  boolean isStitched();

	  boolean useVertexColoring();

	  int getVertexColor();

	  // this actually would require its own thing, but we put it here for simplicity
	  String getTextureSuffix();

	  MaterialRenderInfo setTextureSuffix(String suffix);

	  abstract class AbstractMaterialRenderInfo implements MaterialRenderInfo {

	    private String suffix;

	    @Override
	    public boolean isStitched() {
	      return true;
	    }

	    @Override
	    public boolean useVertexColoring() {
	      return false;
	    }

	    @Override
	    public int getVertexColor() {
	      return 0xffffffff; // white and opaque
	    }

	    @Override
	    public String getTextureSuffix() {
	      return suffix;
	    }

	    @Override
	    public MaterialRenderInfo setTextureSuffix(String suffix) {
	      this.suffix = suffix;
	      return this;
	    }
	  }

	  class AlphaColor extends AbstractMaterialRenderInfo {

		    public final int color;

		    public AlphaColor(int color) {
		      this.color = color;
		    }

		    @Override
		    public TextureAtlasSprite getTexture(ResourceLocation baseTexture, String location) {
		      return new AlphaColorTexture(color, color, color, baseTexture, location);
		    }

		    @Override
		    public boolean isStitched() {
		      return false;
		    }

		    @Override
		    public boolean useVertexColoring() {
		      return true;
		    }

		    @Override
		    public int getVertexColor() {
		      return color;
		    }
		  }
}
