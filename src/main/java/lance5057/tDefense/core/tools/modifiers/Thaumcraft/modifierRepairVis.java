package lance5057.tDefense.core.tools.modifiers.Thaumcraft;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.modifiers.tools.ModBoolean;
import thaumcraft.api.wands.WandCap;

public class modifierRepairVis extends ModBoolean
{
	WandCap	cap;
	String	color;
	String	tooltipName;

	public modifierRepairVis(ItemStack[] items, int effect, String tag, String c, String tip)
	{
		super(items, effect, tag, c, tip);
		color = c;
		tooltipName = tip;
	}

	@Override
	public boolean matches(ItemStack[] recipe, ItemStack input)
	{
		cap = null;
		for(final ItemStack element : recipe)
		{
			if(element != null)
			{
				for(final WandCap cp : WandCap.caps.values())
				{
					final ItemStack test = cp.getItem();
					if(test != null && element.getItem() == test.getItem() && element.getItemDamage() == test.getItemDamage())
					{
						cap = cp;
						break;
					}
				}
			}
		}

		if(!canModify(input, recipe))
			return false;
		if(cap == null)
			return false;
		return true;
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key) && cap != null; //Will fail if the modifier is false or the tag doesn't exist
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		tags.setFloat(key, cap.getBaseCostModifier());

		int modifiers = tags.getInteger("Modifiers");
		modifiers -= 1;
		tags.setInteger("Modifiers", modifiers);

		final String mat = cap.getTag().substring(0, 1).toUpperCase() + cap.getTag().substring(1) + " ";
		addToolTip(tool, color + mat + tooltipName, color + mat + tooltipName + " (" + (int) (cap.getBaseCostModifier() * 100) + "%)");
	}
}
