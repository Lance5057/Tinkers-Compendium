package lance5057.tDefense.core.parts;

import java.util.ArrayList;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.materials.MaterialArmor;
import lance5057.tDefense.armor.materials.MaterialCloth;
import lance5057.tDefense.core.materials.ShieldMaterialStats;
import lance5057.tDefense.util.ModuleBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTools;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDParts extends ModuleBase {
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

	protected static ArrayList<Item> itemList = new ArrayList<Item>();

	@Override
	public void preInit(FMLPreInitializationEvent e) {

	}

	@Override
	public void init(FMLInitializationEvent e) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub

	}

	public void registerItems(final RegistryEvent.Register<Item> event) {

		final IForgeRegistry registry = event.getRegistry();

		armorPlate = regToolPart(Material.VALUE_Ingot * 4, "armor_plate", event);
		// armorPlate = new ToolPart(Material.VALUE_Ingot * 4);
		// armorPlate.setUnlocalizedName("armor_plate").setRegistryName("tinkersdefense:armor_plate");
		// GameRegistry.register(armorPlate);
		//
		// TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new
		// ItemStack(TinkerTools.pattern), armorPlate));
		//
		chainmail = regToolPart(Material.VALUE_Ingot * 3, "chainmail", event);
		cloth = regToolPart(Material.VALUE_Ingot * 3, "cloth", event);
		rivets = regToolPart(Material.VALUE_Ingot * 1, "rivets", event);
		clasp = regToolPart(Material.VALUE_Ingot * 1, "clasp", event);

		ringShank = regToolPart(Material.VALUE_Ingot * 2, "ringShank", event);
		setting = regToolPart(Material.VALUE_Ingot * 1, "setting", event);
		wire = regToolPart(Material.VALUE_Ingot * 1, "wire", event);
		filigree = regToolPart(Material.VALUE_Ingot * 1, "filigree", event);
		
		ShieldMat = new PartMaterialType(TDParts.armorPlate, ShieldMaterialStats.TYPE);

		ArmorplateMat = new PartMaterialType(armorPlate, MaterialArmor.TYPE);
		ChainmailMat = new PartMaterialType(chainmail, MaterialArmor.TYPE);
		RivetMat = new PartMaterialType(rivets, MaterialTypes.EXTRA);
		ClaspMat = new PartMaterialType(clasp, MaterialTypes.EXTRA);
		ClothMat = new PartMaterialType(cloth, MaterialCloth.TYPE);

		//registry.registerAll((Item[]) itemList.toArray());
	}

	private static ToolPart regToolPart(int castVolume, String name, RegistryEvent.Register<Item> event) {
		ToolPart part = new ToolPart(castVolume);
		part.setUnlocalizedName(name).setRegistryName("tinkersdefense:" + name);
		event.getRegistry().register(part);
		TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), part));
		TinkersDefense.proxy.registerPartModel(part);
		// TinkerRegistry.registerTableCasting(output, cast, fluid, amount);
		itemList.add(part);
		
		return part;
	}

}
