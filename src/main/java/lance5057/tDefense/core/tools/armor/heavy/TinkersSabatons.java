package lance5057.tDefense.core.tools.armor.heavy;

import lance5057.tDefense.core.materials.BootsMaterialStats;
import lance5057.tDefense.core.materials.ClothMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersSabatons;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersSabatons extends ArmorCore
{
	public TinkersSabatons()
	{
		super(new PartMaterialType(TDParts.armorPlate, BootsMaterialStats.TYPE), 
			new PartMaterialType(TDParts.armorPlate, BootsMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE));
		setUnlocalizedName("tinkerssabatons");
	}

	@Override
	public String getArmorTexture(ItemStack stack, int layer)
	{
		String s = "";
		switch(layer)
		{
			case 0: s = "textures/armor/sabatons/_sabatons_plates.png"; break;
			case 1: s = "textures/armor/sabatons/_sabatons_caps.png"; break;
			case 2: s = "textures/armor/sabatons/_sabatons_trim.png"; break;
			case 3: s = "textures/armor/sabatons/_sabatons_soles.png"; break;
		}
		return s;
	}

	@Override
	public ModelBiped getArmorModel(ItemStack stack)
	{
		return new ModelTinkersSabatons(stack);
	}
}
