package lance5057.tDefense.addons;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.tools.modifiers.Botania.modifierCorpseIvy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.tools.TinkerTools;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lib.LibBlockNames;
import vazkii.botania.common.lib.LibOreDict;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class TDAddonBotania
{
	boolean	active;

	Item	corpseIvyGraft;
	Item	corpseIvy;

	public TDAddonBotania()
	{
		active = false;

		if(Loader.isModLoaded("Botania"))
		{
			active = true;

			LoadItems();
		}
	}

	public void LoadItems()
	{
		corpseIvyGraft = new Item().setUnlocalizedName("corpseivygraft").setCreativeTab(TinkersDefense.tabName).setTextureName("tinkersdefense:corpseIvyGraft");

		corpseIvy = new Item().setUnlocalizedName("corpseivy").setCreativeTab(TinkersDefense.tabName).setTextureName("tinkersdefense:corpseIvy");

		GameRegistry.registerItem(corpseIvyGraft, "corpseivygraft");
		GameRegistry.registerItem(corpseIvy, "corpseivy");
	}

	public void RegisterRecipes()
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(corpseIvyGraft), new Object[] {"fsf", "oio", "fgf", 'f', ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_BELLETHORN), 'i', new ItemStack(ModItems.keepIvy, 1, 0), 's', LibOreDict.MANA_STRING, 'g', new ItemStack(TinkerTools.craftedSoil, 1, 3), 'o', new ItemStack(ModItems.fertilizer, 1, 1)}));

		BotaniaAPI.registerManaAlchemyRecipe(new ItemStack(corpseIvy, 1, 0), new ItemStack(corpseIvyGraft, 1, 0), 100000);
	}

	public void RegisterModifiers()
	{
		ModifyBuilder.registerModifier(new modifierCorpseIvy("Corpse Ivy", TinkersDefense.config.CorpseIvyModID, new ItemStack[] {new ItemStack(corpseIvy)}, new int[] {1}));
	}
}
