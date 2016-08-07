package lance5057.tDefense.core.tools.modifiers.TDefense;

import java.util.ArrayList;
import java.util.Random;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.tools.ModifierSoul;
import lance5057.tDefense.core.tools.Shield;
import lance5057.tDefense.core.tools.modifiers.ModifierBoolExclusive;
import lance5057.tDefense.core.tools.modifiers.ModifierIntExclusive;
import lance5057.tDefense.core.tools.modifiers.ModifiersBase;
import lance5057.tDefense.core.tools.modifiers.modLapisShears;
import lance5057.tDefense.core.tools.modifiers.ActiveToolMods.TDefenseActiveToolMod;
import lance5057.tDefense.proxy.CommonProxy;
import mods.battlegear2.api.PlayerEventChild.ShieldBlockEvent;
import mods.battlegear2.api.core.IBattlePlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.oredict.OreDictionary;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import tconstruct.weaponry.TinkerWeaponry;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class TDMods extends ModifiersBase
{
	public TDMods()
	{
		super(new String[] {"AncientRelic", "RainbowGem", "Textbook", "SoulStone", "CrestFeathers", "CrestMirrors", "CrestLegends", "CrestGluttony", "CrestThorns", "CrestSanguisuga", "CrestWinds", "CrestLight", "CrestPaper"}, "modItemsCore");
	}

	@Override
	public void RegisterRecipes()
	{
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(modItems, 1, 0), 1, 1, 1));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(modItems, 1, 3), 1, 1, 1));

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 1), new Object[] {"111", "1d1", "111", 'd', new ItemStack(
				Items.diamond, 1, 0), '1', new ItemStack(Items.dye, 1,
				OreDictionary.WILDCARD_VALUE)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 2), new Object[] {"-1-", "1d1", "-1-", 'd', new ItemStack(
				Items.enchanted_book, 1, OreDictionary.WILDCARD_VALUE), '1', new ItemStack(
				Items.experience_bottle, 1, 0)});

		GameRegistry.addShapelessRecipe(new ItemStack(modItems, 1, 12), new ItemStack(
				Items.enchanted_book, 1, OreDictionary.WILDCARD_VALUE));

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 4), new Object[] {"fcf", "sps", "fcf", 'f', new ItemStack(
				Items.feather, 1, -1), 'c', new ItemStack(
				TinkersDefense.partCloth, 1, OreDictionary.WILDCARD_VALUE), 's', new ItemStack(
				Items.string, 1, -1), 'p', new ItemStack(modItems, 1, 12)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 5), new Object[] {"gng", "spc", "gbg", 'g', new ItemStack(
				Blocks.glass_pane, 1, -1), 'c', new ItemStack(
				TinkersDefense.partCloth, 1, OreDictionary.WILDCARD_VALUE), 's', new ItemStack(
				Blocks.sand, 1, OreDictionary.WILDCARD_VALUE), 'p', new ItemStack(
				modItems, 1, 12), 'n', new ItemStack(Items.nether_star, 1, 0), 'b', new ItemStack(
				Blocks.gold_block, 1, 12)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 6), new Object[] {"-r-", "-p-", "---", 'r', new ItemStack(
				modItems, 1, 0), 'p', new ItemStack(modItems, 1, 12)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 7), new Object[] {"aaa", "ipi", "aaa", 'i', TConstructRegistry.getItemStack("ingotPigIron"), 'p', new ItemStack(
				modItems, 1, 12), 'a', new ItemStack(TinkerWeaponry.arrowhead,
				1, 5)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 8), new Object[] {"aia", "ipi", "aia", 'i', new ItemStack(
				Items.iron_ingot, 1, 0), 'p', new ItemStack(modItems, 1, 12), 'a', new ItemStack(
				TinkersDefense.partRivet, 1, 4)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 9), new Object[] {"brb", "apa", "ara", 'b', TConstructRegistry.getItemStack("necroticBone"), 'r', new ItemStack(
				TinkerTools.toughRod, 1, 7), 'a', new ItemStack(
				TinkerWeaponry.arrowhead, 1, 11), 'p', new ItemStack(modItems,
				1, 12)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 10), new Object[] {"PfP", "tpt", "PfP", 'P', new ItemStack(
				Blocks.piston, 1, 0), 'p', new ItemStack(modItems, 1, 12), 'f', new ItemStack(
				Items.feather, 1, 0), 't', new ItemStack(Items.ghast_tear, 1, 0)});

		GameRegistry.addShapedRecipe(new ItemStack(modItems, 1, 11), new Object[] {"gbg", "tpt", "gbg", 'g', new ItemStack(
				Blocks.glowstone, 1, 0), 'p', new ItemStack(modItems, 1, 12), 'b', new ItemStack(
				Items.blaze_rod, 1, 0), 't', new ItemStack(Blocks.torch, 1, 0)});
	}

	@Override
	public void RegisterModifiers()
	{
		//All 
		ModifyBuilder.registerModifier(new ModifierSoul(
				new ItemStack[] {new ItemStack(modItems, 1, 3)},
				TinkersDefense.config.SoulSteveID, "Ensouled",
				EnumChatFormatting.WHITE.toString(), "Ensouled (Steve)",
				new String[] {}, 0, null, "Steve"));

		//Weapons
		//TO-DO
		ModifyBuilder.registerModifier(new ModifierIntExclusive(
				new ItemStack[] {new ItemStack(
						Blocks.heavy_weighted_pressure_plate, 1, 0)},
				TinkersDefense.config.DazeID, "Daze", 1,
				EnumChatFormatting.GRAY.toString(), "Daze",
				new String[] {"weapon"}, 1, null));
		ModifyBuilder.registerModifier(new ModifierIntExclusive(
				new ItemStack[] {new ItemStack(modItems, 1, 2)},
				TinkersDefense.config.XPBoostID, "XPBoost", 1,
				EnumChatFormatting.GREEN.toString(), "XP Boost",
				new String[] {"weapon"}, 1, null));

		//Shears
		ModifyBuilder.registerModifier(new ModifierBoolExclusive(
				new ItemStack[] {new ItemStack(modItems, 1, 1)},
				TinkersDefense.config.RainbowID, "Rainbow",
				EnumChatFormatting.WHITE.toString(), "Rainbow",
				new String[] {"shears"}, 1, null));

		ModifyBuilder.registerModifier(new modLapisShears(
				TinkersDefense.config.ShearFortuneID,
				new ItemStack[] {new ItemStack(Items.dye, 1, 4), new ItemStack(
						Blocks.lapis_block, 1, 0)}, new int[] {1, 9}));

		//Shields
		RegisterCrestModifier(TinkersDefense.config.CrestFeathersID, "Feathers", 1, EnumChatFormatting.WHITE.toString(), new ItemStack(
				modItems, 1, 4), 1);
		RegisterCrestModifier(TinkersDefense.config.CrestMirrorsID, "Mirrors", EnumChatFormatting.DARK_AQUA.toString(), new ItemStack(
				modItems, 1, 5), 1);
		RegisterLegendModifier(TinkersDefense.config.CrestLegendsID, "Legends", EnumChatFormatting.GOLD.toString(), new ItemStack(
				modItems, 1, 6), 1);
		//		RegisterCrestModifier(TinkersDefense.config.CrestBladesID, "Blades", 1, EnumChatFormatting.GRAY.toString(), new ItemStack(
		//				modItems, 1, 7), 1);
		RegisterCrestModifier(TinkersDefense.config.CrestGluttonyID, "Gluttony", 1, EnumChatFormatting.DARK_GREEN.toString(), new ItemStack(
				modItems, 1, 7), 1);
		//		RegisterCrestModifier(TinkersDefense.config.CrestPitchID, "Pitch", 1, EnumChatFormatting.DARK_GRAY.toString(), new ItemStack(
		//				modItems, 1, 8), 1);
		RegisterCrestModifier(TinkersDefense.config.CrestThornsID, "Thorns", 1, EnumChatFormatting.GREEN.toString(), new ItemStack(
				modItems, 1, 8), 1);
		RegisterCrestModifier(TinkersDefense.config.CrestSanguisugaID, "Sanguisuga", 1, EnumChatFormatting.DARK_RED.toString(), new ItemStack(
				modItems, 1, 9), 1);
		RegisterCrestModifier(TinkersDefense.config.CrestWindsID, "Wind", 1, EnumChatFormatting.AQUA.toString(), new ItemStack(
				modItems, 1, 10), 1);
		//		RegisterCrestModifier(TinkersDefense.config.CrestRetributionID, "Retribution", 1, EnumChatFormatting.LIGHT_PURPLE.toString(), new ItemStack(
		//				modItems, 1, 13), 1);
		RegisterCrestModifier(TinkersDefense.config.CrestLightID, "Light", 1, EnumChatFormatting.YELLOW.toString(), new ItemStack(
				modItems, 1, 11), 1);

		//Jokes
		//		ModifyBuilder.registerModifier(new ModifierBoolExclusive(new ItemStack[] {new ItemStack(Blocks.glass_pane)}, TinkersDefense.config.JokeInsultID, "Insulting", EnumChatFormatting.AQUA.toString(), "Joke: Insulting", null, 0, null));
		//		ModifyBuilder.registerModifier(new ModifierBoolExclusive(new ItemStack[] {new ItemStack(Blocks.glass_pane)}, TinkersDefense.config.JokePyrotechID, "Pyrotech", EnumChatFormatting.AQUA.toString(), "Joke: Pyrotech", null, 0, null));
		//ModifyBuilder.registerModifier(new modifierIntExclusive(new ItemStack[] {new ItemStack(Items.slime_ball)}, TinkersDefense.config.JokeCompensateID, "Compensate", 1, EnumChatFormatting.DARK_GRAY.toString(), "Joke: Compensating", new String[] {"shield"}, 1, null));

		TConstructRegistry.registerActiveToolMod(new TDefenseActiveToolMod());

		for(final ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.DazeID, "tinker", "daze", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ShearFortuneID, "tinker", "lapis", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.RainbowID, "rainbow", "daze", true);

			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestFeathersID, "tinker", "feathers", true);
			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestMirrorsID, "tinker", "mirrors", true);
			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestLegendsID, "tinker", "legends", true);
			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestBladesID, "tinker", "blades", true);
			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestGluttonyID, "tinker", "gluttony", true);
			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestPitchID, "tinker", "pitch", true);
			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestSanguisugaID, "tinker", "sanguisuga", true);
			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestWindsID, "tinker", "wind", true);
			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestRetributionID, "tinker", "retribution", true);
			//			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestLightID, "tinker", "light", true);

			//TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.JokeInsultID, "tinker", "insult", true);
			//TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.JokePyrotechID, "tinker", "pyrotech", true);
			//TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.JokeCompensateID, "tinker", "compensate", true);

			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.SoulBoundID, "tinker", "soulbound", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.RainbowID, "tinker", "rainbow", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.XPBoostID, "tinker", "textbook", true);

		}
	}

	public void RegisterCrestModifier(int[] effect, String tag, int increase, String color, ItemStack item, int mods)
	{
		for(int i = 0; i < TinkersDefense.colors.length; i++)
		{
			final ItemStack[] items = {item, new ItemStack(Items.dye, 1, i)};
			ModifyBuilder.registerModifier(new ModifierIntExclusive(items,
					effect[i], tag.toLowerCase(), increase, color,
					"Crest of " + tag, new String[] {"shield"}, mods, null));
			for(final ToolCore tool : TConstructRegistry.getToolMapping())
			{
				TConstructClientRegistry.addEffectRenderMapping(tool, effect[i], "tinker", TinkersDefense.colors[i] + "_" + tag.toLowerCase(), true);
			}
		}
	}

	public void RegisterCrestModifier(int[] effect, String tag, String color, ItemStack item, int mods)
	{

		for(int i = 0; i < TinkersDefense.colors.length; i++)
		{
			final ItemStack[] items = {item, new ItemStack(Items.dye, 1, i)};
			ModifyBuilder.registerModifier(new ModifierBoolExclusive(items,
					effect[i], tag.toLowerCase(), color, "Crest of " + tag,
					new String[] {"shield"}, mods, null));
			for(final ToolCore tool : TConstructRegistry.getToolMapping())
			{
				TConstructClientRegistry.addEffectRenderMapping(tool, effect[i], "tinker", TinkersDefense.colors[i] + "_" + tag.toLowerCase(), true);
			}
		}
	}

	public void RegisterLegendModifier(int[] effect, String tag, String color, ItemStack item, int mods)
	{

		for(int i = 0; i < TinkersDefense.colors.length; i++)
		{
			final ItemStack[] items = {item, new ItemStack(Items.dye, 1, i)};
			ModifyBuilder.registerModifier(new ModifierBoolExclusive(items,
					effect[i], tag.toLowerCase(), color, "Crest of " + tag,
					new String[] {"heatershield"}, mods, null));
			for(final ToolCore tool : TConstructRegistry.getToolMapping())
			{
				TConstructClientRegistry.addEffectRenderMapping(tool, effect[i], "tinker", TinkersDefense.colors[i] + "_" + tag.toLowerCase(), true);
			}
		}
	}

	@Override
	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(tags.hasKey("mirrors"))
		{
			UpdateMirrors(tool, stack, world, entity);
		}
		if(tags.hasKey("gluttony"))
		{
			UpdateGluttony(tool, stack, world, entity, tags);
		}
		if(world.isRemote && tags.hasKey("Ensouled") && tags.hasKey("Soul"))
		{
			if(CommonProxy.SoulHandler != null)
			{
				CommonProxy.SoulHandler.Update(stack);
			}
		}
	}

	public void UpdateMirrors(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		if(((IBattlePlayer) entity).isBlockingWithShield())
		{
			final AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(((EntityLivingBase) entity).posX - 3, ((EntityLivingBase) entity).posY - 3, ((EntityLivingBase) entity).posZ - 3, ((EntityLivingBase) entity).posX + 3, ((EntityLivingBase) entity).posY + 3, ((EntityLivingBase) entity).posZ + 3);

			final ArrayList<EntityFireball> fireballs = (ArrayList<EntityFireball>) world.getEntitiesWithinAABB(EntityFireball.class, boundingBox);
			for(final EntityFireball fireball : fireballs)
			{
				if(fireball.getDistanceSqToEntity((entity)) <= 25)
				{
					final Vec3 playerlook = ((EntityLivingBase) entity).getLookVec();

					fireball.motionX = playerlook.xCoord;
					fireball.motionY = playerlook.yCoord;
					fireball.motionZ = playerlook.zCoord;
					fireball.accelerationX = fireball.motionX * 0.1D;
					fireball.accelerationY = fireball.motionY * 0.1D;
					fireball.accelerationZ = fireball.motionZ * 0.1D;

					fireball.shootingEntity = ((EntityLivingBase) entity);

					((EntityLivingBase) entity).worldObj.playSoundAtEntity((entity), "battlegear2:shield", 1, 1);
				}
			}
		}
	}

	public void UpdateGluttony(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		final Shield shield = (Shield) tool;

		if(tags.getInteger("Damage") > 0 && shield.getArrowCount(stack) > 0)
		{
			tags.setInteger("Damage", tags.getInteger("Damage") - 2);
			shield.setArrowCount(stack, shield.getArrowCount(stack) - 1);

			if(world.isRemote)
			{
				world.playSoundEffect(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ, "minecraft:random.eat", 1, 1);
			}
		}
	}

	//Events
	@SubscribeEvent
	public void XPBoost(LivingDeathEvent event)
	{
		if(!(event.entityLiving instanceof EntityPlayer) && event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			final EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			final ItemStack itemstack = player.getCurrentEquippedItem();
			if(itemstack != null && itemstack.getItem() instanceof ToolCore)
			{
				final NBTTagCompound tags = itemstack.getTagCompound().getCompoundTag("InfiTool");

				if(tags != null && tags.hasKey("XPBoost"))
				{
					player.worldObj.spawnEntityInWorld(new EntityXPOrb(
							player.worldObj, event.entityLiving.posX,
							event.entityLiving.posY, event.entityLiving.posZ,
							(int) Math.pow(tags.getInteger("XPBoost"), 2)));

				}
			}
		}
	}

	@SubscribeEvent
	public void UpdateDaze(LivingAttackEvent event)
	{
		if(event.source.getEntity() instanceof EntityPlayer)
		{
			final EntityPlayer player = (EntityPlayer) event.source.getEntity();
			final ItemStack heldItem = player.getHeldItem();
			final EntityLivingBase attacked = event.entityLiving;

			if(heldItem != null && heldItem.getItem() != null && heldItem.getItem() instanceof ToolCore)
			{
				final NBTTagCompound tags = heldItem.getTagCompound().getCompoundTag("InfiTool");

				if(tags.hasKey("Daze"))
				{
					final int daze = tags.getInteger("Daze");
					final int chance = daze * 5;

					final Random roll = new Random();
					final int num = roll.nextInt(100) + 1;

					if(num <= chance)
					{
						attacked.addPotionEffect(new PotionEffect(2, 3 * 20,
								100));
						attacked.addPotionEffect(new PotionEffect(9, 3 * 20,
								100));
						attacked.addPotionEffect(new PotionEffect(15, 3 * 20,
								100));
						attacked.addPotionEffect(new PotionEffect(18, 3 * 20,
								100));
					}

				}
			}
		}
	}

	@SubscribeEvent
	@Optional.Method(modid = "battlegear2")
	public void TD_ShieldBlock(ShieldBlockEvent event)
	{
		if(event.shield.getItem() instanceof ToolCore)
		{
			final NBTTagCompound tags = event.shield.getTagCompound().getCompoundTag("InfiTool");

			if(!tags.getBoolean("Broken"))
			{
				if(tags.hasKey("mirrors"))
				{
					UpdateMirrors((ToolCore) event.shield.getItem(), event.shield, event.entityPlayer.worldObj, event.entityPlayer);
				}

				if(tags.hasKey("legends"))
				{
					event.getPlayer().addPotionEffect(new PotionEffect(
							Potion.fireResistance.getId(), 200, 2));
					event.getPlayer().addPotionEffect(new PotionEffect(
							Potion.moveSpeed.getId(), 200, 2));
					event.getPlayer().addPotionEffect(new PotionEffect(
							Potion.resistance.getId(), 200, 2));
				}

				if(tags.hasKey("thorns"))
				{
					event.source.getEntity().attackEntityFrom(DamageSource.generic, tags.getInteger("thorns") * 2);
				}

				if(tags.hasKey("sanguisuga"))
				{
					event.source.getEntity().attackEntityFrom(DamageSource.generic, tags.getInteger("sanguisuga"));
					event.entityPlayer.heal(tags.getInteger("sanguisuga"));
				}

				if(tags.hasKey("light"))
				{
					if(event.source.getEntity() instanceof EntityMob)
					{
						final EntityMob entity = (EntityMob) event.source.getEntity();
						if(entity.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD)
						{
							event.source.getEntity().setFire(tags.getInteger("light"));
						}
					}
				}

				//				if(tags.hasKey("pitch"))
				//				{
				//					if(!event.entityPlayer.worldObj.isRemote && event.source.getEntity() instanceof EntityPlayer)
				//					{
				//						final EntityPlayer entity = (EntityPlayer) event.source.getEntity();
				//						if(entity.getEquipmentInSlot(0) != null)
				//						{
				//							entity.entityDropItem(entity.getEquipmentInSlot(0), 5);
				//							entity.setCurrentItemOrArmor(0, null);
				//							//entity.setCanPickUpLoot(true);
				//						}
				//					}
				//				}

				if(tags.hasKey("wind"))
				{
					if(!event.entityPlayer.worldObj.isRemote && event.source.getEntity() instanceof EntityLiving)
					{
						final EntityLiving entity = (EntityLiving) event.source.getEntity();

						final double x = event.entityLiving.posX - entity.posX;
						final double z = event.entityLiving.posZ - entity.posZ;
						//entity.knockBack(entity, tags.getInteger("winds") * 10, x, z);

						entity.isAirBorne = true;
						final float f1 = MathHelper.sqrt_double(x * x + z * z);
						final float f2 = 0.4F;
						entity.motionX /= 2.0D;
						entity.motionY /= 2.0D;
						entity.motionZ /= 2.0D;
						entity.motionX -= x / f1 * f2 * tags.getInteger("wind");
						entity.motionY += f2;
						entity.motionZ -= z / f1 * f2 * tags.getInteger("wind");

					}
				}
			}
		}
	}
}
