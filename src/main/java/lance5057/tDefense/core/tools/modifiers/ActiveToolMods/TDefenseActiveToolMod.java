package lance5057.tDefense.core.tools.modifiers.ActiveToolMods;

import lance5057.tDefense.core.tools.modifiers.Modifiers;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.tools.ToolCore;

public class TDefenseActiveToolMod extends ActiveToolMod
{
	Modifiers	mods	= new Modifiers();

	// BotaniaToolMods FlowerMods = new BotaniaToolMods();

	@Override
	public void updateTool(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("InfiTool"))
		{
			final NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");

			if(!tags.getBoolean("Broken"))
			{
				// TDefense
				mods.UpdateAll(tool, stack, world, entity, tags);
			}
		}
	}
}
