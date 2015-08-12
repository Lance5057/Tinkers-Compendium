package gmail.Lance5057.items;

import gmail.Lance5057.TinkersDefense;

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
	}

	String[] heads;
	String[] accessorys;
	String[] handles;
	String[] extras;
	
	protected void loadHeads(IIconRegister iconRegister)
	{		
		heads = new String[6];
		
		heads[0] = "_tapered_blade";
//		heads[1] = "_dull_blade";
//		heads[2] = "_glass_blade";
//		heads[3] = "_plumed_blade";
//		heads[4] = "_widebase_blade";
//		heads[5] = "_tapered_blade";
		
		for(int i = 0; i<heads.length; i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String test = entry.getKey();
				String icon = "tinker:";
		        icon += TinkerTools.broadsword.getDefaultFolder() + "/";
		        icon += test + heads[i];
		        //toolIcons[i] = icon;
		        headStrings.put(entry.getValue().materialID+TinkersDefense.config.MaterialIndex, icon);
			}
			
			addIcons(headStrings, headIcons, iconRegister, heads[i], false);
			TinkerTools.broadsword.headStrings.putAll(headStrings);
			TinkerTools.broadsword.headIcons.putAll(headIcons);
		}
	}
	
	@Override
    public void registerIcons (IIconRegister iconRegister)
    {
		loadHeads(iconRegister);
    }

	@Override
	public Item getAccessoryItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultFolder() {
		// TODO Auto-generated method stub
		return "broadsword";
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
