package lance5057.tDefense.armor.materials;

import java.util.List;

import net.minecraft.util.text.TextFormatting;

import com.google.common.collect.Lists;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class MaterialCloth extends AbstractMaterialStats  {

	public final static String TYPE = "cloth";

	  public final static String LOC_Durability   = "stat.cloth.durability.name";
	  //public final static String LOC_DMGReduction  = "stat.cloth.percentblocked.name";

	  public final static String LOC_DurabilityDesc    = "stat.cloth.durability.desc";
	  //public final static String LOC_DMGReductionDesc   = "stat.cloth.percentblocked.desc";

	  public final static String COLOR_Durability = CustomFontColor.valueToColorCode(1f);
	  //public final static String COLOR_DMGReduction    = CustomFontColor.encodeColor(215, 100, 100);
	  
	  public final int durability; // usually between 1 and 1000
	 // public final int DMGReduction; // vanilla is 33%

	  public MaterialCloth(int durability) {
	    super(TYPE);
	    this.durability = durability;
	    //this.DMGReduction = percentBlocked;
	    
	  }

	  @Override
	  public List<String> getLocalizedInfo() {
	    List<String> info = Lists.newArrayList();

	    info.add(formatDurability(durability));
	    //info.add(formatPercentBlocked(DMGReduction));

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

//	  public static String formatPercentBlocked(int percent) {
//	    return formatNumber(LOC_DMGReduction, COLOR_DMGReduction, percent) + "%";
//	  }
//	  
	  @Override
	  public List<String> getLocalizedDesc() {
	    List<String> info = Lists.newArrayList();

	    info.add(Util.translate(LOC_DurabilityDesc));
	    //info.add(Util.translate(LOC_DMGReductionDesc));

	    return info;
	  }
}
