package lance5057.tDefense.core.tools.armor.heavy;

import java.util.List;

import lance5057.tDefense.core.materials.ArmorMaterialStats.ChestMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.util.ArmorNBT;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.Material;
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

	@SideOnly(Side.CLIENT)
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

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(ItemStack stack)
	{
		return new ModelTinkersBreastplate(stack);
	}
	
	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultArmorTag(materials, ChestMaterialStats.TYPE);
	    return data.get();
	}
}
