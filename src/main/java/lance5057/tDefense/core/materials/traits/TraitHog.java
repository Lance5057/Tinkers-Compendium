package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitHog extends AbstractTDTrait {

	public TraitHog() {
		super("hog", 0xef9e9b);
	}

	@Override
	public void onItemPickup(EntityItemPickupEvent e) {
		if (e.getItem().getItem().getItem() instanceof ItemFood) {

			ItemStack stack = e.getItem().getItem();
			ItemFood food = (ItemFood) stack.getItem();
			EntityLivingBase ent = e.getEntityLiving();

			float amount = ((food.getHealAmount(stack) * food.getSaturationModifier(stack)) / 4) * stack.getCount();

			for (ItemStack armor : ent.getArmorInventoryList()) {
				if (armor.getItem() instanceof ArmorCore) {
					ToolHelper.damageTool(armor, (int) -amount, null);
				}
			}

			stack.setCount(0);
			stack.damageItem(1000, null);

			ent.world.playSound((EntityPlayer) null, ent.posX, ent.posY, ent.posZ, SoundEvents.ENTITY_PIG_AMBIENT,
					SoundCategory.PLAYERS, 0.5F, ent.world.rand.nextFloat() * 0.1F + 0.9F);
		}
	}
}
