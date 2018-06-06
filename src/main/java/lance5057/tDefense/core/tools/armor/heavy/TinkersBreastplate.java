package lance5057.tDefense.core.tools.armor.heavy;

import java.util.List;

import lance5057.tDefense.core.library.ArmorNBT;
import lance5057.tDefense.core.materials.stats.ArmorMaterialStats;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.TinkerTools;

public class TinkersBreastplate extends ArmorCore
{
	public TinkersBreastplate()
	{
		super(EntityEquipmentSlot.CHEST, new PartMaterialType(TinkerTools.largePlate, ChestMaterialStats.TYPE), new PartMaterialType(TDParts.armorPlate, ChestMaterialStats.TYPE), PartMaterialType
				.handle(TDParts.filigree), PartMaterialType.extra(TDParts.chainmail));
		setUnlocalizedName("tinkersbreastplate");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		String texture;
		NBTTagList t = TagUtil.getBaseMaterialsTagList(stack);
		texture = "textures/armor/breastplate/_breastplate_plate_" + t.getStringTagAt(0);
		return texture;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	{
		return new ModelTinkersBreastplate(itemStack);
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials)
	{
		ArmorNBT data = buildDefaultTag(materials);
		return data.get();
	}

	@Override
	public EntityEquipmentSlot getArmorSlot(ItemStack stack, EntityEquipmentSlot armorType)
	{
		return EntityEquipmentSlot.CHEST;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public float damagePotential()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double attackSpeed()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected ArmorNBT buildDefaultTag(List<Material> materials)
	{
		ArmorNBT data = new ArmorNBT();

		if (materials.size() >= 2)
		{
			ArmorMaterialStats handle = materials.get(0).getStatsOrUnknown(FabricMaterialStats.TYPE);
			ArmorMaterialStats head = materials.get(1).getStatsOrUnknown(FabricMaterialStats.TYPE);
			// start with head
			data.head(head);

			// add in accessoires if present
			if (materials.size() >= 3)
			{
				ExtraMaterialStats binding = materials.get(2).getStatsOrUnknown(MaterialTypes.EXTRA);
				data.extra(binding);
			}

			// calculate handle impact
			data.head(handle);
		}

		// 3 free modifiers
		data.modifiers = DEFAULT_MODIFIERS;

		return data;
	}
}
