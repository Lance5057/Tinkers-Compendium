package lance5057.tDefense.core.library.materialutilities;

import java.io.PrintWriter;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.materials.Material;

public abstract interface MaterialBase {

	public abstract void setupPre(MaterialHelper mat);

	public abstract void setupInit(MaterialHelper mat);

	public abstract void setupIntegration(MaterialIntegration mi);

	public abstract void setupPost(MaterialHelper mat);

	public abstract void setupClient(MaterialHelper mat);

	public abstract void setupModels(MaterialHelper mat);

	public abstract void setupWiki(MaterialHelper mat, PrintWriter out);
}
