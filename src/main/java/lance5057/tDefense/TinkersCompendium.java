package lance5057.tDefense;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import lance5057.tDefense.core.addons.bloodmagic.AddonBloodMagic;
import lance5057.tDefense.core.addons.botania.AddonBotania;
import lance5057.tDefense.core.addons.toolleveling.AddonToolLeveling;
import lance5057.tDefense.core.entities.CompendiumEntities;
import lance5057.tDefense.core.events.TDEvents;
import lance5057.tDefense.core.library.book.CompendiumBook;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import lance5057.tDefense.core.materials.CompendiumTraits;
import lance5057.tDefense.core.modifiers.CompendiumModifiers;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.TDTools;
import lance5057.tDefense.core.workstations.CompendiumWorkstations;
import lance5057.tDefense.proxy.CommonProxy;
import lance5057.tDefense.textiles.CompendiumTextiles;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import scala.reflect.internal.Trees.Modifiers;
import slimeknights.mantle.client.CreativeTab;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME, dependencies = "required-after:tconstruct@[1.12-2.7.2.15,);")
public class TinkersCompendium {

	private static int modGuiIndex = 0;
	// public static final int GUI_CREST_INV = modGuiIndex++;
	// public static final int GUI_ANVIL_INV = modGuiIndex++;
	// public static final int GUI_GUIDEBOOK = modGuiIndex++;
	// public static final int GUI_STRAPS_INV = modGuiIndex++;

	@Mod.Instance(Reference.MOD_ID)
	public static TinkersCompendium instance = new TinkersCompendium();

	PacketHandler phandler = new PacketHandler();

	public static CreativeTab tab = new CreativeTab("tinkerscompendium", new ItemStack(Items.SHIELD));
	public static TCConfig config;

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

	public static Modifiers mods;

	public static TDParts parts;
	public static TDTools tools;
	public static CompendiumMaterials mats;
	public static CompendiumTraits traits;
	public static CompendiumWorkstations workstations;
	public static CompendiumModifiers modifiers;
	public static TDEvents events;
	public static CompendiumEntities entities;

	public static CompendiumTextiles textiles;

	public static AddonBloodMagic bloodmagic;
	public static AddonBotania botania;
	public static AddonToolLeveling leveling;

	@SidedProxy(clientSide = "lance5057.tDefense.proxy.ClientProxy", serverSide = "lance5057.tDefense.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		parts = new TDParts();
		mats = new CompendiumMaterials();
		tools = new TDTools();
		events = new TDEvents();
		traits = new CompendiumTraits();
		modifiers = new CompendiumModifiers();
		workstations = new CompendiumWorkstations();
		entities = new CompendiumEntities();
		textiles = new CompendiumTextiles();
		config = new TCConfig();
		
		if (Loader.isModLoaded("bloodmagic") && TCConfig.addons.BloodMagic)
			bloodmagic = new AddonBloodMagic();
		if (Loader.isModLoaded("botania") && TCConfig.addons.Botania)
			botania = new AddonBotania();
		if(Loader.isModLoaded("tinkertoolleveling") && TCConfig.addons.ToolLeveling)
			leveling = new AddonToolLeveling();

		parts.preInit(e);
		mats.preInit(e);
		tools.preInit(e);
		traits.preInit();
		modifiers.preInit();
		workstations.preInit(e);
		textiles.preInit();
		events.preInit();
		entities.preInit(e);
		
		if(bloodmagic != null)
			bloodmagic.preInit(e);
		if(botania != null)
			botania.preInit(e);
		
		proxy.preInit();

		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			CompendiumBook.init();
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);

		parts.init(e);
		mats.init(e);
		tools.init(e);
		traits.init();
		modifiers.init();
		workstations.init(e);
		textiles.init();
		events.init();
		
		entities.init(e);
		
		if(bloodmagic != null)
			bloodmagic.init(e);
		if(botania != null)
			botania.init(e);
		if(leveling != null)
			leveling.init(e);
		
		proxy.init();

		phandler.init();

		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		parts.postInit(e);
		mats.postInit(e);
		tools.postInit(e);
		traits.postInit();
		modifiers.postInit();
		workstations.postInit(e);
		textiles.postInit();
		events.postInit();
		
		entities.postInit(e);
		
		if(bloodmagic != null)
			bloodmagic.postInit(e);		
		if(botania != null)
			botania.postInit(e);	
		if(leveling != null)
			leveling.postInit(e);
		
		proxy.postInit();

		if (TCConfig.debug) {
			dumpBiomeInfo();
		}
	}

	//public static List<MaterialHelper.oreGen> biomeCheck = new ArrayList<MaterialHelper.oreGen>();

	void dumpBiomeInfo() {
		File f = new File(Loader.instance().getConfigDir(), "BiomeDump.txt");
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(f));

			for (Biome b : ForgeRegistries.BIOMES) {
				output.write(b.getBiomeName());
				output.newLine();

				output.write("Elevation:" + Float.toString(b.getBaseHeight()));
				output.newLine();

				output.write("Temperature:" + Float.toString(b.getDefaultTemperature()));
				output.newLine();

				output.write("Humidity:" + Float.toString(b.getRainfall()));
				output.newLine();
				output.newLine();

//				for (MaterialHelper.oreGen ore : biomeCheck) {
//					if ((ore.oreBiomeWhite == null || checkBiome(b, ore.oreBiomeWhite))
//							&& (ore.oreBiomeBlack == null || !checkBiome(b, ore.oreBiomeBlack))) {
//						float temp = b.getDefaultTemperature();
//						float elevation = b.getBaseHeight();
//						float humidity = b.getRainfall();
//
//						// -2 = null
//						if (ore.biomeTempMax == -2 || ore.biomeTempMin == -2
//								|| (temp >= ore.biomeTempMin && temp <= ore.biomeTempMax))
//							if (ore.biomeElevationMax == -2 || ore.biomeElevationMin == -2
//									|| (elevation >= ore.biomeElevationMin && elevation <= ore.biomeElevationMax))
//								if (ore.biomeHumidityMax == -2 || ore.biomeHumidityMin == -2
//										|| (humidity >= ore.biomeHumidityMin && humidity <= ore.biomeHumidityMax)) {
//									output.write(ore.getName());
//									output.newLine();
//								}
//					}
//				}

				output.write("------------------");
				output.newLine();
			}

			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean checkBiome(Biome current, Biome[] biomes) {
		if (biomes != null) {
			for (Biome b : biomes) {
				if (current == b)
					return true;
			}
		} else
			return true;
		return false;
	}
	
	
}
