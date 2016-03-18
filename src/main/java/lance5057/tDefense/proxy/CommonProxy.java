package lance5057.tDefense.proxy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.blocks.crestMount.Container_CrestMount;
import lance5057.tDefense.core.blocks.crestMount.Gui_CrestMount;
import lance5057.tDefense.core.blocks.crestMount.TileEntity_CrestMount;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.Container_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.Gui_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.TileEntity_FinishingAnvil;
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
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == TinkersDefense.GUI_CREST_INV)
		{
			return new Container_CrestMount(player.inventory, (TileEntity_CrestMount) world.getTileEntity(x, y, z));
		}
		if(ID == TinkersDefense.GUI_ANVIL_INV)
		{
			return new Container_FinishingAnvil(player.inventory, (TileEntity_FinishingAnvil) world.getTileEntity(x, y, z));
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == TinkersDefense.GUI_CREST_INV)
		{
			return new Gui_CrestMount(player.inventory, (TileEntity_CrestMount) world.getTileEntity(x, y, z));
		}
		if(ID == TinkersDefense.GUI_ANVIL_INV)
		{
			return new Gui_FinishingAnvil(player.inventory, (TileEntity_FinishingAnvil) world.getTileEntity(x, y, z));
		}
		return null;
	}
}
