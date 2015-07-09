package gmail.Lance5057;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class TD_Config
{
	public int AeonsteelMatID;	
	public int QueensGoldMatID;	
	public int DogbeariumMatID;
	
	public int DazeID;
	public int CrestFeathersID;
	public int CrestMirrorsID;
	
	public TD_Config(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
		config.load();
		
		AeonsteelMatID = config.get("Material Configs", "Aeonsteel Material ID", 201).getInt();
		QueensGoldMatID = config.get("Material Configs", "QueensGold Material ID", 202).getInt();
		DogbeariumMatID = config.get("Material Configs", "Dogbearium Material ID", 203).getInt();
		
		DazeID = config.get("Modifier Configs", "Daze ID", 18).getInt();
		CrestFeathersID = config.get("Modifier Configs", "Crest of Feathers ID", 19).getInt();
		CrestMirrorsID = config.get("Modifier Configs", "Crest of Mirrors ID", 20).getInt();
		
		config.save();
	}
}
