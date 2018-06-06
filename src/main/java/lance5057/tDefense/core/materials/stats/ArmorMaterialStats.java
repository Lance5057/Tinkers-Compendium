package lance5057.tDefense.core.materials.stats;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;

public class ArmorMaterialStats extends AbstractMaterialStats {
	public final static String LOC_Durability = "stat.armor.durability.name";
	public final static String LOC_ArmorRating = "stat.armor.rating.name";
	public final static String LOC_ArmorToughness = "stat.armor.toughness.name";
	public final static String LOC_MagicPotency = "stat.armor.potency.name";

	public final static String LOC_DurabilityDesc = "stat.armor.durability.desc";
	public final static String LOC_ArmorRatingDesc = "stat.armor.rating.desc";
	public final static String LOC_ArmorToughnessDesc = "stat.armor.toughness.desc";
	public final static String LOC_MagicPotencyDesc = "stat.cloth.potency.desc";

	public final static String COLOR_Durability = CustomFontColor.valueToColorCode(1f);
	public final static String COLOR_ArmorRating = CustomFontColor.encodeColor(215, 100, 100);
	public final static String COLOR_ArmorToughness = CustomFontColor.encodeColor(215, 100, 100);
	public final static String COLOR_MagicPotency = CustomFontColor.encodeColor(215, 100, 100);

	public final int durability; // usually between 1 and 1000
	public final int rating; // 1 - 20
	public final int toughness;
	public final float potency;

	public ArmorMaterialStats(int durability, int rating, int toughness, float potency, String TYPE) {
		super(TYPE);
		this.durability = durability;
		this.rating = rating;
		this.toughness = toughness;
		this.potency = potency;
	}

	@Override
	public List<String> getLocalizedInfo() {
		List<String> info = Lists.newArrayList();

		info.add(formatDurability(durability));
		info.add(formatArmorRating(rating));
		info.add(formatArmorToughness(toughness));
		info.add(formatMagicPotency(potency));

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

	public static String formatArmorRating(int percent) {
		return formatNumber(LOC_ArmorRating, COLOR_ArmorRating, percent);
	}

	public static String formatArmorToughness(int percent) {
		return formatNumber(LOC_ArmorToughness, COLOR_ArmorToughness, percent);
	}
	
	public static String formatMagicPotency(float potency2)
	{
		return formatNumber(LOC_MagicPotency, COLOR_MagicPotency, potency2);
	}

	@Override
	public List<String> getLocalizedDesc() {
		List<String> info = Lists.newArrayList();	

		info.add(Util.translate(LOC_DurabilityDesc));
		info.add(Util.translate(LOC_ArmorRatingDesc));
		info.add(Util.translate(LOC_ArmorToughnessDesc));
		info.add(Util.translate(LOC_MagicPotencyDesc));

		return info;
	}
}
