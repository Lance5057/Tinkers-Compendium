package lance5057.tDefense.core.tools.armor.renderers;

import java.util.List;

import org.lwjgl.opengl.GL11;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.tools.armor.renderers.shaders.ArmorShader;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class ArmorRenderer extends ModelBiped
{
	// public String[] partNames;

	public ItemStack	stack;
	public String		defaultFolder;

	// public List<ModelRenderer> boxes = new ArrayList<ModelRenderer>();

	public NBTTagCompound defaultTags = new NBTTagCompound();

	public ArmorRenderer(float a, float b, int c, int d, ItemStack stack)
	{
		super(a, b, c, d);

		this.stack = stack;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		GL11.glPushMatrix();

		for (int i = 0; i < TinkerUtil.getMaterialsFromTagList(TagUtil.getBaseMaterialsTagList(stack)).size(); i++)
		{
			GL11.glPushMatrix();

			EntityLivingBase e = (EntityLivingBase) entity;
			String s = stack.getItem().getRegistryName().getResourceDomain();
			List<Material> mats = TinkerUtil.getMaterialsFromTagList(TagUtil.getBaseMaterialsTagList(stack));

			String o = mats.get(i).renderInfo.getTextureSuffix();

			ArmorShader.selectRenderer(mats.get(i).renderInfo, new ResourceLocation(Reference.MOD_ID, ((ArmorCore) stack.getItem()).getArmorTexture(stack, i)));

			super.render(entity, f, f1, f2, f3, f4, f5);

			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}

		GL11.glPopMatrix();
		GL11.glColor3d(1.0, 1.0, 1.0);
	}

	//Mojang plz
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		if (entityIn instanceof EntityArmorStand)
		{
			EntityArmorStand entityarmorstand = (EntityArmorStand) entityIn;
			this.bipedHead.rotateAngleX = 0.017453292F * entityarmorstand.getHeadRotation().getX();
			this.bipedHead.rotateAngleY = 0.017453292F * entityarmorstand.getHeadRotation().getY();
			this.bipedHead.rotateAngleZ = 0.017453292F * entityarmorstand.getHeadRotation().getZ();
			this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
			this.bipedBody.rotateAngleX = 0.017453292F * entityarmorstand.getBodyRotation().getX();
			this.bipedBody.rotateAngleY = 0.017453292F * entityarmorstand.getBodyRotation().getY();
			this.bipedBody.rotateAngleZ = 0.017453292F * entityarmorstand.getBodyRotation().getZ();
			this.bipedLeftArm.rotateAngleX = 0.017453292F * entityarmorstand.getLeftArmRotation().getX();
			this.bipedLeftArm.rotateAngleY = 0.017453292F * entityarmorstand.getLeftArmRotation().getY();
			this.bipedLeftArm.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftArmRotation().getZ();
			this.bipedRightArm.rotateAngleX = 0.017453292F * entityarmorstand.getRightArmRotation().getX();
			this.bipedRightArm.rotateAngleY = 0.017453292F * entityarmorstand.getRightArmRotation().getY();
			this.bipedRightArm.rotateAngleZ = 0.017453292F * entityarmorstand.getRightArmRotation().getZ();
			this.bipedLeftLeg.rotateAngleX = 0.017453292F * entityarmorstand.getLeftLegRotation().getX();
			this.bipedLeftLeg.rotateAngleY = 0.017453292F * entityarmorstand.getLeftLegRotation().getY();
			this.bipedLeftLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getZ();
			this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
			this.bipedRightLeg.rotateAngleX = 0.017453292F * entityarmorstand.getRightLegRotation().getX();
			this.bipedRightLeg.rotateAngleY = 0.017453292F * entityarmorstand.getRightLegRotation().getY();
			this.bipedRightLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getRightLegRotation().getZ();
			this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
			copyModelAngles(this.bipedHead, this.bipedHeadwear);
		} else
			super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}
}
