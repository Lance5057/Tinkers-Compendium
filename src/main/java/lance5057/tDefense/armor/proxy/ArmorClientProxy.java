package lance5057.tDefense.armor.proxy;

import lance5057.tDefense.armor.ArmorBase;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;

public class ArmorClientProxy {
	
	ToolBuildGuiInfo hoodGUI;
	
	public void preInit()
	{
		registerToolRenderers();
	}
	public void init()
	{
		createToolGuis();
		setupToolGuis();
		registerToolGuis();
	}
	public void postInit(){}
	
	public void createToolGuis()
	{
		hoodGUI = new ToolBuildGuiInfo(ArmorBase.armor_TinkerHood);
	}
	
	public void registerToolRenderers()
	{
		ModelRegisterUtil.registerToolModel(ArmorBase.armor_TinkerHood);
		
	}
	public void setupToolGuis()
	{
		hoodGUI.positions.clear();
		hoodGUI.addSlotPosition(34, 15+8);
		hoodGUI.addSlotPosition(34, 33+8);
		hoodGUI.addSlotPosition(34, 51+8);
	}
	
	public void registerToolGuis()
	{
		TinkerRegistryClient.addToolBuilding(hoodGUI);
	}
}
