package lance5057.tDefense.holiday.xmas.gumdropslime;

import lance5057.tDefense.Reference;
import lance5057.tDefense.util.Color16Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import slimeknights.tconstruct.library.client.renderer.RenderTinkerSlime;

public class GumDropSlimeRenderer extends RenderTinkerSlime
{
	public static final Factory FACTORY_GumDropSlime = new Factory();
	
	public GumDropSlimeRenderer(RenderManager renderManager) {
		super(renderManager, Color16Util.colorsHex[Minecraft.getMinecraft().world.rand.nextInt(16)],
				new ResourceLocation(Reference.MOD_ID,"textures/entity/slime.png"));
		// TODO Auto-generated constructor stub
	}
	
	  private static class Factory implements IRenderFactory<EntitySlime> 
	  {
		    public Factory() {
		    }

		    @Override
		    public Render<? super EntitySlime> createRenderFor(RenderManager manager) {
		      return new GumDropSlimeRenderer(manager);
		    }
		  }
}
