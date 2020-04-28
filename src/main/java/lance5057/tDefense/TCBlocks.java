package lance5057.tDefense;

import java.util.ArrayList;
import java.util.List;

import com.typesafe.config.ConfigException.Generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class TCBlocks {

	public static List<Block> blocks = new ArrayList<Block>();

	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub

	}

	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub

	}

	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub

	}
	
	public static Block registerBlock(String name, Material mat) {
		Block block = new Block(mat)
				.setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
		blocks.add(block);
		return block;
	}
	
	public static Block registerBlock(Block block,String name) {
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
		blocks.add(block);
		return block;
	}

	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		for (Block i : blocks) {
			event.getRegistry().register(i);
		}
	}
}
