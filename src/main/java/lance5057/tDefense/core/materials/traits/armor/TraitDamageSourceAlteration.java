package lance5057.tDefense.core.materials.traits.armor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitDamageSourceAlteration extends AbstractTDTrait {
	List<DamagePercent> damageTypes = new ArrayList<DamagePercent>();

	public TraitDamageSourceAlteration(String name, int icolor, DamagePercent... itypes) {
		super(name, icolor);
		damageTypes.addAll(Arrays.asList(itypes));
	}
	
	public TraitDamageSourceAlteration(String name, TextFormatting icolor, DamagePercent... itypes) {
		super(name, icolor);
		damageTypes.addAll(Arrays.asList(itypes));
	}
	
	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		for(DamagePercent d: damageTypes)
		{
			if(e.getSource() == d.type)
			{
				float damage = e.getAmount();
				float alteration = damage * d.percent;
				
				damage += alteration;
				e.setAmount(damage);
			}
		}
	}
	
	public static class DamagePercent
	{
		public DamageSource type;
		public float percent;
		
		public DamagePercent(DamageSource d, float p)
		{
			type = d;
			percent = p;
		}
	}
}
