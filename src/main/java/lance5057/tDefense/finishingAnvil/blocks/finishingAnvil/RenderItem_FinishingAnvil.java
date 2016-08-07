package lance5057.tDefense.finishingAnvil.blocks.finishingAnvil;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

public class RenderItem_FinishingAnvil extends RenderItem
{
	private final Gui_FinishingAnvil	anvilGui;
	float								sx;
	float								sy;
	float								sz;

	RenderItem_FinishingAnvil(Gui_FinishingAnvil gui, float sx, float sy, float sz)
	{
		super();
		anvilGui = gui;
		this.sx = sx;
		this.sy = sy;
		this.sz = sz;
	}

	@Override
	public void renderItemAndEffectIntoGUI(FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int x, int y)
	{
		if(itemStack == null)
			return;

		RenderHelper.enableGUIStandardItemLighting();

		final Slot slot = anvilGui.inventorySlots.getSlotFromInventory(anvilGui.inventory, 0);

		if(slot.getStack() != null)
		{
			GL11.glPushMatrix();

			GL11.glScalef(sx, sy, sz);
			super.renderItemAndEffectIntoGUI(fontRenderer, textureManager, itemStack, x, y);

			GL11.glPopMatrix();
		}
	}
}
