package lance5057.tDefense.core.workstations;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.workstations.recipes.ManualInteractionRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.DryingRecipe;
import slimeknights.tconstruct.library.events.TinkerRegisterEvent;

public class WorkstationRegistry {
	private static List<ManualInteractionRecipe> HammeringRegistry = new ArrayList<ManualInteractionRecipe>();

	//ItemStack in
		public static void registerHammeringRecipe(ItemStack input, ItemStack[] output, int time) {
		    if(output == null || input == null) {
		      return;
		    }
		    
		    addHammeringRecipe(new ManualInteractionRecipe(new RecipeMatch.Item(input, 1), output, time));
		  }
	
	//Item in
	public static void registerHammeringRecipe(Item input, ItemStack[] output, int time) {
	    if(output == null || input == null) {
	      return;
	    }

	    ItemStack stack = new ItemStack(input, 1, OreDictionary.WILDCARD_VALUE);
	    addHammeringRecipe(new ManualInteractionRecipe(new RecipeMatch.Item(stack, 1), output, time));
	  }
	
	//Oredict in
	public static void registerHammeringRecipe(String oredict, ItemStack[] output, int interaction) {
		if (output != null || oredict == null) {
			return;
		}

		addHammeringRecipe(new ManualInteractionRecipe(new RecipeMatch.Oredict(oredict, 1), output, interaction));
	}
	
	//Block in
	public static void registerHammeringRecipe(Block input, ItemStack[] output, int time) {
	    if(output == null || input == null) {
	      return;
	    }

	    ItemStack stack = new ItemStack(input, 1, OreDictionary.WILDCARD_VALUE);
	    addHammeringRecipe(new ManualInteractionRecipe(new RecipeMatch.Item(stack, 1), output, time));
	  }

	public static int getHammeringInteractions(ItemStack input) {
		for (ManualInteractionRecipe r : HammeringRegistry) {
			if (r.matches(input)) {
				return r.getInteractions();
			}
		}

		return -1;
	}

	public static ItemStack[] getHammeringResult(ItemStack input) {
		for (ManualInteractionRecipe r : HammeringRegistry) {
			if (r.matches(input)) {
				return r.getResult();
			}
		}

		return null;
	}

	public static void addHammeringRecipe(ManualInteractionRecipe recipe) {
		HammeringRegistry.add(recipe);
	}
}
