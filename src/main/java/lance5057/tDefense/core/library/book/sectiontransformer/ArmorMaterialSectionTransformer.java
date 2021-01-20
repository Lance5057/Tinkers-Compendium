package lance5057.tDefense.core.library.book.sectiontransformer;

import lance5057.tDefense.core.library.book.content.ContentArmorMaterial2;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.materials.stats.HelmMaterialStats;
import lance5057.tDefense.core.materials.stats.LegsMaterialStats;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.book.data.content.PageContent;
import slimeknights.tconstruct.library.book.sectiontransformer.AbstractMaterialSectionTransformer;
import slimeknights.tconstruct.library.materials.Material;

/** Populates the materials section for tool materials with content */
@SideOnly(Side.CLIENT)
public class ArmorMaterialSectionTransformer extends AbstractMaterialSectionTransformer {

  public ArmorMaterialSectionTransformer() {
    super("armormaterials2");
  }

  @Override
  protected boolean isValidMaterial(Material material) {
    return material.hasStats(HelmMaterialStats.TYPE) || material.hasStats(ChestMaterialStats.TYPE) || material.hasStats(LegsMaterialStats.TYPE)|| material.hasStats(FeetMaterialStats.TYPE);
  }

  @Override
  protected PageContent getPageContent(Material material) {
    return new ContentArmorMaterial2(material);
  }
}