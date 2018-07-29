package lance5057.tDefense.core.tools.armor.cloth;

import java.util.List;

import lance5057.tDefense.core.library.ArmorNBT;
import lance5057.tDefense.core.library.ArmorTags;
import lance5057.tDefense.core.library.ArmorTextureBuilder;
import lance5057.tDefense.core.materials.stats.ArmorMaterialStats;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.cloth.ModelTinkersHood;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TinkersHood extends ArmorCore
{
	int induceDamage = 0;

	public TinkersHood()
	{
		super(EntityEquipmentSlot.HEAD, new PartMaterialType(TDParts.fabric, FabricMaterialStats.TYPE), new PartMaterialType(TDParts.fabric, FabricMaterialStats.TYPE), PartMaterialType
				.extra(TDParts.rivets));
		setUnlocalizedName("tinkerhood");
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);

	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	{
		return new ModelTinkersHood(itemStack);
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
		return EntityEquipmentSlot.HEAD;
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
			data.head(head, handle);

			// add in accessoires if present
			if (materials.size() >= 3)
			{
				ExtraMaterialStats binding = materials.get(2).getStatsOrUnknown(MaterialTypes.EXTRA);
				data.extra(binding);
			}

			// calculate handle impact
			// data.head(handle);
		}

		// 3 free modifiers
		data.modifiers = DEFAULT_MODIFIERS;

		return data;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public NBTTagCompound setupTexture(List<Material> materials)
	{
		NBTTagCompound base = new NBTTagCompound();

		ResourceLocation rc = ArmorTextureBuilder.createArmorTexture("hood", new String[] { "cloth", "trim", "metal" }, materials);

		if (rc != null)
		{
			base.setString(ArmorTags.TexLoc, rc.toString());
			return base;
		}
		return null;
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
}
