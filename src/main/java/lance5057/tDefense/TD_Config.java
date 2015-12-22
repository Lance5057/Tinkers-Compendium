package lance5057.tDefense;

import java.util.Vector;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class TD_Config
{
	public int AeonsteelMatID;	
	public int QueensGoldMatID;	
	public int DogbeariumMatID;
	public int RedMintMatID;
	public int GreenMintMatID;
	
	public int DazeID;
	public int CrestFeathersID;
	public int CrestMirrorsID;
	public int CrestLegendsID;
	public int CrestBladesID;
	
	public int MaterialIndex;
	
	public TD_Config(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
		config.load();
		
		AeonsteelMatID = config.get("Material Configs", "Aeonsteel Material ID", 201).getInt();
		QueensGoldMatID = config.get("Material Configs", "QueensGold Material ID", 202).getInt();
		DogbeariumMatID = config.get("Material Configs", "Dogbearium Material ID", 203).getInt();
		RedMintMatID = config.get("Material Configs", "RedMint Material ID", 204).getInt();
		GreenMintMatID = config.get("Material Configs", "GreenMint Material ID", 205).getInt();

		DazeID = config.get("Modifier Configs", "Daze ID", 18).getInt();
		CrestFeathersID = config.get("Modifier Configs", "Crest of Feathers ID", 19).getInt();
		CrestMirrorsID = config.get("Modifier Configs", "Crest of Mirrors ID", 20).getInt();
		CrestLegendsID = config.get("Modifier Configs", "Crest of Legends ID", 21).getInt();
		CrestLegendsID = config.get("Modifier Configs", "Crest of Legends ID", 22).getInt();
		
		MaterialIndex = config.get("Material Index", "Highest material ID - TDefense - 204 MFR - 1001 ExtraTIC - 1024", 204).getInt();
		
		
		
		config.save();
	}
}
