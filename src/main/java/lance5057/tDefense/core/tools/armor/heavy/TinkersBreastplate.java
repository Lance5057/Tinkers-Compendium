package lance5057.tDefense.core.tools.armor.heavy;

import java.util.List;

import lance5057.tDefense.core.library.ArmorNBT;
import lance5057.tDefense.core.library.ArmorTags;
import lance5057.tDefense.core.library.ArmorTextureBuilder;
import lance5057.tDefense.core.materials.stats.ArmorMaterialStats;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class TinkersBreastplate extends ArmorCore {
	public TinkersBreastplate() {
		super(EntityEquipmentSlot.CHEST, new PartMaterialType(TinkerTools.largePlate, ChestMaterialStats.TYPE),
				new PartMaterialType(TDParts.armorPlate, ChestMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				PartMaterialType.extra(TDParts.chainmail),
				PartMaterialType.extra(TDParts.fabric));
		setUnlocalizedName("tinkersbreastplate");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public NBTTagCompound setupTexture(List<Material> materials) {
		NBTTagCompound base = new NBTTagCompound();

		ResourceLocation rc = ArmorTextureBuilder.createArmorTexture("breastplate",
				new String[] { "plate", "smallplate", "trim", "chain", "cloth" }, materials);

		if (rc != null) {
			base.setString(ArmorTags.TexLoc, rc.toString());
			return base;
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot,
			ModelBiped _default) {
		return new ModelTinkersBreastplate(itemStack);
		//return new ModelArmorTerrasteel(itemStack, armorSlot);
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultTag(materials);
		return data.get();
	}

	@Override
	public EntityEquipmentSlot getArmorSlot(ItemStack stack, EntityEquipmentSlot armorType) {
		return EntityEquipmentSlot.CHEST;
	}

	@Override
	public float damagePotential() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double attackSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected ArmorNBT buildDefaultTag(List<Material> materials) {
		ArmorNBT data = new ArmorNBT();

		ArmorMaterialStats head2 = materials.get(0).getStatsOrUnknown(ChestMaterialStats.TYPE);
		ArmorMaterialStats head = materials.get(1).getStatsOrUnknown(ChestMaterialStats.TYPE);
		HandleMaterialStats handle = materials.get(2).getStatsOrUnknown(MaterialTypes.HANDLE);
		ExtraMaterialStats extra = materials.get(3).getStatsOrUnknown(MaterialTypes.EXTRA);
		// start with head
		data.head(head, head2);
		data.extra(extra);
		data.handle(handle);

		data.modifiers = 5;

		return data;
	}
}
