package lance5057.tDefense.finishingAnvil.utilities;

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

public class Injector extends ToolCore
{

	ToolCore			tool;

	InjectorLocations	injectLoc;

	List<String>		heads		= new ArrayList<String>();
	List<String>		accessorys	= new ArrayList<String>();
	List<String>		handles		= new ArrayList<String>();
	List<String>		extras		= new ArrayList<String>();

	public Injector(int baseDamage, ToolCore tool, InjectorLocations injLoc)
	{
		super(0);
		this.tool = tool;

		injectLoc = injLoc;

		List<String> temp = injectLoc.getList(tool.getUnlocalizedName().substring(tool.getUnlocalizedName().lastIndexOf('.') + 1, tool.getUnlocalizedName().length()));

		if(!temp.isEmpty())
		{
			for(int i = 0; i < temp.size(); i++)
			{
				if(temp.get(i).contains("head"))
				{
					heads.add(temp.get(i));
				}
				if(temp.get(i).contains("accessory"))
				{
					accessorys.add(temp.get(i));
				}
				if(temp.get(i).contains("handle"))
				{
					handles.add(temp.get(i));
				}
				if(temp.get(i).contains("extra"))
				{
					extras.add(temp.get(i));
				}
			}
		}
	}

	protected void loadHeads(IIconRegister iconRegister)
	{
		IIcon origHead = tool.headIcons.get(-1);
		IIcon origAccessory = tool.accessoryIcons.get(-1);
		IIcon origHandle = tool.handleIcons.get(-1);
		IIcon origExtra = tool.handleIcons.get(-1);

		//File[] icons = new File("tinkersdefense:items/" + tool.getDefaultFolder()).listFiles();

		ResourceLocation icons = new ResourceLocation("tinkersdefense", tool.getDefaultFolder());
		String test = icons.toString();
		for(int i = 0; i < heads.size(); i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
				icon += tool.getDefaultFolder() + "/" + entry.getKey().toLowerCase() + "/" + heads.get(i);
				//toolIcons[i] = icon;
				headStrings.put(entry.getValue().materialID + (TinkersDefense.config.MaterialIndex * (i + 1)), icon);
			}

			addIcons(tool.headStrings, headIcons, iconRegister, heads.get(i), false);

			for(int j = (i + 1) * TinkersDefense.config.MaterialIndex; j < TinkersDefense.config.MaterialIndex + ((i + 1) * TinkersDefense.config.MaterialIndex); j++)
			{
				if(!headIcons.containsKey(j))
				{
					headIcons.put(j, headIcons.get(-1));
				}
			}

			tool.headStrings.putAll(headStrings);
			tool.headIcons.putAll(headIcons);
		}

		for(int i = 0; i < accessorys.size(); i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
				icon += tool.getDefaultFolder() + "/" + entry.getKey().toLowerCase() + "/" + accessorys.get(i);
				//toolIcons[i] = icon;
				accessoryStrings.put(entry.getValue().materialID + (TinkersDefense.config.MaterialIndex * (i + 1)), icon);
			}

			addIcons(accessoryStrings, accessoryIcons, iconRegister, accessorys.get(i), false);

			for(int j = (i + 1) * TinkersDefense.config.MaterialIndex; j < TinkersDefense.config.MaterialIndex + ((i + 1) * TinkersDefense.config.MaterialIndex); j++)
			{
				if(!accessoryIcons.containsKey(j))
				{
					accessoryIcons.put(j, accessoryIcons.get(-1));
				}
			}

			tool.accessoryStrings.putAll(accessoryStrings);
			tool.accessoryIcons.putAll(accessoryIcons);
		}

		for(int i = 0; i < handles.size(); i++)
		{
			PatternBuilder pb = PatternBuilder.instance;
			for(Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
				icon += tool.getDefaultFolder() + "/" + entry.getKey().toLowerCase() + "/" + handles.get(i);
				//toolIcons[i] = icon;
				handleStrings.put(entry.getValue().materialID + (TinkersDefense.config.MaterialIndex * (i + 1)), icon);
			}

			addIcons(handleStrings, handleIcons, iconRegister, handles.get(i), false);

			for(int j = (i + 1) * TinkersDefense.config.MaterialIndex; j < TinkersDefense.config.MaterialIndex + ((i + 1) * TinkersDefense.config.MaterialIndex); j++)
			{
				if(!handleIcons.containsKey(j))
				{
					handleIcons.put(j, handleIcons.get(-1));
				}
			}

			tool.handleStrings.putAll(handleStrings);
			tool.handleIcons.putAll(handleIcons);
		}

		tool.headIcons.put(-1, origHead);
		tool.accessoryIcons.put(-1, origAccessory);
		tool.handleIcons.put(-1, origHandle);
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		loadHeads(iconRegister);
	}

	@Override
	public String getDefaultTexturePath()
	{
		return "tinkersdefense:" + getDefaultFolder();
	}

	@Override
	public Item getAccessoryItem()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultFolder()
	{
		// TODO Auto-generated method stub
		String s = tool.getDefaultFolder();
		return s;
	}

	@Override
	public String getEffectSuffix()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getHeadItem()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIconSuffix(int arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getTraits()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
