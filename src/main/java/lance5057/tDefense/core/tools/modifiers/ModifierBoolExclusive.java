package lance5057.tDefense.core.tools.modifiers;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModBoolean;

public class ModifierBoolExclusive extends ModBoolean
{
	String[]			exclusive;
	protected int		modsNeeded	= 0;
	protected String	color;
	protected String	tooltipName;
	String[]			modExclusions;

	/*
	 * excludeMods: If these modifier keys are present this modifier wont take.
	 */
	public ModifierBoolExclusive(ItemStack[] items, int effect, String tag, String c, String tip, String[] exclusive, int modsNeeded, String[] excludeMods)
	{
		super(items, effect, tag, c, tip);
		this.exclusive = exclusive;
		this.modsNeeded = modsNeeded;
		color = c;
		tooltipName = tip;
		modExclusions = excludeMods;
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		final List list = Arrays.asList(((ToolCore) tool.getItem()).getTraits());
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		boolean isExclusive = false;
		boolean hasModRejection = false;

		if(exclusive.length > 0)
		{
			for(final String element : exclusive)
			{
				if(list.contains(element))
				{
					isExclusive = true;
				}
			}
		}
		else
		{
			isExclusive = true;
		}

		if(modExclusions != null)
		{
			for(final String modExclusion : modExclusions)
			{
				if(tags.hasKey(modExclusion))
				{
					hasModRejection = true;
				}
			}
		}

		return isExclusive && !hasModRejection && !tags.hasKey(key);
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		tags.setBoolean(key, true);

		int modifiers = tags.getInteger("Modifiers");
		modifiers -= modsNeeded;
		tags.setInteger("Modifiers", modifiers);

		addToolTip(tool, color + tooltipName, color + key);
	}
}
