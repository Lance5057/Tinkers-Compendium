package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class TraitCombatAdvantage extends AbstractTDTrait {
	int timer = 0;

	public TraitCombatAdvantage() {
		super("combatadvantage", TextFormatting.DARK_PURPLE);
	}

	@Override
	public void onDamagePre(ItemStack tool, LivingAttackEvent e) {
		if (timer == 0) {
			e.setCanceled(true);
			timer = 2400;
		}
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(timer > 0)
		{
			timer--;
		}
	}

}
