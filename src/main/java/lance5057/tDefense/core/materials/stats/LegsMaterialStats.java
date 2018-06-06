package lance5057.tDefense.core.materials.stats;

public class LegsMaterialStats extends ArmorMaterialStats {
	public final static String TYPE = "legs";

	public LegsMaterialStats(int durability, int rating, int toughness, float potency) {
		super(durability, rating, toughness,potency, TYPE);
	}

}