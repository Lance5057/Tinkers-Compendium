package lance5057.tDefense.core.blocks.fluid;

import lance5057.tDefense.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import slimeknights.tconstruct.library.fluid.FluidMolten;

public class TDFluid extends FluidMolten 
{

	public TDFluid(String fluidName, int color, int temp, int lumen, int visk, int dense) {
		super(fluidName, color, new ResourceLocation("tconstruct:blocks/fluids/molten_metal"), new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow"));
		this.setUnlocalizedName(Reference.MOD_ID + "." + fluidName);
	    this.setTemperature(temp);
	    this.setLuminosity(lumen);
	    this.setViscosity(visk);
	    this.setDensity(dense);
	}
	
	public TDFluid(String fluidName, int color, int temp, int lumen, int visk, int dense, ResourceLocation source, ResourceLocation flow) {
		super(fluidName, color, source, flow);
		this.setUnlocalizedName(Reference.MOD_ID + "." + fluidName);
	    this.setTemperature(temp);
	    this.setLuminosity(lumen);
	    this.setViscosity(visk);
	    this.setDensity(dense);
	}
}
