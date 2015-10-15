package lance5057.tDefense.core.tools.modifiers.weapons;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ItemModTypeFilter;

public class modifierDaze extends ItemModTypeFilter
{
    String tooltipName;
    int max = 5;
    String guiType;

    public modifierDaze(String type, int effect, ItemStack[] items, int[] values)
    {
        super(effect, "Daze", items, values);
        tooltipName = "\u00A76Daze";
        guiType = type;
    }

    @Override
    protected boolean canModify (ItemStack tool, ItemStack[] input)
    {
    	if (tool.getItem() instanceof ToolCore)
        {
    		List list = Arrays.asList(((ToolCore)tool.getItem()).getTraits());
    		if (list.contains("weapon"))
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
    		}
        }

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
            int[] keyPair = new int[] { increase, max, tooltipIndex };
            tags.setIntArray(key, keyPair);
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