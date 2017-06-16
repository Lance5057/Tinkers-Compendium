package lance5057.tDefense.core.materials;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidColor extends Fluid
{

	int color; 
	public FluidColor(String fluidName, ResourceLocation still, ResourceLocation flowing, int color) {
		super(fluidName, still, flowing);
		this.color = color;
	}
	
	@Override
	public int getColor()
    {
        return color;
    }
}
