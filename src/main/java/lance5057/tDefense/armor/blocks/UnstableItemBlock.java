package lance5057.tDefense.armor.blocks;

import lance5057.tDefense.armor.TDArmorAddon;
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
		return this.getUnlocalizedName() + "_" + ((UnstableBlock) TDArmorAddon.block_Unstable).types[stack.getItemDamage()];
	}
}
