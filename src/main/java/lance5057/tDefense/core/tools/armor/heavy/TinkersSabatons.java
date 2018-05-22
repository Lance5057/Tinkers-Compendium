package lance5057.tDefense.core.tools.armor.heavy;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.materials.ArmorMaterialStats.ClothMaterialStats;
import lance5057.tDefense.core.materials.ArmorMaterialStats.FeetMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersSabatons;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.util.ArmorNBT;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersSabatons extends ArmorCore {
	public TinkersSabatons() {
		super(EntityEquipmentSlot.FEET,new PartMaterialType(TDParts.armorPlate, FeetMaterialStats.TYPE),
				new PartMaterialType(TDParts.armorPlate, FeetMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE));
		setUnlocalizedName("tinkerssabatons");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public List<String> getArmorTexture(ItemStack stack) {
		List<String> textures = new ArrayList();
		textures.add("textures/armor/sabatons/_sabatons_plates.png");
		textures.add("textures/armor/sabatons/_sabatons_caps.png");
		textures.add("textures/armor/sabatons/_sabatons_trim.png");
		textures.add("textures/armor/sabatons/_sabatons_soles.png");
		return textures;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ArmorRenderer getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack) {
		return new ModelTinkersSabatons(itemStack);
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

	@Override
	public void getTooltipDetailed(ItemStack stack, List<String> tooltips) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTooltipComponents(ItemStack stack, List<String> tooltips) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage,
			int slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		
	}
}
