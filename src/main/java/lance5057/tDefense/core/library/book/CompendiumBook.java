package lance5057.tDefense.core.library.book;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.library.book.content.ContentArmor;
import lance5057.tDefense.core.library.book.content.ContentModifier;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.BookTransformer;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.book.content.ContentImageText2;
import slimeknights.tconstruct.library.book.content.ContentMaterial;
import slimeknights.tconstruct.library.book.content.ContentModifierFortify;
import slimeknights.tconstruct.library.book.content.ContentSingleStatMultMaterial;
import slimeknights.tconstruct.library.book.sectiontransformer.BowMaterialSectionTransformer;
import slimeknights.tconstruct.library.book.sectiontransformer.MaterialSectionTransformer;
import slimeknights.tconstruct.library.book.sectiontransformer.ModifierSectionTransformer;
import slimeknights.tconstruct.library.book.sectiontransformer.ToolSectionTransformer;

@SideOnly(Side.CLIENT)
public class CompendiumBook extends BookData {

	public final static BookData INSTANCE = BookLoader.registerBook(Reference.MOD_ID, false, false);

	public static void init() {
		//BookLoader.registerPageType(ContentMaterial.ID, ContentMaterial.class);
		BookLoader.registerPageType(ContentModifier.ID, ContentModifier.class);
		//BookLoader.registerPageType(ContentModifierFortify.ID, ContentModifierFortify.class);
		BookLoader.registerPageType(ContentArmor.ID, ContentArmor.class);
		//BookLoader.registerPageType(ContentSingleStatMultMaterial.ID, ContentSingleStatMultMaterial.class);
		//BookLoader.registerPageType(ContentImageText2.ID, ContentImageText2.class);
		INSTANCE.addRepository(new FileRepository(Util.resource("book2")));
		INSTANCE.addTransformer(new ToolSectionTransformer());
		INSTANCE.addTransformer(new MaterialSectionTransformer());
		INSTANCE.addTransformer(new ModifierSectionTransformer());
		INSTANCE.addTransformer(new BowMaterialSectionTransformer());
		INSTANCE.addTransformer(BookTransformer.IndexTranformer());
	}
}