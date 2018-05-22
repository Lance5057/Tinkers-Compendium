package lance5057.tDefense.core.tools.armor.heavy;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.materials.ArmorMaterialStats.ChestMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersBreastplate;
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
import slimeknights.tconstruct.tools.TinkerTools;

public class TinkersBreastplate extends ArmorCore {
	public TinkersBreastplate() {
		super(EntityEquipmentSlot.CHEST, new PartMaterialType(TinkerTools.largePlate, ChestMaterialStats.TYPE),
				new PartMaterialType(TDParts.armorPlate, ChestMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree), PartMaterialType.extra(TDParts.chainmail));
		setUnlocalizedName("tinkersbreastplate");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public List<String> getArmorTexture(ItemStack stack) {
		List<String> textures = new ArrayList();
		textures.add("textures/armor/breastplate/_breastplate_plate.png");
		textures.add("textures/armor/breastplate/_breastplate_smallplate.png");
		textures.add("textures/armor/breastplate/_breastplate_trim.png");
		textures.add("textures/armor/breastplate/_breastplate_chain.png");
		return textures;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ArmorRenderer getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack) {
		return new ModelTinkersBreastplate(itemStack);
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultArmorTag(materials, ChestMaterialStats.TYPE);
		return data.get();
	}

	@Override
	public EntityEquipmentSlot getArmorSlot(ItemStack stack, EntityEquipmentSlot armorType) {
		return EntityEquipmentSlot.CHEST;
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
