package lance5057.tDefense.core.blocks;

import java.util.Random;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TDOreBlock extends BlockOre
{
	//Item drop;
	Item clump;
	
	public TDOreBlock()
    {
        super();
        this.setCreativeTab(TinkersDefense.tab);
    }
	
	public TDOreBlock(Item clump)
    {
        super();
        this.setCreativeTab(TinkersDefense.tab);
        
        //this.drop = drop;
        this.clump = clump;
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
	      return Item.getItemFromBlock(this);
    }

	//TODO: add way to handle ore clumps
    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }
}
