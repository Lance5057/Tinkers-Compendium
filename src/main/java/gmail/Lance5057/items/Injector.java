package gmail.Lance5057.items;

import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class Injector extends Item
{
	int headsIndex;
	int accessoryIndex;
	int handleIndex;
	int extraIndex;
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		Inject(TinkerTools.broadsword, iconRegister);
	}
	
	protected void Inject(ToolCore tc, IIconRegister iconRegister)
	{		
		tc.accessoryStrings.clear();
		tc.accessoryStrings.put(19, "tinkersdefense:broadsword/_smallguard");
		
		
		tc.registerIcons(iconRegister);
	}
}
