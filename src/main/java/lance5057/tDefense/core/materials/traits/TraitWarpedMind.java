package lance5057.tDefense.core.materials.traits;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.TD_Config;
import lance5057.tDefense.core.tools.TDToolEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitWarpedMind extends AbstractTrait {

	List<ResourceLocation> sounds = new ArrayList<ResourceLocation>();

	public TraitWarpedMind() {
		super("warpedmind", TextFormatting.WHITE);

		sounds.add(new ResourceLocation("block.chest.open"));
		sounds.add(new ResourceLocation("block.end_portal.spawn"));
		sounds.add(new ResourceLocation("block.glass.break"));
		sounds.add(new ResourceLocation("block.slime.place"));
		sounds.add(new ResourceLocation("block.wooden_door.close"));
		sounds.add(new ResourceLocation("block.wooden_door.open"));
		sounds.add(new ResourceLocation("entity.bat.death"));
		sounds.add(new ResourceLocation("entity.blaze.ambient"));
		sounds.add(new ResourceLocation("entity.cat.hiss"));
		sounds.add(new ResourceLocation("entity.chicken.death"));
		sounds.add(new ResourceLocation("entity.cow.death"));
		sounds.add(new ResourceLocation("entity.creeper.death"));
		sounds.add(new ResourceLocation("entity.creeper.primed"));
		sounds.add(new ResourceLocation("entity.donkey.death"));
		sounds.add(new ResourceLocation("entity.endermen.death"));
		sounds.add(new ResourceLocation("entity.endermen.scream"));
		sounds.add(new ResourceLocation("entity.endermen.stare"));
		sounds.add(new ResourceLocation("entity.firework.blast"));
		sounds.add(new ResourceLocation("entity.firework.large_blast"));
		sounds.add(new ResourceLocation("entity.ghast.ambient"));
		sounds.add(new ResourceLocation("entity.ghast.scream"));
		sounds.add(new ResourceLocation("entity.horse.angry"));
		sounds.add(new ResourceLocation("entity.horse.death"));
		sounds.add(new ResourceLocation("entity.husk.ambient"));
		sounds.add(new ResourceLocation("entity.lightning.impact"));
		sounds.add(new ResourceLocation("entity.lightning.thunder"));
		sounds.add(new ResourceLocation("entity.llama.death"));
		sounds.add(new ResourceLocation("entity.parrot.death"));
		sounds.add(new ResourceLocation("entity.pig.death"));
		sounds.add(new ResourceLocation("entity.player.breath"));
		sounds.add(new ResourceLocation("entity.polar_bear.death"));
		sounds.add(new ResourceLocation("entity.rabbit.death"));
		sounds.add(new ResourceLocation("entity.sheep.death"));
		sounds.add(new ResourceLocation("entity.shulker.death"));
		sounds.add(new ResourceLocation("entity.silverfish.death"));
		sounds.add(new ResourceLocation("entity.skeleton.ambient"));
		sounds.add(new ResourceLocation("entity.skeleton.death"));
		sounds.add(new ResourceLocation("entity.spider.death"));
		sounds.add(new ResourceLocation("entity.stray.death"));
		sounds.add(new ResourceLocation("entity.tnt.primed"));
		sounds.add(new ResourceLocation("entity.vex.death"));
		sounds.add(new ResourceLocation("entity.villager.death"));
		sounds.add(new ResourceLocation("entity.vindication_illager.death"));
		sounds.add(new ResourceLocation("entity.witch.ambient"));
		sounds.add(new ResourceLocation("entity.witch.death"));
		sounds.add(new ResourceLocation("entity.wither_skeleton.death"));
		sounds.add(new ResourceLocation("entity.wolf.death"));
		sounds.add(new ResourceLocation("entity.wolf.howl"));
		sounds.add(new ResourceLocation("entity.zombie.attack_door_wood"));
		sounds.add(new ResourceLocation("entity.zombie.ambient"));
		sounds.add(new ResourceLocation("block.lever.click"));
		sounds.add(new ResourceLocation("entity.generic.explode"));
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		AxisAlignedBB axisalignedbb = player.getEntityBoundingBox();

		List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(player, axisalignedbb);

		for (int i = 0; i < list.size(); ++i) {
			Entity entity = list.get(i);

			if (entity instanceof EntityXPOrb) {
				int rand = world.rand.nextInt(100);
				int chance = world.rand.nextInt(100); // reduce how often it happens so its not just white noise
				
				if (chance < 10) {
					if (rand < 50) {
						if (!world.isRemote && !TD_Config.KiddyCoastersMakeMeRetch)
							player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 20, 1 * player.experienceLevel));
					} 
					else if (rand >= 50 && rand < 80) 
					{
						if (world.isRemote)
						{
							playRandomSound(player);
						}
					} 
					else if (rand >= 80 && rand < 90)
					{
						TDToolEvents.overlayJumpTimer = world.rand.nextInt(30)+5;
					}
					else 
					{
						player.addExperience(1);
					}
				}
			}
		}
	}

	void playRandomSound(EntityPlayer player) {
		float volume = player.experienceLevel;

		if (volume > 20)
			volume = 20;

		int rand = player.world.rand.nextInt(sounds.size());
		player.playSound(SoundEvent.REGISTRY.getObject(sounds.get(rand)), volume * 0.5f,
				player.world.rand.nextInt(10) - 5);
	}
}
