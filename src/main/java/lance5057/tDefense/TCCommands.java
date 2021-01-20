package lance5057.tDefense;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import lance5057.tDefense.core.library.ArmorTags;
import lance5057.tDefense.util.ArmorTagUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TCCommands extends CommandBase implements ICommand {
	private final List aliases;
	private final List commands;

	public TCCommands() {
		aliases = new ArrayList();

		aliases.add("tinkersdefense");
		aliases.add("tdefense");
		aliases.add("td");

		commands = new ArrayList();

		commands.add("reloadrenderers");
		commands.add("toggletransparency");
		commands.add("toggledebugmode");
		commands.add("visor");
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	// @Override
	// public int compareTo(Object arg0)
	// {
	// return 0;
	// }

	@Override
	public String getName() {
		return "tinkersdefense";
	}

	@Override
	public String getUsage(ICommandSender p_71518_1_) {
		return "tinkersdefense <text>";
	}

	// @Override
	// public List getCommandAliases()
	// {
	// return aliases;
	// }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] commandIn) {
		final World world = sender.getEntityWorld();
		if (world.isRemote) {
			// if(p_71515_2_[0].equals("reloadRenderers"))
			// {
			// p_71515_1_.addChatMessage(new TextComponentString(
			// "�9[TDefense]�f - Reloading All Renderers..."));
			// reloadModels();
			// }
			// else if(p_71515_2_[0].equals("toggleTransparency"))
			// {
			// TinkersDefense.config.transparency = !TinkersDefense.config.transparency;
			// if(TinkersDefense.config.transparency)
			// {
			// p_71515_1_.addChatMessage(new TextComponentString(
			// "�9[TDefense]�f - Transparency on."));
			// }
			// else
			// {
			// p_71515_1_.addChatMessage(new TextComponentString(
			// "�9[TDefense]�f - Transparency off."));
			// }
			//
			// }
			if (commandIn[0].equals("toggledebugmode")) {
				TinkersCompendium.config.debug = !TinkersCompendium.config.debug;
				if (TinkersCompendium.config.debug) {
					sender.sendMessage(new TextComponentString("[TDefense] - Debug Mode on."));
				} else {
					sender.sendMessage(new TextComponentString("[TDefense] - Debug Mode off."));
				}

			} else if (commandIn[0].equals("reloadrenderers")) {
				TinkersCompendium.proxy.reloadRenderers();
			} else if (commandIn[0].equals("visor")) {
				if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
					EntityPlayer p = (EntityPlayer) sender.getCommandSenderEntity();
					for (ItemStack s : p.getArmorInventoryList()) {
						if (s != null && s.getItem() != Items.AIR) {
							ArmorTagUtil.setVisor(s, !ArmorTagUtil.getVisor(s));
							System.out.println(ArmorTagUtil.getVisor(s));
							ArmorTagUtil.setVisorTime(s, 0.0f);
							s.serializeNBT();
							if (TinkersCompendium.config.debug) {
								if (ArmorTagUtil.getVisor(s))
									sender.sendMessage(new TextComponentString("[TDefense] - Visor closed."));
								else
									sender.sendMessage(new TextComponentString("[TDefense] - Visor opened."));
							}
						}
					}
				}
				else
					sender.sendMessage(new TextComponentString("You must wear a full set of armor to open your visor."));
			} else {
				sender.sendMessage(new TextComponentString("[TDefense] - Invalid Command"));
			}
		}
	}

	// @Override
	// public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_)
	// {
	// return true;
	// }
	//
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			@Nullable BlockPos pos) {
		return commands;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		return false;
	}

	// public void reloadModels()
	// {
	// TinkersDefense.proxy.registerRenderers();
	// }
}
