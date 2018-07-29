package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TraitPiggy extends AbstractTDTrait {

	public TraitPiggy() {
		super("piggy", 0xef9e9b);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if (player.getFoodStats().needFood()) {
			for (int i = 0; i < player.inventory.mainInventory.size(); i++) {
				ItemStack stack = player.inventory.mainInventory.get(i);
				if(stack.getItem() instanceof ItemFood)
				{
					ItemFood food = (ItemFood) stack.getItem();
					
					food.onItemUseFinish(stack, world, player);
					
//					player.getFoodStats().addStats(food.getHealAmount(stack), food.getSaturationModifier(stack));
//					player.inventory.decrStackSize(i, 1);
					
		            world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
					
					break;
				}
			}
		}
	}

}
