package lance5057.tDefense.core.tools.modifiers;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tconstruct.library.tools.ToolCore;
import lance5057.tDefense.TDIntegration;
import lance5057.tDefense.armor.modifiers.ArmorMods;
import lance5057.tDefense.core.tools.modifiers.Botania.BotaniaMods;
import lance5057.tDefense.core.tools.modifiers.Thaumcraft.ThaumcraftMods;

public class Modifiers
{
	public static ToolMods	TMod;
	public static ArmorMods	AMod;
	public static BotaniaMods BotMod;
	public static ThaumcraftMods ThaumMod;

	public void preInit()
	{
		TMod	= new ToolMods();
		AMod	= new ArmorMods();
		
		if(TDIntegration.botania)
		{
			BotMod = new BotaniaMods();
		}
		
		if(TDIntegration.thaumcraft)
		{
			ThaumMod = new ThaumcraftMods();
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
	}
	
	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		TMod.UpdateAll(tool, stack, world, entity, tags);
		AMod.UpdateAll(tool, stack, world, entity, tags);
		if(BotMod != null)
			BotMod.UpdateAll(tool, stack, world, entity, tags);
		if(ThaumMod != null)
			ThaumMod.UpdateAll(tool, stack, world, entity, tags);
		
	}
}
