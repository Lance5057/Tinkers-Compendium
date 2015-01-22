package gmail.Lance5057.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class QueensGoldBlock extends Block
{

        public QueensGoldBlock (Material material)
        {
                super(material);
                setHarvestLevel("pickaxe",2);
        }

}