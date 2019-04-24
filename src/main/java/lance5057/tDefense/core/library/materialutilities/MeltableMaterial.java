package lance5057.tDefense.core.library.materialutilities;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

public class MeltableMaterial implements MaterialBase {

	public FluidMolten fluid;
	public HeadMaterialStats head;
	public HandleMaterialStats handle;
	public ShieldMaterialStats shield;
	public ExtraMaterialStats extra;
	public BowMaterialStats bow;

	int temp;

	public Item ingot;
	public Item nugget;

	public Block block;
	public Item itemBlock;
	boolean hasBlockTexture;

	public MeltableMaterial(int temp, HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra,
			ShieldMaterialStats shield, BowMaterialStats bow) {
		this(temp, head, handle, extra, shield, bow, false);
	}

	public MeltableMaterial(int temp, HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra,
			ShieldMaterialStats shield, BowMaterialStats bow, boolean hasBlockTexture) {
		this.temp = temp;
		this.head = head;
		this.handle = handle;
		this.shield = shield;
		this.extra = extra;
		this.bow = bow;

		this.hasBlockTexture = hasBlockTexture;
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

		fluid = fluidMetal(mat.getIdentifier(), mat.materialTextColor, temp);
		CompendiumMaterials.fluids.put(mat.getIdentifier(), fluid);

		mat.setCraftable(false).setCastable(true);
		mat.setFluid(fluid);

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

		mat.addItem(nugget, 1, Material.VALUE_Nugget);
		mat.addItem(ingot, 1, Material.VALUE_Ingot);
		mat.addItem(block, Material.VALUE_Block);
	}

	@Override
	public void setupClient(Material mat) {
		TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, ingot);
		TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, nugget);
		if (!hasBlockTexture) {
			TinkersCompendium.proxy.registerBlockColorHandler(mat.materialTextColor, block);
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, Item.getItemFromBlock(block));
		}
	}

	public FluidMolten fluidMetal(String name, int color, int temp) {

		FluidMolten f = registerFluid(new FluidMolten(name, color));
		f.setTemperature(800);
		initFluidMetal(f);

		return f;
	}

	public void initFluidMetal(Fluid fluid) {
		registerMoltenBlock(fluid);
		FluidRegistry.addBucketForFluid(fluid);
		TinkersCompendium.proxy.registerFluidModels(fluid);
	}

	public <T extends Fluid> T registerFluid(T fluid) {
		fluid.setUnlocalizedName(Reference.MOD_ID + "." + fluid.getName().toLowerCase(Locale.US));
		FluidRegistry.registerFluid(fluid);
		return fluid;
	}

	public BlockMolten registerMoltenBlock(Fluid fluid) {
		BlockMolten block = new BlockMolten(fluid);
		return registerBlock(block, "molten_" + fluid.getName());
	}

	public <T extends Block> T registerBlock(T block, String name) {
		block.setUnlocalizedName(Reference.MOD_ID + "." + name);
		block.setRegistryName(Reference.MOD_ID + "." + name);
		Item ib = new ItemBlock(block).setRegistryName(block.getRegistryName());
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(ib);
		return block;
	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		mi.fluid = fluid;

	}

	@Override
	public void setupModels(Material mat) {
		TinkersCompendium.proxy.registerItemRenderer(ingot, 0, "ingot");
		TinkersCompendium.proxy.registerItemRenderer(nugget, 0, "nugget");
		if (!hasBlockTexture) {
			TinkersCompendium.proxy.registerBlockRenderer(block, "block");
			TinkersCompendium.proxy.registerItemBlockRenderer(block, 0, "componentblock");
		}
	}

	@Override
	public void setupInit(Material mat) {
		// TODO Auto-generated method stub
		
	}
}
