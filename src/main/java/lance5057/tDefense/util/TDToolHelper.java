package lance5057.tDefense.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagList;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TDToolHelper {

	public static boolean checkIfMetal(ItemStack item) {
		
		if(item.getItem() instanceof ToolCore)
		{
			NBTTagList list = TagUtil.getBaseMaterialsTagList(item);
	
			for (int i = 0; i < list.tagCount(); i++) {
				String s = list.getStringTagAt(i);
				if (s != "obsidian") {
					Material m = TinkerRegistry.getMaterial(s);
					if(m.hasFluid())
						return true;
				}
			}
		}
		else
		{
			if(item.getItem() instanceof ItemTool)
			{
				ItemTool i = (ItemTool) item.getItem();
				
				if(i.getToolMaterial() != i.getToolMaterial().WOOD ||
						i.getToolMaterial() != i.getToolMaterial().STONE)
				{
					
				}
			}
		}

		return false;
	}

}
