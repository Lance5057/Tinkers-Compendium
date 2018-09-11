package lance5057.tDefense.core.materials.traits;

import net.minecraft.block.material.Material;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TraitGoggles extends AbstractTDTrait {

	public TraitGoggles() {
		super("goggles", TextFormatting.AQUA);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void alterFogDensity(FogDensity event)
	{
		if(event.getEntity().isInsideOfMaterial(Material.WATER))
		{
			event.setDensity(0.0001f);
		}
		else
		{
			event.setDensity(0.0001f);
		}
		
		event.setCanceled(true); 
	}

}
