package lance5057.tDefense.core.tools;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.common.CommonProxy;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tools.ToolCore;

import com.google.common.eventbus.Subscribe;

//@Pulse(id = TDTools.PulseId, description = "All the tools and everything related to it.")
public class TDTools
{

	TDToolEvents events = new TDToolEvents();

  // Tools
	public static ToolCore roundshield = new RoundShield();
	public static ToolCore heatershield = new HeaterShield();
	public static ToolCore zweihander = new Zweihander();
	
  // Tool Parts

  // Modifiers

  // Helper stuff
//  static List<ToolCore> tools = Lists.newLinkedList();      // contains all tools registered in this pulse
//  static List<ToolPart> toolparts = Lists.newLinkedList();  // ^ all toolparts
//  static List<IModifier> modifiers = Lists.newLinkedList(); // ^ all modifiers

  // PRE-INITIALIZATION
  @Subscribe
  public void preInit(FMLPreInitializationEvent event) {
    // register items
	  MinecraftForge.EVENT_BUS.register(events);

    regToolParts();
    regTools();
    registerModifiers();

    // register blocks

    // register entities
    
    //proxy.preInit();
  }

  private void regToolParts() {
    // The order the items are registered in represents the order in the stencil table GUI too
	  
  }

  private void regTools() {
	  
	  regTool(roundshield, "roundshield");
	  regTool(heatershield, "heatershield");
	  regTool(zweihander, "zweihander");
	  
//	  TinkerRegistry.registerToolStationCrafting(roundshield);
//	  TinkerRegistry.registerToolForgeCrafting(heatershield);
//	  TinkerRegistry.registerToolForgeCrafting(zweihander);
  }
  
  private void regTool(ToolCore tool, String name)
  {
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

    //proxy.init();
  }

  private void regToolBuilding() {
    TinkerRegistry.registerToolCrafting(roundshield);
    TinkerRegistry.registerToolForgeCrafting(heatershield);
    TinkerRegistry.registerToolForgeCrafting(zweihander);
  }

  private void regRecipies() {

  }
  
  // POST-INITIALIZATION
  @Subscribe
  public void postInit(FMLPostInitializationEvent event) {
    //proxy.postInit();
  }
  
  
}
