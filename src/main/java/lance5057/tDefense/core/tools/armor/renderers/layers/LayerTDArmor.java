package lance5057.tDefense.core.tools.armor.renderers.layers;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.client.CustomTextureCreator;

@SideOnly(Side.CLIENT)
public abstract class LayerTDArmor<T extends ModelBase> implements LayerRenderer<EntityLivingBase> {

	protected static final ResourceLocation ENCHANTED_ITEM_GLINT_RES = new ResourceLocation(
			"textures/misc/enchanted_item_glint.png");
	private final RenderLivingBase<?> renderer;
	private float alpha = 1.0F;
	private float colorR = 1.0F;
	private float colorG = 1.0F;
	private float colorB = 1.0F;
	private boolean skipRenderGlint;
	private static final Map<String, ResourceLocation> ARMOR_TEXTURE_RES_MAP = Maps
			.<String, ResourceLocation>newHashMap();

	public LayerTDArmor(RenderLivingBase<?> rendererIn) {
		this.renderer = rendererIn;
		this.initArmor();
	}

	protected abstract void initArmor();

	protected abstract void setModelSlotVisible(T p_188359_1_, EntityEquipmentSlot slotIn);

	@Override
	public abstract void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale);

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void renderArmorLayer(EntityLivingBase entityLivingBaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale,
			EntityEquipmentSlot slotIn) {
		ItemStack itemstack = entityLivingBaseIn.getItemStackFromSlot(slotIn);

		if (itemstack != null && itemstack.getItem() instanceof ArmorCore) {
			ArmorCore itemarmor = (ArmorCore) itemstack.getItem();

			if (itemarmor.getArmorSlot(itemstack, null) == slotIn) {
				T t = this.getModelFromSlot(entityLivingBaseIn, slotIn);
				if (t != null) {
					t.setModelAttributes(this.renderer.getMainModel());
					t.setLivingAnimations(entityLivingBaseIn, limbSwing, limbSwingAmount, partialTicks);
					this.setModelSlotVisible(t, slotIn);
					Map<String, TextureAtlasSprite> sprites = CustomTextureCreator.sprites.get("tinkersdefense:armor/helm/_helm_visor");
					List<String> textures = getArmorResource(entityLivingBaseIn, itemstack, slotIn, null);
					for (String s : textures) {
						CustomTextureCreator.sprites.get(s);
						this.renderer.bindTexture(new ResourceLocation(Reference.MOD_ID, s + ".png"));
						t.render(entityLivingBaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,
								scale);
					}

					if (!this.skipRenderGlint && itemstack.hasEffect()) {
						renderEnchantedGlint(this.renderer, entityLivingBaseIn, t, limbSwing, limbSwingAmount,
								partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
					}
				}
			}
		}
	}

	public abstract T getModelFromSlot(EntityLivingBase ent, EntityEquipmentSlot slotIn);

	public abstract List<String> getArmorResource(net.minecraft.entity.Entity entity, ItemStack stack,
			EntityEquipmentSlot slot, String type);

	public static void renderEnchantedGlint(RenderLivingBase<?> p_188364_0_, EntityLivingBase p_188364_1_,
			ModelBase model, float p_188364_3_, float p_188364_4_, float p_188364_5_, float p_188364_6_,
			float p_188364_7_, float p_188364_8_, float p_188364_9_) {
		float f = (float) p_188364_1_.ticksExisted + p_188364_5_;
		p_188364_0_.bindTexture(ENCHANTED_ITEM_GLINT_RES);
		Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
		GlStateManager.enableBlend();
		GlStateManager.depthFunc(514);
		GlStateManager.depthMask(false);
		float f1 = 0.5F;
		GlStateManager.color(0.5F, 0.5F, 0.5F, 1.0F);

		for (int i = 0; i < 2; ++i) {
			GlStateManager.disableLighting();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_COLOR, GlStateManager.DestFactor.ONE);
			float f2 = 0.76F;
			GlStateManager.color(0.38F, 0.19F, 0.608F, 1.0F);
			GlStateManager.matrixMode(5890);
			GlStateManager.loadIdentity();
			float f3 = 0.33333334F;
			GlStateManager.scale(0.33333334F, 0.33333334F, 0.33333334F);
			GlStateManager.rotate(30.0F - (float) i * 60.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.translate(0.0F, f * (0.001F + (float) i * 0.003F) * 20.0F, 0.0F);
			GlStateManager.matrixMode(5888);
			model.render(p_188364_1_, p_188364_3_, p_188364_4_, p_188364_6_, p_188364_7_, p_188364_8_, p_188364_9_);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		}

		GlStateManager.matrixMode(5890);
		GlStateManager.loadIdentity();
		GlStateManager.matrixMode(5888);
		GlStateManager.enableLighting();
		GlStateManager.depthMask(true);
		GlStateManager.depthFunc(515);
		GlStateManager.disableBlend();
		Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
	}
}
