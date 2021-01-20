package lance5057.tDefense.core.tools.basic;

import java.util.List;

import c4.conarm.lib.armor.ArmorPart;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.tools.TinkerTools;
import c4.conarm.common.ConstructsRegistry;

//Till I figure out why Armor Parts wont register normally
public class RegDummy extends ToolCore {

	public static final float DURABILITY_MODIFIER = 1.0f;

	public RegDummy() {
		super(new PartMaterialType(TinkerTools.largePlate, ChestMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				PartMaterialType.extra(TDParts.chainmail),
				PartMaterialType.extra(ConstructsRegistry.bootsCore),
				new PartMaterialType(TDParts.chainmail, LegsMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.helmetCore, HelmMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.chestCore, ChestMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.leggingsCore, LegsMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.bootsCore, FeetMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.armorTrim, HelmMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.armorTrim, ChestMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.armorTrim, LegsMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.armorTrim, FeetMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.armorPlate, HelmMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.armorPlate, ChestMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.armorPlate, LegsMaterialStats.TYPE),
				new PartMaterialType(ConstructsRegistry.armorPlate, FeetMaterialStats.TYPE),
				new PartMaterialType(TDParts.chainmail, HelmMaterialStats.TYPE),
				PartMaterialType.extra(TDParts.rivets),
				new PartMaterialType(TDParts.fabric, FabricMaterialStats.TYPE));

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
