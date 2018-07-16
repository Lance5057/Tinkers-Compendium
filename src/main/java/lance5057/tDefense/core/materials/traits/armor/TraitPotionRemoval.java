package lance5057.tDefense.core.materials.traits.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitPotionRemoval extends AbstractTrait
{
	Potion[] effects;

	public TraitPotionRemoval(String identifier, TextFormatting color, Potion... pots) {
		super(identifier, color);
		effects = pots;
	}
	
	@Override
	public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
		if(entity instanceof EntityLiving)
		{
			EntityLiving l = (EntityLiving) entity;
			for(Potion m: effects)
			{
				PotionEffect pot = l.getActivePotionEffect(m);
				ToolHelper.damageTool(tool, pot.getDuration(), l);
				l.removePotionEffect(m);
			}
		}
	}

}
