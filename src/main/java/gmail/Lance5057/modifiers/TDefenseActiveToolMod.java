package gmail.Lance5057.modifiers;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.tools.ToolCore;

public class TDefenseActiveToolMod extends ActiveToolMod {
	@Override
	public int baseAttackDamage(int earlyModDamage, int damage, ToolCore tool,
			NBTTagCompound tags, NBTTagCompound toolTags, ItemStack stack,
			EntityLivingBase player, Entity entity) {
		if (!toolTags.hasKey("Broken")) {
			if (toolTags.hasKey("Daze")) {
				int[] array = toolTags.getIntArray("Daze");
				int chance = array[0] * 5;

				Random roll = new Random();
				int num = roll.nextInt(100) + 1;

				if (num <= chance) {
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(2, 3 * 20, 100));
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(9, 3 * 20, 100));
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(15, 3 * 20, 100));
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(18, 3 * 20, 100));
				}
			}
		}

		return 0;
	}
}
