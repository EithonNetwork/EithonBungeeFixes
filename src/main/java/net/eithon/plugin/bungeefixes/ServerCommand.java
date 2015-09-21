package net.eithon.plugin.bungeefixes;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServerCommand extends Command {

	public ServerCommand() {
		super("eserver","permissions.eserver",new String[0]);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new ComponentBuilder("This command can only be run by a player!").color(ChatColor.RED).create());
			return;
		}
		
		if (args.length > 0) {
			for (String string : args) {
				ComponentBuilder cb = new ComponentBuilder(string);
				sender.sendMessage(cb.color(ChatColor.BLUE).create());
			}
		}

		ProxiedPlayer player = (ProxiedPlayer) sender;
		String serverName = "builder";
		if (playerServerHasName(player, serverName))  {
			player.sendMessage(new ComponentBuilder("You are already connected to the Hub!").color(ChatColor.RED).create());
			return;
		}
		ServerInfo target = ProxyServer.getInstance().getServerInfo("Hub");
		player.connect(target);
	}

	private boolean playerServerHasName(ProxiedPlayer player, String serverName) {
		return player.getServer().getInfo().getName().equalsIgnoreCase(serverName);
	}

}
