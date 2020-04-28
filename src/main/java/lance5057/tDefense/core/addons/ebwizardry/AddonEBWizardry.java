package lance5057.tDefense.core.addons.ebwizardry;

import electroblob.wizardry.constants.Element;
import electroblob.wizardry.registry.WizardryItems;
import lance5057.tDefense.core.addons.ebwizardry.modifiers.ModElementalFocus;
import lance5057.tDefense.core.library.ModuleBase;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.Util;

public class AddonEBWizardry extends ModuleBase {
	
	ModElementalFocus earthFocus = new ModElementalFocus(Element.EARTH.getDisplayName(),  Util.enumChatFormattingToColor(Element.EARTH.getColour().getColor()), Element.EARTH);
	ModElementalFocus fireFocus = new ModElementalFocus(Element.FIRE.getDisplayName(),  Util.enumChatFormattingToColor(Element.FIRE.getColour().getColor()), Element.FIRE);
	ModElementalFocus iceFocus = new ModElementalFocus(Element.ICE.getDisplayName(),  Util.enumChatFormattingToColor(Element.ICE.getColour().getColor()), Element.ICE);
	ModElementalFocus healingFocus = new ModElementalFocus(Element.HEALING.getDisplayName(),  Util.enumChatFormattingToColor(Element.HEALING.getColour().getColor()), Element.HEALING);
	ModElementalFocus necroFocus = new ModElementalFocus(Element.NECROMANCY.getDisplayName(),  Util.enumChatFormattingToColor(Element.NECROMANCY.getColour().getColor()), Element.NECROMANCY);
	ModElementalFocus sorceryFocus = new ModElementalFocus(Element.SORCERY.getDisplayName(),  Util.enumChatFormattingToColor(Element.SORCERY.getColour().getColor()), Element.SORCERY);
	ModElementalFocus lightningFocus = new ModElementalFocus(Element.LIGHTNING.getDisplayName(),  Util.enumChatFormattingToColor(Element.LIGHTNING.getColour().getColor()), Element.LIGHTNING);
	
	public AddonEBWizardry() {
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FMLInitializationEvent e) {
		earthFocus.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(WizardryItems.magic_crystal,1,5), new ItemStack(WizardryItems.magic_silk), new ItemStack(Items.GOLD_INGOT)));
		fireFocus.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(WizardryItems.magic_crystal,1,1), new ItemStack(WizardryItems.magic_silk), new ItemStack(Items.GOLD_INGOT)));
		iceFocus.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(WizardryItems.magic_crystal,1,2), new ItemStack(WizardryItems.magic_silk), new ItemStack(Items.GOLD_INGOT)));
		healingFocus.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(WizardryItems.magic_crystal,1,7), new ItemStack(WizardryItems.magic_silk), new ItemStack(Items.GOLD_INGOT)));
		necroFocus.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(WizardryItems.magic_crystal,1,4), new ItemStack(WizardryItems.magic_silk), new ItemStack(Items.GOLD_INGOT)));
		sorceryFocus.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(WizardryItems.magic_crystal,1,6), new ItemStack(WizardryItems.magic_silk), new ItemStack(Items.GOLD_INGOT)));
		lightningFocus.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(WizardryItems.magic_crystal,1,3), new ItemStack(WizardryItems.magic_silk), new ItemStack(Items.GOLD_INGOT)));

		MinecraftForge.EVENT_BUS.register(new EBWizardryEvents());
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void registerItems(Register<Item> event) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void registerBlocks(Register<Block> event) {
//		// TODO Auto-generated method stub
//		
//	}

}
