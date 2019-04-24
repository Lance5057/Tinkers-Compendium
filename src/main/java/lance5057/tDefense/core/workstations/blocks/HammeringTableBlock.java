package lance5057.tDefense.core.workstations.blocks;

import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.workstations.tileentities.GuilessManualWorkstationTileEntity;
import lance5057.tDefense.core.workstations.tileentities.HammeringTableTileEntity;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.tools.tools.Hammer;

public class HammeringTableBlock extends GuilessManualWorkstationBase {

	public HammeringTableBlock() {
		super();
		this.setUnlocalizedName("hammeringtable");
		this.setRegistryName("hammeringtable");
		this.setCreativeTab(TinkersCompendium.tab);
		this.setSoundType(SoundType.ANVIL);
		this.setResistance(5f);
		this.setHardness(1f);
		this.setHarvestLevel("pickaxe", 0);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		// if (!world.isRemote) {
		TileEntity te = world.getTileEntity(pos);
		if (te instanceof HammeringTableTileEntity) {
			HammeringTableTileEntity tile = (HammeringTableTileEntity) te;
			ItemStack item = player.getHeldItem(hand);

			if (item.equals(ItemStack.EMPTY) && player.isSneaking()) {
				tile.removeItemFromBlock(player, hand);
			} else {
				if (item.getItem() instanceof Hammer)
					tile.interact(player, hand);
				else
					tile.addItemToBlock(player, hand);
			}

			te.markDirty();

			if (te.getWorld() != null) {
				IBlockState bState = world.getBlockState(te.getPos());
				world.notifyBlockUpdate(te.getPos(), bState, bState, 3);
			}
		}
		// }
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new HammeringTableTileEntity(1, "hammeringtable", 4, "ore", "dust"); // TODO replace with
																					// gravel ores
	}
}
