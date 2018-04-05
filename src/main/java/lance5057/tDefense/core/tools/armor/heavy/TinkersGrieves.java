package lance5057.tDefense.core.tools.armor.heavy;

import java.util.List;

import lance5057.tDefense.core.materials.ArmorMaterialStats.ClothMaterialStats;
import lance5057.tDefense.core.materials.ArmorMaterialStats.LegsMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersGrieves;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.util.ArmorNBT;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersGrieves extends ArmorCore
{
	public TinkersGrieves()
	{
		super(new PartMaterialType(TDParts.armorPlate, LegsMaterialStats.TYPE), 
			new PartMaterialType(TDParts.chainmail, LegsMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE));
		setUnlocalizedName("tinkersgrieves");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, int layer)
	{
		String s = "";
		switch(layer)
		{
			case 0: s = "textures/armor/grieves/_grieves_plate.png"; break;
			case 1: s = "textures/armor/grieves/_grieves_chain.png"; break;
			case 2: s = "textures/armor/grieves/_grieves_trim.png"; break;
			case 3: s = "textures/armor/grieves/_grieves_cloth.png"; break;
		}
		return s;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack,
			EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default)
	{
		return new ModelTinkersGrieves(itemStack);
	}
	
	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultArmorTag(materials, LegsMaterialStats.TYPE);
	    return data.get();
	}
	
	@Override
	public EntityEquipmentSlot getArmorSlot(ItemStack stack, EntityEquipmentSlot armorType) {
		return EntityEquipmentSlot.LEGS;
	}
}
