package lance5057.tDefense.util;

import java.util.ArrayList;

import lance5057.tDefense.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class BlocksBase {
	protected static ArrayList<Block> blockList = new ArrayList<Block>(); 
	protected static ArrayList<Item> itemList = new ArrayList<Item>(); 
	public BlocksBase()
	{
		
	}
	
	public abstract void preInit(FMLPreInitializationEvent e);
	
	public abstract void init(FMLInitializationEvent e);
	
	public abstract void postInit(FMLPostInitializationEvent e);
	
	protected Block setupRegister(String name, CreativeTabs tabName, float hardness) 
	{
		Block block = new Block(Material.IRON).setCreativeTab(tabName).setUnlocalizedName(name).setRegistryName(Reference.MOD_ID, name).setHardness(hardness);
		blockList.add(block);
		return block;
	}
	
	protected ItemBlock setupRegister(String name, int size, CreativeTabs tabName, Block block) 
	{
		ItemBlock item = new ItemBlock(block);
		item.setCreativeTab(tabName).setMaxStackSize(size).setUnlocalizedName(name).setRegistryName(Reference.MOD_ID, name).setCreativeTab(tabName);
		itemList.add(item);
		return item;
	}
	

}
	
//	protected MetaItem registerMeta(String name, String[] names,int size) 
//	{
//		Item item = new MetaItem(names).setCreativeTab(tabName).setMaxStackSize(size).setUnlocalizedName(name).setRegistryName(Reference.MOD_ID, name);
//
//		GameRegistry.register(item);
//		return (MetaItem) item;
//	}