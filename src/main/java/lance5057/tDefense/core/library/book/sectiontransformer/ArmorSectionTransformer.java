package lance5057.tDefense.core.library.book.sectiontransformer;

import java.util.Optional;

import lance5057.tDefense.core.library.TCRegistry;
import lance5057.tDefense.core.library.book.content.ContentArmor;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.PageData;
import slimeknights.tconstruct.library.book.content.ContentListing;
import slimeknights.tconstruct.library.book.content.ContentTool;
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer;

@SideOnly(Side.CLIENT)
public class ArmorSectionTransformer extends ContentListingSectionTransformer {

  public ArmorSectionTransformer() {
    super("armor");
  }

  @Override
  protected void processPage(BookData book, ContentListing listing, PageData page) {
    // only add tool pages if the tool exists
    if(page.content instanceof ContentArmor) {
      String toolName = ((ContentTool) page.content).toolName;
      Optional<ArmorCore> tool = TCRegistry.getArmor().stream()
                                              .filter(toolCore -> toolName.equals(toolCore.getIdentifier()))
                                              .findFirst();

      tool.ifPresent(toolCore -> listing.addEntry(toolCore.getLocalizedName(), page));
    }
    else {
      super.processPage(book, listing, page);
    }
  }
}