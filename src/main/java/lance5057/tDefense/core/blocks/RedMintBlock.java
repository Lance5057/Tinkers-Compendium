package lance5057.tDefense.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RedMintBlock extends Block
{

	public RedMintBlock(Material material)
	{
		super(material);
		setHarvestLevel("pickaxe", 2);
	}

}
