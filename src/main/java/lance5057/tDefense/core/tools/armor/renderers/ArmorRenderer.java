package lance5057.tDefense.core.tools.armor.renderers;

import java.util.Map;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ArmorRenderer extends ModelBiped {
	public Map<String, Boolean> partsList;

	public ItemStack stack;
	public String defaultFolder;
	DynamicTexture texture;
	
	protected boolean visor = false;
	protected float visorTime = 0f;
	
	public EntityEquipmentSlot slot;

	// public List<ModelRenderer> boxes = new ArrayList<ModelRenderer>();

	public NBTTagCompound defaultTags = new NBTTagCompound();

	public ArmorRenderer(float a, float b, int c, int d, ItemStack stack) {
		super(a, b, c, d);

		this.stack = stack;
	}
	
	public ArmorRenderer(float a, float b, int c, int d, ItemStack stack, EntityEquipmentSlot s) {
		super(a, b, c, d);

		this.stack = stack;
		slot = s;
	}
	
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	// Mojang plz
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
		if (entityIn instanceof EntityArmorStand) {
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
		} else {
			super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		}
	}
	
	protected ModelRenderer lerpModel(ModelRenderer from, ModelRenderer to, float time)
	{
		if(from.offsetX != to.offsetX)
			from.offsetX = lerp(from.offsetX, to.offsetX, time);
		if(from.offsetY != to.offsetY)
			from.offsetY = lerp(from.offsetY, to.offsetY, time);
		if(from.offsetZ != to.offsetZ)
			from.offsetZ = lerp(from.offsetZ, to.offsetZ, time);
		
		if(from.rotateAngleX != to.rotateAngleX)
			from.rotateAngleX = lerp(from.rotateAngleX, to.rotateAngleX, time);
		if(from.rotateAngleY != to.rotateAngleY)
			from.rotateAngleY = lerp(from.rotateAngleY, to.rotateAngleY, time);
		if(from.rotateAngleZ != to.rotateAngleZ)
			from.rotateAngleZ = lerp(from.rotateAngleZ, to.rotateAngleZ, time);
		
		return from;
	}
	
	private float lerp(float from, float to, float time)
	{
		return (1 - time) * from + time * to;
	}
}
