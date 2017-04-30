package lance5057.tDefense.core.blocks.crestMount;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.tools.ToolCore;

public class Renderer_CrestMount extends TileEntitySpecialRenderer
{
	//private RenderItem itemRenderer;
	private final ModelCrestMount	model;
	EntityItem						entItem		= null;
	EntityItem						entItem2	= null;
	EntityItem						entItem3	= null;
	EntityItem						entItem4	= null;

	public Renderer_CrestMount()
	{
		model = new ModelCrestMount();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		final TileEntity_CrestMount tileEntity = (TileEntity_CrestMount) te;

		boolean left = false, right = false, shield = false;

		if(tileEntity.getStackInSlot(1) != null)
		{
			right = true;
		}
		if(tileEntity.getStackInSlot(0) != null)
		{
			left = true;
		}
		if(tileEntity.getStackInSlot(3) != null)
		{
			shield = true;
		}

		GL11.glPushMatrix();

		//Render Crest Mount
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		final ResourceLocation textures = (new ResourceLocation(
				"tinkersdefense:textures/blocks/crestmount.png"));

		Minecraft.getMinecraft().renderEngine.bindTexture(textures);

		GL11.glPushMatrix();

		final int meta = te.getBlockMetadata();
		float rotation = 0;
		switch(meta)
		{
			case 1:
				rotation = 180;
				break;
			case 2:
				rotation = 0;
				break;
			case 3:
				rotation = -90;
				break;
			case 4:
				rotation = 90;
				break;
		}
		GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);

		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90F, 0.5F, 0.0F, 0.0F);
		GL11.glTranslatef(0, -1, -1);

		model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, left, right, shield);
		GL11.glPopMatrix();

		//Render Inventory            

		//right slot
		renderSlot(tileEntity, x, y, z, 1, rotation, tileEntity.flip[1]);

		//left slot
		renderSlot(tileEntity, x, y, z, 0, rotation, tileEntity.flip[0]);

		//middle slot
		renderSlot(tileEntity, x, y, z, 2, rotation, tileEntity.flip[2]);

		//shield slot
		renderSlot(tileEntity, x, y, z, 3, rotation, tileEntity.flip[3]);

		GL11.glPopMatrix();

		entItem = null;
		entItem2 = null;
		entItem3 = null;
		entItem4 = null;
	}
	
	private void renderSlot(TileEntity_CrestMount te, double x, double y, double z, int slot, float rotation, boolean flip)
	{
		if(te.getStackInSlot(slot) != null)
		{
			GL11.glPushMatrix();
			
			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

			GL11.glScalef(2f, 2f, 2f);
			GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
			
			if(te.flip[3] == true)
			{
				GL11.glRotatef(180, 0, 0, 1);
				GL11.glTranslatef(0.0f, 1.0f, 0);
			}

			Minecraft.getMinecraft().getRenderItem().renderItem(te.getStackInSlot(slot),
					ItemCameraTransforms.TransformType.NONE);
			
			GL11.glPopMatrix();
		}
	}

}
