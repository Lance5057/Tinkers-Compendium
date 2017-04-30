package lance5057.tDefense.core.blocks.crestMount;

import java.util.Random;

import javax.annotation.Nullable;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CrestMount extends BlockContainer implements ITileEntityProvider {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.1875D, 1.0D, 1.0D);
	protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.8125D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.1875D);
	protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.8125D, 1.0D, 1.0D, 1.0D);

	public CrestMount() {
		super(Material.IRON);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		
		this.setRegistryName("crestmount");
		this.setUnlocalizedName("crestmount");
		
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		GameRegistry.registerTileEntity(TileEntity_CrestMount.class, Reference.MOD_ID + "_crestmount");
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}
	
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
	
	@Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }


	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch ((EnumFacing) state.getValue(FACING)) {
		case NORTH:
			return NORTH_AABB;
		case SOUTH:
			return SOUTH_AABB;
		case WEST:
			return WEST_AABB;
		case EAST:
		default:
			return EAST_AABB;
		}
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_CrestMount.class, new Renderer_CrestMount());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		return false;
	}

	@Override
	public boolean isBlockNormalCube(IBlockState blockState) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState blockState) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.west()).isSideSolid(worldIn, pos.west(), EnumFacing.EAST)
				|| worldIn.getBlockState(pos.east()).isSideSolid(worldIn, pos.east(), EnumFacing.WEST)
				|| worldIn.getBlockState(pos.north()).isSideSolid(worldIn, pos.north(), EnumFacing.SOUTH)
				|| worldIn.getBlockState(pos.south()).isSideSolid(worldIn, pos.south(), EnumFacing.NORTH);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		if (facing.getAxis().isHorizontal() && this.canBlockStay(worldIn, pos, facing)) {
			return this.getDefaultState().withProperty(FACING, facing);
		} else {
			for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
				if (this.canBlockStay(worldIn, pos, enumfacing)) {
					return this.getDefaultState().withProperty(FACING, enumfacing);
				}
			}

			return this.getDefaultState();
		}
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {
		return worldIn.getBlockState(pos.offset(facing.getOpposite())).isSideSolid(worldIn,
				pos.offset(facing.getOpposite()), facing);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		final TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity == null || playerIn.isSneaking())
			return false;
		// code to open gui explained later
		playerIn.openGui(TinkersDefense.instance, TinkersDefense.GUI_CREST_INV, worldIn, 0, 0, 0);
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		dropItems(worldIn, pos);
		super.breakBlock(worldIn, pos, state);
	}

	private void dropItems(World world, BlockPos pos) {
		final Random rand = new Random();

		final TileEntity tileEntity = world.getTileEntity(pos);
		if (!(tileEntity instanceof IInventory))
			return;
		final IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			final ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0) {
				final float rx = rand.nextFloat() * 0.8F + 0.1F;
				final float ry = rand.nextFloat() * 0.8F + 0.1F;
				final float rz = rand.nextFloat() * 0.8F + 0.1F;

				final EntityItem entityItem = new EntityItem(world, pos.getX() + rx, pos.getY() + ry, pos.getZ() + rz,
						new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

				if (item.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}

				final float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntity(entityItem);
				item.stackSize = 0;
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World w, int md) {
		final TileEntity_CrestMount te = new TileEntity_CrestMount();
		return te;
	}

	// @Override
	// public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState
	// state, EntityLivingBase placer, ItemStack stack)
	// {
	// int j1 = p_149660_9_;
	//
	// if((p_149660_9_ == 0 || p_149660_5_ == 2) &&
	// p_149660_1_.isSideSolid(p_149660_2_, p_149660_3_, p_149660_4_ + 1,
	// NORTH))
	// {
	// j1 = 1;
	// }
	//
	// if((j1 == 0 || p_149660_5_ == 3) && p_149660_1_.isSideSolid(p_149660_2_,
	// p_149660_3_, p_149660_4_ - 1, SOUTH))
	// {
	// j1 = 2;
	// }
	//
	// if((j1 == 0 || p_149660_5_ == 4) && p_149660_1_.isSideSolid(p_149660_2_ +
	// 1, p_149660_3_, p_149660_4_, WEST))
	// {
	// j1 = 3;
	// }
	//
	// if((j1 == 0 || p_149660_5_ == 5) && p_149660_1_.isSideSolid(p_149660_2_ -
	// 1, p_149660_3_, p_149660_4_, EAST))
	// {
	// j1 = 4;
	// }
	//
	// return j1;
	// }
}
