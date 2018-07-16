package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent.Finish;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public abstract class AbstractTDTrait extends AbstractTrait {
	public AbstractTDTrait(String identifier, TextFormatting color) {
		super(identifier, color);
	}

	public AbstractTDTrait(String identifier, int color) {
		super(identifier, color);
	}

	public void onArmorEquip(EntityPlayer e) {

	}

	public void onArmorUnequip(EntityPlayer e) {

	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
	}

	public void onFoodEaten(LivingEntityUseItemEvent.Finish e) {

	}
}
