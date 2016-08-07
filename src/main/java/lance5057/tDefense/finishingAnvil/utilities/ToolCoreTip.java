package lance5057.tDefense.finishingAnvil.utilities;

import java.util.ArrayList;
import java.util.List;

public class ToolCoreTip
{
	String			head		= "";
	String			handle		= "";
	String			accessory	= "";
	String			extra		= "";

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
			case 1:
				return head;
			case 3:
				return handle;
			case 2:
				return accessory;
			case 4:
				return extra;
			default:
				return "";
		}
	}

	public String getPartName(int partId /*1-4*/, int id)
	{
		switch(partId)
		{
			case 1:
				if(headTT.size() > 0 && headTT.size() - 1 >= id && headTT.get(id) != null)
					return headTT.get(id);
			case 3:
				if(handleTT.size() > 0 && handleTT.size() - 1 >= id && handleTT.get(id) != null)
					return handleTT.get(id);
			case 2:
				if(accessoryTT.size() > 0 && accessoryTT.size() - 1 >= id && accessoryTT.get(id) != null)
					return accessoryTT.get(id);
			case 4:
				if(extraTT.size() > 0 && extraTT.size() - 1 >= id && extraTT.get(id) != null)
					return extraTT.get(id);
			default:
				return "";
		}
	}
}
