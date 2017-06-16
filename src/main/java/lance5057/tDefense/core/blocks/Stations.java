//package lance5057.tDefense.core.blocks;
//
//import java.util.List;
//import java.util.Locale;
//
//import javax.annotation.Nonnull;
//
//import com.google.common.collect.Lists;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.SoundType;
//import net.minecraft.block.material.Material;
//import net.minecraft.block.properties.IProperty;
//import net.minecraft.block.properties.PropertyEnum;
//import net.minecraft.block.state.BlockStateContainer;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.player.EntityPlayerMP;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.IStringSerializable;
//import net.minecraft.util.math.AxisAlignedBB;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.RayTraceResult;
//import net.minecraft.util.math.Vec3d;
//import net.minecraft.world.IBlockAccess;
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
//import slimeknights.tconstruct.tools.common.tileentity.TileCraftingStation;
//import slimeknights.tconstruct.tools.common.tileentity.TilePartBuilder;
//import slimeknights.tconstruct.tools.common.tileentity.TilePartChest;
//import slimeknights.tconstruct.tools.common.tileentity.TilePatternChest;
//import slimeknights.tconstruct.tools.common.tileentity.TileStencilTable;
//import slimeknights.tconstruct.tools.common.tileentity.TileToolStation;
//
//public class Stations extends BlockTable implements ITinkerStationBlock {
//
//  public static final PropertyEnum<TableTypes> TABLES = PropertyEnum.func_177709_a("type", TableTypes.class);
//
//  public Stations() {
//    super(Material.field_151575_d);
//    this.func_149647_a(TinkerRegistry.tabGeneral);
//
//    this.func_149672_a(SoundType.field_185848_a);
//    this.func_149752_b(5f);
//    this.func_149711_c(1f);
//
//    // set axe as effective tool for all variants
//    this.setHarvestLevel("axe", 0);
//  }
//
//
//  @Nonnull
//  @Override
//  public TileEntity func_149915_a(@Nonnull World worldIn, int meta) {
//    switch(TableTypes.fromMeta(meta)) {
//      case CraftingStation:
//        return new TileCraftingStation();
//      case StencilTable:
//        return new TileStencilTable();
//      case PartBuilder:
//        return new TilePartBuilder();
//      case ToolStation:
//        return new TileToolStation();
//      case PatternChest:
//        return new TilePatternChest();
//      case PartChest:
//        return new TilePartChest();
//      default:
//        return super.func_149915_a(worldIn, meta);
//    }
//  }
//
//  @Override
//  public boolean openGui(EntityPlayer player, World world, BlockPos pos) {
//    if(!world.field_72995_K) {
//      player.openGui(TConstruct.instance, 0, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
//      if(player.field_71070_bA instanceof BaseContainer) {
//        ((BaseContainer) player.field_71070_bA).syncOnOpen((EntityPlayerMP) player);
//      }
//    }
//    return true;
//  }
//
//  @SideOnly(Side.CLIENT)
//  @Override
//  public void func_149666_a(@Nonnull Item itemIn, CreativeTabs tab, List<ItemStack> list) {
//    // crafting station is boring
//    list.add(new ItemStack(this, 1, TableTypes.CraftingStation.meta));
//
//    // planks for the stencil table
//    addBlocksFromOredict("plankWood", TableTypes.StencilTable.meta, list);
//
//    list.add(new ItemStack(this, 1, TableTypes.PatternChest.meta));
//
//    // logs for the part builder
//    addBlocksFromOredict("logWood", TableTypes.PartBuilder.meta, list);
//
//    list.add(new ItemStack(this, 1, TableTypes.PartChest.meta));
//
//    // stencil table is boring
//    //addBlocksFromOredict("workbench", TableTypes.ToolStation.ordinal(), list);
//    list.add(new ItemStack(this, 1, TableTypes.ToolStation.meta));
//
//  }
//
//  private void addBlocksFromOredict(String oredict, int meta, List<ItemStack> list) {
//    for(ItemStack stack : OreDictionary.getOres(oredict)) {
//      Block block = func_149634_a(stack.func_77973_b());
//      int blockMeta = stack.func_77952_i();
//
//      if(blockMeta == OreDictionary.WILDCARD_VALUE) {
//        List<ItemStack> subBlocks = Lists.newLinkedList();
//        block.func_149666_a(stack.func_77973_b(), null, subBlocks);
//
//        for(ItemStack subBlock : subBlocks) {
//          list.add(createItemstack(this, meta, func_149634_a(subBlock.func_77973_b()), subBlock.func_77952_i()));
//          if(!Config.listAllTables) {
//            return;
//          }
//        }
//      }
//      else {
//        list.add(createItemstack(this, meta, block, blockMeta));
//        if(!Config.listAllTables) {
//          return;
//        }
//      }
//    }
//  }
//
//  @Override
//  protected boolean keepInventory(IBlockState state) {
//    return Config.chestsKeepInventory &&
//           (state.func_177229_b(TABLES) == TableTypes.PatternChest || state.func_177229_b(TABLES) == TableTypes.PartChest);
//  }
//
//  @Nonnull
//  @Override
//  protected BlockStateContainer func_180661_e() {
//    return new ExtendedBlockState(this, new IProperty[]{TABLES}, new IUnlistedProperty[]{TEXTURE, INVENTORY, FACING});
//  }
//
//  @Nonnull
//  @Override
//  public IBlockState func_176203_a(int meta) {
//    return this.func_176223_P().func_177226_a(TABLES, TableTypes.fromMeta(meta));
//  }
//
//  @Override
//  public int func_176201_c(IBlockState state) {
//    return (state.func_177229_b(TABLES)).meta;
//  }
//
//  /* Bounds */
//  private static AxisAlignedBB BOUNDS_Chest = new AxisAlignedBB(0, 0, 0, 1, 0.875, 1);
//
//  @Nonnull
//  @Override
//  public AxisAlignedBB func_185496_a(IBlockState state, IBlockAccess source, BlockPos pos) {
//    if(state.func_177229_b(TABLES).isChest) {
//      return BOUNDS_Chest;
//    }
//
//    return super.func_185496_a(state, source, pos);
//  }
//
//  @Override
//  public RayTraceResult func_180636_a(IBlockState blockState, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Vec3d start, @Nonnull Vec3d end) {
//    if(blockState.func_177229_b(TABLES).isChest) {
//      return func_185503_a(pos, start, end, BOUNDS_Chest);
//    }
//
//    return super.func_180636_a(blockState, worldIn, pos, start, end);
//  }
//
//  @Override
//  public int getGuiNumber(IBlockState state) {
//    switch(state.func_177229_b(TABLES)) {
//      case StencilTable:
//        return 10;
//      case PatternChest:
//        return 15;
//      case PartChest:
//        return 16;
//      case PartBuilder:
//        return 20;
//      case ToolStation:
//        return 25;
//      case CraftingStation:
//        return 50;
//      default:
//        return 0;
//    }
//  }
//
//  public enum TableTypes implements IStringSerializable {
//    CraftingStation,
//    StencilTable,
//    PartBuilder,
//    ToolStation,
//    PatternChest(true),
//    PartChest(true);
//
//    TableTypes() {
//      meta = this.ordinal();
//      this.isChest = false;
//    }
//
//    TableTypes(boolean chest) {
//      meta = this.ordinal();
//      this.isChest = chest;
//    }
//
//    public final int meta;
//    public final boolean isChest;
//
//    public static TableTypes fromMeta(int meta) {
//      if(meta < 0 || meta >= values().length) {
//        meta = 0;
//      }
//
//      return values()[meta];
//    }
//
//    @Override
//    public String func_176610_l() {
//      return this.toString().toLowerCase(Locale.US);
//    }
//  }
//}
