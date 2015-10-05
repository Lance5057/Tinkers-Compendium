package lance5057.tDefense.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.crafting.PatternBuilder.MaterialSet;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;

public class Injector extends ToolCore
{

	ToolCore tool;
	
	public Injector(int baseDamage, ToolCore tool) {
		super(baseDamage);
		this.tool = tool;
	}

	List<String> heads = new ArrayList<String>();
	List<String> accessorys= new ArrayList<String>();
	List<String> handles = new ArrayList<String>();
	List<String> extras = new ArrayList<String>();
	
	protected void loadHeads(IIconRegister iconRegister)
	{				
		IIcon origHead = TinkerTools.broadsword.headIcons.get(-1);
		IIcon origAccessory = TinkerTools.broadsword.accessoryIcons.get(-1);
		IIcon origHandle = TinkerTools.broadsword.handleIcons.get(-1);
		
		//File[] icons = new File("tinkersdefense:items/" + tool.getDefaultFolder()).listFiles();
		ResourceLocation icons = new ResourceLocation("tinkersdefense", tool.getDefaultFolder());
		String test = icons.toString();
		for(int i = 0; i<heads.size(); i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
		        icon += TinkerTools.broadsword.getDefaultFolder() + "/" + entry.getKey().toLowerCase() + "/" + heads.get(i);
		        //toolIcons[i] = icon;
		        headStrings.put(entry.getValue().materialID+(TinkersDefense.config.MaterialIndex*(i+1)), icon);
			}
			
			addIcons(headStrings, headIcons, iconRegister, heads.get(i), false);
			
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
		
		for(int i = 0; i<accessorys.size(); i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
		        icon += TinkerTools.broadsword.getDefaultFolder() + "/" + entry.getKey().toLowerCase() + "/" + accessorys.get(i);
		        //toolIcons[i] = icon;
		        accessoryStrings.put(entry.getValue().materialID+(TinkersDefense.config.MaterialIndex*(i+1)), icon);
			}
			
			addIcons(accessoryStrings, accessoryIcons, iconRegister, accessorys.get(i), false);
			
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
		
		for(int i = 0; i<handles.size(); i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
		        icon += TinkerTools.broadsword.getDefaultFolder() + "/" + entry.getKey().toLowerCase() + "/" + handles.get(i);
		        //toolIcons[i] = icon;
		        handleStrings.put(entry.getValue().materialID+(TinkersDefense.config.MaterialIndex*(i+1)), icon);
			}
			
			addIcons(handleStrings, handleIcons, iconRegister, handles.get(i), false);
			
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
