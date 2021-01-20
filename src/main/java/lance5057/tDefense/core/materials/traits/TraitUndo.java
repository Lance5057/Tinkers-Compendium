package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.core.library.ArmorHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.utils.ToolHelper;

import java.util.Random;

public class TraitUndo extends AbstractTDTrait {

	public TraitUndo() {
		super("undo", 0xa470e0);
	}

	public void onArmorTick(ItemStack tool, World world, EntityPlayer player)
	{
		if(!world.isRemote && !ArmorHelper.isBroken(tool))
		{
			float hp=player.getHealth();

			int repair = player.experienceLevel * 4;

			float health=hp;

			if(health < 5 && player.experienceLevel > 1)
			{
				player.setHealth(10);
				ArmorHelper.repairTool(tool, repair);
				player.addExperienceLevel(-1);
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION,200, 5));
				player.addPotionEffect(new PotionEffect(MobEffects.SATURATION,200, 5, true, false));
			}
		}
	}
}
