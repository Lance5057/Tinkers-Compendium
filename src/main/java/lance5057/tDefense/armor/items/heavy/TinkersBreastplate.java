package lance5057.tDefense.armor.items.heavy;

import java.util.List;

import lance5057.tDefense.armor.ArmorCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class TinkersBreastplate extends ArmorCore
{
	public TinkersBreastplate()
	{
		super(EntityEquipmentSlot.CHEST,
				PartMaterialType.head(TinkerTools.largePlate), 
				PartMaterialType.head(TinkerTools.largePlate), 
				PartMaterialType.handle(TinkerTools.toughToolRod),
				PartMaterialType.extra(TinkerTools.bowString));
		setUnlocalizedName("tinkersbreastplate");
		maxReduction = 100;
		reductionPercent = 8 * 0.04f;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		
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
	public NBTTagCompound buildTag(List<Material> materials) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
//	{
//		return "tinkersdefense:textures/armor/Tinkersbreastplate.png";
//	}
//
//	@Override
//	public ArmorRenderer getRenderer()
//	{
//		return ClientProxy.breastplate;
//	}
}
