package gmail.Lance5057.gui;

import gmail.Lance5057.blocks.TileEntity_CrestMount;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler_CrestMount implements IGuiHandler {
    //returns an instance of the Container you made earlier
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if(tileEntity instanceof TileEntity_CrestMount){
                    return new Container_CrestMount(player.inventory, (TileEntity_CrestMount) tileEntity);
            }
            return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if(tileEntity instanceof TileEntity_CrestMount){
                    return new Gui_CrestMount((Container_CrestMount) new Container_CrestMount(player.inventory, new TileEntity_CrestMount()));
            }
            return null;

    }
}
