//package lance5057.tDefense.armor.modifiers.Botania;
//
//import lance5057.tDefense.TinkersDefense;
//import lance5057.tDefense.core.tools.modifiers.ModifierIntExclusive;
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
//import vazkii.botania.common.item.ModItems;
//import cpw.mods.fml.common.registry.GameRegistry;
//
//public class BotaniaArmorMods extends ModifiersBase
//{
//	public BotaniaArmorMods()
//	{
//		super(new String[] {"elementiumcore"}, "modItemsBotaniaArmor");
//	}
//
//	@Override
//	public void RegisterRecipes()
//	{
//		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 0), new Object[] {"sis", "idi", "sis", 'i', new ItemStack(
//				ModItems.manaResource, 1, 7), 's', new ItemStack(
//				ModItems.manaResource, 1, 12), 'd', new ItemStack(
//				ModItems.manaResource, 1, 2)});
//
//		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 0), new Object[] {"sis", "idi", "sis", 'i', new ItemStack(
//				ModItems.manaResource, 1, 7), 's', new ItemStack(
//				ModItems.manaResource, 1, 12), 'd', new ItemStack(
//				ModItems.manaResource, 1, 1)});
//	}
//
//	@Override
//	public void RegisterModifiers()
//	{
//		ModifyBuilder.registerModifier(new ModifierIntExclusive(
//				new ItemStack[] {new ItemStack(ModItems.manaResource, 1, 22)},
//				TinkersDefense.config.ArmorManaDiscountModID, "ManaEmbroidery",
//				1, EnumChatFormatting.AQUA.toString(), "Mana Embroidery",
//				new String[] {"cloth"}, 1, new String[] {}));
//
//		ModifyBuilder.registerModifier(new ModifierIntExclusive(
//				new ItemStack[] {new ItemStack(modItems, 1, 4)},
//				TinkersDefense.config.ArmorPixieCoreModID, "ElementiumCore", 1,
//				EnumChatFormatting.LIGHT_PURPLE.toString(), "Elementium Core",
//				new String[] {"armor"}, 1, new String[] {}));
//
//		for(final ToolCore tool : TConstructRegistry.getToolMapping())
//		{
//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorManaDiscountModID, "tinker", "manaembroidery", true);
//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorPixieCoreModID, "tinker", "elementiumcore", true);
//
//		}
//	}
//
//	@Override
//	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
//	{
//	}
//}
