package gmail.Lance5057.items;

import gmail.Lance5057.TinkersDefense;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.crafting.PatternBuilder.MaterialSet;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

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
		heads = new String[9];
		accessorys = new String[10];
		handles = new String[2];
		
		heads[0] = "_tapered_blade";
		heads[1] = "_dull_blade";
		heads[2] = "_glass_blade";
		heads[3] = "_plumed_blade";
		heads[4] = "_spiked_blade";
		heads[5] = "_widebase_blade";	
		heads[6] = "_mace_blade";
		heads[7] = "_elusive_blade";
		heads[8] = "_repulsive_blade";
		
		accessorys[0] = "_straight_guard";
		accessorys[1] = "_basket_guard";
		accessorys[2] = "_curved_guard";
		accessorys[3] = "_extended_guard";
		accessorys[4] = "_legendary_guard";
		accessorys[5] = "_queens_guard";
		accessorys[6] = "_square_guard";
		accessorys[7] = "_no_guard";
		accessorys[8] = "_elusive_guard";
		accessorys[9] = "_repulsive_guard";
		
		handles[0] = "_ornate_handle";
		handles[1] = "_thick_handle";
		
		IIcon origHead = TinkerTools.broadsword.headIcons.get(-1);
		IIcon origAccessory = TinkerTools.broadsword.accessoryIcons.get(-1);
		IIcon origHandle = TinkerTools.broadsword.handleIcons.get(-1);
		
		
		for(int i = 0; i<heads.length; i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
		        icon += TinkerTools.broadsword.getDefaultFolder() + "/" + entry.getKey().toLowerCase() + "/" + heads[i];
		        //toolIcons[i] = icon;
		        headStrings.put(entry.getValue().materialID+(TinkersDefense.config.MaterialIndex*(i+1)), icon);
			}
			
			addIcons(headStrings, headIcons, iconRegister, heads[i], false);
			
			for(int j = (i+1)*TinkersDefense.config.MaterialIndex; j<TinkersDefense.config.MaterialIndex + ((i+1)*TinkersDefense.config.MaterialIndex); j++)
			{
				if(!headIcons.containsKey(j))
				{
					headIcons.put(j, headIcons.get(-1));
				}
			}
			
			TinkerTools.broadsword.headStrings.putAll(headStrings);
			TinkerTools.broadsword.headIcons.putAll(headIcons);
		}
		
		for(int i = 0; i<accessorys.length; i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
		        icon += TinkerTools.broadsword.getDefaultFolder() + "/" + entry.getKey().toLowerCase() + "/" + accessorys[i];
		        //toolIcons[i] = icon;
		        accessoryStrings.put(entry.getValue().materialID+(TinkersDefense.config.MaterialIndex*(i+1)), icon);
			}
			
			addIcons(accessoryStrings, accessoryIcons, iconRegister, accessorys[i], false);
			
			for(int j = (i+1)*TinkersDefense.config.MaterialIndex; j<TinkersDefense.config.MaterialIndex + ((i+1)*TinkersDefense.config.MaterialIndex); j++)
			{
				if(!accessoryIcons.containsKey(j))
				{
					accessoryIcons.put(j, accessoryIcons.get(-1));
				}
			}
			
			TinkerTools.broadsword.accessoryStrings.putAll(accessoryStrings);
			TinkerTools.broadsword.accessoryIcons.putAll(accessoryIcons);
		}
		
		for(int i = 0; i<handles.length; i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
		        icon += TinkerTools.broadsword.getDefaultFolder() + "/" + entry.getKey().toLowerCase() + "/" + handles[i];
		        //toolIcons[i] = icon;
		        handleStrings.put(entry.getValue().materialID+(TinkersDefense.config.MaterialIndex*(i+1)), icon);
			}
			
			addIcons(handleStrings, handleIcons, iconRegister, handles[i], false);
			
			for(int j = (i+1)*TinkersDefense.config.MaterialIndex; j<TinkersDefense.config.MaterialIndex + ((i+1)*TinkersDefense.config.MaterialIndex); j++)
			{
				if(!handleIcons.containsKey(j))
				{
					handleIcons.put(j, handleIcons.get(-1));
				}
			}
			
			TinkerTools.broadsword.handleStrings.putAll(handleStrings);
			TinkerTools.broadsword.handleIcons.putAll(handleIcons);
		}
		
		TinkerTools.broadsword.headIcons.put(-1, origHead);
		TinkerTools.broadsword.accessoryIcons.put(-1, origAccessory);
		TinkerTools.broadsword.handleIcons.put(-1, origHandle);
	}
	
	@Override
    public void registerIcons (IIconRegister iconRegister)
    {
		loadHeads(iconRegister);
    }
	
	@Override
	 public String getDefaultTexturePath()
	    {
	        return "tinkersdefense:" + getDefaultFolder();
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
