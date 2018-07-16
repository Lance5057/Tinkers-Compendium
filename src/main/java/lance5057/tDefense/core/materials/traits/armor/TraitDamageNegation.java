package lance5057.tDefense.core.materials.traits.armor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitDamageNegation extends AbstractTDTrait {
	List<DamageSource> damageTypes = new ArrayList<DamageSource>();
	float negate = 0;

	public TraitDamageNegation(String identifier, TextFormatting color, float amount) {
		super(identifier, color);
		negate = amount;
	}
	
	public TraitDamageNegation(String identifier, TextFormatting color, float amount, DamageSource... sources) {
		super(identifier, color);
		negate = amount;
		damageTypes.addAll(Arrays.asList(sources));
	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {

		if (damageTypes.size() > 0) {
			for (DamageSource d : damageTypes) {
				if (d == e.getSource() && e.getAmount() <= negate) {
					ToolHelper.damageTool(tool, (int) e.getAmount(), e.getEntityLiving());
					e.setCanceled(true);
				}
			}
		} else {
			if (e.getAmount() <= negate) {
				ToolHelper.damageTool(tool, (int) e.getAmount(), e.getEntityLiving());
				e.setCanceled(true);
			}
		}
	}

}
