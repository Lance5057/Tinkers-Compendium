package lance5057.tDefense.proxy;

import javax.annotation.Nonnull;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TD_Commands;
import lance5057.tDefense.baubles.BaublesClientProxy;
import lance5057.tDefense.core.CoreBlocks;
import lance5057.tDefense.core.CoreClientProxy;
import lance5057.tDefense.core.CoreItems;
import lance5057.tDefense.core.blocks.TDMetalBlock;
import lance5057.tDefense.core.tools.TDTools;
import lance5057.tDefense.holiday.HolidayClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;

//import lance5057.tDefense.core.renderer.TestSkinChanger;

public class ClientProxy extends CommonProxy {
	// static final ToolModelLoader toolmodel = new ToolModelLoader();
	// public static final ModelSheath sheath = new ModelSheath();
	// ModifierSoulHandler SoulHandler;

	// public static ModelTinkersTabard sheath;

	public static BaublesClientProxy baubles = new BaublesClientProxy();

	ToolBuildGuiInfo roundshieldGUI;
	ToolBuildGuiInfo heatershieldGUI;

	ToolBuildGuiInfo zweihanderGUI;
	ToolBuildGuiInfo shearsGUI;
	ToolBuildGuiInfo fishingRodGUI;

	ToolBuildGuiInfo hoodGUI;
	ToolBuildGuiInfo shawlGUI;
	ToolBuildGuiInfo robeGUI;
	ToolBuildGuiInfo shoesGUI;

	ToolBuildGuiInfo coifGUI;
	ToolBuildGuiInfo hauberkGUI;
	ToolBuildGuiInfo chaussesGUI;
	ToolBuildGuiInfo bootsGUI;

	ToolBuildGuiInfo helmGUI;
	ToolBuildGuiInfo breastplateGUI;
	ToolBuildGuiInfo grievesGUI;
	ToolBuildGuiInfo sabatonsGUI;

	public static CoreClientProxy coreProxy = new CoreClientProxy();
	public static HolidayClientProxy holiProxy = new HolidayClientProxy();
	// public static ArmorClientProxy armorProxy = new ArmorClientProxy();

	@Override
	public void preInit() {
		ClientCommandHandler.instance.registerCommand(new TD_Commands());
		registerToolRenderers();

		coreProxy.preInit();
		// armorProxy.preInit();
		baubles.preInit();
	}

	@Override
	public void init() {
		// Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		// .register(TDTools.heatershield, 0, new
		// ModelResourceLocation("modid:itemname", "inventory"));
		//

		createToolGuis();
		setToolGuis();
		registerToolGuis();
		
		registerItemRenderer(CoreBlocks.metalItemBlock, TDMetalBlock.EnumMetal.AEONSTEEL.getID(), "aeonsteelblock");
		registerItemRenderer(CoreBlocks.metalItemBlock, TDMetalBlock.EnumMetal.QUEENSGOLD.getID(), "queensgoldblock");
		registerItemRenderer(CoreBlocks.metalItemBlock, TDMetalBlock.EnumMetal.DOGBEARIUM.getID(), "dogbeariumblock");

		registerItemRenderer(CoreItems.item_aeonsteelIngot, 0, CoreItems.item_aeonsteelIngot.getUnlocalizedName());
		registerItemRenderer(CoreItems.item_dogbeariumIngot, 0, CoreItems.item_dogbeariumIngot.getUnlocalizedName());
		registerItemRenderer(CoreItems.item_queensgoldIngot, 0, CoreItems.item_queensgoldIngot.getUnlocalizedName());

		coreProxy.init();
		// armorProxy.init();
		holiProxy.Init();
		baubles.init();
	}

	public void registerToolRenderers() {
		ModelRegisterUtil.registerToolModel(TDTools.roundshield);
		ModelRegisterUtil.registerToolModel(TDTools.heatershield);
		ModelRegisterUtil.registerToolModel(TDTools.zweihander);
		ModelRegisterUtil.registerToolModel(TDTools.shears);
		ModelRegisterUtil.registerToolModel(TDTools.fishingRod);

		ModelRegisterUtil.registerToolModel(TDTools.hood);
		ModelRegisterUtil.registerToolModel(TDTools.shawl);
		ModelRegisterUtil.registerToolModel(TDTools.robe);
		ModelRegisterUtil.registerToolModel(TDTools.shoes);

	}

	public void createToolGuis() {
		roundshieldGUI = new ToolBuildGuiInfo(TDTools.roundshield);
		heatershieldGUI = new ToolBuildGuiInfo(TDTools.heatershield);
		zweihanderGUI = new ToolBuildGuiInfo(TDTools.zweihander);
		shearsGUI = new ToolBuildGuiInfo(TDTools.shears);
		fishingRodGUI = new ToolBuildGuiInfo(TDTools.fishingRod);

		hoodGUI = new ToolBuildGuiInfo(TDTools.hood);
		shawlGUI = new ToolBuildGuiInfo(TDTools.shawl);
		robeGUI = new ToolBuildGuiInfo(TDTools.robe);
		shoesGUI = new ToolBuildGuiInfo(TDTools.shoes);
	}

	public void setupToolGuis() {
		roundshieldGUI.addSlotPosition(34, 15 + 8);
		roundshieldGUI.addSlotPosition(34, 33 + 8);
		roundshieldGUI.addSlotPosition(34, 51 + 8);

		heatershieldGUI.addSlotPosition(34, 15 + 8);
		heatershieldGUI.addSlotPosition(25, 33 + 8);
		heatershieldGUI.addSlotPosition(43, 33 + 8);
		heatershieldGUI.addSlotPosition(34, 51 + 8);

		zweihanderGUI.addSlotPosition(34, 15 + 8);
		zweihanderGUI.addSlotPosition(25, 33 + 8);
		zweihanderGUI.addSlotPosition(43, 33 + 8);
		zweihanderGUI.addSlotPosition(34, 51 + 8);

		hoodGUI.addSlotPosition(34, 15 + 8);
		hoodGUI.addSlotPosition(43, 33 + 8);
		hoodGUI.addSlotPosition(34, 51 + 8);

		shawlGUI.addSlotPosition(34, 15 + 8);
		shawlGUI.addSlotPosition(43, 33 + 8);
		shawlGUI.addSlotPosition(34, 51 + 8);

		robeGUI.addSlotPosition(34, 15 + 8);
		robeGUI.addSlotPosition(43, 33 + 8);
		robeGUI.addSlotPosition(34, 51 + 8);

		shoesGUI.addSlotPosition(34, 15 + 8);
		shoesGUI.addSlotPosition(43, 33 + 8);
		shoesGUI.addSlotPosition(34, 51 + 8);

		shearsGUI.addSlotPosition(34, 15 + 8);
		shearsGUI.addSlotPosition(43, 33 + 8);
		shearsGUI.addSlotPosition(34, 51 + 8);
	}

	public void registerToolGuis() {
		TinkerRegistryClient.addToolBuilding(roundshieldGUI);
		TinkerRegistryClient.addToolBuilding(heatershieldGUI);
		TinkerRegistryClient.addToolBuilding(zweihanderGUI);
		TinkerRegistryClient.addToolBuilding(shearsGUI);
		TinkerRegistryClient.addToolBuilding(fishingRodGUI);

		TinkerRegistryClient.addToolBuilding(hoodGUI);
		TinkerRegistryClient.addToolBuilding(shawlGUI);
		TinkerRegistryClient.addToolBuilding(robeGUI);
		TinkerRegistryClient.addToolBuilding(shoesGUI);

	}

	@Override
	public void reloadRenderers() {
		setToolGuis();

		baubles.reloadRenderers();
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
		shoesGUI.addSlotPosition(43, 33 + 8);
		shoesGUI.addSlotPosition(34, 51 + 8);

		shearsGUI.positions.clear();
		shearsGUI.addSlotPosition(34, 15 + 8);
		shearsGUI.addSlotPosition(43, 33 + 8);
		shearsGUI.addSlotPosition(34, 51 + 8);

		fishingRodGUI.positions.clear();
		fishingRodGUI.addSlotPosition(34, 15 + 8);
		fishingRodGUI.addSlotPosition(43, 33 + 8);
		fishingRodGUI.addSlotPosition(34, 51 + 8);
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
	}

	@Override
	public void registerFluidModels(Fluid fluid) {
		if (fluid == null) {
			return;
		}

		Block block = fluid.getBlock();
		if (block != null) {
			Item item = Item.getItemFromBlock(block);
			FluidStateMapper mapper = new FluidStateMapper(fluid);

			// item-model
			if (item != null) {
				ModelLoader.registerItemVariants(item);
				ModelLoader.setCustomMeshDefinition(item, mapper);
			}
			// block-model
			ModelLoader.setCustomStateMapper(block, mapper);
		}
	}
	
	@Override
	public void registerItemBlockRenderer(Block block, int meta, String file) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MOD_ID + ":" + file, "inventory"));
	}
	

    public static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {

        public final Fluid fluid;
        public final ModelResourceLocation location;

        public FluidStateMapper(Fluid fluid) {
            this.fluid = fluid;

            // have each block hold its fluid per nbt? hm
            this.location = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "fluid_block"), fluid.getName());
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
}
