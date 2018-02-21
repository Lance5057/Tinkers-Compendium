package lance5057.tDefense.core.tools.basic;

import lance5057.tDefense.core.materials.ShieldMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.bases.Shield;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class HeaterShield extends Shield
{
	int	induceDamage	= 0;

	public HeaterShield()
	{
		super(PartMaterialType.handle(TinkerTools.toughToolRod),
			new PartMaterialType(TDParts.armorPlate, ShieldMaterialStats.TYPE),
			new PartMaterialType(TDParts.armorPlate, ShieldMaterialStats.TYPE),
			PartMaterialType.extra(TDParts.rivets));
		setUnlocalizedName("heatershield");
	}
}
