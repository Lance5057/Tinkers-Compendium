package lance5057.tDefense.core.materials.traits;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitSpiny extends AbstractTDTrait {

	protected static final AxisAlignedBB CACTUS_COLLISION_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D, 0.9375D);
	
	public TraitSpiny() {
		super("spiny", TextFormatting.GREEN);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		List<Entity> l = world.getEntitiesInAABBexcluding(player, CACTUS_COLLISION_AABB, null);
		
		for(Entity e: l)
		{
			if(e instanceof EntityLiving)
			{
				EntityLiving living = (EntityLiving) e;
				living.attackEntityFrom(DamageSource.CACTUS, 1);
			}
		}
	}
}
