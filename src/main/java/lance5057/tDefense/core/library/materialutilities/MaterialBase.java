package lance5057.tDefense.core.library.materialutilities;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.materials.Material;

public abstract interface MaterialBase {
	
	public abstract void setupPre(Material mat);
	public abstract void setupInit(Material mat);
	public abstract void setupIntegration(MaterialIntegration mi);
	public abstract void setupPost(Material mat);
	public abstract void setupClient(Material mat);
	public abstract void setupModels(Material mat);
	
	default Item registerItem(String name, CreativeTabs tab) {
		Item item = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
		item.setCreativeTab(tab);
		CompendiumMaterials.itemList.add(item);
		return item;
	}

	default Item registerItemBlock(String name, Block b, CreativeTabs tab) {
		Item item = new ItemBlock(b).setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
		item.setCreativeTab(tab);
		CompendiumMaterials.itemList.add(item);
		return item;
	}

	default Block registerBlock(String name) {
		Block block = new Block(net.minecraft.block.material.Material.IRON)
				.setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
		CompendiumMaterials.blockList.add(block);
		return block;
	}
}
