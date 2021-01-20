package lance5057.tDefense.core.library.book;

import c4.conarm.lib.book.content.ContentArmorMaterial;
import c4.conarm.lib.utils.ConstructUtils;
import lance5057.tDefense.Reference;
import lance5057.tDefense.core.library.book.content.ContentArmor;
import lance5057.tDefense.core.library.book.content.ContentArmorMaterial2;
import lance5057.tDefense.core.library.book.content.ContentImageText3;
import lance5057.tDefense.core.library.book.content.ContentModifier;
import lance5057.tDefense.core.library.book.sectiontransformer.ArmorMaterialSectionTransformer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.BookTransformer;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.book.sectiontransformer.BowMaterialSectionTransformer;
import slimeknights.tconstruct.library.book.sectiontransformer.ModifierSectionTransformer;
import slimeknights.tconstruct.library.book.sectiontransformer.ToolSectionTransformer;

@SideOnly(Side.CLIENT)
public class CompendiumBook extends BookData {

	public final static BookData INSTANCE = BookLoader.registerBook(Reference.MOD_ID, false, false);

	public static void init() {
		BookLoader.registerPageType(ContentArmorMaterial2.ID, ContentArmorMaterial2.class);
		BookLoader.registerPageType(ContentModifier.ID, ContentModifier.class);
		//BookLoader.registerPageType(ContentModifierFortify.ID, ContentModifierFortify.class);
		BookLoader.registerPageType(ContentArmor.ID, ContentArmor.class);
		//BookLoader.registerPageType(ContentSingleStatMultMaterial.ID, ContentSingleStatMultMaterial.class);
		BookLoader.registerPageType(ContentImageText3.ID, ContentImageText3.class);
		INSTANCE.addRepository(new FileRepository(ConstructUtils.getResource("book").toString()));
		INSTANCE.addTransformer(new ToolSectionTransformer());
		INSTANCE.addTransformer(new ArmorMaterialSectionTransformer());
		INSTANCE.addTransformer(new ModifierSectionTransformer());
		//INSTANCE.addTransformer(new BowMaterialSectionTransformer());
		INSTANCE.addTransformer(BookTransformer.IndexTranformer());
	}
}