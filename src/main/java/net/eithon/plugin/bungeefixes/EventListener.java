package net.eithon.plugin.bungeefixes;

import net.eithon.plugin.bungeefixes.logic.Controller;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class EventListener implements Listener {
	
	private Controller _controller;

    public EventListener(ProxyServer proxy, Controller controller) {
		super();
		this._controller = controller;
	}

	@EventHandler
    public void onPlayerDisconnectEvent(PlayerDisconnectEvent event) {
		this._controller.playerDisconnnected(event.getPlayer());
    }
}
