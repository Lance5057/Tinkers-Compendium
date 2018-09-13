//package lance5057.tDefense.core.blocks.workstation;
//
//import javax.annotation.Nonnull;
//
//import com.google.common.collect.ImmutableList;
//
//import lance5057.tDefense.TinkersDefense;
//import lance5057.tDefense.core.tileentities.ArmorStationTile;
//import net.minecraft.block.Block;
//import net.minecraft.block.SoundType;
//import net.minecraft.block.material.Material;
//import net.minecraft.block.properties.IProperty;
//import net.minecraft.block.state.BlockStateContainer;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.player.EntityPlayerMP;
//import net.minecraft.item.ItemStack;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.math.AxisAlignedBB;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.RayTraceResult;
//import net.minecraft.util.math.Vec3d;
//import net.minecraft.world.World;
//import net.minecraftforge.common.property.ExtendedBlockState;
//import net.minecraftforge.common.property.IUnlistedProperty;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import net.minecraftforge.oredict.OreDictionary;
//import slimeknights.mantle.inventory.BaseContainer;
//import slimeknights.tconstruct.TConstruct;
//import slimeknights.tconstruct.common.config.Config;
//import slimeknights.tconstruct.library.TinkerRegistry;
//import slimeknights.tconstruct.shared.block.BlockTable;
//import slimeknights.tconstruct.tools.common.block.ITinkerStationBlock;
//import slimeknights.tconstruct.tools.common.block.BlockToolTable.TableTypes;
//
//public class FinishingAnvilBlock extends BlockTable implements ITinkerStationBlock {
//
//	public FinishingAnvilBlock() {
//		super(Material.IRON);
//		this.setUnlocalizedName("finishinganvil");
//		this.setRegistryName("finishinganvil");
//		this.setCreativeTab(TinkersDefense.tab);
//		this.setSoundType(SoundType.ANVIL);
//		this.setResistance(5f);
//		this.setHardness(1f);
//		this.setHarvestLevel("pickaxe", 0);
//	}
//
//	@Nonnull
//	@Override
//	public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
//		//return new ArmorStationTile();
//	}
//
//	@Nonnull
//	@Override
//	protected BlockStateContainer createBlockState() {
//		return new ExtendedBlockState(this, new IProperty[] {}, new IUnlistedProperty[] { TEXTURE, INVENTORY, FACING });
//	}
//
//	@Override
//	public boolean openGui(EntityPlayer player, World world, BlockPos pos) {
//		if (!world.isRemote) {
//			player.openGui(TConstruct.instance, , world, pos.getX(), pos.getY(), pos.getZ());
//			if (player.openContainer instanceof BaseContainer) {
//				((BaseContainer) player.openContainer).syncOnOpen((EntityPlayerMP) player);
//			}
//		}
//		return true;
//	}
//
//	@Override
//	public int getGuiNumber(IBlockState state) {
//		return 57;
//	}
//
//	private static ImmutableList<AxisAlignedBB> BOUNDS_Table = ImmutableList
//			//.of(new AxisAlignedBB(0.5, 0.5, 0.5, 1, 1, 1));
//
//	@Override
//	public RayTraceResult collisionRayTrace(IBlockState blockState, @Nonnull World worldIn, @Nonnull BlockPos pos,
//			@Nonnull Vec3d start, @Nonnull Vec3d end) {
//		// basically the same BlockStairs does
//		// Raytrace through all AABBs (plate, legs) and return the nearest one
//		return raytraceMultiAABB(BOUNDS_Table, pos, start, end);
//	}
//}