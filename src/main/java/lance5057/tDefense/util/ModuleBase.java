package lance5057.tDefense.util;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public abstract class ModuleBase 
{
	protected ItemsBase items;
	
	public void preInit()
	{
		items.preInit();
	}
	
	public void init()
	{
		items.init();
	}
}
