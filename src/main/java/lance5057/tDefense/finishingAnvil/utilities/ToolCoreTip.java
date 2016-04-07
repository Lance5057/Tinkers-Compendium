package lance5057.tDefense.finishingAnvil.utilities;

import java.util.ArrayList;
import java.util.List;

public class ToolCoreTip
{	
	String head;
	String handle;
	String accessory;
	String extra;
	
	List<String>	headTT		= new ArrayList<String>();
	List<String>	accessoryTT	= new ArrayList<String>();
	List<String>	handleTT	= new ArrayList<String>();
	List<String>	extraTT		= new ArrayList<String>();
	
	public ToolCoreTip()
	{
	}
	
	public String getPart(int id /*1-4*/)
	{
		switch(id)
		{
			case 1: return head;
			case 2: return handle;
			case 3: return accessory;
			case 4: return extra;
			default: return "";
		}
	}
	
	public String getPartName(int partId /*1-4*/, int id)
	{
		switch(partId)
		{
			case 1: return headTT.get(id);
			case 2: return handleTT.get(id);
			case 3: return accessoryTT.get(id);
			case 4: return extraTT.get(id);
			default: return "";
		}
	}
}
