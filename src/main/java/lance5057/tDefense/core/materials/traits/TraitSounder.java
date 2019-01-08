package lance5057.tDefense.core.materials.traits;

import java.util.List;

import lance5057.tDefense.core.library.ai.EntityAITemptArmor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitSounder extends AbstractTDTrait {

	public TraitSounder() {
		super("sounder", TextFormatting.RED);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		AxisAlignedBB aabb = new AxisAlignedBB(-10 + player.posX, -10 + player.posY, -10 + player.posZ,
				10 + player.posX, 10 + player.posY, 10 + player.posZ);
		List<Entity> ents = world.getEntitiesInAABBexcluding(player, aabb, null);

		for (Entity e : ents) {
			if (e instanceof EntityPig) {
				EntityPig p = (EntityPig) e;
				EntityAITemptArmor ai = new EntityAITemptArmor(p, 1, false, null);
				
				boolean contains = false;
				for(EntityAITaskEntry task: p.targetTasks.taskEntries)
					if(task.action instanceof EntityAITemptArmor)
						contains = true;
				
				if(!contains)
					p.targetTasks.addTask(0, ai);
			}

			// if (e instanceof EntityPigZombie) {
			// EntityPigZombie p = (EntityPigZombie) e;
			// p.setAttackTarget(null);
			// p.setRevengeTarget(null);
			//
			// NBTTagCompound compound = p.serializeNBT();
			// NBTTagCompound tag = compound.getCompoundTag("ForgeData");
			// tag.setShort("Anger", (short) 0);
			// tag.setString("HurtBy", "");
			//
			// compound.setShort("Anger", (short) 0);
			// compound.setString("HurtBy", UUID.randomUUID().toString());
			// compound.setTag("ForgeData", tag);
			//
			// p.readEntityFromNBT(compound);
			// }
		}
	}
}
