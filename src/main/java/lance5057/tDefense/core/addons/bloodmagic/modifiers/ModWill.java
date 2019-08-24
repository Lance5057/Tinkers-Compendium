package lance5057.tDefense.core.addons.bloodmagic.modifiers;

import java.util.ArrayList;
import java.util.List;

import WayofTime.bloodmagic.core.RegistrarBloodMagicItems;
import WayofTime.bloodmagic.soul.EnumDemonWillType;
import WayofTime.bloodmagic.soul.IDemonWill;
import WayofTime.bloodmagic.soul.PlayerDemonWillHandler;
import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class ModWill extends ModifierTDTrait {

	public ModWill() {
		super("will", 0xAAAAFF);
	}

	@Override
	public void onEnemyDrops(LivingDropsEvent e, ItemStack tool, EntityLivingBase attacker) {
		if (attacker instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) attacker;
			EntityLivingBase attackedEntity = e.getEntityLiving();

			IDemonWill soul = ((IDemonWill) RegistrarBloodMagicItems.MONSTER_SOUL);

			EnumDemonWillType type = EnumDemonWillType.DEFAULT;

			List<ItemStack> droppedSouls = new ArrayList<ItemStack>();

			for (int i = 0; i <= ToolHelper.getFortuneLevel(tool); i++) {
				if (i == 0 || player.getEntityWorld().rand.nextDouble() < 0.4) {
					ItemStack soulStack = soul.createWill(type.ordinal(),
							1 * (1 * player.getEntityWorld().rand.nextDouble() + 1) * e.getEntityLiving().getMaxHealth()
									/ 20d);
					droppedSouls.add(soulStack);
				}
			}

			if (!droppedSouls.isEmpty()) {
				ItemStack remainder;
				for (ItemStack willStack : droppedSouls) {
					remainder = PlayerDemonWillHandler.addDemonWill(player, willStack);

					if (!remainder.isEmpty()) {
						EnumDemonWillType pickupType = ((IDemonWill) remainder.getItem()).getType(remainder);
						if (((IDemonWill) remainder.getItem()).getWill(pickupType, remainder) >= 0.0001) {
							e.getDrops().add(new EntityItem(attackedEntity.getEntityWorld(), attackedEntity.posX,
									attackedEntity.posY, attackedEntity.posZ, remainder));
						}
					}
				}
				player.inventoryContainer.detectAndSendChanges();
			}
		}
	}

	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (!(stack.getItem() instanceof ToolCore || stack.getItem() instanceof ToolCore)) {
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
