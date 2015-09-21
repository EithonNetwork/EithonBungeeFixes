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
		super("eserver");
		//super("eserver","permissions.eserver",new String[0]);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new ComponentBuilder("This command can only be run by a player!").color(ChatColor.RED).create());
			return;
		}
		
		// Get the server name
		if (args.length != 1) {
			sender.sendMessage(new ComponentBuilder("Usage: /eserver <server name>").color(ChatColor.RED).create());
			return;
		}
		String serverName = args[0];

		// Already connected?
		ProxiedPlayer player = (ProxiedPlayer) sender;
		if (playerServerHasName(player, serverName))  {
			sender.sendMessage(new ComponentBuilder(String.format("You are already connected to the server %s", serverName)).color(ChatColor.YELLOW).create());
			return;
		}
		
		// Find server
		ServerInfo target = ProxyServer.getInstance().getServerInfo(serverName);
		if (target == null) {
			sender.sendMessage(new ComponentBuilder(String.format("Could not find the server %s", serverName)).color(ChatColor.RED).create());
			return;			
		}
		
		// Connect player
		player.connect(target);
	}

	private boolean playerServerHasName(ProxiedPlayer player, String serverName) {
		return player.getServer().getInfo().getName().equalsIgnoreCase(serverName);
	}

}
