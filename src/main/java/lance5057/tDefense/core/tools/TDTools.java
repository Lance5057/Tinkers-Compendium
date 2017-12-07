package lance5057.tDefense.core.tools;

import java.util.ArrayList;

import com.google.common.eventbus.Subscribe;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.tools.armor.cloth.TinkersHood;
import lance5057.tDefense.core.tools.armor.cloth.TinkersRobe;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShawl;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShoes;
import lance5057.tDefense.core.tools.armor.straps.ItemStraps;
import lance5057.tDefense.core.tools.basic.FishingRod;
import lance5057.tDefense.core.tools.basic.HeaterShield;
import lance5057.tDefense.core.tools.basic.RoundShield;
import lance5057.tDefense.core.tools.basic.Shears;
import lance5057.tDefense.core.tools.basic.Zweihander;
import lance5057.tDefense.core.tools.baubles.Amulet;
import lance5057.tDefense.core.tools.baubles.Ring;
import lance5057.tDefense.core.tools.baubles.Sheathe;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tools.ToolCore;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
//@Pulse(id = TDTools.PulseId, description = "All the tools and everything related to it.")
public class TDTools {

	TDToolEvents events = new TDToolEvents();

	// Tools
	public static ToolCore roundshield;
	public static ToolCore heatershield;
	public static ToolCore zweihander;
	public static ToolCore shears;
	public static ToolCore fishingRod;

	//armor
	public static ItemStraps straps;
	
	public static ToolCore hood;
	public static ToolCore shawl;
	public static ToolCore robe;
	public static ToolCore shoes;

	public static ToolCore coif;
	public static ToolCore hauberk;
	public static ToolCore chausses;
	public static ToolCore boots;

	public static ToolCore helm;
	public static ToolCore breastplate;
	public static ToolCore grieves;
	public static ToolCore sabatons;
	
	//baubles
	public static ToolCore sheathe;
	public static ToolCore ring;
	public static ToolCore amulet;
	
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
		straps = new ItemStraps();
		itemList.add(straps);
	}

	private void regTools() {

		

		// TinkerRegistry.registerToolStationCrafting(roundshield);
		// TinkerRegistry.registerToolForgeCrafting(heatershield);
		// TinkerRegistry.registerToolForgeCrafting(zweihander);
	}
	
	public void registerItems(final RegistryEvent.Register<Item> event)
	{
		
		roundshield = new RoundShield();
		heatershield = new HeaterShield();
		zweihander = new Zweihander();
		shears = new Shears();
		fishingRod = new FishingRod();
 
		hood = new TinkersHood();
		shawl = new TinkersShawl();
		robe = new TinkersRobe();
		shoes = new TinkersShoes();
		
		sheathe = new Sheathe();
		ring = new Ring();
		amulet = new Amulet();
		
		regTool(roundshield, "roundshield", event);
		regTool(heatershield, "heatershield", event);
		regTool(zweihander, "zweihander", event);
		regTool(shears, "shears", event);
		regTool(fishingRod, "fishingRod", event);

		regTool(hood, "hood", event);
		regTool(shawl, "shawl", event);
		regTool(robe, "robe", event);
		regTool(shoes, "shoes", event);
		
		regTool(sheathe, "sheathe", event);
		regTool(ring, "ring", event);
		regTool(amulet, "amulet", event);
		
		final IForgeRegistry registry = event.getRegistry();
		for (Item i : itemList) {
			registry.register(i);
		}
	}

	private static void regTool(ToolCore tool, String name, RegistryEvent.Register<Item> event) {
		tool.setRegistryName(new ResourceLocation("tinkersdefense:" + name));
		event.getRegistry().register(tool);
		TinkerRegistry.registerTool(tool);
		TinkersDefense.proxy.registerToolModel(tool);
		itemList.add(tool);
	} 

	private void registerModifiers() {

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
	}

	private void regToolBuilding() {
		TinkerRegistry.registerToolCrafting(roundshield);
		TinkerRegistry.registerToolForgeCrafting(heatershield);
		TinkerRegistry.registerToolForgeCrafting(zweihander);
		TinkerRegistry.registerToolCrafting(shears);
		TinkerRegistry.registerToolCrafting(fishingRod);

		TinkerRegistry.registerToolCrafting(hood);
		TinkerRegistry.registerToolCrafting(shawl);
		TinkerRegistry.registerToolCrafting(robe);
		TinkerRegistry.registerToolCrafting(shoes);
		
		TinkerRegistry.registerToolCrafting(sheathe);
		TinkerRegistry.registerToolCrafting(ring);
		TinkerRegistry.registerToolCrafting(amulet);
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
