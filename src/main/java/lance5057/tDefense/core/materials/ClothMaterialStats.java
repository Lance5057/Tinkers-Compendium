package lance5057.tDefense.core.materials;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;

public class ClothMaterialStats extends AbstractMaterialStats
{
	public final static String TYPE = "chest";

	public final static String	LOC_Durability		= "stat.cloth.durability.name";
	public final static String	LOC_MagicPotency	= "stat.cloth.potency.name";

	public final static String	LOC_DurabilityDesc		= "stat.cloth.durability.desc";
	public final static String	LOC_MagicPotencyDesc		= "stat.cloth.potency.desc";

	public final static String	COLOR_Durability		= CustomFontColor.valueToColorCode(1f);
	public final static String	COLOR_MagicPotency		= CustomFontColor.encodeColor(215, 100, 100);

	public final int	durability;	// usually between 1 and 1000
	public final float	potency;		// 1 - 100

	public ClothMaterialStats(int durability, float potency)
	{
		super(TYPE);
		this.durability = durability;
		this.potency = potency;
	}

	@Override
	public List<String> getLocalizedInfo()
	{
		List<String> info = Lists.newArrayList();

		info.add(formatDurability(durability));
		info.add(formatMagicPotency(potency));

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

	public static String formatMagicPotency(float potency2)
	{
		return formatNumber(LOC_MagicPotency, COLOR_MagicPotency, potency2);
	}

	@Override
	public List<String> getLocalizedDesc()
	{
		List<String> info = Lists.newArrayList();

		info.add(Util.translate(LOC_DurabilityDesc));
		info.add(Util.translate(LOC_MagicPotencyDesc));

		return info;
	}
}