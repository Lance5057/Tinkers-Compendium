package lance5057.tDefense.core.tools;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.eventbus.Subscribe;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.library.ArmorTags;
import lance5057.tDefense.core.library.TCRegistry;
import lance5057.tDefense.core.network.ArmorStationSelectionPacket;
import lance5057.tDefense.core.network.FinishingAnvilSelectionPacket;
import lance5057.tDefense.core.tools.armor.chain.TinkersBoots;
import lance5057.tDefense.core.tools.armor.chain.TinkersChausses;
import lance5057.tDefense.core.tools.armor.chain.TinkersCoif;
import lance5057.tDefense.core.tools.armor.chain.TinkersHauberk;
import lance5057.tDefense.core.tools.armor.cloth.TinkersHood;
import lance5057.tDefense.core.tools.armor.cloth.TinkersRobe;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShawl;
import lance5057.tDefense.core.tools.armor.cloth.TinkersShoes;
import lance5057.tDefense.core.tools.armor.heavy.TinkersBreastplate;
import lance5057.tDefense.core.tools.armor.heavy.TinkersGrieves;
import lance5057.tDefense.core.tools.armor.heavy.TinkersHelm;
import lance5057.tDefense.core.tools.armor.heavy.TinkersSabatons;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.core.tools.bases.BaubleTool;
import lance5057.tDefense.core.tools.basic.Backpack;
import lance5057.tDefense.core.tools.basic.FireDrill;
import lance5057.tDefense.core.tools.basic.FishingRod;
import lance5057.tDefense.core.tools.basic.HeaterShield;
import lance5057.tDefense.core.tools.basic.Mallet;
import lance5057.tDefense.core.tools.basic.RegDummy;
import lance5057.tDefense.core.tools.basic.RoundShield;
import lance5057.tDefense.core.tools.basic.Saw;
import lance5057.tDefense.core.tools.basic.Shears;
import lance5057.tDefense.core.tools.basic.TowerShield;
import lance5057.tDefense.core.tools.basic.Zweihander;
import lance5057.tDefense.core.tools.baubles.TinkerRing;
import lance5057.tDefense.core.tools.baubles.TinkersTabard;
import lance5057.tDefense.core.workstations.blocks.ArmorStationBlock;
import lance5057.tDefense.core.workstations.tileentities.ArmorStationTile;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.common.TinkerNetwork;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TagUtil;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDTools {
	public static final List<ToolCore> tools = new ArrayList<>();
	public static final List<ArmorCore> armors = new ArrayList<>();
	TDToolEvents events = new TDToolEvents();

	public static ArmorStationBlock station;

	public static ItemBlock stationItem;

	// Tools
	public static ToolCore regDummy;

	public static ToolCore roundshield;
	public static ToolCore heatershield;
	public static ToolCore towershield;
	public static ToolCore zweihander;
	public static ToolCore shears;
	public static ToolCore fishingRod;
	public static ToolCore mallet;
	public static ToolCore saw;
	public static ToolCore fireDrill;

	public static ArmorCore hood;
	public static ArmorCore shawl;
	public static ArmorCore robe;
	public static ArmorCore shoes;

	public static ArmorCore coif;
	public static ArmorCore hauberk;
	public static ArmorCore chausses;
	public static ArmorCore boots;

	public static ArmorCore helm;
	public static ArmorCore breastplate;
	public static ArmorCore grieves;
	public static ArmorCore sabatons;

	// baubles
	public static ToolCore sheathe;
	public static ToolCore ring;
	// public static ToolCore amulet;
	public static BaubleTool tabard;
	
	public static ToolCore backpack;

	static ArrayList<Item> itemList = new ArrayList<Item>();

	// Tool Parts

	// Modifiers

	// Helper stuff
	// static List<ToolCore> tools = Lists.newLinkedList(); // contains all
	// tools registered in this pulse
	// static List<ToolPart> toolparts = Lists.newLinkedList(); // ^ all
	// toolparts
	// static List<IModifier> modifiers = Lists.newLinkedList(); // ^ all
	// modifiers

	protected static final ResourceLocation PROPERTY_FINISHING_ANVIL0 = new ResourceLocation("finishinganvil0");
	protected static final ResourceLocation PROPERTY_FINISHING_ANVIL1 = new ResourceLocation("finishinganvil1");
	protected static final ResourceLocation PROPERTY_FINISHING_ANVIL2 = new ResourceLocation("finishinganvil2");
	protected static final ResourceLocation PROPERTY_FINISHING_ANVIL3 = new ResourceLocation("finishinganvil3");
	protected static final ResourceLocation PROPERTY_FINISHING_ANVIL4 = new ResourceLocation("finishinganvil4");

	protected final IItemPropertyGetter finishingAnvilPropertyGetter = new IItemPropertyGetter() {
		@Override
		@SideOnly(Side.CLIENT)
		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
			if (stack.getItem() instanceof ToolCore) {
				return getAnvilID(stack, entityIn, 0);
			}
			return 0;
		}
	};
//
//	protected final IItemPropertyGetter finishingAnvilPropertyGetter1 = new IItemPropertyGetter() {
//		@Override
//		@SideOnly(Side.CLIENT)
//		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
//			if (stack.getItem() instanceof ToolCore) {
//				return getAnvilID(stack, entityIn, 1);
//			}
//			return 0;
//		}
//	};
//
//	protected final IItemPropertyGetter finishingAnvilPropertyGetter2 = new IItemPropertyGetter() {
//		@Override
//		@SideOnly(Side.CLIENT)
//		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
//			if (stack.getItem() instanceof ToolCore) {
//				return getAnvilID(stack, entityIn, 2);
//			}
//			return 0;
//		}
//	};
//
//	protected final IItemPropertyGetter finishingAnvilPropertyGetter3 = new IItemPropertyGetter() {
//		@Override
//		@SideOnly(Side.CLIENT)
//		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
//			if (stack.getItem() instanceof ToolCore) {
//				return getAnvilID(stack, entityIn, 3);
//			}
//			return 0;
//		}
//	};
//
//	protected final IItemPropertyGetter finishingAnvilPropertyGetter4 = new IItemPropertyGetter() {
//		@Override
//		@SideOnly(Side.CLIENT)
//		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
//			if (stack.getItem() instanceof ToolCore) {
//				return getAnvilID(stack, entityIn, 4);
//			}
//			return 0;
//		}
//	};

	public float getAnvilID(ItemStack stack, EntityLivingBase e, int layer) {

		NBTTagCompound tag = TagUtil.getTagSafe(stack);
		if (!tag.hasKey(ArmorTags.AnvilBase)) {
			tag.setTag(ArmorTags.AnvilBase, new NBTTagCompound());
		}
		NBTTagCompound anvil = tag.getCompoundTag(ArmorTags.AnvilBase);
		if (!anvil.hasKey(ArmorTags.ModelType)) {
			anvil.setInteger(ArmorTags.ModelType, 0);
		}

		int bit = anvil.getInteger(ArmorTags.ModelType) >> (layer * 8);
		return bit;
	}

	// PRE-INITIALIZATION
	@Subscribe
	public void preInit(FMLPreInitializationEvent event) {

	}

	private void regTools() {

	}

	public void registerItems(final RegistryEvent.Register<Item> event) {

		// TODO find a way to not use this
		regDummy = new RegDummy();
		regTool(regDummy, "regdummy", event);

		if (TinkersCompendium.config.shields.enableShields) {
			if (TinkersCompendium.config.shields.enableBuckler) {
				roundshield = new RoundShield();
				regTool(roundshield, "roundshield", event);
			}
			if (TinkersCompendium.config.shields.enableHeaterShield) {
				heatershield = new HeaterShield();
				regTool(heatershield, "heatershield", event);
			}
			if (TinkersCompendium.config.shields.enableTowerShield) {
				towershield = new TowerShield();
				regTool(towershield, "towershield", event);
			}
		}

		if (TinkersCompendium.config.tools.enableTools) {
			if (TinkersCompendium.config.tools.enableZweihander) {
				zweihander = new Zweihander();
				regTool(zweihander, "zweihander", event);
			}
			if (TinkersCompendium.config.tools.enableShears) {
				shears = new Shears();
				regTool(shears, "shears", event);
			}
			if (TinkersCompendium.config.tools.enableFishingRod) {
				fishingRod = new FishingRod();
				regTool(fishingRod, "fishingRod", event);
			}
			if (TinkersCompendium.config.tools.enableSaw) {
				saw = new Saw();
				regTool(saw, "saw", event);
			}
			if (TinkersCompendium.config.tools.enableMallet) {
				mallet = new Mallet();
				regTool(mallet, "mallet", event);
			}
			if (TinkersCompendium.config.tools.enableFireDrill) {
				fireDrill = new FireDrill();
				regTool(fireDrill, "fireDrill", event);
			}
			
			if (TinkersCompendium.config.tools.enableBackpack) {
				backpack = new Backpack();
				regTool(backpack, "backpack", event);
			}
		}

		if (TinkersCompendium.config.armor.enableClothArmor) {
			hood = new TinkersHood();
			regArmor(hood, "hood", event);
			shawl = new TinkersShawl();
			regArmor(shawl, "shawl", event);
			robe = new TinkersRobe();
			regArmor(robe, "robe", event);
			shoes = new TinkersShoes();
			regArmor(shoes, "shoes", event);
		}

		if (TinkersCompendium.config.armor.enableChainArmor) {
			coif = new TinkersCoif();
			regArmor(coif, "coif", event);
			hauberk = new TinkersHauberk();
			regArmor(hauberk, "hauberk", event);
			chausses = new TinkersChausses();
			regArmor(chausses, "chausses", event);
			boots = new TinkersBoots();
			regArmor(boots, "boots", event);
		}

		if (TinkersCompendium.config.armor.enableChainArmor) {
			helm = new TinkersHelm();
			regArmor(helm, "helm", event);
			breastplate = new TinkersBreastplate();
			regArmor(breastplate, "breastplate", event);
			grieves = new TinkersGrieves();
			regArmor(grieves, "grieves", event);
			sabatons = new TinkersSabatons();
			regArmor(sabatons, "sabatons", event);
		}

		if (TinkersCompendium.config.baubles.enableBaubles) {
			if (TinkersCompendium.config.baubles.enableTabard) {
				tabard = new TinkersTabard();
				regTool(tabard, "tabard", event);
			}
			if (TinkersCompendium.config.baubles.enableRing) {
				ring = new TinkerRing();
				regTool(ring, "ring", event);
			}
		}

		// sheathe = new Sheathe();

		// amulet = new Amulet();

		// regTool(boots, "boots", event);

		// CustomTextureCreator.registerTexture(new
		// ResourceLocation("tinkersdefense",
		// "items/battleaxe/_halbard_accessory"));

		//
		// regTool(sheathe, "sheathe", event);

		// regTool(amulet, "amulet", event);

		final IForgeRegistry registry = event.getRegistry();
		for (Item i : itemList) {
			registry.register(i);
		}

		stationItem = (ItemBlock) new ItemBlock(station).setRegistryName(station.getRegistryName());
		registry.register(stationItem);

		for (ToolCore i : TinkerRegistry.getTools()) {
			i.addPropertyOverride(PROPERTY_FINISHING_ANVIL0, finishingAnvilPropertyGetter);
//			i.addPropertyOverride(PROPERTY_FINISHING_ANVIL1, finishingAnvilPropertyGetter1);
//			i.addPropertyOverride(PROPERTY_FINISHING_ANVIL2, finishingAnvilPropertyGetter2);
//			i.addPropertyOverride(PROPERTY_FINISHING_ANVIL3, finishingAnvilPropertyGetter3);
//			i.addPropertyOverride(PROPERTY_FINISHING_ANVIL4, finishingAnvilPropertyGetter4);
			// TinkersCompendium.proxy.registerAnvilToolModel(i);
		}

	}

	public void registerBlocks(final RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();

		station = new ArmorStationBlock();
		registry.register(station);

		GameRegistry.registerTileEntity(ArmorStationTile.class, "armorstationtile");

		//
	}

	private static void regTool(ToolCore tool, String name, RegistryEvent.Register<Item> event) {
		tool.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		event.getRegistry().register(tool);
		TinkerRegistry.registerTool(tool);
		TinkersCompendium.proxy.registerToolModel(tool);
		tools.add(tool);
	}

	private static void regArmor(ArmorCore armor, String name, RegistryEvent.Register<Item> event) {
		armor.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		event.getRegistry().register(armor);
		TCRegistry.registerTool(armor);
		TinkersCompendium.proxy.registerArmorModel(armor);
		armors.add(armor);
	}

	private void registerModifiers() {

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		TinkersCompendium.proxy.registerItemBlockRenderer(station, 0, "armorstation");

		if (TinkersCompendium.config.anvil.enableFinishingAnvilTools)
			for (ToolCore i : TinkerRegistry.getTools()) {
				// i.addPropertyOverride(PROPERTY_FINISHING_ANVIL,
				// finishingAnvilPropertyGetter);
				TinkersCompendium.proxy.registerAnvilToolModel(i);
			}
	}

	// INITIALIZATION
	@Subscribe
	public void init(FMLInitializationEvent event) {
		// register items

		// register blocks

		// register entities

		// proxy.preInit();
		regToolBuilding();
		regRecipies();

		// proxy.init();

		TinkerNetwork.instance.registerPacket(ArmorStationSelectionPacket.class);
		TinkerNetwork.instance.registerPacket(FinishingAnvilSelectionPacket.class);
	}

	private void regToolBuilding() {
		if (TinkersCompendium.config.shields.enableShields) {
			if (TinkersCompendium.config.shields.enableBuckler)
				TinkerRegistry.registerToolCrafting(roundshield);
			if (TinkersCompendium.config.shields.enableHeaterShield)
				TinkerRegistry.registerToolForgeCrafting(heatershield);
			if (TinkersCompendium.config.shields.enableTowerShield)
				TinkerRegistry.registerToolForgeCrafting(towershield);
		}

		if (TinkersCompendium.config.tools.enableTools) {
			if (TinkersCompendium.config.tools.enableZweihander)
				TinkerRegistry.registerToolForgeCrafting(zweihander);
			if (TinkersCompendium.config.tools.enableShears)
				TinkerRegistry.registerToolCrafting(shears);
			if (TinkersCompendium.config.tools.enableFishingRod)
				TinkerRegistry.registerToolCrafting(fishingRod);
			if (TinkersCompendium.config.tools.enableMallet)
				TinkerRegistry.registerToolCrafting(mallet);
			if (TinkersCompendium.config.tools.enableSaw)
				TinkerRegistry.registerToolCrafting(saw);
			if (TinkersCompendium.config.tools.enableFireDrill)
				TinkerRegistry.registerToolCrafting(fireDrill);
			if (TinkersCompendium.config.tools.enableBackpack)
				TinkerRegistry.registerToolCrafting(backpack);
		}

		if (TinkersCompendium.config.armor.enableClothArmor) {
			TCRegistry.registerArmorCrafting(hood);
			TCRegistry.registerArmorCrafting(shawl);
			TCRegistry.registerArmorCrafting(robe);
			TCRegistry.registerArmorCrafting(shoes);
		}

		if (TinkersCompendium.config.armor.enableChainArmor) {
			TCRegistry.registerArmorCrafting(coif);
			TCRegistry.registerArmorCrafting(hauberk);
			TCRegistry.registerArmorCrafting(chausses);
			TCRegistry.registerArmorCrafting(boots);
		}

		if (TinkersCompendium.config.armor.enableHeavyArmor) {
			TCRegistry.registerArmorCrafting(helm);
			TCRegistry.registerArmorCrafting(breastplate);
			TCRegistry.registerArmorCrafting(grieves);
			TCRegistry.registerArmorCrafting(sabatons);
		}

		if (TinkersCompendium.config.baubles.enableBaubles) {
			if (TinkersCompendium.config.baubles.enableTabard) {
				TinkerRegistry.registerToolCrafting(tabard);
			}
			if (TinkersCompendium.config.baubles.enableRing) {
				TinkerRegistry.registerToolCrafting(ring);
			}
		}

		// TinkerRegistry.registerToolCrafting(sheathe);
		// TinkerRegistry.registerToolCrafting(ring);
		// TinkerRegistry.registerToolCrafting(amulet);
	}

	private void regRecipies() {

	}

	// POST-INITIALIZATION
	@Subscribe
	public void postInit(FMLPostInitializationEvent event) {
		// proxy.postInit();

		MinecraftForge.EVENT_BUS.register(events);

		regTools();
		registerModifiers();
	}
}
