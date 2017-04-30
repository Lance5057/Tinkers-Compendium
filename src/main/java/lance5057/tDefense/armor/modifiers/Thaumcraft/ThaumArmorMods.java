//package lance5057.tDefense.armor.modifiers.Thaumcraft;
//
//import lance5057.tDefense.TinkersDefense;
//import lance5057.tDefense.core.tools.modifiers.ModifierBoolExclusive;
//import lance5057.tDefense.core.tools.modifiers.ModifierIntExclusive;
//import lance5057.tDefense.core.tools.modifiers.ModifiersBase;
//import net.minecraft.entity.Entity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.world.World;
//import tconstruct.library.TConstructRegistry;
//import tconstruct.library.client.TConstructClientRegistry;
//import tconstruct.library.crafting.ModifyBuilder;
//import tconstruct.library.tools.ToolCore;
//import thaumcraft.api.ItemApi;
//
//public class ThaumArmorMods extends ModifiersBase
//{
//
//	//Runic Shielding is handled in ArmorCore.java
//
//	public ThaumArmorMods()
//	{
//		super(new String[] {}, "modItemsThaumArmor");
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public void RegisterRecipes()
//	{
//	}
//
//	@Override
//	public void RegisterModifiers()
//	{
//		ModifyBuilder.registerModifier(new ModifierBoolExclusive(
//				new ItemStack[] {ItemApi.getItem("itemGoggles", 0)},
//				TinkersDefense.config.RevealingModID, "Revealing", "\u00A75",
//				"Revealing", new String[] {"head"}, 0, null));
//
//		ModifyBuilder.registerModifier(new ModifierIntExclusive(
//				new ItemStack[] {ItemApi.getItem("itemResource", 7)},
//				TinkersDefense.config.VisDiscountModID, "VisEmbroidery", 1,
//				"\u00A79", "Vis Embroidery", new String[] {"cloth"}, 1,
//				new String[] {}));
//
//		for(final ToolCore tool : TConstructRegistry.getToolMapping())
//		{
//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.RevealingModID, "tinker", "revealing", true);
//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.VisDiscountModID, "tinker", "visembroidery", true);
//
//		}
//	}
//
//	@Override
//	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
//	{
//	}
//}
