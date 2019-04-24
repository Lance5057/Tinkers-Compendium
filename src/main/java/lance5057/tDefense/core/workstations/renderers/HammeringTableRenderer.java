package lance5057.tDefense.core.workstations.renderers;

import lance5057.tDefense.core.workstations.tileentities.HammeringTableTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class HammeringTableRenderer extends TileEntitySpecialRenderer<HammeringTableTileEntity> {
	@Override
	public void render(HammeringTableTileEntity te, double x, double y, double z, float partialTicks,
			int destroyStage, float alpha) {
		GlStateManager.pushMatrix();

		GlStateManager.translate(x, y, z);
		GlStateManager.disableRescaleNormal();

		GlStateManager.rotate(180, 1, 0, 0);
		GlStateManager.translate(0.5, -1.5, -0.5);

		if (te.items != null)
			for (int i = 0; i < te.items.length; i++) {
				if (te.items[i] != null) {
					GlStateManager.pushMatrix();

					GlStateManager.rotate(180, 0, 0, 1);
					GlStateManager.rotate(90, 1, 0, 0);
					GlStateManager.rotate(45, 0, 0, 1);
					float s = 0.4f;
					GlStateManager.scale(s, s, s);
					GlStateManager.translate(0.75F, -0.0f, 1.4f);

					Minecraft.getMinecraft().getRenderItem().renderItem(te.items[i], ItemCameraTransforms.TransformType.NONE);
					GlStateManager.popMatrix();
				}
			}
		
		if (te.output != null) {
			GlStateManager.pushMatrix();

			GlStateManager.rotate(180, 0, 0, 1);
			GlStateManager.rotate(90, 1, 0, 0);
			float s = 0.4f;
			GlStateManager.scale(s, s, s);
			GlStateManager.translate(-0.0F, 0.0f, 1.4f);

			Minecraft.getMinecraft().getRenderItem().renderItem(te.output, ItemCameraTransforms.TransformType.NONE);
			GlStateManager.popMatrix();
		}

		GlStateManager.popMatrix();
	}
}
