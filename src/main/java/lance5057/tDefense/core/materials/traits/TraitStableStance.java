package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitStableStance extends AbstractTrait {

	public TraitStableStance() {
		super("stablestance", TextFormatting.DARK_PURPLE);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.isSneaking())
		{
			player.removePotionEffect(MobEffects.LEVITATION);
			ToolHelper.damageTool(tool, 50, null);
		}
	}
}
