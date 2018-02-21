package lance5057.tDefense.core.tools.bases;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.materials.ArmorMaterialStats;
import lance5057.tDefense.util.ArmorNBT;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
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
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TagUtil;

public abstract class ArmorCore extends ToolCore {
	public ArmorCore(PartMaterialType... requiredComponents) {
		super(requiredComponents);
	}

	protected String getHarvestType() {
		return null;
	}

	@Override
	public float damagePotential() {
		return 0.0f;
	}

	@Override
	public double attackSpeed() {
		return 0;
	}

	@Override
	public abstract NBTTagCompound buildTag(List<slimeknights.tconstruct.library.materials.Material> materials);

	public int getArmorDisplay(ItemStack stack) {
		return TagUtil.getToolStats(stack).get().getInteger("ArmorRating");
	}

	@SideOnly(Side.CLIENT)
	public abstract String getArmorTexture(ItemStack stack, int layer);

	@SideOnly(Side.CLIENT)
	public abstract ModelBiped getArmorModel(ItemStack stack);

	public ArmorNBT buildDefaultArmorTag(List<Material> materials, String type) {
		ArmorNBT data = new ArmorNBT();

		if (materials.size() >= 2) {
			HandleMaterialStats handle = materials.get(0).getStatsOrUnknown(MaterialTypes.HANDLE);
			ArmorMaterialStats head = materials.get(1).getStatsOrUnknown(type);
			// start with head
			data.head(head);

			// add in accessoires if present
			if (materials.size() >= 3) {
				ExtraMaterialStats binding = materials.get(2).getStatsOrUnknown(MaterialTypes.EXTRA);
				data.extra(binding);
			}

			// calculate handle impact
			data.handle(handle);
		}

		// 3 free modifiers
		data.modifiers = 5;

		return data;
	}
}
