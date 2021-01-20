package lance5057.tDefense.core.tools;

import java.util.ArrayList;
import java.util.List;

import com.google.common.eventbus.Subscribe;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.library.TCRegistry;
import lance5057.tDefense.core.network.ArmorStationSelectionPacket;
import lance5057.tDefense.core.tools.armor.chain.TinkersChainboots;
import lance5057.tDefense.core.tools.armor.chain.TinkersChausses;
import lance5057.tDefense.core.tools.armor.chain.TinkersCoif;
import lance5057.tDefense.core.tools.armor.chain.TinkersHauberk;
import lance5057.tDefense.core.tools.armor.heavy.TinkersBreastplate;
import lance5057.tDefense.core.tools.armor.heavy.TinkersGrieves;
import lance5057.tDefense.core.tools.armor.heavy.TinkersHelm;
import lance5057.tDefense.core.tools.armor.heavy.TinkersSabatons;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.core.tools.basic.KiteShield;
import lance5057.tDefense.core.tools.basic.RegDummy;
import lance5057.tDefense.core.tools.basic.RoundShield;
import lance5057.tDefense.core.tools.basic.Shears;
import lance5057.tDefense.core.tools.baubles.TinkerRing;
import lance5057.tDefense.core.workstations.blocks.ArmorStationBlock;
import lance5057.tDefense.core.workstations.tileentities.ArmorStationTile;
import lance5057.tDefense.util.ArmorTagUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.common.TinkerNetwork;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tools.ToolCore;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDTools {
	public static final List<ToolCore> tools = new ArrayList<>();
	public static final List<ArmorCore> armors = new ArrayList<>();
	TDToolEvents events = new TDToolEvents();

	public static ArmorStationBlock station;

	public static ItemBlock stationItem;

	// Tools
	public static ToolCore regDummy;

	public static ToolCore roundshield;
	public static ToolCore kiteshield;
	public static ToolCore shears;

	public static ArmorCore coif;
	public static ArmorCore hauberk;
	public static ArmorCore chausses;
	public static ArmorCore chainboots;

	public static ArmorCore helm;
	public static ArmorCore breastplate;
	public static ArmorCore grieves;
	public static ArmorCore sabatons;

	// baubles
	public static ToolCore ring;

	static ArrayList<Item> itemList = new ArrayList<Item>();

	// Tool Parts

	// Modifiers

	// Helper stuff
	// static List<ToolCore> tools = Lists.newLinkedList(); // contains all
	// tools registered in this pulse
	// static List<ToolPart> toolparts = Lists.newLinkedList(); // ^ all
	// toolparts
	// static List<IModifier> modifiers = Lists.newLinkedList(); // ^ all
	// modifiers


	// PRE-INITIALIZATION
	@Subscribe
	public void preInit(FMLPreInitializationEvent event) {

	}

	private void regTools() {

	}

	public void registerItems(final RegistryEvent.Register<Item> event) {

		// TODO find a way to not use this
		regDummy = new RegDummy();
		regTool(regDummy, "regdummy", event);

		roundshield = new RoundShield();
		regTool(roundshield, "roundshield", event);
		kiteshield = new KiteShield();
		regTool(kiteshield, "kiteshield", event);

		shears = new Shears();
		regTool(shears, "shears", event);

		coif = new TinkersCoif();
		regArmor(coif, "coif", event);
		hauberk = new TinkersHauberk();
		regArmor(hauberk, "hauberk", event);
		chausses = new TinkersChausses();
		regArmor(chausses, "chausses", event);
		chainboots = new TinkersChainboots();
		regArmor(chainboots, "chainboots", event);

		helm = new TinkersHelm();
		regArmor(helm, "helm", event);
		breastplate = new TinkersBreastplate();
		regArmor(breastplate, "breastplate", event);
		grieves = new TinkersGrieves();
		regArmor(grieves, "grieves", event);
		sabatons = new TinkersSabatons();
		regArmor(sabatons, "sabatons", event);

		ring = new TinkerRing();
		regTool(ring, "ring", event);


		final IForgeRegistry registry = event.getRegistry();
		for (Item i : itemList) {
			registry.register(i);
		}

		stationItem = (ItemBlock) new ItemBlock(station).setRegistryName(station.getRegistryName());
		registry.register(stationItem);

	}

	public void registerBlocks(final RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();

		station = new ArmorStationBlock();
		registry.register(station);

		GameRegistry.registerTileEntity(ArmorStationTile.class, "armorstationtile");

	}

	private static void regTool(ToolCore tool, String name, RegistryEvent.Register<Item> event) {
		tool.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		event.getRegistry().register(tool);
		TinkerRegistry.registerTool(tool);
		TinkersCompendium.proxy.registerToolModel(tool);
		tools.add(tool);
	}

	private static void regArmor(ArmorCore armor, String name, RegistryEvent.Register<Item> event) {
		armor.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		event.getRegistry().register(armor);
		TCRegistry.registerTool(armor);
		TinkersCompendium.proxy.registerArmorModel(armor);
		armors.add(armor);
	}

	private void registerModifiers() {

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		TinkersCompendium.proxy.registerItemBlockRenderer(station, 0, "armorstation");
	}

	// INITIALIZATION
	@Subscribe
	public void init(FMLInitializationEvent event) {
		// proxy.preInit();
		regToolBuilding();
		regRecipies();

		// proxy.init();

		TinkerNetwork.instance.registerPacket(ArmorStationSelectionPacket.class);
	}

	private void regToolBuilding() {
		if (TinkersCompendium.config.shields.enableShields) {
			if (TinkersCompendium.config.shields.enableBuckler)
				TinkerRegistry.registerToolCrafting(roundshield);
			if (TinkersCompendium.config.shields.enableKiteShield)
				TinkerRegistry.registerToolForgeCrafting(kiteshield);
		}

		if (TinkersCompendium.config.tools.enableTools) {
			if (TinkersCompendium.config.tools.enableShears)
				TinkerRegistry.registerToolCrafting(shears);
		}

		if (TinkersCompendium.config.armor.enableChainArmor) {
			TCRegistry.registerArmorCrafting(coif);
			TCRegistry.registerArmorCrafting(hauberk);
			TCRegistry.registerArmorCrafting(chausses);
			TCRegistry.registerArmorCrafting(chainboots);
		}

		if (TinkersCompendium.config.armor.enableHeavyArmor) {
			TCRegistry.registerArmorCrafting(helm);
			TCRegistry.registerArmorCrafting(breastplate);
			TCRegistry.registerArmorCrafting(grieves);
			TCRegistry.registerArmorCrafting(sabatons);
		}

		if (TinkersCompendium.config.baubles.enableBaubles) {
			if (TinkersCompendium.config.baubles.enableRing) {
				TinkerRegistry.registerToolCrafting(ring);
			}
		}
	}

	private void regRecipies() {

	}

	// POST-INITIALIZATION
	@Subscribe
	public void postInit(FMLPostInitializationEvent event) {
		// proxy.postInit();

		MinecraftForge.EVENT_BUS.register(events);

		regTools();
		registerModifiers();
	}
}
