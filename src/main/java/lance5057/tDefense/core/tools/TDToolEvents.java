package lance5057.tDefense.core.tools;

import java.util.UUID;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.core.tools.bases.Shield;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDToolEvents {
	public static int overlayJumpTimer = 0;
	// public static boolean overlayHelm = false;

	public static AttributeModifier td_stoned = new AttributeModifier(UUID.randomUUID(), "td_stoned", -0.01f, 0);

	public static AttributeModifier td_currentrider = new AttributeModifier(UUID.randomUUID(), "td_currentrider", 0.05f,
			0);
	public static AttributeModifier td_fins = new AttributeModifier(UUID.randomUUID(), "td_fins", 1.0f, 0);

	public static AttributeModifier td_knockback = new AttributeModifier(UUID.randomUUID(), "td_knockback", 0.5f, 0);

	public static AttributeModifier td_hotfoot = new AttributeModifier(UUID.randomUUID(), "td_hotfoot", 0.1f, 0);

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
		removeAttributes(event.player);
		onArmorTick(event);
	}

	@SubscribeEvent
	public void DamagePre(LivingAttackEvent e) {
		for (ItemStack tool : e.getEntityLiving().getArmorInventoryList()) {
			if (tool != null && tool.getItem() instanceof ArmorCore && !ToolHelper.isBroken(tool)) {
				NBTTagList list = TagUtil.getTraitsTagList(tool);
				for (int i = 0; i < list.tagCount(); i++) {
					if (TinkerRegistry.getTrait(list.getStringTagAt(i)) instanceof ITrait) {
						ITrait trait = TinkerRegistry.getTrait(list.getStringTagAt(i));
						if (trait != null && trait instanceof AbstractTDTrait) {
							((AbstractTDTrait) trait).onDamagePre(tool, e);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	void onItemPickup(EntityItemPickupEvent e) {
		for (ItemStack tool : e.getEntityLiving().getArmorInventoryList()) {
			if (tool != null && tool.getItem() instanceof ArmorCore && !ToolHelper.isBroken(tool)) {
				NBTTagList list = TagUtil.getTraitsTagList(tool);
				for (int i = 0; i < list.tagCount(); i++) {
					if (TinkerRegistry.getTrait(list.getStringTagAt(i)) instanceof AbstractTDTrait) {
						AbstractTDTrait trait = (AbstractTDTrait)TinkerRegistry.getTrait(list.getStringTagAt(i));
						if (trait != null) {
							trait.onItemPickup(e);
						}
					}
				}
			}
		}
	}

	void onArmorTick(TickEvent.PlayerTickEvent event) {
		for (ItemStack tool : event.player.getArmorInventoryList()) {
			if (tool != null && tool.getItem() instanceof ArmorCore && !ToolHelper.isBroken(tool)) {
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
		if (event.getEntity() == null) {
			return;
		}

		// we allow block traits to affect both main and offhand
		for (ItemStack tool : event.getEntity().getArmorInventoryList()) {
			if (tool != null && tool.getItem() instanceof ArmorCore && !ToolHelper.isBroken(tool)) {
				NBTTagList list = TagUtil.getTraitsTagList(tool);
				for (int i = 0; i < list.tagCount(); i++) {
					if (TinkerRegistry.getTrait(list.getStringTagAt(i)) instanceof AbstractTDTrait) {
						AbstractTDTrait trait = (AbstractTDTrait) TinkerRegistry.getTrait(list.getStringTagAt(i));
						if (trait != null) {
							trait.onDamageTaken(tool, event);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void playerAte(LivingEntityUseItemEvent.Finish e) {
		if (e.getItem().getItem() instanceof ItemFood) {
			for (ItemStack tool : e.getEntity().getArmorInventoryList()) {
				if (tool != null && tool.getItem() instanceof ArmorCore && !ToolHelper.isBroken(tool)) {
					NBTTagList list = TagUtil.getTraitsTagList(tool);
					for (int i = 0; i < list.tagCount(); i++) {
						if (TinkerRegistry.getTrait(list.getStringTagAt(i)) instanceof AbstractTDTrait) {
							AbstractTDTrait trait = (AbstractTDTrait) TinkerRegistry.getTrait(list.getStringTagAt(i));
							if (trait != null) {
								trait.onFoodEaten(e);
							}
						}
					}
				}
			}
		}
	}

	void removeAttributes(EntityPlayer player) {
		// Speed Mods
		IAttributeInstance att = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

		if (att.hasModifier(td_currentrider))
			att.removeModifier(td_currentrider);
		if (att.hasModifier(td_fins))
			att.removeModifier(td_fins);
		if (att.hasModifier(td_stoned))
			att.removeModifier(td_stoned);
		if (att.hasModifier(td_hotfoot))
			att.removeModifier(td_hotfoot);

		// Knockback Mods
		att = player.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);

		if (att.hasModifier(td_knockback))
			att.removeModifier(td_knockback);
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
