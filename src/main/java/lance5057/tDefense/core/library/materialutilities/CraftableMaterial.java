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

	public String type;

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

	@Override
	public void setupPre(Material mat) {
		if (doIngot && ingot == null) {
			ingot = registerItem(type + "_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(ingot);
		}

		if (doNugget && nugget == null) {
			nugget = registerItem("nugget_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(nugget);
		}

		if (doBlock && block == null) {
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
		if (doIngot)
			OreDictionary.registerOre(type + StringUtils.capitalize(mat.identifier), new ItemStack(ingot));
		if (doNugget)
			OreDictionary.registerOre("nugget" + StringUtils.capitalize(mat.identifier), new ItemStack(nugget));
		if (doBlock)
			OreDictionary.registerOre("block" + StringUtils.capitalize(mat.identifier), new ItemStack(block));

		
		
		
	}

	@Override
	public void setupClient(Material mat) {
		if (doIngot)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, ingot);
		if (doNugget)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, nugget);
		if (doBlock) {
			TinkersCompendium.proxy.registerBlockColorHandler(mat.materialTextColor, block);
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, Item.getItemFromBlock(block));
		}
	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupModels(Material mat) {
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
	public void setupInit(Material mat) {
		if (ingot != null)
		{
			mat.addItem(ingot, Material.VALUE_Ingot, 1);
			mat.setRepresentativeItem(ingot);
		}
		if (nugget != null)
			mat.addItem(nugget, Material.VALUE_Nugget, 1);
		if (block != null)
			mat.addItem(block, Material.VALUE_Block);
		
		mat.addItem(type + StringUtils.capitalize(mat.identifier), mat.VALUE_Ingot, 1);
		mat.addItem("nugget" + StringUtils.capitalize(mat.identifier), mat.VALUE_Nugget, 1);
		mat.addItem("block" + StringUtils.capitalize(mat.identifier), mat.VALUE_Block, 1);
			
	}
	
	public CraftableMaterial disableIngot()
	{
		this.doIngot = false;
		return this;
	}
	
	public CraftableMaterial disableNugget()
	{
		this.doNugget = false;
		return this;
	}
	
	public CraftableMaterial disableBlock()
	{
		this.doBlock = false;
		return this;
	}

}
