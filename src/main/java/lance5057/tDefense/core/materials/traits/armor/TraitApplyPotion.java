package lance5057.tDefense.core.materials.traits.armor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitApplyPotion extends AbstractTrait {
	List<PotionEffect> pots = new ArrayList<PotionEffect>();
	boolean rand = false;

	public TraitApplyPotion(String identifier, TextFormatting color, boolean randChoice, PotionEffect... pot) {
		super(identifier, color);
		rand = randChoice;
		pots.addAll(Arrays.asList(pot));
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		Collection<PotionEffect> effects = player.getActivePotionEffects();
		
		if(!compare(effects))
		{
			if(rand)
			{
				int i = world.rand.nextInt(pots.size());
				player.addPotionEffect(pots.get(i));
			}
			else
			{
				for(PotionEffect p: pots)
				{
					player.addPotionEffect(p);
				}
			}
		}
	}
	
	private boolean compare(Collection<PotionEffect> effects)
	{
		for(PotionEffect p: pots)
		{
			for(PotionEffect e: effects)
			{
				if(e == p)
				{
					return false;
				}
			}
		}
		return true;
	}
}
