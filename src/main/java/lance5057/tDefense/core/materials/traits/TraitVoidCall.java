package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.TCConfig;
import lance5057.tDefense.core.library.ArmorHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitVoidCall extends AbstractTDTrait
{
	public TraitVoidCall() {
		super("voidcall", TextFormatting.WHITE);
	}

	@Override
	  public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.posY <= 0)
		{
			player.motionY+=3.0;
			ArmorHelper.damageTool(tool, 10, player);
		}
	  }
}
