package lance5057.tDefense.core.materials.stats;

public class HelmMaterialStats extends ArmorMaterialStats {
		public final static String TYPE = "helm";

		public HelmMaterialStats(int durability, int rating, int toughness, float potency) {
			super(durability, rating, toughness,potency, TYPE);
		}

	}