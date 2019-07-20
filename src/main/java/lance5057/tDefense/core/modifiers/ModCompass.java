package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.armor.cloth.TinkersHood;
import lance5057.tDefense.core.tools.armor.heavy.TinkersHelm;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierAspect.FreeModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class ModCompass extends ModifierTDTrait {

	public ModCompass() {
		super("compass", 0xBBBBBB);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(RenderGameOverlayEvent.Post e) {

		GlStateManager.pushMatrix();
		ScaledResolution res = e.getResolution();
		
//		GlStateManager.rotate(180, 0, 0, 1);
//		GlStateManager.rotate(90, 1, 0, 0);
//		GlStateManager.rotate(45, 0, 0, 1);
		float s = 2f;
		GlStateManager.scale(s, s, s);
//		GlStateManager.translate(0.75F, -0.0f, 1.4f);

		// GlStateManager.disableTexture2D();
		
		int height = (res.getScaledHeight()-32);
		int width = (res.getScaledWidth()/2 + 92);
		
		height /= s;
		width /= s;
		
		
		
		Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(Items.COMPASS), width, height);
		// GlStateManager.enableTexture2D();
//		GlStateManager.
		GlStateManager.popMatrix();
	}

	@Override
	public boolean canApplyCustom(ItemStack stack) {
		if (!(stack.getItem() instanceof TinkersHelm) && !(stack.getItem() instanceof TinkersHood)) {
			return false;
		}

		if (!(stack.getItem() instanceof ArmorCore)) {
			return false;
		}
		// not present yet, ok
		if (super.canApplyCustom(stack)) {
			return true;
		}
		// no max level
		else if (maxLevel == 0) {
			return false;
		}

		// already present, limit by level
		NBTTagCompound tag = TinkerUtil.getModifierTag(stack, identifier);

		return ModifierNBT.readTag(tag).level <= maxLevel;
	}

	@Override
	protected ModifierAspect[] getAspects() {
		return new ModifierAspect[] {new FreeModifierAspect(0)};
	}
}
