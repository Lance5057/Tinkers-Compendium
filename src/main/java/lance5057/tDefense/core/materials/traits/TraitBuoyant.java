package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitBuoyant extends AbstractTDTrait
{
	public TraitBuoyant() {
		super("buoyant", TextFormatting.AQUA);
	}

	@Override
	  public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.isInWater())
		{
			if(!player.isSneaking())
			{
				player.motionY += 0.01f;
			}
		}
	  }
}
