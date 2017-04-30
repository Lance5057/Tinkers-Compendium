package lance5057.tDefense.baubles;

import lance5057.tDefense.baubles.tools.TDBaubles;
import lance5057.tDefense.util.ModuleBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BaublesBase extends ModuleBase
{
	public static BaublesBase instance = new BaublesBase();
	
	
	public static BaublesItems items;
	public static TDBaubles tools;
	
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		items = new BaublesItems();
		tools = new TDBaubles();
		
		items.preInit(e);
		tools.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		items.init(e);
		tools.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		items.postInit(e);
		tools.postInit(e);
	}
}
