package lance5057.tDefense.core.tools.modifiers.shields;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ItemModTypeFilter;

public class modifierCrestofFeathers extends ItemModTypeFilter
{
    String tooltipName;
    int max = 10;
    String guiType;

    public modifierCrestofFeathers(String type, int effect, ItemStack[] items, int[] values)
    {
        super(effect, "Feathers", items, values);
        tooltipName = "\u00A7fCrest of Feathers";
        guiType = type;
    }

    @Override
    protected boolean canModify (ItemStack tool, ItemStack[] input)
    {
        NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
        if (!tags.hasKey(key))
            return tags.getInteger("Modifiers") > 0 && matchingAmount(input) <= max;

        if (matchingAmount(input) > max)
            return false;

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
        int[] keyPair;
        int current = 0;
        if (tags.hasKey(key))
        {
            keyPair = tags.getIntArray(key);

            if (keyPair[0] % max == 0)
            {
                keyPair[0] += increase;
                keyPair[1] += max;
                tags.setIntArray(key, keyPair);

                int modifiers = tags.getInteger("Modifiers");
                modifiers -= 1;
                tags.setInteger("Modifiers", modifiers);
            }
            else
            {
                keyPair[0] += increase;
                tags.setIntArray(key, keyPair);
            }
            updateModTag(tool, keyPair);

        }
        else
        {
            int modifiers = tags.getInteger("Modifiers");
            modifiers -= 1;
            tags.setInteger("Modifiers", modifiers);
            String modName = "\u00A76" + guiType + " (" + increase + "/" + max + ")";
            int tooltipIndex = addToolTip(tool, tooltipName, modName);
            keyPair = new int[] { increase, max, tooltipIndex };
            tags.setIntArray(key, keyPair);
        }
        
        int miningSpeed = tags.getInteger("MiningSpeed");
        int boost = 8 + ((current - 1) / 50 * 2);
        Item temp = tool.getItem();
        if (temp instanceof ToolCore)
        {
            ToolCore toolcore = (ToolCore) temp;
            if (toolcore.durabilityTypeHandle() == 2)
                boost += 2;
            if (toolcore.durabilityTypeAccessory() == 2)
                boost += 2;
            if (toolcore.durabilityTypeExtra() == 2)
                boost += 2;
        }
        miningSpeed += (increase * boost);
        tags.setInteger("MiningSpeed", miningSpeed);

        String[] type = { "MiningSpeed2", "MiningSpeedHandle", "MiningSpeedExtra" };

        for (int i = 0; i < 3; i++)
        {
            if (tags.hasKey(type[i]))
            {
                int speed = tags.getInteger(type[i]);
                speed += (increase * boost);
                tags.setInteger(type[i], speed);
            }
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
