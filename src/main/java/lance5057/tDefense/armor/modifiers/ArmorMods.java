package lance5057.tDefense.armor.modifiers;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TDIntegration;
import lance5057.tDefense.TinkersDefense;
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
import net.minecraft.world.World;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.common.registry.GameRegistry;

public class ArmorMods
{
	ThaumArmorMods	tcmods;

	Item			item_Canister;
	Item			item_Emptycanister;
	Item			item_Rebreather;

	Item			item_Glowsole;
	Item			item_Firesole;
	Item			item_Icesole;
	Item			item_Feathersole;
	Item			item_Flippers;
	
	public ArmorMods()
	{
		LoadItems();
	}

	public void LoadItems()
	{
		item_Canister = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(10).setUnlocalizedName("FilledCart").setTextureName(Reference.MOD_ID + ":FilledCart");
		item_Emptycanister = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(10).setUnlocalizedName("EmptyCart").setTextureName(Reference.MOD_ID + ":EmptyCart");
		item_Rebreather = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("Rebreather").setTextureName(Reference.MOD_ID + ":Rebreather");

		item_Feathersole = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("FeatherSole").setTextureName(Reference.MOD_ID + ":FeatherSole");
		item_Firesole = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("FireSole").setTextureName(Reference.MOD_ID + ":FireSole");
		item_Icesole = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("IceSole").setTextureName(Reference.MOD_ID + ":IceSole");
		item_Glowsole = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("GlowSole").setTextureName(Reference.MOD_ID + ":GlowSole");
		item_Flippers = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("Flippers").setTextureName(Reference.MOD_ID + ":Flippers");

		GameRegistry.registerItem(item_Canister, "FilledCart");
		GameRegistry.registerItem(item_Emptycanister, "EmptyCart");
		GameRegistry.registerItem(item_Rebreather, "Rebreather");

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
		GameRegistry.addShapedRecipe(new ItemStack(item_Rebreather), new Object[] {"-s-", "eie", "-d-", 's', new ItemStack(Items.slime_ball, 1, 0), 'e', new ItemStack(item_Emptycanister, 1, 0), 'i', new ItemStack(TinkersDefense.partArmorplate, 1, 2), 'd', new ItemStack(Items.dye, 1, 0)});

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
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Rebreather, 1, 0)}, TinkersDefense.config.ArmorRebreatherID, "Rebreather", "\u00A76", "Rebreather", new String[] {"head"}, 1));

		//Excluding Cloth
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(TinkersDefense.partArmorplate, 1, 2)}, TinkersDefense.config.ArmorProtectionID, 1, "\u00A77", "Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(Items.magma_cream, 1)}, TinkersDefense.config.ArmorFireProtectionID, 1, "\u00A7c", "Fire Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(Blocks.wool, 1)}, TinkersDefense.config.ArmorBlastProtectionID, 1, "\u00A72", "Blast Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(TinkersDefense.partRivet, 1, 2)}, TinkersDefense.config.ArmorProjectileProtectionID, 1, "\u00A7f", "Projectile Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(item_Feathersole, 1, 0)}, TinkersDefense.config.ArmorFeatherfallID, 1, "\u00A7f", "Featherfall"));

		//Feet only
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Glowsole, 1, 0)}, TinkersDefense.config.ArmorGlowstepID, "GlowStep", "\u00A76", "GlowStep", new String[] {"feet"}, 1));
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Firesole, 1, 0)}, TinkersDefense.config.ArmorFirewalkerID, "Firewalker", "\u00A74", "Firewalker", new String[] {"feet"}, 1));
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Icesole, 1, 0)}, TinkersDefense.config.ArmorFrostwalkerID, "Frostwalker", "\u00A7b", "Frostwalker", new String[] {"feet"}, 1));
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_Flippers, 1, 0)}, TinkersDefense.config.ArmorDepthstriderID, "Depthstrider", "\u00A71", "Depthstrider", new String[] {"feet"}, 1));

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
		}
		else
		{
			if(tags.hasKey("Depthstrider"))
				UpdateFlippers(tool, stack, world, entity);
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
}
