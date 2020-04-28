package lance5057.tDefense.core.library;

import lance5057.tDefense.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.client.CreativeTab;

public abstract class ModuleBase 
{	
	CreativeTab tab;
	
	public abstract void preInit(FMLPreInitializationEvent e);
	
	public abstract void init(FMLInitializationEvent e);
	
	public abstract void postInit(FMLPostInitializationEvent e);
	
//	public abstract void registerItems(final RegistryEvent.Register<Item> event);
//	
//	public abstract void registerBlocks(final RegistryEvent.Register<Block> event);
	
//	protected void setupItem(Item i, String name) {
//		i.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setCreativeTab(tab);
//	}
//
//	protected void setupBlock(Block b, String name) {
//		b.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setCreativeTab(tab);
//	}
}
