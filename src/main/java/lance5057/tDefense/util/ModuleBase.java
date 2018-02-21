package lance5057.tDefense.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class ModuleBase 
{	
	public abstract void preInit(FMLPreInitializationEvent e);
	
	public abstract void init(FMLInitializationEvent e);
	
	public abstract void postInit(FMLPostInitializationEvent e);
}
