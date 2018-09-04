package lance5057.tDefense.core.library.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lance5057.tDefense.core.library.ArmorTags;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IFinishingAnvil {
	public default void setPartsToNBT(ItemStack stack, Map<String, Boolean> parts)
	{
		NBTTagCompound tag = new NBTTagCompound();
		NBTTagCompound partsTag = new NBTTagCompound();
		tag.setTag(ArmorTags.ModelParts, partsTag);
		
		for(String key: parts.keySet())
		{
			partsTag.setBoolean(key, parts.get(key));
		}
		
		NBTTagCompound item = stack.getTagCompound();
		item.setTag(ArmorTags.AnvilBase, tag);
		stack.setTagCompound(item);
	}
	
	public default Map<String, Boolean> init(ItemStack stack, List<ModelRenderer> boxes)
	{
		Map<String, Boolean> partsList = new HashMap<String, Boolean>();
		
		for(ModelRenderer box: boxes)
		{
			partsList.put(box.boxName, true);
		}
		
		setPartsToNBT(stack, partsList);
		
		return partsList;
	}
}
