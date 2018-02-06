package lance5057.tDefense.core.tools.armor.heavy;

import lance5057.tDefense.core.materials.HelmMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersHelm;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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

	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, int layer)
	{
		String s = "";
		switch(layer)
		{
			case 0: s = "textures/armor/helm/_helm_top.png"; break;
			case 1: s = "textures/armor/helm/_helm_plate.png"; break;
			case 2: s = "textures/armor/helm/_helm_visor.png"; break;
			case 3: s = "textures/armor/helm/_helm_chain.png"; break;
		}
		return s;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(ItemStack stack)
	{
		return new ModelTinkersHelm(stack);
	}
}
