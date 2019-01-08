package lance5057.tDefense.core.workstations.recipes;

import net.minecraft.item.ItemStack;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.utils.ListUtil;

public class ManualInteractionRecipe {
	public final int interactions;
	public final RecipeMatch input;
	public final ItemStack[] output;

	public ManualInteractionRecipe(RecipeMatch input, ItemStack[] output, int interactions) {
		this.interactions = interactions;
		this.input = input;
		this.output = output;
	}

	public boolean matches(ItemStack input) {
		return this.input != null && this.input.matches(ListUtil.getListFrom(input)).isPresent();
	}

	public ItemStack[] getResult() {
		return output;
	}

	public int getInteractions() {
		return interactions;
	}
}
