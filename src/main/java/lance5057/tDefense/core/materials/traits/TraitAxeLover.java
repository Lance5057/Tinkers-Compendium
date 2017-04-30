package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.util.TDToolHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.tools.Hatchet;
import slimeknights.tconstruct.tools.tools.LumberAxe;
import slimeknights.tconstruct.tools.tools.Mattock;

public class TraitAxeLover extends AbstractTrait {

	public TraitAxeLover() {
		super("securiphilic", TextFormatting.GREEN);
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player,
			LivingHurtEvent event) {
		Entity src = event.getSource().getSourceOfDamage();
		if (src != null && src instanceof EntityLiving) {
			EntityLivingBase liv = (EntityLivingBase) src;

			if (liv.getHeldItemMainhand() != null) {
				ItemStack held = liv.getHeldItemMainhand();
				if (held.getItem() instanceof LumberAxe
						|| held.getItem() instanceof ItemAxe
						|| held.getItem() instanceof Hatchet
						|| held.getItem() instanceof Mattock) {
					if (player.world.rand.nextInt(100) < 5) {
						liv.entityDropItem(liv.getHeldItemMainhand(), 0f);
						liv.setHeldItem(EnumHand.MAIN_HAND, null);
					}
				}
			}
		}
	}
}
