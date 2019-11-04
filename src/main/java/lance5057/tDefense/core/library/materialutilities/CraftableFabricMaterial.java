package lance5057.tDefense.core.library.materialutilities;

import org.apache.commons.lang3.StringUtils;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.BowStringMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

public class CraftableFabricMaterial implements MaterialBase {
	//public ExtraMaterialStats extra;
	public FabricMaterialStats fabric;
	public BowStringMaterialStats bowstring;

	public ItemStack cord;
	public ItemStack block;

	public CraftableFabricMaterial( FabricMaterialStats fabric,
			BowStringMaterialStats bowstring) {
		//this.extra = extra;
		this.fabric = fabric;
		this.bowstring = bowstring;
	}

	public CraftableFabricMaterial(FabricMaterialStats fabric,
			BowStringMaterialStats bowstring, ItemStack string, ItemStack block) {
		this(fabric, bowstring);
		this.cord = string;
		this.block = block;
	}

	@Override
	public void setupPre(Material mat) {

		mat.setCraftable(true).setCastable(false);

		if (fabric != null)
			TinkerRegistry.addMaterialStats(mat, fabric);
		if (bowstring != null)
			TinkerRegistry.addMaterialStats(mat, bowstring);

		if (cord != null)
			mat.addItem(cord, 1, Material.VALUE_Ingot / 4);
		if (block != null) {
			mat.addItem(block, 1, Material.VALUE_Ingot);
		}
	}

	@Override
	public void setupPost(Material mat) {

	}

	@Override
	public void setupClient(Material mat) {
	}

	@Override
	public void setupIntegration(MaterialIntegration mi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupModels(Material mat) {
	}

	@Override
	public void setupInit(Material mat) {
		mat.setRepresentativeItem(block);
	}

}
