package lance5057.tDefense.armor.modifiers;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModInteger;

public class modifierProtection extends ModInteger
{
	String		color;
	String		type;
	String		tooltipName	= "";
	int			initialIncrease;
	int			secondaryIncrease;
	String[]	types		= {"Protection", "Fire Protection", "Blast Protection", "Projectile Protection", "Featherfall"};

	public modifierProtection(ItemStack[] items, int effect, int increase, String c, String t)
	{
		super(items, effect, t, increase, c, t);
		color = c;
		type = t;
		initialIncrease = secondaryIncrease = increase;
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		if(tool.getItem() instanceof ToolCore)
		{
			final List list = Arrays.asList(((ToolCore) tool.getItem()).getTraits());
			final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

			if(list.contains("heavyarmor") || list.contains("lightarmor"))
			{
				if(type != types[4])
				{
					for(int i = 0; i < 4; i++)
					{
						if(tags.hasKey(types[i]))
						{
							if(types[i] != type)
							{
								return false;
							}
							if(types[i] == type && tags.getInteger(types[i]) > 5)
							{
								return false;
							}
						}
					}
					return true;
				}
				else if(type == types[4] && tags.getInteger(types[4]) < 5)
				{
					if(list.contains("feet"))
					{
						return true;
					}
					return false;
				}
			}

		}
		return false;
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
		modifiers -= 1;
		tags.setInteger("Modifiers", modifiers);

		int prot = tags.getInteger(type);
		prot += 1;
		tags.setInteger(type, prot);

		addToolTip(tool, color + tooltipName, color + key);
	}
}
