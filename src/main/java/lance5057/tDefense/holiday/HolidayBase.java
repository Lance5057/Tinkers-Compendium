package lance5057.tDefense.holiday;

import lance5057.tDefense.holiday.xmas.XmasBase;
import lance5057.tDefense.util.ModuleBase;

public class HolidayBase 
{
	ModuleBase xmas;
	
	public HolidayBase()
	{
		xmas = new XmasBase();
	}
	
	public void preInit()
	{
		xmas.preInit();
	}
	
	public void init()
	{
		xmas.init();
	}
}
