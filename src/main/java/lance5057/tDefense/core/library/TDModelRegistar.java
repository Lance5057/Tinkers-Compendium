package lance5057.tDefense.core.library;

import javax.annotation.Nonnull;

import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import slimeknights.tconstruct.TConstruct;

public class TDModelRegistar {
	public static ResourceLocation registerToolModel(ArmorCore armor) {
		if (armor == null || armor.getRegistryName() == null) {
			return null;
		}
		ResourceLocation itemLocation = armor.getRegistryName();
		String path = "tools/" + itemLocation.getResourcePath() + TDModelLoader.EXTENSION;

		ResourceLocation location = new ResourceLocation(itemLocation.getResourceDomain(), path);
		TDModelLoader.addPartMapping(location, armor);

		return registerToolModel(armor, location);
	}

	/**
	 * Manual registration of a tool model. You probably shouldn't be using this.
	 */
	public static ResourceLocation registerToolModel(Item item, final ResourceLocation location) {
		if (!location.getResourcePath().endsWith(TDModelLoader.EXTENSION)) {
			TConstruct.log.error("The material-model " + location.toString() + " does not end with '"
					+ TDModelLoader.EXTENSION + "' and will therefore not be loaded by the custom model loader!");
		}

		return registerIt(item, location);
	}

	private static ResourceLocation registerIt(Item item, final ResourceLocation location) {
		// plop it in.
		// This here is needed for the model to be found ingame when the game looks for
		// a model to render an Itemstack
		// we use an ItemMeshDefinition because it allows us to do it no matter what
		// metadata we use
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() { 
			@Nonnull
			@Override
			public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
				return new ModelResourceLocation(location, "inventory");
			}
		});

		// We have to readd the default variant if we have custom variants, since it
		// wont be added otherwise and therefore not loaded
		ModelLoader.registerItemVariants(item, location);

		return location;
	}
}
