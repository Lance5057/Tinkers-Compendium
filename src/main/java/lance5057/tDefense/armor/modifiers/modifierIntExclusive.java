package lance5057.tDefense.armor.modifiers;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModInteger;

public class modifierIntExclusive extends ModInteger
{
	String[]	exclusive;
	int			modsNeeded	= 0;
	String		color;
	String		tooltipName;
	int			initialIncrease;
	int			secondaryIncrease;
	int			max			= 5;

	public modifierIntExclusive(ItemStack[] items, int effect, String dataKey, int increase, String c, String tip, String[] exclusive, int modsNeeded)
	{
		super(items, effect, dataKey, increase, c, tip);
		this.exclusive = exclusive;
		this.modsNeeded = modsNeeded;
		initialIncrease = secondaryIncrease = increase;
		color = c;
		tooltipName = tip;
	}

	public modifierIntExclusive(ItemStack[] items, int effect, String dataKey, int increase, String c, String tip, String[] exclusive, int modsNeeded, int max)
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
		List list = Arrays.asList(((ToolCore) tool.getItem()).getTraits());
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		for(int i = 0; i < exclusive.length; i++)
		{
			if(list.contains(exclusive[i]))
			{
				return tags.getInteger(tooltipName) < max;
			}
		}

		return false;
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
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
