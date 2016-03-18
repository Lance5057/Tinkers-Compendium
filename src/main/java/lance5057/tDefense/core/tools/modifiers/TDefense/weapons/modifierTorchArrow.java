package lance5057.tDefense.core.tools.modifiers.TDefense.weapons;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ItemModTypeFilter;
import tconstruct.modifiers.tools.ModBoolean;

public class modifierTorchArrow extends ModBoolean
{
	String	tooltipName;
	String	guiType;
	String	color;

	public modifierTorchArrow(ItemStack[] items, int effect)
	{
		super(items, effect, "Torch", "\u00A76", "Torch");
		tooltipName = "\u00A76Daze";
		color = "\u00A76";
		//guiType = type;
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		if(tool.getItem() instanceof ToolCore)
		{
			List list = Arrays.asList(((ToolCore) tool.getItem()).getTraits());
			if(list.contains("ammo"))
			{
				ToolCore toolItem = (ToolCore) tool.getItem();
				if(!validType(toolItem))
					return false;

				NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

				return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key);
			}
		}
		return false;
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		tags.setBoolean(key, true);

		int modifiers = tags.getInteger("Modifiers");
		modifiers -= 1;
		tags.setInteger("Modifiers", modifiers);

		int attack = tags.getInteger("Attack");
		attack -= 3;
		if(attack < 0)
			attack = 0;
		tags.setInteger("Attack", attack);

		addToolTip(tool, color + tooltipName, color + key);
	}

	void updateModTag(ItemStack tool, int[] keys)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		String tip = "ModifierTip" + keys[2];
		String modName = color + guiType + " (" + keys[0] + "/" + keys[1] + ")";
		tags.setString(tip, modName);
	}
}
