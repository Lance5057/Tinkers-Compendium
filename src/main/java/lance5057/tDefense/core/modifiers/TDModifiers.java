package lance5057.tDefense.core.modifiers;

import java.util.ArrayList;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.blocks.UnstableBlock;
import lance5057.tDefense.core.library.TDClientRegistry;
import lance5057.tDefense.core.modifiers.models.ModelGoggles;
import lance5057.tDefense.core.parts.TDParts;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.tools.TinkerMaterials;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDModifiers {

	public static Item item_canister;
	public static Item item_emptycanister;
	public static Item item_rebreather;
	public static Item item_goggles;
	public static Item item_nightvisiongoggles;

	public static Item item_glowsole;
	public static Item item_firesole;
	public static Item item_icesole;
	public static Item item_feathersole;
	public static Item item_flippers;
	
	public static Block unstable_obsidian;
	public static Block unstable_ice;
	
	public static Modifier deadmansswitch = new ModDeadMansSwitch();
	public static Modifier protection = new ModProtection("protection", 0xe2e2e2, Enchantments.PROTECTION);
	public static Modifier projprotection = new ModProtection("projprotection", 0xffffff, Enchantments.PROJECTILE_PROTECTION);
	public static Modifier blastprotection = new ModProtection("blastprotection", 0x0bad00, Enchantments.BLAST_PROTECTION);
	public static Modifier fireprotection = new ModProtection("fireprotection", 0xfcb56a, Enchantments.FIRE_PROTECTION);
	
	public static Modifier nightvision = new ModNightVision();
	public static Modifier respirationI = new ModRespiration(1);
	public static Modifier respirationII = new ModRespiration(2);
	public static Modifier antiblindness = new ModAntiBlindness();
	
	static ArrayList<Item> itemList = new ArrayList<Item>();
	static ArrayList<Block> blockList = new ArrayList<Block>();
	
	public void preInit()
	{
		itemList.add(item_canister = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "canister")).setUnlocalizedName("canister").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_emptycanister = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "empty_canister")).setUnlocalizedName("empty_canister").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_rebreather = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "rebreather")).setUnlocalizedName("rebreather").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_nightvisiongoggles = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "nightvisiongoggles")).setUnlocalizedName("nightvisiongoggles").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_goggles = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "goggles")).setUnlocalizedName("goggles").setCreativeTab(TinkersCompendium.tab));

		itemList.add(item_glowsole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "glowsole")).setUnlocalizedName("glowsole").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_firesole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "firesole")).setUnlocalizedName("firesole").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_icesole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "icesole")).setUnlocalizedName("icesole").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_feathersole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "feathersole")).setUnlocalizedName("feathersole").setCreativeTab(TinkersCompendium.tab));
		itemList.add(item_flippers = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "flippers")).setUnlocalizedName("flippers").setCreativeTab(TinkersCompendium.tab));
		
		blockList.add(unstable_obsidian = new UnstableBlock(Material.ROCK, MapColor.OBSIDIAN, Blocks.LAVA, 15, 0).setRegistryName(new ResourceLocation(Reference.MOD_ID, "unstableobsidian")).setUnlocalizedName("unstableobsidian").setCreativeTab(TinkersCompendium.tab));
		blockList.add(unstable_ice = new UnstableBlock(Material.ICE, MapColor.ICE, Blocks.WATER, 0, 0.98F).setRegistryName(new ResourceLocation(Reference.MOD_ID, "unstableice")).setUnlocalizedName("unstableice").setCreativeTab(TinkersCompendium.tab));
	}
	
	public void init()
	{
		deadmansswitch.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Blocks.TNT),new ItemStack(Items.REPEATER),new ItemStack(Blocks.TNT)));
		
		ItemStack plate = TDParts.armorPlate.getItemstackWithMaterial(TinkerMaterials.iron);
		ItemStack rivet = TDParts.rivets.getItemstackWithMaterial(TinkerMaterials.iron);
		
		protection.addRecipeMatch(new RecipeMatch.Item(plate, 1));
		fireprotection.addRecipeMatch(new RecipeMatch.Item(new ItemStack(Items.MAGMA_CREAM), 1));
		blastprotection.addRecipeMatch(new RecipeMatch.Item(new ItemStack(Blocks.WOOL), 1));
		projprotection.addRecipeMatch(new RecipeMatch.Item(rivet, 4));
		
		nightvision.addRecipeMatch(new RecipeMatch.Item(new ItemStack(item_nightvisiongoggles), 1));
		antiblindness.addRecipeMatch(new RecipeMatch.Item(new ItemStack(item_goggles), 1));
		
		respirationI.addRecipeMatch(new RecipeMatch.Item(new ItemStack(item_rebreather), 1));
		//TODO add advanced respiration item
	}
	
	public void postInit()
	{
		
	}
	
	public void clientInit()
	{
		TDClientRegistry.addModifierModel("goggles", new ModelGoggles());
	}
	

	public void registerItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry registry = event.getRegistry();
		
		for (Item i : itemList)
		{
			registry.register(i);
		}
	}
	
	public void registerBlocks(final RegistryEvent.Register<Block> event) {
		final IForgeRegistry registry = event.getRegistry();
		
		for (Block i : blockList)
		{
			registry.register(i);
		}
	}
}
