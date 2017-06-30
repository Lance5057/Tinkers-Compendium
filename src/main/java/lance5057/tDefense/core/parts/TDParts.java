package lance5057.tDefense.core.parts;

import lance5057.tDefense.armor.materials.MaterialArmor;
import lance5057.tDefense.armor.materials.MaterialCloth;
import lance5057.tDefense.core.materials.ShieldMaterialStats;
import lance5057.tDefense.util.ModuleBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTools;

public class TDParts extends ModuleBase
{
	public static PartMaterialType ShieldMat;
	
	public static PartMaterialType ArmorplateMat;
	public static PartMaterialType ChainmailMat;
	public static PartMaterialType RivetMat;
	public static PartMaterialType ClaspMat;
	public static PartMaterialType ClothMat;
	
	public static ToolPart armorPlate;
	public static ToolPart chainmail;
	public static ToolPart cloth;
	public static ToolPart rivets;
	public static ToolPart clasp;
	
	public static ToolPart ringShank;
	public static ToolPart setting;
	public static ToolPart wire;
	public static ToolPart filigree;


	@Override
	public void preInit(FMLPreInitializationEvent e) {
		armorPlate = regToolPart(Material.VALUE_Ingot * 4, "armor_plate");
		chainmail = regToolPart(Material.VALUE_Ingot * 3, "chainmail");
		cloth = regToolPart(Material.VALUE_Ingot * 3, "cloth");
		rivets = regToolPart(Material.VALUE_Ingot * 1, "rivets");
		clasp = regToolPart(Material.VALUE_Ingot * 1, "clasp");
		
		ringShank = regToolPart(Material.VALUE_Ingot * 2, "ringShank");
		setting = regToolPart(Material.VALUE_Ingot * 1, "setting");
		wire = regToolPart(Material.VALUE_Ingot * 1, "wire");
		filigree = regToolPart(Material.VALUE_Ingot * 1, "filigree");
		
		ShieldMat = new PartMaterialType(armorPlate, ShieldMaterialStats.TYPE);
		ArmorplateMat = new PartMaterialType(armorPlate, MaterialArmor.TYPE);
		ChainmailMat = new PartMaterialType(chainmail, MaterialArmor.TYPE);
		RivetMat = new PartMaterialType(rivets, MaterialTypes.EXTRA);
		ClaspMat = new PartMaterialType(clasp, MaterialTypes.EXTRA);
		ClothMat = new PartMaterialType(cloth, MaterialCloth.TYPE);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private ToolPart regToolPart(int castVolume, String name)
	{
		ToolPart part = new ToolPart(castVolume);
		part.setUnlocalizedName(name).setRegistryName("tinkersdefense:"+name);
		GameRegistry.register(part);
		TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), part));
		
		return part;
	}

	
}
