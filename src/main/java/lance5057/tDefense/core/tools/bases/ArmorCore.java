package lance5057.tDefense.core.tools.bases;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.client.model.MaterialModel;
import slimeknights.tconstruct.library.client.model.ModelHelper;
import slimeknights.tconstruct.library.client.model.ToolModel;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;

public abstract class ArmorCore extends ToolCore
{
	public ArmorCore(PartMaterialType... requiredComponents)
	{
		super(requiredComponents);
	}

	protected String getHarvestType()
	{
		return null;
	}

	@Override
	public float damagePotential()
	{
		return 0.0f;
	}

	@Override
	public double attackSpeed()
	{
		return 0;
	}

	@Override
	public NBTTagCompound buildTag(List<slimeknights.tconstruct.library.materials.Material> materials)
	{
		ToolNBT data = buildDefaultTag(materials);
		return data.get();
	}

	public int getArmorDisplay()
	{
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public abstract String getArmorTexture(ItemStack stack,int layer);

	@SideOnly(Side.CLIENT)
	public abstract ModelBiped getArmorModel(ItemStack stack);

	public List<TextureAtlasSprite> sprites;

	@SideOnly(Side.CLIENT)
	public void initTextures(ItemStack stack, EntityLivingBase entity)
	{
		sprites = new ArrayList<TextureAtlasSprite>();
		
		TextureAtlasSprite s = ((ToolCore)stack.getItem()).getMaterialForPartForGuiRendering(0).renderInfo.getTexture(new ResourceLocation(Reference.MOD_ID), "hood_cloth");

//		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
//		List<BakedQuad> list = new ArrayList<BakedQuad>();
//
//		IBakedModel m = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(stack, entity.world, entity);
		//Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);
		//= ModelHelper.getBakedModelForItem(stack, entity.world, entity);
		
//		list.addAll(m.getQuads(null, null, 0));
//		
//		for (BakedQuad quad : list)
//		{
//			ResourceLocation loc1 = new ResourceLocation(quad.getSprite().getIconName());
//
//			sprites.add(Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(loc1.toString()));
//		}
	}
}
