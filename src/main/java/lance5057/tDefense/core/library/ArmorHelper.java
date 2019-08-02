package lance5057.tDefense.core.library;

import java.util.List;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import lance5057.tDefense.core.library.events.TinkerArmorEvent;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.event.ForgeEventFactory;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.TinkerNetwork;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.events.TinkerToolEvent;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.TinkersItem;
import slimeknights.tconstruct.library.tools.ranged.IProjectile;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.common.network.ToolBreakAnimationPacket;
import slimeknights.tconstruct.tools.modifiers.ModReinforced;

public final class ArmorHelper {
	/* Tool Durability */

	public static int getCurrentDurability(ItemStack stack) {
		return stack.getMaxDamage() - stack.getItemDamage();
	}

	public static int getMaxDurability(ItemStack stack) {
		return stack.getMaxDamage();
	}

	/**
	 * Damages the tool. Entity is only needed in case the tool breaks for rendering
	 * the break effect.
	 */
	public static void damageTool(ItemStack stack, int amount, EntityLivingBase entity) {
		if (amount == 0 || isBroken(stack)) {
			return;
		}

		int actualAmount = amount;

		for (ITrait trait : TinkerUtil.getTraitsOrdered(stack)) {
			if (amount > 0) {
				actualAmount = trait.onToolDamage(stack, amount, actualAmount, entity);
			} else {
				actualAmount = trait.onToolHeal(stack, amount, actualAmount, entity);
			}
		}

		// extra compatibility for unbreaking.. because things just love to mess it up..
		// like 3rd party stuff
		if (actualAmount > 0 && TagUtil.getTagSafe(stack).getBoolean(ModReinforced.TAG_UNBREAKABLE)) {
			actualAmount = 0;
		}

		// ensure we never deal more damage than durability
		actualAmount = Math.min(actualAmount, getCurrentDurability(stack));
		stack.setItemDamage(stack.getItemDamage() + actualAmount);

		if (getCurrentDurability(stack) == 0) {
			breakTool(stack, entity);
		}
	}

	public static void healTool(ItemStack stack, int amount, EntityLivingBase entity) {
		damageTool(stack, -amount, entity);
	}

	public static boolean isBroken(ItemStack stack) {
		return TagUtil.getToolTag(stack).getBoolean(Tags.BROKEN);
	}

	public static void breakTool(ItemStack stack, EntityLivingBase entity) {
		NBTTagCompound tag = TagUtil.getToolTag(stack);
		tag.setBoolean(Tags.BROKEN, true);
		TagUtil.setToolTag(stack, tag);

		if (entity instanceof EntityPlayerMP) {
			TinkerNetwork.sendTo(new ToolBreakAnimationPacket(stack), (EntityPlayerMP) entity);
		}
	}

	public static void unbreakTool(ItemStack stack) {
		if (isBroken(stack)) {
			// ensure correct damage value
			stack.setItemDamage(stack.getMaxDamage());

			// setItemDamage might break the tool again, so we do this afterwards
			NBTTagCompound tag = TagUtil.getToolTag(stack);
			tag.setBoolean(Tags.BROKEN, false);
			TagUtil.setToolTag(stack, tag);
		}
	}

	public static void repairTool(ItemStack stack, int amount) {
		// entity is optional, only needed for rendering break effect, never needed when
		// repairing
		repairTool(stack, amount, null);
	}

	public static void repairTool(ItemStack stack, int amount, EntityLivingBase entity) {
		unbreakTool(stack);

		TinkerArmorEvent.OnRepair.fireEvent(stack, amount);

		healTool(stack, amount, entity);
	}
}