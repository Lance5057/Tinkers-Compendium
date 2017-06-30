package lance5057.tDefense.core.blocks;

import java.util.List;

import lance5057.tDefense.core.CoreBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class TDMetalBlock extends Block {
	public static final PropertyEnum METAL = PropertyEnum.create("metal", TDMetalBlock.EnumMetal.class);

	public TDMetalBlock() {
		super(Material.IRON);
		this.setCreativeTab(CoreBase.tab);
		this.setHardness(5);
		this.setResistance(30);
		this.setDefaultState(this.blockState.getBaseState().withProperty(METAL, EnumMetal.AEONSTEEL));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { METAL });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumMetal colour = EnumMetal.byMetadata(meta);
		return this.getDefaultState().withProperty(METAL, colour);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumMetal type = (EnumMetal) state.getValue(METAL);
		return type.getID();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		EnumMetal[] all = EnumMetal.values();
		for (EnumMetal block : all) {
			list.add(new ItemStack(itemIn, 1, block.getID()));
		}
	}

	public enum EnumMetal implements IStringSerializable {
		AEONSTEEL(0, "aeonsteel"),
		QUEENSGOLD(1, "queensgold"),
		DOGBEARIUM(2, "dogbearium"),
		REDCANDY(3, "redcandy"),
		GREENCANDY(4, "greencandy"),
		SINISTERIUM(5, "sinisterium"),
		NIHILITE(6, "nihilite"),
		ORICHALCUM(7, "orichalcum"),
		PANDORIUM(8, "pandorium"),
		ROSEGOLD(9, "rosegold"),
		PLATINUM(10, "platinum"),
		BRASS(11, "brass"),
		SILVER(12, "silver"),
		CHEESE(13, "cheese");

		private int ID;
		private String name;

		private EnumMetal(int ID, String name) {
			this.ID = ID;
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

		public int getID() {
			return ID;
		}

		@Override
		public String toString() {
			return getName();
		}

		public static EnumMetal byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		private static final EnumMetal[] META_LOOKUP = new EnumMetal[values().length];

		static {
			for (EnumMetal colour : values()) {
				META_LOOKUP[colour.getID()] = colour;
			}
		}
	}
}
