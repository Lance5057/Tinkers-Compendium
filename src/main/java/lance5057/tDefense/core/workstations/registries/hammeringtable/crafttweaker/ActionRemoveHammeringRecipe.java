package lance5057.tDefense.core.workstations.registries.hammeringtable.crafttweaker;

import static crafttweaker.api.minecraft.CraftTweakerMC.getIItemStack;

import java.util.HashMap;
import java.util.Map;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.api.item.IIngredient;
import lance5057.tDefense.core.workstations.registries.hammeringtable.HammeringTableRecipeRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ActionRemoveHammeringRecipe implements IAction {
    
    private IIngredient output;
    private IIngredient input;
    Map<ItemStack, ItemStack> smeltingMap = new HashMap<>();
    
    public ActionRemoveHammeringRecipe(IIngredient output, IIngredient input) {
        this.output = output;
        this.input = input;
    }
    
    @Override
    public void apply() {
        Map<ItemStack, ItemStack> smeltingList = HammeringTableRecipeRegistry.instance().getHammeringList();
        if(input == null) {
            for(Map.Entry<ItemStack, ItemStack> entry : smeltingList.entrySet()) {
                if(output.matches(getIItemStack(entry.getValue()))) {
                    smeltingMap.put(entry.getKey(), entry.getValue());
                }
            }
        } else {
            for(Map.Entry<ItemStack, ItemStack> entry : smeltingList.entrySet()) {
                if(output.matches(getIItemStack(entry.getValue())) && input.matches(getIItemStack(entry.getKey()))) {
                    smeltingMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        for(Map.Entry<ItemStack, ItemStack> entry : smeltingMap.entrySet()) {
        	HammeringTableRecipeRegistry.instance().getHammeringList().remove(entry.getKey(), entry.getValue());
        }
        CraftTweakerAPI.logInfo(smeltingMap.size() + " recipes removed for: " + output);
    }
    
    @Override
    public String describe() {
        return "Removing hammering recipes for: " + output;
    }
}