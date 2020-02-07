package lance5057.tDefense.core.library;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.utils.TagUtil;

public final class ArmorTags {
	/** The stored dynamic texture location for this piece of armor */
	public static final String DynTex = "DynTex";
	public static final String TexLoc = "TexLoc";

	/** Finishing Anvil **/
	public static final String AnvilBase = "AnvilBase";
	public static final String ModelType = "Type";
	public static final String ModelParts = "ModelParts";

	/** Armor **/
	public static final String ArmorBaseTag = "Armor";

	public static final String ArmorRating = "Rating";
	public static final String ArmorToughness = "Toughness";
	public static final String ArmorPotency = "Potency";

	/** Helmet visor **/
	public static final String Visor = "Visor";
	public static final String VisorTime = "VisorTime";

	/** Trait Specials **/
	// Soggy Trait
	public static final String Water = "Water";

	// Discharge Trait
	public static final String Charge = "Charge";
	
	//Ranked Trait
	public static final String Kills = "kills";
	
	public static NBTTagCompound getFinishingAnvilIDs(ItemStack stack)
	{
		NBTTagCompound tag = TagUtil.getToolTag(stack);
		if (!tag.hasKey(ArmorTags.AnvilBase)) {
			tag.setTag(ArmorTags.AnvilBase, new NBTTagCompound());
		}
		return tag.getCompoundTag(ArmorTags.AnvilBase);
	}
}
