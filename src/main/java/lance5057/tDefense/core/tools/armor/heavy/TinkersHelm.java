package lance5057.tDefense.core.tools.armor.heavy;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.materials.ArmorMaterialStats.HelmMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersHelm;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.util.ArmorNBT;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.TinkerTools;

public class TinkersHelm extends ArmorCore {
	public TinkersHelm() {
		super(EntityEquipmentSlot.HEAD,new PartMaterialType(TinkerTools.panHead, HelmMaterialStats.TYPE),
				new PartMaterialType(TDParts.armorPlate, HelmMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree), PartMaterialType.extra(TDParts.chainmail));
		setUnlocalizedName("tinkershelm");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public List<String> getArmorTexture(ItemStack stack) {
		List<String> textures = new ArrayList();
		NBTTagList t = TagUtil.getBaseMaterialsTagList(stack);
		textures.add("textures/armor/helm/_helm_top_" + t.getStringTagAt(0));
		textures.add("textures/armor/helm/_helm_plate_" + t.getStringTagAt(1));
		textures.add("textures/armor/helm/_helm_visor_" + t.getStringTagAt(2));
		textures.add("textures/armor/helm/_helm_chain_" + t.getStringTagAt(3));
		return textures;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ArmorRenderer getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack) {
		return new ModelTinkersHelm(itemStack);
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultArmorTag(materials, HelmMaterialStats.TYPE);
		return data.get();
	}

	@Override
	public EntityEquipmentSlot getArmorSlot(ItemStack stack, EntityEquipmentSlot armorType) {
		return EntityEquipmentSlot.HEAD;
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
