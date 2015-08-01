package gmail.Lance5057.items;

import java.util.Map;

import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.crafting.PatternBuilder.MaterialSet;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class Injector extends ToolCore
{
	public Injector(int baseDamage) {
		super(baseDamage);
		// TODO Auto-generated constructor stub
	}

	String[] heads;
	String[] accessorys;
	String[] handles;
	String[] extras;
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		Inject(TinkerTools.broadsword, iconRegister);
	}
	
	protected void Inject(ToolCore tc, IIconRegister iconRegister)
	{		
		tc.accessoryStrings.clear();
		tc.accessoryIcons.clear();
		
		PatternBuilder pb = PatternBuilder.instance;
		for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
		{
		String test = entry.getKey();
		String icon = "tinkersdefense:";
            icon += tc.getDefaultFolder() + "/";
        icon += test + "_smallguard";
        //toolIcons[i] = icon;
        tc.accessoryStrings.put(entry.getValue().materialID, icon);
		}
        
		//tc.accessoryStrings.put(0, "tinkersdefense:broadsword/_smallguard");
		
		tc.registerIcons(iconRegister);
	}

	@Override
	public Item getAccessoryItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEffectSuffix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getHeadItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIconSuffix(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getTraits() {
		// TODO Auto-generated method stub
		return null;
	}
}
