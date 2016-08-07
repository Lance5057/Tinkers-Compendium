package lance5057.tDefense.core.tools.modifiers;

import java.util.Arrays;
import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModLapis;

public class modLapisShears extends ModLapis
{

	public modLapisShears(int effect, ItemStack[] items, int[] values)
	{
		super(effect, items, values);
	}

	@Override
	public void modify(ItemStack[] input, ItemStack tool)
	{
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		if(!tags.hasKey(key))
		{
			tags.setBoolean(key, true);

			final String modName = "\u00a79Lapis (0/450)";
			final int tooltipIndex = addToolTip(tool, "\u00a79Luck", modName);
			final int[] keyPair = new int[] {0, tooltipIndex};
			tags.setIntArray(key, keyPair);

			int modifiers = tags.getInteger("Modifiers");
			modifiers -= 1;
			tags.setInteger("Modifiers", modifiers);
		}

		final int increase = matchingAmount(input);
		final int keyPair[] = tags.getIntArray(key);
		keyPair[0] += increase;
		tags.setIntArray(key, keyPair);
		final ToolCore toolcore = (ToolCore) tool.getItem();
		final String[] types = toolcore.getTraits();
		boolean harvest = false;
		for(final String s : types)
		{
			if(s.equals("shears"))
			{
				harvest = true;
			}
		}
		if(harvest)
		{
			if(keyPair[0] >= 450)
			{
				addEnchantment(tool, Enchantment.fortune, 3);
			}
			else if(keyPair[0] >= 300)
			{
				addEnchantment(tool, Enchantment.fortune, 2);
			}
			else if(keyPair[0] >= 100)
			{
				addEnchantment(tool, Enchantment.fortune, 1);
			}
		}

		updateModTag2(tool, keyPair);
	}

	void updateModTag2(ItemStack tool, int[] keys)
	{
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		final String tip = "ModifierTip" + keys[1];
		final String modName = "\u00a79Lapis (" + keys[0] + "/" + "450" + ")";
		tags.setString(tip, modName);
	}

	@Override
	public boolean validType(ToolCore tool)
	{
		final List list = Arrays.asList(tool.getTraits());
		return list.contains("shears");
	}
}
