package lance5057.tDefense.core.tools.modifiers;

import lance5057.tDefense.core.items.MetaModifierItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import tconstruct.library.tools.ToolCore;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class ModifiersBase
{
	public MetaModifierItem	modItems;
	public String[]			itemStrings;
	public String			name;

	public ModifiersBase(String[] strings, String name)
	{
		itemStrings = strings;
		this.name = name;

		MinecraftForge.EVENT_BUS.register(this);
		LoadItems();
	}

	public void LoadItems()
	{
		if(itemStrings != null && name != null)
		{
			modItems = new MetaModifierItem(name, itemStrings.length,
					itemStrings);
			GameRegistry.registerItem(modItems, name);
		}
	}

	public abstract void RegisterRecipes();

	public abstract void RegisterModifiers();

	public abstract void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags);
}
