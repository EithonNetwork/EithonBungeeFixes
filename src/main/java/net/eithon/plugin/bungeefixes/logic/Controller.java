package net.eithon.plugin.bungeefixes.logic;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;

public class Controller {

	private static final String PLAYER_DISCONNECTED = "PlayerDisconnected";
	private static final String EITHON_BUNGEE_FIXES_CHANNEL = "EithonBungeeFixes";
	
	public Controller() {
		registerChannels();
	}

	public void registerChannels() {
		ProxyServer.getInstance().registerChannel(EITHON_BUNGEE_FIXES_CHANNEL);
	}

	public void playerDisconnnected(ProxiedPlayer player) {
		final String playerUuid = player.getUniqueId().toString();
		for (Server server : getServers()) {
			sendMessage(server, PLAYER_DISCONNECTED, ProxyServer.getInstance().getName(), playerUuid);
		}
	}

	private Collection<Server> getServers() {
		HashMap<String, Server> servers = new HashMap<String, Server>();
		for (ProxiedPlayer proxiedPlayer : ProxyServer.getInstance().getPlayers()) {
			Server server = proxiedPlayer.getServer();
			if (server == null) continue;
			ServerInfo info = server.getInfo();
			if (info == null) continue;
			String serverName = info.getName();
			if (servers.containsKey(serverName)) continue;
			servers.put(serverName, server);
		}
		return servers.values();
	}

	public static void sendMessage(Server server, String... message) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream o = new DataOutputStream(b);

		try {
			for(String m : message) {
				o.writeUTF(m);
			}
		}
		catch(IOException ignored) {}

		server.sendData(EITHON_BUNGEE_FIXES_CHANNEL, b.toByteArray());
	}
}
