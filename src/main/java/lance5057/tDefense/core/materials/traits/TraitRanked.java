package lance5057.tDefense.core.materials.traits;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.library.ArmorNBT;
import lance5057.tDefense.util.ArmorTagUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.traits.TraitProgressiveStats;

/**
 * Gives the tool bonus stats on crafting. The bonus stats are distributed over
 * time and are more or less random. The stats that will be rewarded are already
 * designated on the first time the tool is crafted
 */
public class TraitRanked extends TraitProgressiveStats {

	protected static int TICK_PER_STAT = 72;

	protected static int DURABILITY_STEP = 10;
	protected static int TOUGNESS_STEP = 1;

	public TraitRanked() {
		super("ranked", TextFormatting.YELLOW);
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
		// StatNBT pool = getPoolLazily(root);
		StatNBT distributed = getBonus(root);
		ArmorNBT data = ArmorTagUtil.getToolStats(tool);
		ArmorNBT originalData = ArmorTagUtil.getOriginalToolStats(tool);

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
		int rank = calculateRank(player.getStatFile().readStat(StatList.MOB_KILLS)
				+ (player.getStatFile().readStat(StatList.PLAYER_KILLS)) * 10);

		data.durability = originalData.durability + DURABILITY_STEP * player.getStatFile().readStat(StatList.MOB_KILLS);
		distributed.durability = DURABILITY_STEP * player.experienceLevel;

		data.armorToughness = (int) (originalData.armorToughness
				+ TOUGNESS_STEP * player.getStatFile().readStat(StatList.MOB_KILLS));
		distributed.speed = TOUGNESS_STEP * player.experienceLevel;

		// update tool stats
		TagUtil.setToolTag(root, data.get());
		// update statistics on distributed stats
		setBonus(root, distributed);
	}

	int calculateRank(int kills) {

		// Footman
		if (kills > 10 && kills > 50)
			return 1;
		// Infantry
		if (kills > 50 && kills > 250)
			return 2;
		// Squire
		if (kills > 250 && kills > 500)
			return 3;
		// Knight
		if (kills > 500 && kills > 1000)
			return 4;
		// Captain
		if (kills > 1000 && kills > 2000)
			return 5;
		// Brigadier
		if (kills > 2000 && kills > 4000)
			return 6;
		// Lord
		if (kills > 4000 && kills > 8000)
			return 7;
		// Warlord
		if (kills > 8000 && kills > 16000)
			return 8;

		// Peasant
		return 0;
	}

//	String getRankName(int rank) {
//
//		switch (rank) {
//		case 1:
//			return "trait.rank.footman";
//		case 2:
//			return "trait.rank.infantry";
//		case 3:
//			return "trait.rank.squire";
//		case 4:
//			return "trait.rank.knight";
//		case 5:
//			return "trait.rank.captain";
//		case 6:
//			return "trait.rank.brigadier";
//		case 7:
//			return "trait.rank.lord";
//		case 8:
//			return "trait.rank.warlord";
//		default:
//			return "trait.rank.peasant";
//		}
//	}

//	@Override
//	public List<String> getExtraInfo(ItemStack tool, NBTTagCompound modifierTag) {
//		StatNBT pool = getBonus(TagUtil.getTagSafe(tool));
//
//		List<String> s = new ArrayList<String>();
//		s.add(String.format("%s: %s",
//                Util.translate("trait.rank"),
//                CustomFontColor.formatPartialAmount(durability, ref))
//  + TextFormatting.RESET)
//	}
}