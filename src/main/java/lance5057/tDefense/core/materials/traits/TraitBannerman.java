package lance5057.tDefense.core.materials.traits;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TraitBannerman extends AbstractTDTrait {
	public TraitBannerman() {
		super("bannerman", TextFormatting.YELLOW);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		AxisAlignedBB bb = new AxisAlignedBB(player.posX + 25, player.posY + 25, player.posZ + 25, player.posX - 25,
				player.posY - 25, player.posZ - 25);
		List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(player, bb);

		for (Entity e : entities) {
			if (e instanceof EntityPlayer) {
				EntityPlayer p = (EntityPlayer) e;
				
				if(p.isOnSameTeam(player))
				{
					p.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 10, 1, false, false));
					p.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 10, 1, false, false));
				}
			}
		}
	}
}
