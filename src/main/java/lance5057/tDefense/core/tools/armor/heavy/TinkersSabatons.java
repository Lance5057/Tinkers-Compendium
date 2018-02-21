package lance5057.tDefense.core.tools.armor.heavy;

import java.util.List;

import lance5057.tDefense.core.materials.ArmorMaterialStats.ClothMaterialStats;
import lance5057.tDefense.core.materials.ArmorMaterialStats.FeetMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersSabatons;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.util.ArmorNBT;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersSabatons extends ArmorCore
{
	public TinkersSabatons()
	{
		super(new PartMaterialType(TDParts.armorPlate, FeetMaterialStats.TYPE), 
			new PartMaterialType(TDParts.armorPlate, FeetMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE));
		setUnlocalizedName("tinkerssabatons");
	}

	@SideOnly(Side.CLIENT)
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

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(ItemStack stack)
	{
		return new ModelTinkersSabatons(stack);
	}
	
	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultArmorTag(materials, FeetMaterialStats.TYPE);
	    return data.get();
	}
}
