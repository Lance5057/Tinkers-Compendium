package lance5057.tDefense.core.materials.stats;

public class FeetMaterialStats extends ArmorMaterialStats {
	public final static String TYPE = "feet";

	public FeetMaterialStats(int durability, int rating, int toughness, float potency) {
		super(durability, rating, toughness,potency, TYPE);
	}

}