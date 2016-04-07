package lance5057.tDefense.armor.modifiers;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModBoolean;

public class modifierBoolExclusive extends ModBoolean
{
	String[] exclusive;
	public modifierBoolExclusive(ItemStack[] items, int effect, String tag, String c, String tip, String[] exclusive)
	{
		super(items, effect, tag, c, tip);
		this.exclusive = exclusive;
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
				return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key);
			}
		}
		
		return false;
	}
}
