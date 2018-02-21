package lance5057.tDefense.core.tools.basic;

import lance5057.tDefense.core.materials.ShieldMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.bases.Shield;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class RoundShield extends Shield
{
	int	induceDamage	= 0;

	public RoundShield()
	{
	    super(PartMaterialType.handle(TinkerTools.toolRod),
	    	new PartMaterialType(TDParts.armorPlate, ShieldMaterialStats.TYPE),
	            PartMaterialType.head(TinkerTools.panHead));
		setUnlocalizedName("roundshield");
	}
}
