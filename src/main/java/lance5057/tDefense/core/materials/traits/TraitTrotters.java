package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitTrotters extends AbstractTrait {

	public TraitTrotters() {
		super("trotters", TextFormatting.RED);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(player.isRiding())
		{
			if(player.getRidingEntity() instanceof EntityPig)
			{
				EntityPig p = (EntityPig) player.getRidingEntity();
				
				p.addPotionEffect(new PotionEffect(MobEffects.SPEED, 10, 2));
			}
		}
	}
}
