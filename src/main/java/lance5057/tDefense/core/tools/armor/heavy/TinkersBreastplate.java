package lance5057.tDefense.core.tools.armor.heavy;

import lance5057.tDefense.core.materials.ChestMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class TinkersBreastplate extends ArmorCore
{
	public TinkersBreastplate()
	{
		super(new PartMaterialType(TinkerTools.largePlate, ChestMaterialStats.TYPE), 
			new PartMaterialType(TDParts.armorPlate, ChestMaterialStats.TYPE), 
				PartMaterialType.handle(TDParts.filigree),
				PartMaterialType.extra(TDParts.chainmail));
		setUnlocalizedName("tinkersbreastplate");
	}

	@Override
	public String getArmorTexture(ItemStack stack, int layer)
	{
		String s = "";
		switch(layer)
		{
			case 0: s = "textures/armor/breastplate/_breastplate_plate.png"; break;
			case 1: s = "textures/armor/breastplate/_breastplate_smallplate.png"; break;
			case 2: s = "textures/armor/breastplate/_breastplate_trim.png"; break;
			case 3: s = "textures/armor/breastplate/_breastplate_chain.png"; break;
		}
		return s;
	}

	@Override
	public ModelBiped getArmorModel(ItemStack stack)
	{
		return new ModelTinkersBreastplate(stack);
	}
}
