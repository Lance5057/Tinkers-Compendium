package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TraitHunt extends AbstractTDTrait {

	public TraitHunt() {
		super("hunt", 0x6d3300);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.isSprinting())
			player.addExhaustion(-(0.1F * 24 * 0.01F));
	}
}
