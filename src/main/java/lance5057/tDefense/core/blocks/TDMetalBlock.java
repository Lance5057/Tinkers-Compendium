package lance5057.tDefense.core.blocks;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class TDMetalBlock extends Block {
	public static PropertyInteger METAL;
	public int maxmeta;

	public TDMetalBlock(int max) {
		super(Material.IRON);
		maxmeta = max;
		this.setCreativeTab(TinkersDefense.tab);
		this.setHardness(5);
		this.setResistance(30);
		METAL = PropertyInteger.create("metal", 0, max);
		this.setDefaultState(this.blockState.getBaseState().withProperty(METAL, 0));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { METAL });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(METAL, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int type = state.getValue(METAL);
		return type;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> tab) {
		for (int i = 0; i < maxmeta; i++) {
			tab.add(new ItemStack(this, 1, i));
		}
	}

}
