package lance5057.tDefense.core.tools.modifiers.Botania;

import lance5057.tDefense.TDIntegration;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.tools.modifiers.ModifierBoolExclusive;
import lance5057.tDefense.core.tools.modifiers.ModifiersBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.entity.EntityManaBurst;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.item.equipment.tool.terrasteel.ItemTerraSword;
import vazkii.botania.common.lib.LibBlockNames;
import vazkii.botania.common.lib.LibOreDict;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Optional.InterfaceList({@Optional.Interface(modid = "botania", iface = "vazkii.botania.common.entity.EntityManaBurst"), @Optional.Interface(modid = "botania", iface = "vazkii.botania.common.item.ModItems"), @Optional.Interface(modid = "botania", iface = "vazkii.botania.common.item.equipment.tool.ToolCommons"), @Optional.Interface(modid = "botania", iface = "vazkii.botania.common.item.equipment.tool.terrasteel.ItemTerraSword"),})
public class BotaniaMods extends ModifiersBase
{
	public BotaniaMods()
	{
		super(new String[] {"corpseIvyGraft", "corpseIvy", "terraCore", "manaCore"}, "modItemsBotania");
	}

	@Override
	public void RegisterRecipes()
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(
				new ItemStack(modItems, 1, 0),
				new Object[] {"fsf", "oio", "fgf", 'f', ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_BELLETHORN), 'i', new ItemStack(
						ModItems.keepIvy, 1, 0), 's', LibOreDict.MANA_STRING, 'g', new ItemStack(
						TinkerTools.craftedSoil, 1, 3), 'o', new ItemStack(
						ModItems.fertilizer, 1, 1)}));

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 2), new Object[] {"sis", "idi", "sis", 'i', new ItemStack(
				ModItems.manaResource, 1, 4), 's', new ItemStack(
				ModItems.manaResource, 1, 12), 'd', new ItemStack(
				ModItems.manaResource, 1, 2)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 2), new Object[] {"sis", "idi", "sis", 'i', new ItemStack(
				ModItems.manaResource, 1, 4), 's', new ItemStack(
				ModItems.manaResource, 1, 12), 'd', new ItemStack(
				ModItems.manaResource, 1, 1)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 3), new Object[] {"sis", "idi", "sis", 'i', new ItemStack(
				ModItems.manaResource, 1, 0), 's', new ItemStack(
				ModItems.manaResource, 1, 12), 'd', new ItemStack(
				ModItems.manaTablet)});

		BotaniaAPI.registerManaAlchemyRecipe(new ItemStack(modItems, 1, 1), new ItemStack(
				modItems, 1, 0), 100000);

	}

	@Override
	public void RegisterModifiers()
	{
		ModifyBuilder.registerModifier(new ModifierBoolExclusive(
				new ItemStack[] {new ItemStack(modItems, 1, 1)},
				TinkersDefense.config.CorpseIvyModID, "CorpseIvy",
				EnumChatFormatting.DARK_GREEN.toString(), "Corpse Ivy",
				new String[] {"weapon"}, 1, new String[] {"ManaCore"}));

		ModifyBuilder.registerModifier(new ModifierBoolExclusive(
				new ItemStack[] {new ItemStack(modItems, 1, 2)},
				TinkersDefense.config.TerraCoreModID, "TerraCore",
				EnumChatFormatting.GREEN.toString(), "TerraCore",
				new String[] {"weapon"}, 1, null));

		ModifyBuilder.registerModifier(new ModifierBoolExclusive(
				new ItemStack[] {new ItemStack(modItems, 1, 3)},
				TinkersDefense.config.ManaRepairModID, "ManaCore",
				EnumChatFormatting.AQUA.toString(), "ManaCore",
				new String[] {}, 1, new String[] {"CorpseIvy"}));

		for(final ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CorpseIvyModID, "tinker", "corpseivy", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.TerraCoreModID, "tinker", "terracore", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ManaRepairModID, "tinker", "manacore", true);

		}
	}

	@Override
	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(!world.isRemote)
		{
			if(tags.hasKey("TerraCore"))
			{
				UpdateTerraCore(tool, stack, world, entity, tags);
			}
			//			if(tags.hasKey("CorpseIvy"))
			//			{
			//				UpdateCorpseIvy(tool, stack, world, entity, tags);
			//			}
			if(tags.hasKey("ManaCore"))
			{
				UpdateManaRepair(tool, stack, world, entity, tags);
			}
		}
	}

	public void UpdateTerraCore(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(entity instanceof EntityPlayer)
		{
			final EntityPlayer player = (EntityPlayer) entity;
			final PotionEffect haste = player.getActivePotionEffect(Potion.digSpeed);
			final float check = haste == null ? 0.16666667F : haste.getAmplifier() == 1 ? 0.5F : 0.4F;

			if(player.getCurrentEquippedItem() == stack && player.swingProgress == check && !world.isRemote && world.rand.nextInt(2) == 0)
			{
				final int color = TConstructRegistry.getMaterial(tags.getInteger("Head")).primaryColor();
				final EntityManaBurst burst = ((ItemTerraSword) ModItems.terraSword).getBurst(player, new ItemStack(
						ModItems.terraSword));
				burst.setColor(color);
				world.spawnEntityInWorld(burst);
				//ToolCommonSoundAtEntity(player, "botania:terraBlade", 0.4F, 1.4F);
				AbilityHelper.damageTool(stack, 1, player, false);
			}
		}
	}

	//	public void UpdateCorpseIvy(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	//	{
	//		if(entity instanceof EntityPlayer)
	//		{
	//			final int mana = stack.getTagCompound().getCompoundTag("InfiTool").getInteger("CorpseIvyMana");
	//			final int returned = ManaItemHandler.dispatchMana(stack, (EntityPlayer) entity, mana, true);
	//			stack.getTagCompound().getCompoundTag("InfiTool").setInteger("CorpseIvyMana", mana - returned);
	//		}
	//	}

	@SubscribeEvent
	public void BotaniaAttackEvent(LivingAttackEvent event)
	{
		if(TDIntegration.botania)
		{
			if(event.source.getEntity() instanceof EntityPlayer)
			{
				final EntityPlayer player = (EntityPlayer) event.source.getEntity();
				final ItemStack heldItem = player.getHeldItem();

				if(heldItem != null && heldItem.getItem() != null && heldItem.getItem() instanceof ToolCore)
				{
					final NBTTagCompound tags = heldItem.getTagCompound().getCompoundTag("InfiTool");

					if(tags.hasKey("CorpseIvy"))
					{
						ManaItemHandler.dispatchMana(heldItem, player, 100, true);
					}
				}
			}
		}
	}

	public void UpdateManaRepair(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(entity instanceof EntityPlayer)
		{
			if(tags.getInteger("Damage") > 0)
			{

				if(ManaItemHandler.requestManaExact(stack, (EntityPlayer) entity, 100, true))
				{
					tags.setInteger("Damage", tags.getInteger("Damage") - 1);
				}

			}
		}
	}
}
