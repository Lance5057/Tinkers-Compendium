package lance5057.tDefense.core.tools.armor.cloth;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.materials.ClothMaterialStats;
import lance5057.tDefense.core.materials.HelmMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.cloth.ModelTinkersHood;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;

public class TinkersHood extends ArmorCore
{
	int induceDamage = 0;

	public TinkersHood()
	{
		super(new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE), new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE), PartMaterialType.extra(TDParts.rivets));
		setUnlocalizedName("tinkerhood");
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);

	}

	@Override
	public float damagePotential()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double attackSpeed()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getArmorTexture(ItemStack stack, int layer) 
	{
		String s = "";
		switch(layer)
		{
			case 0: s = "textures/armor/hood/_hood_cloth.png"; break;
			case 1: s = "textures/armor/hood/_hood_trim.png"; break;
			case 2: s = "textures/armor/hood/_hood_metal.png"; break;
		}
		return s;
	}

	@Override
	public ModelBiped getArmorModel(ItemStack stack)
	{
		return new ModelTinkersHood(stack);
	}

}
