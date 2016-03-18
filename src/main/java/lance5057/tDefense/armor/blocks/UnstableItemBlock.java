package lance5057.tDefense.armor.blocks;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class UnstableItemBlock extends ItemBlockWithMetadata
{

	public UnstableItemBlock(Block block)
	{
		super(block, block);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.getUnlocalizedName() + "_" + ((UnstableBlock) TinkersDefense.block_Unstable).types[stack.getItemDamage()];
	}
}
