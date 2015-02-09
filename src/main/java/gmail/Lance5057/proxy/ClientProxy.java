package gmail.Lance5057.proxy;

import gmail.Lance5057.blocks.Renderer_CrestMount;
import gmail.Lance5057.blocks.TileEntity_CrestMount;
import gmail.Lance5057.items.ModelTinkerArmor;
import net.minecraft.client.model.ModelBiped;
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
      
}