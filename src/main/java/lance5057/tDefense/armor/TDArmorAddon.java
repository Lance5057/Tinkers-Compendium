package lance5057.tDefense.armor;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.blocks.GlowstoneCrumbs;
import lance5057.tDefense.armor.blocks.UnstableBlock;
import lance5057.tDefense.armor.blocks.UnstableItemBlock;
import lance5057.tDefense.armor.items.Sheath;
import lance5057.tDefense.armor.items.TinkersGauntlets;
import lance5057.tDefense.armor.items.cloth.TinkersHood;
import lance5057.tDefense.armor.items.cloth.TinkersRobe;
import lance5057.tDefense.armor.items.cloth.TinkersShawl;
import lance5057.tDefense.armor.items.cloth.TinkersShoes;
import lance5057.tDefense.armor.items.heavy.TinkersBreastplate;
import lance5057.tDefense.armor.items.heavy.TinkersGrieves;
import lance5057.tDefense.armor.items.heavy.TinkersHelm;
import lance5057.tDefense.armor.items.heavy.TinkersSabatons;
import lance5057.tDefense.armor.items.light.TinkersBoots;
import lance5057.tDefense.armor.items.light.TinkersChausses;
import lance5057.tDefense.armor.items.light.TinkersCoif;
import lance5057.tDefense.armor.items.light.TinkersHauberk;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import tconstruct.client.FlexibleToolRenderer;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.ToolBuilder;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class TDArmorAddon
{
	public static CreativeTabs	tabName;

	public static ToolCore		armor_TinkerHood;
	public static ToolCore		armor_TinkerShawl;
	public static ToolCore		armor_TinkerRobe;
	public static ToolCore		armor_TinkerShoes;

	public static ToolCore		armor_TinkerCoif;
	public static ToolCore		armor_TinkerHauberk;
	public static ToolCore		armor_TinkerChausses;
	public static ToolCore		armor_TinkerBoots;

	public static ToolCore		armor_TinkerHelm;
	public static ToolCore		armor_TinkerBreastplate;
	public static ToolCore		armor_TinkerGrieves;
	public static ToolCore		armor_TinkerSabatons;
	public static ToolCore		armor_TinkerGauntlets;

	public static ToolCore		accessory_sheath;

	public static Block			block_Unstable;
	public static Block			block_GlowCrumbs;

	public void preInit(FMLPreInitializationEvent e)
	{
		tabName = new CreativeTabs("TabArmor")
		{

			@Override
			public Item getTabIconItem()
			{
				return ToolBuilder.instance.buildTool(new ItemStack(
						TinkerTools.largePlate, 1, 2), new ItemStack(
						TinkerTools.toughRod, 1, 2), new ItemStack(
						TinkersDefense.partArmorplate, 1, 2), new ItemStack(
						TinkersDefense.partChainmaille, 1, 2), "ArmorTab").getItem();
			}

		};

		armor_TinkerHelm = new TinkersHelm();
		armor_TinkerBreastplate = new TinkersBreastplate();
		armor_TinkerGrieves = new TinkersGrieves();
		armor_TinkerSabatons = new TinkersSabatons();
		armor_TinkerGauntlets = new TinkersGauntlets();

		armor_TinkerRobe = new TinkersRobe();
		armor_TinkerShawl = new TinkersShawl();
		armor_TinkerHood = new TinkersHood();
		armor_TinkerShoes = new TinkersShoes();

		armor_TinkerCoif = new TinkersCoif();
		armor_TinkerHauberk = new TinkersHauberk();
		armor_TinkerChausses = new TinkersChausses();
		armor_TinkerBoots = new TinkersBoots();

		accessory_sheath = new Sheath();

		block_Unstable = new UnstableBlock();
		block_GlowCrumbs = new GlowstoneCrumbs();

		GameRegistry.registerItem(armor_TinkerHelm, "tinkerhelm");
		GameRegistry.registerItem(armor_TinkerBreastplate, "tinkerbreastplate");
		GameRegistry.registerItem(armor_TinkerGrieves, "tinkergrieves");
		GameRegistry.registerItem(armor_TinkerSabatons, "tinkersabatons");
		GameRegistry.registerItem(armor_TinkerGauntlets, "tinkergauntlets");

		GameRegistry.registerItem(armor_TinkerCoif, "tinkercoif");
		GameRegistry.registerItem(armor_TinkerHauberk, "tinkerhauberk");
		GameRegistry.registerItem(armor_TinkerChausses, "tinkerchausses");
		GameRegistry.registerItem(armor_TinkerBoots, "tinkerboots");

		GameRegistry.registerItem(armor_TinkerRobe, "tinkerrobe");
		GameRegistry.registerItem(armor_TinkerShawl, "tinkershawl");
		GameRegistry.registerItem(armor_TinkerHood, "tinkerhood");
		GameRegistry.registerItem(armor_TinkerShoes, "tinkershoes");

		GameRegistry.registerItem(accessory_sheath, "Sheath");

		GameRegistry.registerBlock(block_Unstable, UnstableItemBlock.class, "Unstable");
		GameRegistry.registerBlock(block_GlowCrumbs, "Block_GlowCrumbs");

		TConstructRegistry.addItemToDirectory("tinkerhelm", armor_TinkerHelm);
		TConstructRegistry.addItemToDirectory("tinkerbreastplate", armor_TinkerBreastplate);
		TConstructRegistry.addItemToDirectory("tinkergrieves", armor_TinkerGrieves);
		TConstructRegistry.addItemToDirectory("tinkersabatons", armor_TinkerSabatons);
		TConstructRegistry.addItemToDirectory("tinkergauntlets", armor_TinkerGauntlets);

		TConstructRegistry.addItemToDirectory("tinkercoif", armor_TinkerCoif);
		TConstructRegistry.addItemToDirectory("tinkerhauberk", armor_TinkerHauberk);
		TConstructRegistry.addItemToDirectory("tinkerchausses", armor_TinkerChausses);
		TConstructRegistry.addItemToDirectory("tinkerboots", armor_TinkerBoots);

		TConstructRegistry.addItemToDirectory("tinkerrobe", armor_TinkerRobe);
		TConstructRegistry.addItemToDirectory("tinkershawl", armor_TinkerShawl);
		TConstructRegistry.addItemToDirectory("tinkerhood", armor_TinkerHood);
		TConstructRegistry.addItemToDirectory("tinkershoes", armor_TinkerShoes);

		TConstructRegistry.addItemToDirectory("Sheath", accessory_sheath);
	}

	public void init(FMLInitializationEvent e)
	{

		TConstructRegistry.addToolRecipe(armor_TinkerHelm, TinkerTools.frypanHead, TinkerTools.toughRod, TinkersDefense.partArmorplate, TinkersDefense.partChainmaille);
		TConstructRegistry.addToolRecipe(armor_TinkerBreastplate, TinkerTools.largePlate, TinkerTools.toughRod, TinkersDefense.partArmorplate, TinkersDefense.partChainmaille);
		TConstructRegistry.addToolRecipe(armor_TinkerGrieves, TinkersDefense.partArmorplate, TinkerTools.toughRod, TinkersDefense.partChainmaille, TinkersDefense.partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerSabatons, TinkersDefense.partArmorplate, TinkerTools.toughRod, TinkersDefense.partArmorplate, TinkersDefense.partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerGauntlets, TinkersDefense.partArmorplate, TinkerTools.toughRod, TinkersDefense.partRivet);

		TConstructRegistry.addToolRecipe(armor_TinkerRobe, TinkersDefense.partCloth, TinkersDefense.partClasp, TinkersDefense.partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerShawl, TinkersDefense.partCloth, TinkersDefense.partArmorplate, TinkersDefense.partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerHood, TinkersDefense.partCloth, TinkerTools.toolRod, TinkersDefense.partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerShoes, TinkersDefense.partCloth, TinkersDefense.partRivet, TinkersDefense.partCloth);

		TConstructRegistry.addToolRecipe(armor_TinkerCoif, TinkersDefense.partChainmaille, TinkerTools.toughRod, TinkersDefense.partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerHauberk, TinkersDefense.partChainmaille, TinkerTools.largePlate, TinkersDefense.partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerChausses, TinkersDefense.partChainmaille, TinkersDefense.partArmorplate, TinkersDefense.partCloth);
		TConstructRegistry.addToolRecipe(armor_TinkerBoots, TinkersDefense.partChainmaille, TinkersDefense.partCloth, TinkersDefense.partRivet);

		TConstructRegistry.addToolRecipe(accessory_sheath, TinkersDefense.partCloth, TinkersDefense.partCloth, TinkersDefense.partCloth);

	}

	public void postInit(FMLPostInitializationEvent e)
	{

	}

	public static void clientProxy(FlexibleToolRenderer renderer)
	{
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.accessory_sheath, renderer);

		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerHelm, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerBreastplate, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerGrieves, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerSabatons, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerGauntlets, renderer);

		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerRobe, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerShawl, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerHood, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerShoes, renderer);

		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerCoif, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerHauberk, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerChausses, renderer);
		MinecraftForgeClient.registerItemRenderer(TDArmorAddon.armor_TinkerBoots, renderer);
	}
}
