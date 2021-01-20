package lance5057.tDefense.core.tools.basic;

import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.bases.Shield;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;
import c4.conarm.common.ConstructsRegistry;

public class RoundShield extends Shield
{
	int	induceDamage	= 0;

	public RoundShield()
	{
	    super(PartMaterialType.handle(TinkerTools.toolRod),
	    	new PartMaterialType(ConstructsRegistry.armorPlate, ShieldMaterialStats.TYPE),
	            PartMaterialType.head(ConstructsRegistry.armorTrim));
		setUnlocalizedName("roundshield");
	}
}
