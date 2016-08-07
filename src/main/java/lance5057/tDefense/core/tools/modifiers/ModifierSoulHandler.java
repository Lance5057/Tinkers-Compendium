package lance5057.tDefense.core.tools.modifiers;

import java.util.List;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.event.ModifyEvent;
import tconstruct.library.tools.ToolCore;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ModifierSoulHandler
{
	String	name;
	int		time			= 160;
	boolean	broken			= false;
	boolean	newlymade		= false;
	boolean	newlymodified	= false;
	boolean	onFire			= false;
	boolean	playerharmed	= false;
	boolean	playerattacked	= false;
	float	dmg				= 0;
	//boolean	playerdead		= false;
	boolean	storymode		= false;
	int		story			= 0;
	int		storyline		= 0;
	int		numofstories	= 0;

	public ModifierSoulHandler(int stories, String name)
	{
		MinecraftForge.EVENT_BUS.register(this);
		numofstories = stories;
		this.name = name;
	}

	public void Update(ItemStack tool)
	{
		final WorldClient world = Minecraft.getMinecraft().theWorld;
		final EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		final NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

		String output = "";

		if(time <= 0)
		{
			if(!tags.getBoolean("Broken"))
			{
				//player.addChatMessage(new ChatComponentText("Test"));
				final List entities = world.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX - 20, player.posY - 20, player.posZ - 20, player.posX + 20, player.posY + 20, player.posZ + 20));
				int choice = world.rand.nextInt(3);
				final float dmg = tags.getInteger("Damage");
				final float dur = tags.getInteger("TotalDurability");
				//				if(playerdead)
				//				{
				//					output += "§4(Player Death)§f ";
				//					output += talk(output, world, (ToolCore) tool.getItem(), "death");
				//					playerdead = false;
				//				}

				if(playerattacked)
				{
					output += "§7(Attacking)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "offense");
					playerattacked = false;
				}

				else if(playerharmed)
				{
					output += "§4(Player Hurt)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "defense");
					playerattacked = false;
				}

				else if(newlymade)
				{
					output += "§7(Greetings)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "creation");
					newlymade = false;
				}

				else if(newlymodified)
				{
					output += "§7(Modified)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "modified");
					newlymodified = false;
				}

				else if(onFire)
				{
					output += "§4(Player on Fire)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "onfire");
				}

				else if(player.getHealth() <= 6)
				{
					output += "§4(Player Low Health)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "lowhp");
				}

				else if(player.getFoodStats().getFoodLevel() <= 6)
				{
					output += "§4(Player Hungry)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "lowhunger");
				}

				else if((dur - dmg) / dur <= 0.1f)
				{
					output += "§4(Nearly Broken)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "lowdurability");
				}

				else if(broken)
				{
					output += "§7(Repaired)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "repaired");
				}

				//react entity
				else if(choice == 0)
				{
					if(entities.size() > 0)
					{
						final EntityLiving ent = (EntityLiving) entities.get(world.rand.nextInt(entities.size()));

						if(ent instanceof EntityCreature || ent instanceof EntityFlying || ent instanceof EntitySlime)
						{
							final boolean doGeneral = world.rand.nextBoolean();
							final boolean doInsult = world.rand.nextBoolean();
							if(!doInsult)
							{
								if(!doGeneral)
								{
									output += "§7(" + ent.getClass().getName().substring(ent.getClass().getName().lastIndexOf("Entity") + 6).toLowerCase() + " Nearby)§f ";
									output += talk(output, world, (ToolCore) tool.getItem(), ent.getClass().getName().substring(ent.getClass().getName().lastIndexOf("Entity") + 6).toLowerCase() + "near");
								}
								else
								{
									output += "§7(Creature Nearby)§f ";
									output += talk(output, world, (ToolCore) tool.getItem(), "creaturenear");
								}
							}
							else
							{
								if(!doGeneral)
								{
									output += "§7(insult" + ent.getClass().getName().substring(ent.getClass().getName().lastIndexOf("Entity") + 6).toLowerCase() + ")§f ";
									output += talk(output, world, (ToolCore) tool.getItem(), "insult" + ent.getClass().getName().substring(ent.getClass().getName().lastIndexOf("Entity") + 6).toLowerCase());
								}
								else
								{
									output += "§7(Generic Insult)§f ";
									output += talk(output, world, (ToolCore) tool.getItem(), "insultother");
								}
							}
						}

						if(output.contains("~other~"))
						{
							output = output.replace("~other~", ent.getClass().getName().substring(ent.getClass().getName().lastIndexOf("Entity") + 6));
						}
					}
				}
				//Story
				else if(choice == 1)
				{
					story = world.rand.nextInt(numofstories);
					output += story(output, world);
					storymode = true;
				}
				//General Chat
				else
				{
					choice = world.rand.nextInt(4);
					if(choice == 0)
					{
						if(tool.getItem() instanceof ArmorCore)
						{
							output += talk(output, world, (ToolCore) tool.getItem(), "armor");

						}
						else
						{
							output += talk(output, world, (ToolCore) tool.getItem(), "weapon");
						}
					}
					else
					{
						output += talk(output, world, (ToolCore) tool.getItem(), "other");
					}
				}

				if(storymode == true)
				{
					time = world.rand.nextInt(160) + 80;
				}
				else
				{
					time = world.rand.nextInt(1600) + 800;
					if(TinkersDefense.config.debug)
					{
						time = world.rand.nextInt(160) + 80;
					}
				}

			}
			else
			{
				if(broken == false)
				{
					output += "§4(Broken)§f ";
					output += talk(output, world, (ToolCore) tool.getItem(), "broken");
					broken = true;
				}
			}

			formatOutput(output, player, tool);
		}
		else
		{
			time--;
		}

	}

	String story(String output, WorldClient world)
	{
		final String line = StatCollector.translateToLocal("soul." + name + ".story." + story + "." + storyline);
		if(!line.equals("soul." + name + ".story." + story + "." + storyline))
		{
			storyline++;
			return line;
		}
		else
		{
			storymode = false;
			story = 0;
			storyline = 0;
			return "";
		}

	}

	String talk(String output, WorldClient world, ToolCore tool, String type)
	{
		final int lines = getAmountOfLines("soul." + name + "." + type + ".");
		if(lines > 0)
		{
			return StatCollector.translateToLocal("soul." + name + "." + type + "." + world.rand.nextInt(lines));
		}
		if(TinkersDefense.config.debug)
		{
			return "Error: No lines (" + type + " chat)";
		}
		return "";
	}

	int getAmountOfLines(String type)
	{
		String nextLine = "";
		int i = -1;
		do
		{
			i++;
			nextLine = StatCollector.translateToLocal(type + i);
		}
		while(!nextLine.contains(type));
		return i;
	}

	void formatOutput(String output, EntityPlayer player, ItemStack tool)
	{
		if(tool != null && output.contains("~tool~"))
		{
			output = output.replace("~tool~", ((ToolCore) tool.getItem()).getLocalizedToolName());
		}
		if(output.contains("~player~"))
		{
			output = output.replace("~player~", player.getDisplayName());
		}
		if(output.contains("~material~"))
		{
			output = output.replace("~material~", TConstructRegistry.toolMaterials.get(tool.getTagCompound().getCompoundTag("InfiTool").getInteger("Head")).localizedName());
		}

		if(output.contains("~damage~"))
		{
			output = output.replace("~damage~", Float.toString(dmg));
		}

		if(!output.isEmpty())
		{
			player.addChatMessage(new ChatComponentText(
					"[" + name + " the " + ((ToolCore) tool.getItem()).getLocalizedToolName() + "] " + output));
		}
		else
		{
			if(TinkersDefense.config.debug)
			{
				player.addChatMessage(new ChatComponentText(
						"Error: Soul missing line"));
			}
		}
	}

	@SubscribeEvent
	public void ModifySoulEvent(ModifyEvent event)
	{
		if(event.modifier.stacks != null && !event.modifier.stacks.isEmpty() && event.modifier.stacks.get(0) != null && ItemStack.areItemStacksEqual((ItemStack) event.modifier.stacks.get(0), new ItemStack(
				Modifiers.TMod.modItems, 1, 3)))
		{
			newlymade = true;

		}
		else if(event.itemStack.getTagCompound().getCompoundTag("InfiTool").hasKey("Ensouled"))
		{
			newlymodified = true;
		}

		time = 0;
	}

	@SubscribeEvent
	public void HarmedEvent(LivingHurtEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			final EntityPlayer player = (EntityPlayer) event.entityLiving;
			if(player.getUniqueID() == Minecraft.getMinecraft().thePlayer.getUniqueID())
			{
				if(event.source.isFireDamage())
				{
					onFire = true;
				}
				else
				{
					playerharmed = true;
					dmg = event.ammount;
				}
				time = 0;
			}
		}
		else if(event.source.getEntity() instanceof EntityPlayer)
		{
			final EntityPlayer player = (EntityPlayer) event.source.getEntity();
			final String p = player.getDisplayName();
			final String s = Minecraft.getMinecraft().thePlayer.getDisplayName();
			if(p == s)
			{
				playerattacked = true;
				dmg = event.ammount;
				time = 0;
			}
		}
	}
	//	@SubscribeEvent
	//	public void PlayerDeathEvent(LivingDeathEvent event)
	//	{
	//		if(event.entityLiving.worldObj.isRemote)
	//			if(event.entityLiving.isEntityEqual(Minecraft.getMinecraft().thePlayer))
	//			{
	//				String output = "";
	//				final int lines = getAmountOfLines("soul." + name + "." + "death" + ".");
	//				if(lines > 0)
	//				{
	//					output += StatCollector.translateToLocal("soul." + name + "." + "death" + "." + event.entityLiving.worldObj.rand.nextInt(lines));
	//				}
	//				else if(TinkersDefense.config.debug)
	//				{
	//					output += "Error: No lines (" + "death" + " chat)";
	//				}
	//				else
	//				{
	//					output += "";
	//				}
	//
	//				formatOutput(output, (EntityPlayer) event.entityLiving, null);
	//			}
	//	}
}
