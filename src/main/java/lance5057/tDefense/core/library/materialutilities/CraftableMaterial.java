package lance5057.tDefense.core.library.materialutilities;

import org.apache.commons.lang3.StringUtils;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

public class CraftableMaterial implements MaterialBase {
	public HeadMaterialStats head;
	public HandleMaterialStats handle;
	public ShieldMaterialStats shield;
	public ExtraMaterialStats extra;
	public BowMaterialStats bow;

	public Item ingot;
	public Item nugget;

	public Block block;
	public Item itemBlock;

	public CraftableMaterial(HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra,
			ShieldMaterialStats shield, BowMaterialStats bow) {
		this.head = head;
		this.handle = handle;
		this.shield = shield;
		this.extra = extra;
		this.bow = bow;
	}

	@Override
	public void setupPre(Material mat) {
		if (ingot == null) {
			ingot = registerItem("ingot_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(ingot);
		}

		if (nugget == null) {
			nugget = registerItem("nugget_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(nugget);
		}

		if (block == null) {
			block = new Block(net.minecraft.block.material.Material.IRON)
					.setRegistryName(new ResourceLocation(Reference.MOD_ID, "block_" + mat.identifier))
					.setUnlocalizedName("block_" + mat.identifier).setCreativeTab(TinkersCompendium.tab);
			CompendiumMaterials.blockList.add(block);
			CompendiumMaterials.itemList
					.add(registerItemBlock("block_" + mat.identifier, block, TinkersCompendium.tab));
		}

		mat.setCraftable(true).setCastable(false);

		if (head != null)
			TinkerRegistry.addMaterialStats(mat, head);
		if (handle != null)
			TinkerRegistry.addMaterialStats(mat, handle);
		if (extra != null)
			TinkerRegistry.addMaterialStats(mat, extra);
		if (shield != null)
			TinkerRegistry.addMaterialStats(mat, shield);
		if (bow != null)
			TinkerRegistry.addMaterialStats(mat, bow);
	}

	@Override
	public void setupPost(Material mat) {
		OreDictionary.registerOre("ingot" + StringUtils.capitalize(mat.identifier), new ItemStack(ingot));
		OreDictionary.registerOre("nugget" + StringUtils.capitalize(mat.identifier), new ItemStack(nugget));
		OreDictionary.registerOre("block" + StringUtils.capitalize(mat.identifier), new ItemStack(block));
		
		mat.setRepresentativeItem(ingot);
	}

	@Override
	public void setupClient(Material mat) {
		TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, ingot);
		TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, nugget);
		TinkersCompendium.proxy.registerBlockColorHandler(mat.materialTextColor, block);
		TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, Item.getItemFromBlock(block));
	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupModels(Material mat) {
		TinkersCompendium.proxy.registerItemRenderer(ingot, 0, "ingot");
		TinkersCompendium.proxy.registerItemRenderer(nugget, 0, "nugget");

		TinkersCompendium.proxy.registerBlockRenderer(block, "block");
		TinkersCompendium.proxy.registerItemBlockRenderer(block, 0, "componentblock");
	}

	@Override
	public void setupInit(Material mat) {
		mat.addItem(ingot, Material.VALUE_Ingot, 1);
		mat.addItem(nugget,Material.VALUE_Nugget, 1);
		mat.addItem(block, Material.VALUE_Block);
	}

}
