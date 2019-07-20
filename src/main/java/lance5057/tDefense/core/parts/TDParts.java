package lance5057.tDefense.core.parts;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.library.ArmorPart;
import lance5057.tDefense.core.library.ModuleBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerTools;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDParts extends ModuleBase
{
	private static final List<ToolPart> toolParts = new ArrayList<>();
	private static final List<ArmorPart> armorParts = new ArrayList<>();
	static List<Pair<Item, ToolPart>> toolPartPatterns = Lists.newLinkedList();
	static List<Pair<Item, ArmorPart>> armorPartPatterns = Lists.newLinkedList();
	// public static PartMaterialType ShieldMat;

	// public static PartMaterialType ArmorplateMat;
	// public static PartMaterialType ChainmailMat;
	// public static PartMaterialType RivetMat;
	// public static PartMaterialType ClaspMat;
	// public static PartMaterialType ClothMat;

	public static ToolPart	armorPlate;
	public static ArmorPart	chainmail;
	public static ArmorPart	fabric;
	public static ToolPart	rivets;
	public static ToolPart	clasp;

	public static ToolPart	ringShank;
	public static ToolPart	setting;
	public static ToolPart	wire;
	public static ToolPart	filigree;

	// public static ToolPart armor_hoodCloth;

	protected static ArrayList<Item> itemList = new ArrayList<Item>();

	@Override
	public void preInit(FMLPreInitializationEvent e)
	{

	}

	@Override
	public void init(FMLInitializationEvent e)
	{
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	public void registerItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry registry = event.getRegistry();

		armorPlate = regToolPart(Material.VALUE_Ingot * 4, "armor_plate", event);
		// armorPlate = new ToolPart(Material.VALUE_Ingot * 4);
		// armorPlate.setUnlocalizedName("armor_plate").setRegistryName("tinkersdefense:armor_plate");
		// GameRegistry.register(armorPlate);
		//
		// TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new
		// ItemStack(TinkerTools.pattern), armorPlate));
		//
		chainmail = regArmorPart(Material.VALUE_Ingot * 3, "chainmail", event);

		fabric = regArmorPart(Material.VALUE_Ingot * 3, "fabric", event);

		rivets = regToolPart(Material.VALUE_Ingot * 1, "rivets", event);
		clasp = regToolPart(Material.VALUE_Ingot * 1, "clasp", event);
//
		ringShank = regToolPart(Material.VALUE_Ingot * 2, "ringShank", event);
		setting = regToolPart(Material.VALUE_Ingot * 1, "setting", event);
//		wire = regToolPart(Material.VALUE_Ingot * 1, "wire", event);
		filigree = regToolPart(Material.VALUE_Ingot * 1, "filigree", event);

		// ShieldMat = new PartMaterialType(TDParts.armorPlate,
		// ShieldMaterialStats.TYPE);

		// ArmorplateMat = new PartMaterialType(armorPlate, MaterialArmor.TYPE);
		// ChainmailMat = new PartMaterialType(chainmail, MaterialArmor.TYPE);
		// RivetMat = new PartMaterialType(rivets, MaterialTypes.EXTRA);
		// ClaspMat = new PartMaterialType(clasp, MaterialTypes.EXTRA);
		// ClothMat = new PartMaterialType(cloth, MaterialCloth.TYPE);

		// registry.registerAll((Item[]) itemList.toArray());

		// armor_hoodCloth = regToolPart(Material.VALUE_Ingot * 1,
		// "armor_hood_cloth", event);
		for(Pair<Item, ToolPart> toolPartPattern : toolPartPatterns) {
		      registerStencil(toolPartPattern.getLeft(), toolPartPattern.getRight());
		    }
		
		for(Pair<Item, ArmorPart> toolPartPattern : armorPartPatterns) {
		      registerStencil(toolPartPattern.getLeft(), toolPartPattern.getRight());
		    }
		
//		for (final IToolPart part : toolParts)
//		{
//			for (final ToolCore tool : TDTools.tools)
//			{
//				for (final PartMaterialType pmt : tool.getRequiredComponents())
//				{
//					if (pmt.getPossibleParts().contains(part))
//					{
//						TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), (Item) part));
//					}
//				}
//			}
//			
//			for (final ArmorCore armor : TDTools.armors)
//			{
//				for (final PartMaterialType pmt : armor.getRequiredComponents())
//				{
//					if (pmt.getPossibleParts().contains(part))
//					{
//						TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), (Item) part));
//					}
//				}
//			}
//		}
	}

	private static ToolPart regToolPart(int castVolume, String name, RegistryEvent.Register<Item> event)
	{
		ToolPart part = new ToolPart(castVolume);
		part.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Reference.MOD_ID,name));
		event.getRegistry().register(part);
		
		if(TinkerTools.pattern != null) {
		      toolPartPatterns.add(Pair.of(TinkerTools.pattern, part));
		    }
		
		TinkerRegistry.registerToolPart(part);
		
		TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), (Item) part));

		// TinkerRegistry.registerTableCasting(output, cast, fluid, amount);
		toolParts.add(part);
		itemList.add(part);

		return part;
	}

	private void registerStencil(Item pattern, ToolPart toolPart) {
	    for(ToolCore toolCore : TinkerRegistry.getTools()) {
	      for(PartMaterialType partMaterialType : toolCore.getRequiredComponents()) {
	        if(partMaterialType.getPossibleParts().contains(toolPart)) {
	          ItemStack stencil = new ItemStack(pattern);
	          Pattern.setTagForPart(stencil, toolPart);
	          TinkerRegistry.registerStencilTableCrafting(stencil);
	          return;
	        }
	      }
	    }
	  }
	
	private static ArmorPart regArmorPart(int castVolume, String name, RegistryEvent.Register<Item> event)
	{
		ArmorPart part = new ArmorPart(castVolume);
		part.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Reference.MOD_ID,name));
		event.getRegistry().register(part);
		
		if(TinkerTools.pattern != null) {
		      armorPartPatterns.add(Pair.of(TinkerTools.pattern, part));
		    }
		
		TinkerRegistry.registerToolPart(part);
		//.proxy.registerArmorPartModel(part);
		TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), (Item) part));

		// TinkerRegistry.registerTableCasting(output, cast, fluid, amount);
		armorParts.add(part);
		itemList.add(part);

		return part;
	}

	private void registerStencil(Item pattern, ArmorPart toolPart) {
	    for(ToolCore toolCore : TinkerRegistry.getTools()) {
	      for(PartMaterialType partMaterialType : toolCore.getRequiredComponents()) {
	        if(partMaterialType.getPossibleParts().contains(toolPart)) {
	          ItemStack stencil = new ItemStack(pattern);
	          Pattern.setTagForPart(stencil, toolPart);
	          TinkerRegistry.registerStencilTableCrafting(stencil);
	          return;
	        }
	      }
	    }
	  }
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		for(ToolPart p: toolParts)
		{
			ModelRegisterUtil.registerPartModel(p);
		}
		
		for(ArmorPart a: armorParts)
		{
			ModelRegisterUtil.registerPartModel(a);
		}
	}

	@Override
	public void registerBlocks(Register<Block> event) {
		// TODO Auto-generated method stub
		
	}
}
