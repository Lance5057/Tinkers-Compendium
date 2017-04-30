package lance5057.tDefense.baubles;

import java.util.Map;

import lance5057.tDefense.Reference;
import lance5057.tDefense.baubles.renderers.BaubleRenderer;
import lance5057.tDefense.baubles.renderers.SheatheModel;
import lance5057.tDefense.baubles.tools.TDBaubles;
import lance5057.tDefense.core.tools.TDTools;
import lance5057.tDefense.util.ModuleBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;

public class BaublesClientProxy {
	
	public SheatheModel sheathe;
	
	ToolBuildGuiInfo sheatheGUI;

	public void preInit() {
		// TODO Auto-generated method stub
		
		reloadRenderers();
	}

	public void init() {
		// TODO Auto-generated method stub
		Map<String, RenderPlayer> skinMap = Minecraft.getMinecraft().getRenderManager().getSkinMap();
		RenderPlayer render;
		render = skinMap.get("default");
		render.addLayer(new BaubleRenderer());
		
		render = skinMap.get("slim");
		render.addLayer(new BaubleRenderer());
		
		createToolGuis();
		setupToolGuis();
		registerToolGuis();
	}
	
	public void postInit() 
	{
	}
	
	public void registerToolRenderers()
	{
		ModelRegisterUtil.registerToolModel(TDBaubles.sheathe);
	}
	
	public void createToolGuis()
	{
		sheatheGUI = new ToolBuildGuiInfo(TDBaubles.sheathe);
	}
	
	public void setupToolGuis()
	{
		sheatheGUI.addSlotPosition(34, 15+8);
		sheatheGUI.addSlotPosition(34, 33+8);
		sheatheGUI.addSlotPosition(34, 51+8);
	}
	
	public void registerToolGuis()
	{
		TinkerRegistryClient.addToolBuilding(sheatheGUI);
	}
	
	public void reloadRenderers()
	{
		sheathe = new SheatheModel();
		registerToolRenderers();
	}
	
	public void setToolGuis()
	{
		sheatheGUI.positions.clear();
		sheatheGUI.addSlotPosition(34, 15);
		sheatheGUI.addSlotPosition(34, 33);
		sheatheGUI.addSlotPosition(34, 51);
	}
	
}
