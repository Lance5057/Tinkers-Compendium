package lance5057.tDefense.holiday;

import slimeknights.tconstruct.library.client.renderer.RenderTinkerSlime;
import slimeknights.tconstruct.world.entity.EntityBlueSlime;
import lance5057.tDefense.holiday.xmas.gumdropslime.GumDropSlime;
import lance5057.tDefense.holiday.xmas.gumdropslime.GumDropSlimeRenderer;
import net.minecraft.client.model.ModelSlime;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class HolidayClientProxy {

	public void Init()
	{
	    RenderingRegistry.registerEntityRenderingHandler(GumDropSlime.class, GumDropSlimeRenderer.FACTORY_GumDropSlime);


	}
}
