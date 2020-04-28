package lance5057.tDefense.core.library.materialutilities;

import java.io.PrintWriter;

import org.apache.commons.lang3.StringUtils;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TCBlocks;
import lance5057.tDefense.TCConfig;
import lance5057.tDefense.TCItems;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.blocks.ComponentDoor;
import lance5057.tDefense.core.blocks.ComponentPane;
import lance5057.tDefense.core.blocks.ComponentStake;
import lance5057.tDefense.core.blocks.ComponentTrapDoor;
import lance5057.tDefense.core.items.ComponentItemDoor;
import lance5057.tDefense.core.materials.CompendiumMaterials;
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
	public void setupPre(MaterialHelper mat) {

		if (dust == null && TinkersCompendium.config.components.enableDust) {
			dust = TCItems.registerItem("dust_" + mat.mat.identifier, TinkersCompendium.tab);
		}
		
		if (grain == null && TinkersCompendium.config.components.enableGrain) {
			grain = TCItems.registerItem("grain_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (plate == null && TinkersCompendium.config.components.enablePlate) {
			plate = TCItems.registerItem("plate_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (coin == null && TinkersCompendium.config.components.enableCoin) {
			coin = TCItems.registerItem("coin_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (gear == null && TinkersCompendium.config.components.enableGear) {
			gear = TCItems.registerItem("gear_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (rod == null && TinkersCompendium.config.components.enableRod) {
			rod = TCItems.registerItem("rod_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (coil == null && TinkersCompendium.config.components.enableCoil) {
			coil = TCItems.registerItem("coil_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (spring == null && TinkersCompendium.config.components.enableSpring) {
			spring = TCItems.registerItem("spring_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (casing == null && TinkersCompendium.config.components.enableCasing) {
			casing = TCItems.registerItem("casing_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (wire == null && TinkersCompendium.config.components.enableWire) {
			wire = TCItems.registerItem("wire_" + mat.mat.identifier, TinkersCompendium.tab);
		}

		if (stake == null) {
			stake = new ComponentStake();
			TCBlocks.registerBlock(stake, "stake_" + mat.mat.identifier);
			TCItems.registerItemBlock("stake_" + mat.mat.identifier, stake, TinkersCompendium.tab);
		}

		if (bars == null) {
			bars = new ComponentPane(net.minecraft.block.material.Material.IRON, true);
			TCBlocks.registerBlock(bars, "bars_" + mat.mat.identifier);
			TCItems.registerItemBlock("bars_" + mat.mat.identifier, bars, TinkersCompendium.tab);
		}

		if (door == null && TCConfig.components.enableDoors) {
			door = new ComponentDoor(net.minecraft.block.material.Material.IRON);
			TCBlocks.registerBlock(door,"door_" + mat.mat.identifier);
			
			ComponentItemDoor b = new ComponentItemDoor(door);
			TCItems.registerItem( "door_" + mat.mat.identifier, b,  TinkersCompendium.tab);
			door.setItem(b);
		}

		if (trapdoor == null) {
			trapdoor = new ComponentTrapDoor(net.minecraft.block.material.Material.IRON);
			TCBlocks.registerBlock(trapdoor, "trapdoor_" + mat.mat.identifier);
			
			TCItems.registerItemBlock("trapdoor_" + mat.mat.identifier, trapdoor, TinkersCompendium.tab);
		}
	}

	@Override
	public void setupPost(MaterialHelper mat) {

		if (TinkersCompendium.config.components.enableDust)
			OreDictionary.registerOre("dust" + StringUtils.capitalize(mat.mat.identifier), new ItemStack(dust));
		if (TinkersCompendium.config.components.enableGrain)
			OreDictionary.registerOre("grain" + StringUtils.capitalize(mat.mat.identifier), new ItemStack(grain));
		if (TinkersCompendium.config.components.enableCoin)
			OreDictionary.registerOre("coin" + StringUtils.capitalize(mat.mat.identifier), new ItemStack(coin));
		if (TinkersCompendium.config.components.enablePlate)
			OreDictionary.registerOre("plate" + StringUtils.capitalize(mat.mat.identifier), new ItemStack(plate));
		if (TinkersCompendium.config.components.enableGear)
			OreDictionary.registerOre("gear" + StringUtils.capitalize(mat.mat.identifier), new ItemStack(gear));
		if (TinkersCompendium.config.components.enableRod)
			OreDictionary.registerOre("rod" + StringUtils.capitalize(mat.mat.identifier), new ItemStack(rod));

	}

	@Override
	public void setupClient(MaterialHelper mat) {

		if (TinkersCompendium.config.components.enableDust)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, dust);
		if (TinkersCompendium.config.components.enableGrain)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, grain);
		if (TinkersCompendium.config.components.enableCoin)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, coin);
		if (TinkersCompendium.config.components.enableGear)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, gear);
		if (TinkersCompendium.config.components.enablePlate)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, plate);
		if (TinkersCompendium.config.components.enableRod)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, rod);
		if (TinkersCompendium.config.components.enableSpring)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, spring);
		if (TinkersCompendium.config.components.enableCoil)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, coil);
		if (TinkersCompendium.config.components.enableWire)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, wire);
		if (TinkersCompendium.config.components.enableCasing)
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, casing);

		if (TinkersCompendium.config.components.enableStake) {
			if (!hasBlockTexture)
				TinkersCompendium.proxy.registerBlockColorHandler(mat.color, stake);
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, Item.getItemFromBlock(stake));
		}

		if (TinkersCompendium.config.components.enableDoors) {
			if (!hasBlockTexture)
				TinkersCompendium.proxy.registerBlockColorHandler(mat.color, door);
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, door.getItem());
		}

		if (TinkersCompendium.config.components.enableTrapDoors) {
			if (!hasBlockTexture)
				TinkersCompendium.proxy.registerBlockColorHandler(mat.color, trapdoor);
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, Item.getItemFromBlock(trapdoor));
		}

		if (TinkersCompendium.config.components.enableBars) {
			if (!hasBlockTexture)
				TinkersCompendium.proxy.registerBlockColorHandler(mat.color, bars);
			TinkersCompendium.proxy.registerItemColorHandler(mat.color, Item.getItemFromBlock(bars));
		}
	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupModels(MaterialHelper mat) {

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
	public void setupInit(MaterialHelper mat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupWiki(MaterialHelper mat,PrintWriter out) {
		// TODO Auto-generated method stub
		
	}

}
