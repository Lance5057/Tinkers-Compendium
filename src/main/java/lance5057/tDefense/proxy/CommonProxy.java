package lance5057.tDefense.proxy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.blocks.crestMount.Container_CrestMount;
import lance5057.tDefense.core.blocks.crestMount.Gui_CrestMount;
import lance5057.tDefense.core.blocks.crestMount.TileEntity_CrestMount;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;


public class CommonProxy implements IGuiHandler
{
	//public static ModifierSoulHandler	SoulHandler	= null;
	
	public void preInit()
	{
	}

	public void init()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(TinkersDefense.instance, this);
	}

	public void registerTileEntitySpecialRenderer()
	{

	}
	
	public void reloadRenderers()
	{

	}

	public void postInit() {
		// TODO Auto-generated method stub
		
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
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == TinkersDefense.GUI_CREST_INV)
			return new Container_CrestMount(player.inventory,
					(TileEntity_CrestMount) world.getTileEntity(new BlockPos(x, y, z)));
//		if(ID == TinkersDefense.GUI_ANVIL_INV)
//			return new Container_FinishingAnvil(player.inventory,
//					(TileEntity_FinishingAnvil) world.getTileEntity(x, y, z));

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == TinkersDefense.GUI_CREST_INV)
			return new Gui_CrestMount(player.inventory,
					(TileEntity_CrestMount) world.getTileEntity(new BlockPos(x, y, z)));
//		if(ID == TinkersDefense.GUI_ANVIL_INV)
//			return new Gui_FinishingAnvil(player.inventory,
//					(TileEntity_FinishingAnvil) world.getTileEntity(x, y, z));
		return null;
	}
}
