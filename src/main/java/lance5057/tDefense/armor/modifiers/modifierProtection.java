package lance5057.tDefense.armor.modifiers;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.modifier.ItemModifier;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModInteger;


public class modifierProtection extends ModInteger
{
	String color;
    String tooltipName = "";
    int initialIncrease;
    int secondaryIncrease;
	
    public modifierProtection(ItemStack[] items, int effect, int increase, String c)
    {
        super(items, effect, "Protection", increase, c, "Protection");
        color = c;
    }

    @Override
    protected boolean canModify (ItemStack tool, ItemStack[] input)
    {
    	if (tool.getItem() instanceof ToolCore)
        {
    		List list = Arrays.asList(((ToolCore)tool.getItem()).getTraits());
    		if (list.contains("heavyarmor") || list.contains("lightarmor"))
    		{
    			return true;
    		}	
        }
    	return false;
    }
    
    @Override
    public void modify (ItemStack[] input, ItemStack tool)
    {
        NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
        if (tags.hasKey(key))
        {
            int increase = tags.getInteger(key);
            increase += secondaryIncrease;
            tags.setInteger(key, increase);
        }
        else
        {
            tags.setInteger(key, initialIncrease);
        }

        int modifiers = tags.getInteger("Modifiers");
        modifiers -= 1;
        tags.setInteger("Modifiers", modifiers);

        int prot = tags.getInteger("Protection");
        prot += 1;
        tags.setInteger("Protection", prot);

        addToolTip(tool, color + tooltipName, color + key);
    }

    protected int addToolTip (ItemStack tool, String tooltip, String modifierTip)
    {
        NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
        int tipNum = 0;
        while (true)
        {
            tipNum++;
            String tip = "Tooltip" + tipNum;
            if (!tags.hasKey(tip))
            {
                tags.setString(tip, "");
                String modTip = "ModifierTip" + tipNum;
                String tag = tags.getString(modTip);
                tags.setString(modTip, getProperName(modifierTip, tag));
                return tipNum;
            }
            else
            {
                String modTip = "ModifierTip" + tipNum;
                String tag = tags.getString(modTip);
                if (tag.contains(modifierTip))
                {
                    tags.setString(tip, "");
                    tag = tags.getString(modTip);
                    tags.setString(modTip, getProperName(modifierTip, tag));
                    return tipNum;
                }
            }
        }
    }
}