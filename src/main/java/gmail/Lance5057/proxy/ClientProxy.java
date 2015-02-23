package gmail.Lance5057.proxy;

import gmail.Lance5057.blocks.Renderer_CrestMount;
import gmail.Lance5057.items.ModelTinkerArmor;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;


public class ClientProxy extends CommonProxy {
	private static final ModelTinkerArmor tutChest = new ModelTinkerArmor(1.0f);
	
        @Override
        public void registerRenderers() {
                // This is for rendering entities and so forth later on
        	ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_CrestMount.class, new Renderer_CrestMount());
        }
        @Override
        public World getClientWorld()
        {
        return FMLClientHandler.instance().getClient().theWorld;
        }
        
        public void registerTileEntitySpecialRenderer()
        {
        	
        }
        @Override
        public ModelBiped getArmorModel(int id)
        { 
        	switch (id)
        	{
		        case 0: return tutChest;
		        default: break; 
	        } 
        		return tutChest; //default, if whenever you should have passed on a wrong id
        } 
      
        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
        {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te != null && te instanceof TileEntity_CrestMount)
        {
        	return null;
			//return new Gui_CrestMount((Container_CrestMount) new Container_CrestMount(player.inventory, new TileEntity_CrestMount()));
        }
        else
        {
        return null;
        }
        }
        }