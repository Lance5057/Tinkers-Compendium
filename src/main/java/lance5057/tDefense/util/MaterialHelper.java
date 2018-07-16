package lance5057.tDefense.util;

import java.util.Locale;

import org.codehaus.plexus.util.StringUtils;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.materials.TDMaterials;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import lance5057.tDefense.proxy.ClientProxy.ColorHandler;
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
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

public class MaterialHelper {
	public MaterialHelper(String name, int color, int temp, HeadMaterialStats head, HandleMaterialStats handle,
			ExtraMaterialStats extra, ShieldMaterialStats shield, BowMaterialStats bow, HelmMaterialStats helm,
			ChestMaterialStats chest, LegsMaterialStats legs, FeetMaterialStats feet) {
		this.name = name;
		this.color = color;
		this.temp = temp;
		this.head = head;
		this.handle = handle;
		this.extra = extra;
		this.shield = shield;
		this.bow = bow;
		this.helm = helm;
		this.chest = chest;
		this.legs = legs;
		this.feet = feet;
	}

	// Make Components Only
	public MaterialHelper(String name, int color) {
		this.name = name;
		this.color = color;
		genMaterial = false;
		genFluid = false;
	}

	// Make Components Only
	public MaterialHelper(String name, int color, boolean castable) {
		this.name = name;
		this.color = color;
		genMaterial = false;
		this.genFluid = castable;
		this.cast = castable;
	}

	public MaterialHelper addPremadeItems(Item ingot, Item nugget, Item dust, Item grain, Item plate, Item coin,
			Item gear, Item rod) {
		this.ingot = ingot;
		this.nugget = nugget;
		this.dust = dust;
		this.grain = grain;
		this.plate = plate;
		this.coin = coin;
		this.gear = gear;
		this.rod = rod;
		return this;
	}

	public Material mat;
	public MaterialIntegration matint;

	public FluidMolten fluid;

	public Item ingot;
	public Item nugget;
	public Item dust;
	public Item grain;
	public Item plate;
	public Item coin;
	public Item gear;
	public Item rod;

	public String name;
	public int color;
	public int temp;

	public boolean genMaterial = true;
	public boolean genFluid = true;
	public boolean cast = true;

	public HeadMaterialStats head;
	public HandleMaterialStats handle;
	public ExtraMaterialStats extra;
	public ShieldMaterialStats shield;
	public BowMaterialStats bow;
	public HelmMaterialStats helm;
	public ChestMaterialStats chest;
	public LegsMaterialStats legs;
	public FeetMaterialStats feet;

	public void setupPre() {

		// aeonsteel.addItem("ingotAeonsteel", 1, Material.VALUE_Ingot);

		if (ingot == null) {
			ingot = registerItem("ingot_" + name);
			TDMaterials.itemList.add(ingot);
		}

		if (nugget == null) {
			nugget = registerItem("nugget_" + name);
			TDMaterials.itemList.add(nugget);
		}

		if (dust == null) {
			dust = registerItem("dust_" + name);
			TDMaterials.itemList.add(dust);
		}
		if (grain == null) {
			grain = registerItem("grain_" + name);
			TDMaterials.itemList.add(grain);
		}

		if (plate == null) {
			plate = registerItem("plate_" + name);
			TDMaterials.itemList.add(plate);
		}

		if (coin == null) {
			coin = registerItem("coin_" + name);
			TDMaterials.itemList.add(coin);
		}

		if (gear == null) {
			gear = registerItem("gear_" + name);
			TDMaterials.itemList.add(gear);
		}

		if (rod == null) {
			rod = registerItem("rod_" + name);
			TDMaterials.itemList.add(rod);
		}

		if (genFluid)
			fluid = fluidMetal(name, color, temp);

		if (genMaterial) {
			mat = new Material(name, color);

			if (fluid != null)
				mat.setFluid(fluid);

			
			mat.setCraftable(!cast).setCastable(cast);

			TinkerRegistry.addMaterialStats(mat, head);
			TinkerRegistry.addMaterialStats(mat, handle);
			TinkerRegistry.addMaterialStats(mat, extra);
			TinkerRegistry.addMaterialStats(mat, shield);
			TinkerRegistry.addMaterialStats(mat, bow);
			TinkerRegistry.addMaterialStats(mat, helm);
			TinkerRegistry.addMaterialStats(mat, chest);
			TinkerRegistry.addMaterialStats(mat, legs);
			TinkerRegistry.addMaterialStats(mat, feet);

			matint = new MaterialIntegration(mat, fluid, StringUtils.capitalise(name));
			matint.toolforge().preInit();

			TinkersDefense.proxy.registerMatColor(mat, color);

			TinkerRegistry.integrate(matint);
		}
	}

	public void setupPost() {
		OreDictionary.registerOre("ingot" + StringUtils.capitalise(name), new ItemStack(ingot));
		OreDictionary.registerOre("nugget" + StringUtils.capitalise(name), new ItemStack(nugget));
		OreDictionary.registerOre("dust" + StringUtils.capitalise(name), new ItemStack(dust));
		OreDictionary.registerOre("grain" + StringUtils.capitalise(name), new ItemStack(grain));
		OreDictionary.registerOre("coin" + StringUtils.capitalise(name), new ItemStack(coin));
		OreDictionary.registerOre("plate" + StringUtils.capitalise(name), new ItemStack(plate));
		OreDictionary.registerOre("gear" + StringUtils.capitalise(name), new ItemStack(gear));
		OreDictionary.registerOre("rod" + StringUtils.capitalise(name), new ItemStack(rod));

		if (genMaterial)
			matint.integrate();
	}

	public void setupModels() {
		TinkersDefense.proxy.registerItemRenderer(ingot, 0, "ingot");
		TinkersDefense.proxy.registerItemRenderer(dust, 0, "dust");
		TinkersDefense.proxy.registerItemRenderer(nugget, 0, "nugget");
		TinkersDefense.proxy.registerItemRenderer(grain, 0, "grain");
		TinkersDefense.proxy.registerItemRenderer(coin, 0, "coin");
		TinkersDefense.proxy.registerItemRenderer(plate, 0, "plate");
		TinkersDefense.proxy.registerItemRenderer(rod, 0, "rod");
		TinkersDefense.proxy.registerItemRenderer(gear, 0, "gear");
	}

	public void setupClient() {
		TinkersDefense.proxy.registerItemColorHandler(new ColorHandler(color), ingot);
		TinkersDefense.proxy.registerItemColorHandler(new ColorHandler(color), nugget);
		TinkersDefense.proxy.registerItemColorHandler(new ColorHandler(color), dust);
		TinkersDefense.proxy.registerItemColorHandler(new ColorHandler(color), grain);
		TinkersDefense.proxy.registerItemColorHandler(new ColorHandler(color), coin);
		TinkersDefense.proxy.registerItemColorHandler(new ColorHandler(color), gear);
		TinkersDefense.proxy.registerItemColorHandler(new ColorHandler(color), plate);
		TinkersDefense.proxy.registerItemColorHandler(new ColorHandler(color), rod);
	}

	public Item registerItem(String name) {
		return new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
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
		TinkersDefense.proxy.registerFluidModels(fluid);
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
}
