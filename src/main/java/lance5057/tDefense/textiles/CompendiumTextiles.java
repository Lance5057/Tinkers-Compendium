package lance5057.tDefense.textiles;

import WayofTime.bloodmagic.util.Utils;
import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.textiles.blocks.BlockCottonCrop;
import lance5057.tDefense.textiles.items.ItemColors;
import lance5057.tDefense.textiles.items.ItemCotton;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.mantle.client.CreativeTab;

public class CompendiumTextiles {

	public static CreativeTab tab = new CreativeTab("compendiumtextiles", new ItemStack(Items.STRING));
	
	public TextileEvents events = new TextileEvents();

	public static Item grassFiber;
	public static Item roughspunCord;
	public static ItemBlock roughspunItemBlock;
	public static Block roughspunBlock;

	public static ItemCotton cotton;
	public static ItemSeeds cottonSeed;
	public static ItemColors cottonYarn;
	public static ItemBlock cottonItemBlock;
	public static BlockCottonCrop cottonCrop;
	public static BlockColored cottonBlock;

	public static ItemColors linenThread;
	public static BlockColored linenBlock;

	public static ItemColors silkThread;
	public static BlockColored silkBlock;

	public static ItemColors ramieCord;
	public static BlockColored ramieBlock;

	public void preInit() {
		grassFiber = new Item();
		setupItem(grassFiber, "grassfiber");

		roughspunCord = new Item();
		setupItem(roughspunCord, "roughspuncord");

		roughspunBlock = new Block(Material.CLOTH);
		setupBlock(this.roughspunBlock, "roughspunblock");

		roughspunItemBlock = new ItemBlock(roughspunBlock);
		setupItem(roughspunItemBlock, "roughspunitemblock");

		cotton = new ItemCotton();
		setupItem(cotton, "cotton");
		
		cottonCrop = new BlockCottonCrop();
		setupBlock(cottonCrop, "cottonCrop");
		
		cottonSeed = new ItemSeeds(cottonCrop, Blocks.FARMLAND);
		setupItem(cottonSeed, "cottonseed");
		
		cottonYarn = new ItemColors();
		setupItem(cottonYarn, "cottonyarn");

		cottonBlock = new BlockColored(Material.CLOTH);
		setupBlock(cottonBlock, "cottonblock");

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
		
		register.register(cotton);
		register.register(cottonSeed);
		register.register(cottonYarn);
		register.register(this.cottonItemBlock);

		TinkersCompendium.proxy.registerItemRenderer(grassFiber, 0, "grassfiber");
		TinkersCompendium.proxy.registerItemRenderer(roughspunCord, 0, "roughspuncord");
		TinkersCompendium.proxy.registerItemRenderer(roughspunItemBlock, 0, "roughspunblock");
		
		TinkersCompendium.proxy.registerItemRenderer(cottonSeed, 0, "cottonseed");
		TinkersCompendium.proxy.registerItemRenderer(cotton, 0, "cotton");

		for (int i = 0; i < 16; i++) {
			TinkersCompendium.proxy.registerItemRenderer(cottonYarn, i, "cottonyarn_" + EnumDyeColor.byDyeDamage(i));
			TinkersCompendium.proxy.registerItemRenderer(cottonItemBlock, i, "cottonblock_" + EnumDyeColor.byMetadata(i));
		}
	}

	public void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> register = event.getRegistry();

		register.register(roughspunBlock);
		register.register(this.cottonBlock);
		register.register(this.cottonCrop);

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
