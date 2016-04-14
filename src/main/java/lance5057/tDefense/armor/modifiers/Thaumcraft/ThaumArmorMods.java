package lance5057.tDefense.armor.modifiers.Thaumcraft;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.modifiers.modifierBoolExclusive;
import lance5057.tDefense.armor.modifiers.modifierIntExclusive;
import lance5057.tDefense.armor.modifiers.modifierProtection;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModInteger;
import tconstruct.tools.TinkerTools;
import thaumcraft.api.ItemApi;
import cpw.mods.fml.common.registry.GameRegistry;

public class ThaumArmorMods
{
	
	//Runic Shielding is handled in ArmorCore.java
	
	public void LoadItems()
	{
	}

	public void RegisterRecipes()
	{
	}

	public void RegisterModifiers()
	{
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {ItemApi.getItem("itemGoggles", 0)}, TinkersDefense.config.RevealingModID, "Revealing", "\u00A75", "Revealing", new String[] {"head"}, 0));
		
		ModifyBuilder.registerModifier(new modifierIntExclusive(new ItemStack[] {ItemApi.getItem("itemResource", 7)}, TinkersDefense.config.VisDiscountModID, "VisEmbroidery", 1, "\u00A79", "Vis Embroidery", new String[] {"cloth"}, 1));
		
		for(ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.RevealingModID, "tinker", "revealing", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.VisDiscountModID, "tinker", "vis", true);

		}
	}

	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
	}
}
