package lance5057.tDefense.util;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import gnu.trove.set.hash.TLinkedHashSet;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

public class TDRegistry {
	private static final Set<ArmorCore> armor = new TLinkedHashSet<>();
	  private static final Set<IToolPart> armorParts = new TLinkedHashSet<>();
	  private static final Set<ArmorCore> armorStationCrafting = Sets.newLinkedHashSet();
	  private static final Set<ArmorCore> armorForgeCrafting = Sets.newLinkedHashSet();
	  
	  public static void registerTool(ArmorCore tool) {
		  armor.add(tool);

		    for(PartMaterialType pmt : tool.getRequiredComponents()) {
		      for(IToolPart tp : pmt.getPossibleParts()) {
		        TinkerRegistry.registerToolPart(tp);
		      }
		    }
		  }
	  
	  /** Adds a armor to the Crafting UI of both the armor Station as well as the armor Forge */
	  public static void registerArmorCrafting(ArmorCore armor) {
	    registerArmorStationCrafting(armor);
	    registerArmorForgeCrafting(armor);
	  }

	  /** Adds a armor to the Crafting UI of the armor Station */
	  public static void registerArmorStationCrafting(ArmorCore armor) {
	    armorStationCrafting.add(armor);
	  }

	  public static ImmutableSet<ArmorCore> getArmorStationCrafting() {
	    return ImmutableSet.copyOf(armorStationCrafting);
	  }

	  /** Adds a armor to the Crafting UI of the armor Forge */
	  public static void registerArmorForgeCrafting(ArmorCore armor) {
	    armorForgeCrafting.add(armor);
	  }

	  public static ImmutableSet<ArmorCore> getArmorForgeCrafting() {
	    return ImmutableSet.copyOf(armorForgeCrafting);
	  }
	  
	  public static Set<ArmorCore> getArmor() {
		    return ImmutableSet.copyOf(armor);
		  }
}
