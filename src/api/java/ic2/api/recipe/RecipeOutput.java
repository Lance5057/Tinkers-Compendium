package ic2.api.recipe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public final class RecipeOutput
{
	public RecipeOutput(NBTTagCompound metadata1, List<ItemStack> items1)
	{
		assert !items1.contains(null);

		metadata = metadata1;
		items = items1;
	}

	public RecipeOutput(NBTTagCompound metadata1, ItemStack... items1)
	{
		this(metadata1, Arrays.asList(items1));
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof RecipeOutput)
		{
			final RecipeOutput ro = (RecipeOutput) obj;

			if(items.size() == ro.items.size() && (metadata == null && ro.metadata == null || metadata != null && ro.metadata != null && metadata.equals(ro.metadata)))
			{
				final Iterator<ItemStack> itA = items.iterator();
				final Iterator<ItemStack> itB = ro.items.iterator();

				while(itA.hasNext() && itB.hasNext())
				{
					final ItemStack stackA = itA.next();
					final ItemStack stackB = itB.next();

					if(ItemStack.areItemStacksEqual(stackA, stackB))
					{
						return false;
					}
				}

				return true;
			}
		}

		return false;
	}

	@Override
	public String toString()
	{
		return "ROutput<" + items + "," + metadata + ">";
	}

	public final List<ItemStack>	items;
	public final NBTTagCompound		metadata;
}
