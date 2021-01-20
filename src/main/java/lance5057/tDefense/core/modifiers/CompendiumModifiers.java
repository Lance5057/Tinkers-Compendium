package lance5057.tDefense.core.modifiers;

import java.util.ArrayList;

import c4.conarm.common.ConstructsRegistry;
import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.parts.TDParts;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.tools.TinkerMaterials;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CompendiumModifiers {

	public static Modifier deadmansswitch = new ModDeadMansSwitch();
	public static Modifier protection = new ModProtection("protection", 0xe2e2e2, Enchantments.PROTECTION);
	public static Modifier projprotection = new ModProtection("projprotection", 0xffffff,
			Enchantments.PROJECTILE_PROTECTION);
	public static Modifier blastprotection = new ModProtection("blastprotection", 0x0bad00,
			Enchantments.BLAST_PROTECTION);
	public static Modifier fireprotection = new ModProtection("fireprotection", 0xfcb56a, Enchantments.FIRE_PROTECTION);
	public static Modifier autofeed = new ModAutofeed();


	public static Modifier clock = new ModClock();
	public static Modifier compass = new ModCompass();
	
	//public static Modifier width2 = new ModHarvestSize("width2");

	static ArrayList<Item> itemList = new ArrayList<Item>();
	static ArrayList<Block> blockList = new ArrayList<Block>();

	public void init() {

		deadmansswitch.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Blocks.TNT),
				new ItemStack(Items.REPEATER), new ItemStack(Blocks.TNT)));

		ItemStack plate = ConstructsRegistry.armorPlate.getItemstackWithMaterial(TinkerMaterials.iron);
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

		clock.addRecipeMatch(new RecipeMatch.Item(new ItemStack(Items.CLOCK), 1));
		compass.addRecipeMatch(new RecipeMatch.Item(new ItemStack(Items.COMPASS), 1));
		
		//width2.addRecipeMatch(new RecipeMatch.Item(new ItemStack(Items.SIGN), 1));
	}

	public void postInit() {

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {

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

		ModelRegisterUtil.registerModifierModel(clock,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + clock.getIdentifier()));
		ModelRegisterUtil.registerModifierModel(compass,
				new ResourceLocation(Reference.MOD_ID, "models/item/modifiers/" + compass.getIdentifier()));
	}

}
