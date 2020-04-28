package lance5057.tDefense.core.entities;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.library.ModuleBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CompendiumEntities  extends ModuleBase {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "phantomwolf"), EntityPhantomWolf.class, "phantomwolf", 0, Reference.MOD_ID, 80, 3, true, 0, 1);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

}
