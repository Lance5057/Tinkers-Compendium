package lance5057.tDefense.proxy;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.library.ArmorPart;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.proxy.ClientProxy.ColorHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CommonProxy implements IGuiHandler {
	// public static ModifierSoulHandler SoulHandler = null;

	public void preInit() {
	}

	public void init() {

	}

	public void registerTileEntitySpecialRenderer() {

	}

	public void reloadRenderers() {

	}

	public void postInit() {
		// TODO Auto-generated method stub

	}

	public void registerToolModel(ToolCore tool) {

	}

	public void registerArmorModel(ArmorCore tool) {

	}

	public void registerPartModel(ToolPart part) {

	}

	public void registerMatColor(Material mat, int color) {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// if(ID == TinkersDefense.GUI_CREST_INV)
		// return new Container_CrestMount(player.inventory,
		// (TileEntity_CrestMount) world.getTileEntity(new BlockPos(x, y, z)));
		// if(ID == TinkersDefense.GUI_ANVIL_INV)
		// return new Container_FinishingAnvil(player.inventory,
		// (TileEntity_FinishingAnvil) world.getTileEntity(x, y, z));

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// if(ID == TinkersDefense.GUI_CREST_INV)
		// return new Gui_CrestMount(player.inventory,
		// (TileEntity_CrestMount) world.getTileEntity(new BlockPos(x, y, z)));
		// if(ID == TinkersDefense.GUI_ANVIL_INV)
		// return new Gui_FinishingAnvil(player.inventory,
		// (TileEntity_FinishingAnvil) world.getTileEntity(x, y, z));
		return null;
	}

	public void registerItemRenderer(Item item, int meta, String id) {

	}

	public void registerFluidModels(Fluid fluid) {

	}

	public void registerItemBlockRenderer(Block block, int meta, String file) {

	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {

		TinkersDefense.parts.registerItems(event);
		TinkersDefense.mats.registerItems(event);
		TinkersDefense.tools.registerItems(event);
		TinkersDefense.modifiers.registerItems(event);
		TinkersDefense.holiday.registerItems(event);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		TinkersDefense.mats.registerBlocks(event);
		TinkersDefense.tools.registerBlocks(event);

	}

	public void registerArmorPartModel(ArmorPart part) {
		// TODO Auto-generated method stub

	}

	public void registerItemColorHandler(IItemColor c, Item i) {
		// TODO Auto-generated method stub

	}
}
