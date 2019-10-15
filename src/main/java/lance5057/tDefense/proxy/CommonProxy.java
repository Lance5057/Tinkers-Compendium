package lance5057.tDefense.proxy;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.items.ItemCompendiumBook;
import lance5057.tDefense.core.library.ArmorPart;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.core.workstations.CompendiumWorkstations;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CommonProxy implements IGuiHandler {
	// public static ModifierSoulHandler SoulHandler = null;
	public static Item book;
	
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
	
	public void registerModifierModel(Modifier mod) {

	}

	public void registerPartModel(ToolPart part) {

	}

	public void registerMatColor(Material mat, int color) {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return CompendiumWorkstations.getServerGuiElement(ID, player, world, x, y, z);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return CompendiumWorkstations.getClientGuiElement(ID, player, world, x, y, z);
	}

	public void registerItemRenderer(Item item, int meta, String id) {

	}

	public void registerFluidModels(Fluid fluid) {

	}

	public void registerItemBlockRenderer(Block block, int meta, String file) {

	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		book = registerItem(event, new ItemCompendiumBook(), "book");
		
		TinkersCompendium.parts.registerItems(event);
		TinkersCompendium.mats.registerItems(event);
		TinkersCompendium.tools.registerItems(event);
		TinkersCompendium.modifiers.registerItems(event);
		TinkersCompendium.workstations.registerItems(event);
		TinkersCompendium.textiles.registerItems(event);
		
		if(TinkersCompendium.bloodmagic != null)
			TinkersCompendium.bloodmagic.registerItems(event);
		if(TinkersCompendium.botania != null)
			TinkersCompendium.botania.registerItems(event);
	}

	private static Item registerItem(Register<Item> event, Item item, String string) {
		item.setUnlocalizedName(string).setRegistryName(Reference.MOD_ID, string);
		event.getRegistry().register(item);
		return item;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		TinkersCompendium.mats.registerBlocks(event);
		TinkersCompendium.tools.registerBlocks(event);
		TinkersCompendium.modifiers.registerBlocks(event);
		TinkersCompendium.workstations.registerBlocks(event);
		TinkersCompendium.textiles.registerBlocks(event);
		
		if(TinkersCompendium.bloodmagic != null)
			TinkersCompendium.bloodmagic.registerBlocks(event);
		if(TinkersCompendium.botania != null)
			TinkersCompendium.botania.registerBlocks(event);
	}

	public void registerArmorPartModel(ArmorPart part) {
		// TODO Auto-generated method stub

	}
	
	public void registerItemColorHandler(int c, Item i) {
		
	}

	public void registerBlockColorHandler(int c, Block i) {
		// TODO Auto-generated method stub
		
	}

	public void registerBlockRenderer(Block block, String file) {
		// TODO Auto-generated method stub
		
	}
}
