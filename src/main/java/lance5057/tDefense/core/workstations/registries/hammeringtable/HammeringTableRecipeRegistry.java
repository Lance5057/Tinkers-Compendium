package lance5057.tDefense.core.workstations.registries.hammeringtable;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class HammeringTableRecipeRegistry {
	private final Map<ItemStack, ItemStack> hammeringList = Maps.<ItemStack, ItemStack>newHashMap();
	private final Map<ItemStack, ResourceLocation> hammeringLootTableList = Maps.<ItemStack, ResourceLocation>newHashMap();
	private static final HammeringTableRecipeRegistry BASE = new HammeringTableRecipeRegistry();

	public static HammeringTableRecipeRegistry instance()
    {
        return BASE;
    }
	
	public void addHammeringRecipeForBlock(Block input, ItemStack stack) {
		this.addHammering(Item.getItemFromBlock(input), stack);
	}

	public void addHammering(Item input, ItemStack stack) {
		this.addHammeringRecipe(new ItemStack(input, 1, 32767), stack);
	}

	public void addHammeringRecipe(ItemStack input, ItemStack stack) {
		if (getHammeringResult(input) != ItemStack.EMPTY) {
			net.minecraftforge.fml.common.FMLLog.log.info("Ignored hammering recipe with conflicting input: {} = {}",
					input, stack);
			return;
		}
		this.hammeringList.put(input, stack);
	}

	public ItemStack getHammeringResult(ItemStack stack) {
		for (Entry<ItemStack, ItemStack> entry : this.hammeringList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return entry.getValue().copy();
			}
		}

		return ItemStack.EMPTY;
	}
	
	//--Loot Tables--//
	
	public void addHammeringLootTableForBlock(Block input, ResourceLocation table) {
		this.addHammering(Item.getItemFromBlock(input), table);
	}

	public void addHammering(Item input, ResourceLocation table) {
		this.addHammeringRecipe(new ItemStack(input, 1, 32767), table);
	}

	public void addHammeringRecipe(ItemStack input, ResourceLocation table) {
		if (getHammeringResult(input) != ItemStack.EMPTY) {
			net.minecraftforge.fml.common.FMLLog.log.info("Ignored hammering recipe with conflicting input: {} = {}",
					input, table);
			return;
		}
		this.hammeringLootTableList.put(input, table);
	}

	public ResourceLocation getHammeringLootTableResult(ItemStack stack) {
		for (Entry<ItemStack, ResourceLocation> entry : this.hammeringLootTableList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return entry.getValue();
			}
		}

		return null;
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
