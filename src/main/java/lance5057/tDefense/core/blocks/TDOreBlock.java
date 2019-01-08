package lance5057.tDefense.core.blocks;

import java.util.Random;

import lance5057.tDefense.TCConfig;
import lance5057.tDefense.TinkersCompendium;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TDOreBlock extends BlockOre {
	// Item drop;
	Item clump;

	public TDOreBlock() {
		super();
		this.setCreativeTab(TinkersCompendium.tab);
	}

	public TDOreBlock(Item clump, float hardness, float resistance, int mininglevel) {
		super();
		this.setCreativeTab(TinkersCompendium.tab);

		// this.drop = drop;
		this.clump = clump;
		this.blockHardness = hardness;
		this.blockResistance = resistance;
		this.setHarvestLevel("pickaxe", mininglevel);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune) {
		Random rand = world instanceof World ? ((World) world).rand : RANDOM;

		if (this.harvesters.get() != null) {
			ItemStack stack = this.harvesters.get().getHeldItemMainhand();

			if ((stack.getItem() instanceof ToolCore && TinkerUtil.hasModifier(TagUtil.getBaseTag(stack), "silkluck"))
					|| TCConfig.OreClumps) {
				drops.add(new ItemStack(clump,  1 + rand.nextInt(1 + fortune), 0));
				return;
			}
		}

		super.getDrops(drops, world, pos, state, fortune);

	}
}
