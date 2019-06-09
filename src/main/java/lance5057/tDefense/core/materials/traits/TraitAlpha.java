package lance5057.tDefense.core.materials.traits;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class TraitAlpha extends AbstractTDTrait {

	public TraitAlpha() {
		super("alpha", 0x6d3300);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		AxisAlignedBB bb = new AxisAlignedBB(player.posX + 5, player.posY + 5, player.posZ + 5, player.posX - 5, player.posY - 5, player.posZ - 5);
		List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(player, bb);
		
		for(Entity e: entities)
		{
			if(e instanceof EntityWolf)
			{
				EntityWolf wolf = (EntityWolf)e;
				if(!wolf.isTamed())
				{
					if(player.experienceLevel > 0)
					{
						wolf.setTamedBy(player);
						player.addExperienceLevel(-1);
					}
				}
			}
		}
	}
}
