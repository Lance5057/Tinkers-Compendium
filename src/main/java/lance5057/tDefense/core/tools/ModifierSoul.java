package lance5057.tDefense.core.tools;

import lance5057.tDefense.core.tools.modifiers.ModifierBoolExclusive;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ModifierSoul extends ModifierBoolExclusive
{
	String	name;

	public ModifierSoul(ItemStack[] items, int effect, String tag, String c, String tip, String[] exclusive, int modsNeeded, String[] excludeMods, String name)
	{
		super(items, effect, tag, c, tip, exclusive, modsNeeded, excludeMods);
		this.name = name;
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		tags.setBoolean(key, true);
		tags.setString("Soul", name);

		int modifiers = tags.getInteger("Modifiers");
		modifiers -= modsNeeded;
		tags.setInteger("Modifiers", modifiers);

		addToolTip(tool, color + tooltipName, color + key);
	}
}
