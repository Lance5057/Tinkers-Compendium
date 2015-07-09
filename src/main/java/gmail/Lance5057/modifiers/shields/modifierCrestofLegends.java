package gmail.Lance5057.modifiers.shields;

import tconstruct.modifiers.tools.ItemModTypeFilter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class modifierCrestofLegends extends ItemModTypeFilter
{
    String tooltipName;
    String guiType;

    public modifierCrestofLegends(String type, int effect, ItemStack[] items, int[] values)
    {
        super(effect, "Legends", items, values);
        tooltipName = "\u00A7fCrest of Legends";
        guiType = type;
    }

    @Override
    protected boolean canModify (ItemStack tool, ItemStack[] input)
    {
        NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

        int keyPair[] = tags.getIntArray(key);
        if (keyPair[0] + matchingAmount(input) <= keyPair[1])
            return true;

        else if (keyPair[0] == keyPair[1])
            return tags.getInteger("Modifiers") > 0;

        else
            return false;
    }

    @Override
    public void modify (ItemStack[] input, ItemStack tool)
    {
        NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
        int increase = matchingAmount(input);
        if (tags.hasKey(key))
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

    void updateModTag (ItemStack tool, int[] keys)
    {
        NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
        String tip = "ModifierTip" + keys[2];
        String modName = "\u00A76" + guiType + " (" + keys[0] + "/" + keys[1] + ")";
        tags.setString(tip, modName);
    }
}
