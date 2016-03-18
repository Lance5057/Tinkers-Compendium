package lance5057.tDefense.core.tools.modifiers.TDefense.shields;

import lance5057.tDefense.core.tools.Shield;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.modifiers.tools.ItemModTypeFilter;

public class modifierCrestofLegends extends ItemModTypeFilter
{
	String	tooltipName;
	String	guiType;

	public modifierCrestofLegends(String type, int effect, ItemStack[] items, int[] values)
	{
		super(effect, "Legends", items, values);
		tooltipName = "\u00A7fCrest of Legends";
		guiType = type;
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		if(tool.getItem() instanceof Shield)
			return tags.getInteger("Modifiers") > 0;

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
		String modName = "\u00A76" + guiType + " (" + keys[0] + "/" + keys[1] + ")";
		tags.setString(tip, modName);
	}
}
