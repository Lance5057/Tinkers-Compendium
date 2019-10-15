package lance5057.tDefense.core.addons.botania.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.core.handler.ModSounds;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.entity.EntityManaBurst;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

public class ModBeam extends ModifierTDTrait {

	private static final String TAG_ATTACKER_USERNAME = "attackerUsername";
	private static final int MANA_PER_DAMAGE = 100;

	public ModBeam() {
		super("beam", 0x55ff55);
	}
	
	@Override
	public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage,
			boolean isCritical) {
		if (!player.world.isRemote) {
			if(player instanceof EntityPlayer)
			trySpawnBurst((EntityPlayer) player);
		}
	}
	
	public void trySpawnBurst(EntityPlayer player) {
		if (!player.getHeldItemMainhand().isEmpty()
				&& player.getCooledAttackStrength(0) == 1) {
			EntityManaBurst burst = getBurst(player, player.getHeldItemMainhand());
			player.world.spawnEntity(burst);
			ToolCommons.damageItem(player.getHeldItemMainhand(), 1, player, MANA_PER_DAMAGE);
			player.world.playSound(null, player.posX, player.posY, player.posZ, ModSounds.terraBlade, SoundCategory.PLAYERS, 0.4F, 1.4F);
		}
	}
	
	public EntityManaBurst getBurst(EntityPlayer player, ItemStack stack) {
		EntityManaBurst burst = new EntityManaBurst(player, EnumHand.MAIN_HAND);

		float motionModifier = 7F;
		
		//TinkerUtil.getMaterialsFromTagList(TagUtil.getBaseMaterialsTagList(stack)).get(0).materialTextColor;

		burst.setColor(TinkerUtil.getMaterialsFromTagList(TagUtil.getBaseMaterialsTagList(stack)).get(0).materialTextColor);
		burst.setMana(MANA_PER_DAMAGE);
		burst.setStartingMana(MANA_PER_DAMAGE);
		burst.setMinManaLoss(40);
		burst.setManaLossPerTick(4F);
		burst.setGravity(0F);
		burst.setMotion(burst.motionX * motionModifier, burst.motionY * motionModifier, burst.motionZ * motionModifier);

		ItemStack lens = stack.copy();
		ItemNBTHelper.setString(lens, TAG_ATTACKER_USERNAME, player.getName());
		burst.setSourceLens(lens);
		return burst;
	}

	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (!(stack.getItem() instanceof ToolCore)) {
			return false;
		}

		// not present yet, ok
		if (super.canApplyCustom(stack)) {
			return true;
		}
		// no max level
//		else if (maxLevel == 0) {
//			return false;
//		}

		// already present, limit by level
		NBTTagCompound tag = TinkerUtil.getModifierTag(stack, identifier);

		return ModifierNBT.readTag(tag).level <= maxLevel;
	}

	@Override
	protected ModifierAspect[] getAspects() {
		return new ModifierAspect[] { ModifierAspect.freeModifier };
	}

}
