package lance5057.tDefense.core.blocks;

import javax.annotation.Nonnull;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.tileentities.ArmorStationTile;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.inventory.BaseContainer;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.shared.block.BlockTable;
import slimeknights.tconstruct.tools.common.block.ITinkerStationBlock;
import slimeknights.tconstruct.tools.common.block.BlockToolTable.TableTypes;

public class ArmorStationBlock extends BlockTable implements ITinkerStationBlock {

    public ArmorStationBlock() {
        super(Material.WOOD);
        this.setUnlocalizedName("armorstation");
        this.setRegistryName("armorstation");
        this.setCreativeTab(TinkersDefense.tab);
        this.setSoundType(SoundType.WOOD);
        this.setResistance(5f);
        this.setHardness(1f);
        this.setHarvestLevel("axe", 0);
    }

    @Nonnull
    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        return new ArmorStationTile();
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new ExtendedBlockState(this, new IProperty[]{}, new IUnlistedProperty[]{TEXTURE, INVENTORY, FACING});
    }
    
//    @SideOnly(Side.CLIENT)
//    @Override
//    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
//      // crafting station is boring
//      list.add(new ItemStack(this, 1, TableTypes.CraftingStation.meta));
//
//      // planks for the stencil table
//      addBlocksFromOredict("plankWood", TableTypes.StencilTable.meta, list);
//
//      list.add(new ItemStack(this, 1, TableTypes.PatternChest.meta));
//
//      // logs for the part builder
//      addBlocksFromOredict("logWood", TableTypes.PartBuilder.meta, list);
//
//      list.add(new ItemStack(this, 1, TableTypes.PartChest.meta));
//
//      // stencil table is boring
//      //addBlocksFromOredict("workbench", TableTypes.ToolStation.ordinal(), list);
//      list.add(new ItemStack(this, 1, TableTypes.ToolStation.meta));
//
//    }
//
//    private void addBlocksFromOredict(String oredict, int meta, NonNullList<ItemStack> list) {
//      for(ItemStack stack : OreDictionary.getOres(oredict)) {
//        Block block = getBlockFromItem(stack.getItem());
//        int blockMeta = stack.getItemDamage();
//
//        if(blockMeta == OreDictionary.WILDCARD_VALUE) {
//          NonNullList<ItemStack> subBlocks = NonNullList.create();
//          block.getSubBlocks(null, subBlocks);
//
//          for(ItemStack subBlock : subBlocks) {
//            list.add(createItemstack(this, meta, getBlockFromItem(subBlock.getItem()), subBlock.getItemDamage()));
//            if(!Config.listAllTables) {
//              return;
//            }
//          }
//        }
//        else {
//          list.add(createItemstack(this, meta, block, blockMeta));
//          if(!Config.listAllTables) {
//            return;
//          }
//        }
//      }
//    }

    @Override
    public boolean openGui(EntityPlayer player, World world, BlockPos pos) {
        if(!world.isRemote) {
            player.openGui(TConstruct.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
            if(player.openContainer instanceof BaseContainer) {
                ((BaseContainer) player.openContainer).syncOnOpen((EntityPlayerMP) player);
            }
        }
        return true;
    }

    @Override
    public int getGuiNumber(IBlockState state) {
        return 55;
    }
}