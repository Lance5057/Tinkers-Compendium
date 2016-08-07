package lance5057.tDefense.core.tools.modifiers.BloodMagic;

import lance5057.tDefense.TDIntegration;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.tools.modifiers.ModifierBoolExclusive;
import lance5057.tDefense.core.tools.modifiers.ModifiersBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;
import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.items.ShapedBloodOrbRecipe;
import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;
import WayofTime.alchemicalWizardry.common.items.EnergyItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class BloodMagicMods extends ModifiersBase
{

	public BloodMagicMods()
	{
		super(new String[] {"bindingwrap", "bloodybandages"}, "modItemsBloodMagic");
	}

	@Override
	public void RegisterRecipes()
	{
		GameRegistry.addRecipe(new ShapedBloodOrbRecipe(new ItemStack(modItems,
				1, 0), new Object[] {"sts", "cbc", "sos", 's', new ItemStack(
						ModItems.weakBloodShard, 1, 0), 't', new ItemStack(
								TinkersDefense.partChainmaille, 1, 2), 'c', new ItemStack(
										ModItems.standardBindingAgent, 1, 0), 'b', new ItemStack(
												ModItems.energySword, 1, 0), 'o', new ItemStack(
														ModItems.magicianBloodOrb, 1, 0)}));

		AltarRecipeRegistry.registerAltarRecipe(new ItemStack(modItems, 1, 1), new ItemStack(
				TinkersDefense.partCloth, 1, -1), 2, 12000, 10, 10, false);

	}

	@Override
	public void RegisterModifiers()
	{
		// TODO Auto-generated method stub
		ModifyBuilder.registerModifier(new ModifierBoolExclusive(
				new ItemStack[] {new ItemStack(modItems, 1, 0)},
				TinkersDefense.config.BloodOathModID, "BloodOath",
				EnumChatFormatting.RED.toString(), "Blood Oath",
				new String[] {"weapon"}, 1, null));

		ModifyBuilder.registerModifier(new ModifierBoolExclusive(
				new ItemStack[] {new ItemStack(modItems, 1, 1)},
				TinkersDefense.config.ScabbingModID, "Scabbing",
				EnumChatFormatting.DARK_RED.toString(), "Scabbing",
				new String[] {}, 1, new String[] {"Supping"}));

		ModifyBuilder.registerModifier(new ModifierBoolExclusive(
				new ItemStack[] {new ItemStack(ModItems.apprenticeBloodOrb, 1), new ItemStack(
						ModItems.sacrificialDagger, 1)},
						TinkersDefense.config.SuppingModID, "Supping",
						EnumChatFormatting.DARK_RED.toString(), "Supping",
						new String[] {"weapon"}, 1, new String[] {"Scabbing"}));

		for(final ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.BloodOathModID, "tinker", "bloodoath", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ScabbingModID, "tinker", "scabbing", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.SuppingModID, "tinker", "supping", true);
		}
	}

	@Override
	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(!world.isRemote)
		{
			if(tags.hasKey("Scabbing"))
			{
				SoulNetworkHandler.checkAndSetItemOwner(stack, (EntityPlayer) entity);
				UpdateScabbing(tool, stack, world, entity, tags);
			}
		}
	}

	public void UpdateScabbing(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(tags.getInteger("Damage") > 0 && EnergyItems.syphonBatteries(stack, (EntityPlayer) entity, 50))
		{
			tags.setInteger("Damage", tags.getInteger("Damage") - 1);
		}
	}

	@SubscribeEvent
	public void BloodOathInteractEvent(LivingAttackEvent event)
	{
		if(TDIntegration.bloodMagic && !event.entity.worldObj.isRemote)
		{
			if(event.source.getEntity() instanceof EntityPlayer)
			{
				final EntityPlayer player = (EntityPlayer) event.source.getEntity();
				final ItemStack heldItem = player.getHeldItem();

				if(heldItem != null && heldItem.getItem() != null && heldItem.getItem() instanceof ToolCore)
				{
					SoulNetworkHandler.checkAndSetItemOwner(heldItem, player);
					final NBTTagCompound tags = heldItem.getTagCompound().getCompoundTag("InfiTool");

					if(tags.hasKey("BloodOath") && EnergyItems.syphonBatteries(heldItem, player, 50))
					{
						event.entityLiving.addPotionEffect(new PotionEffect(
								Potion.weakness.id, 30, 2));
					}

					if(tags.hasKey("Supping"))
					{
						SoulNetworkHandler.addCurrentEssenceToMaximum(SoulNetworkHandler.getOwnerName(heldItem), 10, SoulNetworkHandler.getMaximumForOrbTier(SoulNetworkHandler.getCurrentMaxOrb(SoulNetworkHandler.getOwnerName(heldItem))));
					}
				}
			}
		}
	}
}
