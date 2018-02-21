package lance5057.tDefense.core.tools.armor.cloth;

import java.util.List;

import lance5057.tDefense.core.materials.ArmorMaterialStats.ClothMaterialStats;
import lance5057.tDefense.core.materials.ArmorMaterialStats.HelmMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.cloth.ModelTinkersHood;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.util.ArmorNBT;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersHood extends ArmorCore {
	int induceDamage = 0;

	public TinkersHood() {
		super(new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE),
				new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE), PartMaterialType.extra(TDParts.rivets));
		setUnlocalizedName("tinkerhood");
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		super.onUpdate(stack, world, entity, par4, par5);

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

	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, int layer) {
		String s = "";
		switch (layer) {
		case 0:
			s = "textures/armor/hood/_hood_cloth.png";
			break;
		case 1:
			s = "textures/armor/hood/_hood_trim.png";
			break;
		case 2:
			s = "textures/armor/hood/_hood_metal.png";
			break;
		}
		return s;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(ItemStack stack) {
		return new ModelTinkersHood(stack);
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultArmorTag(materials, HelmMaterialStats.TYPE);
		return data.get();
	}
}
