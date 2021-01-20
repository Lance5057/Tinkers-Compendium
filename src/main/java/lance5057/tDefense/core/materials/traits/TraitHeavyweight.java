package lance5057.tDefense.core.materials.traits;

import exterminatorjeff.undergroundbiomes.api.enums.UBStoneStyle;
import exterminatorjeff.undergroundbiomes.api.enums.UBStoneType;
import exterminatorjeff.undergroundbiomes.intermod.StonesRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import static exterminatorjeff.undergroundbiomes.api.enums.IgneousVariant.*;
import static exterminatorjeff.undergroundbiomes.api.enums.MetamorphicVariant.*;
import static exterminatorjeff.undergroundbiomes.api.enums.SedimentaryVariant.*;

public class TraitHeavyweight extends AbstractTDTrait {
	public TraitHeavyweight() {
		super("heavyweight", TextFormatting.RED);
	}

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {

		if (e.getSource() == DamageSource.FALL) {
			EntityLivingBase ent = e.getEntityLiving();

			for (int x = (int) (-1 * ent.fallDistance); x < 1 * ent.fallDistance; x++) {
				for (int y = (int) (-1 * ent.fallDistance); y < 1 * ent.fallDistance; y++) {
					BlockPos underPlayer = new BlockPos(ent.posX + x, ent.posY - 1, ent.posZ + y);

					IBlockState block = ent.world.getBlockState(underPlayer);
					Block b = block.getBlock();
					
					if (b == Blocks.STONE) {
						ent.world.setBlockState(underPlayer, Blocks.COBBLESTONE.getDefaultState());
					}
					else if (b == Blocks.COBBLESTONE) {
						ent.world.setBlockState(underPlayer, Blocks.GRAVEL.getDefaultState());
					}
					else if (b == Blocks.GRAVEL) {
						ent.world.setBlockState(underPlayer, Blocks.SAND.getDefaultState());
					}
					else if (b == Blocks.SANDSTONE) {
						ent.world.setBlockState(underPlayer, Blocks.SAND.getDefaultState());
					}
					else if (b == Blocks.GRASS) {
						ent.world.setBlockState(underPlayer, Blocks.DIRT.getDefaultState());
					}
					else if (b == Blocks.GRASS_PATH) {
						ent.world.setBlockState(underPlayer, Blocks.DIRT.getDefaultState());
					}

					//=========UNDERGROUND BIOMES STONES=========

					//IGNEOUS STONE--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=red_granite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
								.withProperty(IGNEOUS_VARIANT_PROPERTY, RED_GRANITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=black_granite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BLACK_GRANITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=rhyolite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, RHYOLITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=andesite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, ANDESITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=gabbro")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, GABBRO));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=basalt")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BASALT));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=komatiite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, KOMATIITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=dacite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, DACITE));
					}

					//IGNEOUS COBBLE--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=red_granite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, RED_GRANITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=black_granite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BLACK_GRANITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=rhyolite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, RHYOLITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=andesite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, ANDESITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=gabbro")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, GABBRO));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=basalt")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BASALT));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=komatiite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, KOMATIITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=dacite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, DACITE));
					}

					//IGNEOUS GRAVEL--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=red_granite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, RED_GRANITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=black_granite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BLACK_GRANITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=rhyolite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, RHYOLITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=andesite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, ANDESITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=gabbro")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, GABBRO));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=basalt")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BASALT));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=komatiite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, KOMATIITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:igneous_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=dacite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, DACITE));
					}

					//IGNEOUS SANDSTONE--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:igneous_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=red_granite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, RED_GRANITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:igneous_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=black_granite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BLACK_GRANITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:igneous_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=rhyolite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, RHYOLITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:igneous_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=andesite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, ANDESITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:igneous_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=gabbro")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, GABBRO));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:igneous_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=basalt")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, BASALT));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:igneous_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=komatiite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, KOMATIITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:igneous_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=dacite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.IGNEOUS, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(IGNEOUS_VARIANT_PROPERTY, DACITE));
					}

					//METAMORPHIC STONE--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=gneiss")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GNEISS));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=eclogite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, ECLOGITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=marble")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MARBLE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=quartzite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, QUARTZITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=blueschist")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, BLUESCHIST));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=greenschist")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GREENSCHIST));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=soapstone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, SOAPSTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=migmatite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.COBBLE).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MIGMATITE));
					}

					//METAMORPHIC COBBLE--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=gneiss")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GNEISS));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=eclogite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, ECLOGITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=marble")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MARBLE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=quartzite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, QUARTZITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=blueschist")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, BLUESCHIST));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=greenschist")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GREENSCHIST));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=soapstone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, SOAPSTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_cobble")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=migmatite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MIGMATITE));
					}

					//METAMORPHIC GRAVEL--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=gneiss")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GNEISS));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=eclogite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, ECLOGITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=marble")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MARBLE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=quartzite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, QUARTZITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=blueschist")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, BLUESCHIST));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=greenschist")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GREENSCHIST));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=soapstone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, SOAPSTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:metamorphic_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=migmatite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MIGMATITE));
					}

					//METAMORPHIC SANDSTONE--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:metamorphic_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=gneiss")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GNEISS));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:metamorphic_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=eclogite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, ECLOGITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:metamorphic_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=marble")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MARBLE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:metamorphic_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=quartzite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, QUARTZITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:metamorphic_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=blueschist")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, BLUESCHIST));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:metamorphic_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=greenschist")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, GREENSCHIST));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:metamorphic_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=soapstone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, SOAPSTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:metamorphic_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=migmatite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.METAMORPHIC, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(METAMORPHIC_VARIANT_PROPERTY, MIGMATITE));
					}

					//SEDIMENTARY STONE--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=limestone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, LIMESTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=chalk")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, CHALK));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=shale")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, SHALE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=siltstone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, SILTSTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=lignite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, LIGNITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=dolomite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, DOLOMITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=greywacke")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, GREYWACKE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_stone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=chert")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.GRAVEL).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, CHERT));
					}

					//SEDIMENTARY GRAVEL--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=limestone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, LIMESTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=chalk")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, CHALK));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=shale")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, SHALE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=siltstone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, SILTSTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=lignite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, LIGNITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=dolomite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, DOLOMITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=greywacke")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, GREYWACKE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().equals("undergroundbiomes:sedimentary_gravel")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=chert")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, CHERT));
					}

					//SEDIMENTARY SANDSTONE--------------
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:sedimentary_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=limestone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, LIMESTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:sedimentary_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=chalk")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, CHALK));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:sedimentary_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=shale")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, SHALE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:sedimentary_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=siltstone")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, SILTSTONE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:sedimentary_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=lignite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, LIGNITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:sedimentary_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=dolomite")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, DOLOMITE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:sedimentary_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=greywacke")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, GREYWACKE));
					}
					else if (ent.world.getBlockState(underPlayer).getBlock().getRegistryName().toString().contains("undergroundbiomes:sedimentary_sandstone")
							&& ent.world.getBlockState(underPlayer).getProperties().toString().contains("=chert")) {
						ent.world.setBlockState(underPlayer,
								StonesRegistry.INSTANCE.stoneFor(UBStoneType.SEDIMENTARY, UBStoneStyle.SAND).getBlock().getDefaultState()
										.withProperty(SEDIMENTARY_VARIANT_PROPERTY, CHERT));
					}

					
					ent.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, underPlayer.getX(), underPlayer.getY(), underPlayer.getZ(), ent.world.rand.nextInt(5), Math.abs((x+y) + ent.fallDistance), ent.world.rand.nextInt(5), new int[0]);
				}
			}
			
			AxisAlignedBB aabb = new AxisAlignedBB(ent.posX + (-1 * ent.fallDistance), ent.posY + (-1 * ent.fallDistance), ent.posZ + (-1 * ent.fallDistance), ent.posX + (1 * ent.fallDistance), ent.posY + (1 * ent.fallDistance), ent.posZ + (1 * ent.fallDistance));
			for(Entity entity: ent.world.getEntitiesInAABBexcluding(ent, aabb, null))
			{
				entity.attackEntityFrom(DamageSource.MAGIC, 2);
			}

			e.setAmount(e.getAmount() * 1.5f);
		}
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if (player.motionY < 0) {
			player.motionY *= 1.1f;
		}
	}
}
