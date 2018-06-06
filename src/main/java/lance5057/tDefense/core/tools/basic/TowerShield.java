package lance5057.tDefense.core.tools.basic;

import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.bases.Shield;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class TowerShield extends Shield
{
	int	induceDamage	= 0;

	public TowerShield()
	{
		super(PartMaterialType.handle(TinkerTools.toughToolRod),
			new PartMaterialType(TinkerTools.largePlate, ShieldMaterialStats.TYPE),
			new PartMaterialType(TinkerTools.largePlate, ShieldMaterialStats.TYPE),
			PartMaterialType.extra(TDParts.rivets));
		setUnlocalizedName("towershield");
	}
}
