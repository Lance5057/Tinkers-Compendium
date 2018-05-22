package lance5057.tDefense.util;

import com.google.common.collect.Maps;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.apache.logging.log4j.Logger;

import java.util.Map;

import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.client.texture.AbstractColoredTexture;

@SideOnly(Side.CLIENT)
public final class TDClientRegistry {

  // the logger for the library
  public static final Logger log = Util.getLogger("API-Client");

  private TDClientRegistry() {
  }

  /*---------------------------------------------------------------------------
  | GUI & CRAFTING                                                            |
  ---------------------------------------------------------------------------*/
  private static final Map<Item, ArmorBuildGuiInfo> armorBuildInfo = Maps.newLinkedHashMap();

  public static void addArmorBuilding(ArmorBuildGuiInfo info) {
	  armorBuildInfo.put(info.armor.getItem(), info);
  }

  public static ArmorBuildGuiInfo getArmorBuildInfoForArmor(Item armor) {
    return armorBuildInfo.get(armor);
  }

  public static void clear() {
	  armorBuildInfo.clear();
  }

  /*---------------------------------------------------------------------------
  | MATERIAL TEXTURE CREATION                                                 |
  ---------------------------------------------------------------------------*/
  private static final Map<String, AbstractColoredTexture> textureProcessors = Maps.newHashMap();

}