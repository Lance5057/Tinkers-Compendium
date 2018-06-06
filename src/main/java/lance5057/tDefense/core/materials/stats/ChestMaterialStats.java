package lance5057.tDefense.core.materials.stats;

public class ChestMaterialStats extends ArmorMaterialStats {
	public final static String TYPE = "chest";

	public ChestMaterialStats(int durability, int rating, int toughness, float potency) {
		super(durability, rating, toughness,potency, TYPE);
	}

}