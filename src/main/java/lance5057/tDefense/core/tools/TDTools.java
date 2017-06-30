package lance5057.tDefense.core.tools;

import com.google.common.eventbus.Subscribe;

import lance5057.tDefense.armor.items.cloth.TinkersHood;
import lance5057.tDefense.armor.items.cloth.TinkersRobe;
import lance5057.tDefense.armor.items.cloth.TinkersShawl;
import lance5057.tDefense.armor.items.cloth.TinkersShoes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tools.ToolCore;

//@Pulse(id = TDTools.PulseId, description = "All the tools and everything related to it.")
public class TDTools {

	TDToolEvents events = new TDToolEvents();

	// Tools
	public static ToolCore roundshield;
	public static ToolCore heatershield;
	public static ToolCore zweihander;
	public static ToolCore shears;
	public static ToolCore fishingRod;

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
		// register items
		roundshield = new RoundShield();
		heatershield = new HeaterShield();
		zweihander = new Zweihander();
		shears = new Shears();
		fishingRod = new FishingRod();

		hood = new TinkersHood();
		shawl = new TinkersShawl();
		robe = new TinkersRobe();
		shoes = new TinkersShoes();

		MinecraftForge.EVENT_BUS.register(events);

		regTools();
		registerModifiers();

		// register blocks

		// register entities

		// proxy.preInit();
	}

	private void regTools() {

		regTool(roundshield, "roundshield");
		regTool(heatershield, "heatershield");
		regTool(zweihander, "zweihander");
		regTool(shears, "shears");
		regTool(fishingRod, "fishingRod");

		regTool(hood, "hood");
		regTool(shawl, "shawl");
		regTool(robe, "robe");
		regTool(shoes, "shoes");

		// TinkerRegistry.registerToolStationCrafting(roundshield);
		// TinkerRegistry.registerToolForgeCrafting(heatershield);
		// TinkerRegistry.registerToolForgeCrafting(zweihander);
	}

	private void regTool(ToolCore tool, String name) {
		tool.setRegistryName(new ResourceLocation("tinkersdefense:" + name));
		TinkerRegistry.registerTool(tool);
		GameRegistry.register(tool);
	}

	private void registerModifiers() {

	}

	// INITIALIZATION
	@Subscribe
	public void init(FMLInitializationEvent event) {
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
	}

	private void regRecipies() {

	}

	// POST-INITIALIZATION
	@Subscribe
	public void postInit(FMLPostInitializationEvent event) {
		// proxy.postInit();
	}

}
