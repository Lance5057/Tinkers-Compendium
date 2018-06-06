package lance5057.tDefense.core.materials.stats;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;

public class ShieldMaterialStats extends AbstractMaterialStats  {

	public final static String TYPE = "shield";

	  public final static String LOC_Durability   = "stat.shield.durability.name";
	  public final static String LOC_PercentBlocked  = "stat.shield.percentblocked.name";

	  public final static String LOC_DurabilityDesc    = "stat.shield.durability.desc";
	  public final static String LOC_PercentBlockedDesc   = "stat.shield.percentblocked.desc";

	  public final static String COLOR_Durability = CustomFontColor.valueToColorCode(1f);
	  public final static String COLOR_PercentBlocked    = CustomFontColor.encodeColor(215, 100, 100);
	  
	  public final int durability; // usually between 1 and 1000
	  public final int percentBlocked; // vanilla is 33%

	  public ShieldMaterialStats(int durability, int percentBlocked) {
	    super(TYPE);
	    this.durability = durability;
	    this.percentBlocked = percentBlocked;
	    
	  }

	  @Override
	  public List<String> getLocalizedInfo() {
	    List<String> info = Lists.newArrayList();

	    info.add(formatDurability(durability));
	    info.add(formatPercentBlocked(percentBlocked));

	    return info;
	  }

	  public static String formatDurability(int durability) {
	    return formatNumber(LOC_Durability, COLOR_Durability, durability);
	  }

	  public static String formatDurability(int durability, int ref) {
	    return String.format("%s: %s%s%s/%s%s",
	                         Util.translate(LOC_Durability),
	                         CustomFontColor.valueToColorCode((float) durability / (float) ref),
	                         Util.df.format(durability),
	                         TextFormatting.GRAY.toString(),
	                         COLOR_Durability,
	                         Util.df.format(ref))
	           + TextFormatting.RESET;
	  }

	  public static String formatPercentBlocked(int percent) {
	    return formatNumber(LOC_PercentBlocked, COLOR_PercentBlocked, percent) + "%";
	  }
	  
	  @Override
	  public List<String> getLocalizedDesc() {
	    List<String> info = Lists.newArrayList();

	    info.add(Util.translate(LOC_DurabilityDesc));
	    info.add(Util.translate(LOC_PercentBlockedDesc));

	    return info;
	  }
}
