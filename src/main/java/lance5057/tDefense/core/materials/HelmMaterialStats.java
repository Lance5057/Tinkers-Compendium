package lance5057.tDefense.core.materials;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;

public class HelmMaterialStats extends AbstractMaterialStats
{
	public final static String TYPE = "helm";

	public final static String	LOC_Durability		= "stat.helm.armor.durability.name";
	public final static String	LOC_ArmorRating		= "stat.helm.armor.rating.name";
	public final static String	LOC_ArmorToughness	= "stat.helm.armor.toughness.name";

	public final static String	LOC_DurabilityDesc		= "stat.helm.armor.durability.desc";
	public final static String	LOC_ArmorRatingDesc		= "stat.helm.armor.rating.desc";
	public final static String	LOC_ArmorToughnessDesc	= "stat.helm.armor.toughness.desc";

	public final static String	COLOR_Durability		= CustomFontColor.valueToColorCode(1f);
	public final static String	COLOR_ArmorRating		= CustomFontColor.encodeColor(215, 100, 100);
	public final static String	COLOR_ArmorToughness	= CustomFontColor.encodeColor(215, 100, 100);

	public final int	durability;	// usually between 1 and 1000
	public final int	rating;		// 1 - 20
	public final int	toughness;

	public HelmMaterialStats(int durability, int rating, int toughness)
	{
		super(TYPE);
		this.durability = durability;
		this.rating = rating;
		this.toughness = toughness;
	}

	@Override
	public List<String> getLocalizedInfo()
	{
		List<String> info = Lists.newArrayList();

		info.add(formatDurability(durability));
		info.add(formatArmorRating(rating));
		info.add(formatArmorToughness(toughness));
		
		return info;
	}

	public static String formatDurability(int durability)
	{
		return formatNumber(LOC_Durability, COLOR_Durability, durability);
	}

	public static String formatDurability(int durability, int ref)
	{
		return String.format("%s: %s%s%s/%s%s",
			Util.translate(LOC_Durability),
			CustomFontColor.valueToColorCode((float) durability / (float) ref),
			Util.df.format(durability),
			TextFormatting.GRAY.toString(),
			COLOR_Durability,
			Util.df.format(ref)) + TextFormatting.RESET;
	}

	public static String formatArmorRating(int percent)
	{
		return formatNumber(LOC_ArmorRating, COLOR_ArmorRating, percent);
	}

	public static String formatArmorToughness(int percent)
	{
		return formatNumber(LOC_ArmorToughness, COLOR_ArmorToughness, percent);
	}
	
	@Override
	public List<String> getLocalizedDesc()
	{
		List<String> info = Lists.newArrayList();

		info.add(Util.translate(LOC_DurabilityDesc));
		info.add(Util.translate(LOC_ArmorRatingDesc));
		info.add(Util.translate(LOC_ArmorToughnessDesc));

		return info;
	}
}
