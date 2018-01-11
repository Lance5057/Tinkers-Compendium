package lance5057.tDefense.core.tools.armor.heavy;

import lance5057.tDefense.core.materials.ChestMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class TinkersBreastplate extends ArmorCore
{
	public TinkersBreastplate()
	{
		super(new PartMaterialType(TinkerTools.largePlate, ChestMaterialStats.TYPE), 
			new PartMaterialType(TDParts.armorPlate, ChestMaterialStats.TYPE), 
				PartMaterialType.handle(TDParts.filigree),
				PartMaterialType.extra(TDParts.chainmail));
		setUnlocalizedName("tinkersbreastplate");
	}

//	@Override
//	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
//		// TODO Auto-generated method stub
//		
//	}


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
