package lance5057.tDefense.core.modifiers;

import java.util.ArrayList;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.blocks.CrackedObsidian;
import lance5057.tDefense.core.parts.TDParts;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.modifiers.ModHarvestSize;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CompendiumModifiers {

	public static Item item_canister;
	public static Item item_emptycanister;
	public static Item item_rebreather;
	public static Item item_eldergills;
	public static Item item_goggles;
	public static Item item_nightvisiongoggles;

	public static Item item_glowsole;
	public static Item item_firesole;
	public static Item item_icesole;
	public static Item item_feathersole;
	public static Item item_flippers;

	public static Block unstable_obsidian;
	public static ItemBlock item_unstable_obsidian;

	public static Modifier deadmansswitch = new ModDeadMansSwitch();
	public static Modifier protection = new ModProtection("protection", 0xe2e2e2, Enchantments.PROTECTION);
	public static Modifier projprotection = new ModProtection("projprotection", 0xffffff,
			Enchantments.PROJECTILE_PROTECTION);
	public static Modifier blastprotection = new ModProtection("blastprotection", 0x0bad00,
			Enchantments.BLAST_PROTECTION);
	public static Modifier fireprotection = new ModProtection("fireprotection", 0xfcb56a, Enchantments.FIRE_PROTECTION);
	public static Modifier autofeed = new ModAutofeed();

	public static Modifier nightvision = new ModNightVision();
	public static Modifier respirationI = new ModRespiration(1);
	public static Modifier respirationII = new ModRespiration(2);
	public static Modifier antiblindness = new ModAntiBlindness();

	public static Modifier frostwalker;
	public static Modifier firewalker;

	public static Modifier clock = new ModClock();
	public static Modifier compass = new ModCompass();
	
	//public static Modifier width2 = new ModHarvestSize("width2");

	static ArrayList<Item> itemList = new ArrayList<Item>();
	static ArrayList<Block> blockList = new ArrayList<Block>();

	public void preInit() {
		blockList.add(unstable_obsidian = new CrackedObsidian()
				.setRegistryName(new ResourceLocation(Reference.MOD_ID, "crackedobsidian"))
				.setUnlocalizedName("crackedobsidian").setCreativeTab(TinkersCompendium.tab));

		itemList.add(item_unstable_obsidian = (ItemBlock) new ItemBlock(unstable_obsidian)
				.setRegistryName(new ResourceLocation(Reference.MOD_ID, "crackedobsidianitemblock"))
				.setUnlocalizedName("crackedobsidianitemblock").setCreativeTab(TinkersCompendium.tab));

		itemList.add(item_canister = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "canister"))
				.setUnlocalizedName("canister").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_emptycanister = new Item()
				.setRegistryName(new ResourceLocation(Reference.MOD_ID, "empty_canister"))
				.setUnlocalizedName("empty_canister").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_rebreather = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "rebreather"))
				.setUnlocalizedName("rebreather").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_eldergills = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "eldergills"))
				.setUnlocalizedName("eldergills").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_nightvisiongoggles = new Item()
				.setRegistryName(new ResourceLocation(Reference.MOD_ID, "nightvisiongoggles"))
				.setUnlocalizedName("nightvisiongoggles").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_goggles = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "goggles"))
				.setUnlocalizedName("goggles").setCreativeTab(TinkersCompendium.tab));

		itemList.add(item_glowsole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "glowsole"))
				.setUnlocalizedName("glowsole").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_firesole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "firesole"))
				.setUnlocalizedName("firesole").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_icesole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "icesole"))
				.setUnlocalizedName("icesole").setCreativeTab(TinkersCompendium.tab));
		itemList.add(
				item_feathersole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "feathersole"))
						.setUnlocalizedName("feathersole").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_flippers = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "flippers"))
				.setUnlocalizedName("flippers").setCreativeTab(TinkersCompendium.tab));

		frostwalker = new ModWalker("frostwalker", 0x93d7ff, Blocks.WATER, Blocks.FLOWING_WATER, Blocks.FROSTED_ICE);
		firewalker = new ModWalker("firewalker", 0xff4300, Blocks.LAVA, Blocks.FLOWING_LAVA, unstable_obsidian);

	}

	public void init() {

		deadmansswitch.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Blocks.TNT),
				new ItemStack(Items.REPEATER), new ItemStack(Blocks.TNT)));

		ItemStack plate = TDParts.armorPlate.getItemstackWithMaterial(TinkerMaterials.iron);
		ItemStack rivet = TDParts.rivets.getItemstackWithMaterial(TinkerMaterials.iron);
		ItemStack chainmail = TDParts.chainmail.getItemstackWithMaterial(TinkerMaterials.iron);

		Item dogbeariumIngot = Item.REGISTRY.getObject(new ResourceLocation(Reference.MOD_ID, "ingot_dogbearium"));
		Item dogbeariumGear = Item.REGISTRY.getObject(new ResourceLocation(Reference.MOD_ID, "gear_dogbearium"));

		if (dogbeariumGear != null)
			autofeed.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Items.BOWL),
					new ItemStack(Items.ENDER_EYE), new ItemStack(dogbeariumGear)));
		else if (dogbeariumIngot != null)
			autofeed.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Items.BOWL),
					new ItemStack(Items.ENDER_EYE), new ItemStack(dogbeariumIngot)));
		else
			autofeed.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Items.BOWL),
					new ItemStack(Items.ENDER_EYE), new ItemStack(Items.APPLE)));

		protection.addRecipeMatch(new RecipeMatch.ItemCombination(1, plate, rivet, new ItemStack(Items.LEATHER)));
		fireprotection.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Items.MAGMA_CREAM),
				new ItemStack(Items.LEATHER), new ItemStack(Blocks.PACKED_ICE)));
		fireprotection.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Items.MAGMA_CREAM),
				new ItemStack(Items.LEATHER), new ItemStack(Blocks.ICE)));

		blastprotection.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Blocks.WOOL),
				new ItemStack(Items.LEATHER), new ItemStack(Items.FEATHER)));

		rivet.setCount(4);
		projprotection
				.addRecipeMatch(new RecipeMatch.ItemCombination(1, rivet, chainmail, new ItemStack(Items.IRON_NUGGET)));

		nightvision.addRecipeMatch(new RecipeMatch.Item(new ItemStack(item_nightvisiongoggles), 1));
		antiblindness.addRecipeMatch(new RecipeMatch.Item(new ItemStack(item_goggles), 1));

		respirationI.addRecipeMatch(new RecipeMatch.Item(new ItemStack(item_rebreather), 1));
		respirationII.addRecipeMatch(new RecipeMatch.Item(new ItemStack(item_eldergills), 1));

		frostwalker.addRecipeMatch(new RecipeMatch.Item(new ItemStack(item_icesole), 1));
		firewalker.addRecipeMatch(new RecipeMatch.Item(new ItemStack(item_firesole), 1));

		clock.addRecipeMatch(new RecipeMatch.Item(new ItemStack(Items.CLOCK), 1));
		compass.addRecipeMatch(new RecipeMatch.Item(new ItemStack(Items.COMPASS), 1));
		
		//width2.addRecipeMatch(new RecipeMatch.Item(new ItemStack(Items.SIGN), 1));
	}

	public void postInit() {

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		// TDClientRegistry.addModifierModel("goggles", new ModelGoggles());

		TinkersCompendium.proxy.registerItemRenderer(item_canister, 0, "canister");
		TinkersCompendium.proxy.registerItemRenderer(item_eldergills, 0, "eldergills");
		TinkersCompendium.proxy.registerItemRenderer(item_emptycanister, 0, "empty_canister");
		TinkersCompendium.proxy.registerItemRenderer(item_feathersole, 0, "feathersole");
		TinkersCompendium.proxy.registerItemRenderer(item_glowsole, 0, "glowsole");
		TinkersCompendium.proxy.registerItemRenderer(item_goggles, 0, "goggles");
		TinkersCompendium.proxy.registerItemRenderer(item_icesole, 0, "icesole");
		TinkersCompendium.proxy.registerItemRenderer(item_firesole, 0, "firesole");
		TinkersCompendium.proxy.registerItemRenderer(item_flippers, 0, "flippers");
		TinkersCompendium.proxy.registerItemRenderer(item_nightvisiongoggles, 0, "nightvisiongoggles");
		TinkersCompendium.proxy.registerItemRenderer(item_rebreather, 0, "rebreather");

		ModelRegisterUtil.registerModifierModel(deadmansswitch,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + deadmansswitch.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(protection,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + protection.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(projprotection,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + projprotection.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(blastprotection,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + blastprotection.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(fireprotection,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + fireprotection.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(autofeed,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + autofeed.getIdentifier()));

		ModelRegisterUtil.registerModifierModel(nightvision,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + nightvision.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(respirationI,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + respirationI.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(respirationII,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + respirationII.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(antiblindness,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + antiblindness.getIdentifier()));

		ModelRegisterUtil.registerModifierModel(frostwalker,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + frostwalker.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(firewalker,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + firewalker.getIdentifier()));

		ModelRegisterUtil.registerModifierModel(clock,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + clock.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(compass,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + compass.getIdentifier()));
	}

	@SubscribeEvent
	public static void loottableedit(LootTableLoadEvent e) {
		if (e.getName().toString().equals("minecraft:entities/elder_guardian")) {
			LootEntry entry = new LootEntryItem(CompendiumModifiers.item_eldergills, 15, 60, new LootFunction[0],
					new LootCondition[0], Reference.MOD_ID + ":elderdrops");
			LootPool pool1 = new LootPool(new LootEntry[] { entry }, new LootCondition[0], new RandomValueRange(1),
					new RandomValueRange(0, 1), Reference.MOD_ID + ":elderpool");
			e.getTable().addPool(pool1);
		}
	}
}
