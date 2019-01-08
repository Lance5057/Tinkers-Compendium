package lance5057.tDefense.core.addons.bloodmagic.modifiers;

import WayofTime.bloodmagic.core.data.SoulNetwork;
import WayofTime.bloodmagic.core.data.SoulTicket;
import WayofTime.bloodmagic.util.helper.NetworkHelper;
import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.utils.ToolHelper;
import net.minecraftforge.fml.common.Optional;

public class ModScabbing extends ModifierTDTrait {

	public ModScabbing() {
		super("scabbing", 0xFF0000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			SoulNetwork s = NetworkHelper.getSoulNetwork(player);
			int dur = ToolHelper.getMaxDurability(tool) - ToolHelper.getCurrentDurability(tool);
			if (dur > 0) {
				s.syphonAndDamage(player, new SoulTicket(5));
				ToolHelper.repairTool(tool, 1);
			}
		}
	}
}
