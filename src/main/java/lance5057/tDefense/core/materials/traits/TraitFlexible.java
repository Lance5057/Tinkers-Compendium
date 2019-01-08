package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitFlexible extends AbstractTDTrait {

	public TraitFlexible() {
		super("flexible", TextFormatting.BLUE);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.isSneaking())
			player.stepHeight = 0.60001f;
		else
			player.stepHeight = 1.25f;
	}
}
