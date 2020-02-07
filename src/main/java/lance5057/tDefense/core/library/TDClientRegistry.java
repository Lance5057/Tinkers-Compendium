package lance5057.tDefense.core.library;

import java.util.Map;

import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.Util;
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
  private static final Map<Item, Integer> toolVariants = Maps.newLinkedHashMap();
  

  public static void addArmorBuilding(ArmorBuildGuiInfo info) {
	  armorBuildInfo.put(info.armor.getItem(), info);
  }

  public static ArmorBuildGuiInfo getArmorBuildInfoForArmor(Item armor) {
    return armorBuildInfo.get(armor);
  }

  public static void clear() {
	  armorBuildInfo.clear();
  }
  
  public static void addVarient(Item item, int i)
  {
	  toolVariants.put(item, i);
  }
  
  public static int getVarient(Item item)
  {
	  Integer i = toolVariants.get(item);
	  if(i==null)
		  return 0;
	  return i;
  }

  /*---------------------------------------------------------------------------
  | MATERIAL TEXTURE CREATION                                                 |
  ---------------------------------------------------------------------------*/
  private static final Map<String, AbstractColoredTexture> textureProcessors = Maps.newHashMap();
  
  /*---------------------------------------------------------------------------
  | MODIFIER MODELS                                                |
  ---------------------------------------------------------------------------*/
  private static final Map<String, ModelBiped> modifierModels = Maps.newLinkedHashMap();
  
  public static void addModifierModel(String name, ModelBiped model) {
	  modifierModels.put(name, model);
  }

  public static ModelBiped getModifierModel(String name) {
    return modifierModels.get(name);
  }

}