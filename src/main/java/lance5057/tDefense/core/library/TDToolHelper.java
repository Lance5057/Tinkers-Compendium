package lance5057.tDefense.core.library;

import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagList;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TDToolHelper {

	public static boolean checkIfMetal(ItemStack item) {
		
		if(item.getItem() instanceof ArmorCore)
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
				
				if(i.getToolMaterialName() != "WOOD" ||
						i.getToolMaterialName() != "STONE")
				{
					
				}
			}
		}

		return false;
	}

}
