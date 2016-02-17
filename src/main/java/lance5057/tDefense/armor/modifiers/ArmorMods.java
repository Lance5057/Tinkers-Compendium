package lance5057.tDefense.armor.modifiers;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import lance5057.tDefense.TinkersDefense;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.armor.TinkerArmor;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;

public class ArmorMods 
{
	Item protKit;

	public ArmorMods()
	{
		LoadItems();
		RegisterRecipes();
		RegisterModifiers();
	}
	
	public void LoadItems()
	{
		protKit = new Item()
			.setUnlocalizedName("protectionkit")
			.setCreativeTab(TinkersDefense.tabName)
			.setTextureName("tinkersdefense:protectionkit");
		
		GameRegistry.registerItem(protKit, "protectionkit");
	}
	
	public void RegisterRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(protKit,1), new ItemStack(TinkersDefense.partArmorplate,1,2), TinkerArmor.heartCanister, Items.iron_ingot);
	}
	
	public void RegisterModifiers()
	{		
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(protKit,1)}, TinkersDefense.config.ArmorProtectionID, 1, "\u00A77"));
		
		for (ToolCore tool : TConstructRegistry.getToolMapping())
        {
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorProtectionID, "tinker", "protection", true);
        }
	}
}
