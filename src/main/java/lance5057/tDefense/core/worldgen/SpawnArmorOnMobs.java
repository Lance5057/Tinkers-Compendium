package lance5057.tDefense.core.worldgen;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TCConfig;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import lance5057.tDefense.core.tools.armor.cloth.TinkersHood;
import lance5057.tDefense.core.tools.armor.cloth.TinkersRobe;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShawl;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShoes;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class SpawnArmorOnMobs {

	@SubscribeEvent(priority = EventPriority.LOW)
	public void spawnArmor(EntityJoinWorldEvent e) {
		if (e.getEntity() instanceof EntityZombie || e.getEntity() instanceof EntityPigZombie
				|| e.getEntity() instanceof EntitySkeleton || e.getEntity() instanceof EntityWitherSkeleton
				|| e.getEntity() instanceof EntityHusk || e.getEntity() instanceof EntityStray) {
			
			EntityMob mob = (EntityMob) e.getEntity();
			World world = e.getWorld();
			DifficultyInstance dif = world.getDifficultyForLocation(e.getEntity().getPosition());

			// Overworld
			if (mob.dimension == 0) {
				// Easy
				if (dif.getClampedAdditionalDifficulty() < 0.25f) {
					int roll = world.rand.nextInt(100);
					String[] mats = TCConfig.materials.easyoverworld;
					Material[] fabrics = TinkerRegistry.getAllMaterialsWithStats(FabricMaterialStats.TYPE).toArray(new Material[0]);
					Material[] bowstrings = TinkerRegistry.getAllMaterialsWithStats(MaterialTypes.BOWSTRING).toArray(new Material[0]);

					// Cloth
					if (roll < 75) {
						int headRoll = world.rand.nextInt(100);
						int chestRoll = world.rand.nextInt(100);
						int legsRoll = world.rand.nextInt(100);
						int feetRoll = world.rand.nextInt(100);

						if (headRoll > 50) {
							TinkersHood hood = new TinkersHood();

							List<Material> tobuild = new ArrayList<Material>();
							tobuild.add(fabrics[world.rand.nextInt(fabrics.length)]);
							tobuild.add(fabrics[world.rand.nextInt(fabrics.length)]);
							tobuild.add(TinkerRegistry.getMaterial(mats[world.rand.nextInt(mats.length)]));
							ItemStack hoodStack = hood.buildItem(tobuild);

							mob.setItemStackToSlot(EntityEquipmentSlot.HEAD, hoodStack);
						}
						
						if (chestRoll > 50) {
							TinkersShawl hood = new TinkersShawl();

							List<Material> tobuild = new ArrayList<Material>();
							tobuild.add(fabrics[world.rand.nextInt(fabrics.length)]);
							tobuild.add(fabrics[world.rand.nextInt(fabrics.length)]);
							tobuild.add(TinkerRegistry.getMaterial(mats[world.rand.nextInt(mats.length)]));
							ItemStack hoodStack = hood.buildItem(tobuild);

							mob.setItemStackToSlot(EntityEquipmentSlot.CHEST, hoodStack);
						}
						
						if (legsRoll > 50) {
							TinkersRobe hood = new TinkersRobe();

							List<Material> tobuild = new ArrayList<Material>();
							tobuild.add(fabrics[world.rand.nextInt(fabrics.length)]);
							tobuild.add(fabrics[world.rand.nextInt(fabrics.length)]);
							tobuild.add(TinkerRegistry.getMaterial(mats[world.rand.nextInt(mats.length)]));
							ItemStack hoodStack = hood.buildItem(tobuild);

							mob.setItemStackToSlot(EntityEquipmentSlot.LEGS, hoodStack);
						}
						
						if (feetRoll > 50) {
							TinkersShoes hood = new TinkersShoes();

							List<Material> tobuild = new ArrayList<Material>();
							tobuild.add(fabrics[world.rand.nextInt(fabrics.length)]);
							tobuild.add(fabrics[world.rand.nextInt(fabrics.length)]);
							tobuild.add(TinkerRegistry.getMaterial(mats[world.rand.nextInt(mats.length)]));
							tobuild.add(bowstrings[world.rand.nextInt(bowstrings.length)]);
							ItemStack hoodStack = hood.buildItem(tobuild);

							mob.setItemStackToSlot(EntityEquipmentSlot.FEET, hoodStack);
						}
					}
				}
			}
		}
	}
}
