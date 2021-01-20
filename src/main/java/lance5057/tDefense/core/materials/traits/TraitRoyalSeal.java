package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.core.tools.TDTools;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitRoyalSeal extends AbstractTDTrait {
	public TraitRoyalSeal() {
		super("royalseal", TextFormatting.YELLOW);
	}

	@Override
	public void onDamagePre(ItemStack tool, LivingAttackEvent e) {
		if (e.getSource() == DamageSource.MAGIC)
			if (e.getEntityLiving() instanceof EntityPlayer) {
				EntityPlayer p = (EntityPlayer) e.getEntityLiving();
				p.getCooldownTracker().setCooldown(Items.SHIELD, 100);
				p.getCooldownTracker().setCooldown(TDTools.kiteshield, 100);
				p.getCooldownTracker().setCooldown(TDTools.roundshield, 100);
				p.getEntityWorld().setEntityState(p, (byte) 30);
				
				ToolHelper.damageTool(tool, (int) Math.ceil(e.getAmount() * 5), null);
				e.setCanceled(true);
			}
	}
}
