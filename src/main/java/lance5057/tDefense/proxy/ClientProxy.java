package lance5057.tDefense.proxy;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TD_Commands;
import lance5057.tDefense.core.CoreItems;
import lance5057.tDefense.core.tools.TDTools;
import lance5057.tDefense.holiday.HolidayClientProxy;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.model.ModelLoader;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;

//import lance5057.tDefense.core.renderer.TestSkinChanger;

public class ClientProxy extends CommonProxy 
{
	//static final ToolModelLoader toolmodel = new ToolModelLoader();
	//public static final ModelSheath sheath = new ModelSheath();
	//ModifierSoulHandler						SoulHandler;

//	public static ModelTinkersTabard		sheath;
//
//	public static ModelTinkersHelm			helm;
//	public static ModelTinkersBreastplate	breastplate;
//	public static ModelTinkersGrieves		grieves;
//	public static ModelTinkersSabatons		sabatons;
//	public static ModelTinkersGauntlets		gauntlets;
//
//	public static ModelTinkersHood			hood;
//	public static ModelTinkersShawl			shawl;
//	public static ModelTinkersRobe			robe;
//	public static ModelTinkersShoes			shoes;
//
//	public static ModelTinkersCoif			coif;
//	public static ModelTinkersHauberk		hauberk;
//	public static ModelTinkersChausses		chausses;
//	public static ModelTinkersBoots			boots;
	
	ToolBuildGuiInfo roundshieldGUI;
	ToolBuildGuiInfo heatershieldGUI;
	
	HolidayClientProxy holiProxy = new HolidayClientProxy();
	
	@Override
	public void preInit()
	{
		ClientCommandHandler.instance.registerCommand(new TD_Commands());
		registerToolRenderers();
		
	}
	
	@Override
	public void Init()
	{
//		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
//	    .register(TDTools.heatershield, 0, new ModelResourceLocation("modid:itemname", "inventory"));
//		
		
		createToolGuis();
		setupToolGuis();
		registerToolGuis();
		
		registerItemRenderer(CoreItems.item_aeonsteelIngot, 0, CoreItems.item_aeonsteelIngot.getUnlocalizedName());
		registerItemRenderer(CoreItems.item_dogbeariumIngot, 0, CoreItems.item_dogbeariumIngot.getUnlocalizedName());
		registerItemRenderer(CoreItems.item_queensgoldIngot, 0, CoreItems.item_queensgoldIngot.getUnlocalizedName());
		
		holiProxy.Init();
	}
	
	public void registerToolRenderers()
	{
		ModelRegisterUtil.registerToolModel(TDTools.roundshield);
		ModelRegisterUtil.registerToolModel(TDTools.heatershield);
		
		
	}
	
	public void createToolGuis()
	{
		roundshieldGUI = new ToolBuildGuiInfo(TDTools.roundshield);
		heatershieldGUI = new ToolBuildGuiInfo(TDTools.heatershield);
	}
	
	public void setupToolGuis()
	{
		roundshieldGUI.addSlotPosition(34, 15+8);
		roundshieldGUI.addSlotPosition(34, 33+8);
		roundshieldGUI.addSlotPosition(34, 51+8);
		
		heatershieldGUI.addSlotPosition(34, 15+8);
		heatershieldGUI.addSlotPosition(25, 33+8);
		heatershieldGUI.addSlotPosition(43, 33+8);
		heatershieldGUI.addSlotPosition(34, 51+8);
	}
	
	public void registerToolGuis()
	{
		TinkerRegistryClient.addToolBuilding(roundshieldGUI);
		TinkerRegistryClient.addToolBuilding(heatershieldGUI);
	}
	
	@Override
	public void reloadRenderers()
	{
		setToolGuis();
	}
	
	public void setToolGuis()
	{
		roundshieldGUI.positions.clear();
		roundshieldGUI.addSlotPosition(34, 15);
		roundshieldGUI.addSlotPosition(34, 33);
		roundshieldGUI.addSlotPosition(34, 51);
		
		heatershieldGUI.positions.clear();
		heatershieldGUI.addSlotPosition(34, 15);
		heatershieldGUI.addSlotPosition(25, 33);
		heatershieldGUI.addSlotPosition(43, 33);
		heatershieldGUI.addSlotPosition(34, 51);
	}
	
	 public static void registerItemRenderer(Item item, int meta, String id) {
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
		 }
}
