package lance5057.tDefense.core.tools.armor.renderers.layers;

import java.util.List; 

import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class LayerTDBipedArmor extends LayerTDArmor<ModelBiped> {

	public LayerTDBipedArmor(RenderLivingBase<?> rendererIn) {
		super(rendererIn);
	}

	@Override
	protected void initArmor() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setModelSlotVisible(ModelBiped p_188359_1_, EntityEquipmentSlot slotIn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw,
				headPitch, scale, EntityEquipmentSlot.CHEST);
		this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw,
				headPitch, scale, EntityEquipmentSlot.LEGS);
		this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw,
				headPitch, scale, EntityEquipmentSlot.FEET);
		this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw,
				headPitch, scale, EntityEquipmentSlot.HEAD);
	}

	@Override
	public ModelBiped getModelFromSlot(EntityLivingBase ent, EntityEquipmentSlot slotIn) {
		if (ent instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer) ent;
			ItemStack armor = p.inventory.armorItemInSlot(slotIn.getIndex());
			ModelBiped b = ((ArmorCore)armor.getItem()).getArmorModel(ent, armor);
			return b;
		}
		return null;
	}

	@Override
	public List<String> getArmorResource(Entity entity, ItemStack stack, EntityEquipmentSlot slot, String type) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer) entity;
			ItemStack armor = p.inventory.armorItemInSlot(slot.getIndex());
			//List<String> l = ((ArmorCore)armor.getItem()).getArmorTexture(armor);
			//return l;
		}
		return null;
	}

}
