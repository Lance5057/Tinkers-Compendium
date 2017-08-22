package lance5057.tDefense.core.tools;

import lance5057.tDefense.core.tools.bases.Shield;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TDToolEvents {

	public TDToolEvents() {

	}

	@SubscribeEvent(priority = EventPriority.LOW)
	// lower priority so we get called later since we change tool NBT
	public void reducedDamageBlocked(LivingHurtEvent event) {
		if (event.getSource().isUnblockable()
				|| event.getSource().isMagicDamage()
				|| event.getSource().isExplosion() || event.isCanceled()) {
			return;
		}

		if (event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if (player.getActiveItemStack() != null
					&& player.getActiveItemStack().getItem() != null
					&& player.getActiveItemStack().getItem() instanceof Shield
					&& !ToolHelper.isBroken(player.getActiveItemStack())) {
				ItemStack shield = player.getActiveItemStack();

				int damage = event.getAmount() < 2f ? 1 : Math.round(event
						.getAmount() / 2f);

				event.setAmount(event.getAmount() * 0.7f);
				if (event.getSource().isProjectile()) {
					event.setAmount(0);
				}

				ToolHelper.damageTool(shield, damage, player);
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
