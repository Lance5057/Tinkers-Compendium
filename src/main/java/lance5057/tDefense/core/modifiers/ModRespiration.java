package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class ModRespiration extends ArmorModifierTrait {

	int level = 1;

	public ModRespiration(int level) {
		super("respiration" + level, 0x4444ff);
		this.level = level;
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if (player.getAir() <= 5) {
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (player.inventory.getStackInSlot(i) != null
						&& player.inventory.getStackInSlot(i).getItem() == CompendiumModifiers.item_canister) {
					if (level == 1) {
						player.inventory.decrStackSize(i, 1);
						player.inventory.addItemStackToInventory(new ItemStack(CompendiumModifiers.item_emptycanister, 1));
					}

					player.setAir(player.getAir() + 150);
					
					world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, player.posX + world.rand.nextDouble() - 0.5f, player.posY + 2 + world.rand.nextDouble() - 0.5f, player.posZ + world.rand.nextDouble() - 0.5f, 0, 1, 0, new int[0]);
					world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, player.posX + world.rand.nextDouble() - 0.5f, player.posY + 2 + world.rand.nextDouble() - 0.5f, player.posZ + world.rand.nextDouble() - 0.5f, 0, 1, 0, new int[0]);
					world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, player.posX + world.rand.nextDouble() - 0.5f, player.posY + 2 + world.rand.nextDouble() - 0.5f, player.posZ + world.rand.nextDouble() - 0.5f, 0, 1, 0, new int[0]);
					world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, player.posX + world.rand.nextDouble() - 0.5f, player.posY + 2 + world.rand.nextDouble() - 0.5f, player.posZ + world.rand.nextDouble() - 0.5f, 0, 1, 0, new int[0]);
					world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, player.posX + world.rand.nextDouble() - 0.5f, player.posY + 2 + world.rand.nextDouble() - 0.5f, player.posZ + world.rand.nextDouble() - 0.5f, 0, 1, 0, new int[0]);

					break;
				}
			}
		}
	}
	
	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (!(stack.getItem() instanceof ArmorCore)) {
			return false;
		}
		
		//Helmet only
		if(((ArmorCore)stack.getItem()).armorType != EntityEquipmentSlot.HEAD)
			return false;
		
		// not present yet, ok
		if (super.canApplyCustom(stack)) {
			return true;
		}
		// no max level
		else if (maxLevel == 0) {
			return false;
		}

		// already present, limit by level
		NBTTagCompound tag = TinkerUtil.getModifierTag(stack, identifier);

		return ModifierNBT.readTag(tag).level <= maxLevel;
	}
}
