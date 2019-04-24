package lance5057.tDefense.core.library.materialutilities;

import org.apache.commons.lang3.StringUtils;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TCConfig;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.blocks.ComponentDoor;
import lance5057.tDefense.core.blocks.ComponentPane;
import lance5057.tDefense.core.blocks.ComponentStake;
import lance5057.tDefense.core.blocks.ComponentTrapDoor;
import lance5057.tDefense.core.items.ComponentItemDoor;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.materials.Material;

public class MaterialComponents implements MaterialBase {

	public Item dust;
	public Item grain;
	public Item plate;
	public Item coin;
	public Item gear;
	public Item rod;
	public Item coil;
	public Item spring;
	public Item casing;
	public Item wire;

	public ComponentDoor door;
	public ComponentTrapDoor trapdoor;
	public ComponentStake stake;
	public ComponentPane bars;

	public Item itemDoor;
	public Item itemTrapdoor;
	public Item itemStake;
	public Item itemBars;

	boolean hasBlockTexture = false;

	public MaterialComponents(boolean hasBlockTexture) {
		this.hasBlockTexture = hasBlockTexture;
	}

	@Override
	public void setupPre(Material mat) {

		if (dust == null && TinkersCompendium.config.components.enableDust) {
			dust = registerItem("dust_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(dust);
		}
		if (grain == null && TinkersCompendium.config.components.enableGrain) {
			grain = registerItem("grain_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(grain);
		}

		if (plate == null && TinkersCompendium.config.components.enablePlate) {
			plate = registerItem("plate_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(plate);
		}

		if (coin == null && TinkersCompendium.config.components.enableCoin) {
			coin = registerItem("coin_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(coin);
		}

		if (gear == null && TinkersCompendium.config.components.enableGear) {
			gear = registerItem("gear_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(gear);
		}

		if (rod == null && TinkersCompendium.config.components.enableRod) {
			rod = registerItem("rod_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(rod);
		}

		if (coil == null && TinkersCompendium.config.components.enableCoil) {
			coil = registerItem("coil_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(coil);
		}

		if (spring == null && TinkersCompendium.config.components.enableSpring) {
			spring = registerItem("spring_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(spring);
		}

		if (casing == null && TinkersCompendium.config.components.enableCasing) {
			casing = registerItem("casing_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(casing);
		}

		if (wire == null && TinkersCompendium.config.components.enableWire) {
			wire = registerItem("wire_" + mat.identifier, TinkersCompendium.tab);
			CompendiumMaterials.itemList.add(wire);
		}

		if (stake == null) {
			stake = new ComponentStake();
			stake.setRegistryName(new ResourceLocation(Reference.MOD_ID, "stake_" + mat.identifier))
					.setUnlocalizedName("stake_" + mat.identifier).setCreativeTab(TinkersCompendium.tab);
			;
			CompendiumMaterials.blockList.add(stake);
			CompendiumMaterials.itemList
					.add(registerItemBlock("stake_" + mat.identifier, stake, TinkersCompendium.tab));
		}

		if (bars == null) {
			bars = new ComponentPane(net.minecraft.block.material.Material.IRON, true);
			bars.setRegistryName(new ResourceLocation(Reference.MOD_ID, "bars_" + mat.identifier))
					.setUnlocalizedName("bars_" + mat.identifier).setCreativeTab(TinkersCompendium.tab);
			;
			CompendiumMaterials.blockList.add(bars);
			CompendiumMaterials.itemList.add(registerItemBlock("bars_" + mat.identifier, bars, TinkersCompendium.tab));
		}

		if (door == null && TCConfig.components.enableDoors) {
			door = new ComponentDoor(net.minecraft.block.material.Material.IRON);
			door.setRegistryName(new ResourceLocation(Reference.MOD_ID, "door_" + mat.identifier))
					.setUnlocalizedName("door_" + mat.identifier).setCreativeTab(TinkersCompendium.tab);
			;
			CompendiumMaterials.blockList.add(door);
			ComponentItemDoor b = new ComponentItemDoor(door);
			b.setRegistryName(new ResourceLocation(Reference.MOD_ID, "door_" + mat.identifier))
					.setUnlocalizedName("door_" + mat.identifier);
			CompendiumMaterials.itemList.add(b);
			door.setItem(b);
		}

		if (trapdoor == null) {
			trapdoor = new ComponentTrapDoor(net.minecraft.block.material.Material.IRON);
			trapdoor.setRegistryName(new ResourceLocation(Reference.MOD_ID, "trapdoor_" + mat.identifier))
					.setUnlocalizedName("trapdoor_" + mat.identifier).setCreativeTab(TinkersCompendium.tab);
			;
			CompendiumMaterials.blockList.add(trapdoor);
			CompendiumMaterials.itemList
					.add(registerItemBlock("trapdoor_" + mat.identifier, trapdoor, TinkersCompendium.tab));
		}
	}

	@Override
	public void setupPost(Material mat) {

		if (TinkersCompendium.config.components.enableDust)
			OreDictionary.registerOre("dust" + StringUtils.capitalize(mat.identifier), new ItemStack(dust));
		if (TinkersCompendium.config.components.enableGrain)
			OreDictionary.registerOre("grain" + StringUtils.capitalize(mat.identifier), new ItemStack(grain));
		if (TinkersCompendium.config.components.enableCoin)
			OreDictionary.registerOre("coin" + StringUtils.capitalize(mat.identifier), new ItemStack(coin));
		if (TinkersCompendium.config.components.enablePlate)
			OreDictionary.registerOre("plate" + StringUtils.capitalize(mat.identifier), new ItemStack(plate));
		if (TinkersCompendium.config.components.enableGear)
			OreDictionary.registerOre("gear" + StringUtils.capitalize(mat.identifier), new ItemStack(gear));
		if (TinkersCompendium.config.components.enableRod)
			OreDictionary.registerOre("rod" + StringUtils.capitalize(mat.identifier), new ItemStack(rod));

	}

	@Override
	public void setupClient(Material mat) {

		if (TinkersCompendium.config.components.enableDust)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, dust);
		if (TinkersCompendium.config.components.enableGrain)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, grain);
		if (TinkersCompendium.config.components.enableCoin)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, coin);
		if (TinkersCompendium.config.components.enableGear)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, gear);
		if (TinkersCompendium.config.components.enablePlate)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, plate);
		if (TinkersCompendium.config.components.enableRod)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, rod);
		if (TinkersCompendium.config.components.enableSpring)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, spring);
		if (TinkersCompendium.config.components.enableCoil)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, coil);
		if (TinkersCompendium.config.components.enableWire)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, wire);
		if (TinkersCompendium.config.components.enableCasing)
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, casing);

		if (TinkersCompendium.config.components.enableStake) {
			if (!hasBlockTexture)
				TinkersCompendium.proxy.registerBlockColorHandler(mat.materialTextColor, stake);
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, Item.getItemFromBlock(stake));
		}

		if (TinkersCompendium.config.components.enableDoors) {
			if (!hasBlockTexture)
				TinkersCompendium.proxy.registerBlockColorHandler(mat.materialTextColor, door);
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, door.getItem());
		}

		if (TinkersCompendium.config.components.enableTrapDoors) {
			if (!hasBlockTexture)
				TinkersCompendium.proxy.registerBlockColorHandler(mat.materialTextColor, trapdoor);
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, Item.getItemFromBlock(trapdoor));
		}

		if (TinkersCompendium.config.components.enableBars) {
			if (!hasBlockTexture)
				TinkersCompendium.proxy.registerBlockColorHandler(mat.materialTextColor, bars);
			TinkersCompendium.proxy.registerItemColorHandler(mat.materialTextColor, Item.getItemFromBlock(bars));
		}
	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupModels(Material mat) {

		if (TinkersCompendium.config.components.enableDust)
			TinkersCompendium.proxy.registerItemRenderer(dust, 0, "dust");

		if (TinkersCompendium.config.components.enableGrain)
			TinkersCompendium.proxy.registerItemRenderer(grain, 0, "grain");
		if (TinkersCompendium.config.components.enableCoin)
			TinkersCompendium.proxy.registerItemRenderer(coin, 0, "coin");
		if (TinkersCompendium.config.components.enablePlate)
			TinkersCompendium.proxy.registerItemRenderer(plate, 0, "plate");
		if (TinkersCompendium.config.components.enableRod)
			TinkersCompendium.proxy.registerItemRenderer(rod, 0, "rod");
		if (TinkersCompendium.config.components.enableGear)
			TinkersCompendium.proxy.registerItemRenderer(gear, 0, "gear");
		if (TinkersCompendium.config.components.enableSpring)
			TinkersCompendium.proxy.registerItemRenderer(spring, 0, "spring");
		if (TinkersCompendium.config.components.enableCoil)
			TinkersCompendium.proxy.registerItemRenderer(coil, 0, "coil");
		if (TinkersCompendium.config.components.enableWire)
			TinkersCompendium.proxy.registerItemRenderer(wire, 0, "wire");
		if (TinkersCompendium.config.components.enableCasing)
			TinkersCompendium.proxy.registerItemRenderer(casing, 0, "casing");

		if (TinkersCompendium.config.components.enableStake) {
			if (!hasBlockTexture) {
				TinkersCompendium.proxy.registerBlockRenderer(stake, "stake");
				TinkersCompendium.proxy.registerItemBlockRenderer(stake, 0, "componentstake");
			}
		}
		if (TinkersCompendium.config.components.enableBars) {
			if (!hasBlockTexture) {
				TinkersCompendium.proxy.registerBlockRenderer(bars, "bars");
				TinkersCompendium.proxy.registerItemRenderer(Item.getItemFromBlock(bars), 0, "componentbars");
			}
		}
		if (TinkersCompendium.config.components.enableDoors) {
			if (!hasBlockTexture) {
				TinkersCompendium.proxy.registerBlockRenderer(door, "door");
				TinkersCompendium.proxy.registerItemRenderer(door.getItem(), 0, "componentdoor");
			}
		}
		if (TinkersCompendium.config.components.enableTrapDoors) {
			if (!hasBlockTexture) {
				TinkersCompendium.proxy.registerBlockRenderer(trapdoor, "trapdoor");
				TinkersCompendium.proxy.registerItemRenderer(Item.getItemFromBlock(trapdoor), 0, "componenttrapdoor");
			}
		}
	}

	@Override
	public void setupInit(Material mat) {
		// TODO Auto-generated method stub
		
	}

}
