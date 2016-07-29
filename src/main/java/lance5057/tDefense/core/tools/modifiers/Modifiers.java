package lance5057.tDefense.core.tools.modifiers;

import lance5057.tDefense.TDIntegration;
import lance5057.tDefense.armor.modifiers.ArmorMods;
import lance5057.tDefense.core.tools.modifiers.BloodMagic.BloodMagicMods;
import lance5057.tDefense.core.tools.modifiers.Botania.BotaniaMods;
import lance5057.tDefense.core.tools.modifiers.TDefense.TDMods;
import lance5057.tDefense.core.tools.modifiers.Thaumcraft.ThaumcraftMods;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tconstruct.library.tools.ToolCore;

public class Modifiers
{
	public static TDMods			TMod;
	public static ArmorMods			AMod;
	public static BotaniaMods		BotMod;
	public static ThaumcraftMods	ThaumMod;
	public static BloodMagicMods	BloodMod;

	public void preInit()
	{
		TMod = new TDMods();
		AMod = new ArmorMods();

		if(TDIntegration.botania)
		{
			BotMod = new BotaniaMods();
		}

		if(TDIntegration.thaumcraft)
		{
			ThaumMod = new ThaumcraftMods();
		}
		if(TDIntegration.bloodMagic)
		{
			BloodMod = new BloodMagicMods();
		}
	}

	public void Init()
	{
		TMod.RegisterRecipes();
		TMod.RegisterModifiers();

		AMod.RegisterRecipes();
		AMod.RegisterModifiers();

		if(BotMod != null)
		{
			BotMod.RegisterRecipes();
			BotMod.RegisterModifiers();
		}

		if(ThaumMod != null)
		{
			ThaumMod.RegisterRecipes();
			ThaumMod.RegisterModifiers();
		}
		if(BloodMod != null)
		{
			BloodMod.RegisterRecipes();
			BloodMod.RegisterModifiers();
		}
	}

	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		TMod.UpdateAll(tool, stack, world, entity, tags);
		//AMod.UpdateAll(tool, stack, world, entity, tags);
		if(BotMod != null)
		{
			BotMod.UpdateAll(tool, stack, world, entity, tags);
		}
		if(ThaumMod != null)
		{
			ThaumMod.UpdateAll(tool, stack, world, entity, tags);
		}
		if(BloodMod != null)
		{
			BloodMod.UpdateAll(tool, stack, world, entity, tags);
		}
	}
}
