package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.core.tools.TDToolEvents;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitHotFoot extends AbstractTrait {

	public TraitHotFoot() {
		super("hotfoot", TextFormatting.RED);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		IAttributeInstance att = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		if(player.isBurning())
		{
			if(!att.hasModifier(TDToolEvents.td_hotfoot))
				att.applyModifier(TDToolEvents.td_hotfoot);
		}
		else
			if(!att.hasModifier(TDToolEvents.td_hotfoot))
				att.removeModifier(TDToolEvents.td_hotfoot);
	}

}
