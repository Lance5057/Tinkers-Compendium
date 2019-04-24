package lance5057.tDefense.core.tools.basic;

import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.tools.TinkerTools;

public class Saw extends ToolCore {
	
	public static final float DURABILITY_MODIFIER = 1.5f;

	public Saw() {
		super(PartMaterialType.head(TinkerTools.toolRod), PartMaterialType.extra(TinkerTools.binding),
				PartMaterialType.handle(TinkerTools.toughToolRod));

		setUnlocalizedName("saw");
	}
	
	@Override
	public float damagePotential() {
		return 0.75f;
	}

	@Override
	public double attackSpeed() {
		return 1f;
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ToolNBT data = buildDefaultTag(materials);
	    data.durability *= DURABILITY_MODIFIER;
	    return data.get();
	}

}
