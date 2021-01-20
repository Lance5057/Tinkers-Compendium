package lance5057.tDefense.core.materials.traits;

import exterminatorjeff.undergroundbiomes.api.enums.UBStoneStyle;
import exterminatorjeff.undergroundbiomes.api.enums.UBStoneType;
import exterminatorjeff.undergroundbiomes.intermod.StonesRegistry;
import lance5057.tDefense.core.library.ArmorHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import slimeknights.tconstruct.library.utils.ToolHelper;

import static exterminatorjeff.undergroundbiomes.api.enums.IgneousVariant.*;
import static exterminatorjeff.undergroundbiomes.api.enums.MetamorphicVariant.*;
import static exterminatorjeff.undergroundbiomes.api.enums.SedimentaryVariant.*;

public class TraitStonekin extends AbstractTDTrait
{
	public TraitStonekin() {
		super("stonekin", TextFormatting.RED);
	}
	
	@Override
	  public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {

		if(ToolHelper.getCurrentDurability(tool) < ToolHelper.getMaxDurability(tool))
		{
				BlockPos underPlayer = new BlockPos(player.posX, player.posY - 1, player.posZ);

				if (world.getBlockState(underPlayer).getBlock() == Blocks.STONE) {
					ArmorHelper.repairTool(tool, 5);
					world.setBlockState(underPlayer, Blocks.COBBLESTONE.getDefaultState());
				}


				//=========UNDERGROUND BIOMES STONES=========
				else if (Loader.isModLoaded("undergroundbiomes")) {
					//IGNEOUS--------------
					if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=red_granite")) {
						ArmorHelper.repairTool(tool, 5);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, RED_GRANITE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=black_granite")) {
						ArmorHelper.repairTool(tool, 5);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BLACK_GRANITE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=rhyolite")) {
						ArmorHelper.repairTool(tool, 5);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, RHYOLITE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=andesite")) {
						ArmorHelper.repairTool(tool, 5);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, ANDESITE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=gabbro")) {
						ArmorHelper.repairTool(tool, 5);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, GABBRO));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=basalt")) {
						ArmorHelper.repairTool(tool, 5);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BASALT));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=komatiite")) {
						ArmorHelper.repairTool(tool, 5);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, KOMATIITE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=dacite")) {
						ArmorHelper.repairTool(tool, 5);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, DACITE));
					}

					//METAMORPHIC------------------
					else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=gneiss")) {
						ArmorHelper.repairTool(tool, 10);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GNEISS));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=eclogite")) {
						ArmorHelper.repairTool(tool, 10);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, ECLOGITE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=marble")) {
						ArmorHelper.repairTool(tool, 10);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MARBLE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=quartzite")) {
						ArmorHelper.repairTool(tool, 10);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, QUARTZITE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=blueschist")) {
						ArmorHelper.repairTool(tool, 10);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, BLUESCHIST));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=greenschist")) {
						ArmorHelper.repairTool(tool, 10);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GREENSCHIST));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=soapstone")) {
						ArmorHelper.repairTool(tool, 10);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, SOAPSTONE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=migmatite")) {
						ArmorHelper.repairTool(tool, 10);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MIGMATITE));
					}

					//SEDIMENTARY------------------
					else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=limestone")) {
						ArmorHelper.repairTool(tool, 3);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, LIMESTONE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=chalk")) {
						ArmorHelper.repairTool(tool, 3);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, CHALK));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=shale")) {
						ArmorHelper.repairTool(tool, 3);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, SHALE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=siltstone")) {
						ArmorHelper.repairTool(tool, 3);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, SILTSTONE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=lignite")) {
						ArmorHelper.repairTool(tool, 3);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, LIGNITE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=dolomite")) {
						ArmorHelper.repairTool(tool, 3);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, DOLOMITE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=greywacke")) {
						ArmorHelper.repairTool(tool, 3);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, GREYWACKE));
					} else if (world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& world.getBlockState(underPlayer).getProperties().toString().contains("=chert")) {
						ArmorHelper.repairTool(tool, 3);
						world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, CHERT));
					}
				}
		}
	  }
}
