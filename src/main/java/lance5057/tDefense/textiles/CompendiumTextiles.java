package lance5057.tDefense.textiles;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.textiles.items.ItemColors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.mantle.client.CreativeTab;

public class CompendiumTextiles {

	public static CreativeTab tab = new CreativeTab("compendiumtextiles", new ItemStack(Items.STRING));

	public Item grassFiber;
	public Item roughspunCord;
	public ItemBlock roughspunItemBlock;
	public Block roughspunBlock;

	public ItemColors cottonYarn;
	public ItemBlock cottonItemBlock;
	public BlockColored cottonBlock;

	public ItemColors linenThread;
	public BlockColored linenBlock;

	public ItemColors silkThread;
	public BlockColored silkBlock;

	public ItemColors ramieCord;
	public BlockColored ramieBlock;

	public void preInit() {
		grassFiber = new Item();
		setupItem(grassFiber, "grassfiber");

		roughspunCord = new Item();
		setupItem(roughspunCord, "roughspuncord");

		roughspunBlock = new Block(Material.CLOTH);
		setupBlock(this.roughspunBlock, "roughspunblock");

		roughspunItemBlock = new ItemBlock(roughspunBlock);
		setupItem(roughspunItemBlock, "roughspunitemblock");

		cottonYarn = new ItemColors();
		setupItem(cottonYarn, "cottonyarn");

		cottonBlock = new BlockColored(Material.CLOTH);
		setupBlock(cottonBlock, "cotton");

		cottonItemBlock = new ItemCloth(cottonBlock);
		setupItem(cottonItemBlock, "cottonitemblock");
	}

	public void init() {

	}

	public void postInit() {

	}

	public void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> register = event.getRegistry();

		register.register(grassFiber);
		register.register(this.roughspunCord);
		register.register(roughspunItemBlock);
		register.register(cottonYarn);
		register.register(this.cottonItemBlock);

		TinkersCompendium.proxy.registerItemRenderer(grassFiber, 0, "grassfiber");
		TinkersCompendium.proxy.registerItemRenderer(roughspunCord, 0, "roughspuncord");
		TinkersCompendium.proxy.registerItemRenderer(roughspunItemBlock, 0, "roughspunblock");

		for (int i = 0; i < 16; i++) {
			TinkersCompendium.proxy.registerItemRenderer(cottonYarn, i, "cottonyarn");
			TinkersCompendium.proxy.registerItemRenderer(cottonItemBlock, i, "cottonblock");
		}
	}

	public void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> register = event.getRegistry();

		register.register(roughspunBlock);
		register.register(this.cottonBlock);

		// TinkersCompendium.proxy.registerBlockRenderer(roughspunBlock,
		// "roughspunblock");
		// TinkersCompendium.proxy.registerBlockRenderer(cottonBlock, "cottonblock");
	}

	void setupItem(Item i, String name) {
		i.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setCreativeTab(tab);
	}

	void setupBlock(Block b, String name) {
		b.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Reference.MOD_ID, name)).setCreativeTab(tab);
	}
}
