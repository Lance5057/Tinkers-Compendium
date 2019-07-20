package lance5057.tDefense.core.materials.traits;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.traits.TraitProgressiveStats;

/**
 * Gives the tool bonus stats on crafting. The bonus stats are distributed over
 * time and are more or less random. The stats that will be rewarded are already
 * designated on the first time the tool is crafted
 */
public class TraitRegal extends TraitProgressiveStats {

	protected static int TICK_PER_STAT = 72;

	protected static int DURABILITY_STEP = 1;
	protected static float SPEED_STEP = 0.1f;
	protected static float ATTACK_STEP = 0.005f;

	public TraitRegal() {
		super("regal", TextFormatting.YELLOW);
	}

	@Override
	public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (entity instanceof FakePlayer || entity.getEntityWorld().isRemote) {
			return;
		}

		EntityPlayerMP player = (EntityPlayerMP) entity;

		// every 3.6 seconds we distribute one stat. This means 1h = 1000 applications
//		if (player.experienceLevel % TICK_PER_STAT > 0) {
//			return;
//		}

		// we don't update if the player is currently breaking a block because that'd
		// reset it
		if (playerIsBreakingBlock(entity)
				|| (entity instanceof EntityPlayerMP && ((EntityPlayerMP) entity).getActiveItemStack() == tool)) {
			return;
		}

		NBTTagCompound root = TagUtil.getTagSafe(tool);
		//StatNBT pool = getPoolLazily(root);
		StatNBT distributed = getBonus(root);
		ToolNBT data = TagUtil.getToolStats(tool);
		ToolNBT originalData = TagUtil.getOriginalToolStats(tool);

//    // attack
//    if(player.experienceLevel % (TICK_PER_STAT * 3) == 0) {
//      if(distributed.attack < pool.attack) {
//        data.attack += ATTACK_STEP;
//        distributed.attack += ATTACK_STEP;
//      }
//    }
//    // speed
//    else if(player.experienceLevel % (TICK_PER_STAT * 2) == 0) {
//      if(distributed.speed < pool.speed) {
//        data.speed += SPEED_STEP;
//        distributed.speed += SPEED_STEP;
//      }
//    }
//    // durability
//    else {
//      if(player.experienceLevel % (TICK_PER_STAT) == 0) {
//        data.durability += DURABILITY_STEP;
//        distributed.durability += DURABILITY_STEP;
//      }
//    }
		
//		data.attack = originalData.attack + ATTACK_STEP * player.experienceLevel;
//		distributed.attack = ATTACK_STEP * player.experienceLevel;

		data.durability = originalData.durability + DURABILITY_STEP * player.experienceLevel;
		distributed.durability = DURABILITY_STEP * player.experienceLevel;

		data.speed = originalData.speed + SPEED_STEP * player.experienceLevel;
		distributed.speed = SPEED_STEP * player.experienceLevel;

		// update tool stats
		TagUtil.setToolTag(root, data.get());
		// update statistics on distributed stats
		setBonus(root, distributed);
	}

	@Override
	public List<String> getExtraInfo(ItemStack tool, NBTTagCompound modifierTag) {
		StatNBT pool = getBonus(TagUtil.getTagSafe(tool));

		return ImmutableList.of(HeadMaterialStats.formatDurability(pool.durability),
				HeadMaterialStats.formatMiningSpeed(pool.speed));
	}
}