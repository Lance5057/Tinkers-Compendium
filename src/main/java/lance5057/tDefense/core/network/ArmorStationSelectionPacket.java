package lance5057.tDefense.core.network;

import io.netty.buffer.ByteBuf;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.core.workstations.gui.armorstation.ArmorStationContainer;
import lance5057.tDefense.core.workstations.gui.armorstation.ArmorStationGui;
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

public class ArmorStationSelectionPacket extends AbstractPacketThreadsafe {

  public ArmorCore armor;
  public int activeSlots;

  public ArmorStationSelectionPacket() {
  }
 
  public ArmorStationSelectionPacket(ArmorCore tool, int activeSlots) {
    this.armor = tool;
    this.activeSlots = activeSlots;
  }

  @Override
  public void handleClientSafe(NetHandlerPlayClient netHandler) {
    Container container = Minecraft.getMinecraft().player.openContainer;
    if(container instanceof ArmorStationContainer) {
      ((ArmorStationContainer) container).setToolSelection(armor, activeSlots);
      if(Minecraft.getMinecraft().currentScreen instanceof ArmorStationGui) {
        ((ArmorStationGui) Minecraft.getMinecraft().currentScreen).onToolSelectionPacket(this);
      }
    }
  }

  @Override
  public void handleServerSafe(NetHandlerPlayServer netHandler) {
    Container container = netHandler.player.openContainer;
    if(container instanceof ArmorStationContainer) {
      ((ArmorStationContainer) container).setToolSelection(armor, activeSlots);

      // find all people who also have the same gui open and update them too
      WorldServer server = netHandler.player.getServerWorld();
      for(EntityPlayer player : server.playerEntities) {
        if(player == netHandler.player) {
          continue;
        }
        if(player.openContainer instanceof ArmorStationContainer) {
          if(((BaseContainer) container).sameGui((BaseContainer) player.openContainer)) {
            ((ArmorStationContainer) player.openContainer).setToolSelection(armor, activeSlots);
            // same gui, send him an update
            TinkerNetwork.sendTo(this, (EntityPlayerMP) player);
          }
        }
      }
    }
  }

  @Override
  public void fromBytes(ByteBuf buf) {
    int id = buf.readShort();
    if(id > -1) {
      Item item = Item.getItemById(id);
      if(item instanceof ArmorCore) {
        armor = (ArmorCore) item;
      }
    }

    activeSlots = buf.readInt();
  }

  @Override
  public void toBytes(ByteBuf buf) {
    if(armor == null) {
      buf.writeShort(-1);
    }
    else {
      buf.writeShort(Item.getIdFromItem(armor));
    }

    buf.writeInt(activeSlots);
  }
}