package lance5057.tDefense.core.network;

import io.netty.buffer.ByteBuf;
import lance5057.tDefense.core.workstations.gui.finishinganvil.FinishingAnvilContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.WorldServer;
import slimeknights.mantle.inventory.BaseContainer;
import slimeknights.mantle.network.AbstractPacketThreadsafe;
import slimeknights.tconstruct.common.TinkerNetwork;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.tools.common.client.GuiToolStation;
import slimeknights.tconstruct.tools.common.inventory.ContainerToolStation;

public class FinishingAnvilSelectionPacket extends AbstractPacketThreadsafe {

	int anvil0 = 0;
	int anvil1 = 0;
	int anvil2 = 0;
	int anvil3 = 0;
	int anvil4 = 0;

	public FinishingAnvilSelectionPacket() {
	}

	public FinishingAnvilSelectionPacket(int anvil0,int anvil1,int anvil2,int anvil3,int anvil4) {
		this.anvil0 = anvil0;
		this.anvil1 = anvil1;
		this.anvil2 = anvil2;
		this.anvil3 = anvil3;
		this.anvil4 = anvil4;
	}

	@Override
	public void handleClientSafe(NetHandlerPlayClient netHandler) {
		Container container = Minecraft.getMinecraft().player.openContainer;
		if (container instanceof FinishingAnvilContainer) {
			((FinishingAnvilContainer) container).anvil0 = anvil0;
//			if (Minecraft.getMinecraft().currentScreen instanceof GuiToolStation) {
//				((GuiToolStation) Minecraft.getMinecraft().currentScreen).onToolSelectionPacket(this);
//			}
		}
	}

	@Override
	public void handleServerSafe(NetHandlerPlayServer netHandler) {
		Container container = netHandler.player.openContainer;
		if (container instanceof FinishingAnvilContainer) {
			((FinishingAnvilContainer) container).anvil0 = anvil0;
			((FinishingAnvilContainer) container).anvil1 = anvil1;
			((FinishingAnvilContainer) container).anvil2 = anvil2;
			((FinishingAnvilContainer) container).anvil3 = anvil3;
			((FinishingAnvilContainer) container).anvil4 = anvil4;

			// find all people who also have the same gui open and update them too
			WorldServer server = netHandler.player.getServerWorld();
			for (EntityPlayer player : server.playerEntities) {
				if (player == netHandler.player) {
					continue;
				}
				if (player.openContainer instanceof FinishingAnvilContainer) {
					if (((BaseContainer) container).sameGui((BaseContainer) player.openContainer)) {
						// ((ContainerToolStation) player.openContainer).setToolSelection(tool,
						// activeSlots);
						// same gui, send him an update
						TinkerNetwork.sendTo(this, (EntityPlayerMP) player);
					}
				}
			}
		}
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		anvil0 = buf.readInt();
		anvil1 = buf.readInt();
		anvil2 = buf.readInt();
		anvil3 = buf.readInt();
		anvil4 = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(anvil0);
		buf.writeInt(anvil1);
		buf.writeInt(anvil2);
		buf.writeInt(anvil3);
		buf.writeInt(anvil4);
	}
}