package lance5057.tDefense.core.tools.armor.light;

import java.util.List;

import lance5057.tDefense.core.materials.ArmorMaterialStats.ClothMaterialStats;
import lance5057.tDefense.core.materials.ArmorMaterialStats.FeetMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.light.ModelTinkersBoots;
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

public class TinkersBoots extends ArmorCore
{
	public TinkersBoots()
	{
		super(new PartMaterialType(TDParts.chainmail, FeetMaterialStats.TYPE), 
			new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE), 
			PartMaterialType.handle(TDParts.rivets));
		setUnlocalizedName("tinkersboots");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, int layer)
	{
		String s = "";
		switch(layer)
		{
			case 0: s = "textures/armor/boots/_boots_chain.png"; break;
			case 1: s = "textures/armor/boots/_boots_cloth.png"; break;
			case 2: s = "textures/armor/boots/_boots_rivet.png"; break;
		}
		return s;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack,
			EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default)
	{
		return new ModelTinkersBoots(itemStack);
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultArmorTag(materials, FeetMaterialStats.TYPE);
	    return data.get();
	}
	
	@Override
	public EntityEquipmentSlot getArmorSlot(ItemStack stack, EntityEquipmentSlot armorType) {
		return EntityEquipmentSlot.FEET;
	}
}
