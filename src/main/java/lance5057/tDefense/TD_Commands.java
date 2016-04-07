package lance5057.tDefense;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.armor.renderers.ModelMask;
import lance5057.tDefense.armor.renderers.ModelSheath;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersHood;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersRobe;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersShawl;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersGauntlets;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersGrieves;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersHelm;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersSabatons;
import lance5057.tDefense.armor.renderers.light.ModelTinkersBoots;
import lance5057.tDefense.armor.renderers.light.ModelTinkersChausses;
import lance5057.tDefense.armor.renderers.light.ModelTinkersCoif;
import lance5057.tDefense.armor.renderers.light.ModelTinkersHalberd;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TD_Commands extends CommandBase implements ICommand
{
	private final List	aliases;
	private final List	commands;

	public TD_Commands()
	{
		aliases = new ArrayList();

		aliases.add("TinkersDefense");
		aliases.add("TDefense");
		aliases.add("TD");

		commands = new ArrayList();

		commands.add("reloadModels");
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 0;
	}

	@Override
	public int compareTo(Object arg0)
	{
		return 0;
	}

	@Override
	public String getCommandName()
	{
		return "TinkersDefense";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_)
	{
		return "TinkersDefense <text>";
	}

	@Override
	public List getCommandAliases()
	{
		return aliases;
	}

	@Override
	public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_)
	{
		World world = p_71515_1_.getEntityWorld();
		if(p_71515_2_[0].equals("reloadModels"))
		{
			p_71515_1_.addChatMessage(new ChatComponentText("§9[TDefense] - Reloading All Models..."));
			reloadModels();
		}
		else
		{
			p_71515_1_.addChatMessage(new ChatComponentText("§c[TDefense] - Invalid Command"));
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_)
	{
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_)
	{
		return commands;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_)
	{
		return false;
	}

	public void reloadModels()
	{
		ClientProxy.mask = new ModelMask(null);
		ClientProxy.sheath = new ModelSheath();

		ClientProxy.helm = new ModelTinkersHelm();
		ClientProxy.breastplate = new ModelTinkersBreastplate();
		ClientProxy.grieves = new ModelTinkersGrieves();
		ClientProxy.sabatons = new ModelTinkersSabatons();
		ClientProxy.gauntlets = new ModelTinkersGauntlets();

		ClientProxy.hood = new ModelTinkersHood();
		ClientProxy.shawl = new ModelTinkersShawl();
		ClientProxy.robe = new ModelTinkersRobe();
		ClientProxy.shoes = new ModelTinkersBoots();

		ClientProxy.coif = new ModelTinkersCoif();
		ClientProxy.halberd = new ModelTinkersHalberd();
		ClientProxy.chausses = new ModelTinkersChausses();
		ClientProxy.boots = new ModelTinkersBoots();
	}
}
