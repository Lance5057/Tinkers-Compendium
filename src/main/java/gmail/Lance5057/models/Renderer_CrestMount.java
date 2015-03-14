package gmail.Lance5057.models;

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

import tconstruct.library.tools.ToolCore;

public class Renderer_CrestMount extends TileEntitySpecialRenderer
{
	//private RenderItem itemRenderer;
    private final ModelCrestMount model;
    EntityItem entItem = null;
    EntityItem entItem2 = null;
    EntityItem entItem3 = null;
    EntityItem entItem4 = null;
   
    public Renderer_CrestMount() {
            this.model = new ModelCrestMount();
    }
   
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) 
    {
    	TileEntity_CrestMount tileEntity = (TileEntity_CrestMount)te;
    	
    	boolean left=false,
    			right=false,
    			shield=false;
    	
    	if(tileEntity.getStackInSlot(0)!=null)
    		right=true;
    	if(tileEntity.getStackInSlot(1)!=null)
    		left=true;
    	if(tileEntity.getStackInSlot(3)!=null)
    		shield=true;
    	
    	
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
            
            this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F,left,right,shield);
            GL11.glPopMatrix();
            
            //Render Inventory            
            
            //right slot
            int slot = 0;
            if(tileEntity.getStackInSlot(slot)!=null)
            {
            if((entItem == null) || entItem.getEntityItem().getItem() != tileEntity.getStackInSlot(slot).getItem())
             entItem = new EntityItem(tileEntity.getWorldObj(), 0, 0, 0, tileEntity.getStackInSlot(slot));
            GL11.glPushMatrix();
            this.entItem.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GL11.glScalef(2f,2f,2f);
            GL11.glRotatef(90, 0, 0, -1);   
            GL11.glRotatef(rotation, -1.0F, 0.0F, 0.0F);
            //GL11.glTranslatef(0.4f/*up - down*/, -0.3f/*left - right*/, 0.22f);
            if(tileEntity.flip[0]==true)
            {
            	GL11.glRotatef(180, 0, 0, 1);
            	GL11.glTranslatef(-0.8f, 0.2f, 0);
            }
            
            if(tileEntity.getStackInSlot(0).getItem() instanceof ToolCore)
            {
                GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(-0.505f, -0.32f, 0);
            }
            
            RenderManager.instance.renderEntityWithPosYaw(entItem, 0.4f/*up - down*/, -0.3f/*left - right*/, 0.23f, 0, 0);         
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
            }
            
            //left slot
            slot = 1;
            if(tileEntity.getStackInSlot(slot)!=null)
            {
            if((entItem2 == null) || entItem2.getEntityItem().getItem() != tileEntity.getStackInSlot(slot).getItem())
             entItem2 = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(slot));
            GL11.glPushMatrix();
            this.entItem2.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            //GL11.glTranslatef((float)te.xCoord + 0.5F, (float)te.yCoord + 1.02F, (float)te.zCoord + 0.3F);
            GL11.glScalef(2f,2f,2f);
            GL11.glRotatef(180, 0, 0, 1);      
            GL11.glRotatef(rotation, 0.0F, -1.0F, 0.0F);
            if(tileEntity.flip[1]==true)
            {
            	GL11.glRotatef(180, 0, 0, 1);
            	GL11.glTranslatef(0.2f, -0.8f, 0);
            }
            
            if(tileEntity.getStackInSlot(1).getItem() instanceof ToolCore)
            {
                GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(0.5f, -0.325f, 0);
            }
            
            RenderManager.instance.renderEntityWithPosYaw(entItem2, -0.1, 0.2, 0.23, 0, 0);           
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
            }
            
            //middle slot
            slot = 2;
            if(tileEntity.getStackInSlot(slot)!=null)
            {
            if((entItem3 == null) || entItem3.getEntityItem().getItem() != tileEntity.getStackInSlot(slot).getItem())
             entItem3 = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(slot));
            GL11.glPushMatrix();
            this.entItem3.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GL11.glScalef(2f,2f,2f);
            if(rotation == 90)
            	GL11.glTranslatef(0.3f, 0, 0.0f);
            if(rotation == -90)
            	GL11.glTranslatef(-0.3f, 0, 0.0f);
            GL11.glRotatef(225, 0, 0, 1);
            GL11.glRotatef(rotation, 1F, 1F, 0F); 
            if(tileEntity.flip[2]==true)
            {
            	GL11.glRotatef(180, 0, 0, 1);
            	GL11.glTranslatef(-0.5f, -0.5f, 0);
            }
            
            if(tileEntity.getStackInSlot(2).getItem() instanceof ToolCore)
            {
                GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(-0.1125f, -0.5125f, 0);
            }
            
            RenderManager.instance.renderEntityWithPosYaw(entItem3, 0.3, 0.1, 0.16, 0, 0);           
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
            }
            
            //shield slot
            slot = 3;
            if(tileEntity.getStackInSlot(slot)!=null)
            {
            if((entItem4 == null) || entItem4.getEntityItem().getItem() != tileEntity.getStackInSlot(slot).getItem())
             entItem4 = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(slot));
            GL11.glPushMatrix();
            this.entItem4.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GL11.glScalef(2f,2f,2f);           
            GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
            if(tileEntity.flip[3]==true)
            {
            	GL11.glRotatef(180, 0, 0, 1);
            	GL11.glTranslatef(0.0f, 1.0f, 0);
            }
            
            
            RenderManager.instance.renderEntityWithPosYaw(entItem4, 0, -0.7, -0.01, 0, 0); 
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
            }
            
            
            GL11.glPopMatrix();
            
            entItem = null;
            entItem2= null;
            entItem3= null;
            entItem4= null;
    }

}
