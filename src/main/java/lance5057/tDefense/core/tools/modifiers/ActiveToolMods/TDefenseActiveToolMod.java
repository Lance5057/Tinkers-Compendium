package lance5057.tDefense.core.tools.modifiers.ActiveToolMods;

import java.util.Random;

import cpw.mods.fml.common.Loader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.tools.ToolCore;



public class TDefenseActiveToolMod extends ActiveToolMod 
{
	TdefenseToolMods TDMods = new TdefenseToolMods();
	BotaniaToolMods FlowerMods = new BotaniaToolMods();
	

	@Override
	public void updateTool(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("InfiTool"))
		{
			NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");
			
			if (!tags.getBoolean("Broken")) 
			{
				//TDefense
				TDMods.UpdateAll(tool, stack, world, entity, tags);
				
				//Botania
				if(Loader.isModLoaded("Botania"))
				{
					FlowerMods.UpdateAll(tool, stack, world, entity, tags);
				}
				
			}
		}
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
