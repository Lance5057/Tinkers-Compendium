package lance5057.tDefense.core.tools;

import java.util.ArrayList;
import java.util.List;

import com.google.common.eventbus.Subscribe;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.library.CustomArmorTextureCreator;
import lance5057.tDefense.core.library.TCRegistry;
import lance5057.tDefense.core.network.ArmorStationSelectionPacket;
import lance5057.tDefense.core.tools.armor.cloth.TinkersHood;
import lance5057.tDefense.core.tools.armor.cloth.TinkersRobe;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShawl;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShoes;
import lance5057.tDefense.core.tools.armor.heavy.TinkersBreastplate;
import lance5057.tDefense.core.tools.armor.heavy.TinkersGrieves;
import lance5057.tDefense.core.tools.armor.heavy.TinkersHelm;
import lance5057.tDefense.core.tools.armor.heavy.TinkersSabatons;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.core.tools.basic.FishingRod;
import lance5057.tDefense.core.tools.basic.HeaterShield;
import lance5057.tDefense.core.tools.basic.RegDummy;
import lance5057.tDefense.core.tools.basic.RoundShield;
import lance5057.tDefense.core.tools.basic.Shears;
import lance5057.tDefense.core.tools.basic.TowerShield;
import lance5057.tDefense.core.tools.basic.Zweihander;
import lance5057.tDefense.core.tools.baubles.Sheathe;
import lance5057.tDefense.core.workstations.blocks.ArmorStationBlock;
import lance5057.tDefense.core.workstations.tileentities.ArmorStationTile;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
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
	public static ToolCore heatershield;
	public static ToolCore towershield;
	public static ToolCore zweihander;
	public static ToolCore shears;
	public static ToolCore fishingRod;

	public static ArmorCore hood;
	public static ArmorCore shawl;
	public static ArmorCore robe;
	public static ArmorCore shoes;

	public static ArmorCore coif;
	public static ArmorCore hauberk;
	public static ArmorCore chausses;
	// public static ToolCore boots;

	public static ArmorCore helm;
	public static ArmorCore breastplate;
	public static ArmorCore grieves;
	public static ArmorCore sabatons;

	// baubles
	public static ToolCore sheathe;
	// public static ToolCore ring;
	// public static ToolCore amulet;

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

		stationItem = (ItemBlock) new ItemBlock(station).setRegistryName(station.getRegistryName());

		regDummy = new RegDummy();

		roundshield = new RoundShield();
		heatershield = new HeaterShield();
		towershield = new TowerShield();
		zweihander = new Zweihander();
		shears = new Shears();
		fishingRod = new FishingRod();

		hood = new TinkersHood();
		shawl = new TinkersShawl();
		robe = new TinkersRobe();
		shoes = new TinkersShoes();

		// coif = new TinkersCoif();
		// hauberk = new TinkersHauberk();
		// chausses = new TinkersChausses();
		// boots = new TinkersBoots();

		helm = new TinkersHelm();
		breastplate = new TinkersBreastplate();
		grieves = new TinkersGrieves();
		sabatons = new TinkersSabatons();

		sheathe = new Sheathe();
		// ring = new Ring();
		// amulet = new Amulet();

		regTool(regDummy, "regdummy", event);
		regTool(roundshield, "roundshield", event);
		regTool(heatershield, "heatershield", event);
		regTool(towershield, "towershield", event);
		regTool(zweihander, "zweihander", event);
		regTool(shears, "shears", event);
		regTool(fishingRod, "fishingRod", event);

		regArmor(hood, "hood", event);

		regArmor(shawl, "shawl", event);

		regArmor(robe, "robe", event);

		regArmor(shoes, "shoes", event);

		// regTool(boots, "boots", event);

		regArmor(helm, "helm", event);

		regArmor(breastplate, "breastplate", event);

		regArmor(grieves, "grieves", event);

		regArmor(sabatons, "sabatons", event);

		// CustomTextureCreator.registerTexture(new
		// ResourceLocation("tinkersdefense",
		// "items/battleaxe/_halbard_accessory"));

		//
		regTool(sheathe, "sheathe", event);
		// regTool(ring, "ring", event);
		// regTool(amulet, "amulet", event);

		final IForgeRegistry registry = event.getRegistry();
		for (Item i : itemList) {
			registry.register(i);
		}

		registry.register(stationItem);

	}

	public void registerBlocks(final RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();

		station = new ArmorStationBlock();

		registry.register(station);

		GameRegistry.registerTileEntity(ArmorStationTile.class, "armorstationtile");

		//
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
		// register items

		// register blocks

		// register entities

		// proxy.preInit();
		regToolBuilding();
		regRecipies();

		// proxy.init();

		TinkerNetwork.instance.registerPacket(ArmorStationSelectionPacket.class);
	}

	private void regToolBuilding() {
		TinkerRegistry.registerToolCrafting(roundshield);
		TinkerRegistry.registerToolForgeCrafting(heatershield);
		TinkerRegistry.registerToolForgeCrafting(towershield);
		TinkerRegistry.registerToolForgeCrafting(zweihander);
		TinkerRegistry.registerToolCrafting(shears);
		TinkerRegistry.registerToolCrafting(fishingRod);

		TCRegistry.registerArmorCrafting(hood);
		TCRegistry.registerArmorCrafting(shawl);
		TCRegistry.registerArmorCrafting(robe);
		TCRegistry.registerArmorCrafting(shoes);

		// TinkerRegistry.registerToolCrafting(boots);

		TCRegistry.registerArmorCrafting(helm);
		TCRegistry.registerArmorCrafting(breastplate);
		TCRegistry.registerArmorCrafting(grieves);
		TCRegistry.registerArmorCrafting(sabatons);

		TinkerRegistry.registerToolCrafting(sheathe);
		// TinkerRegistry.registerToolCrafting(ring);
		// TinkerRegistry.registerToolCrafting(amulet);
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
