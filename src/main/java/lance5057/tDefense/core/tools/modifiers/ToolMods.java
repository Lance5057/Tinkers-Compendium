package lance5057.tDefense.core.tools.modifiers;

import java.util.ArrayList;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.modifiers.modifierBoolExclusive;
import lance5057.tDefense.armor.modifiers.modifierIntExclusive;
import lance5057.tDefense.core.tools.modifiers.ActiveToolMods.TDefenseActiveToolMod;
import lance5057.tDefense.core.tools.modifiers.TDefense.modifierSoulBound;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofBlades;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofFeathers;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofLegends;
import lance5057.tDefense.core.tools.modifiers.TDefense.shields.modifierCrestofMirrors;
import lance5057.tDefense.core.tools.modifiers.TDefense.weapons.modifierDaze;
import mods.battlegear2.api.core.IBattlePlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ToolMods
{
	public static Item	item_relic;
	public static Item	itemSoulChain;

	public static Item	item_RainbowGem;
	public static Item	item_Textbook;

	public ToolMods()
	{
		MinecraftForge.EVENT_BUS.register(this);
		
		LoadItems();
	}

	public void LoadItems()
	{
		item_relic = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("AncientRelic").setTextureName(Reference.MOD_ID + ":AncientRelic");

		itemSoulChain = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("SoulChain").setTextureName(Reference.MOD_ID + ":SoulChain");

		item_Textbook = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("Textbook").setTextureName(Reference.MOD_ID + ":Textbook");

		//Shears
		item_RainbowGem = new Item().setCreativeTab(TinkersDefense.tabName).setMaxStackSize(1).setUnlocalizedName("RainbowGem").setTextureName(Reference.MOD_ID + ":RainbowGem");

		GameRegistry.registerItem(item_relic, "AncientRelic");
		GameRegistry.registerItem(itemSoulChain, "SoulChain");
		GameRegistry.registerItem(item_RainbowGem, "RainbowGem");
		GameRegistry.registerItem(item_Textbook, "Textbook");
	}

	public void RegisterRecipes()
	{
	}

	public void RegisterModifiers()
	{
		//All
		ModifyBuilder.registerModifier(new modifierSoulBound(new ItemStack[] {new ItemStack(itemSoulChain)}, TinkersDefense.config.SoulBoundID, "Soulbound", "\u00A7b", "Soulbound"));

		//Weapons
		//TO-DO
		ModifyBuilder.registerModifier(new modifierDaze("Daze", TinkersDefense.config.DazeID, new ItemStack[] {new ItemStack(Blocks.light_weighted_pressure_plate), new ItemStack(Items.potionitem, 1, 8202)}, new int[] {1, 0}));
		ModifyBuilder.registerModifier(new modifierIntExclusive(new ItemStack[] {new ItemStack(item_Textbook, 1, 0)}, TinkersDefense.config.XPBoostID, "XPBoost", 1, EnumChatFormatting.GREEN.toString(), "XP Boost", new String[] {"weapon"}, 1, null));

		//Shears
		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_RainbowGem, 1, 0)}, TinkersDefense.config.RainbowID, "Rainbow", EnumChatFormatting.WHITE.toString(), "Rainbow", new String[] {"shears"}, 1, null));

		//Shields
		ModifyBuilder.registerModifier(new modifierCrestofFeathers("Crest of Feathers", TinkersDefense.config.CrestFeathersID, new ItemStack[] {new ItemStack(Items.feather)}, new int[] {1}));
		ModifyBuilder.registerModifier(new modifierCrestofMirrors("Crest of Mirrors", TinkersDefense.config.CrestMirrorsID, new ItemStack[] {new ItemStack(Blocks.glass_pane)}, new int[] {1}));
		ModifyBuilder.registerModifier(new modifierCrestofLegends("Crest of Legends", TinkersDefense.config.CrestLegendsID, new ItemStack[] {new ItemStack(item_relic)}, new int[] {1}));
		ModifyBuilder.registerModifier(new modifierCrestofBlades("Crest of Blades", TinkersDefense.config.CrestBladesID, new ItemStack[] {new ItemStack(Items.iron_sword)}, new int[] {1}));

		ModifyBuilder.registerModifier(new modifierBoolExclusive(new ItemStack[] {new ItemStack(item_RainbowGem, 1, 0)}, TinkersDefense.config.RainbowID, "Rainbow", EnumChatFormatting.WHITE.toString(), "Rainbow", new String[] {"shears"}, 1, null));

		TConstructRegistry.registerActiveToolMod(new TDefenseActiveToolMod());

		for(ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.DazeID, "tinker", "daze", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestFeathersID, "tinker", "feathers", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestMirrorsID, "tinker", "mirrors", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestLegendsID, "tinker", "legends", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.CrestBladesID, "tinker", "blades", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.SoulBoundID, "tinker", "soulbound", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.RainbowID, "tinker", "rainbow", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.XPBoostID, "tinker", "textbook", true);

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

	@SubscribeEvent
	public void XPBoost(LivingDeathEvent event)
	{
		if(!(event.entityLiving instanceof EntityPlayer) && event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			ItemStack itemstack = player.getCurrentEquippedItem();
			if(itemstack != null)
			{
				NBTTagCompound tags = itemstack.getTagCompound().getCompoundTag("InfiTool");

				if(tags != null && tags.hasKey("XPBoost"))
				{
					player.worldObj.spawnEntityInWorld(new EntityXPOrb(player.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, (int)Math.pow(tags.getInteger("XPBoost"),2)));

				}
			}
		}
	}
}
