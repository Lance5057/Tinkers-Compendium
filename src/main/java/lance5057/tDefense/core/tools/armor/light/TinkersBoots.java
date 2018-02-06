package lance5057.tDefense.core.tools.armor.light;

import lance5057.tDefense.core.materials.BootsMaterialStats;
import lance5057.tDefense.core.materials.ClothMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.light.ModelTinkersBoots;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersBoots extends ArmorCore
{
	public TinkersBoots()
	{
		super(new PartMaterialType(TDParts.chainmail, BootsMaterialStats.TYPE), 
			new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE), 
			PartMaterialType.handle(TDParts.rivets));
		setUnlocalizedName("tinkersboots");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, int layer)
	{
		String s = "";
		switch(layer)
		{
			case 0: s = "textures/armor/boots/_boots_chain.png"; break;
			case 1: s = "textures/armor/boots/_boots_cloth.png"; break;
			case 2: s = "textures/armor/boots/_boots_rivet.png"; break;
		}
		return s;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(ItemStack stack)
	{
		return new ModelTinkersBoots(stack);
	}
}
