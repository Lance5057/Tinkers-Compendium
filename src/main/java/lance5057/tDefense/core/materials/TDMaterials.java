package lance5057.tDefense.core.materials;

import static slimeknights.tconstruct.library.utils.HarvestLevels.COBALT;

import java.util.Collection;
import java.util.List;

import lance5057.tDefense.core.materials.traits.TraitAxeLover;
import lance5057.tDefense.core.materials.traits.TraitDulling;
import lance5057.tDefense.core.materials.traits.TraitFirestarter;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.TinkerMaterials;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;

public class TDMaterials {

	public static final List<Material> materials = Lists.newArrayList();

	String SHIELD = ShieldMaterialStats.TYPE;

	public static final Material aeonsteel = mat("aeonsteel", 0xd200d1);
	public static final Material queensgold = mat("queensgold", 0xdede00);
	public static final Material dogbearium = mat("dogbearium", 0x604933);

	public static final AbstractTrait axelover = new TraitAxeLover();
	public static final AbstractTrait dulling = new TraitDulling();
	public static final AbstractTrait firestarter = new TraitFirestarter();

	private static Material mat(String name, int color) {
		Material mat = new Material(name, color);
		materials.add(mat);
		return mat;
	}

	@Subscribe
	public void setupMaterials(FMLInitializationEvent event) {
		Material.UNKNOWN.addStats(new ShieldMaterialStats(35, 33));
		
//		TinkerRegistry.addMaterialStats(Material.UNKNOWN,
//				new ShieldMaterialStats(35, 33));
		
		// TinkerRegistry.addMaterialStats(Material.UNKNOWN,
		// new ShieldMaterialStats(35, 33));
		 TinkerRegistry.addMaterialStats(TinkerMaterials.wood,
		 new ShieldMaterialStats(35, 33));
		 TinkerMaterials.wood.addTrait(axelover, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.stone,
				new ShieldMaterialStats(120, 33));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.stone, dulling,
		// SHIELD);
		TinkerMaterials.stone.addTrait(dulling, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.flint,
				new ShieldMaterialStats(150, 33));
		TinkerRegistry.addMaterialTrait(TinkerMaterials.flint, firestarter, SHIELD);
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus,
				new ShieldMaterialStats(210, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone,
				new ShieldMaterialStats(200, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian,
				new ShieldMaterialStats(139, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine,
				new ShieldMaterialStats(430, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone,
				new ShieldMaterialStats(420, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper,
				new ShieldMaterialStats(12, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge,
				new ShieldMaterialStats(550, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood,
				new ShieldMaterialStats(550, 33));

		// Slime
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime,
				new ShieldMaterialStats(1000, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime,
				new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime,
				new ShieldMaterialStats(850, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime,
				new ShieldMaterialStats(600, 33));

		// Nether
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack,
				new ShieldMaterialStats(270, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt,
				new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite,
				new ShieldMaterialStats(990, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn,
				new ShieldMaterialStats(820, 33));

		// Metals
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron,
				new ShieldMaterialStats(204, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron,
				new ShieldMaterialStats(380, 33));

		// Mod Integration
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper,
				new ShieldMaterialStats(210, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze,
				new ShieldMaterialStats(430, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.lead,
				new ShieldMaterialStats(334, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.silver,
				new ShieldMaterialStats(250, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum,
				new ShieldMaterialStats(50, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.steel,
				new ShieldMaterialStats(540, 33));

		TinkerRegistry.addMaterialStats(aeonsteel, new HeadMaterialStats(1000,
				4.0f, 3.00f, COBALT), new HandleMaterialStats(1.10f, 200),
				new ExtraMaterialStats(500));
		// iron.addItemIngot("ingotIron");
		// iron.setRepresentativeItem(Items.field_151042_j);
		// iron.addTrait(magnetic2, HEAD);
		// iron.addTrait(magnetic);

		// TinkerMaterials.stone.addTrait(TinkerMaterials.cheapskate,
		// ShieldMaterialStats.TYPE);
		
		//TAIGA TEST
		Collection<Material> mats = TinkerRegistry.getAllMaterials();
		for (Material i : mats) {
			if(!i.hasStats(SHIELD))
			{
				if(i.hasStats(MaterialTypes.HEAD))
				{
					int dur = ((HeadMaterialStats)i.getStats(MaterialTypes.HEAD)).durability;
					i.addStats(new ShieldMaterialStats(dur, 33));
				}
			}
		}
	}
}
