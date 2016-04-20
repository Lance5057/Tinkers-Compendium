package lance5057.tDefense.armor.modifiers;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModBoolean;

public class modifierBoolExclusive extends ModBoolean
{
	String[]	exclusive;
	int			modsNeeded	= 0;
	String		color;
	String		tooltipName;
	String[]	modExclusions;

	/*
	 * excludeMods: If these modifier keys are present this modifier wont take.
	 */
	public modifierBoolExclusive(ItemStack[] items, int effect, String tag, String c, String tip, String[] exclusive, int modsNeeded, String[] excludeMods)
	{
		super(items, effect, tag, c, tip);
		this.exclusive = exclusive;
		this.modsNeeded = modsNeeded;
		this.color = c;
		this.tooltipName = tip;
		this.modExclusions = excludeMods;
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		List list = Arrays.asList(((ToolCore) tool.getItem()).getTraits());
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		boolean isExclusive = false;
		boolean hasModRejection = false;

		for(int i = 0; i < exclusive.length; i++)
		{
			if(list.contains(exclusive[i]))
			{
				isExclusive = true;
			}
		}

		if(modExclusions != null)
		{
			for(int i = 0; i < modExclusions.length; i++)
			{
				if(tags.hasKey(modExclusions[i]))
				{
					hasModRejection = true;
				}
			}
		}

		return isExclusive && !hasModRejection && !tags.hasKey(tooltipName);
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		tags.setBoolean(key, true);

		int modifiers = tags.getInteger("Modifiers");
		modifiers -= modsNeeded;
		tags.setInteger("Modifiers", modifiers);

		addToolTip(tool, color + tooltipName, color + key);
	}
}
