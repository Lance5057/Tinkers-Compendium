package lance5057.tDefense.core.tools.armor.heavy;

import lance5057.tDefense.core.materials.BootsMaterialStats;
import lance5057.tDefense.core.materials.ClothMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersSabatons extends ArmorCore
{
	public TinkersSabatons()
	{
		super(new PartMaterialType(TDParts.armorPlate, BootsMaterialStats.TYPE), 
			new PartMaterialType(TDParts.armorPlate, BootsMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE));
		setUnlocalizedName("tinkershelm");
	}
}
