package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.util.ArmorTagUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class TraitStatuesque extends AbstractTDTrait {
	public TraitStatuesque() {
		super("statuesque", TextFormatting.RED);
	}

	private static long counter = 0;
	static final int ticksToRun = 2;
	private static Map<EntityPlayer, Vec3d> previousPlayerPos = new HashMap<>();

	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if(world.isRemote) return;
		if((counter++ % ticksToRun) == 0)
		{
			previousPlayerPos.putIfAbsent(player, new Vec3d(player.posX, player.posY, player.posZ));
			if (Math.abs(player.posX - previousPlayerPos.get(player).x) < 0.0001 && Math.abs(player.posY - previousPlayerPos.get(player).y) < 0.0001 && Math.abs(player.posZ - previousPlayerPos.get(player).z) < 0.0001) {
				for (Entity e : world.getLoadedEntityList()) {
					if (e instanceof EntityMob) {
						EntityMob mob = (EntityMob) e;

						mob.setAttackTarget(null);
					}
				}
				player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 40, 2, true, false));
			}
			previousPlayerPos.put(player, new Vec3d(player.posX, player.posY, player.posZ));
		}
	}


}

