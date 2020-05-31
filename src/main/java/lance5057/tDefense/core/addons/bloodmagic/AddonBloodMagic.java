package lance5057.tDefense.core.addons.bloodmagic;

import WayofTime.bloodmagic.core.RegistrarBloodMagicItems;
import lance5057.tDefense.Reference;
import lance5057.tDefense.TCItems;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.addons.bloodmagic.modifiers.ModScabbing;
import lance5057.tDefense.core.addons.bloodmagic.modifiers.ModWill;
import lance5057.tDefense.core.library.ModuleBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.common.ModelRegisterUtil;

public class AddonBloodMagic extends ModuleBase {
	public AddonBloodMagic() {
	}

	public static Item bloodyBandages;

	public static ModScabbing scabbing = new ModScabbing();
	public static ModWill will = new ModWill();

//	public static MaterialHelper blankslate = new MaterialHelper("blankslate", 0x5f3d3d,
//			new HeadMaterialStats(120, 4.00f, 3.00f, HarvestLevels.STONE), new HandleMaterialStats(0.50f, -50),
//			new ExtraMaterialStats(20), new ShieldMaterialStats(120 / 4, 30), CompendiumMaterials.whyWouldYouMakeABowOutOfThis,
//			new HelmMaterialStats(120, 2, 0, 0), new ChestMaterialStats(120, 4, 0, 0),
//			new LegsMaterialStats(120, 3, 0, 0), new FeetMaterialStats(120, 2, 0, 0));
//
//	public static MaterialHelper reinforcedslate = new MaterialHelper("reinforcedslate", 0x5f3d3d,
//			new HeadMaterialStats(240, 4.50f, 3.50f, HarvestLevels.IRON), new HandleMaterialStats(0.60f, 0),
//			new ExtraMaterialStats(40), new ShieldMaterialStats(240 / 4, 40), CompendiumMaterials.whyWouldYouMakeABowOutOfThis,
//			new HelmMaterialStats(240, 2, 0, 5), new ChestMaterialStats(240, 5, 0, 5),
//			new LegsMaterialStats(240, 3, 0, 5), new FeetMaterialStats(240, 2, 0, 5));
//
//	public static MaterialHelper imbuedslate = new MaterialHelper("imbuedslate", 0x5f3d3d,
//			new HeadMaterialStats(360, 5.0f, 4.0f, HarvestLevels.DIAMOND), new HandleMaterialStats(0.70f, 50),
//			new ExtraMaterialStats(60), new ShieldMaterialStats(360 / 4, 50), CompendiumMaterials.whyWouldYouMakeABowOutOfThis,
//			new HelmMaterialStats(360, 3, 0, 10), new ChestMaterialStats(360, 6, 0, 10),
//			new LegsMaterialStats(360, 6, 0, 10), new FeetMaterialStats(360, 3, 0, 10));
//
//	public static MaterialHelper demonicslate = new MaterialHelper("demonicslate", 0x5f3d3d,
//			new HeadMaterialStats(480, 5.50f, 5.50f, HarvestLevels.OBSIDIAN), new HandleMaterialStats(0.80f, 100),
//			new ExtraMaterialStats(80), new ShieldMaterialStats(480 / 4, 60), CompendiumMaterials.whyWouldYouMakeABowOutOfThis,
//			new HelmMaterialStats(480, 3, 0, 15), new ChestMaterialStats(480, 6, 1, 15),
//			new LegsMaterialStats(480, 6, 1, 15), new FeetMaterialStats(480, 3, 0, 15));
//
//	public static MaterialHelper etherealslate = new MaterialHelper("etherealslate", 0x5f3d3d,
//			new HeadMaterialStats(600, 6.0f, 6.0f, HarvestLevels.COBALT), new HandleMaterialStats(0.90f, 150),
//			new ExtraMaterialStats(100), new ShieldMaterialStats(600 / 4, 70), CompendiumMaterials.whyWouldYouMakeABowOutOfThis,
//			new HelmMaterialStats(600, 2, 1, 20), new ChestMaterialStats(600, 5, 2, 20),
//			new LegsMaterialStats(600, 3, 2, 20), new FeetMaterialStats(600, 2, 1, 20));

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		//bloodyBandages = TCItems.registerItem("bloodybandages", TinkersCompendium.tab);

		//this.setupItem(bloodyBandages, "bloodybandages");

		// CompendiumMaterials.itemList.add(bloodyBandages);

//		CompendiumMaterials.materials.add(this.blankslate);
//		CompendiumMaterials.materials.add(this.reinforcedslate);
//		CompendiumMaterials.materials.add(this.imbuedslate);
//		CompendiumMaterials.materials.add(this.demonicslate);
//		CompendiumMaterials.materials.add(this.etherealslate);

		// TinkerRegistry.registerModifier(scabbing);

		//TinkersCompendium.proxy.registerItemRenderer(bloodyBandages, 0, "bloodmagic/bloodybandages");

		TinkersCompendium.proxy.registerModifierModel(scabbing);
		TinkersCompendium.proxy.registerModifierModel(will);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		scabbing.addRecipeMatch(new RecipeMatch.Item(new ItemStack(this.bloodyBandages), 1));
		will.addRecipeMatch(new RecipeMatch.Item(new ItemStack(RegistrarBloodMagicItems.SENTIENT_SWORD), 1));
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub

	}

}
