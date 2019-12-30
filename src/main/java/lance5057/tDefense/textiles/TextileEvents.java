package lance5057.tDefense.textiles;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TextileEvents {

	@SubscribeEvent
	public static void addToGrassDrops(HarvestDropsEvent e) {
		if (e.getState().getBlock() instanceof BlockTallGrass) {

			if (e.getWorld().rand.nextInt(100) <= TinkersCompendium.config.textiles.grassFiberDropPercent)
				e.getDrops().add(new ItemStack(CompendiumTextiles.grassFiber));
			
			if (e.getWorld().rand.nextInt(100) <= TinkersCompendium.config.textiles.cottonSeedDropPercent)
				e.getDrops().add(new ItemStack(CompendiumTextiles.cottonSeed));
		}
	}

}
