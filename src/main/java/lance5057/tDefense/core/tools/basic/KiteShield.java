package lance5057.tDefense.core.tools.basic;

import c4.conarm.common.ConstructsRegistry;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.core.tools.bases.Shield;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class KiteShield extends Shield
{
	int	induceDamage	= 0;

	public KiteShield()
	{
		super(PartMaterialType.handle(TinkerTools.toughToolRod),
			new PartMaterialType(ConstructsRegistry.armorPlate, ShieldMaterialStats.TYPE),
			new PartMaterialType(ConstructsRegistry.armorPlate, ShieldMaterialStats.TYPE),
			PartMaterialType.extra(TDParts.rivets));
		setUnlocalizedName("kiteshield");
	}
}
