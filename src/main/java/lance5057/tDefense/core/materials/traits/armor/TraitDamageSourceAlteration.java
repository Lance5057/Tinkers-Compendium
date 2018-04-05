package lance5057.tDefense.core.materials.traits.armor;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import scala.actors.threadpool.Arrays;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitDamageSourceAlteration extends AbstractTDTrait {
	List<DamagePercent> damageTypes = new ArrayList<DamagePercent>();

	public TraitDamageSourceAlteration(String name, int icolor, DamagePercent... itypes) {
		super(name, icolor);
		damageTypes.addAll(Arrays.asList(itypes));
	}
	
	@Override
	public void onDamageTaken(LivingHurtEvent e) {
		
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
