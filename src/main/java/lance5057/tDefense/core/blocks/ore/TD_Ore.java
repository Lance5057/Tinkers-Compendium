package lance5057.tDefense.core.blocks.ore;

import java.util.Random;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class TD_Ore extends Block
{
	Item drops;
	public TD_Ore(Material mat, String name, Item drop)
	{
		super(mat);
		this.setBlockName(name + "ore");
        this.setBlockTextureName(Reference.MOD_ID + ":" + name + "ore");
        this.setCreativeTab(TinkersDefense.tabName);
        this.setStepSound(soundTypeStone);
        this.setHardness(10.0f);
        this.setResistance(20.0f);
		setHarvestLevel("pickaxe",2);
		
		drops = drop;
	}
	
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return drops;
    }
    
    @Override
    public int quantityDropped(int meta, int fortune, Random random) 
    {
    	int rand = random.nextInt(fortune + 1) + 1;
    	return rand;
    }
}
