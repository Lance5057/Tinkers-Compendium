package lance5057.tDefense.core.blocks;

import lance5057.tDefense.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;

public class ColoredBlockMapper extends StateMapperBase
{

	String type;
	
	public ColoredBlockMapper(String name)
	{
		type = name;
	}
	
	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		// TODO Auto-generated method stub
		return new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "component" + type), null);
	}

}
