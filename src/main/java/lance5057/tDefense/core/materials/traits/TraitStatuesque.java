package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitStatuesque extends AbstractTDTrait
{
	public TraitStatuesque() {
		super("statuesque", TextFormatting.RED);
	}
	
	@Override
	  public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.motionX == 0 && player.motionY == 0 && player.motionZ == 0)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 1));
		}
	  }
}
