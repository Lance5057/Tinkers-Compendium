package lance5057.tDefense.core.tools.modifiers.Botania;

import java.util.Arrays;
import java.util.List;

import lance5057.tDefense.core.tools.Shield;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ItemModTypeFilter;

public class modifierCorpseIvy extends ItemModTypeFilter
{
	String	tooltipName;
	String	guiType;

	public modifierCorpseIvy(String type, int effect, ItemStack[] items, int[] values)
	{
		super(effect, "corpseivy", items, values);
		tooltipName = "\u00A7fCorpse Drinker";
		guiType = type;
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		List list = Arrays.asList(((ToolCore) tool.getItem()).getTraits());
		if(list.contains("weapon"))
		{
			return tags.getInteger("Modifiers") > 0;
		}

		return false;
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		int increase = matchingAmount(input);
		if(tags.hasKey(key))
		{
			int[] keyPair = tags.getIntArray(key);

			updateModTag(tool, keyPair);

		}
		else
		{
			int modifiers = tags.getInteger("Modifiers");
			modifiers -= 1;
			tags.setInteger("Modifiers", modifiers);
			String modName = "\u00A76" + guiType;
			int tooltipIndex = addToolTip(tool, tooltipName, modName);
		}
	}

	void updateModTag(ItemStack tool, int[] keys)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		String tip = "ModifierTip" + keys[2];
		String modName = "\u00A76" + guiType;
		tags.setString(tip, modName);
	}
}
