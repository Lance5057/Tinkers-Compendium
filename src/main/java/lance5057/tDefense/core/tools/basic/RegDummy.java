package lance5057.tDefense.core.tools.basic;

import java.util.List;

import lance5057.tDefense.core.parts.TDParts;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.tools.TinkerTools;

//Till I figure out why Armor Parts wont register normally
public class RegDummy extends ToolCore {

	public static final float DURABILITY_MODIFIER = 1.0f;

	public RegDummy() {
		//Hardcore sword test
		super(PartMaterialType.head(TDParts.chainmail));
		
//		super(PartMaterialType.head(TinkerTools.swordBlade), 
//				PartMaterialType.handle(TinkerTools.toolRod), 
//				PartMaterialType.extra(TinkerTools.wideGuard),
//				PartMaterialType.extra(TDParts.rivets),
//				PartMaterialType.extra(TDParts.fabric),
//				PartMaterialType.extra(TDParts.filigree),
//				PartMaterialType.extra(TinkerTools.arrowHead));

		setUnlocalizedName("regdummy");
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
		ToolNBT data = buildDefaultTag(materials);
		// 2 base damage, like vanilla swords
		data.attack += 1f;
		data.durability *= DURABILITY_MODIFIER;
		return data.get();
	}
}
