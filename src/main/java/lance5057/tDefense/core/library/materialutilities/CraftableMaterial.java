package lance5057.tDefense.core.library.materialutilities;

import java.io.PrintWriter;

import org.apache.commons.lang3.StringUtils;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TCBlocks;
import lance5057.tDefense.TCItems;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.library.OutputWikiPages;
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

	public String type;
	public String oreDict;

	boolean doNugget = true;
	boolean doIngot = true;
	boolean doBlock = true;

	public Item ingot;
	public Item nugget;

	public Block block;
	public Item itemBlock;

	public CraftableMaterial(HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra,
			ShieldMaterialStats shield, BowMaterialStats bow) {
		this("ingot", head, handle, extra, shield, bow);
	}

	public CraftableMaterial(String type, HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra,
			ShieldMaterialStats shield, BowMaterialStats bow) {
		this.type = type;
		this.head = head;
		this.handle = handle;
		this.shield = shield;
		this.extra = extra;
		this.bow = bow;
	}

	public CraftableMaterial(String type, String ore, HeadMaterialStats head, HandleMaterialStats handle,
			ExtraMaterialStats extra, ShieldMaterialStats shield, BowMaterialStats bow) {
		this.type = type;
		this.head = head;
		this.handle = handle;
		this.shield = shield;
		this.extra = extra;
		this.bow = bow;

		this.oreDict = ore;
	}

	@Override
	public void setupPre(MaterialHelper mat) {
		if (doIngot && ingot == null) {
			ingot = TCItems.registerItem(type + "_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (doNugget && nugget == null) {
			nugget = TCItems.registerItem("nugget_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (doBlock && block == null) {
			block = TCBlocks.registerBlock("block_" + mat.mat.identifier, net.minecraft.block.material.Material.ROCK);
			TCItems.registerItemBlock("block_" + mat.mat.identifier, block, TinkersCompendium.tab);
		}

		mat.mat.setCraftable(true).setCastable(false);

		if (head != null)
			TinkerRegistry.addMaterialStats(mat.mat, head);
		if (handle != null)
			TinkerRegistry.addMaterialStats(mat.mat, handle);
		if (extra != null)
			TinkerRegistry.addMaterialStats(mat.mat, extra);
		if (shield != null)
			TinkerRegistry.addMaterialStats(mat.mat, shield);
		if (bow != null)
			TinkerRegistry.addMaterialStats(mat.mat, bow);
	}

	@Override
	public void setupPost(MaterialHelper mat) {
		if (doIngot)
			OreDictionary.registerOre(type + StringUtils.capitalize(mat.mat.identifier), new ItemStack(ingot));
		if (doNugget)
			OreDictionary.registerOre("nugget" + StringUtils.capitalize(mat.mat.identifier), new ItemStack(nugget));
		if (doBlock)
			OreDictionary.registerOre("block" + StringUtils.capitalize(mat.mat.identifier), new ItemStack(block));
	}

	@Override
	public void setupClient(MaterialHelper mat) {
		if (doIngot)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, ingot);
		if (doNugget)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, nugget);
		if (doBlock) {
			TinkersCompendium.proxy.registerBlockColorHandler(mat.color, block);
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, Item.getItemFromBlock(block));
		}
	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupModels(MaterialHelper mat) {
		if (doIngot)
			TinkersCompendium.proxy.registerItemRenderer(ingot, 0, type);
		if (doNugget)
			TinkersCompendium.proxy.registerItemRenderer(nugget, 0, "nugget");

		if (doBlock) {
			TinkersCompendium.proxy.registerBlockRenderer(block, "block");
			TinkersCompendium.proxy.registerItemBlockRenderer(block, 0, "componentblock");
		}
	}

	@Override
	public void setupInit(MaterialHelper mat) {
		if (ingot != null) {
			mat.mat.addItem(ingot, 1, Material.VALUE_Ingot);
			mat.mat.setRepresentativeItem(ingot);
		}
		if (nugget != null)
			mat.mat.addItem(nugget, 1, Material.VALUE_Nugget);
		if (block != null)
			mat.mat.addItem(block, Material.VALUE_Block);

		if (ingot != null)
			mat.mat.addItem(type + StringUtils.capitalize(mat.mat.identifier), 1, mat.mat.VALUE_Ingot);
		if (nugget != null)
			mat.mat.addItem("nugget" + StringUtils.capitalize(mat.mat.identifier), 1, mat.mat.VALUE_Nugget);
		if (block != null)
			mat.mat.addItem("block" + StringUtils.capitalize(mat.mat.identifier), 1, mat.mat.VALUE_Block);

		if (oreDict != null)
			mat.mat.addItem(oreDict, 1, mat.mat.VALUE_Ingot);
	}

	public CraftableMaterial disableIngot() {
		this.doIngot = false;
		return this;
	}

	public CraftableMaterial disableNugget() {
		this.doNugget = false;
		return this;
	}

	public CraftableMaterial disableBlock() {
		this.doBlock = false;
		return this;
	}

	@Override
	public void setupWiki(MaterialHelper mat, PrintWriter out) {
		OutputWikiPages.createMaterialOutput(head, handle, shield, extra, bow, out);
	}

}
