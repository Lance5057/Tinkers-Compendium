package lance5057.tDefense.core.workstations.registries.hammeringtable;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class HammeringTableRecipeRegistry {
	private final Map<ItemStack, ItemStack> hammeringList = Maps.<ItemStack, ItemStack>newHashMap();
	private static final HammeringTableRecipeRegistry BASE = new HammeringTableRecipeRegistry();

	public static HammeringTableRecipeRegistry instance()
    {
        return BASE;
    }
	
	/**
	 * Adds a smelting recipe, where the input item is an instance of Block.
	 */
	public void addHammeringRecipeForBlock(Block input, ItemStack stack) {
		this.addHammering(Item.getItemFromBlock(input), stack);
	}

	/**
	 * Adds a smelting recipe using an Item as the input item.
	 */
	public void addHammering(Item input, ItemStack stack) {
		this.addHammeringRecipe(new ItemStack(input, 1, 32767), stack);
	}

	/**
	 * Adds a smelting recipe using an ItemStack as the input for the recipe.
	 */
	public void addHammeringRecipe(ItemStack input, ItemStack stack) {
		if (getHammeringResult(input) != ItemStack.EMPTY) {
			net.minecraftforge.fml.common.FMLLog.log.info("Ignored hammering recipe with conflicting input: {} = {}",
					input, stack);
			return;
		}
		this.hammeringList.put(input, stack);
	}

	/**
	 * Returns the smelting result of an item.
	 */
	public ItemStack getHammeringResult(ItemStack stack) {
		for (Entry<ItemStack, ItemStack> entry : this.hammeringList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return entry.getValue();
			}
		}

		return ItemStack.EMPTY;
	}

	/**
	 * Compares two itemstacks to ensure that they are the same. This checks both
	 * the item and the metadata of the item.
	 */
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem()
				&& (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}

	public Map<ItemStack, ItemStack> getHammeringList() {
		return this.hammeringList;
	}
}
