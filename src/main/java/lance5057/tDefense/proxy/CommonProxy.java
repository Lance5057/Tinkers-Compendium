package lance5057.tDefense.proxy;

import lance5057.tDefense.TD_Commands;
import net.minecraftforge.client.ClientCommandHandler;


public class CommonProxy// implements IGuiHandler
{
	//public static ModifierSoulHandler	SoulHandler	= null;
	
	public void preInit()
	{
	}

	public void Init()
	{
	}

	public void registerTileEntitySpecialRenderer()
	{

	}
	
	public void reloadRenderers()
	{

	}

//	public EntityPlayer getPlayerEntity(MessageContext ctx)
//	{
//		return ctx.getServerHandler().playerEntity;
//	}
//
//	public ModelBiped getArmorModel(int id)
//	{
//		return null;
//	}
//
//	public World getClientWorld()
//	{
//		return null;
//	}
//
//	@Override
//	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
//	{
//		if(ID == TinkersDefense.GUI_CREST_INV)
//			return new Container_CrestMount(player.inventory,
//					(TileEntity_CrestMount) world.getTileEntity(x, y, z));
//		if(ID == TinkersDefense.GUI_ANVIL_INV)
//			return new Container_FinishingAnvil(player.inventory,
//					(TileEntity_FinishingAnvil) world.getTileEntity(x, y, z));
//
//		return null;
//	}
//
//	@Override
//	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
//	{
//		if(ID == TinkersDefense.GUI_CREST_INV)
//			return new Gui_CrestMount(player.inventory,
//					(TileEntity_CrestMount) world.getTileEntity(x, y, z));
//		if(ID == TinkersDefense.GUI_ANVIL_INV)
//			return new Gui_FinishingAnvil(player.inventory,
//					(TileEntity_FinishingAnvil) world.getTileEntity(x, y, z));
//		return null;
//	}
}
