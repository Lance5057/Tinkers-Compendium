package lance5057.tDefense.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class TDMetalItemBlock extends ItemBlock {
	public TDMetalItemBlock(Block block)
	  {
	    super(block);
	    this.setMaxDamage(0);
	    this.setHasSubtypes(true);
	  }

	  @Override
	  public int getMetadata(int metadata)
	  {
	    return metadata;
	  }

	  // create a unique unlocalised name for each colour, so that we can give each one a unique name
	  @Override
	  public String getUnlocalizedName(ItemStack stack)
	  {
	    return super.getUnlocalizedName() + "." + stack.getMetadata();
	}
}
