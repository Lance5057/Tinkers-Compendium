package lance5057.tDefense.core.tools.modifiers;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModInteger;

public class ModifierIntExclusive extends ModInteger
{
	String[]	exclusive;
	int			modsNeeded	= 0;
	String		color;
	String		tooltipName;
	int			initialIncrease;
	int			secondaryIncrease;
	int			max			= 5;
	String[]	modExclusions;

	public ModifierIntExclusive(ItemStack[] items, int effect, String dataKey, int increase, String c, String tip, String[] exclusive, int modsNeeded, String[] excludeMods)
	{
		super(items, effect, dataKey, increase, c, tip);
		this.exclusive = exclusive;
		this.modsNeeded = modsNeeded;
		initialIncrease = secondaryIncrease = increase;
		color = c;
		tooltipName = tip;
		modExclusions = excludeMods;
	}

	public ModifierIntExclusive(ItemStack[] items, int effect, String dataKey, int increase, String c, String tip, String[] exclusive, int modsNeeded, int max)
	{
		super(items, effect, dataKey, increase, c, tip);
		this.exclusive = exclusive;
		this.modsNeeded = modsNeeded;
		initialIncrease = secondaryIncrease = increase;
		color = c;
		tooltipName = tip;
		this.max = max;
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		final List list = Arrays.asList(((ToolCore) tool.getItem()).getTraits());
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		for(final String element : exclusive)
		{
			if(list.contains(element))
			{
			}
		}

		if(modExclusions != null)
		{
			for(final String modExclusion : modExclusions)
			{
				if(tags.hasKey(modExclusion))
				{
				}
			}
		}

		return tags.getInteger(tooltipName) < max;
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		if(tags.hasKey(key))
		{
			int increase = tags.getInteger(key);
			increase += secondaryIncrease;
			tags.setInteger(key, increase);
		}
		else
		{
			tags.setInteger(key, initialIncrease);
		}

		int modifiers = tags.getInteger("Modifiers");
		modifiers -= modsNeeded;
		tags.setInteger("Modifiers", modifiers);

		addToolTip(tool, color + tooltipName, color + key);
	}
}
