package lance5057.tDefense.core.workstations.registries.hammeringtable.crafttweaker;

import crafttweaker.IAction;
import crafttweaker.api.item.IIngredient;
import lance5057.tDefense.core.workstations.registries.hammeringtable.HammeringTableRecipeRegistry;
import net.minecraft.item.ItemStack;

public class ActionAddHammeringRecipe implements IAction {
    
    private final IIngredient ingredient;
    private final ItemStack[] input;
    private final ItemStack output;
    
    public ActionAddHammeringRecipe(IIngredient ingredient, ItemStack[] input, ItemStack output) {
        this.ingredient = ingredient;
        this.input = input;
        this.output = output;
    }
    
    @Override
    public void apply() {
        for(ItemStack inputStack : input) {
            HammeringTableRecipeRegistry.instance().addHammeringRecipe(inputStack, output);
        }
    }
    
    @Override
    public String describe() {
        return "Adding hammering table recipe for " + ingredient;
    }
}