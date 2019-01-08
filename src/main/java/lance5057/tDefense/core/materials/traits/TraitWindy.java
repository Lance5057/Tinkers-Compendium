package lance5057.tDefense.core.materials.traits;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitWindy extends AbstractTDTrait {

	public TraitWindy() {
		super("windy", TextFormatting.BLUE);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		AxisAlignedBB aabb = new AxisAlignedBB(-10, -10, -10, 10, 10, 10);
		List<Entity> ents = world.getEntitiesInAABBexcluding(player, aabb, null);

		for (Entity e : ents) {
			if (e instanceof EntityPotion) {
				e.setDead();
			}
		}
	}
}
