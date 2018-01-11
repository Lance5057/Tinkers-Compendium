package lance5057.tDefense.core.tools.armor.heavy;

import lance5057.tDefense.core.materials.ClothMaterialStats;
import lance5057.tDefense.core.materials.LegsMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersGrieves extends ArmorCore
{
	public TinkersGrieves()
	{
		super(new PartMaterialType(TDParts.armorPlate, LegsMaterialStats.TYPE), 
			new PartMaterialType(TDParts.filigree, LegsMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE));
		setUnlocalizedName("tinkersgrieves");
	}
}
