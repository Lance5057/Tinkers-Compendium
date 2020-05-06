package lance5057.tDefense.core.addons.actuallyadditions;

import lance5057.tDefense.TCConfig;
import lance5057.tDefense.core.library.ModuleBase;
import lance5057.tDefense.core.library.materialutilities.ArmorMaterial;
import lance5057.tDefense.core.library.materialutilities.CraftableMaterial;
import lance5057.tDefense.core.library.materialutilities.MaterialHelper;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class AddonActuallyAdditions extends ModuleBase {
	public static MaterialHelper blackquartz;
	public static MaterialHelper Void;
	public static MaterialHelper enori;
	public static MaterialHelper palis;
	public static MaterialHelper restonia;
	public static MaterialHelper emeradic;
	public static MaterialHelper diamatine;

	public AddonActuallyAdditions() {
	}

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		if (TinkerRegistry.getMaterial("quartzblack") == Material.UNKNOWN) {
			blackquartz = new MaterialHelper("quartzblack", TextFormatting.BLACK.getColorIndex());
			blackquartz.addons
					.add(new CraftableMaterial("gem", "gemQuartzBlack", new HeadMaterialStats(380, 6, 4.5f, HarvestLevels.DIAMOND),
							new HandleMaterialStats(0.8f, 0), new ExtraMaterialStats(50),
							new ShieldMaterialStats(380 / 4, 45), CompendiumMaterials.whyWouldYouMakeABowOutOfThis).disableBlock().disableIngot().disableNugget());
			blackquartz.addons
					.add(new ArmorMaterial(new HelmMaterialStats(320, 3, 0, 10), new ChestMaterialStats(320, 6, 3, 15),
							new LegsMaterialStats(320, 6, 0, 12.5f), new FeetMaterialStats(320, 3, 0, 10)));
			CompendiumMaterials.materials.add(blackquartz);
		}
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void registerItems(Register<Item> event) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void registerBlocks(Register<Block> event) {
//		// TODO Auto-generated method stub
//
//	}
}
