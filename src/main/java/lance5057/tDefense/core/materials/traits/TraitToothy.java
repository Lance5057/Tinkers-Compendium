package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitToothy extends AbstractTrait {

	public TraitToothy() {
		super("td_toothy", 0x6d3300);
	}

	@Override
	public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (ToolHelper.getCurrentDurability(tool) < ToolHelper.getMaxDurability(tool)) {
			if (entity instanceof EntityPlayer) {
				EntityPlayer p = (EntityPlayer) entity;
				if (p.getFoodStats().getSaturationLevel() > 0) {
					ToolHelper.healTool(tool, 10, p);
					p.getFoodStats().setFoodSaturationLevel(p.getFoodStats().getSaturationLevel() - 1);
				}
			}
		}
	}

}
