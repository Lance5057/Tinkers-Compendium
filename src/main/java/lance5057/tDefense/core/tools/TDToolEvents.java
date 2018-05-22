package lance5057.tDefense.core.tools;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import lance5057.tDefense.core.materials.traits.ITDTrait;
import lance5057.tDefense.core.tools.bases.Shield;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TDToolEvents {

	public TDToolEvents() {

	}

	@SubscribeEvent(priority = EventPriority.LOW)
	// lower priority so we get called later since we change tool NBT
	public void reducedDamageBlocked(LivingHurtEvent event) {
		if (event.getSource().isUnblockable() || event.getSource().isMagicDamage() || event.getSource().isExplosion()
				|| event.isCanceled()) {
			return;
		}

		if (event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if (player.getActiveItemStack() != null && player.getActiveItemStack().getItem() != null
					&& player.getActiveItemStack().getItem() instanceof Shield
					&& !ToolHelper.isBroken(player.getActiveItemStack())) {
				ItemStack shield = player.getActiveItemStack();

				int damage = event.getAmount() < 2f ? 1 : Math.round(event.getAmount() / 2f);

				event.setAmount(event.getAmount() * 0.7f);
				if (event.getSource().isProjectile()) {
					event.setAmount(0);
				}

				ToolHelper.damageTool(shield, damage, player);
			}
		}
	}

	@SubscribeEvent
	public void ArmorTick(TickEvent.PlayerTickEvent event) {
		onArmorTick(event);
	}

	ItemStack armorChanged(TickEvent.PlayerTickEvent event, ItemStack prev, ItemStack cur) {
		if (prev.getItem() != cur.getItem()) {
			if (prev != null && prev.getItem() instanceof ToolCore && !ToolHelper.isBroken(prev)) {
				NBTTagList list = TagUtil.getTraitsTagList(prev);
				for (int i = 0; i < list.tagCount(); i++) {
					if (TinkerRegistry.getTrait(list.getStringTagAt(i)) instanceof ITrait) {
						ITrait trait = TinkerRegistry.getTrait(list.getStringTagAt(i));
						if (trait instanceof AbstractTDTrait) {
							AbstractTDTrait t = (AbstractTDTrait) trait;
							if (trait != null) {
								t.onArmorUnequip(event.player);
							}
						}
					}
				}
			}

			if (cur != null && cur.getItem() instanceof ToolCore && !ToolHelper.isBroken(cur)) {
				NBTTagList list = TagUtil.getTraitsTagList(cur);
				for (int i = 0; i < list.tagCount(); i++) {
					if (TinkerRegistry.getTrait(list.getStringTagAt(i)) instanceof ITrait) {
						ITrait trait = TinkerRegistry.getTrait(list.getStringTagAt(i));
						if (trait instanceof AbstractTDTrait) {
							AbstractTDTrait t = (AbstractTDTrait) trait;
							if (trait != null) {
								t.onArmorEquip(event.player);
							}
						}
					}
				}
			}
			return cur;
		}

		return prev;
	}

	void onArmorTick(TickEvent.PlayerTickEvent event) {
		for (ItemStack tool : event.player.getArmorInventoryList()) {
			if (tool != null && tool.getItem() instanceof ToolCore && !ToolHelper.isBroken(tool)) {
				NBTTagList list = TagUtil.getTraitsTagList(tool);
				for (int i = 0; i < list.tagCount(); i++) {
					if (TinkerRegistry.getTrait(list.getStringTagAt(i)) instanceof ITrait) {
						ITrait trait = TinkerRegistry.getTrait(list.getStringTagAt(i));
						if (trait != null) {
							trait.onArmorTick(tool, event.player.world, event.player);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void playerDamagedEvent(LivingHurtEvent event) {
		if (event.getEntity() == null || !(event.getEntity() instanceof EntityPlayer)) {
			return;
		}

		// we allow block traits to affect both main and offhand
		for (ItemStack tool : event.getEntity().getArmorInventoryList()) {
			if (tool != null && tool.getItem() instanceof ToolCore && !ToolHelper.isBroken(tool)) {
				NBTTagList list = TagUtil.getTraitsTagList(tool);
				for (int i = 0; i < list.tagCount(); i++) {
					if (TinkerRegistry.getTrait(list.getStringTagAt(i)) instanceof ITDTrait) {
						ITDTrait trait = (ITDTrait) TinkerRegistry.getTrait(list.getStringTagAt(i));
						if (trait != null) {
							trait.onDamageTaken(event);
						}
					}
				}
			}
		}
	}

	// @SubscribeEvent
	// public void attackEvent(LivingAttackEvent e) {
	// boolean w = e.getEntity().worldObj.isRemote;
	// //Minecraft.getMinecraft().theWorld.isRemote;
	// if (!w) {
	// float damage = e.getAmount();
	// ItemStack activeItemStack;
	// EntityPlayer player;
	// if (!(e.getEntityLiving() instanceof EntityPlayer)) {
	// return;
	// }
	// player = (EntityPlayer) e.getEntityLiving();
	// if (player.getActiveItemStack() == null) {
	// return;
	// }
	// activeItemStack = player.getActiveItemStack();
	//
	// if (damage > 0.0F && activeItemStack != null
	// && activeItemStack.getItem() instanceof Shield) {
	// int i = 1 + MathHelper.floor_float(damage);
	// ToolHelper.damageTool(activeItemStack, i, player);
	//
	// if (activeItemStack.stackSize <= 0) {
	// EnumHand enumhand = player.getActiveHand();
	// net.minecraftforge.event.ForgeEventFactory
	// .onPlayerDestroyItem(player, activeItemStack,
	// enumhand);
	//
	// if (enumhand == EnumHand.MAIN_HAND) {
	// player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND,
	// (ItemStack) null);
	// } else {
	// player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND,
	// (ItemStack) null);
	// }
	//
	// activeItemStack = null;
	// if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
	// player.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F,
	// 0.8F + player.worldObj.rand.nextFloat() * 0.4F);
	// }
	// }
	// }
	// }
	// }
}
