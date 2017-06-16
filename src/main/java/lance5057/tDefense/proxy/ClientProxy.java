package lance5057.tDefense.proxy;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TD_Commands;
import lance5057.tDefense.baubles.BaublesClientProxy;
import lance5057.tDefense.core.CoreClientProxy;
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
	
	public static BaublesClientProxy baubles = new BaublesClientProxy();
	
	ToolBuildGuiInfo roundshieldGUI;
	ToolBuildGuiInfo heatershieldGUI;
	
	ToolBuildGuiInfo zweihanderGUI;
	
	public static CoreClientProxy coreProxy = new CoreClientProxy();
	public static HolidayClientProxy holiProxy = new HolidayClientProxy();
	//public static ArmorClientProxy armorProxy = new ArmorClientProxy();
	
	@Override
	public void preInit()
	{
		ClientCommandHandler.instance.registerCommand(new TD_Commands());
		registerToolRenderers();
		
		coreProxy.preInit();
		//armorProxy.preInit();
		baubles.preInit();
	}
	
	@Override
	public void init()
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
		
		coreProxy.init();
		//armorProxy.init();
		holiProxy.Init();
		baubles.init();
	}
	
	public void registerToolRenderers()
	{
		ModelRegisterUtil.registerToolModel(TDTools.roundshield);
		ModelRegisterUtil.registerToolModel(TDTools.heatershield);
		ModelRegisterUtil.registerToolModel(TDTools.zweihander);
		
	}
	
	public void createToolGuis()
	{
		roundshieldGUI = new ToolBuildGuiInfo(TDTools.roundshield);
		heatershieldGUI = new ToolBuildGuiInfo(TDTools.heatershield);
		zweihanderGUI = new ToolBuildGuiInfo(TDTools.zweihander);
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
		
		zweihanderGUI.addSlotPosition(34, 15+8);
		zweihanderGUI.addSlotPosition(25, 33+8);
		zweihanderGUI.addSlotPosition(43, 33+8);
		zweihanderGUI.addSlotPosition(34, 51+8);
	}
	
	public void registerToolGuis()
	{
		TinkerRegistryClient.addToolBuilding(roundshieldGUI);
		TinkerRegistryClient.addToolBuilding(heatershieldGUI);
		TinkerRegistryClient.addToolBuilding(zweihanderGUI);
	}
	
	@Override
	public void reloadRenderers()
	{
		setToolGuis();
		
		baubles.reloadRenderers();
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
		
		zweihanderGUI.positions.clear();
		zweihanderGUI.addSlotPosition(34, 15);
		zweihanderGUI.addSlotPosition(25, 33);
		zweihanderGUI.addSlotPosition(43, 33);
		zweihanderGUI.addSlotPosition(34, 51);
	}
	
	 public static void registerItemRenderer(Item item, int meta, String id) {
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
		 }
}
