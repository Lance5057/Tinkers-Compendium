//package lance5057.tDefense.armor.modifiers.BloodMagic;
//
//import lance5057.tDefense.TinkersDefense;
//import lance5057.tDefense.core.tools.modifiers.ModifierBoolExclusive;
//import lance5057.tDefense.core.tools.modifiers.ModifiersBase;
//import net.minecraft.entity.Entity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.util.EnumChatFormatting;
//import net.minecraft.world.World;
//import tconstruct.library.TConstructRegistry;
//import tconstruct.library.client.TConstructClientRegistry;
//import tconstruct.library.crafting.ModifyBuilder;
//import tconstruct.library.tools.ToolCore;
//import WayofTime.alchemicalWizardry.ModItems;
//
//public class BloodArmorMods extends ModifiersBase
//{
//	public BloodArmorMods()
//	{
//		super(new String[] {}, "modItemsBloodArmor");
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public void LoadItems()
//	{
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
//				new ItemStack[] {new ItemStack(ModItems.divinationSigil, 1, 0)},
//				TinkersDefense.config.DivinationModID, "Divination",
//				EnumChatFormatting.DARK_RED.toString(), "Divination",
//				new String[] {"head"}, 0, new String[] {}));
//
//		for(final ToolCore tool : TConstructRegistry.getToolMapping())
//		{
//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.DivinationModID, "tinker", "divination", true);
//			//TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.VisDiscountModID, "tinker", "visembroidery", true);
//
//		}
//	}
//
//	@Override
//	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
//	{
//	}
//}
