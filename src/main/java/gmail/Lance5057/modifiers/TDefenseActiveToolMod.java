package gmail.Lance5057.modifiers;

import java.util.Random;

import mods.battlegear2.api.PlayerEventChild;
import mods.battlegear2.api.core.IBattlePlayer;
import mods.battlegear2.api.core.InventoryPlayerBattle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.tools.ToolCore;

public class TDefenseActiveToolMod extends ActiveToolMod {
	@Override
	public void updateTool(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
//		NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");
//		
//		if (!tags.hasKey("Broken")) {
//			if(((IBattlePlayer)entity).isBlockingWithShield())
//			{
//				if(ShieldEvent.source.getEntity() instanceof EntityFireball)
//				{
//					
//				}
//			}
//		}
	}
	
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
