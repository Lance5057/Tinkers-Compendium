package lance5057.tDefense.armor.blocks;

import java.util.List;
import java.util.Random;

import lance5057.tDefense.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UnstableBlock extends Block
{
	public static final String[]	types			= {"ice", "obsidian"};
	public int						timer;

	public static final String[]	field_150096_a	= new String[] {"ice", "obsidian"};
	@SideOnly(Side.CLIENT)
	private IIcon[]					field_150095_b;

	public UnstableBlock()
	{
		super(Material.rock);
		setBlockName("unstable");
		setBlockTextureName("unstable");
		setTickRandomly(true);
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		if(p_149691_2_ < 0 || p_149691_2_ >= field_150095_b.length)
		{
			p_149691_2_ = 0;
		}

		return field_150095_b[p_149691_2_];
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int p_149692_1_)
	{
		return p_149692_1_;
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		field_150095_b = new IIcon[field_150096_a.length];

		for(int i = 0; i < field_150095_b.length; ++i)
		{
			field_150095_b[i] = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + getTextureName() + field_150096_a[i]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block p_149749_5_, int meta)
	{
		//int meta = par1World.getBlockMetadata(par2, par3, par4);

		if(meta == 0)
		{
			par1World.setBlock(par2, par3, par4, Blocks.water, 0, 3);
		}
		if(meta == 1)
		{
			par1World.setBlock(par2, par3, par4, Blocks.lava, 0, 3);
		}
		par1World.notifyBlockOfNeighborChange(par2, par3, par4, par1World.getBlock(par2, par3, par4));
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		final int meta = par1World.getBlockMetadata(par2, par3, par4);

		if(meta == 0)
		{
			par1World.setBlock(par2, par3, par4, Blocks.water, 0, 3);
		}
		if(meta == 1)
		{
			par1World.setBlock(par2, par3, par4, Blocks.lava, 0, 3);
		}
		par1World.notifyBlockOfNeighborChange(par2, par3, par4, par1World.getBlock(par2, par3, par4));
	}
}
