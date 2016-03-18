package lance5057.tDefense.core.tools.modifiers.TDefense;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.modifiers.tools.ModBoolean;

public class modifierSoulBound extends ModBoolean
{
	String	c;
	String	tip;

	public modifierSoulBound(ItemStack[] items, int effect, String tag, String color, String tipname)
	{
		super(items, effect, tag, color, tipname);
		c = color;
		tip = tipname;
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		tags.setBoolean(key, true);

		addToolTip(tool, c + tip, c + key);
	}

}
