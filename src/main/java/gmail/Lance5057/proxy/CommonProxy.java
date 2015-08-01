package gmail.Lance5057.proxy;

import gmail.Lance5057.TinkersDefense;
import gmail.Lance5057.containers.Container_CrestMount;
import gmail.Lance5057.containers.Container_FinishingAnvil;
import gmail.Lance5057.gui.Gui_CrestMount;
import gmail.Lance5057.gui.Gui_FinishingAnvil;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import gmail.Lance5057.tileentities.TileEntity_FinishingAnvil;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy implements IGuiHandler 
{
        public void registerRenderers() 
        {
        }
        
        public void registerTileEntitySpecialRenderer()
        {
        	
        }
        
        public EntityPlayer getPlayerEntity(MessageContext ctx) 
        {
        	return ctx.getServerHandler().playerEntity;
        }
        
        public ModelBiped getArmorModel(int id)
        { 
        	return null;
        }

        public World getClientWorld()
        {
        return null;
        }

		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) 
		{
			if (ID == TinkersDefense.GUI_CREST_INV)
			{
				return new Container_CrestMount(player.inventory, (TileEntity_CrestMount)world.getTileEntity(x, y, z));
			}
			if (ID == TinkersDefense.GUI_ANVIL_INV)
			{
				return new Container_FinishingAnvil(player.inventory, (TileEntity_FinishingAnvil)world.getTileEntity(x, y, z));
			}
			
			return null;
		}

		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) 
		{
			if (ID == TinkersDefense.GUI_CREST_INV)
			{
				return new Gui_CrestMount(player.inventory, (TileEntity_CrestMount)world.getTileEntity(x, y, z));
			}
			if (ID == TinkersDefense.GUI_ANVIL_INV)
			{
				return new Gui_FinishingAnvil(player.inventory, (TileEntity_FinishingAnvil)world.getTileEntity(x, y, z));
			}
			return null;
		}
} 