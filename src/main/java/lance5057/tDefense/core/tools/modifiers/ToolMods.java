package lance5057.tDefense.core.tools.modifiers;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.tools.modifiers.ActiveToolMods.TDefenseActiveToolMod;
import lance5057.tDefense.core.tools.modifiers.Botania.modifierCorpseIvy;
import lance5057.tDefense.core.tools.modifiers.TDefense.modifierSoulBound;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofBlades;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofFeathers;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofLegends;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofMirrors;
import lance5057.tDefense.core.tools.modifiers.TDefense.weapons.modifierDaze;
import mods.battlegear2.api.core.IBattlePlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lib.LibBlockNames;
import vazkii.botania.common.lib.LibOreDict;

public class ToolMods
{
	public static Item	item_relic;
	public static Item	itemSoulChain;

	public ToolMods()
	{
		LoadItems();
	}

	public void LoadItems()
	{
		item_relic = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("AncientRelic").setTextureName(Reference.MOD_ID + ":AncientRelic");

		itemSoulChain = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("SoulChain").setTextureName(Reference.MOD_ID + ":SoulChain");

		GameRegistry.registerItem(item_relic, "Ancient Relic");
		GameRegistry.registerItem(itemSoulChain, "Soul Chain");
	}

	public void RegisterRecipes()
	{
	}

	public void RegisterModifiers()
	{
		ModifyBuilder.registerModifier(new modifierDaze("Daze", TinkersDefense.config.DazeID, new ItemStack[] {new ItemStack(Blocks.light_weighted_pressure_plate), new ItemStack(Items.potionitem, 1, 8202)}, new int[] {1, 0}));

		//ModifyBuilder.registerModifier(new modifierTorchArrow(new ItemStack[] {new ItemStack(Blocks.glowstone)}, 12));

		ModifyBuilder.registerModifier(new modifierCrestofFeathers("Crest of Feathers", TinkersDefense.config.CrestFeathersID, new ItemStack[] {new ItemStack(Items.feather)}, new int[] {1}));

		ModifyBuilder.registerModifier(new modifierCrestofMirrors("Crest of Mirrors", TinkersDefense.config.CrestMirrorsID, new ItemStack[] {new ItemStack(Blocks.glass_pane)}, new int[] {1}));

		ModifyBuilder.registerModifier(new modifierCrestofLegends("Crest of Legends", TinkersDefense.config.CrestLegendsID, new ItemStack[] {new ItemStack(item_relic)}, new int[] {1}));

		ModifyBuilder.registerModifier(new modifierCrestofBlades("Crest of Blades", TinkersDefense.config.CrestBladesID, new ItemStack[] {new ItemStack(Items.iron_sword)}, new int[] {1}));

		ModifyBuilder.registerModifier(new modifierSoulBound(new ItemStack[] {new ItemStack(itemSoulChain)}, TinkersDefense.config.SoulBoundID, "Soulbound", "\u00A7b", "Soulbound"));

		TConstructRegistry.registerActiveToolMod(new TDefenseActiveToolMod());

		for(ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.DazeID, "tinker", "daze", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestFeathersID, "tinker", "feathers", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestMirrorsID, "tinker", "mirrors", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestLegendsID, "tinker", "legends", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestBladesID, "tinker", "blades", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.SoulBoundID, "tinker", "soulbound", true);
		}
	}

	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(tags.hasKey("Crest of Mirrors"))
			UpdateMirrors(tool, stack, world, entity);
	}

	public void UpdateMirrors(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		if(((IBattlePlayer) entity).isBlockingWithShield())
		{
			AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(((EntityLivingBase) entity).posX - 3, ((EntityLivingBase) entity).posY - 3, ((EntityLivingBase) entity).posZ - 3, ((EntityLivingBase) entity).posX + 3, ((EntityLivingBase) entity).posY + 3, ((EntityLivingBase) entity).posZ + 3);

			ArrayList<EntityFireball> fireballs = (ArrayList<EntityFireball>) world.getEntitiesWithinAABB(EntityFireball.class, boundingBox);
			for(EntityFireball fireball : fireballs)
			{
				if(fireball.getDistanceSqToEntity(((EntityLivingBase) entity)) <= 25)
				{
					Vec3 playerlook = ((EntityLivingBase) entity).getLookVec();

					fireball.motionX = playerlook.xCoord;
					fireball.motionY = playerlook.yCoord;
					fireball.motionZ = playerlook.zCoord;
					fireball.accelerationX = fireball.motionX * 0.1D;
					fireball.accelerationY = fireball.motionY * 0.1D;
					fireball.accelerationZ = fireball.motionZ * 0.1D;

					fireball.shootingEntity = ((EntityLivingBase) entity);

					((EntityLivingBase) entity).worldObj.playSoundAtEntity(((EntityLivingBase) entity), "battlegear2:shield", 1, 1);
				}
			}
		}
	}

	public void UpdateTorchArrow(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		//entity.worldObj.ent
	}
}
