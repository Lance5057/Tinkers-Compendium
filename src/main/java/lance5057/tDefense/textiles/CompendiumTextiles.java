package lance5057.tDefense.textiles;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TCBlocks;
import lance5057.tDefense.TCItems;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.blocks.BlockStairLike;
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
import slimeknights.mantle.block.BlockStairsBase;
import slimeknights.mantle.client.CreativeTab;

public class CompendiumTextiles {

	public static CreativeTab tab = new CreativeTab("compendiumtextiles", new ItemStack(Items.STRING));

	public TextileEvents events = new TextileEvents();

	public static Item grassFiber;
	public static Item roughspunCord;
	public static Item roughspunItemBlock;
	public static Item roughspunItemRoof;
	public static Block roughspunBlock;
	public static BlockStairLike roughspunRoof;

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
	public static ItemBlock silkItemBlock;

	public static ItemColors ramieCord;
	public static BlockColored ramieBlock;

	public void preInit() {
		grassFiber = TCItems.registerItem("grassfiber", TinkersCompendium.tab);

		roughspunCord = TCItems.registerItem("roughspuncord", TinkersCompendium.tab);

		roughspunBlock = TCBlocks.registerBlock("roughspunblock", Material.CLOTH);

		roughspunItemBlock = TCItems.registerItemBlock("roughspunitemblock", roughspunBlock, TinkersCompendium.tab);

		roughspunRoof = new BlockStairLike(Material.CLOTH);
		TCBlocks.registerBlock(this.roughspunRoof, "roughspunblockroof");

		this.roughspunItemRoof = TCItems.registerItemBlock("roughspunitemblockroof", roughspunRoof,
				TinkersCompendium.tab);

		cotton = new ItemCotton();
		TCItems.registerItem("cotton", cotton, TinkersCompendium.tab);

		cottonCrop = new BlockCottonCrop();
		TCBlocks.registerBlock(cottonCrop, "cottonCrop");

		cottonSeed = new ItemSeeds(cottonCrop, Blocks.FARMLAND);
		TCItems.registerItem("cottonseed", cottonSeed, TinkersCompendium.tab);

		cottonYarn = new ItemColors();
		TCItems.registerItem("cottonyarn", cottonYarn, TinkersCompendium.tab);

		cottonBlock = new BlockColored(Material.CLOTH);
		TCBlocks.registerBlock(cottonBlock, "cottonblock");

		cottonItemBlock = new ItemCloth(cottonBlock);
		TCItems.registerItem("cottonitemblock", cottonItemBlock, TinkersCompendium.tab);

		silkThread = new ItemColors();
		TCItems.registerItem("silkyarn", silkThread, TinkersCompendium.tab);

		silkBlock = new BlockColored(Material.CLOTH);
		TCBlocks.registerBlock(silkBlock, "silkblock");

		silkItemBlock = new ItemCloth(silkBlock);
		TCItems.registerItem("silkitemblock", silkItemBlock, TinkersCompendium.tab);
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
		register.register(roughspunItemRoof);

		register.register(cotton);
		register.register(cottonSeed);
		register.register(cottonYarn);
		register.register(this.cottonItemBlock);

		register.register(silkThread);
		register.register(silkItemBlock);

		TinkersCompendium.proxy.registerItemRenderer(grassFiber, 0, "grassfiber");
		TinkersCompendium.proxy.registerItemRenderer(roughspunCord, 0, "roughspuncord");
		TinkersCompendium.proxy.registerItemRenderer(roughspunItemBlock, 0, "roughspunblock");

		TinkersCompendium.proxy.registerItemRenderer(cottonSeed, 0, "cottonseed");
		TinkersCompendium.proxy.registerItemRenderer(cotton, 0, "cotton");

		for (int i = 0; i < 16; i++) {
			TinkersCompendium.proxy.registerItemRenderer(cottonYarn, i, "cottonyarn_" + EnumDyeColor.byDyeDamage(i));
			TinkersCompendium.proxy.registerItemRenderer(cottonItemBlock, i,
					"cottonblock_" + EnumDyeColor.byMetadata(i));

			TinkersCompendium.proxy.registerItemRenderer(silkThread, i, "silkthread_" + EnumDyeColor.byDyeDamage(i));
			TinkersCompendium.proxy.registerItemRenderer(silkItemBlock, i, "silkblock_" + EnumDyeColor.byMetadata(i));
		}
	}

	public void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> register = event.getRegistry();

		register.register(roughspunBlock);
		register.register(roughspunRoof);
		register.register(this.cottonBlock);
		register.register(this.cottonCrop);
		register.register(silkBlock);

		// TinkersCompendium.proxy.registerBlockRenderer(roughspunBlock,
		// "roughspunblock");
		// TinkersCompendium.proxy.registerBlockRenderer(cottonBlock, "cottonblock");
	}
}
