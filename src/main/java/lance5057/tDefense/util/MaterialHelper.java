package lance5057.tDefense.util;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.blocks.ComponentDoor;
import lance5057.tDefense.core.blocks.ComponentPane;
import lance5057.tDefense.core.blocks.ComponentStake;
import lance5057.tDefense.core.blocks.ComponentTrapDoor;
import lance5057.tDefense.core.blocks.TDOreBlock;
import lance5057.tDefense.core.items.ComponentItemDoor;
import lance5057.tDefense.core.materials.TDMaterials;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
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

	public MaterialHelper(String name, int color, FabricMaterialStats fabric) {
		this.name = name;
		this.color = color;
		this.fabric = fabric;

		genFluid = false;
		genComponents = false;
		cast = false;
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

	public ItemStack repItem;

	public MaterialHelper setRepItem(ItemStack repItem) {
		this.repItem = repItem;
		return this;
	}

	public Item ingot;
	public Item nugget;
	public Item dust;
	public Item grain;
	public Item plate;
	public Item coin;
	public Item gear;
	public Item rod;
	public Item oreClump;

	public BlockOre ore;
	public Block block;
	public ComponentDoor door;
	public ComponentTrapDoor trapdoor;
	public ComponentStake stake;
	public ComponentPane bars;

	public MaterialHelper setGenIngot(boolean genIngot) {
		this.genIngot = genIngot;
		return this;
	}

	public MaterialHelper setGenNugget(boolean genNugget) {
		this.genNugget = genNugget;
		return this;
	}

	public MaterialHelper setGenDust(boolean genDust) {
		this.genDust = genDust;
		return this;
	}

	public MaterialHelper setGenGrain(boolean genGrain) {
		this.genGrain = genGrain;
		return this;
	}

	public MaterialHelper setGenPlate(boolean genPlate) {
		this.genPlate = genPlate;
		return this;
	}

	public MaterialHelper setGenCoin(boolean genCoin) {
		this.genCoin = genCoin;
		return this;
	}

	public MaterialHelper setGenGear(boolean genGear) {
		this.genGear = genGear;
		return this;
	}

	public MaterialHelper setGenRod(boolean genRod) {
		this.genRod = genRod;
		return this;
	}

	public MaterialHelper setGenOre(boolean genOre) {
		this.genOre = genOre;
		return this;
	}

	public MaterialHelper setGenBlock(boolean genBlock) {
		this.genBlock = genBlock;
		return this;
	}

	public MaterialHelper setGenStake(boolean genStake) {
		this.genStake = genStake;
		return this;
	}

	public MaterialHelper setGenBars(boolean genBars) {
		this.genBars = genBars;
		return this;
	}

	public MaterialHelper setGenDoor(boolean genDoor) {
		this.genDoor = genDoor;
		return this;
	}

	public MaterialHelper setGenTrapdoor(boolean genTrapdoor) {
		this.genTrapdoor = genTrapdoor;
		return this;
	}

	public String oreIngot = "";
	public String oreNugget = "";

	public MaterialHelper setOreIngot(String oreIngot) {
		this.oreIngot = oreIngot;
		this.genIngot = false;
		return this;
	}

	public MaterialHelper setOreNugget(String oreNugget) {
		this.oreNugget = oreNugget;
		this.genNugget = false;
		return this;
	}

	public boolean genComponents = true;

	public boolean genIngot = true;
	public boolean genNugget = true;
	public boolean genDust = true;
	public boolean genGrain = true;
	public boolean genPlate = true;
	public boolean genCoin = true;
	public boolean genGear = true;
	public boolean genRod = true;
	public boolean genOre = false;
	public boolean genBlock = false;
	public boolean genStake = true;
	public boolean genBars = true;
	public boolean genDoor = true;
	public boolean genTrapdoor = true;

	public String name;
	public int color;
	public int temp;

	public boolean genMaterial = true;
	public boolean genFluid = true;

	public MaterialHelper setGenFluid(boolean genFluid) {
		this.genFluid = genFluid;
		return this;
	}

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
	public FabricMaterialStats fabric;

	public void setupPre() {

		// aeonsteel.addItem("ingotAeonsteel", 1, Material.VALUE_Ingot);

		if (genComponents) {
			if (ingot == null && genIngot) {
				ingot = registerItem("ingot_" + name);
				TDMaterials.itemList.add(ingot);
			}

			if (nugget == null && genNugget) {
				nugget = registerItem("nugget_" + name);
				TDMaterials.itemList.add(nugget);
			}

			if (dust == null && genDust) {
				dust = registerItem("dust_" + name);
				TDMaterials.itemList.add(dust);
			}
			if (grain == null && genGrain) {
				grain = registerItem("grain_" + name);
				TDMaterials.itemList.add(grain);
			}

			if (plate == null && genPlate) {
				plate = registerItem("plate_" + name);
				TDMaterials.itemList.add(plate);
			}

			if (coin == null && genCoin) {
				coin = registerItem("coin_" + name);
				TDMaterials.itemList.add(coin);
			}

			if (gear == null && genGear) {
				gear = registerItem("gear_" + name);
				TDMaterials.itemList.add(gear);
			}

			if (rod == null && genRod) {
				rod = registerItem("rod_" + name);
				TDMaterials.itemList.add(rod);
			}

			if (block == null && genBlock) {
				block = new Block(net.minecraft.block.material.Material.IRON)
						.setRegistryName(new ResourceLocation(Reference.MOD_ID, "block_" + name))
						.setUnlocalizedName("block_" + name);
				TDMaterials.blockList.add(block);
				TDMaterials.itemList.add(registerItemBlock("block_" + name, block));
			}

			if (oreClump == null && genOre) {
				oreClump = registerItem("clump_" + name);
				TDMaterials.itemList.add(oreClump);
			}

			if (ore == null && genOre) {
				if (oreClump != null)
					ore = new TDOreBlock(oreClump);
				else
					ore = new TDOreBlock();
				ore.setRegistryName(new ResourceLocation(Reference.MOD_ID, "ore_" + name))
						.setUnlocalizedName("ore_" + name);
				TDMaterials.blockList.add(ore);
				TDMaterials.itemList.add(registerItemBlock("ore_" + name, ore));
			}

			if (stake == null && genStake) {
				stake = new ComponentStake();
				stake.setRegistryName(new ResourceLocation(Reference.MOD_ID, "stake_" + name))
						.setUnlocalizedName("stake_" + name);
				TDMaterials.blockList.add(stake);
				TDMaterials.itemList.add(registerItemBlock("stake_" + name, stake));
			}

			if (bars == null && genBars) {
				bars = new ComponentPane(net.minecraft.block.material.Material.IRON, true);
				bars.setRegistryName(new ResourceLocation(Reference.MOD_ID, "bars_" + name))
						.setUnlocalizedName("bars_" + name);
				TDMaterials.blockList.add(bars);
				TDMaterials.itemList.add(registerItemBlock("bars_" + name, bars));
			}

			if (door == null && genDoor) {
				door = new ComponentDoor(net.minecraft.block.material.Material.IRON);
				door.setRegistryName(new ResourceLocation(Reference.MOD_ID, "door_" + name))
						.setUnlocalizedName("door_" + name);
				TDMaterials.blockList.add(door);
				ComponentItemDoor b = new ComponentItemDoor(door);
				b.setRegistryName(new ResourceLocation(Reference.MOD_ID, "door_" + name))
						.setUnlocalizedName("door_" + name);
				TDMaterials.itemList.add(b);
				door.setItem(b);
			}

			if (trapdoor == null && genTrapdoor) {
				trapdoor = new ComponentTrapDoor(net.minecraft.block.material.Material.IRON);
				trapdoor.setRegistryName(new ResourceLocation(Reference.MOD_ID, "trapdoor_" + name))
						.setUnlocalizedName("trapdoor_" + name);
				TDMaterials.blockList.add(trapdoor);
				TDMaterials.itemList.add(registerItemBlock("trapdoor_" + name, trapdoor));
			}
		}

		if (genFluid) {
			fluid = fluidMetal(name, color, temp);
			TDMaterials.fluids.put(name, fluid);
		}

		if (genMaterial) {
			mat = new Material(name, color);

			if (fluid != null)
				mat.setFluid(fluid);

			mat.setCraftable(!cast).setCastable(cast);

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
			if (helm != null)
				TinkerRegistry.addMaterialStats(mat, helm);
			if (chest != null)
				TinkerRegistry.addMaterialStats(mat, chest);
			if (legs != null)
				TinkerRegistry.addMaterialStats(mat, legs);
			if (feet != null)
				TinkerRegistry.addMaterialStats(mat, feet);
			if (fabric != null)
				TinkerRegistry.addMaterialStats(mat, fabric);

			if (repItem != null)
				mat.setRepresentativeItem(repItem);

			matint = new MaterialIntegration(mat, fluid, StringUtils.capitalize(name));
			matint.toolforge().preInit();

			TinkersDefense.proxy.registerMatColor(mat, color);

			TinkerRegistry.integrate(matint);
		}
	}

	public void setupPost() {
		if (genComponents) {
			if (genIngot)
				OreDictionary.registerOre("ingot" + StringUtils.capitalize(name), new ItemStack(ingot));
			if (genNugget)
				OreDictionary.registerOre("nugget" + StringUtils.capitalize(name), new ItemStack(nugget));
			if (genDust)
				OreDictionary.registerOre("dust" + StringUtils.capitalize(name), new ItemStack(dust));
			if (genGrain)
				OreDictionary.registerOre("grain" + StringUtils.capitalize(name), new ItemStack(grain));
			if (genCoin)
				OreDictionary.registerOre("coin" + StringUtils.capitalize(name), new ItemStack(coin));
			if (genPlate)
				OreDictionary.registerOre("plate" + StringUtils.capitalize(name), new ItemStack(plate));
			if (genGear)
				OreDictionary.registerOre("gear" + StringUtils.capitalize(name), new ItemStack(gear));
			if (genRod)
				OreDictionary.registerOre("rod" + StringUtils.capitalize(name), new ItemStack(rod));

			if (genBlock)
				OreDictionary.registerOre("block" + StringUtils.capitalize(name), new ItemStack(block));
		}

		if (genMaterial)
			matint.integrate();

	}

	public void setupRecipes(RegistryEvent.Register<IRecipe> event) {
		Material mat = TinkerRegistry.getMaterial(name);
		Item rep = TinkerRegistry.getMaterial(name).getRepresentativeItem().getItem();

		if (genComponents) {
			if (genGear && (genIngot || oreIngot != "" || rep != Items.AIR)) {
				IRecipe recipeGear = null;

				if (genIngot)
					recipeGear = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "gear_recipe"),
							new ItemStack(gear), new Object[] { " i ", "iii", " i ", 'i', new ItemStack(ingot) });
				else if (oreIngot != "")
					recipeGear = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "gear_recipe"),
							new ItemStack(gear), new Object[] { " i ", "iii", " i ", 'i', oreIngot });
				else if (rep != Items.AIR)
					recipeGear = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "gear_recipe"),
							new ItemStack(gear), new Object[] { " i ", "iii", " i ", 'i', new ItemStack(rep) });

				if (recipeGear != null) {
					recipeGear.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "GearRecipe"));

					IForgeRegistry<IRecipe> registry = event.getRegistry();
					registry.register(recipeGear);
				}
			}

			if (genOre) {
				if (genIngot) {
					GameRegistry.addSmelting(ore, new ItemStack(ingot), 3f);
					GameRegistry.addSmelting(oreClump, new ItemStack(ingot), 3f);
				}

				TinkerRegistry.registerMelting(ore, fluid, Material.VALUE_Ingot * 2);
				TinkerRegistry.registerMelting(oreClump, fluid, Material.VALUE_Ingot * 2);
			}

			if (genDust) {
				GameRegistry.addSmelting(dust, new ItemStack(ingot, 1), 0f);
			}

			if (genDoor) {
				if (genGear && (genIngot || oreIngot != "" || rep != Items.AIR)) {
					IRecipe recipe = null;

					if (genIngot)
						recipe = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "door_recipe"),
								new ItemStack(door, 3),
								new Object[] { "ii ", "ii ", "ii ", 'i', new ItemStack(ingot) });
					else if (oreIngot != "")
						recipe = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "door_recipe"),
								new ItemStack(door, 3), new Object[] { "ii ", "ii ", "ii ", 'i', oreIngot });
					else if (rep != Items.AIR)
						recipe = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "door_recipe"),
								new ItemStack(door, 3), new Object[] { "ii ", "ii ", "ii ", 'i', new ItemStack(rep) });

					if (recipe != null) {
						recipe.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "DoorRecipe"));

						IForgeRegistry<IRecipe> registry = event.getRegistry();
						registry.register(recipe);
					}
				}

				if (genIngot)
					GameRegistry.addSmelting(door, new ItemStack(ingot, 2), 0f);
				//TinkerRegistry.registerMelting(door, fluid, Material.VALUE_Ingot * 2);
			}

			if (genTrapdoor) {
				if (genGear && (genIngot || oreIngot != "" || rep != Items.AIR)) {
					IRecipe recipe = null;

					if (genIngot)
						recipe = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "trapdoor_recipe"),
								new ItemStack(trapdoor, 3),
								new Object[] { "   ", "iii", "iii", 'i', new ItemStack(ingot) });
					else if (oreIngot != "")
						recipe = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "trapdoor_recipe"),
								new ItemStack(trapdoor, 3), new Object[] { "   ", "iii", "iii", 'i', oreIngot });
					else if (rep != Items.AIR)
						recipe = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "trapdoor_recipe"),
								new ItemStack(trapdoor, 3),
								new Object[] { "   ", "iii", "iii", 'i', new ItemStack(rep) });

					if (recipe != null) {
						recipe.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "TrapdoorRecipe"));

						IForgeRegistry<IRecipe> registry = event.getRegistry();
						registry.register(recipe);
					}
				}

				if (genIngot)
					GameRegistry.addSmelting(trapdoor, new ItemStack(ingot, 2), 0f);
				//TinkerRegistry.registerMelting(trapdoor, fluid, Material.VALUE_Ingot * 2);
			}

			if (genGear) {
				if (genIngot)
					GameRegistry.addSmelting(gear, new ItemStack(ingot, 4), 0f);
			}

			if (genStake) {
				if (genGear && (genIngot || oreIngot != "" || rep != Items.AIR)) {
					IRecipe recipe = null;

					if (genIngot)
						recipe = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "stake_recipe"),
								new ItemStack(stake, 1),
								new Object[] { " i ", " i ", " i ", 'i', new ItemStack(ingot) });
					else if (oreIngot != "")
						recipe = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "stake_recipe"),
								new ItemStack(stake, 1), new Object[] { " i ", " i ", " i ", 'i', oreIngot });
					else if (rep != Items.AIR)
						recipe = new ShapedOreRecipe(new ResourceLocation(Reference.MOD_ID, "stake_recipe"),
								new ItemStack(stake, 1), new Object[] { " i ", " i ", " i ", 'i', new ItemStack(rep) });

					if (recipe != null) {
						recipe.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "StakeRecipe"));

						IForgeRegistry<IRecipe> registry = event.getRegistry();
						registry.register(recipe);
					}
				}

				if (genIngot)
					GameRegistry.addSmelting(stake, new ItemStack(ingot, 3), 0f);
				//TinkerRegistry.registerMelting(trapdoor, fluid, Material.VALUE_Ingot * 3);
			}
		}
	}

	public void setupModels() {
		if (genComponents) {
			if (genIngot)
				TinkersDefense.proxy.registerItemRenderer(ingot, 0, "ingot");
			if (genDust)
				TinkersDefense.proxy.registerItemRenderer(dust, 0, "dust");
			if (genNugget)
				TinkersDefense.proxy.registerItemRenderer(nugget, 0, "nugget");
			if (genGrain)
				TinkersDefense.proxy.registerItemRenderer(grain, 0, "grain");
			if (genCoin)
				TinkersDefense.proxy.registerItemRenderer(coin, 0, "coin");
			if (genPlate)
				TinkersDefense.proxy.registerItemRenderer(plate, 0, "plate");
			if (genRod)
				TinkersDefense.proxy.registerItemRenderer(rod, 0, "rod");
			if (genGear)
				TinkersDefense.proxy.registerItemRenderer(gear, 0, "gear");

			if (genBlock) {
				TinkersDefense.proxy.registerBlockRenderer(block, "block");
				TinkersDefense.proxy.registerItemBlockRenderer(block, 0, "componentblock");
			}
			if (genStake) {
				TinkersDefense.proxy.registerBlockRenderer(stake, "stake");
				TinkersDefense.proxy.registerItemBlockRenderer(stake, 0, "stake");
			}
			// if (genBars)
			// {
			// TinkersDefense.proxy.registerBlockRenderer(bars, "bars");
			// TinkersDefense.proxy.registerItemRenderer(Item.getItemFromBlock(bars), 0,
			// "bars");
			// }
			// if (genDoor)
			// {
			// TinkersDefense.proxy.registerBlockRenderer(door, "door");
			// TinkersDefense.proxy.registerItemRenderer(Item.getItemFromBlock(door), 0,
			// "door");
			// }
			// if (genTrapdoor)
			// {
			// TinkersDefense.proxy.registerBlockRenderer(trapdoor, "trapdoor");
			// TinkersDefense.proxy.registerItemRenderer(Item.getItemFromBlock(trapdoor), 0,
			// "trapdoor");
			// }
		}
	}

	public void setupClient() {
		if (genComponents) {
			if (genIngot)
				TinkersDefense.proxy.registerItemColorHandler(color, ingot);
			if (genNugget)
				TinkersDefense.proxy.registerItemColorHandler(color, nugget);
			if (genDust)
				TinkersDefense.proxy.registerItemColorHandler(color, dust);
			if (genGrain)
				TinkersDefense.proxy.registerItemColorHandler(color, grain);
			if (genCoin)
				TinkersDefense.proxy.registerItemColorHandler(color, coin);
			if (genGear)
				TinkersDefense.proxy.registerItemColorHandler(color, gear);
			if (genPlate)
				TinkersDefense.proxy.registerItemColorHandler(color, plate);
			if (genRod)
				TinkersDefense.proxy.registerItemColorHandler(color, rod);

			if (genBlock) {
				TinkersDefense.proxy.registerBlockColorHandler(color, block);
				TinkersDefense.proxy.registerItemColorHandler(color, Item.getItemFromBlock(block));
			}

			if (genBlock) {
				TinkersDefense.proxy.registerBlockColorHandler(color, stake);
				TinkersDefense.proxy.registerItemColorHandler(color, Item.getItemFromBlock(stake));
			}
		}
	}

	public Item registerItem(String name) {
		return new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
	}

	public Item registerItemBlock(String name, Block b) {
		return new ItemBlock(b).setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
	}

	public Block registerBlock(String name) {
		return new Block(net.minecraft.block.material.Material.IRON)
				.setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setUnlocalizedName(name);
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
