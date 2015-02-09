package gmail.Lance5057.com;

import static net.minecraft.util.EnumChatFormatting.DARK_RED;
import static net.minecraft.util.EnumChatFormatting.GOLD;
import static net.minecraft.util.EnumChatFormatting.LIGHT_PURPLE;
import gmail.Lance5057.blocks.AeonSteelBlock;
import gmail.Lance5057.blocks.CrestMount;
import gmail.Lance5057.blocks.DogbeariumBlock;
import gmail.Lance5057.blocks.QueensGoldBlock;
import gmail.Lance5057.blocks.TileEntity_CrestMount;
import gmail.Lance5057.items.AeonSteelIngot;
import gmail.Lance5057.items.DogbeariumIngot;
import gmail.Lance5057.items.QueensGoldIngot;
import gmail.Lance5057.proxy.CommonProxy;
import gmail.Lance5057.proxy.Handler_CrestMount;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.client.ToolGuiElement;
import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.crafting.Smeltery;
import tconstruct.library.tools.ToolCore;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="tinkersdefense", version="1.0")
public class mod_TinkersDefense
{
public static String MODID = "tinkersdefense";
public static String VERSION = "1.0";

private static int modGuiIndex = 0;
public static final int GUI_ITEM_INV = modGuiIndex++;

@Instance("tinkersdefense")
public static mod_TinkersDefense instance = new mod_TinkersDefense();

public static CreativeTabs tabName = new CreativeTabs("tabName")
{
public Item getTabIconItem()
{
return Items.arrow;
}
};

public static SimpleNetworkWrapper network;

public static Item item_AeonSteelIngot;
public static Block block_AeonSteelBlock;

public static Fluid moltenAeonsteel;
public static Block moltenAeonsteelBlock;

public static Item item_QueensGoldIngot;
public static Block block_QueensGoldBlock;

public static Fluid moltenQueensGold;
public static Block moltenQueensGoldBlock;

public static Item item_DogbeariumIngot;
public static Block block_DogbeariumBlock;

public static Fluid moltenDogbearium;
public static Block moltenDogbeariumBlock;

public static ToolCore tool_roundShield;
public static ToolCore tool_heaterShield;

public static Block block_CrestMount;

public static Item item_TinkerArmor;

@SidedProxy(clientSide = "gmail.Lance5057.proxy.ClientProxy", serverSide = "gmail.Lance5057.proxy.CommonProxy")
public static CommonProxy proxy;




@EventHandler
public void preInit(FMLPreInitializationEvent e)
{
	//Network
	network = NetworkRegistry.INSTANCE.newSimpleChannel("tDefense");
	Handler_CrestMount.INSTANCE.ordinal();
	
	//Renderers
	proxy.registerRenderers();
	
	//AeonSteel
	item_AeonSteelIngot = new AeonSteelIngot()
		.setCreativeTab(tabName)
		.setMaxStackSize(64)
		.setUnlocalizedName("AeonSteelIngot")
		.setTextureName(MODID+":AeonSteelIngot");
	
	GameRegistry.registerItem(item_AeonSteelIngot, "AeonSteel Ingot");
	
	block_AeonSteelBlock = new AeonSteelBlock(Material.iron)
		.setHardness(4.0F)
		.setStepSound(Block.soundTypeMetal)
		.setBlockName("AeonSteelBlock")
		.setCreativeTab(tabName)
		.setBlockTextureName(MODID+":AeonSteelBlock");	
	
    GameRegistry.registerBlock(block_AeonSteelBlock, "aeonsteelblock");
    
    GameRegistry.addShapedRecipe(new ItemStack(block_AeonSteelBlock), new Object[] {"xxx", "xxx","xxx",
            'x', item_AeonSteelIngot});
    GameRegistry.addShapelessRecipe(new ItemStack(item_AeonSteelIngot,9),new Object[] {new ItemStack(block_AeonSteelBlock)});
    
    moltenAeonsteel = new Fluid("moltenAeonsteel").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
    FluidRegistry.registerFluid(moltenAeonsteel);
    
    moltenAeonsteelFluid moltenAeonsteelBlock = new moltenAeonsteelFluid(moltenAeonsteel);
    
    GameRegistry.registerBlock(moltenAeonsteelBlock, "moltenaeonsteel");
    
    //Queen's Gold
	item_QueensGoldIngot = new QueensGoldIngot()
		.setCreativeTab(tabName)
		.setMaxStackSize(64)
		.setUnlocalizedName("QueensGoldIngot")
		.setTextureName(MODID+":QueensGoldIngot");
	
	GameRegistry.registerItem(item_QueensGoldIngot, "Queen's Gold Ingot");
	
	block_QueensGoldBlock = new QueensGoldBlock(Material.iron)
	.setHardness(4.0F)
	.setStepSound(Block.soundTypeMetal)
	.setBlockName("QueensGoldBlock")
	.setCreativeTab(tabName)
	.setBlockTextureName(MODID+":QueensGoldBlock");	

	GameRegistry.registerBlock(block_QueensGoldBlock, "QueensGoldblock");
	
	 GameRegistry.addShapedRecipe(new ItemStack(block_QueensGoldBlock), new Object[] {"xxx", "xxx","xxx",
         'x', item_QueensGoldIngot});
	 GameRegistry.addShapelessRecipe(new ItemStack(item_QueensGoldIngot,9),new Object[] {new ItemStack(block_QueensGoldBlock)});
 
	
	moltenQueensGold = new Fluid("moltenQueensGold").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
    FluidRegistry.registerFluid(moltenQueensGold);
    
    moltenQueensGoldFluid moltenQueensGoldBlock = new moltenQueensGoldFluid(moltenQueensGold);
    
    GameRegistry.registerBlock(moltenQueensGoldBlock, "moltenQueensGold");
    
  //Dogbearium
  	item_DogbeariumIngot = new DogbeariumIngot()
  		.setCreativeTab(tabName)
  		.setMaxStackSize(64)
  		.setUnlocalizedName("DogbeariumIngot")
  		.setTextureName(MODID+":DogbeariumIngot");
  	
  	GameRegistry.registerItem(item_DogbeariumIngot, "DogbeariumIngot");
  	
  	block_DogbeariumBlock = new DogbeariumBlock(Material.iron)
  		.setHardness(4.0F)
  		.setStepSound(Block.soundTypeMetal)
  		.setBlockName("DogbeariumBlock")
  		.setCreativeTab(tabName)
  		.setBlockTextureName(MODID+":DogbeariumBlock");	
  	
      GameRegistry.registerBlock(block_DogbeariumBlock, "Dogbeariumblock");
      
      GameRegistry.addShapedRecipe(new ItemStack(block_DogbeariumBlock), new Object[] {"xxx", "xxx","xxx",
          'x', item_DogbeariumIngot});
      GameRegistry.addShapelessRecipe(new ItemStack(item_DogbeariumIngot,9),new Object[] {new ItemStack(block_DogbeariumBlock)});
  
      
      moltenDogbearium = new Fluid("moltenDogbearium").setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
      FluidRegistry.registerFluid(moltenDogbearium);
      
      moltenDogbeariumFluid moltenDogbeariumBlock = new moltenDogbeariumFluid(moltenDogbearium);
      
      GameRegistry.registerBlock(moltenDogbeariumBlock, "moltenDogbearium");
    
    tool_roundShield = new RoundShield();
    tool_heaterShield = new HeaterShield();
    
    GameRegistry.registerItem(tool_roundShield, "Round Shield");
    GameRegistry.registerItem(tool_heaterShield, "Heater Shield");
    TConstructRegistry.addItemToDirectory("Round Shield", tool_roundShield);
    TConstructRegistry.addItemToDirectory("Heater Shield", tool_heaterShield);   
    
    block_CrestMount = new CrestMount()
      		.setHardness(4.0F)
      		.setStepSound(Block.soundTypeMetal)
      		.setBlockName("CrestMount")
      		.setCreativeTab(tabName);	
    
    
    
    //item_TinkerArmor = new TinkerArmor(ArmorMaterial.IRON, 4, 1).setUnlocalizedName("Tinker_Armor");
    //GameRegistry.registerItem(item_TinkerArmor,"Tinker Armor");
}

@EventHandler
public void load(FMLInitializationEvent evt)
{
	GameRegistry.registerTileEntity(TileEntity_CrestMount.class, "Tile_CrestMount");
    GameRegistry.registerBlock(block_CrestMount, "Block_CrestMount");
    NetworkRegistry.INSTANCE.registerGuiHandler(mod_TinkersDefense.instance, new CommonProxy());
    MinecraftForge.EVENT_BUS.register(this);
}

@EventHandler
public void init(FMLInitializationEvent e)
{
	System.out.print(MODID);
	 PatternBuilder pb = PatternBuilder.instance;
	    pb.registerMaterialSet("AeonSteel", new ItemStack(TinkerTools.toolShard, 1, 10), new ItemStack(TinkerTools.toolRod, 1, 10), 10);
	 // Tool Materials: id, name, harvestlevel, durability, speed, damage, handlemodifier, reinforced, shoddy, style color, primary color for block use
	   //Aeonsteel
	    TConstructClientRegistry.addMaterialRenderMapping(201, "tinker", "aeonsteel", true);
	    TConstructRegistry.addToolMaterial(201, "AeonSteel", 4, 822, 1100, 3, 1.6F, 2, 0f, LIGHT_PURPLE.toString(), 0xb565e6);
	    TinkerTools.registerPatternMaterial("AeonSteelIngot", 2, "AeonSteel");
	    TConstructRegistry.addDefaultToolPartMaterial(201);	    

	    Smeltery.addMelting(new ItemStack(item_AeonSteelIngot, 1, 0), block_AeonSteelBlock, 0, 500, new FluidStack(moltenAeonsteel, TConstruct.ingotLiquidValue));
	    Smeltery.addMelting(block_AeonSteelBlock, 0, 500, new FluidStack(moltenAeonsteel, TConstruct.ingotLiquidValue*9));
	    
	    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(item_AeonSteelIngot, 1, 0), new FluidStack(moltenAeonsteel, TConstruct.ingotLiquidValue), TConstructRegistry.getItemStack("ingotCast"), false, 50);

	    TConstructRegistry.instance.getBasinCasting().addCastingRecipe(new ItemStack(block_AeonSteelBlock, 1, 0), new FluidStack(moltenAeonsteel, TConstruct.ingotLiquidValue*9), 100);
	    
	    castMolten(moltenAeonsteel, 201);
	    
	    PatternBuilder.instance.registerFullMaterial(new ItemStack(item_AeonSteelIngot, 1, 0), 2, "Aeonsteel", new ItemStack(TinkerTools.toolShard, 1, 201), new ItemStack(TinkerTools.toolRod, 1, 201), 201);
	    
	    Smeltery.addAlloyMixing(new FluidStack(moltenAeonsteel, 144), new FluidStack[] { new FluidStack(TinkerSmeltery.moltenAlumiteFluid, 144), new FluidStack(TinkerSmeltery.moltenCobaltFluid, 144) });
	   //Queen's Gold 
	    TConstructClientRegistry.addMaterialRenderMapping(202, "tinker", "queensgold", true);
	    TConstructRegistry.addToolMaterial(202, "QueensGold", 3, 100, 500, 2, 1.0F, 0, 0f, GOLD.toString(), 0xeaee57);
	    TinkerTools.registerPatternMaterial("QueensGoldIngot", 2, "QueensGold");
	    TConstructRegistry.addDefaultToolPartMaterial(202);
	    
	    Smeltery.addMelting(new ItemStack(item_QueensGoldIngot, 1, 0), block_QueensGoldBlock, 0, 500, new FluidStack(moltenQueensGold, TConstruct.ingotLiquidValue));
	    Smeltery.addMelting(block_QueensGoldBlock, 0, 500, new FluidStack(moltenQueensGold, TConstruct.ingotLiquidValue*9));
	    
	    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(item_QueensGoldIngot, 1, 0), new FluidStack(moltenQueensGold, TConstruct.ingotLiquidValue), TConstructRegistry.getItemStack("ingotCast"), false, 50);

	    TConstructRegistry.instance.getBasinCasting().addCastingRecipe(new ItemStack(block_QueensGoldBlock, 1, 0), new FluidStack(moltenQueensGold, TConstruct.ingotLiquidValue*9), 100);
	    
	    castMolten(moltenQueensGold, 202);
	    
	    PatternBuilder.instance.registerFullMaterial(new ItemStack(item_QueensGoldIngot, 1, 0), 2, "QueensGold", new ItemStack(TinkerTools.toolShard, 1, 202), new ItemStack(TinkerTools.toolRod, 1, 202), 202);
	 
	    Smeltery.addAlloyMixing(new FluidStack(moltenQueensGold, 144*8), new FluidStack[] { new FluidStack(TinkerSmeltery.moltenGoldFluid, 144*8), new FluidStack(TinkerSmeltery.moltenEmeraldFluid, 80) });

	    // Tool Materials: id, name, harvestlevel, durability, speed, damage, handlemodifier, reinforced, shoddy, style color, primary color for block use
	  //Dogbearium
	    TConstructClientRegistry.addMaterialRenderMapping(203, "tinker", "dogbearium", true);
	    TConstructRegistry.addToolMaterial(203, "Dogbearium", 4, 600, 800, 2, 1.6F, 0, -2f, DARK_RED.toString(), 0x754200);
	    TinkerTools.registerPatternMaterial("DogbeariumIngot", 2, "Dogbearium");
	    TConstructRegistry.addDefaultToolPartMaterial(203);	    

	    Smeltery.addMelting(new ItemStack(item_DogbeariumIngot, 1, 0), block_DogbeariumBlock, 0, 500, new FluidStack(moltenDogbearium, TConstruct.ingotLiquidValue));
	    Smeltery.addMelting(block_DogbeariumBlock, 0, 500, new FluidStack(moltenDogbearium, TConstruct.ingotLiquidValue*9));
	    
	    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(item_DogbeariumIngot, 1, 0), new FluidStack(moltenDogbearium, TConstruct.ingotLiquidValue), TConstructRegistry.getItemStack("ingotCast"), false, 50);

	    TConstructRegistry.instance.getBasinCasting().addCastingRecipe(new ItemStack(block_DogbeariumBlock, 1, 0), new FluidStack(moltenDogbearium, TConstruct.ingotLiquidValue*9), 100);
	    
	    castMolten(moltenDogbearium, 203);
	    
	    PatternBuilder.instance.registerFullMaterial(new ItemStack(item_DogbeariumIngot, 1, 0), 2, "Dogbearium", new ItemStack(TinkerTools.toolShard, 1, 203), new ItemStack(TinkerTools.toolRod, 1, 203), 203);
	    
	    Smeltery.addAlloyMixing(new FluidStack(moltenDogbearium, 144*2), new FluidStack[] { new FluidStack(TinkerSmeltery.moltenArditeFluid, 144), new FluidStack(TinkerSmeltery.bloodFluid, 160), new FluidStack(TinkerSmeltery.moltenEnderFluid,250) });

	   //Shields
	    TConstructRegistry.addToolRecipe(tool_roundShield, TinkerTools.largePlate, TinkerTools.toolRod, TinkerTools.frypanHead);

	    TConstructRegistry.addToolRecipe(tool_heaterShield, TinkerTools.largePlate, TinkerTools.toughRod, TinkerTools.largePlate, TinkerTools.toughBinding);
	    
}

@EventHandler
public void postInit(FMLPostInitializationEvent e)
{
    TConstructClientRegistry.toolButtons.add(TConstructClientRegistry.toolButtons.size(),
    		new ToolGuiElement(1, 0, 0, new int[] { 9, 0, 4, 0 }, new int[] { 2, 3, 2, 0 }, "Round Shield", "A simple shield with average durability and average defense.", "tinkersdefense", "textures/gui/icons.png"));
    TConstructClientRegistry.tierTwoButtons.add(TConstructClientRegistry.tierTwoButtons.size(),
    	    new ToolGuiElement(5, 0, 0, new int[] { 9, 8, 9, 9 }, new int[] { 2, 3, 2, 3 }, "Heater Shield", "An advanced shield with high durability and high defense.", "tinkersdefense", "textures/gui/icons.png"));
}

public void castMolten(Fluid fluid, int ID)
{
																										//.addCastingRecipe(output, fluid, cast, hardeningDelay)
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.toolRod, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("toolRodCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.pickaxeHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("pickaxeHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.shovelHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("shovelHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.hatchetHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("hatchetHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.swordBlade, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("swordBladeCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.fullGuard, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("fullGuardCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.wideGuard, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("wideGuardCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.crossbar, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("crossbarCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.binding, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("bindingCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.handGuard, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("handGuardCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.frypanHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("frypanHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.signHead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("signHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.knifeBlade, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("knifeBladeCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.chiselHead, 1, ID),new FluidStack(fluid, (int) (144*0.5D)), TConstructRegistry.getItemStack("chiselHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.toughRod, 1, ID),new FluidStack(fluid, (int) (144*3.0D)), TConstructRegistry.getItemStack("toughRodCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.toughBinding, 1, ID),new FluidStack(fluid, (int) (144*3.0D)), TConstructRegistry.getItemStack("toughBindingCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.largePlate, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("largePlateCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.broadAxeHead, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("broadAxeHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.scytheBlade, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("scytheHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.excavatorHead, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("excavatorHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.largeSwordBlade, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("largeBladeCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.hammerHead, 1, ID),new FluidStack(fluid, (int) (144*8.0D)), TConstructRegistry.getItemStack("hammerHeadCast"),50);
    TConstructRegistry.instance.getTableCasting().addCastingRecipe(new ItemStack(TinkerTools.arrowhead, 1, ID),new FluidStack(fluid, (int) (144*1.0D)), TConstructRegistry.getItemStack("arrowheadCast"),50);

    
}
}