package lance5057.tDefense.proxy;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TD_Commands;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.blocks.ColoredBlockMapper;
import lance5057.tDefense.core.library.ArmorBuildGuiInfo;
import lance5057.tDefense.core.library.ArmorPart;
import lance5057.tDefense.core.library.CustomArmorTextureCreator;
import lance5057.tDefense.core.library.TDClientRegistry;
import lance5057.tDefense.core.library.TDModelLoader;
import lance5057.tDefense.core.library.TDModelRegistar;
import lance5057.tDefense.core.tools.TDTools;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.renderers.deserializers.AlphaColorTextureDeserializer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.client.material.MaterialRenderInfoLoader;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;

//@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ClientProxy extends CommonProxy {
	// static final ToolModelLoader toolmodel = new ToolModelLoader();
	// public static final ModelSheath sheath = new ModelSheath();
	// ModifierSoulHandler SoulHandler;

	// public static ModelTinkersTabard sheath;

	private static final TDModelLoader loader = new TDModelLoader();

	ToolBuildGuiInfo roundshieldGUI;
	ToolBuildGuiInfo heatershieldGUI;
	ToolBuildGuiInfo towershieldGUI;

	ToolBuildGuiInfo zweihanderGUI;
	ToolBuildGuiInfo shearsGUI;
	ToolBuildGuiInfo fishingRodGUI;

	ArmorBuildGuiInfo hoodGUI;
	ArmorBuildGuiInfo shawlGUI;
	ArmorBuildGuiInfo robeGUI;
	ArmorBuildGuiInfo shoesGUI;

	ArmorBuildGuiInfo coifGUI;
	ArmorBuildGuiInfo hauberkGUI;
	ArmorBuildGuiInfo chaussesGUI;
	// ToolBuildGuiInfo bootsGUI;

	ArmorBuildGuiInfo helmGUI;
	ArmorBuildGuiInfo breastplateGUI;
	ArmorBuildGuiInfo grievesGUI;
	ArmorBuildGuiInfo sabatonsGUI;

	ToolBuildGuiInfo sheatheGUI;
	// ToolBuildGuiInfo ringGUI;
	// ToolBuildGuiInfo amuletGUI;

	// public static SheatheModel sheathe;

	@Override
	public void preInit() {
		ClientCommandHandler.instance.registerCommand(new TD_Commands());
		ModelLoaderRegistry.registerLoader(loader);
		MaterialRenderInfoLoader.addRenderInfo("alpha_color", AlphaColorTextureDeserializer.class);

		MinecraftForge.EVENT_BUS.register(CustomArmorTextureCreator.INSTANCE);

		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/hood/_hood_cloth"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/hood/_hood_trim"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/hood/_hood_metal"));

		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/shawl/_shawl_cloth"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/shawl/_shawl_trim"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/shawl/_shawl_metal"));

		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/robe/_robe_cloth"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/robe/_robe_trim"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/robe/_robe_metal"));

		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/shoes/_shoes_cloth"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/shoes/_shoes_trim"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/shoes/_shoes_metal"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/shoes/_shoes_string"));

		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/helm/_helm_chain"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/helm/_helm_plate"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/helm/_helm_top"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/helm/_helm_trim"));
		CustomArmorTextureCreator.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/helm/_helm_cloth"));

		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/breastplate/_breastplate_chain"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/breastplate/_breastplate_plate"));
		CustomArmorTextureCreator.registerTexture(
				new ResourceLocation(Reference.MOD_ID, "armor/breastplate/_breastplate_smallplate"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/breastplate/_breastplate_trim"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/breastplate/_breastplate_cloth"));

		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/grieves/_grieves_chain"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/grieves/_grieves_plate"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/grieves/_grieves_cloth"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/grieves/_grieves_trim"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/grieves/_grieves_clasp"));

		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/sabatons/_sabatons_caps"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/sabatons/_sabatons_plates"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/sabatons/_sabatons_soles"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/sabatons/_sabatons_trim"));
		CustomArmorTextureCreator
				.registerTexture(new ResourceLocation(Reference.MOD_ID, "armor/sabatons/_sabatons_rivets"));
	}

	@Override
	public void init() {

		createToolGuis();
		setToolGuis();
		registerToolGuis();
		createToolModels();
	}

	@Override
	public void postInit() {
//		registerItemColorHandler(new ColorHandler(0xa470e0), TDMaterials.aeonsteelIngot);
//		registerItemColorHandler(new ColorHandler(0xa470e0), TDMaterials.aeonsteelNugget);
//		registerItemColorHandler(new ColorHandler(0xa470e0), TDMaterials.aeonsteelDust);
//		registerItemColorHandler(new ColorHandler(0xa470e0), TDMaterials.aeonsteelGrain);
//		registerItemColorHandler(new ColorHandler(0xa470e0), TDMaterials.aeonsteelCoin);
//		registerItemColorHandler(new ColorHandler(0xa470e0), TDMaterials.aeonsteelGear);
//		registerItemColorHandler(new ColorHandler(0xa470e0), TDMaterials.aeonsteelPlate);
//		registerItemColorHandler(new ColorHandler(0xa470e0), TDMaterials.aeonsteelRod);
		
		//TDMaterials.queensgold.setupClient();

		TinkersDefense.tab.setDisplayIcon(TDTools.heatershield.buildItemForRendering(
				ImmutableList.of(TinkerRegistry.getMaterial("iron"), TinkerRegistry.getMaterial("cobalt"),
						TinkerRegistry.getMaterial("cobalt"), TinkerRegistry.getMaterial("iron"))));
	}

	@Override
	public void registerFluidModels(Fluid fluid) {
		if (fluid == null)
			return;
		Block block = fluid.getBlock();
		if (block != null) {
			Item item = Item.getItemFromBlock(block);
			FluidStateMapper mapper = new FluidStateMapper(fluid);
			if (item != null) {
				ModelBakery.registerItemVariants(item);
				ModelLoader.setCustomMeshDefinition(item, mapper);
			}
			ModelLoader.setCustomStateMapper(block, mapper);
		}
	}

	@Override
	public void registerToolModel(ToolCore tool) {
		ModelRegisterUtil.registerToolModel(tool);
	}

	@Override
	public void registerArmorModel(ArmorCore tool) {
		TDModelRegistar.registerToolModel(tool);
	}

	@Override
	public void registerPartModel(ToolPart part) {
		ModelRegisterUtil.registerPartModel(part);
	}

	@Override
	public void registerArmorPartModel(ArmorPart part) {
		ModelRegisterUtil.registerPartModel(part);
	}

	@Override
	public void registerMatColor(Material mat, int color) {
		mat.setRenderInfo(color);
	}

	public void createToolGuis() {
		roundshieldGUI = new ToolBuildGuiInfo(TDTools.roundshield);
		heatershieldGUI = new ToolBuildGuiInfo(TDTools.heatershield);
		towershieldGUI = new ToolBuildGuiInfo(TDTools.towershield);
		zweihanderGUI = new ToolBuildGuiInfo(TDTools.zweihander);
		shearsGUI = new ToolBuildGuiInfo(TDTools.shears);
		fishingRodGUI = new ToolBuildGuiInfo(TDTools.fishingRod);

		hoodGUI = new ArmorBuildGuiInfo(TDTools.hood);
		shawlGUI = new ArmorBuildGuiInfo(TDTools.shawl);
		robeGUI = new ArmorBuildGuiInfo(TDTools.robe);
		shoesGUI = new ArmorBuildGuiInfo(TDTools.shoes);

		// bootsGUI = new ToolBuildGuiInfo(TDTools.boots);

		helmGUI = new ArmorBuildGuiInfo(TDTools.helm);
		breastplateGUI = new ArmorBuildGuiInfo(TDTools.breastplate);
		grievesGUI = new ArmorBuildGuiInfo(TDTools.grieves);
		sabatonsGUI = new ArmorBuildGuiInfo(TDTools.sabatons);

		sheatheGUI = new ToolBuildGuiInfo(TDTools.sheathe);
		// ringGUI = new ToolBuildGuiInfo(TDTools.ring);
		// amuletGUI = new ToolBuildGuiInfo(TDTools.amulet);

	}

	public void setupToolGuis() {

	}

	public void registerToolGuis() {
		TinkerRegistryClient.addToolBuilding(roundshieldGUI);
		TinkerRegistryClient.addToolBuilding(heatershieldGUI);
		TinkerRegistryClient.addToolBuilding(towershieldGUI);
		TinkerRegistryClient.addToolBuilding(zweihanderGUI);
		TinkerRegistryClient.addToolBuilding(shearsGUI);
		TinkerRegistryClient.addToolBuilding(fishingRodGUI);

		TDClientRegistry.addArmorBuilding(hoodGUI);
		TDClientRegistry.addArmorBuilding(shawlGUI);
		TDClientRegistry.addArmorBuilding(robeGUI);
		TDClientRegistry.addArmorBuilding(shoesGUI);

		// TinkerRegistryClient.addToolBuilding(bootsGUI);

		TinkerRegistryClient.addToolBuilding(sheatheGUI);
		// TinkerRegistryClient.addToolBuilding(ringGUI);
		// TinkerRegistryClient.addToolBuilding(amuletGUI);
		//
		TDClientRegistry.addArmorBuilding(helmGUI);
		TDClientRegistry.addArmorBuilding(breastplateGUI);
		TDClientRegistry.addArmorBuilding(grievesGUI);
		TDClientRegistry.addArmorBuilding(sabatonsGUI);
	}

	@Override
	public void reloadRenderers() {
		setToolGuis();
	}

	public void setToolGuis() {
		roundshieldGUI.positions.clear();
		roundshieldGUI.addSlotPosition(34, 15);
		roundshieldGUI.addSlotPosition(34, 33);
		roundshieldGUI.addSlotPosition(34, 51);

		heatershieldGUI.positions.clear();
		heatershieldGUI.addSlotPosition(34, 15);
		heatershieldGUI.addSlotPosition(25, 33);
		heatershieldGUI.addSlotPosition(43, 33);
		heatershieldGUI.addSlotPosition(34, 51);

		towershieldGUI.positions.clear();
		towershieldGUI.addSlotPosition(34, 15);
		towershieldGUI.addSlotPosition(25, 33);
		towershieldGUI.addSlotPosition(43, 33);
		towershieldGUI.addSlotPosition(34, 51);

		zweihanderGUI.positions.clear();
		zweihanderGUI.addSlotPosition(34, 15);
		zweihanderGUI.addSlotPosition(25, 33);
		zweihanderGUI.addSlotPosition(43, 33);
		zweihanderGUI.addSlotPosition(34, 51);

		hoodGUI.positions.clear();
		hoodGUI.addSlotPosition(34, 15 + 8);
		hoodGUI.addSlotPosition(43, 33 + 8);
		hoodGUI.addSlotPosition(34, 51 + 8);

		shawlGUI.positions.clear();
		shawlGUI.addSlotPosition(34, 15 + 8);
		shawlGUI.addSlotPosition(43, 33 + 8);
		shawlGUI.addSlotPosition(34, 51 + 8);

		robeGUI.positions.clear();
		robeGUI.addSlotPosition(34, 15 + 8);
		robeGUI.addSlotPosition(43, 33 + 8);
		robeGUI.addSlotPosition(34, 51 + 8);

		shoesGUI.positions.clear();
		shoesGUI.addSlotPosition(34, 15 + 8);
		shoesGUI.addSlotPosition(25, 33 + 8);
		shoesGUI.addSlotPosition(43, 51 + 8);
		shoesGUI.addSlotPosition(34, 51 + 8);

		// bootsGUI.positions.clear();
		// bootsGUI.addSlotPosition(34, 15 + 8);
		// bootsGUI.addSlotPosition(43, 33 + 8);
		// bootsGUI.addSlotPosition(34, 51 + 8);

		breastplateGUI.positions.clear();
		breastplateGUI.addSlotPosition(34, 15 + 8);
		breastplateGUI.addSlotPosition(43, 33 + 8);
		breastplateGUI.addSlotPosition(34, 51 + 8);
		breastplateGUI.addSlotPosition(43, 51 + 8);
		breastplateGUI.addSlotPosition(43, 51 + 8);

		helmGUI.positions.clear();
		helmGUI.addSlotPosition(34, 15 + 8);
		helmGUI.addSlotPosition(43, 33 + 8);
		helmGUI.addSlotPosition(34, 51 + 8);
		helmGUI.addSlotPosition(43, 51 + 8);
		helmGUI.addSlotPosition(43, 51 + 8);

		sabatonsGUI.positions.clear();
		sabatonsGUI.addSlotPosition(34, 15 + 8);
		sabatonsGUI.addSlotPosition(43, 33 + 8);
		sabatonsGUI.addSlotPosition(34, 51 + 8);
		sabatonsGUI.addSlotPosition(43, 51 + 8);
		sabatonsGUI.addSlotPosition(43, 51 + 8);

		grievesGUI.positions.clear();
		grievesGUI.addSlotPosition(34, 15 + 8);
		grievesGUI.addSlotPosition(43, 33 + 8);
		grievesGUI.addSlotPosition(34, 51 + 8);
		grievesGUI.addSlotPosition(43, 51 + 8);
		grievesGUI.addSlotPosition(43, 51 + 8);

		shearsGUI.positions.clear();
		shearsGUI.addSlotPosition(34, 15 + 8);
		shearsGUI.addSlotPosition(43, 33 + 8);
		shearsGUI.addSlotPosition(34, 51 + 8);

		fishingRodGUI.positions.clear();
		fishingRodGUI.addSlotPosition(34, 15 + 8);
		fishingRodGUI.addSlotPosition(43, 33 + 8);
		fishingRodGUI.addSlotPosition(34, 51 + 8);

		sheatheGUI.positions.clear();
		sheatheGUI.addSlotPosition(34, 15);
		sheatheGUI.addSlotPosition(34, 33);
		sheatheGUI.addSlotPosition(34, 51);
		//
		// ringGUI.positions.clear();
		// ringGUI.addSlotPosition(34, 15);
		// ringGUI.addSlotPosition(34, 33);
		// ringGUI.addSlotPosition(34, 51);
		//
		// amuletGUI.positions.clear();
		// amuletGUI.addSlotPosition(34, 15);
		// amuletGUI.addSlotPosition(34, 33);
		// amuletGUI.addSlotPosition(34, 51);
	}

	void createToolModels() {
		// sheathe = new SheatheModel();
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
	}

	@Override
	public void registerItemBlockRenderer(Block block, int meta, String file) {
		Item b = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(b, meta,
				new ModelResourceLocation(Reference.MOD_ID + ":" + file, "inventory"));
	}
	
	@Override 
	public void registerBlockRenderer(Block block, String file) {
		ModelLoader.setCustomStateMapper(block, new ColoredBlockMapper(file));
	}

	@Override
	public void registerItemColorHandler(int c, Item i) {
		ItemColors itemcolors = Minecraft.getMinecraft().getItemColors();
		itemcolors.registerItemColorHandler(new ItemColorHandler(c), i);
	}
	
	@Override
	public void registerBlockColorHandler(int c, Block i) { 
		BlockColors blockcolors = Minecraft.getMinecraft().getBlockColors();
		blockcolors.registerBlockColorHandler(new BlockColorHandler(c), i);
	}

	public static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {

		public final Fluid fluid;
		public final ModelResourceLocation location;

		public FluidStateMapper(Fluid fluid) {
			this.fluid = fluid;

			// have each block hold its fluid per nbt? hm
			this.location = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "fluid_block"),
					fluid.getName());
		}

		@Nonnull
		@Override
		protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
			return location;
		}

		@Nonnull
		@Override
		public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
			return location;
		}
	}

	@SideOnly(Side.CLIENT)
	public static class ItemColorHandler implements IItemColor {
		public ItemColorHandler(int color) {
			this.color = color;
		}

		int color;
		
		@Override
		public int colorMultiplier(ItemStack stack, int tintIndex) {
			if (tintIndex == 0) {
				return color;
			}
			return 0xFFFFFF;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static class BlockColorHandler implements IBlockColor {
		public BlockColorHandler(int color) {
			this.color = color;
		}

		int color;

		@Override
		public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
			if (tintIndex == 0) {
				return color;
			}
			return 0xFFFFFF;
		}
	}
}
