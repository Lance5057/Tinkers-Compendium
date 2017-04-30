package lance5057.tDefense.baubles.tools;

import com.google.common.eventbus.Subscribe;

import lance5057.tDefense.core.tools.HeaterShield;
import lance5057.tDefense.core.tools.RoundShield;
import lance5057.tDefense.core.tools.TDToolEvents;
import lance5057.tDefense.core.tools.Zweihander;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tools.ToolCore;

public class TDBaubles
{

	TDToolEvents events = new TDToolEvents();

  // Tools
	public static ToolCore sheathe = new Sheathe();
	
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
	  
	  regTool(sheathe, "sheathe");
	  
	  TinkerRegistry.registerToolStationCrafting(sheathe);
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
    TinkerRegistry.registerToolCrafting(sheathe);
  }

  private void regRecipies() {

  }
  
  // POST-INITIALIZATION
  @Subscribe
  public void postInit(FMLPostInitializationEvent event) {
    //proxy.postInit();
  }
  
  
}