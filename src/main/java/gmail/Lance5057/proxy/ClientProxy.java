package gmail.Lance5057.proxy;

import gmail.Lance5057.blocks.Renderer_CrestMount;
import gmail.Lance5057.blocks.TileEntity_CrestMount;
import gmail.Lance5057.proxy.CommonProxy;
import gmail.Lance5057.items.ModelTinkerArmor;
import gmail.Lance5057.items.TinkerArmor;
import net.minecraft.client.model.ModelBiped;
import cpw.mods.fml.client.registry.ClientRegistry;


public class ClientProxy extends CommonProxy {
	private static final ModelTinkerArmor tutChest = new ModelTinkerArmor(1.0f);
	
        @Override
        public void registerRenderers() {
                // This is for rendering entities and so forth later on
        	ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_CrestMount.class, new Renderer_CrestMount());
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