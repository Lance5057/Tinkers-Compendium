package lance5057.tDefense.core.workstations.registries.hammeringtable.crafttweaker;

import static crafttweaker.api.minecraft.CraftTweakerMC.getItemStack;
import static crafttweaker.api.minecraft.CraftTweakerMC.getItemStacks;

import java.util.ArrayList;
import java.util.List;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.mc1120.actions.ActionAddFurnaceRecipe;
import crafttweaker.mc1120.actions.ActionFurnaceRemoveAllRecipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.tinkerscompendium.HammeringTable")
@ZenRegister
public class HammeringTableManager {
    public static List<ActionAddHammeringRecipe> recipesToAdd = new ArrayList<>();
    public static List<ActionRemoveHammeringRecipe> recipesToRemove = new ArrayList<>();

    public HammeringTableManager() {

    }

    @ZenMethod
    public void remove(IIngredient output, @Optional IIngredient input) {
        if(output == null)
            throw new IllegalArgumentException("output cannot be null");

        recipesToRemove.add(new ActionRemoveHammeringRecipe(output, input));
    }

//    public void removeAll() {
//        recipesToRemove.add(new ActionFurnaceRemoveAllRecipes());
//    }

    @ZenMethod
    public void addRecipe(IItemStack output, IIngredient input) {
        List<IItemStack> items = input.getItems();
        if(items == null) {
            CraftTweakerAPI.logError("Cannot turn " + input.toString() + " into a furnace recipe");
            return;
        }
        ItemStack[] items2 = getItemStacks(items);
        ItemStack output2 = getItemStack(output);
        recipesToAdd.add(new ActionAddHammeringRecipe(input, items2, output2));
    }

    //TODO
//    public List<IFurnaceRecipe> getAll() {
//        return HammeringTableRecipeRegistry.instance()
//                .getHammeringList().entrySet().stream()
//                .filter(ent -> {
//                    if (!ent.getValue().isEmpty() && !ent.getKey().isEmpty()) {
//                        return true;
//                    } else {
//                        CraftTweakerAPI.logWarning("Furnace recipe from " + ent.getKey() + " to " + ent.getValue() + " has a empty stack.");
//                        return false;
//                    }
//                })
//                .map(ent -> new FurnaceRecipe(MCItemStack.createNonCopy(ent.getKey()), MCItemStack.createNonCopy(ent.getValue()), FurnaceRecipes.instance().getSmeltingExperience(ent.getValue())))
//                .collect(Collectors.toList());
//    }


}