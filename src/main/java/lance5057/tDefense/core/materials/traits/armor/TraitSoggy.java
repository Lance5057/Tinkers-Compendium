package lance5057.tDefense.core.materials.traits.armor;

import java.util.List;

import lance5057.tDefense.TD_Config;
import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import lance5057.tDefense.util.ArmorTagUtil;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitSoggy extends AbstractTDTrait {

	public TraitSoggy() {
		super("soggy", TextFormatting.YELLOW);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if (player.isInWater()) {
			ArmorTagUtil.setWater(tool, 65);
		}

		if (ArmorTagUtil.getWater(tool) > 0) {
			// Under player
			BlockPos pos = new BlockPos(player.posX, player.posY - 1, player.posZ);
			IBlockState block = world.getBlockState(pos);

			if (block == Blocks.LAVA.getDefaultState())
				changeBlock(tool, world, pos, Blocks.OBSIDIAN.getDefaultState());
			if (block == Blocks.FARMLAND.getDefaultState())
				changeBlock(tool, world, pos,
						Blocks.FARMLAND.getDefaultState().withProperty(BlockFarmland.MOISTURE, 7));

			// At Player
			pos = player.getPosition();
			block = world.getBlockState(player.getPosition());
			if (block == Blocks.FIRE.getDefaultState())
				changeBlock(tool, world, pos, Blocks.AIR.getDefaultState());
			if (block == Blocks.FLOWING_LAVA.getDefaultState())
				changeBlock(tool, world, pos, Blocks.STONE.getDefaultState());

			if (!TD_Config.DontTouchMyBucket) {
				List<ItemStack> items = player.inventory.mainInventory;
				for (int i = 0; i < items.size(); i++) {
					if (items.get(i).getItem() == Items.BUCKET) {

						if (player.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET, 1, 0))) {
							player.inventory.mainInventory.get(i).splitStack(1);
							ArmorTagUtil.setWater(tool, ArmorTagUtil.getWater(tool) - 1);
						}
					}
					if (items.get(i).getItem() == Items.GLASS_BOTTLE) {

						ItemStack pot = new ItemStack(Items.POTIONITEM, 1, 0);
						PotionUtils.addPotionToItemStack(pot, PotionType.getPotionTypeForName("water"));
						if (player.inventory.addItemStackToInventory(pot)) {
							player.inventory.mainInventory.get(i).splitStack(1);
							ArmorTagUtil.setWater(tool, ArmorTagUtil.getWater(tool) - 1);
						}
					}
				}
			}
		}
	}

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		if (e.getSource() == DamageSource.ON_FIRE || e.getSource() == DamageSource.IN_FIRE
				|| e.getSource() == DamageSource.LAVA) {
			if (ArmorTagUtil.getWater(tool) > 0) {
				e.getEntityLiving().extinguish();
				ArmorTagUtil.setWater(tool, ArmorTagUtil.getWater(tool) - 1);
			} else {
				ToolHelper.damageTool(tool, 50, e.getEntityLiving());
			}
		}
	}

	void changeBlock(ItemStack tool, World world, BlockPos pos, IBlockState state) {
		if (ArmorTagUtil.getWater(tool) > 0) {
			world.setBlockState(pos, state);
			ArmorTagUtil.setWater(tool, ArmorTagUtil.getWater(tool) - 1);
		}
	}
}
