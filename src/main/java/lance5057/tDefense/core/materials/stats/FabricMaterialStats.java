package lance5057.tDefense.core.materials.stats;

public class FabricMaterialStats extends ArmorMaterialStats {
	public final static String TYPE = "fabric";

	public FabricMaterialStats(int durability, int rating, int toughness, float potency) {
		super(durability, rating, toughness,potency, TYPE);
	}

}