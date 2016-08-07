package lance5057.tDefense.core.tools.modifiers.Thaumcraft;

import java.lang.reflect.Method;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.tools.modifiers.ModifiersBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;
import thaumcraft.api.ItemApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.FMLLog;

public class ThaumcraftMods extends ModifiersBase
{

	public ThaumcraftMods()
	{
		super(null, null);
	}

	@Override
	public void LoadItems()
	{

	}

	@Override
	public void RegisterRecipes()
	{
	}

	@Override
	public void RegisterModifiers()
	{
		ModifyBuilder.registerModifier(new modifierRepairVis(
				new ItemStack[] {ItemApi.getItem("itemWandCap", 0)},
				TinkersDefense.config.CapsModID, "Caps",
				EnumChatFormatting.GOLD.toString(), "Caps"));

		for(final ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CapsModID, "tinker", "cap", true);
		}
	}

	@Override
	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(!world.isRemote)
		{
			if(tags.hasKey("Caps"))
			{
				UpdateRepairVis(tool, stack, world, entity, tags);
			}
		}
	}

	static Method	consumeVisFromInventory;

	public void UpdateRepairVis(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(tags.getInteger("Damage") > 0)
		{
			final AspectList cost = new AspectList();
			cost.add(Aspect.AIR, (int) (10 * tags.getFloat("Caps")));
			cost.add(Aspect.WATER, (int) (30 * tags.getFloat("Caps")));
			cost.add(Aspect.FIRE, (int) (10 * tags.getFloat("Caps")));
			cost.add(Aspect.ORDER, (int) (20 * tags.getFloat("Caps")));
			cost.add(Aspect.ENTROPY, (int) (10 * tags.getFloat("Caps")));
			cost.add(Aspect.EARTH, (int) (30 * tags.getFloat("Caps")));

			boolean success = false;
			try
			{
				if(consumeVisFromInventory == null)
				{
					consumeVisFromInventory = Class.forName("thaumcraft.common.items.wands.WandManager").getMethod("consumeVisFromInventory", EntityPlayer.class, AspectList.class);
				}
				success = (Boolean) consumeVisFromInventory.invoke(null, entity, cost);
			}
			catch(final Exception ex)
			{
				FMLLog.warning("Thaumcraft is missing, you shouldn't see this, please report");
			}
			finally
			{
				if(success)
				{
					if(tags.getInteger("Damage") >= 4)
					{
						tags.setInteger("Damage", tags.getInteger("Damage") - 4);
					}
					else
					{
						tags.setInteger("Damage", 0);
					}
				}
			}
		}
	}
}
