package lance5057.tDefense.core.tools.armor.heavy;

import lance5057.tDefense.core.materials.ClothMaterialStats;
import lance5057.tDefense.core.materials.LegsMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersGrieves;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersGrieves extends ArmorCore
{
	public TinkersGrieves()
	{
		super(new PartMaterialType(TDParts.armorPlate, LegsMaterialStats.TYPE), 
			new PartMaterialType(TDParts.chainmail, LegsMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE));
		setUnlocalizedName("tinkersgrieves");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, int layer)
	{
		String s = "";
		switch(layer)
		{
			case 0: s = "textures/armor/grieves/_grieves_plate.png"; break;
			case 1: s = "textures/armor/grieves/_grieves_chain.png"; break;
			case 2: s = "textures/armor/grieves/_grieves_trim.png"; break;
			case 3: s = "textures/armor/grieves/_grieves_cloth.png"; break;
		}
		return s;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(ItemStack stack)
	{
		return new ModelTinkersGrieves(stack);
	}
}
