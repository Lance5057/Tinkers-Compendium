package lance5057.tDefense.core.tools.modifiers.shields;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModBoolean;

public class modifierCrestofMirrors extends ModBoolean 
{
    String tooltipName;
    String guiType;

    public modifierCrestofMirrors(String type, int effect, ItemStack[] items, int[] values)
    {
    	super(items, effect, "Mirrors", "\u00A7", "");
        tooltipName = "\u00A7bCrest of Mirrors";
        guiType = type;
    }

    @Override
    protected boolean canModify (ItemStack tool, ItemStack[] input)
    {
    	if (tool.getItem() instanceof ToolCore)
        {
    		List list = Arrays.asList(((ToolCore)tool.getItem()).getTraits());
    		if (list.contains("shield"))
    		{
    			
    			NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
            
            if (tags.hasKey(key))
                return false;
            
            return true;
    		}
        }
    	return false;
        
    }

    @Override
    public void modify (ItemStack[] input, ItemStack tool)
    {
    	NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
        tags.setBoolean(key, true);
        
        int modifiers = tags.getInteger("Modifiers");
        modifiers -= 1;
        tags.setInteger("Modifiers", modifiers);
        
        addToolTip(tool, "\u00A7b" + tooltipName, "\u00A7b" + key);
    }

    void updateModTag (ItemStack tool, int[] keys)
    {
        NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
        String tip = "ModifierTip" + keys[2];
        String modName = "\u00A7b" + guiType;
        tags.setString(tip, modName);
    }
}
