package lance5057.tDefense.core.tools.modifiers;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.modifiers.ArmorMods;
import lance5057.tDefense.core.tools.modifiers.ActiveToolMods.TDefenseActiveToolMod;
import lance5057.tDefense.core.tools.modifiers.TDefense.modifierSoulBound;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofBlades;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofFeathers;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofLegends;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofMirrors;
import lance5057.tDefense.core.tools.modifiers.TDefense.weapons.modifierDaze;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModBoolean;
import cpw.mods.fml.common.registry.GameRegistry;

public class Modifiers
{
	public static Item		item_relic;
	public static Item		itemSoulChain;
	public static ArmorMods	AMod = new ArmorMods();

	public void preInit()
	{
		AMod.LoadItems();
		
		item_relic = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("AncientRelic").setTextureName(Reference.MOD_ID + ":AncientRelic");

		itemSoulChain = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("SoulChain").setTextureName(Reference.MOD_ID + ":SoulChain");

		GameRegistry.registerItem(item_relic, "Ancient Relic");
		GameRegistry.registerItem(itemSoulChain, "Soul Chain");
	}
	
	public void Init()
	{
		AMod.RegisterRecipes();
		AMod.RegisterModifiers();
		
		ModifyBuilder.registerModifier(new modifierDaze("Daze", TinkersDefense.config.DazeID, new ItemStack[] {new ItemStack(Blocks.light_weighted_pressure_plate), new ItemStack(Items.potionitem, 1, 8202)}, new int[] {1, 0}));

		//ModifyBuilder.registerModifier(new modifierTorchArrow(new ItemStack[] {new ItemStack(Blocks.glowstone)}, 12));

		ModifyBuilder.registerModifier(new modifierCrestofFeathers("Crest of Feathers", TinkersDefense.config.CrestFeathersID, new ItemStack[] {new ItemStack(Items.feather)}, new int[] {1}));

		ModifyBuilder.registerModifier(new modifierCrestofMirrors("Crest of Mirrors", TinkersDefense.config.CrestMirrorsID, new ItemStack[] {new ItemStack(Blocks.glass_pane)}, new int[] {1}));

		ModifyBuilder.registerModifier(new modifierCrestofLegends("Crest of Legends", TinkersDefense.config.CrestLegendsID, new ItemStack[] {new ItemStack(item_relic)}, new int[] {1}));

		ModifyBuilder.registerModifier(new modifierCrestofBlades("Crest of Blades", TinkersDefense.config.CrestBladesID, new ItemStack[] {new ItemStack(Items.iron_sword)}, new int[] {1}));

		ModifyBuilder.registerModifier(new modifierSoulBound(new ItemStack[] {new ItemStack(itemSoulChain)}, TinkersDefense.config.SoulBoundID, "Soulbound", "\u00A7b", "Soulbound"));

		TConstructRegistry.registerActiveToolMod(new TDefenseActiveToolMod());

		for(ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.DazeID, "tinker", "daze", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestFeathersID, "tinker", "feathers", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestMirrorsID, "tinker", "mirrors", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestLegendsID, "tinker", "legends", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestBladesID, "tinker", "blades", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.SoulBoundID, "tinker", "soulbound", true);
		}
	}
}
