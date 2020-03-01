package lance5057.tDefense.core.network;

import io.netty.buffer.ByteBuf;
import lance5057.tDefense.core.workstations.gui.finishinganvil.FinishingAnvilContainer;
import lance5057.tDefense.core.workstations.gui.finishinganvil.FinishingAnvilGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.WorldServer;
import slimeknights.mantle.inventory.BaseContainer;
import slimeknights.mantle.network.AbstractPacketThreadsafe;
import slimeknights.tconstruct.common.TinkerNetwork;

public class FinishingAnvilSelectionPacket extends AbstractPacketThreadsafe {

	int anvil0 = 0;

	public FinishingAnvilSelectionPacket() {
	}

	public FinishingAnvilSelectionPacket(int anvil0) {
		this.anvil0 = anvil0;
	}

	@Override
	public void handleClientSafe(NetHandlerPlayClient netHandler) {
		Container container = Minecraft.getMinecraft().player.openContainer;
		if (container instanceof FinishingAnvilContainer) {
			((FinishingAnvilContainer) container).anvil0 = anvil0;
//			if (Minecraft.getMinecraft().currentScreen instanceof GuiToolStation) {
				((FinishingAnvilGui) Minecraft.getMinecraft().currentScreen).onToolSelectionPacket(this);
//			}
		}
	}

	@Override
	public void handleServerSafe(NetHandlerPlayServer netHandler) {
		Container container = netHandler.player.openContainer;
		if (container instanceof FinishingAnvilContainer) {
			((FinishingAnvilContainer) container).anvil0 = anvil0;

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
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(anvil0);
	}
}