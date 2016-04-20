package lance5057.tDefense.armor.modifiers;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TDIntegration;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.items.cloth.TinkersRobe;
import lance5057.tDefense.armor.items.heavy.TinkersGrieves;
import lance5057.tDefense.armor.items.light.TinkersChausses;
import lance5057.tDefense.armor.modifiers.Thaumcraft.ThaumArmorMods;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ArmorMods
{
	ThaumArmorMods	tcmods;

	Item			item_Canister;
	Item			item_Emptycanister;
	Item			item_Rebreather;
	Item			item_NightvisionGoggles;

	Item			item_Glowsole;
	Item			item_Firesole;
	Item			item_Icesole;
	Item			item_Feathersole;
	Item			item_Flippers;

	public ArmorMods()
	{
		FMLCommonHandler.instance().bus().register(this);
		MinecraftForge.EVENT_BUS.register(this);
		 
		LoadItems();
	}

	public void LoadItems()
	{
		//Head
		item_Canister = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(10).setUnlocalizedName("FilledCart").setTextureName(Reference.MOD_ID + ":FilledCart");
		item_Emptycanister = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(10).setUnlocalizedName("EmptyCart").setTextureName(Reference.MOD_ID + ":EmptyCart");
		item_Rebreather = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("Rebreather").setTextureName(Reference.MOD_ID + ":Rebreather");
		item_NightvisionGoggles = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("NightvisionGoggles").setTextureName(Reference.MOD_ID + ":NightvisionGoggles");

		//Feet
		item_Feathersole = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("FeatherSole").setTextureName(Reference.MOD_ID + ":FeatherSole");
		item_Firesole = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("FireSole").setTextureName(Reference.MOD_ID + ":FireSole");
		item_Icesole = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("IceSole").setTextureName(Reference.MOD_ID + ":IceSole");
		item_Glowsole = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("GlowSole").setTextureName(Reference.MOD_ID + ":GlowSole");
		item_Flippers = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("Flippers").setTextureName(Reference.MOD_ID + ":Flippers");

		GameRegistry.registerItem(item_Canister, "FilledCart");
		GameRegistry.registerItem(item_Emptycanister, "EmptyCart");
		GameRegistry.registerItem(item_Rebreather, "Rebreather");
		GameRegistry.registerItem(item_NightvisionGoggles, "NightvisionGoggles");

		GameRegistry.registerItem(item_Feathersole, "FeatherSole");
		GameRegistry.registerItem(item_Firesole, "FireSole");
		GameRegistry.registerItem(item_Icesole, "IceSole");
		GameRegistry.registerItem(item_Glowsole, "GlowSole");
		GameRegistry.registerItem(item_Flippers, "Flippers");

		if(TDIntegration.thaumcraft)
		{
			tcmods = new ThaumArmorMods();
			tcmods.LoadItems();
		}

	}

	public void RegisterRecipes()
	{
		GameRegistry.addShapedRecipe(new ItemStack(item_Canister), new Object[] {"-c-", "ses", "-s-", 'c', new ItemStack(Items.coal, 1, 1), 's', new ItemStack(Blocks.sapling, 1), 'e', new ItemStack(item_Emptycanister, 1, 0)});
		GameRegistry.addShapedRecipe(new ItemStack(item_Emptycanister), new Object[] {"gsg", "lil", "gig", 'g', new ItemStack(Items.gold_nugget, 1, 0), 's', new ItemStack(Items.slime_ball, 1, 0), 'l', new ItemStack(Items.dye, 1, 4), 'i', new ItemStack(Items.iron_ingot, 1, 0)});
		GameRegistry.addShapedRecipe(new ItemStack(item_Rebreather), new Object[] {"-s-", "eie", "-d-", 's', new ItemStack(Items.slime_ball, 1, 0), 'e', new ItemStack(item_Emptycanister, 1, 0), 'i', new ItemStack(TinkersDefense.partArmorplate, 1, 2), 'd', new ItemStack(Items.dye, 1, 4)});
		GameRegistry.addShapedRecipe(new ItemStack(item_NightvisionGoggles), new Object[] {"-s-", "eie", "-d-", 's', new ItemStack(Items.potionitem, 1, Potion.nightVision.id), 'e', new ItemStack(Blocks.glass_pane, 1, 0), 'i', new ItemStack(Items.iron_ingot, 1, 0), 'd', new ItemStack(Items.dye, 1, 2)});

		GameRegistry.addShapedRecipe(new ItemStack(item_Glowsole), new Object[] {"ggg", "ala", "ggg", 'g', new ItemStack(Blocks.glowstone, 1, 0), 'a', new ItemStack(Items.glowstone_dust, 1, 0), 'l', TConstructRegistry.getItemStack("lavaCrystal")});
		GameRegistry.addShapedRecipe(new ItemStack(item_Glowsole), new Object[] {"gag", "glg", "gag", 'g', new ItemStack(Blocks.glowstone, 1, 0), 'a', new ItemStack(Items.glowstone_dust, 1, 0), 'l', TConstructRegistry.getItemStack("lavaCrystal")});
		GameRegistry.addShapedRecipe(new ItemStack(item_Feathersole), new Object[] {"fgf", 'g', new ItemStack(Items.gold_nugget, 1, 0), 'f', new ItemStack(Items.feather, 1, 0)});
		GameRegistry.addShapedRecipe(new ItemStack(item_Firesole), new Object[] {"lol", "oao", "lol", 'o', new ItemStack(Blocks.obsidian, 1, 0), 'a', TConstructRegistry.getItemStack("ingotArdite"), 'l', TConstructRegistry.getItemStack("lavaCrystal")});
		GameRegistry.addShapedRecipe(new ItemStack(item_Icesole), new Object[] {"ili", "lcl", "ili", 'l', new ItemStack(Blocks.lapis_block, 1, 0), 'i', new ItemStack(Blocks.ice, 1, 0), 'c', TConstructRegistry.getItemStack("ingotCobalt")});
		GameRegistry.addShapedRecipe(new ItemStack(item_Flippers), new Object[] {"-b-", "rlr", "-s-", 'b', new ItemStack(Items.leather_boots, 1, 0), 'l', new ItemStack(Items.leather, 1, 0), 'r', new ItemStack(TinkerTools.toolRod, 1, 2), 's', new ItemStack(Items.slime_ball, 1, 0)});

		if(TDIntegration.thaumcraft)
		{
			tcmods.RegisterRecipes();
		}
	}

	public void RegisterModifiers()
	{
		//Head only
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Rebreather, 1, 0)}, TinkersDefense.config.ArmorRebreatherID, "Rebreather", EnumChatFormatting.GOLD.toString(), "Rebreather", new String[] {"head"}, 1, null));
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_NightvisionGoggles, 1, 0)}, TinkersDefense.config.ArmorNightvisionID, "Nightvision", EnumChatFormatting.GREEN.toString(), "Nightvision", new String[] {"head"}, 1, null));
		ModifyBuilder.registerModifier(new modifierIntExclusive(new ItemStack[] {new ItemStack(Items.ghast_tear, 1, 0)}, TinkersDefense.config.ArmorAntiBlindnessID, "AntiBlindness", 1, EnumChatFormatting.AQUA.toString(), "AntiBlindness", new String[] {"head"}, 1, null));
		//ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(Blocks.pumpkin, 1, 0)}, TinkersDefense.config.ArmorPumpkinID, "Pumpkin", EnumChatFormatting.GOLD.toString(), "Pumpkin", new String[] {"head"}, 1, null));

		//Legs only
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(Blocks.sticky_piston, 1, 0)}, TinkersDefense.config.ArmorHighstepID, "Highstep", EnumChatFormatting.LIGHT_PURPLE.toString(), "Highstep", new String[] {"pants"}, 1, null));
		ModifyBuilder.registerModifier(new modifierIntExclusive(new ItemStack[] {new ItemStack(Blocks.redstone_block, 1, 0)}, TinkersDefense.config.ArmorSpeedID, "Speed", 1, EnumChatFormatting.DARK_RED.toString(), "Haste", new String[] {"pants"}, 1, null));
		ModifyBuilder.registerModifier(new modifierIntExclusive(new ItemStack[] {new ItemStack(Blocks.piston, 1, 0)}, TinkersDefense.config.ArmorJumpboostID, "Jump", 1, EnumChatFormatting.WHITE.toString(), "Jump Boost", new String[] {"pants"}, 1, null));

		//Excluding Cloth
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(TinkersDefense.partArmorplate, 1, 2)}, TinkersDefense.config.ArmorProtectionID, 1, EnumChatFormatting.DARK_GRAY.toString(), "Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(Items.magma_cream, 1)}, TinkersDefense.config.ArmorFireProtectionID, 1, EnumChatFormatting.RED.toString(), "Fire Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(Blocks.wool, 1)}, TinkersDefense.config.ArmorBlastProtectionID, 1, EnumChatFormatting.DARK_GREEN.toString(), "Blast Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(TinkersDefense.partRivet, 1, 2)}, TinkersDefense.config.ArmorProjectileProtectionID, 1, EnumChatFormatting.GRAY.toString(), "Projectile Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(item_Feathersole, 1, 0)}, TinkersDefense.config.ArmorFeatherfallID, 1, EnumChatFormatting.WHITE.toString(), "Featherfall"));
		ModifyBuilder.registerModifier(new modifierIntExclusive(new ItemStack[] {TConstructRegistry.getItemStack("canisterRedHeart")}, TinkersDefense.config.ArmorAbsorptionID, "HealthBoost", 1, EnumChatFormatting.DARK_RED.toString(), "HealthBoost", new String[] {"heavy", "light"}, 1, null));

		//Feet only
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Glowsole, 1, 0)}, TinkersDefense.config.ArmorGlowstepID, "GlowStep", EnumChatFormatting.YELLOW.toString(), "GlowStep", new String[] {"feet"}, 1, null));
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Firesole, 1, 0)}, TinkersDefense.config.ArmorFirewalkerID, "Firewalker", EnumChatFormatting.RED.toString(), "Firewalker", new String[] {"feet"}, 1, new String[] {"Frostwalker"}));
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Icesole, 1, 0)}, TinkersDefense.config.ArmorFrostwalkerID, "Frostwalker", EnumChatFormatting.BLUE.toString(), "Frostwalker", new String[] {"feet"}, 1, new String[] {"Firewalker"}));
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Flippers, 1, 0)}, TinkersDefense.config.ArmorDepthstriderID, "Depthstrider", EnumChatFormatting.DARK_BLUE.toString(), "Depthstrider", new String[] {"feet"}, 1, new String[] {"Frostwalker", "Firewalker"}));

		for(ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorRebreatherID, "tinker", "rebreather", true);

			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorProtectionID, "tinker", "protection", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorFireProtectionID, "tinker", "fireprotection", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorBlastProtectionID, "tinker", "blastprotection", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorProjectileProtectionID, "tinker", "projprotection", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorFeatherfallID, "tinker", "featherfall", true);

			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorGlowstepID, "tinker", "glowstep", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorFirewalkerID, "tinker", "firewalk", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorFrostwalkerID, "tinker", "frostwalk", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorDepthstriderID, "tinker", "depthstrider", true);

		}

		if(TDIntegration.thaumcraft)
		{
			tcmods.RegisterModifiers();
		}
	}

	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(!world.isRemote)
		{
			if(tags.hasKey("Frostwalker"))
				UpdateWalker(tool, stack, world, entity, Material.water, TinkersDefense.block_Unstable, 0);
			if(tags.hasKey("Firewalker"))
				UpdateWalker(tool, stack, world, entity, Material.lava, TinkersDefense.block_Unstable, 1);
			if(tags.hasKey("GlowStep"))
				UpdateGlowstep(tool, stack, world, entity);
			if(tags.hasKey("Rebreather"))
				UpdateRebreather(tool, stack, world, entity);
			if(tags.hasKey("Nightvision"))
				UpdateNightvision(tool, stack, world, entity);
			if(tags.hasKey("AntiBlindness"))
				UpdateAntiBlind(tool, stack, world, entity);
			if(tags.hasKey("HealthBoost"))
				UpdateHealthBoost(tool, stack, world, entity, tags);
			//UpdateHighstep(tool, stack, world, entity);

		}
		else
		{
			if(tags.hasKey("Depthstrider"))
				UpdateFlippers(tool, stack, world, entity);
			if(tags.hasKey("Speed"))
				UpdateSpeed(tool, stack, world, entity, tags);
//			if(tags.hasKey("Jump"))
//				UpdateJump(tool, stack, world, entity, tags);
		}

		if(TDIntegration.thaumcraft)
		{
			tcmods.UpdateAll(tool, stack, world, entity, tags);
		}
	}

	public void UpdateWalker(ToolCore tool, ItemStack stack, World world, Entity entity, Material mat, Block replacement, int meta)
	{
		int x = (int) Math.floor(entity.posX);
		int y = (int) (entity.posY - entity.getYOffset());
		int z = (int) Math.floor(entity.posZ);

		Block block;

		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
			{
				block = world.getBlock(x + (i - 2), y - 1, z + (j - 2));
				if(block instanceof BlockLiquid)
				{
					if(((BlockLiquid) block).getMaterial() == mat && world.getBlockMetadata(x + (i - 2), y - 1, z + (j - 2)) == 0)
					{
						world.setBlock(x + (i - 2), y - 1, z + (j - 2), replacement, meta, 3);
						world.notifyBlocksOfNeighborChange(x + (i - 2), y - 1, z + (j - 2), world.getBlock(x + (i - 2), y - 1, z + (j - 2)));
					}
				}
			}
	}

	int	glowTimer	= 8;
	int	prevX		= 0;
	int	prevZ		= 0;

	public void UpdateGlowstep(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		int x = (int) Math.floor(entity.posX);
		int y = (int) (entity.posY - entity.getYOffset());
		int z = (int) Math.floor(entity.posZ);

		if(glowTimer == 0)
		{
			if(world.getBlock(x, y, z) == Blocks.air && world.getBlock(x, y - 1, z).isNormalCube())
			{
				world.setBlock(x, y, z, TinkersDefense.block_GlowCrumbs, 0, 3);
				//world.notifyBlocksOfNeighborChange(x + (i - 2), y - 1, z + (j - 2), world.getBlock(x + (i - 2), y - 1, z + (j - 2)));
			}
			glowTimer = 8;
		}
		else if(Math.abs(x - prevX) >= 1 || Math.abs(z - prevZ) >= 1)
		{
			glowTimer--;
		}

		prevX = x;
		prevZ = z;
	}

	public void UpdateFlippers(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		if(entity.isInWater())
		{
			entity.motionX *= 1.2;
			entity.motionY *= 1.2;
			entity.motionZ *= 1.2;
		}
	}

	public void UpdateRebreather(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		EntityPlayer player = (EntityPlayer) entity;
		if(player.getAir() <= 0)
		{
			if(player.inventory.hasItem(item_Canister))
			{
				player.inventory.consumeInventoryItem(item_Canister);
				player.inventory.addItemStackToInventory(new ItemStack(item_Emptycanister, 1, 0));
				player.setAir(150);
			}
			if(player.inventory.hasItem(item_Canister))
			{
				player.inventory.consumeInventoryItem(item_Canister);
				player.inventory.addItemStackToInventory(new ItemStack(item_Emptycanister, 1, 0));
				player.setAir(300);
			}
		}
	}

	public void UpdateNightvision(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		if(!((EntityPlayer) entity).isPotionActive(Potion.nightVision) || ((EntityPlayer) entity).getActivePotionEffect(Potion.nightVision).getDuration() < 1000)
			((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.nightVision.id, 1000, 1, true));
	}

	boolean	isBlind	= false;

	public void UpdateAntiBlind(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");
		if(((EntityPlayer) entity).isPotionActive(Potion.blindness) && !isBlind)
		{
			int roll = world.rand.nextInt(100);
			int antiLevel = tags.getInteger("AntiBlindness");
			if(roll < antiLevel * 10)
			{
				((EntityPlayer) entity).removePotionEffect(Potion.blindness.id);
			}
			else
			{
				isBlind = true;
			}
		}
		if(!((EntityPlayer) entity).isPotionActive(Potion.blindness) && isBlind)
		{
			isBlind = false;
		}
	}

	public void UpdateSpeed(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		EntityPlayer ent = (EntityPlayer) entity;
		if(!entity.isInWater() && !ent.isSneaking() && ent.moveForward > 0.0)
		{
			float speed = (float) (tags.getInteger("Speed") * 0.05);
			if(entity.onGround)
			{
				ent.moveFlying(0.0f, 1.0f, speed);
			}
			else
			{
				ent.jumpMovementFactor = speed;
			}
		}
	}
	
	PotionEffect hb;
	public void UpdateHealthBoost(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(!((EntityPlayer) entity).isPotionActive(21))
			((EntityPlayer) entity).addPotionEffect(new PotionEffect(21, 100, tags.getInteger("HealthBoost")-1, true));
		else if (((EntityPlayer) entity).getActivePotionEffect(Potion.potionTypes[21]).getDuration() < 10)
			((EntityPlayer) entity).getActivePotionEffect(Potion.potionTypes[21]).combine(new PotionEffect(21, 100, tags.getInteger("HealthBoost")-1, true));
	}

//	public void UpdateJump(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
//	{
//		EntityPlayer ent = (EntityPlayer) entity;
//		if(!entity.isInWater() && !ent.isSneaking() && ent.motionY > 0.0)
//		{
//			float speed = (float) (tags.getInteger("Jump") * 0.15);
//
//			ent.jumpMovementFactor = speed;
//
//		}
//	}

	@SubscribeEvent
	public void Jump(LivingJumpEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			if(player.getCurrentArmor(1) != null)
			{
				ItemStack legs = player.getCurrentArmor(1);
				Item armor = legs.getItem();
				NBTTagCompound tags = legs.getTagCompound().getCompoundTag("InfiTool");
				
				if((armor instanceof TinkersRobe || armor instanceof TinkersChausses || armor instanceof TinkersGrieves) && tags.hasKey("Jump"))
				{
					double speed = tags.getInteger("Jump") * 0.1;
					player.setVelocity(0, 0.4 + speed, 0);
					player.velocityChanged = true;
				}
			}
		}
	}

	@SubscribeEvent
	public void Highstep(TickEvent.PlayerTickEvent event)
	{
		event.player.stepHeight = 0.5f;
		if(event.player.getCurrentArmor(1) != null)
		{
			ItemStack legs = event.player.getCurrentArmor(1);
			Item armor = legs.getItem();
			NBTTagCompound tags = legs.getTagCompound().getCompoundTag("InfiTool");

			if((armor instanceof TinkersRobe || armor instanceof TinkersChausses || armor instanceof TinkersGrieves) && tags.hasKey("Highstep") && !event.player.isSneaking())
			{
				event.player.stepHeight = 1.0f;
			}
		}
	}
	//	public void UpdateHighstep(ToolCore tool, ItemStack stack, World world, Entity entity)
	//	{
	//		NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");
	//		EntityPlayer ent = (EntityPlayer) entity;
	//
	//		if(tool instanceof TinkersRobe || tool instanceof TinkersChausses || tool instanceof TinkersGrieves)
	//		{
	//			ent.stepHeight = 0.5f;
	//			if(tags.hasKey("Highstep"))
	//			{
	//				if(!ent.isSneaking())
	//				{
	//					ent.stepHeight = 1f;
	//				}
	//			}
	//		}
	//
	//	}

	//	@SubscribeEvent
	//	public void CalmEndermen(LivingSetAttackTargetEvent event)
	//	{
	//		NBTTagCompound tags;
	//
	//		if(event.target instanceof EntityPlayer)
	//		{
	//			if(((EntityPlayer) event.target).getCurrentArmor(3).hasTagCompound() && ((EntityPlayer) event.target).getCurrentArmor(3).getTagCompound().hasKey("InfiTool"))
	//			{
	//				tags = ((EntityPlayer) event.target).getCurrentArmor(3).getTagCompound().getCompoundTag("InfiTool");
	//
	//				if(event.entityLiving instanceof EntityEnderman && tags.hasKey("Pumpkin"))
	//				{
	//					event.entityLiving.setRevengeTarget(null);
	//				}
	//			}
	//		}
	//	}
}
