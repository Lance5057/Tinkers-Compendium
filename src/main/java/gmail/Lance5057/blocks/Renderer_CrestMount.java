package gmail.Lance5057.blocks;

import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class Renderer_CrestMount extends TileEntitySpecialRenderer
{

    //The model of your block
    private final ModelCrestMount model;
    EntityItem entItem = null;
   
    public Renderer_CrestMount() {
            this.model = new ModelCrestMount();
    }
   
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
            GL11.glPushMatrix();

            //Render Crest Mount
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

            ResourceLocation textures = (new ResourceLocation("tinkersdefense:textures/blocks/CrestMount.png"));
            
            Minecraft.getMinecraft().renderEngine.bindTexture(textures);

            GL11.glPushMatrix();

            int meta = te.getBlockMetadata();
            float rotation = 0;
            switch(meta)
            {
            case 1: rotation = 0; break;
            case 2: rotation = 180; break;
            case 3: rotation = 90; break;
            case 4: rotation = -90; break;
            }
            GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
            
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(90F, 0.5F, 0.0F, 0.0F);
            GL11.glTranslatef(0, -1, -1);
            
            this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            
            //Render Inventory
            int slot = 1; //Example: int slot = 1;
            TileEntity_CrestMount tileEntity = (TileEntity_CrestMount)te;
            if(tileEntity.getStackInSlot(slot)!=null)
            {
            if((entItem == null) || entItem.getEntityItem().getItem() != tileEntity.getStackInSlot(slot).getItem())
             entItem = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(slot));
            GL11.glPushMatrix();
            this.entItem.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GL11.glTranslatef((float)x + 0.5F, (float)y + 1.02F, (float)z + 0.3F);
            GL11.glRotatef(180, 0, 1, 1);
            GL11.glScalef(5, 5, 5);
            RenderManager.instance.renderEntityWithPosYaw(entItem, x + 0.5, y + 1, z + 0.5, 0, 0);           
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
            }
            
            
            GL11.glPopMatrix();
    }

}
