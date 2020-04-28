package lance5057.tDefense;

import java.util.Locale;
import java.util.Map;

import gnu.trove.map.hash.THashMap;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

public class TCFluids {
	
	public static final Map<String, FluidMolten> fluids = new THashMap();

	public static FluidMolten fluidMetal(String name, int color, int temp) {

		FluidMolten f = registerFluid(new FluidMolten(name, color));
		f.setTemperature(800);
		initFluidMetal(f);

		return f;
	}

	public static void initFluidMetal(Fluid fluid) {
		registerMoltenBlock(fluid);
		FluidRegistry.addBucketForFluid(fluid);
		TinkersCompendium.proxy.registerFluidModels(fluid);
	}

	public static <T extends Fluid> T registerFluid(T fluid) {
		fluid.setUnlocalizedName(Reference.MOD_ID + "." + fluid.getName().toLowerCase(Locale.US));
		FluidRegistry.registerFluid(fluid);
		return fluid;
	}

	public static Block registerMoltenBlock(Fluid fluid) {
		BlockMolten block = new BlockMolten(fluid);
		return TCBlocks.registerBlock(block, "molten_" + fluid.getName());
	}
}
