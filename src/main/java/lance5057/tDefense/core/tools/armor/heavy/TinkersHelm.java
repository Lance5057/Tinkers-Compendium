package lance5057.tDefense.core.tools.armor.heavy;

import lance5057.tDefense.core.materials.HelmMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class TinkersHelm extends ArmorCore
{
	public TinkersHelm()
	{
		super(new PartMaterialType(TinkerTools.panHead, HelmMaterialStats.TYPE), 
			new PartMaterialType(TDParts.armorPlate, HelmMaterialStats.TYPE), 
				PartMaterialType.handle(TDParts.filigree),
				PartMaterialType.extra(TDParts.chainmail));
		setUnlocalizedName("tinkershelm");
	}
}
