package lance5057.tDefense.core.tools.basic;

import java.util.List;

import lance5057.tDefense.core.parts.TDParts;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.tools.TinkerTools;

public class FishingRod extends ToolCore {
	
	public static final float DURABILITY_MODIFIER = 1.0f;

	public FishingRod() {
		super(PartMaterialType.head(TinkerTools.toughToolRod), PartMaterialType.bowstring(TinkerTools.bowString),
				PartMaterialType.handle(TDParts.rivets));

		setUnlocalizedName("fishingRod");
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
