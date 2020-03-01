package lance5057.tDefense.core.materials.stats;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;

public class BackpackMaterialStats extends AbstractMaterialStats {
	public final static String LOC_Durability = "stat.backpack.durability.name";
	public final static String LOC_Width = "stat.backpack.width.name";
	public final static String LOC_Height = "stat.backpack.height.name";

	public final static String LOC_DurabilityDesc = "stat.backpack.durability.desc";
	public final static String LOC_WidthDesc = "stat.backpack.width.desc";
	public final static String LOC_HeightDesc = "stat.backpack.height.desc";

	public final static String COLOR_Durability = CustomFontColor.valueToColorCode(1f);
	public final static String COLOR_Width = CustomFontColor.encodeColor(215, 100, 100);
	public final static String COLOR_Height = CustomFontColor.encodeColor(215, 100, 100);

	public final int durability; // usually between 1 and 1000
	public final int width; // 9
	public final int height; // 3 - Default Chest

	public BackpackMaterialStats(int durability, int width, int height, String TYPE) {
		super(TYPE);
		this.durability = durability;
		this.width = width;
		this.height = height;
	}

	@Override
	public List<String> getLocalizedInfo() {
		List<String> info = Lists.newArrayList();

		info.add(formatDurability(durability));
		info.add(formatWidth(width));
		info.add(formatHeight(height));

		return info;
	}

	public static String formatDurability(int durability) {
		return formatNumber(LOC_Durability, COLOR_Durability, durability);
	}

	public static String formatDurability(int durability, int ref) {
		return String.format("%s: %s%s%s/%s%s", Util.translate(LOC_Durability),
				CustomFontColor.valueToColorCode((float) durability / (float) ref), Util.df.format(durability),
				TextFormatting.GRAY.toString(), COLOR_Durability, Util.df.format(ref)) + TextFormatting.RESET;
	}

	public static String formatWidth(int width) {
		return formatNumber(LOC_Width, COLOR_Width, width);
	}

	public static String formatHeight(int percent) {
		return formatNumber(LOC_Height, COLOR_Height, percent);
	}

	@Override
	public List<String> getLocalizedDesc() {
		List<String> info = Lists.newArrayList();	

		info.add(Util.translate(LOC_DurabilityDesc));
		info.add(Util.translate(LOC_WidthDesc));
		info.add(Util.translate(LOC_HeightDesc));

		return info;
	}
}
